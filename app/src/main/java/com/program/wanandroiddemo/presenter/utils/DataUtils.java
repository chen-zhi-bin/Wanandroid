package com.program.wanandroiddemo.presenter.utils;

import java.util.List;

public class DataUtils {
    private static final DataUtils ourInstance = new DataUtils();
    private final GetCollectionIds mGetCollectionIds;


    public static DataUtils getInstance(){
        return ourInstance;
    }

    public GetCollectionIds getGetCollectionIds() {
        return mGetCollectionIds;
    }

    private DataUtils(){
        mGetCollectionIds = new GetCollectionIds();
    }
}
