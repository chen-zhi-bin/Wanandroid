package com.program.wanandroiddemo.presenter.utils;

import com.program.wanandroiddemo.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class GetCollectionIds {

    private List<Integer> mIds;

    public void setIds(List<Integer> ids) {
        mIds=new ArrayList<>();
        this.mIds.addAll(ids);
        LogUtils.d(GetCollectionIds.this,"ids ="+mIds);
        LogUtils.d(GetCollectionIds.this,"ids ="+ids);
    }

    public List<Integer> getIds() {
        return mIds;
    }

    @Override
    public String toString() {
        return "GetCollectionIds{" +
                "mIds=" + mIds +
                '}';
    }
}
