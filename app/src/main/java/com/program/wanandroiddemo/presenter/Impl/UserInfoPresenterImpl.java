package com.program.wanandroiddemo.presenter.Impl;

import android.app.Activity;
import android.widget.Toast;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.model.Api;
import com.program.wanandroiddemo.model.domain.Loginout;
import com.program.wanandroiddemo.model.domain.UserInfo;
import com.program.wanandroiddemo.presenter.IUserPresenter;
import com.program.wanandroiddemo.presenter.utils.GetCollectionIds;
import com.program.wanandroiddemo.ui.custom.LoadingDialog;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.RetrofitManager;
import com.program.wanandroiddemo.utils.SharedPreferencesUtils;
import com.program.wanandroiddemo.utils.ToastUtils;
import com.program.wanandroiddemo.view.IUserCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoPresenterImpl implements IUserPresenter {

    private SharedPreferencesUtils mSPUtils;
    private final Api mApi;
    private Activity mDialogActivity;
    private IUserCallback mCallback = null;

    public UserInfoPresenterImpl() {
        mApi = RetrofitManager.getInstence().getApi();

    }

    @Override
    public void getUserLoginout() {
        LoadingDialog loadingDialog = new LoadingDialog(mDialogActivity, R.layout.wait_dialog);
        loadingDialog.show();
        mSPUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        String token = mSPUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        Call<Loginout> task = mApi.getLoginout(token);
        task.enqueue(new Callback<Loginout>() {
            @Override
            public void onResponse(Call<Loginout> call, Response<Loginout> response) {
                int code = response.code();
                LogUtils.d(this, "code ==" + code);
                LogUtils.d(this, "result ==" + response.body());
                if (code == HttpURLConnection.HTTP_OK && response.body().getErrorCode() != -1001) {
                    mSPUtils.putString(SharedPreferencesUtils.NEED_REFRESH,SharedPreferencesUtils.NEED_REFRESH);
                    mSPUtils.remove(SharedPreferencesUtils.USER_TOKEN_COOKIE_TIME);
                    mSPUtils.remove(SharedPreferencesUtils.USER_TOKEN_COOKIE);
                    mSPUtils.remove(SharedPreferencesUtils.USER_NAME);
                    mCallback.onResultLoginOut();
                    new GetCollectionIds().setIds2Null();
                }else {
                    mCallback.onError();
                }
                loadingDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Loginout> call, Throwable t) {
                LogUtils.d(this, "error t->" + t.toString());
                loadingDialog.dismiss();
                mCallback.onError();
            }
        });
    }

    @Override
    public void setDialogActivity(Activity activity) {
        this.mDialogActivity = activity;
    }

    @Override
    public void getUserInfo() {
        mSPUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        String token = mSPUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
        Call<UserInfo> task = mApi.getUserInfo(token);
        task.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                int code = response.code();
                LogUtils.d(UserInfoPresenterImpl.this,"result cod=="+code);
                UserInfo info = response.body();
                if (code==HttpURLConnection.HTTP_OK&&info.getErrorCode()!=-1){
                  mCallback.onUserInfo(info);
                }else {
                    ToastUtils.showToast(response.body().getErrorMsg());
                }
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                mCallback.onError();
            }
        });
    }

    @Override
    public void registerViewCallback(IUserCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        this.mCallback = null;
    }
}
