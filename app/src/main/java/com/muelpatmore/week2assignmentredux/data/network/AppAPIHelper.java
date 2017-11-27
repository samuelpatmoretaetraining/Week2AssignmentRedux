package com.muelpatmore.week2assignmentredux.data.network;


import com.muelpatmore.week2assignmentredux.data.ISong;
import com.muelpatmore.week2assignmentredux.data.RealmSong;
import com.muelpatmore.week2assignmentredux.data.messages.APIDataReady;
import com.muelpatmore.week2assignmentredux.data.network.models.MusicResultsModel;
import com.muelpatmore.week2assignmentredux.data.network.models.SongModel;
import com.muelpatmore.week2assignmentredux.data.network.services.ConnectionService;
import com.muelpatmore.week2assignmentredux.data.realm.RealmAdapter;
import com.muelpatmore.week2assignmentredux.ui.utils.AppConstants;
import com.muelpatmore.week2assignmentredux.ui.utils.rx.AppSchedulerProvider;
import com.muelpatmore.week2assignmentredux.ui.utils.rx.SchedulerProvider;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Sam on 25/11/2017.
 *
 * Single resource for all API requests accessible through the APIHelper interface.
 */
public class AppAPIHelper implements APIHelper {

    private static final String TAG = APIHelper.class.getSimpleName();

    private CompositeDisposable compositeDisposable;
    private ConnectionService connectionService;
    private SchedulerProvider schedulerProvider;

    public AppAPIHelper() {
        this.connectionService = new ConnectionService();
    }



    @Override
    public Observable<MusicResultsModel> getClassicList() {
        AppSchedulerProvider scheduler = new AppSchedulerProvider();
        return ConnectionService
                .getConnection()
                .getClassicList();
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
