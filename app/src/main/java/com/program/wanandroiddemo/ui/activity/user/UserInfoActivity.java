package com.program.wanandroiddemo.ui.activity.user;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseActivity;
import com.program.wanandroiddemo.model.domain.UserInfo;
import com.program.wanandroiddemo.model.domain.UserInformation;
import com.program.wanandroiddemo.presenter.IUserPresenter;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.ToastUtils;
import com.program.wanandroiddemo.view.IUserCallback;

import butterknife.BindView;

public class UserInfoActivity extends BaseActivity implements IUserCallback {

    @BindView(R.id.user_login_out)
    public TextView mLoginOutBtn;
    @BindView(R.id.user_info_tv)
    public TextView mInfoTv;
    private IUserPresenter mUserInfoPresenter;

    @Override
    protected void initPresenter() {
        mUserInfoPresenter = PresenterManager.getInstance().getUserInfoPresenter();
        mUserInfoPresenter.getUserInfo();
        mUserInfoPresenter.setDialogActivity(this);
        mUserInfoPresenter.registerViewCallback(this);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initEvent() {
        super.initEvent();

        initListener();
    }

    private void initListener() {
        mLoginOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserInfoPresenter.getUserLoginout();
            }
        });
    }


    @Override
    public void onUserInfo(UserInfo userInfo) {
        mInfoTv.setText(userInfo.toString());
    }

    @Override
    public void onResultLoginOut() {
        ToastUtils.showToast("登出成功");
        mUserInfoPresenter.unregisterViewCallback();
        this.finish();
    }

    @Override
    public void onError() {
        ToastUtils.showToast("网络错误，请稍后重试");
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }
}