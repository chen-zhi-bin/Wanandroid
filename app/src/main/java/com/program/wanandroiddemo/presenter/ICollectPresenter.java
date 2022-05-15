package com.program.wanandroiddemo.presenter;

import com.program.wanandroiddemo.base.IBaseCallback;
import com.program.wanandroiddemo.base.IBasePresenter;
import com.program.wanandroiddemo.view.ICollectBallback;

public interface ICollectPresenter extends IBasePresenter<ICollectBallback> {

    /**
     * 收藏文章
     * @param title     标题
     * @param author    作者
     * @param link      url
     */
    void setCollectArticle(String title,String author,String link);

    /**
     * 收藏网站
     * @param title     标题
     * @param link      url
     */
    void setCollectWeb(String title,String link);
}
