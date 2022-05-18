package com.program.wanandroiddemo.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseFragment;
import com.program.wanandroiddemo.presenter.IUserLoginPresenter;
import com.program.wanandroiddemo.ui.activity.MainActivity;
import com.program.wanandroiddemo.ui.activity.user.UserCollectActivity;
import com.program.wanandroiddemo.ui.activity.user.UserInfoActivity;
import com.program.wanandroiddemo.ui.activity.user.UserLoginActivity;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.SharedPreferencesUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;

import static com.program.wanandroiddemo.base.BaseApplication.getAppContext;

public class UserFragment extends BaseFragment {

    @BindView(R.id.user_login)
    public TextView mUserTv;
  @BindView(R.id.user_collection)
    public TextView mUserCollectBtn;
    @BindView(R.id.user_info)
    public TextView mUserInfoBtn;


    @BindView(R.id.fragment_bar_title_tv)
    public TextView barTitleTv;

    private SharedPreferencesUtils mSPUtils;
    private String mUserName;
    private IUserLoginPresenter mUserPresenter;

    private boolean userLoginOrName=false;//判断登录是否可用

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_user;
    }

    @Override
    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_with_bar_layout,container,false);
    }

    //显示
    protected void initView(View rootView) {
        Context context = getAppContext();
        mSPUtils = SharedPreferencesUtils.getInstance(context);
        String token = mSPUtils.getString("token_press");
        setupState(State.SUCCESS);
        userLoginOrName = false;

        LogUtils.d(UserFragment.class,"token =="+token);
        barTitleTv.setText("个人信息");

        LogUtils.d(UserFragment.this,"context =="+context);
        onRefersh();
    }


    /**
     * 用户初始化或刷新信息
     */
    private void onRefersh() {
        mUserName = mSPUtils.getString(SharedPreferencesUtils.USER_NAME);
        LogUtils.d(UserFragment.this,"user name =="+mUserName);
        if (mUserName.equals("")){
            mUserTv.setText(R.string.user_login_register);
            mUserCollectBtn.setVisibility(View.GONE);
            mUserInfoBtn.setVisibility(View.GONE);
            userLoginOrName = false;
        }else {
            mUserTv.setText(mUserName);
            mUserCollectBtn.setVisibility(View.VISIBLE);
            mUserInfoBtn.setVisibility(View.VISIBLE);
            userLoginOrName = true;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        onRefersh();
    }

    @Override
    protected void initPresenter() {
        mUserPresenter = PresenterManager.getInstance().getUserPresenter();
    }

    @Override
    protected void initListener() {
        super.initListener();
        mUserTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userLoginOrName){
                    //有名字就点击无效
                    LogUtils.d(UserFragment.this,"onClick login="+getAppContext());
                    startActivity(new Intent(getContext(), UserLoginActivity.class));

                }
            }
        });

        mUserCollectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), UserCollectActivity.class));
            }
        });

        mUserInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getContext(),UserInfoActivity.class));
            }
        });
    }

}
