package com.program.wanandroiddemo.presenter;

import android.app.Activity;

import com.program.wanandroiddemo.base.IBasePresenter;
import com.program.wanandroiddemo.view.IUserCallback;

public interface IUserPresenter extends IBasePresenter<IUserCallback> {

    /**
     * 登出
     */
    void getUserLoginout();

    /**
     * 设置activity，用于使用dialog(dialog的上下文必须是活动)
     * @param activity
     */
    void setDialogActivity(Activity activity);

    void getUserInfo();
}
