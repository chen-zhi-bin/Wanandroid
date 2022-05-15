package com.program.wanandroiddemo.ui.activity.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ldoublem.loadingviewlib.view.LVCircularRing;
import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.model.Api;
import com.program.wanandroiddemo.model.domain.CollectionArticle;
import com.program.wanandroiddemo.model.domain.UserInformation;
import com.program.wanandroiddemo.ui.custom.CollectDialog;
import com.program.wanandroiddemo.ui.custom.LoadingDialog;
import com.program.wanandroiddemo.ui.custom.LoadingView;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.ProgramConfigManage;
import com.program.wanandroiddemo.utils.RetrofitManager;
import com.program.wanandroiddemo.utils.SharedPreferencesUtils;
import com.program.wanandroiddemo.utils.UrlUitl;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity implements CollectDialog.OnCenterItemClickListener{

    @BindView(R.id.test_result)
    public TextView res;
    @BindView(R.id.test_login)
    public TextView login;
    @BindView(R.id.test_shu)
    public TextView mshu;

    @BindView(R.id.test_layout)
    public View mParent;
    @BindView(R.id.test_ring)
    public LVCircularRing mLVCircularRing;

    @BindView(R.id.test_collect)
    public FloatingActionButton mFloatingActionButton;

    private Headers mHeaders;
    private String mToken;
    private SharedPreferencesUtils mSharedPreferencesUtils;
    private ProgramConfigManage mProgramConfigManage;
    private CollectDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        initView();
        initListener();

//        mLVCircularRing.setViewColor(Color.argb(10, 255, 255, 255));
        mLVCircularRing.setBarColor(Color.BLACK);
        mLVCircularRing.startAnim();
//        loading version 1.X
//         LoadingBar.make(mParent).show();
//
//        LoadingBar.cancel(mParent);
    }

    private void initView() {
        mDialog = new CollectDialog(TestActivity.this);
        mDialog.setOnCenterItemClickListener((CollectDialog.OnCenterItemClickListener) this);
    }


    private void initListener() {
        Context applicationContext = getApplicationContext();
        Api api = RetrofitManager.getInstence().getApi();

        LogUtils.d(TestActivity.this,"context,applicationContext=="+ applicationContext.toString()+","+BaseApplication.getAppContext());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingDialog loadingDialog = new LoadingDialog(TestActivity.this, R.layout.wait_dialog);
                loadingDialog.show();
                Call<UserInformation> task = api.getUserLogin("speak_dream", "wanandroid");
                task.enqueue(new Callback<UserInformation>() {
                    @Override
                    public void onResponse(Call<UserInformation> call, Response<UserInformation> response) {
                        LogUtils.d(TestActivity.this,"code=="+response.code());
                        UserInformation body = response.body();
                        mHeaders = response.headers();
                        Map<String, List<String>> stringListMap = mHeaders.toMultimap();
                        List<String> strings = stringListMap.get("set-cookie");
                        mToken = "";
                        for (String string : strings) {
                            mToken +=string;
                        }
                        LogUtils.d(TestActivity.this,"res cookie--->"+ mToken);

//                        mProgramConfigManage = ProgramConfigManage.GetInstance(getBaseContext());
//                        mProgramConfigManage.setString(ProgramConfigManage.SP_USER_LOGIN_TOKEN,mToken);
                        SharedPreferencesUtils instance = SharedPreferencesUtils.getInstance(getBaseContext());
                        instance.putString(SharedPreferencesUtils.USER_TOKEN_COOKIE,mToken);
                        LogUtils.d(TestActivity.this,"mToken=="+mToken);
                       loadingDialog.dismiss();
//                        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance();
//                        mSharedPreferencesUtils.putString(SharedPreferencesUtils.USER_TOKEN_COOKIE,mToken);

//                        LogUtils.d(TestActivity.this,"headers is ==>"+ mHeaders);
//                        LogUtils.d(TestActivity.this,"============================");
//
//                        String s = response.headers().get("Set-Cookie");
//                        LogUtils.d(TestActivity.this,"Set-Cookie:++==>\n"+s.toString());
//
//                        LogUtils.d(TestActivity.this,"body =="+body);
//                        ToastUtils.showToast("登录成功");
                    }

                    @Override
                    public void onFailure(Call<UserInformation> call, Throwable t) {
                        LogUtils.d(this,"error t-->"+t.getMessage());
                    }
                });
            }
        });

        mshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String token = mSharedPreferencesUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
                LogUtils.d(TestActivity.this,"getString");
