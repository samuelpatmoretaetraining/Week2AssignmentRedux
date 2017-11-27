package com.muelpatmore.week2assignmentredux.ui.tracklist;

import android.provider.SyncStateContract;

import com.muelpatmore.week2assignmentredux.data.AppDataManager;
import com.muelpatmore.week2assignmentredux.data.IDataManager;
import com.muelpatmore.week2assignmentredux.data.messages.DataReadyForRecyclerView;
import com.muelpatmore.week2assignmentredux.ui.base.BasePresenter;
import com.muelpatmore.week2assignmentredux.ui.base.MvpView;
import com.muelpatmore.week2assignmentredux.ui.utils.AppConstants;
import com.muelpatmore.week2assignmentredux.ui.utils.rx.SchedulerProvider;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Samuel on 27/11/2017.
 */

public class TrackListPresenter<V extends TrackListMvpView> extends BasePresenter<V>
        implements TrackListMvpPresenter<V> {

    private MvpView mvpView;
    private TrackListMvpView mTrackListMvpView;
    private String genre = AppConstants.CLASSIC;

    public TrackListPresenter(AppDataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {

    }

    public void giveView(TrackListMvpView mTrackListMvpView) {
        this.mTrackListMvpView = mTrackListMvpView;
    }

    @Override
    public void requestNewData() {
        getDataManager().getData(genre);
    }

    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DataReadyForRecyclerView event) {

    }




    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }



    @Override
    public void onDetach() {

    }

    @Override
    public boolean isViewAttached() {
        return super.isViewAttached();
    }

    @Override
    public V getMvpView() {
        return super.getMvpView();
    }

    @Override
    public void checkViewAttached() {
        super.checkViewAttached();
    }

    @Override
    public IDataManager getDataManager() {
        return super.getDataManager();
    }

    @Override
    public SchedulerProvider getSchedulerProvider() {
        return super.getSchedulerProvider();
    }

    @Override
    public CompositeDisposable getCompositeDisposable() {
        return super.getCompositeDisposable();
    }
}
