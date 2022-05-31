package com.program.wanandroiddemo.presenter.Impl;

import android.util.Log;

import com.program.wanandroiddemo.model.Api;
import com.program.wanandroiddemo.model.domain.SystemCateGoriesChild;
import com.program.wanandroiddemo.model.domain.SystemCategories;
import com.program.wanandroiddemo.presenter.ISystemFragmentPresenter;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.RetrofitManager;
import com.program.wanandroiddemo.view.ISystemFragmentCallback;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SystemFragmentPresenterImpl implements ISystemFragmentPresenter {


    private final Api mApi;
    private ISystemFragmentCallback mCallback=null;


    public SystemFragmentPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();
    }

    /**
     * 当前状态，是否为加载中
     */
    private boolean mIsLoading = true;
    @Override
    public void getSystem() {
        if (mCallback != null) {
            mCallback.onLoading();
        }
        Call<SystemCategories> task = mApi.getSystemCategories();
        task.enqueue(new Callback<SystemCategories>() {
            @Override
            public void onResponse(Call<SystemCategories> call, Response<SystemCategories> response) {
                int code = response.code();
                LogUtils.d(SystemFragmentPresenterImpl.this,"code =="+code);
                SystemCategories data = response.body();
                LogUtils.d(SystemFragmentPresenterImpl.this,"data =="+data);
                if (code== HttpURLConnection.HTTP_OK&&data.getErrorCode()==0){
                    if (mCallback != null) {
                        LogUtils.d(SystemFragmentPresenterImpl.this,"system data="+ data.toString());
//                        SystemCategories2Child(data);
                        mCallback.onSystemCategories(data);
                    }
                }else {
                    mCallback.onError();
                }
            }

            @Override
            public void onFailure(Call<SystemCategories> call, Throwable t) {
                if (mCallback != null) {
                    mCallback.onError();
                }
            }
        });
    }

    /**
     * 把SystemCategories中主要的数据提取出来（已摒弃）
     * @param callback
     */
//    private SystemCateGoriesChild SystemCategories2Child(SystemCategories data) {
//        SystemCateGoriesChild systemCateGoriesChild = new SystemCateGoriesChild();
//        List<SystemCateGoriesChild.DataBeanTitle> child = new ArrayList<>();
//        List<SystemCateGoriesChild.DataBeanTitle.DataBean> childDataBean = new ArrayList<>();
//        for (SystemCategories.DataBean bean : data.getData()) {
//            child.clear();
//            childDataBean.clear();
//            Integer id = bean.getId();
//            String name = bean.getName();
//            for (SystemCategories.DataBean.ChildrenBean childrenBean : bean.getChildren()) {
//                Integer parentChapterId = childrenBean.getParentChapterId();
//                String childName = childrenBean.getName();
//                SystemCateGoriesChild.DataBeanTitle.DataBean dataBean = new SystemCateGoriesChild.DataBeanTitle.DataBean(parentChapterId, childName);
//                childDataBean.add(dataBean);
//            }
//            SystemCateGoriesChild.DataBeanTitle dataBeanTitle = new SystemCateGoriesChild.DataBeanTitle(id, name, childDataBean);
//            child.add(dataBeanTitle);
//        }
//        systemCateGoriesChild.setDataBeans(child);
//        LogUtils.d(SystemFragmentPresenterImpl.this,"dataChilld ="+systemCateGoriesChild.toString());
//        return systemCateGoriesChild;
//    }


    @Override
    public void registerViewCallback(ISystemFragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        mCallback=null;
    }
}
