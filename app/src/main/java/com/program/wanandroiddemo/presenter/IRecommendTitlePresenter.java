package com.program.wanandroiddemo.presenter;

import com.program.wanandroiddemo.base.IArticlePresenter;
import com.program.wanandroiddemo.base.IBasePresenter;
import com.program.wanandroiddemo.view.IRecommendTitleCallback;

public interface IRecommendTitlePresenter extends IArticlePresenter<IRecommendTitleCallback> {

    void getRecommendTitle();

    void getUserCollection();
}
