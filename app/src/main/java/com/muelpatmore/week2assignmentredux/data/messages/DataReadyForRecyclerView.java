package com.muelpatmore.week2assignmentredux.data.messages;

import com.muelpatmore.week2assignmentredux.data.ISong;

import java.util.ArrayList;

/**
 * Created by Samuel on 27/11/2017.
 */

public class DataReadyForRecyclerView {
    public ArrayList<ISong> songList;
    public String genre;

    public DataReadyForRecyclerView(ArrayList<ISong> songList, String genre) {
        this.songList = songList;
        this.genre = genre;
    }
}
