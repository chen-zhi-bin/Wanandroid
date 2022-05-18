package com.program.wanandroiddemo.presenter.Impl;

import android.app.Activity;
import android.content.Context;
import android.os.Message;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.model.Api;
import com.program.wanandroiddemo.model.domain.UserInformation;
import com.program.wanandroiddemo.presenter.IUserLoginPresenter;
import com.program.wanandroiddemo.presenter.utils.DataUtils;
import com.program.wanandroiddemo.presenter.utils.GetCollectionIds;
import com.program.wanandroiddemo.ui.custom.LoadingDialog;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.RetrofitManager;
import com.program.wanandroiddemo.utils.SharedPreferencesUtils;
import com.program.wanandroiddemo.utils.ToastUtils;
import com.program.wanandroiddemo.view.ILoginCallback;

import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginPresenterImpl implements IUserLoginPresenter {

    private final Api mApi;
    private ILoginCallback mUserCallback;
    private Activity mDialogActivity;
    private final GetCollectionIds mGetCollectionIds;


    public UserLoginPresenterImpl(){
        mApi = RetrofitManager.getInstence().getApi();
        mGetCollectionIds = DataUtils.getInstance().getGetCollectionIds();
    }

    @Override
    public void setDialogActivity(Activity activity){
        this.mDialogActivity=activity;
    }

    @Override
    public void getUserLogin(String name,String psw,Context context) {

//        LogUtils.d(UserPresenterImpl.this,"context asdasda=="+(Activity)context);

//        com.dyhdyh.widget.loading.dialog.LoadingDialog.make(mDialogActivity)
//                .setMessage("正在登录")
//                .show();

        LoadingDialog loadingDialog = new LoadingDialog(mDialogActivity,R.layout.wait_dialog);
        loadingDialog.show();

        SharedPreferencesUtils sp = SharedPreferencesUtils.getInstance(context);

        LogUtils.d(UserLoginPresenterImpl.this,"正在登录....Impl");
        Call<UserInformation> task = mApi.getUserLogin(name, psw);

        task.enqueue(new Callback<UserInformation>() {
            @Override
            public void onResponse(Call<UserInformation> call, Response<UserInformation> response) {
                int code = response.code();
                LogUtils.d(UserLoginPresenterImpl.this,"longin result code =="+code);
                UserInformation data = response.body();
                if (code== HttpURLConnection.HTTP_OK&&data.getErrorCode()!=-1){
                    LogUtils.d(UserLoginPresenterImpl.this,"body="+response.body());
                    Headers headers = response.headers();
                    Map<String, List<String>> stringListMap = headers.toMultimap();
                    List<String> strings = stringListMap.get("set-cookie");
                    String token = "";
                    String time="";
                    for (String string : strings) {
                        token +=string;
                        if (string.contains("loginUserName=")){
                            time+=string;
                        }
                    }

                    //保存token时效
                    //loginUserName=speak_dream; Expires=Sat, 11-Jun-2022 13:04:31 GMT; Path=/
                    LogUtils.d(UserLoginPresenterImpl.this,"token_cookie_time"+time);
                    String tiemData=time.substring(time.indexOf(",")+2,time.indexOf(",")+22);
                    if (time.indexOf(",")!=-1){
                        LogUtils.d(UserLoginPresenterImpl.this,"token_time====="+tiemData);
                    }
                    DateFormat Gmt = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss",Locale.ENGLISH);
                    try {
                        long saveTime = Gmt.parse(tiemData).getTime();
                        LogUtils.d(UserLoginPresenterImpl.this,"token_time=="+saveTime);
                        sp.putString(SharedPreferencesUtils.USER_TOKEN_COOKIE_TIME,saveTime+"");
                    } catch (ParseException e) {
                        e.printStackTrace();

                    }



                    UserInformation userData = response.body();
                    sp.putString(SharedPreferencesUtils.USER_TOKEN_COOKIE,token);
                    sp.putString(SharedPreferencesUtils.USER_NAME,userData.getData().getNickname());
                    sp.putString(SharedPreferencesUtils.NEED_REFRESH,SharedPreferencesUtils.NEED_REFRESH);

                    mGetCollectionIds.setIds(data.getData().getCollectIds());

                    ToastUtils.showToast("登录成功");
                    mUserCallback.onResultLogin();
                }else {
                    ToastUtils.showToast("登录失败,"+response.body().getErrorMsg());
                }
//                LoadingDialog.cancel();
                loadingDialog.dismiss();

            }

            @Override
            public void onFailure(Call<UserInformation> call, Throwable t) {
                LogUtils.d(UserLoginPresenterImpl.this,"登录失败...Impl..."+t.getMessage());
                ToastUtils.showToast("登录失败，网络错误");
//                LoadingDialog.cancel();
                loadingDialog.dismiss();
            }
        });

    }




    @Override
    public void registerViewCallback(ILoginCallback callback) {
        this.mUserCallback = callback;
    }

    @Override
    public void unregisterViewCallback() {
        this.mUserCallback=null;
    }
}
