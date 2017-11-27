package com.muelpatmore.week2assignmentredux.data.network;


import com.muelpatmore.week2assignmentredux.data.network.models.MusicResultsModel;
import com.muelpatmore.week2assignmentredux.data.network.services.ConnectionService;
import com.muelpatmore.week2assignmentredux.data.realm.AppRealmHelper;
import com.muelpatmore.week2assignmentredux.ui.utils.AppConstants;
import com.muelpatmore.week2assignmentredux.ui.utils.rx.AppSchedulerProvider;
import com.muelpatmore.week2assignmentredux.ui.utils.rx.SchedulerProvider;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Sam on 25/11/2017.
 *
 * Single resource for all API requests accessible through the APIHelper interface.
 */
public class AppAPIHelper implements APIHelper {

    private static final String TAG = APIHelper.class.getSimpleName();

    private CompositeDisposable compositeDisposable;
    private ConnectionService connectionService;
    private SchedulerProvider scheduler;
    private AppRealmHelper realmHelper;

    public AppAPIHelper() {
        this.connectionService = new ConnectionService();
        this.scheduler = new AppSchedulerProvider();
        this.realmHelper = new AppRealmHelper();
    }

    public void requestApiData(String genre) {
        switch (genre) {
            case AppConstants.CLASSIC :
                getClassicListFromAPI(genre);
        }
    }

    private void getClassicListFromAPI(String genre) {
//        compositeDisposable.add(
//                getClassicList()
//                        .observeOn(scheduler.ui())
//                        .subscribeOn(scheduler.io())
//                        .subscribe(new Consumer<MusicResultsModel>() {
//                            @Override
//                            public void accept(MusicResultsModel musicResultsModel) throws Exception {
//                                ArrayList<RealmSong> songList =
//                                        RealmAdapter.apiDataListToRealmObject(
//                                                new ArrayList<>(musicResultsModel.getResults()), genre);
//                                Log.e(TAG, songList.size()+" songs read in.");
//                                //realmHelper.saveSongList(songList, genre);
//                            }
//                        }, new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception {
//
//                            }
//                        })
//        );
    }

    @Override
    public Observable<MusicResultsModel> getClassicList() {
       return null;
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
