package com.program.wanandroiddemo.base;

public interface IArticleCallback extends IBaseCallback{
    //============================文章相关 start============================//

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

    //============================文章相关 end============================//
}
