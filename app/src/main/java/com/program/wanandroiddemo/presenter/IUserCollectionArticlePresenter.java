package com.program.wanandroiddemo.presenter;

import android.content.Context;

import com.program.wanandroiddemo.base.IArticlePresenter;
import com.program.wanandroiddemo.base.IBasePresenter;
import com.program.wanandroiddemo.view.IUserCollectionArticleCallback;

public interface IUserCollectionArticlePresenter extends IArticlePresenter<IUserCollectionArticleCallback> {

    void getCollectionArticle();


}
