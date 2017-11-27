package com.muelpatmore.week2assignmentredux.ui.tracklist;

import com.muelpatmore.week2assignmentredux.data.ISong;
import com.muelpatmore.week2assignmentredux.ui.base.MvpView;

import java.util.ArrayList;

/**
 * Created by Sam on 25/11/2017.
 */

public interface TrackListMvpView extends MvpView {
    public void onFetchDataSuccess(ArrayList<ISong> mSongList);
    public void refreshRecyclerView();
}
