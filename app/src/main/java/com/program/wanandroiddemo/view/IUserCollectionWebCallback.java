package com.program.wanandroiddemo.view;

import com.program.wanandroiddemo.base.IBaseCallback;
import com.program.wanandroiddemo.model.domain.CollectionWebsite;

public interface IUserCollectionWebCallback extends IBaseCallback {
    /**
     * get收藏网站列表
     * @param data
     */
    void onCollectionWeb(CollectionWebsite data);

//    /**
//     * 收藏列表
//     * 正确返回
//     */
//    void onCollectionList();
//
//    /**
//     * 错误返回
//     */
//    void onNetworkError();
//
//    /**
//     * 收藏成功返回
//     */
//    void onCollectSuccess();

    /**
     * 收藏成功
     */
    void onCollectSuccess();

    /**
     * 收藏失败
     */
    void onCollectError();

    /**
     * 取消收藏成功后通知
     */
    void onSendUnCollectionSuccess();

    /**
     * 取消收藏失败后通知
     */
    void onSendUnCollectionError();
}
