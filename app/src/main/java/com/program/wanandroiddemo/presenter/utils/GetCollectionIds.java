package com.program.wanandroiddemo.presenter.utils;

import com.program.wanandroiddemo.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class GetCollectionIds {

    private List<Integer> mIds=new ArrayList<>();;

    public void setIds(List<Integer> ids) {
        mIds.clear();
        this.mIds.addAll(ids);
        LogUtils.d(GetCollectionIds.this,"ids ="+ids);
    }

    public List<Integer> getIds() {
        return mIds;
    }

    public void setIds2Null(){
        mIds.clear();
        LogUtils.d(GetCollectionIds.this,"mids size ="+mIds.size());
    }

    @Override
    public String toString() {
        return "GetCollectionIds{" +
                "mIds=" + mIds +
                '}';
    }
}
