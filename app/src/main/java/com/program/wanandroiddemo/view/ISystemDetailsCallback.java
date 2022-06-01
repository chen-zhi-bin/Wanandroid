package com.program.wanandroiddemo.view;

import com.program.wanandroiddemo.base.IArticleCallback;
import com.program.wanandroiddemo.model.domain.RecommendTitle;
import com.program.wanandroiddemo.model.domain.SystemArticleList;

public interface ISystemDetailsCallback extends IArticleCallback {

    void onSystemArticleList(SystemArticleList data);
    /**
     * 没有更多内容
     */
    void onLoaderMoreEmpty();

    /**
     * 加载了更多内容
     */
    void onLoaderMoreLoaded(SystemArticleList data);
    /**
     * 加载更多时错误
     */
    void onLoaderMoreError();
}
