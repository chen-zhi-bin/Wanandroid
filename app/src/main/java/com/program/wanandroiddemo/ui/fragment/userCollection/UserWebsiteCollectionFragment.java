package com.program.wanandroiddemo.ui.fragment.userCollection;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.base.BaseFragment;
import com.program.wanandroiddemo.model.domain.CollectionWebsite;
import com.program.wanandroiddemo.presenter.IUserCollectionWebPresentere;
import com.program.wanandroiddemo.ui.activity.DetailsActivity;
import com.program.wanandroiddemo.ui.adapter.CollectionWebAdapter;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.SizeUtils;
import com.program.wanandroiddemo.utils.ToastUtils;
import com.program.wanandroiddemo.view.IUserCollectionWebCallback;

import butterknife.BindView;

public class UserWebsiteCollectionFragment extends BaseFragment implements IUserCollectionWebCallback, CollectionWebAdapter.OnCollectionWebItemCClickListener {

    @BindView(R.id.collect_web)
    public RecyclerView mWebRv;
    private CollectionWebAdapter mCollectionAdapter;
    private IUserCollectionWebPresentere mUserCollectionWebPresentere =null;
    private ImageView mView; //主要用于取消收藏失败的处理

    @Override
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
        //设置LayoutManager,不然不显示数据
        mWebRv.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mCollectionAdapter = new CollectionWebAdapter();
        mWebRv.setAdapter(mCollectionAdapter);
        mWebRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = SizeUtils.dip2px(getContext(), 2.5f);
                outRect.bottom = SizeUtils.dip2px(getContext(), 2.5f);
                outRect.left = SizeUtils.dip2px(getContext(), 2.5f);
                outRect.right = SizeUtils.dip2px(getContext(), 2.5f);
            }
        });
    }

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_user_collection_website;
    }


    @Override
    protected void initPresenter() {
        super.initPresenter();
        mUserCollectionWebPresentere = PresenterManager.getInstance().getUserCollectionWeb();
        mUserCollectionWebPresentere.registerViewCallback(this);
        mUserCollectionWebPresentere.getCollectionWeb();

    }

    @Override
    protected void initListener() {
        super.initListener();
        mCollectionAdapter.setOnCollectionWebItemCClickListener(this);
    }

    @Override
    public void onCollectionWeb(CollectionWebsite data) {
        setupState(State.SUCCESS);
        mCollectionAdapter.setData(data);
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
            ToastUtils.showToast("收藏失败");
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
    protected void relese() {
        super.relese();
        if (mUserCollectionWebPresentere != null) {
            mUserCollectionWebPresentere.unregisterViewCallback();

        }
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
    public void onWebItemClick(CollectionWebsite.DataBean dataBean) {
        //收藏网页item被点击
        Intent intent = new Intent(BaseApplication.getAppContext(), DetailsActivity.class);
        intent.putExtra(Constants.TITLE,dataBean.getName());
        intent.putExtra(Constants.LINK,dataBean.getLink());
        startActivity(intent);
    }

    @Override
    public void onCollectionClick(ImageView view, CollectionWebsite.DataBean dataBean) {
        mUserCollectionWebPresentere.onCollect(dataBean.getName(),dataBean.getLink());
        this.mView=view;
    }

    @Override
    public void onUnCollectClick(ImageView view, CollectionWebsite.DataBean dataBean) {
        mUserCollectionWebPresentere.onUnCollect(dataBean.getId());
        this.mView=view;
    }
}
