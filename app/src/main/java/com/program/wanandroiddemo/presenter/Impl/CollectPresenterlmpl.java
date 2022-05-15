package com.program.wanandroiddemo.presenter.Impl;

import com.program.wanandroiddemo.model.Api;
import com.program.wanandroiddemo.model.domain.CollectArticleOut;
import com.program.wanandroiddemo.model.domain.CollectWebsite;
import com.program.wanandroiddemo.presenter.ICollectPresenter;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.RetrofitManager;
import com.program.wanandroiddemo.view.ICollectBallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//收藏活动使用
public class CollectPresenterlmpl implements ICollectPresenter {

    private final Api mApi;
    private ICollectBallback mCallback = null;

    public CollectPresenterlmpl() {
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void setCollectArticle(String title, String author, String link) {
        String token = Constants.getCookie();
        Call<CollectArticleOut> task = mApi.setCollectArticleOut(token, title, author, link);
        task.enqueue(new Callback<CollectArticleOut>() {
            @Override
            public void onResponse(Call<CollectArticleOut> call, Response<CollectArticleOut> response) {
                int code = response.code();
                CollectArticleOut data = response.body();
                if (code == HttpURLConnection.HTTP_OK && data.getErrorCode() == 0) {
                    onSuccess();
                } else {
                    onError();
                }
            }

            @Override
            public void onFailure(Call<CollectArticleOut> call, Throwable t) {
                onError();
            }
        });
    }

    @Override
    public void setCollectWeb(String title, String link) {
        String token = Constants.getCookie();
        Call<CollectWebsite> task = mApi.collectWeb(token, title, link);
        task.enqueue(new Callback<CollectWebsite>() {
            @Override
            public void onResponse(Call<CollectWebsite> call, Response<CollectWebsite> response) {
                int code = response.code();
                CollectWebsite data = response.body();
                LogUtils.d(CollectPresenterlmpl.class, "code == " + code + "// data == " + data);
                if (code == HttpURLConnection.HTTP_OK && data.getErrorCode() == 0) {
                    onSuccess();
                } else {
                    onError();
                }
            }

            @Override
            public void onFailure(Call<CollectWebsite> call, Throwable t) {
                onError();
            }
        });
    }

    private void onError() {
        if (mCallback != null) {
            mCallback.resultError();
        }
    }

    private void onSuccess() {
        if (mCallback != null) {
            mCallback.resultSuccess();
        }
    }


    @Override
    public void registerViewCallback(ICollectBallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback = null;
    }
}
