package com.muelpatmore.week2assignmentredux.data;

import com.muelpatmore.week2assignmentredux.data.network.APIHelper;
import com.muelpatmore.week2assignmentredux.data.realm.IRealmHelper;

import java.util.ArrayList;

/**
 * Created by Sam on 25/11/2017.
 */

public interface IDataManager extends APIHelper, IRealmHelper {
    void getData(String genre);
}
