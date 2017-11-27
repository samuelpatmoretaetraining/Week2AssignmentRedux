package com.muelpatmore.week2assignmentredux.ui.tracklist;

import com.muelpatmore.week2assignmentredux.ui.base.MvpPresenter;
import com.muelpatmore.week2assignmentredux.ui.base.MvpView;

/**
 * Created by Sam on 25/11/2017.
 */

public interface TrackListMvpPresenter<V extends TrackListMvpView> extends MvpPresenter<V> {
    public void onViewPrepared();
    public void requestNewData();
    public void setGenre(String genre);
}
