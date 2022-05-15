package com.program.wanandroiddemo.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseFragment;

public class SystemFragment extends BaseFragment {

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_system;
    }

    //显示
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
    }
}
