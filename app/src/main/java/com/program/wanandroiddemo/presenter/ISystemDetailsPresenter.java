package com.program.wanandroiddemo.presenter;

import com.program.wanandroiddemo.base.IArticlePresenter;
import com.program.wanandroiddemo.base.IBasePresenter;
import com.program.wanandroiddemo.view.ISystemDetailsCallback;

public interface ISystemDetailsPresenter extends IArticlePresenter<ISystemDetailsCallback> {

    void getSystemArticle(int id);

    void loadMore();

    void getUserCollection();

}
