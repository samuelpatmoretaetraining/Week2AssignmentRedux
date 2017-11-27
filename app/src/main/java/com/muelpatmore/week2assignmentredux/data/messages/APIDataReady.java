package com.muelpatmore.week2assignmentredux.data.messages;

import com.muelpatmore.week2assignmentredux.data.ISong;
import com.muelpatmore.week2assignmentredux.data.RealmSong;

import java.util.ArrayList;

/**
 * Created by Samuel on 27/11/2017.
 */

public class APIDataReady {
    public ArrayList<RealmSong> songList;
    public String genre;

    public APIDataReady(ArrayList<RealmSong> songList, String genre) {
        this.songList = songList;
        this.genre = genre;

    }
}
