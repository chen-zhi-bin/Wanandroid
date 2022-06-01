package com.program.wanandroiddemo.ui.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.base.BaseFragment;
import com.program.wanandroiddemo.model.domain.SystemCategories;
import com.program.wanandroiddemo.presenter.ISystemFragmentPresenter;
import com.program.wanandroiddemo.ui.activity.SystemDetailsActivity;
import com.program.wanandroiddemo.ui.adapter.SystemAdapter;
import com.program.wanandroiddemo.ui.custom.FlowTextLayout;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.SizeUtils;
import com.program.wanandroiddemo.view.ISystemFragmentCallback;

import butterknife.BindView;

public class SystemFragment extends BaseFragment implements ISystemFragmentCallback, SystemAdapter.OnSystemItemClickListener {

    @BindView(R.id.system_recyclerview)
    public RecyclerView mRecyclerView;
    private SystemAdapter mAdapter;

    @BindView(R.id.fragment_bar_title_tv)
    public TextView barTitleTv;
    private ISystemFragmentPresenter mSystemFragmentPresenter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_system;
    }


    @Override
    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_with_bar_layout, container, false);
    }

    //显示
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
        barTitleTv.setText("体系");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mAdapter = new SystemAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = SizeUtils.dip2px(getContext(), 2f);
                outRect.bottom = SizeUtils.dip2px(getContext(), 2f);
                outRect.left = SizeUtils.dip2px(getContext(), 2f);
                outRect.right = SizeUtils.dip2px(getContext(), 2f);
            }
        });
    }

    @Override
    protected void initListener() {
        mAdapter.setOnSystemItemClickListener(this);
    }

    @Override
    protected void initPresenter() {
        mSystemFragmentPresenter = PresenterManager.getInstance().getSystemFragmentPresenter();
        mSystemFragmentPresenter.registerViewCallback(this);
    }

    @Override
    protected void loadData() {
        setupState(State.LOADING);
        mSystemFragmentPresenter.getSystem();
    }

    @Override
    public void onSystemCategories(SystemCategories data) {
        mAdapter.setData(data.getData());
        setupState(State.SUCCESS);
    }


    @Override
    public void onError() {
        setupState(State.ERROR);
    }

    @Override
    public void onLoading() {
        setupState(State.LOADING);
    }

    @Override
    public void onEmpty() {
        setupState(State.EMPTY);
    }

    @Override
    public void systemItemClick(String name, int id) {
        Intent intent = new Intent(BaseApplication.getAppContext(), SystemDetailsActivity.class);
        intent.putExtra(Constants.TITLE,name);
        intent.putExtra(Constants.ID,id);
        startActivity(intent);
    }
}
