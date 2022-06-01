package com.program.wanandroiddemo.presenter.Impl;

import android.os.Message;

import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.model.Api;
import com.program.wanandroiddemo.model.domain.CollectArticle;
import com.program.wanandroiddemo.model.domain.RecommendTitle;
import com.program.wanandroiddemo.model.domain.SystemArticleList;
import com.program.wanandroiddemo.model.domain.UnCollectArticle;
import com.program.wanandroiddemo.model.domain.UserInfo;
import com.program.wanandroiddemo.presenter.ISystemDetailsPresenter;
import com.program.wanandroiddemo.presenter.utils.DataUtils;
import com.program.wanandroiddemo.presenter.utils.GetCollectionIds;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.RetrofitManager;
import com.program.wanandroiddemo.utils.SharedPreferencesUtils;
import com.program.wanandroiddemo.utils.UrlUitl;
import com.program.wanandroiddemo.view.ISystemDetailsCallback;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SystemDetailsPresenterImpl implements ISystemDetailsPresenter {

    private final Api mApi;
    private static final int DEFAULT_PAGE = 0;
    private int mPage = DEFAULT_PAGE;
    private ISystemDetailsCallback mCallback=null;
    private GetCollectionIds mGetCollectionIds;
    private SharedPreferencesUtils mSPUtils;
    private int mId;

    public SystemDetailsPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
        mGetCollectionIds = DataUtils.getInstance().getGetCollectionIds();
        mSPUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
    }

    @Override
    public void getSystemArticle(int id) {
        mId = id;
        String url = UrlUitl.getSystemArticle(mPage);
        mPage+=1;
        Call<SystemArticleList> task = mApi.getSystemArticleList(url, id);
        task.enqueue(new Callback<SystemArticleList>() {
            @Override
            public void onResponse(Call<SystemArticleList> call, Response<SystemArticleList> response) {
                int code = response.code();
                SystemArticleList data = response.body();
                if (code== HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
                    LogUtils.d(SystemDetailsPresenterImpl.this,"data ="+data);
                    onSuccess(data);

                }else {
                    onLoadError();
                }
            }

            @Override
            public void onFailure(Call<SystemArticleList> call, Throwable t) {
                onLoadError();
            }
        });
    }

    @Override
    public void loadMore() {
        mPage+=1;
        String url = UrlUitl.getSystemArticle(mPage);
        Call<SystemArticleList> task = mApi.getSystemArticleList(url, mId);
        task.enqueue(new Callback<SystemArticleList>() {
            @Override
            public void onResponse(Call<SystemArticleList> call, Response<SystemArticleList> response) {
                int code = response.code();
                SystemArticleList data = response.body();
                if (code==HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
                    loadMoreResult(data);
                }else {
                    loadMoreResultError();
                }
            }

            @Override
            public void onFailure(Call<SystemArticleList> call, Throwable t) {
                loadMoreResultError();
            }
        });
    }

    private void loadMoreResultError() {
        if (mCallback != null) {
            mCallback.onLoaderMoreError();
        }
    }

    private void loadMoreResult(SystemArticleList data) {
        if (data==null||data.getData().getDatas().size()==0) {
            mCallback.onLoaderMoreEmpty();
            mPage--;
        }else {
            mCallback.onLoaderMoreLoaded(data);
        }
    }

    @Override
    public void getUserCollection() {
        String token = Constants.getCookie();
        LogUtils.d(SystemDetailsPresenterImpl.this, "ids =" + mGetCollectionIds + "====cookie" + token.equals(""));
//        if (!token.equals("")) {
        LogUtils.d(SystemDetailsPresenterImpl.this, "ids =" + mGetCollectionIds + "====cookie" + token);
        Call<UserInfo> task = mApi.getUserInfo(token);
        task.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                int code = response.code();
                LogUtils.d(SystemDetailsPresenterImpl.this,"code ="+code);
                UserInfo data = response.body();
                LogUtils.d(SystemDetailsPresenterImpl.this,"recommend title data ="+data);
                if (code == HttpURLConnection.HTTP_OK&&data.getErrorCode()==0) {
                    mGetCollectionIds.setIds(data.getData().getUserInfo().getCollectIds());
                    LogUtils.d(SystemDetailsPresenterImpl.this, "ids =" + mGetCollectionIds);

                }
                if (data.getErrorCode()==-1001){
                    mSPUtils= SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
                    mSPUtils.clear();
                    ArrayList<Integer> nullData = new ArrayList<>();
                    mGetCollectionIds.setIds(nullData);
                }

            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {

            }
        });



    }

    private void onLoadError() {
        if (mCallback != null) {
            mCallback.onError();
        }
    }

    private void onSuccess(SystemArticleList data) {
        if (mCallback != null) {
            try {
                if (isEmpty(data)) {
                    onEmpty();
                } else {
                    mCallback.onSystemArticleList(data);
                    LogUtils.d("DEBUG", "result");
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
    private boolean isEmpty(SystemArticleList result) {
        int size = result.getData().getDatas().size();
        return size == 0;
    }
    @Override
    public void CollectArticle(int id) {
        String url = UrlUitl.CollectArticle(id);
        String token = Constants.getCookie();
        Call<CollectArticle> task = mApi.setCollectArticle(url, token);
        task.enqueue(new Callback<CollectArticle>() {
            @Override
            public void onResponse(Call<CollectArticle> call, Response<CollectArticle> response) {
                int code = response.code();
                CollectArticle data = response.body();
                if (code == HttpURLConnection.HTTP_OK && data.getErrorCode() == 0) {
                    mCallback.onCollectSuccess();
                } else {
                    mCallback.onCollectError();
                }
            }

            @Override
            public void onFailure(Call<CollectArticle> call, Throwable t) {
                mCallback.onCollectError();
            }
        });
    }

    @Override
    public void unCollect(int id, int originId) {
        String token = Constants.getCookie();
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
                unCollectError();
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

    @Override
    public void registerViewCallback(ISystemDetailsCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback=null;
    }
}
