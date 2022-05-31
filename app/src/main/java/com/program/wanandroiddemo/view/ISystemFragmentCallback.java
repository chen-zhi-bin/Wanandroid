package com.program.wanandroiddemo.view;

import com.program.wanandroiddemo.base.IBaseCallback;
import com.program.wanandroiddemo.model.domain.SystemCategories;

public interface ISystemFragmentCallback extends IBaseCallback {

    void onSystemCategories(SystemCategories data);

}
