package com.program.wanandroiddemo.utils;

import com.program.wanandroiddemo.presenter.ICollectPresenter;
import com.program.wanandroiddemo.presenter.IMainActivityDataHandle;
import com.program.wanandroiddemo.presenter.IUserCollectionArticlePresenter;
import com.program.wanandroiddemo.presenter.IUserCollectionWebPresentere;
import com.program.wanandroiddemo.presenter.IUserLoginPresenter;
import com.program.wanandroiddemo.presenter.IRecommendTitlePresenter;
import com.program.wanandroiddemo.presenter.IUserPresenter;
import com.program.wanandroiddemo.presenter.Impl.CollectPresenterlmpl;
import com.program.wanandroiddemo.presenter.Impl.MainActivityDataHandleImpl;
import com.program.wanandroiddemo.presenter.Impl.UserCollectionArticlePresenterImpl;
import com.program.wanandroiddemo.presenter.Impl.UserCollectionWebImpl;
import com.program.wanandroiddemo.presenter.Impl.UserInfoPresenterImpl;
import com.program.wanandroiddemo.presenter.Impl.UserLoginPresenterImpl;
import com.program.wanandroiddemo.presenter.Impl.RecommendTitlePresenterImpl;

public class PresenterManager {
    private static final PresenterManager ourInstance = new PresenterManager();
    private final IUserLoginPresenter mLoginPresenter;
    private final IRecommendTitlePresenter mRecommendTitlePresenter;
    private final IUserPresenter mUserInfoPresenter;
    private final IUserCollectionArticlePresenter mUserCollectionPresenter;
    private final IUserCollectionWebPresentere mUserCollectionWeb;
    private final ICollectPresenter mCollectPresenterlmpl;
    private final IMainActivityDataHandle mMainActivityDataHandle;


    public static PresenterManager getInstance(){
        return ourInstance;
    }


    public IRecommendTitlePresenter getRecommendTitlePresenter() {
        return mRecommendTitlePresenter;
    }

    public IUserPresenter getUserInfoPresenter() {
        return mUserInfoPresenter;
    }

    public IUserLoginPresenter getUserPresenter() {
        return mLoginPresenter;
    }


    public IUserCollectionWebPresentere getUserCollectionWeb() {
        return mUserCollectionWeb;
    }

    public IUserCollectionArticlePresenter getUserCollectionPresenter() {
        return mUserCollectionPresenter;
    }

    public ICollectPresenter getCollectPresenterlmpl() {
        return mCollectPresenterlmpl;
    }

    public IMainActivityDataHandle getMainActivityDataHandle() {
        return mMainActivityDataHandle;
    }

    private PresenterManager(){
        mRecommendTitlePresenter = new RecommendTitlePresenterImpl();
        mLoginPresenter = new UserLoginPresenterImpl();
        mUserInfoPresenter = new UserInfoPresenterImpl();
        mUserCollectionPresenter = new UserCollectionArticlePresenterImpl();
        mUserCollectionWeb = new UserCollectionWebImpl();
        mCollectPresenterlmpl = new CollectPresenterlmpl();
        mMainActivityDataHandle = new MainActivityDataHandleImpl();
    }

}
