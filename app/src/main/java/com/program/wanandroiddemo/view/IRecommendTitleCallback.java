package com.program.wanandroiddemo.view;

import com.program.wanandroiddemo.base.IArticleCallback;
import com.program.wanandroiddemo.base.IBaseCallback;
import com.program.wanandroiddemo.model.domain.RecommendPagerContent;
import com.program.wanandroiddemo.model.domain.RecommendTitle;

import java.util.List;

public interface IRecommendTitleCallback extends IArticleCallback {

    /**
     * 内容
     * @param content
     */
    void onContentLoadedSuccess(RecommendTitle content);

    /**
     * 加载更多时错误
     */
    void onLoaderMoreError();

    /**
     * 没有更多内容
     */
    void onLoaderMoreEmpty();

    /**
     * 加载了更多内容
     */
    void onLoaderMoreLoaded(RecommendTitle data);

    /**
     * 轮播图内容加载
     * @param contents
     */
    void onLooperListLoaded(RecommendPagerContent contents);
}
