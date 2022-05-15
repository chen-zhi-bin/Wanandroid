package com.program.wanandroiddemo.view;

import com.program.wanandroiddemo.base.IBaseCallback;
import com.program.wanandroiddemo.model.domain.UserInfo;

public interface IUserCallback extends IBaseCallback {
    /**
     * 设置用户信息
     * @param userInfo
     */
    void onUserInfo(UserInfo userInfo);

    void onResultLoginOut();


}
