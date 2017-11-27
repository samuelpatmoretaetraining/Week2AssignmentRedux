package com.muelpatmore.week2assignmentredux.data.network;


import com.muelpatmore.week2assignmentredux.data.network.models.MusicResultsModel;

import io.reactivex.Observable;

/**
 * Created by Sam on 25/11/2017.
 *
 * Interface to API web-service request functions provided by classes that implement this interface.
 */
public interface APIHelper {
    Observable<MusicResultsModel> getClassicList();
    Observable<MusicResultsModel> getRockList();
    Observable<MusicResultsModel> getPopList();
}
