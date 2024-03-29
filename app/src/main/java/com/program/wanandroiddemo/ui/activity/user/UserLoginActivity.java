package com.program.wanandroiddemo.ui.activity.user;


import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseActivity;
import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.presenter.IUserLoginPresenter;
import com.program.wanandroiddemo.ui.activity.MainActivity;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.ToastUtils;
import com.program.wanandroiddemo.view.ILoginCallback;

import butterknife.BindView;

public class UserLoginActivity extends BaseActivity implements ILoginCallback {


    private IUserLoginPresenter mLoginPresenter;
    @BindView(R.id.username)
    public EditText mName;
    @BindView(R.id.password)
    public EditText mPsw;
    @BindView(R.id.user_login_btn)
    public TextView mLoginBtn;
    private Context mContext;
    private boolean isNameOk = false;
    private boolean isPswOk = false;

    @Override
    protected void initPresenter() {
        mLoginPresenter = PresenterManager.getInstance().getUserPresenter();
        mLoginPresenter.setDialogActivity(this);
        mLoginPresenter.registerViewCallback(this);
    }

    @Override
    protected void initView() {
        mContext =BaseApplication.getAppContext();
        LogUtils.d(UserLoginActivity.this,"context =="+ mContext);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.user_login;
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        initListener();
        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isNameOk=s.length()>0;
                upState();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPsw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isPswOk=s.length()>0;
                upState();
            }

            @Override
            public void afterTextChanged(Editable s) {
                isPswOk=s.length()==0;
            }
        });
    }

    private void upState() {
        if (isNameOk&&isPswOk){
            mLoginBtn.setBackgroundColor(getResources().getColor(R.color.teal_200));
        }else {
            mLoginBtn.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    private void initListener() {
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString().trim();
                String psw = mPsw.getText().toString().trim();
                if (name.length()==0||psw.length()==0){
                    ToastUtils.showToast("输入的账号或密码不能为空");
                }else {
                    mLoginPresenter.getUserLogin(name, psw, mContext);
                    LogUtils.d(UserLoginActivity.this,"正在登录");
                }
            }
        });
    }



    @Override
    public void onResultLogin() {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        this.finish();
    }

    @Override
    public void onBackPressed() {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        this.finish();
    }
}
