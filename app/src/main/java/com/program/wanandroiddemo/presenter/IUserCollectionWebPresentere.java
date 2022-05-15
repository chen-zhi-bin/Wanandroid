package com.program.wanandroiddemo.presenter;

import android.content.Context;

import com.program.wanandroiddemo.base.IBasePresenter;
import com.program.wanandroiddemo.view.IUserCollectionWebCallback;

public interface IUserCollectionWebPresentere extends IBasePresenter<IUserCollectionWebCallback> {

    void getCollectionWeb();

    /**
     * 收藏
     * @param name
     * @param link
     */
    void onCollect(String name,String link);

    /**
     * 取消收藏
     * @param id
     */
    void onUnCollect(int id);
}
