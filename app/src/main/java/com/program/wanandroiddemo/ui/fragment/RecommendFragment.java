package com.program.wanandroiddemo.ui.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseActivity;
import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.base.BaseFragment;
import com.program.wanandroiddemo.model.domain.CollectionArticle;
import com.program.wanandroiddemo.model.domain.RecommendTitle;
import com.program.wanandroiddemo.presenter.IRecommendTitlePresenter;
import com.program.wanandroiddemo.presenter.utils.DataUtils;
import com.program.wanandroiddemo.presenter.utils.GetCollectionIds;
import com.program.wanandroiddemo.ui.activity.DetailsActivity;
import com.program.wanandroiddemo.ui.adapter.RecommendAdapter;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.SharedPreferencesUtils;
import com.program.wanandroiddemo.utils.SizeUtils;
import com.program.wanandroiddemo.utils.ToastUtils;
import com.program.wanandroiddemo.view.IRecommendTitleCallback;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

public class RecommendFragment extends BaseFragment implements IRecommendTitleCallback, RecommendAdapter.OnRecommendTitleItemClickListener {

    @BindView(R.id.home_recommend_title)
    public RecyclerView mContentRv;

    @BindView(R.id.fragment_bar_title_tv)
    public TextView barTitleTv;

    @BindView(R.id.recommend_refresh)
    public SmartRefreshLayout mRefreshLayout;
//    public TwinklingRefreshLayout mRefreshLayout;


    private RecommendAdapter mRecommendAdapter;
    private IRecommendTitlePresenter mRecommendTitlePresenter;
    private GetCollectionIds mGetCollectionIds;
    private ImageView mView;


    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_with_bar_layout, container, false);
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

//        mRefreshLayout.setEnableLoadmore(true);
//        mRefreshLayout.setEnableRefresh(true);


    }

    @Override
    protected void initPresenter() {
        super.initPresenter();
        mRecommendTitlePresenter = PresenterManager.getInstance().getRecommendTitlePresenter();
        mRecommendTitlePresenter.registerViewCallback(this);
        mGetCollectionIds = DataUtils.getInstance().getGetCollectionIds();

    }


    @Override
    protected void loadData() {
        super.loadData();
        //加载数据
        mRecommendTitlePresenter.getUserCollection();
//        mRecommendTitlePresenter.getRecommendTitle();
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRecommendAdapter.setOnRecommendTitleItemClickListener(this);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (mRecommendTitlePresenter != null) {
                    mRecommendTitlePresenter.getUserCollection();
                }
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (mRecommendTitlePresenter != null) {
                    mRecommendTitlePresenter.loadMore();
                }
            }
        });
//        mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
//            @Override
//            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
//                super.onLoadMore(refreshLayout);
//                if (mRecommendTitlePresenter != null) {
//                    mRecommendTitlePresenter.loadMore();
//                }
//            }
//
//            @Override
//            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
//                super.onRefresh(refreshLayout);
//                if (mRecommendTitlePresenter != null) {
//                    mRecommendTitlePresenter.getUserCollection();
//                }
//            }
//        });
    }


    @Override
    public void onResume() {
        super.onResume();
        boolean needRefresh = mRecommendTitlePresenter.needRefresh();
        LogUtils.d(RecommendFragment.this, "str boolean =" + needRefresh);
        if (needRefresh) {
            loadData();

        }
        LogUtils.d(RecommendFragment.this, "onResume");
    }

    @Override
    protected void relese() {
        super.relese();
        if (mRecommendTitlePresenter != null) {
            mRecommendTitlePresenter.unregisterViewCallback();
        }
    }

    private boolean isFrist = true;

    @Override
    public void onContentLoadedSuccess(RecommendTitle content) {
        //数据回来
        setupState(State.SUCCESS);
        LogUtils.d(RecommendFragment.this, "is frist =" + isFrist);
        if (mRefreshLayout != null && !isFrist) {
            ToastUtils.showToast("刷新成功");
//            mRefreshLayout.finishRefreshing();
            mRefreshLayout.finishRefresh();
        }
        LogUtils.d(RecommendFragment.this, "onContentLoadedSuccess");
        isFrist = false;
        //更新ui
        mRecommendAdapter.setCollectionData(mGetCollectionIds.getIds());
        mRecommendAdapter.setData(content);
    }

    @Override
    public void onLoaderMoreError() {
        ToastUtils.showToast("网络异常，请稍后重试");
        if (mRefreshLayout != null) {
//            mRefreshLayout.finishLoadmore();
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void onLoaderMoreEmpty() {
        ToastUtils.showToast("没有有更多数据了");
        if (mRefreshLayout != null) {
//            mRefreshLayout.finishLoadmore();
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void onLoaderMoreLoaded(RecommendTitle data) {
        mRecommendAdapter.addData(data);
        if (mRefreshLayout != null) {
//            mRefreshLayout.finishLoadmore();
            mRefreshLayout.finishLoadMore();
        }
        ToastUtils.showToast("加载了" + data.getData().getDatas().size() + "条数据");
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
        int tag = Integer.parseInt(mView.getTag()+"");
        if (tag==R.mipmap.collect_normal){
            mView.setImageResource(Constants.BULE_LOVE);
            mView.setTag(Constants.BULE_LOVE);
            ToastUtils.showToast("收藏成功");
        }
    }

    @Override
    public void onCollectError() {
        int tag = Integer.parseInt(mView.getTag()+"");
        if (tag==R.mipmap.collect_normal){
            mView.setImageResource(Constants.WHITE_LOVE);
            mView.setTag(Constants.WHITE_LOVE);
            ToastUtils.showToast("收藏失败,请检查登录情况");
        }
    }

    @Override
    public void onSendUnCollectionSuccess() {
        int tag = Integer.parseInt(mView.getTag()+"");
        if (tag==R.mipmap.collect_press){
            mView.setImageResource(Constants.WHITE_LOVE);
            mView.setTag(Constants.WHITE_LOVE);
            ToastUtils.showToast("已取消收藏");
        }
    }

    @Override
    public void onSendUnCollectionError() {
        int tag = Integer.parseInt(mView.getTag()+"");
        if (tag==R.mipmap.collect_press){
            mView.setImageResource(Constants.BULE_LOVE);
            mView.setTag(Constants.BULE_LOVE);
            ToastUtils.showToast("网络错误，取消收藏失败");
        }

    }

    @Override
    public void onItemClick(RecommendTitle.DataBean.DatasBean data) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(Constants.TITLE, data.getTitle());
        intent.putExtra(Constants.LINK, data.getLink());
        startActivity(intent);
    }

    @Override
    public void onCollectItemClick(ImageView view, RecommendTitle.DataBean.DatasBean data) {
        mRecommendTitlePresenter.CollectArticle(data.getId());
        this.mView = view;
    }

    @Override
    public void onUnCollectItemClick(ImageView view, RecommendTitle.DataBean.DatasBean data) {
        mRecommendTitlePresenter.unCollect(data.getId(),data.getId());
        this.mView=view;
    }
}
