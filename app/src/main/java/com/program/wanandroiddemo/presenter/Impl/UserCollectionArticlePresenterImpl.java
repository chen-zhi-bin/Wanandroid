package com.program.wanandroiddemo.presenter.Impl;

import android.content.Context;

import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.model.Api;
import com.program.wanandroiddemo.model.domain.CollectArticle;
import com.program.wanandroiddemo.model.domain.CollectionArticle;
import com.program.wanandroiddemo.model.domain.UnCollectArticle;
import com.program.wanandroiddemo.presenter.IUserCollectionArticlePresenter;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.RetrofitManager;
import com.program.wanandroiddemo.utils.SharedPreferencesUtils;
import com.program.wanandroiddemo.utils.UrlUitl;
import com.program.wanandroiddemo.view.IUserCollectionArticleCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserCollectionArticlePresenterImpl implements IUserCollectionArticlePresenter {

    private final Api mApi;
    private IUserCollectionArticleCallback mCallback = null;
    private static final int DEFAULT_PAGE = 0;
    private int mCurrentPage = DEFAULT_PAGE;

    public UserCollectionArticlePresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void getCollectionArticle() {
        //通知ui
        if (mCallback != null) {
            mCallback.onLoading();
        }
        String token = getCookie(BaseApplication.getAppContext());
        LogUtils.d(UserCollectionArticlePresenterImpl.class, "page ==" + mCurrentPage);
        String collectionListPage = UrlUitl.getCollectionList(mCurrentPage);
        Call<CollectionArticle> task = mApi.getUserCollection(collectionListPage, token);
        task.enqueue(new Callback<CollectionArticle>() {
            @Override
            public void onResponse(Call<CollectionArticle> call, Response<CollectionArticle> response) {
                int code = response.code();
                LogUtils.d(UserCollectionArticlePresenterImpl.class, "result code ==" + code);
                CollectionArticle collectionList = response.body();
                LogUtils.d(UserCollectionArticlePresenterImpl.class, "errorCode =" + collectionList.getErrorCode());
                LogUtils.d(UserCollectionArticlePresenterImpl.class, "errorMsg =" + collectionList.getErrorMsg());
                if (code == HttpURLConnection.HTTP_OK && collectionList.getErrorCode() == 0) {
                    LogUtils.d(UserCollectionArticlePresenterImpl.class, "result =" + collectionList);
                    onLoadingArticleSuccess(collectionList);
                } else {
                    onLoadingError();
                }
            }

            @Override
            public void onFailure(Call<CollectionArticle> call, Throwable t) {
                onLoadingError();
            }
        });


    }


    private void unCollectError() {
        if (mCallback != null) {
            mCallback.onSendUnCollectionError();
        }
    }

    private void unCollectSuccess() {
        if (mCallback != null) {
            mCallback.onSendUnCollectionSuccess();
        }
    }

    private String getCookie(Context context) {
        //拿cookie
        SharedPreferencesUtils sp = SharedPreferencesUtils.getInstance(context);
        return sp.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }


    private void onLoadingArticleSuccess(CollectionArticle result) {
        if (mCallback != null) {
            try {
                if (isEmpty(result)) {
                    onEmpty();
                } else {
                    mCallback.onUserCollectionArticle(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
                onEmpty();
            }
        }
    }

    private void onEmpty() {
        if (mCallback != null) {
            mCallback.onEmpty();
        }
    }

    private void onLoadingError() {
        if (mCallback != null) {
            mCallback.onError();
        }
    }

    private boolean isEmpty(CollectionArticle collectionList) {
        int size = collectionList.getData().getDatas().size();
        LogUtils.d(UserCollectionArticlePresenterImpl.class, "size==" + size);
        return size == 0;
    }

    @Override
    public void registerViewCallback(IUserCollectionArticleCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }

    @Override
    public void CollectArticle(int id) {
        String url = UrlUitl.CollectArticle(id);
        String token = getCookie(BaseApplication.getAppContext());
        Call<CollectArticle> task = mApi.setCollectArticle(url, token);
        task.enqueue(new Callback<CollectArticle>() {
            @Override
            public void onResponse(Call<CollectArticle> call, Response<CollectArticle> response) {
                int code = response.code();
                CollectArticle data = response.body();
                if (code==HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
                    LogUtils.d(UserCollectionArticlePresenterImpl.class,"code == "+code+"response =="+data);
                    CollectSuccess();
                }else {
                    CollectError();
                }
            }

            @Override
            public void onFailure(Call<CollectArticle> call, Throwable t) {
                    CollectError();
            }
        });
    }

    /**
     * 收藏失败
     */
    private void CollectError() {
        if (mCallback != null) {
            mCallback.onCollectError();
        }
    }

    /**
     * 收藏成功
     */
    private void CollectSuccess() {
        if (mCallback != null) {
            mCallback.onCollectSuccess();
        }
    }

    @Override
    public void unCollect(int id, int originId) {
        String token = getCookie(BaseApplication.getAppContext());
        String url = UrlUitl.unCollectUrl(id);
        Call<UnCollectArticle> task = mApi.unCollectArticle(url, token, originId);
        task.enqueue(new Callback<UnCollectArticle>() {

            @Override
            public void onResponse(Call<UnCollectArticle> call, Response<UnCollectArticle> response) {
                int code = response.code();
                UnCollectArticle result = response.body();
                if (code == HttpURLConnection.HTTP_OK && result.getErrorCode() == 0) {
                    unCollectSuccess();
                } else {
                    unCollectError();
                }
            }

            @Override
            public void onFailure(Call<UnCollectArticle> call, Throwable t) {
                LogUtils.d(UserCollectionArticlePresenterImpl.class, "error t -->" + t.toString());
                unCollectError();
            }

        });

    }




}
