package com.muelpatmore.week2assignmentredux;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.muelpatmore.week2assignmentredux.ui.tracklist.TrackListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager mFragmentManager;
    private NavigationFragment mNavigationFragment;
    private TrackListView mTrackListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationFragment = new NavigationFragment();
        mTrackListView = new TrackListView();

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .add(R.id.flNavigation, mNavigationFragment)
                .commit();
        mFragmentManager.beginTransaction()
                .add(R.id.flContent, mTrackListView)
                .commit();
    }


}
