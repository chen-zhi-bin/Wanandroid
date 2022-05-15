package com.program.wanandroiddemo.ui.fragment.userCollection;

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
import com.program.wanandroiddemo.model.domain.CollectionArticle;
import com.program.wanandroiddemo.presenter.IUserCollectionArticlePresenter;
import com.program.wanandroiddemo.ui.activity.DetailsActivity;
import com.program.wanandroiddemo.ui.adapter.CollectionArticleAdapter;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.SizeUtils;
import com.program.wanandroiddemo.utils.ToastUtils;
import com.program.wanandroiddemo.view.IUserCollectionArticleCallback;

import butterknife.BindView;

public class UserArticleCollectionFragment extends BaseFragment implements IUserCollectionArticleCallback, CollectionArticleAdapter.OnCollectionAdapterItemClickListener {

    @BindView(R.id.collect_article)
    public RecyclerView mArticleRv;
    private IUserCollectionArticlePresenter mUserCollectionPresenter=null;
    private CollectionArticleAdapter mCollectionAdapter;
    private ImageView mview;  //主要用于取消收藏失败的处理

    @Override
    protected void initView(View rootView) {
        setupState(State.SUCCESS);
        //设置LayoutManager,不然不显示数据
        mArticleRv.setLayoutManager(new LinearLayoutManager(BaseApplication.getAppContext()));
        mCollectionAdapter = new CollectionArticleAdapter();
        mArticleRv.setAdapter(mCollectionAdapter);
        mArticleRv.addItemDecoration(new RecyclerView.ItemDecoration() {
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
        return R.layout.fragment_user_collection_article;
    }

    @Override
    protected void initPresenter() {
        super.initPresenter();
        mUserCollectionPresenter = PresenterManager.getInstance().getUserCollectionPresenter();
        mUserCollectionPresenter.registerViewCallback(this);
        mUserCollectionPresenter.getCollectionArticle();
    }

    @Override
    protected void initListener() {
        super.initListener();
        mCollectionAdapter.setOnRecommendTitleItemClickListener(this);
    }

    @Override
    public void onUserCollectionArticle(CollectionArticle collectionList) {
        setupState(State.SUCCESS);
         mCollectionAdapter.setDataArticle(collectionList);
    }


    @Override
    public void onSendUnCollectionSuccess() {
        int tag = Integer.parseInt(mview.getTag()+"");
        if (tag==R.mipmap.collect_press){
            mview.setImageResource(Constants.WHITE_LOVE);
            mview.setTag(Constants.WHITE_LOVE);
            ToastUtils.showToast("已取消收藏");
        }
    }

    @Override
    public void onSendUnCollectionError() {
        int tag = Integer.parseInt(mview.getTag()+"");
        if (tag==R.mipmap.collect_press){
            mview.setImageResource(Constants.BULE_LOVE);
            mview.setTag(Constants.BULE_LOVE);
            ToastUtils.showToast("网络错误，取消收藏失败");
        }

    }

    @Override
    protected void relese() {
        super.relese();
        if (mUserCollectionPresenter != null) {
            mUserCollectionPresenter.unregisterViewCallback();

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
    public void onCollectSuccess() {
        int tag = Integer.parseInt(mview.getTag()+"");
        if (tag==R.mipmap.collect_normal){
            mview.setImageResource(Constants.BULE_LOVE);
            mview.setTag(Constants.BULE_LOVE);
            ToastUtils.showToast("收藏成功");
        }
    }

    @Override
    public void onCollectError() {
        int tag = Integer.parseInt(mview.getTag()+"");
        if (tag==R.mipmap.collect_normal){
            mview.setImageResource(Constants.WHITE_LOVE);
            mview.setTag(Constants.WHITE_LOVE);
            ToastUtils.showToast("收藏失败");
        }
    }


    @Override
    public void onArticleItemClick(CollectionArticle.DataBean.DatasBean data) {
        Intent intent = new Intent(BaseApplication.getAppContext(), DetailsActivity.class);
        intent.putExtra(Constants.TITLE,data.getTitle());
        intent.putExtra(Constants.LINK,data.getLink());
        startActivity(intent);
    }

    @Override
    public void onCollectItemClick(ImageView view,CollectionArticle.DataBean.DatasBean data) {

        LogUtils.d(UserArticleCollectionFragment.class,"id == "+data.getId()+"title ="+data.getTitle()+"link = "+data.getLink()+"author = "+data.getAuthor());
    mUserCollectionPresenter.CollectArticle(data.getOriginId());
    this.mview = view;
    }

    @Override
    public void onUnCollectItemClick(ImageView view,CollectionArticle.DataBean.DatasBean data) {
        mUserCollectionPresenter.unCollect(data.getId(),data.getOriginId());
        this.mview = view;
    }
}
