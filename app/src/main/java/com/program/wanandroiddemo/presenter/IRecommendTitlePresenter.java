package com.program.wanandroiddemo.presenter;

import com.program.wanandroiddemo.base.IArticlePresenter;
import com.program.wanandroiddemo.base.IBasePresenter;
import com.program.wanandroiddemo.view.IRecommendTitleCallback;

public interface IRecommendTitlePresenter extends IArticlePresenter<IRecommendTitleCallback> {

    void getRecommendTitle();

    void loadMore();

    void getUserCollection();

    /**
     * 返回时判断是否需要刷新
     */
    boolean needRefresh();

    /*
    轮播图
     */
    void getLooperPager();
}
