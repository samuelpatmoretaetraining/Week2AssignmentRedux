package com.muelpatmore.week2assignmentredux.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muelpatmore.week2assignmentredux.data.ISong;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Samuel on 26/11/2017.
 */

public class RealmSong extends RealmObject implements ISong {

    @PrimaryKey
    private Integer trackId;
    private String trackName;
    private String artistName;
    private Integer collectionId;
    private String genre;
    private String artworkUrl60;
    private Integer trackTimeMillis;
    private Double trackPrice;
    private String currency;

    @Override
    public Integer getTrackId() {
        return trackId;
    }

    @Override
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    @Override
    public String getTrackName() {
        return trackName;
    }

    @Override
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @Override
    public String getArtistName() {
        return artistName;
    }

    @Override
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public Integer getCollectionId() {
        return collectionId;
    }

    @Override
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    @Override
    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    @Override
    public Integer getTrackTimeMillis() {
        return trackTimeMillis;
    }

    @Override
    public void setPreviewUrl(String previewUrl) {

    }

    @Override
    public String getPreviewUrl() {
        return null;
    }

    @Override
    public void setTrackTimeMillis(Integer trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    @Override
    public Double getTrackPrice() {
        return trackPrice;
    }

    @Override
    public void setTrackPrice(Double trackPrice) {
        this.trackPrice = trackPrice;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

