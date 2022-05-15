package com.program.wanandroiddemo.presenter;

import android.app.Activity;
import android.content.Context;

import com.program.wanandroiddemo.base.IBasePresenter;
import com.program.wanandroiddemo.view.ILoginCallback;

public interface IUserLoginPresenter extends IBasePresenter<ILoginCallback> {
    /**
     * 登录
     * @param name 账号
     * @param psw  密码
     * @param context   用于持久化存储的上下文
     */
    void getUserLogin(String name, String psw, Context context);

    /**
     * 设置activity，用于使用dialog(dialog的上下文必须是活动)
     * @param activity
     */
    void setDialogActivity(Activity activity);


}
