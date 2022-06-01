package com.program.wanandroiddemo.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseActivity;
import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.model.domain.SystemArticleList;
import com.program.wanandroiddemo.presenter.ISystemDetailsPresenter;
import com.program.wanandroiddemo.presenter.utils.DataUtils;
import com.program.wanandroiddemo.presenter.utils.GetCollectionIds;
import com.program.wanandroiddemo.ui.adapter.SystemAdapter;
import com.program.wanandroiddemo.ui.adapter.SystemDetailsAdapter;
import com.program.wanandroiddemo.ui.custom.LoadingDialog;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.SizeUtils;
import com.program.wanandroiddemo.utils.ToastUtils;
import com.program.wanandroiddemo.view.ISystemDetailsCallback;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import butterknife.BindView;

public class SystemDetailsActivity extends BaseActivity implements ISystemDetailsCallback, SystemDetailsAdapter.OnTitleItemClickListener {

    @BindView(R.id.system_details_title)
    public TextView mTitle;

    @BindView(R.id.system_details_refresh)
    public SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.system_details_data)
    public RecyclerView mDetailsRv;
    private SystemDetailsAdapter mAdapter;
    private int mId;
    private ISystemDetailsPresenter mSystemDetailsPresenter;
    private LoadingDialog mLoadingDialog;
    private GetCollectionIds mGetCollectionIds;
    private ImageView mView;

    @Override
    protected void initEvent() {
        mAdapter.setOnTitleItemClickListener(this);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (mSystemDetailsPresenter != null) {
                    mSystemDetailsPresenter.getSystemArticle(mId);
                }
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (mSystemDetailsPresenter != null) {
                    mSystemDetailsPresenter.loadMore();
                }
            }
        });
    }

    @Override
    protected void initPresenter() {
        mSystemDetailsPresenter = PresenterManager.getInstance().getSystemDetailsPresenter();
        mSystemDetailsPresenter.registerViewCallback(this);
        mGetCollectionIds = DataUtils.getInstance().getGetCollectionIds();
        mSystemDetailsPresenter.getUserCollection();
        mSystemDetailsPresenter.getSystemArticle(mId);
    }

    @Override
    protected void initView() {
        mLoadingDialog = new LoadingDialog(SystemDetailsActivity.this,R.layout.wait_dialog);
        mLoadingDialog.show();
        Intent intent = getIntent();
        String name = intent.getStringExtra(Constants.TITLE);
        mId = intent.getIntExtra(Constants.ID,0);
        mTitle.setText(name);

        mDetailsRv.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mDetailsRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = SizeUtils.dip2px(SystemDetailsActivity.this, 2f);
                outRect.bottom = SizeUtils.dip2px(SystemDetailsActivity.this, 2f);
                outRect.left = SizeUtils.dip2px(SystemDetailsActivity.this, 2f);
                outRect.right = SizeUtils.dip2px(SystemDetailsActivity.this, 2f);
            }
        });
        mAdapter = new SystemDetailsAdapter();
        mDetailsRv.setAdapter(mAdapter);

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_system_details;
    }

    @Override
    public void onSystemArticleList(SystemArticleList data) {
        mLoadingDialog.dismiss();
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        }
        mAdapter.setData(data.getData().getDatas());
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
    public void onLoaderMoreLoaded(SystemArticleList data) {
        mAdapter.addData(data);
        if (mRefreshLayout != null) {
//            mRefreshLayout.finishLoadmore();
            mRefreshLayout.finishLoadMore();
        }
        ToastUtils.showToast("加载了" + data.getData().getDatas().size() + "条数据");

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
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onItemClick(SystemArticleList.DataBean.DatasBean datasBean) {
        Intent intent = new Intent(BaseApplication.getAppContext(), DetailsActivity.class);
        intent.putExtra(Constants.LINK,datasBean.getLink());
        intent.putExtra(Constants.TITLE,datasBean.getTitle());
        startActivity(intent);
    }

    @Override
    public void onCollectItemClick(ImageView view, SystemArticleList.DataBean.DatasBean datasBean) {
        mSystemDetailsPresenter.CollectArticle(datasBean.getId());
        this.mView = view;
    }

    @Override
    public void onUnCollectItemClick(ImageView view, SystemArticleList.DataBean.DatasBean datasBean) {
        mSystemDetailsPresenter.unCollect(datasBean.getId(),datasBean.getId());
        this.mView=view;
    }
}