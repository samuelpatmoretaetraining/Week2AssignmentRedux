package com.muelpatmore.week2assignmentredux.data.realm;

import com.muelpatmore.week2assignmentredux.data.RealmSong;

import java.util.ArrayList;

/**
 * Created by Samuel on 26/11/2017.
 */

public interface IRealmHelper {
    public long getLastUpdate(String genre);
    public void saveSongList(ArrayList<RealmSong> realmSongList, String genre);
    public ArrayList<RealmSong> getSongList(String genre);
}
