package com.muelpatmore.week2assignmentredux;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager mFragmentManager;
    private NavigationFragment mNavigationFragment;
    private TrackListFragment mTrackListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .add(R.id.flNavigation, mNavigationFragment);
        mFragmentManager.beginTransaction()
                .add(R.id.flContent, mTrackListFragment);
    }
}
