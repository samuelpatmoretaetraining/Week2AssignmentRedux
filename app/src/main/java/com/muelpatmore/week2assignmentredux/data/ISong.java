package com.muelpatmore.week2assignmentredux.data;

/**
 * Created by Samuel on 26/11/2017.
 */

public interface ISong {
    public Integer getTrackId();
    public void setTrackId(Integer trackId);
    public String getTrackName();
    public void setTrackName(String trackName);
    public String getArtistName();
    public void setArtistName(String artistName);
    public Integer getCollectionId();
    public void setCollectionId(Integer collectionId);
    public String getGenre();
    public void setGenre(String genre);
    public String getArtworkUrl60();
    public void setArtworkUrl60(String artworkUrl60);
    public Integer getTrackTimeMillis();
    public void setPreviewUrl(String previewUrl);
    public String getPreviewUrl();
    public void setTrackTimeMillis(Integer trackTimeMillis);
    public Double getTrackPrice();
    public void setTrackPrice(Double trackPrice);
    public String getCurrency();
    public void setCurrency(String currency);
}
