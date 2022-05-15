package com.program.wanandroiddemo.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.model.domain.CollectionArticle;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionArticleAdapter extends RecyclerView.Adapter<CollectionArticleAdapter.InnerHolder> {
    private List<CollectionArticle.DataBean.DatasBean> mData=new ArrayList<>();
    private OnCollectionAdapterItemClickListener mContentItemClickListener=null;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new CollectionArticleAdapter.InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        CollectionArticle.DataBean.DatasBean datasBean = mData.get(position);
        LogUtils.d("DEBUG","data==="+mData);
        holder.setDataArticle(datasBean);

        holder.mDataLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContentItemClickListener != null) {
                    mContentItemClickListener.onArticleItemClick(datasBean);
                }
            }
        });

        holder.mLoveIv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt(holder.mLoveIv.getTag()+"");
                LogUtils.d(CollectionArticle.class,"image tag =="+tag+"  ?   image "+R.mipmap.collect_press+"  int max"+Integer.MAX_VALUE);
                LogUtils.d(CollectionArticle.class,"isCollection(tag)=="+isCollection(tag));
                if (isCollection(tag)){
                    if (mContentItemClickListener!=null){
                        mContentItemClickListener.onUnCollectItemClick((ImageView) v,datasBean);
                    }
                }else {
                    if (mContentItemClickListener!=null){
                        mContentItemClickListener.onCollectItemClick((ImageView) v,datasBean);
                    }
                }
            }

        });
    }

    private boolean isCollection(int tag) {
        return tag==R.mipmap.collect_press;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setDataArticle(CollectionArticle data){
        this.mData.clear();
        this.mData.addAll(data.getData().getDatas());
        notifyDataSetChanged();
    }



    public class InnerHolder extends RecyclerView.ViewHolder {

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

        //文章基本信息
        @BindView(R.id.article_data)
        public LinearLayout mDataLayout;
        //文章标题
        @BindView(R.id.article_title)
        public TextView ArticleTitleTv;
        //文章作者
        @BindView(R.id.author_or_shareuser)
        public TextView authorTv;
        //分类
        @BindView(R.id.article_sort)
        public TextView sortTv;
        //发布时间
        @BindView(R.id.article_time)
        public TextView timeTv;

        @BindView(R.id.article_icon)
        public ImageView mLoveIv;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setDataArticle(CollectionArticle.DataBean.DatasBean data) {
            LogUtils.d(CollectionArticle.class,"data ="+data);
            ArticleTitleTv.setText(data.getTitle());
            authorTv.setText(data.getAuthor());
//            sortTv.setVisibility(View.GONE);
            long time = data.getPublishTime();
            timeTv.setText(longTime2String(time));
            mLoveIv.setImageResource(R.mipmap.collect_press);
            mLoveIv.setTag(R.mipmap.collect_press);
        }

        private String longTime2String(long time){
            Date date = new Date(time);
            return sdf.format(date);
        }


    }

    public void setOnRecommendTitleItemClickListener(OnCollectionAdapterItemClickListener listener){
        this.mContentItemClickListener = listener;
    }

    public interface OnCollectionAdapterItemClickListener{
        /**
         * 文章item点击事件
         * @param data
         */
        void onArticleItemClick(CollectionArticle.DataBean.DatasBean data);

        /**
         * 收藏点击事件
         */
        void onCollectItemClick(ImageView view, CollectionArticle.DataBean.DatasBean data);

        /**
         * 取消收藏点击事件
         * @param data
         */
        void onUnCollectItemClick(ImageView view,CollectionArticle.DataBean.DatasBean data);

    }
}
