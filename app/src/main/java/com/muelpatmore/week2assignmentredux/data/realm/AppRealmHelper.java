package com.muelpatmore.week2assignmentredux.data.realm;

import android.util.Log;

import com.muelpatmore.week2assignmentredux.MyMusicApp;
import com.muelpatmore.week2assignmentredux.data.RealmSong;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

/**
 * Created by Samuel on 26/11/2017.
 */

public class AppRealmHelper implements IRealmHelper {

    // Class TAG for log messages
    private final static String TAG = "RealmController";
    private final static String CLASSIC = "classic";
    private final static String ROCK = "rock";
    private final static String POP = "pop";


    private Realm mRealm; //

    /**
     * Constructor for AppRealmHelper
     */
    public AppRealmHelper() {
        Realm.init(MyMusicApp.getContext());
        this.mRealm = Realm.getDefaultInstance();
    }
    /**
     * Get time since last recorded upload of data to the database. Returns zero if no such data exists.
     * @param genre Genre of the music subcategory that is being queried
     * @return Time that the genre was last updated (milliseconds since January 1, 1970 UTC)
     */
    public long getLastUpdate(String genre) {
        RealmGenre realmGenre = mRealm
                .where(RealmGenre.class)
                .equalTo("genre", genre)
                .findFirst();
        if (realmGenre != null) {
            return realmGenre.getLastUpdate();
        }
        return 0;
    }

    /**
     * Store a list of songs in the database.
     * @param realmSongList ArrayList of RealmSongs.
     */
    public void saveSongList(ArrayList<RealmSong> realmSongList, String genre) {

        Log.i(TAG, realmSongList.size()+" "+genre+" songs, storing in Realm.");
        RealmGenre realmGenre = new RealmGenre();
        realmGenre.setGenre(genre);
        realmGenre.setLastUpdate(System.currentTimeMillis());

        try(Realm realmInstance = Realm.getDefaultInstance()) {
            realmInstance.executeTransaction((realm) -> realm.insertOrUpdate(realmSongList));
            realmInstance.executeTransaction((realm) -> realm.insertOrUpdate(realmGenre));
            Log.i(TAG, realmSongList.size()+" "+genre+" songs stored in Realm.");
        } catch (RealmException e){
            e.printStackTrace();
        }
    }

    public ArrayList<RealmSong> getSongList(String genre) {
        ArrayList<RealmSong> songList = new ArrayList<>();
        RealmResults<RealmSong> realmSongList = mRealm
                .where(RealmSong.class)
                .equalTo("genre", genre)
                .findAll();
//        for(RealmSong s : realmSongList) {
//            songList.add(s);
//        }
        songList.addAll(realmSongList);
        return songList;
    }
}