//                String token = mProgramConfigManage.getString(ProgramConfigManage.SP_USER_LOGIN_TOKEN);
                SharedPreferencesUtils instance = SharedPreferencesUtils.getInstance(getBaseContext());
                String token = instance.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
//                LogUtils.d(TestActivity.this,"token=="+token);
                Call<CollectionArticle> task = api.getUserCollection(UrlUitl.getCollectionList(0),token);
//                        "loginUserName_wanandroid_com=speak_dream;" +
//                                " token_pass_wanandroid_com=7c934a41fee93d67b5bcc9c25d498f48; " +
//                                "JSESSIONID=778F0AB5255709B8F31027EFDA23C7A2; " +
//                                "loginUserName=speak_dream; " +
//                                "token_pass=7c934a41fee93d67b5bcc9c25d498f48"
                task.enqueue(new Callback<CollectionArticle>() {
                    @Override
                    public void onResponse(Call<CollectionArticle> call, Response<CollectionArticle> response) {
                        CollectionArticle body = response.body();
                        LogUtils.d(TestActivity.this,"res=="+body);

                        LogUtils.d(TestActivity.this,"desc=="+body.getData().getDatas());

                        res.setText(body.toString());

                    }

                    @Override
                    public void onFailure(Call<CollectionArticle> call, Throwable t) {
                        LogUtils.d(TestActivity.this,"error   t-->"+t.getMessage());

                    }
                });
            }
        });

        int choice;
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.show();

                //设置dialog当前属性
                Window dialogWindow = mDialog.getWindow();
                WindowManager.LayoutParams attributes = dialogWindow.getAttributes();
                attributes.alpha=0.8f;
                attributes.dimAmount=0.5f;
                dialogWindow.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialogWindow.setAttributes(attributes);
            }
        });

    }


//    R.id.dialog_collect_article,    //单选--文章
//    R.id.dialog_collect_web,        //单选--web
//    R.id.dialog_collect_title,      //标题
//    R.id.dialog_collect_author,     //作者
//    R.id.dialog_collect_link,       //url
//    R.id.dialog_cancel_btn,         //取消按钮
//    R.id.dialog_sure_btn            //确定

    int choice=1;
    @SuppressLint("NonConstantResourceId")
    @Override
    public void OnCenterItemClick(CollectDialog dialog, View view) {
            switch (view.getId()){
                case R.id.dialog_collect_article:
//                    LogUtils.d(TestActivity.this,"dialog =="+dialog.mArticleBtn);
                    dialog.mAuthor.setVisibility(View.VISIBLE);
                    choice=Constants.DIALOG_CHOICE_ARTICLE;
                    break;
                case R.id.dialog_collect_web:
                    dialog.mAuthor.setVisibility(View.GONE);
                    choice=Constants.DIALOG_CHOICE_WEB;
                    break;
                case R.id.dialog_collect_title:
                    break;
                case R.id.dialog_collect_author:
                    break;
                case R.id.dialog_collect_link:
                    break;
                case R.id.dialog_cancel_btn:
                    mDialog.dismiss();
                    break;
                case R.id.dialog_sure_btn:
                    if (choice==2){
                        String title = dialog.mTitle.getText().toString().trim();
                        String link = dialog.mLink.getText().toString().trim();
                        LogUtils.d(TestActivity.this,"title=="+title+"//"+"link=="+link);
                    }
                    break;
            }
    }
}