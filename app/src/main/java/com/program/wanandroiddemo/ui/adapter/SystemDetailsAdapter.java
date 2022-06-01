package com.program.wanandroiddemo.ui.adapter;

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
import com.program.wanandroiddemo.model.domain.RecommendTitle;
import com.program.wanandroiddemo.model.domain.SystemArticleList;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.SearchUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SystemDetailsAdapter extends RecyclerView.Adapter<SystemDetailsAdapter.InnerHolder> {
    
    private List<SystemArticleList.DataBean.DatasBean> mData = new ArrayList<>();
    private List<Integer> mCollectionIds = new ArrayList<>();
    private OnTitleItemClickListener mContentItemClickListener = null;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        SystemArticleList.DataBean.DatasBean datasBean = mData.get(position);
        holder.setData(datasBean);
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContentItemClickListener != null) {
                    mContentItemClickListener.onItemClick(datasBean);
                }
            }
        });

        holder.mLoveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt(holder.mLoveIv.getTag() + "");
                LogUtils.d(CollectionArticle.class,"image tag =="+tag+"  ?   image "+R.mipmap.collect_press+"  int max"+Integer.MAX_VALUE);
                LogUtils.d(CollectionArticle.class,"isCollection(tag)=="+isCollection(tag));
                if (isCollection(tag)){
                    if (mContentItemClickListener!=null){
                        mContentItemClickListener.onUnCollectItemClick(holder.mLoveIv,datasBean);
                    }
                }else {
                    if (mContentItemClickListener!=null){
                        mContentItemClickListener.onCollectItemClick(holder.mLoveIv,datasBean);
                    }
                }
            }
        });
    }

    private boolean isCollection(int tag) {
        return tag==R.mipmap.collect_press;
    }

    public void setCollectionData(List<Integer> ids){
        if (ids!=null){
            if (ids.size()>=0){
                this.mCollectionIds.clear();
                this.mCollectionIds.addAll(ids);
                notifyDataSetChanged();
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<SystemArticleList.DataBean.DatasBean> datas) {
        this.mData.clear();
        this.mData.addAll(datas);
        notifyDataSetChanged();
    }

    public void addData(SystemArticleList data) {
        int olderSize = mData.size();
        mData.addAll(data.getData().getDatas());
        notifyItemChanged(olderSize,data.getData().getDatas().size());
    }


    public class InnerHolder extends RecyclerView.ViewHolder {

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

        @BindView(R.id.article_data)
        public LinearLayout mLayout;

        @BindView(R.id.item_collect_layout)
        public LinearLayout mLoveLayout;

        @BindView(R.id.article_title)
        public TextView mTitleTv;

        @BindView(R.id.author_or_shareuser)
        public TextView author;

        @BindView(R.id.article_sort)
        public TextView sort;

        @BindView(R.id.article_time)
        public TextView time;

        @BindView(R.id.article_icon)
        public ImageView mLoveIv;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(SystemArticleList.DataBean.DatasBean datasBean) {
            mTitleTv.setText(datasBean.getTitle());
            author.setText(datasBean.getAuthor().equals(" ")?"作者:"+datasBean.getAuthor():"分享人:"+datasBean.getShareUser());
            sort.setText(datasBean.getSuperChapterName()+"/"+datasBean.getChapterName());
            long t = datasBean.getPublishTime();
            time.setText(longTime2String(t));
            int collection = SearchUtil.Search(mCollectionIds, datasBean.getId());
            if (collection!=-1){
                mLoveIv.setImageResource(R.mipmap.collect_press);
                mLoveIv.setTag(R.mipmap.collect_press);
            }else {
                mLoveIv.setTag(R.mipmap.collect_normal);
            }

        }
        private String longTime2String(long time){
            Date date = new Date(time);
            return sdf.format(date);
        }
    }
    public void setOnTitleItemClickListener(OnTitleItemClickListener listener){
        this.mContentItemClickListener = listener;
    }

    public interface OnTitleItemClickListener {
        /**
         * item点击事件
         * @param datasBean
         */
        void onItemClick(SystemArticleList.DataBean.DatasBean datasBean);
        /**
         * 收藏点击事件
         */
        void onCollectItemClick(ImageView view, SystemArticleList.DataBean.DatasBean datasBean);

        /**
         * 取消收藏点击事件
         * @param datasBean
         */
        void onUnCollectItemClick(ImageView view, SystemArticleList.DataBean.DatasBean datasBean);

    }
}
