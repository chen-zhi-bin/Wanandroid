package com.program.wanandroiddemo.presenter.Impl;

import com.program.wanandroiddemo.model.Api;
import com.program.wanandroiddemo.model.domain.CollectWebsite;
import com.program.wanandroiddemo.model.domain.CollectionWebsite;
import com.program.wanandroiddemo.model.domain.UnCollectWeb;
import com.program.wanandroiddemo.presenter.IUserCollectionWebPresentere;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.RetrofitManager;
import com.program.wanandroiddemo.view.IUserCollectionWebCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserCollectionWebImpl implements IUserCollectionWebPresentere {


    private final Api mApi;
    private IUserCollectionWebCallback mCallback;
    public UserCollectionWebImpl(){
        mApi = RetrofitManager.getInstence().getApi();
    }

    @Override
    public void getCollectionWeb() {
        //通知ui
        if (mCallback != null) {
            mCallback.onLoading();
        }
        String token = Constants.getCookie();

        Call<CollectionWebsite> task = mApi.getUserCollectionWeb(token);
        task.enqueue(new Callback<CollectionWebsite>() {
            @Override
            public void onResponse(Call<CollectionWebsite> call, Response<CollectionWebsite> response) {
                int code = response.code();
                LogUtils.d(UserCollectionWebImpl.class,"code result =="+code);
                CollectionWebsite data = response.body();
                if (code== HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
                    onLondingSuccess(data);
                }else {
                    onLoadingError();
                }
            }

            @Override
            public void onFailure(Call<CollectionWebsite> call, Throwable t) {
                onLoadingError();
            }
        });
    }

    @Override
    public void onCollect(String name, String link) {
        String token = Constants.getCookie();
        Call<CollectWebsite> task = mApi.collectWeb(token, name, link);
        task.enqueue(new Callback<CollectWebsite>() {
            @Override
            public void onResponse(Call<CollectWebsite> call, Response<CollectWebsite> response) {
                int code = response.code();
                CollectWebsite data = response.body();
                if (code==HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
                   if (mCallback!=null){
                       mCallback.onCollectSuccess();
                   }
                }else {
                    if (mCallback!=null){
                        mCallback.onCollectSuccess();
                    }
                }
            }

            @Override
            public void onFailure(Call<CollectWebsite> call, Throwable t) {
                if (mCallback != null) {
                    mCallback.onCollectError();
                }
            }
        });
    }


    @Override
    public void onUnCollect(int id) {
        String token = Constants.getCookie();
        Call<UnCollectWeb> task = mApi.unCollectWeb(token, id);
        task.enqueue(new Callback<UnCollectWeb>() {
            @Override
            public void onResponse(Call<UnCollectWeb> call, Response<UnCollectWeb> response) {
                int code = response.code();
                UnCollectWeb data = response.body();
                if (code==HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
                    onUnCollectionSuccess();
                }else {
                    onNetworkErrorResult();
                }
            }

            @Override
            public void onFailure(Call<UnCollectWeb> call, Throwable t) {
                onNetworkErrorResult();
            }
        });
    }

    private void onNetworkErrorResult() {
        if (mCallback != null) {
            mCallback.onSendUnCollectionError();
        }
    }


    private void onUnCollectionSuccess() {
        if (mCallback != null) {
            mCallback.onSendUnCollectionSuccess();
        }
    }

    private void onLoadingError() {
        if (mCallback != null) {
            mCallback.onError();
        }
    }

    private void onLondingSuccess(CollectionWebsite data) {
        if (mCallback != null) {
            try {
                if (isEmpty(data)) {
                    onEmpty();
                }else {
                    mCallback.onCollectionWeb(data);
                }
            }catch (Exception e){
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

    private boolean isEmpty(CollectionWebsite data) {
        return data.getData().size()==0;
    }



    @Override
    public void registerViewCallback(IUserCollectionWebCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        this.mCallback=null;
    }


}
