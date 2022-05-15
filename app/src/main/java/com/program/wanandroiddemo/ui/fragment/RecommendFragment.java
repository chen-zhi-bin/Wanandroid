package com.program.wanandroiddemo.ui.fragment;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseActivity;
import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.base.BaseFragment;
import com.program.wanandroiddemo.model.domain.RecommendTitle;
import com.program.wanandroiddemo.presenter.IRecommendTitlePresenter;
import com.program.wanandroiddemo.presenter.utils.DataUtils;
import com.program.wanandroiddemo.presenter.utils.GetCollectionIds;
import com.program.wanandroiddemo.ui.adapter.RecommendAdapter;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.SizeUtils;
import com.program.wanandroiddemo.view.IRecommendTitleCallback;

import java.util.List;

import butterknife.BindView;

public class RecommendFragment extends BaseFragment implements  IRecommendTitleCallback {

    @BindView(R.id.home_recommend_title)
    public RecyclerView mContentRv;

    @BindView(R.id.fragment_bar_title_tv)
    public TextView barTitleTv;



    private RecommendAdapter mRecommendAdapter;
    private IRecommendTitlePresenter mRecommendTitlePresenter;
    private GetCollectionIds mGetCollectionIds;


    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_with_bar_layout,container,false);
    }

    //显示
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
        //设置LayoutManager,不然不显示数据
        mContentRv.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));

        //设置适配器
        mRecommendAdapter = new RecommendAdapter();
        mContentRv.setAdapter(mRecommendAdapter);
        barTitleTv.setText("推荐");

        mContentRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = SizeUtils.dip2px(getContext(), 2.5f);
                outRect.bottom = SizeUtils.dip2px(getContext(), 2.5f);
                outRect.left = SizeUtils.dip2px(getContext(), 2.5f);
                outRect.right = SizeUtils.dip2px(getContext(), 2.5f);
            }
        });

        mGetCollectionIds = DataUtils.getInstance().getGetCollectionIds();
    }

    @Override
    protected void initPresenter() {
        super.initPresenter();
        mRecommendTitlePresenter = PresenterManager.getInstance().getRecommendTitlePresenter();
        mRecommendTitlePresenter.registerViewCallback(this);
        mRecommendTitlePresenter.getUserCollection();
    }


    @Override
    protected void loadData() {
        super.loadData();
        //加载数据
        mRecommendTitlePresenter.getRecommendTitle();
    }

    @Override
    protected void initListener() {
        super.initListener();

    }

    @Override
    protected void relese() {
        super.relese();
        if (mRecommendTitlePresenter!=null){
            mRecommendTitlePresenter.unregisterViewCallback();
        }
    }

    @Override
    public void onContentLoadedSuccess(RecommendTitle content) {
        //数据回来
        setupState(State.SUCCESS);
        //更新ui
        mRecommendAdapter.setData(content);

        mRecommendAdapter.setCollectionData(mGetCollectionIds.getIds());
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
    public void onCollectSuccess() {

    }

    @Override
    public void onCollectError() {

    }

    @Override
    public void onSendUnCollectionSuccess() {

    }

    @Override
    public void onSendUnCollectionError() {

    }
}
