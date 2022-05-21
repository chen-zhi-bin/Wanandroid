package com.program.wanandroiddemo.presenter.Impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.model.Api;
import com.program.wanandroiddemo.model.domain.CollectArticle;
import com.program.wanandroiddemo.model.domain.CollectionArticle;
import com.program.wanandroiddemo.model.domain.RecommendPagerContent;
import com.program.wanandroiddemo.model.domain.RecommendTitle;
import com.program.wanandroiddemo.model.domain.UnCollectArticle;
import com.program.wanandroiddemo.model.domain.UserInfo;
import com.program.wanandroiddemo.presenter.IRecommendTitlePresenter;
import com.program.wanandroiddemo.presenter.utils.DataUtils;
import com.program.wanandroiddemo.presenter.utils.GetCollectionIds;
import com.program.wanandroiddemo.ui.fragment.UserFragment;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.RetrofitManager;
import com.program.wanandroiddemo.utils.SharedPreferencesUtils;
import com.program.wanandroiddemo.utils.ToastUtils;
import com.program.wanandroiddemo.utils.UrlUitl;
import com.program.wanandroiddemo.view.IRecommendTitleCallback;

import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class RecommendTitlePresenterImpl implements IRecommendTitlePresenter {

    private IRecommendTitleCallback mCallback = null;
    private final Api mApi;
    private static final int DEFAULT_PAGE = 0;
    private int mCurrentPage = DEFAULT_PAGE;
    private final GetCollectionIds mGetCollectionIds;
    private SharedPreferencesUtils mSPUtils;
    private Thread mThread=null;

    private Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == Constants.MESSAGE_WHAT_COLLECTION) {
                LogUtils.d(RecommendTitlePresenterImpl.this, "recommend collection ids ==" + mGetCollectionIds);
                getRecommendTitle();
            }
        }
    };
    /**
     * 当前状态
     */
    private boolean mIsLoading = true;
    private final SharedPreferencesUtils mSp;


    public RecommendTitlePresenterImpl() {
//        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
//        mApi = retrofit.create(Api.class);

        mApi = RetrofitManager.getInstence().getApi();
        mGetCollectionIds = DataUtils.getInstance().getGetCollectionIds();
        mSp = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
    }

    @Override
    public void getRecommendTitle() {
        mCurrentPage=DEFAULT_PAGE;
        //通知ui
        if (mCallback != null&&mIsLoading) {
            mCallback.onLoading();
        }
        mIsLoading=false;
        String recommendTitleUrl = UrlUitl.getRecommendTitle(mCurrentPage);
        Call<RecommendTitle> task = mApi.getRecommend(recommendTitleUrl);
        task.enqueue(new Callback<RecommendTitle>() {
            @Override
            public void onResponse(Call<RecommendTitle> call, Response<RecommendTitle> response) {
                int code = response.code();
                LogUtils.d(RecommendTitlePresenterImpl.this, "code-->" + code);
//                LogUtils.d(RecommendTitlePresenterImpl.this,"result-->"+response.body());
                if (code == HttpURLConnection.HTTP_OK) {
                    RecommendTitle data = response.body();
                    if (mCallback != null) {
                        onSuccess(data);
                    }
                } else {
                    onLoadError();
                }
            }

            @Override
            public void onFailure(Call<RecommendTitle> call, Throwable t) {
                LogUtils.d(RecommendTitlePresenterImpl.this, "error  t-->" + t.getMessage());
                onLoadError();
            }
        });
    }

    @Override
    public void loadMore() {
        mCurrentPage+=1;
        String url = UrlUitl.getRecommendTitle(mCurrentPage);
        Call<RecommendTitle> task = mApi.getRecommend(url);
        task.enqueue(new Callback<RecommendTitle>() {
            @Override
            public void onResponse(Call<RecommendTitle> call, Response<RecommendTitle> response) {
                int code = response.code();
                if (code==HttpURLConnection.HTTP_OK){
                    RecommendTitle data = response.body();
                    handleLoaderResult(data);
                }else {
                    handleLoaderResultError();
                }
            }

            @Override
            public void onFailure(Call<RecommendTitle> call, Throwable t) {
                handleLoaderResultError();
            }
        });
    }

    private void handleLoaderResultError() {
        mCallback.onLoaderMoreError();
    }

    private void handleLoaderResult(RecommendTitle data) {
        if (data==null||data.getData().getDatas().size()==0){
            mCallback.onLoaderMoreEmpty();
            mCurrentPage--;
        }else {
            mCallback.onLoaderMoreLoaded(data);
        }
    }


    private void onLoadError() {


        if (mCallback != null) {
            mCallback.onError();
        }
    }

    private void onSuccess(RecommendTitle result) {
        if (mCallback != null) {
            try {
                if (isEmpty(result)) {
                    onEmpty();
                } else {
                    mCallback.onContentLoadedSuccess(result);
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

    private boolean isEmpty(RecommendTitle result) {
        int size = result.getData().getDatas().size();
        return size == 0;
    }

    @Override
    public void registerViewCallback(IRecommendTitleCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        this.mCallback = null;
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
            mCallback.onCollectError();
        }
    }

    private void unCollectSuccess() {
        if (mCallback != null) {
            mCallback.onCollectSuccess();
        }
    }

    @Override
    public void getUserCollection() {
        String token = Constants.getCookie();
        LogUtils.d(RecommendTitlePresenterImpl.this, "ids =" + mGetCollectionIds + "====cookie" + token.equals(""));
        if (!token.equals("")) {
            LogUtils.d(RecommendTitlePresenterImpl.this, "ids =" + mGetCollectionIds + "====cookie" + token);
            Call<UserInfo> task = mApi.getUserInfo(token);
            task.enqueue(new Callback<UserInfo>() {
                @Override
                public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                    int code = response.code();
                    LogUtils.d(RecommendTitlePresenterImpl.this,"code ="+code);
                    UserInfo data = response.body();
                    LogUtils.d(RecommendTitlePresenterImpl.this,"recommend title data ="+data);
                    if (code == HttpURLConnection.HTTP_OK&&data.getErrorCode()==0) {
                        mGetCollectionIds.setIds(data.getData().getUserInfo().getCollectIds());
                        LogUtils.d(RecommendTitlePresenterImpl.this, "ids =" + mGetCollectionIds);
//                        if (mThread == null) {
//                            LogUtils.d(RecommendTitlePresenterImpl.this,"Thread");
//                            mThread = new Thread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Message message = new Message();
//                                    message.what = Constants.MESSAGE_WHAT_COLLECTION;
//                                }
//                            });
//                            mThread.start();
//                        }
                    }
                    getRecommendTitle();
                }

                @Override
                public void onFailure(Call<UserInfo> call, Throwable t) {

                }
            });
        } else {
            LogUtils.d(RecommendTitlePresenterImpl.this, " recommend  ");
            getRecommendTitle();
        }

//        LogUtils.d(RecommendTitlePresenterImpl.this,"recommend collection ids =="+mGetCollectionIds);
//        mUserCollectionIds=new ArrayList<>();
//        if (cookie!=null){
//            String url = UrlUitl.getCollectionList(page);
//            Call<CollectionArticle> task = mApi.getUserCollection(url,cookie);
//            task.enqueue(new Callback<CollectionArticle>() {
//                @Override
//                public void onResponse(Call<CollectionArticle> call, Response<CollectionArticle> response) {
//                    int code = response.code();
//                    CollectionArticle data = response.body();
//                    if (code==HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
//                        for (int i = 0; i < data.getData().getDatas().size(); i++) {
//                            mUserCollectionIds.add(data.getData().getDatas().get(i).getOriginId());
//                        }
//                        mGetCollectionIds.setIds(mUserCollectionIds);
//                        if (data.getData().getPageCount()>1){
//                            page+=1;
//                            LogUtils.d(RecommendTitlePresenterImpl.this,"recommend collection ids =="+mGetCollectionIds+" pageCount ="+data.getData().getPageCount());
//                            getUserCollectionMore(data.getData().getPageCount());
//                        }else {
//                            LogUtils.d(RecommendTitlePresenterImpl.this,"recommend asd="+data.getData().getPageCount());
//                            new Thread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Message message = new Message();
//                                    message.what=Constants.MESSAGE_WHAT_COLLECTION;
//                                }
//                            }).start();
//                        }
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<CollectionArticle> call, Throwable t) {
//
//                }
//            });
//        }


    }


    @Override
    public boolean needRefresh() {
        String str = mSp.getString(SharedPreferencesUtils.NEED_REFRESH);
        LogUtils.d(RecommendTitlePresenterImpl.this,"str ="+str);
        if (str==null||str.equals("")){
            return false;
        }else {
            mSp.remove(SharedPreferencesUtils.NEED_REFRESH);
            return true;
        }
    }

    @Override
    public void getLooperPager() {
        Call<RecommendPagerContent> task = mApi.getRecommendPagerLoop(Constants.BASE_URL + "banner/json");
        task.enqueue(new Callback<RecommendPagerContent>() {
            @Override
            public void onResponse(Call<RecommendPagerContent> call, Response<RecommendPagerContent> response) {
                int code = response.code();
                RecommendPagerContent data = response.body();
                LogUtils.d(RecommendTitlePresenterImpl.this,"loop data ="+data);
                if (code==HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){

                    mCallback.onLooperListLoaded(data);
                }else {
                    ToastUtils.showToast(data.getErrorMsg());
                }
            }

            @Override
            public void onFailure(Call<RecommendPagerContent> call, Throwable t) {
                ToastUtils.showToast(t.getMessage());
            }
        });
    }


}
