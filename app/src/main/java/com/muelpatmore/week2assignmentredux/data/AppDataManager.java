package com.muelpatmore.week2assignmentredux.data;



import android.util.Log;
import android.widget.Toast;

import com.muelpatmore.week2assignmentredux.MyMusicApp;
import com.muelpatmore.week2assignmentredux.data.messages.APIDataReady;
import com.muelpatmore.week2assignmentredux.data.network.AppAPIHelper;
import com.muelpatmore.week2assignmentredux.data.network.models.MusicResultsModel;
import com.muelpatmore.week2assignmentredux.data.network.models.SongModel;
import com.muelpatmore.week2assignmentredux.data.network.services.ConnectionService;
import com.muelpatmore.week2assignmentredux.data.realm.IRealmHelper;
import com.muelpatmore.week2assignmentredux.data.realm.RealmAdapter;
import com.muelpatmore.week2assignmentredux.ui.utils.AppConstants;
import com.muelpatmore.week2assignmentredux.ui.utils.rx.AppSchedulerProvider;
import com.muelpatmore.week2assignmentredux.ui.utils.rx.SchedulerProvider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Sam on 25/11/2017.
 */

public class AppDataManager implements IDataManager, IRealmHelper {

    private static final String TAG = AppDataManager.class.getSimpleName();

    private AppAPIHelper apiHelper;
    private IRealmHelper realmHelper;
    private CompositeDisposable compositeDisposable;
    private SchedulerProvider scheduler;
    private boolean currentAPIRquest = false;

    public AppDataManager() {
        realmHelper = new AppDataManager();
        apiHelper = new AppAPIHelper();
        compositeDisposable = new CompositeDisposable();
        scheduler = new AppSchedulerProvider();
    }

    @Override
    public long getLastUpdate(String genre) {
        return 0;
    }

    @Override
    public void saveSongList(ArrayList<RealmSong> realmSongList, String genre) {

    }

    public void getData(String genre) {
        if( !currentAPIRquest) {
            getAPIData(genre);
        } else {
            Toast.makeText(MyMusicApp.getContext(), "Too many requests.", Toast.LENGTH_SHORT).show();
        }
    }

    private void getAPIData(String genre) {
        currentAPIRquest= true;
        switch (genre) {
            case AppConstants.CLASSIC :
                compositeDisposable.add(
                        getClassicList()
                        .observeOn(scheduler.ui())
                        .subscribeOn(scheduler.io())
                        .subscribe(new Consumer<MusicResultsModel>() {
                            @Override
                            public void accept(MusicResultsModel musicResultsModel) throws Exception {
                                ArrayList<RealmSong> songList =
                                        RealmAdapter.apiDataListToRealmObject(
                                                new ArrayList<>(musicResultsModel.getResults()), genre);
                                currentAPIRquest= false;
                                //realmHelper.saveSongList(songList, genre);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        })
                );
        }
    }



    @Override
    public ArrayList<RealmSong> getSongList(String genre) {
        return null;
    }

    @Override
    public Observable<MusicResultsModel> getClassicList() {
        return apiHelper.getClassicList();
    }

    @Override
    public Observable<MusicResultsModel> getRockList() {
        return null;
    }

    @Override
    public Observable<MusicResultsModel> getPopList() {
        return null;
    }

}
