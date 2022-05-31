package com.program.wanandroiddemo.presenter;

import com.program.wanandroiddemo.base.IBaseCallback;
import com.program.wanandroiddemo.base.IBasePresenter;
import com.program.wanandroiddemo.view.ISystemFragmentCallback;

public interface ISystemFragmentPresenter extends IBasePresenter<ISystemFragmentCallback> {

    void getSystem();

}
