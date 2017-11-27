package com.muelpatmore.week2assignmentredux;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.muelpatmore.week2assignmentredux.data.messages.ChangeGenre;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager mFragmentManager;
    private NavigationFragment mNavigationFragment;
    private TrackListFragment mTrackListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationFragment = new NavigationFragment();
        mTrackListFragment = new TrackListFragment();

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .add(R.id.flNavigation, mNavigationFragment)
                .commit();
        mFragmentManager.beginTransaction()
                .add(R.id.flContent, mTrackListFragment)
                .commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(
            ChangeGenre event) {/* Do something */};

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
