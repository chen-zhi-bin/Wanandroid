package com.program.wanandroiddemo.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.wanandroiddemo.model.Api;
import com.program.wanandroiddemo.model.domain.CollectArticle;
import com.program.wanandroiddemo.model.domain.CollectionArticle;
import com.program.wanandroiddemo.model.domain.RecommendTitle;
import com.program.wanandroiddemo.presenter.IRecommendTitlePresenter;
import com.program.wanandroiddemo.presenter.utils.DataUtils;
import com.program.wanandroiddemo.presenter.utils.GetCollectionIds;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.RetrofitManager;
import com.program.wanandroiddemo.utils.UrlUitl;
import com.program.wanandroiddemo.view.IRecommendTitleCallback;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendTitlePresenterImpl implements IRecommendTitlePresenter {

    private IRecommendTitleCallback mCallback =null;
    private final Api mApi;
    private static final int DEFAULT_PAGE=1;
    private int mCurrentPage = DEFAULT_PAGE;
    private final GetCollectionIds mGetCollectionIds;

    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==Constants.MESSAGE_WHAT_COLLECTION){
                LogUtils.d(RecommendTitlePresenterImpl.this,"recommend collection ids =="+mGetCollectionIds);
                getRecommendTitle();
            }
        }
    };
    /**
     * 当前状态
     */
    private boolean mIsLoading = false;


    public RecommendTitlePresenterImpl() {
//        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
//        mApi = retrofit.create(Api.class);

        mApi =RetrofitManager.getInstence().getApi();
        mGetCollectionIds = DataUtils.getInstance().getGetCollectionIds();
    }

    @Override
    public void getRecommendTitle() {
        if (mIsLoading){
            return;
        }
        mIsLoading = true;
        //通知ui
        if (mCallback != null) {
            mCallback.onLoading();
        }

        String recommendTitleUrl = UrlUitl.getRecommendTitle(mCurrentPage);
        Call<RecommendTitle> task = mApi.getRecommend(recommendTitleUrl);
        task.enqueue(new Callback<RecommendTitle>() {
            @Override
            public void onResponse(Call<RecommendTitle> call, Response<RecommendTitle> response) {
                int code = response.code();
                LogUtils.d(RecommendTitlePresenterImpl.this,"code-->"+code);
//                LogUtils.d(RecommendTitlePresenterImpl.this,"result-->"+response.body());
                if (code== HttpURLConnection.HTTP_OK){
                    RecommendTitle data = response.body();
                    if (mCallback != null) {
                        onSuccess(data);
                    }
                }else {
                    onLoadError();
                }
            }

            @Override
            public void onFailure(Call<RecommendTitle> call, Throwable t) {
                LogUtils.d(RecommendTitlePresenterImpl.this,"error  t-->"+t.getMessage());
                onLoadError();
            }
        });
    }

    private void onLoadError() {
        if (mCallback != null) {
            mCallback.onError();
        }
    }

    private void onSuccess(RecommendTitle result){
        if (mCallback != null) {
            try {
                if (isEmpty(result)){
                    onEmpty();
                }else {
                    mCallback.onContentLoadedSuccess(result);
                    LogUtils.d("DEBUG","result");
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

    private boolean isEmpty(RecommendTitle result) {
        int size = result.getData().getDatas().size();
        return size == 0;
    }

    @Override
    public void registerViewCallback(IRecommendTitleCallback callback) {
        this.mCallback =callback;
    }

    @Override
    public void unregisterViewCallback() {
        this.mCallback =null;
    }


    @Override
    public void CollectArticle(int id) {
        String url = UrlUitl.CollectArticle(id);
        String token = Constants.getCookie();
        Call<CollectArticle> task = mApi.setCollectArticle(url,token);
        task.enqueue(new Callback<CollectArticle>() {
            @Override
            public void onResponse(Call<CollectArticle> call, Response<CollectArticle> response) {
                int code = response.code();
                CollectArticle data = response.body();
                if (code==HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
                    mCallback.onCollectSuccess();
                }else {
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

    }

    private String cookie = Constants.getCookie();
    private int page =0;
    private List<Integer> mUserCollectionIds=null;
    @Override
    public void getUserCollection() {
        LogUtils.d(RecommendTitlePresenterImpl.this,"recommend collection ids =="+mGetCollectionIds);
        mUserCollectionIds=new ArrayList<>();
        if (cookie!=null){
            String url = UrlUitl.getCollectionList(page);
            Call<CollectionArticle> task = mApi.getUserCollection(url,cookie);
            task.enqueue(new Callback<CollectionArticle>() {
                @Override
                public void onResponse(Call<CollectionArticle> call, Response<CollectionArticle> response) {
                    int code = response.code();
                    CollectionArticle data = response.body();
                    if (code==HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
                        for (int i = 0; i < data.getData().getDatas().size(); i++) {
                            mUserCollectionIds.add(data.getData().getDatas().get(i).getOriginId());
                        }
                        mGetCollectionIds.setIds(mUserCollectionIds);
                        if (data.getData().getPageCount()>1){
                            page+=1;
                            LogUtils.d(RecommendTitlePresenterImpl.this,"recommend collection ids =="+mGetCollectionIds+" pageCount ="+data.getData().getPageCount());
                            getUserCollectionMore(data.getData().getPageCount());
                        }else {
                            LogUtils.d(RecommendTitlePresenterImpl.this,"recommend asd="+data.getData().getPageCount());
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    Message message = new Message();
                                    message.what=Constants.MESSAGE_WHAT_COLLECTION;
                                }
                            }).start();
                        }
                    }
                }

                @Override
                public void onFailure(Call<CollectionArticle> call, Throwable t) {

                }
            });
        }


    }

    private void getUserCollectionMore(int pageCount) {
        for (; page < pageCount; page++) {
            String url = UrlUitl.getCollectionList(page);
            Call<CollectionArticle> task = mApi.getUserCollection(url,cookie);
            task.enqueue(new Callback<CollectionArticle>() {
                @Override
                public void onResponse(Call<CollectionArticle> call, Response<CollectionArticle> response) {
                    int code = response.code();
                    CollectionArticle data = response.body();
                    if (code==HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
                        for (int i = 0; i < data.getData().getDatas().size(); i++) {
                            mUserCollectionIds.add(data.getData().getDatas().get(i).getOriginId());
                        }
                        mGetCollectionIds.setIds(mUserCollectionIds);
                        LogUtils.d(RecommendTitlePresenterImpl.this,"recommend collection ids =="+mGetCollectionIds);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Message message = new Message();
                                message.what=Constants.MESSAGE_WHAT_COLLECTION;
                            }
                        }).start();

                    }
                }

                @Override
                public void onFailure(Call<CollectionArticle> call, Throwable t) {

                }
            });
        }


    }
}
