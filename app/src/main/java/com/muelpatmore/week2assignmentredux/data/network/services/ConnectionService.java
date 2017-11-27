package com.muelpatmore.week2assignmentredux.data.network.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.muelpatmore.week2assignmentredux.MyMusicApp;
import com.muelpatmore.week2assignmentredux.data.constants.API_Constants;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.File;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by kalpesh on 13/07/2017.
 *
 * API conectivity resource class making initial connection to online APIs. Allows for cached and
 * uncached connections to be established.
 */
public class ConnectionService {

    static Retrofit retrofit;
    static OkHttpClient okHttpClient;
    static RequestInterface requestInterface;

    /**
     * Opens a connection to the iTunes music catalogue API preloaded with the HTTP requests
     * spesified in the RequestInterface interface class.
     */
    public static RequestInterface getConnection(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient= new OkHttpClient.Builder().
                addInterceptor(httpLoggingInterceptor).build();

        retrofit= new Retrofit.Builder()
                .baseUrl(API_Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(RequestInterface.class);
    }

    /**
     * Opens a cached connection to the iTunes music catalogue API preloaded with the HTTP requests
     * spesified in the RequestInterface interface class.
     */
    public static RequestInterface BackendService() {

        File httpCacheDirectory = new File(MyMusicApp.getApplication().getCacheDir(),  "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(REWRITE_RESPONSE_INTERCEPTOR)
                .addInterceptor(OFFLINE_INTERCEPTOR)
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_Constants.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit.create(RequestInterface.class);
    }

    /**
     * Interceptor to cache data and maintain it for a minute.
     *
     * If the same network request is sent within a minute,
     * the response is retrieved from cache.
     */
    private static final Interceptor REWRITE_RESPONSE_INTERCEPTOR = chain -> {
        Response originalResponse = chain.proceed(chain.request());
        String cacheControl = originalResponse.header("Cache-Control");

        if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
                cacheControl.contains("must-revalidate") || cacheControl.contains("max-age=0")) {
            Log.i("Values", "REWRITE_RESPONSE_CACHE");
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 60)
                    .build();

        } else {
            Log.i("Values", "REWRITE_RESPONSE_INTERCEPTOR");
            return originalResponse;

        }
    };

    private static final Interceptor OFFLINE_INTERCEPTOR = chain -> {
        Request request = chain.request();

        if (!isOnline()) {
            Log.d(TAG, "rewriting request");

            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
            request = request.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
        return chain.proceed(request);
    };

    public static boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) MyMusicApp.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

}
