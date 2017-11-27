package com.muelpatmore.week2assignmentredux.data.realm;

import com.muelpatmore.week2assignmentredux.data.ISong;
import com.muelpatmore.week2assignmentredux.data.network.models.SongModel;
import com.muelpatmore.week2assignmentredux.data.RealmSong;

import java.util.ArrayList;

/**
 * Created by Samuel on 26/11/2017.
 *
 * Utility class for converting API GSON data into Realm database objects.
 */
public class RealmAdapter {
    /**
     * Converter for API data to RealmSong, including genre field.
     * @param apiSong SongModel object of converted JSON API data.
     * @param genre Genre of the song, used for internal filing only.
     * @return RealmSong object encapsulating song data.
     */
    public static RealmSong apiDataToRealmObject(SongModel apiSong, String genre) {
        RealmSong realmSong = new RealmSong();

        realmSong.setTrackId(apiSong.getTrackId());
        realmSong.setTrackName(apiSong.getTrackName());
        realmSong.setArtistName(apiSong.getArtistName());
        realmSong.setCollectionId(apiSong.getCollectionId());
        realmSong.setGenre(genre);
        realmSong.setArtworkUrl60(apiSong.getArtworkUrl60());
        realmSong.setPreviewUrl(apiSong.getPreviewUrl());
        realmSong.setTrackTimeMillis(apiSong.getTrackTimeMillis());
        realmSong.setTrackPrice(apiSong.getTrackPrice());
        realmSong.setCurrency(apiSong.getCurrency());

        return realmSong;
    }

    /**
     * Converter for API data to RealmSong.
     * @param apiSong SongModel object of converted JSON API data.
     * @return RealmSong object encapsulating song data.
     */
    public static RealmSong apiDataToRealmObject(SongModel apiSong) {
        RealmSong realmSong = apiDataToRealmObject(apiSong, null);
        return realmSong;
    }

    public static ArrayList<RealmSong> apiDataListToRealmObject(ArrayList<SongModel> apiSongList, String genre) {
        ArrayList<RealmSong> realmSongList = new ArrayList<>();
        for (SongModel s : apiSongList) {
            realmSongList.add(apiDataToRealmObject(s, genre));
        }
        return realmSongList;
    }

    public static ArrayList<RealmSong> apiDataListToRealmObject(ArrayList<SongModel> apiSongList) {
        return apiDataListToRealmObject(apiSongList, null);
    }


    /**
     * Prevents instantiation of this utility class.
     */
    private RealmAdapter() {}
}