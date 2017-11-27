package com.muelpatmore.week2assignmentredux.ui.tracklist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muelpatmore.week2assignmentredux.MusicListAdapter;
import com.muelpatmore.week2assignmentredux.R;
import com.muelpatmore.week2assignmentredux.data.AppDataManager;
import com.muelpatmore.week2assignmentredux.data.ISong;
import com.muelpatmore.week2assignmentredux.ui.utils.AppConstants;
import com.muelpatmore.week2assignmentredux.ui.utils.rx.AppSchedulerProvider;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Samuel on 27/11/2017.
 */

public class TrackListView extends Fragment implements TrackListMvpView {

    private TrackListPresenter mTrackListPresenter;
    private RecyclerView mRecyclerView;

    private ArrayList<ISong> mSongList;
    private String genre = AppConstants.CLASSIC;


    public TrackListView() {
        // Required empty public constructor
        mTrackListPresenter = new TrackListPresenter(
                new AppDataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable());
        mTrackListPresenter.onAttach(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_track_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mTrackListPresenter.requestNewData();
    }

    @Override
    public void onFetchDataSuccess(ArrayList<ISong> mSongList) {
        this.mSongList = mSongList;
        refreshRecyclerView();
    }

    @Override
    public void refreshRecyclerView() {
        MusicListAdapter mAdapter = new MusicListAdapter(mSongList, 0, getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

    public void setGenre() {
        this.genre = genre;
        mTrackListPresenter.setGenre(genre);
        mTrackListPresenter.requestNewData();
    }
}
