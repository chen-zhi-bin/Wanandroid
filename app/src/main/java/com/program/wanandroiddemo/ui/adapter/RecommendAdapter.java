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
import com.program.wanandroiddemo.presenter.utils.GetCollectionIds;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.SearchUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.InnerHolder> {

    private List<RecommendTitle.DataBean.DatasBean> mData=new ArrayList<>();
    private OnRecommendTitleItemClickListener mContentItemClickListener=null;
    private List<Integer> mCollectionIds = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
    //绑定数据
        RecommendTitle.DataBean.DatasBean datasBean = mData.get(position);
        LogUtils.d("DEBUG","holdder setData=="+datasBean);
        holder.setData(datasBean);

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContentItemClickListener != null) {
                    mContentItemClickListener.onItemClick(datasBean);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(RecommendTitle content) {
        this.mData.clear();
        this.mData.addAll(content.getData().getDatas());
        LogUtils.d("DEBUG","Recommend setData=="+mData);

        notifyDataSetChanged();
    }

    public void addData(RecommendTitle data){
        int olderSize = mData.size();
        mData.addAll(data.getData().getDatas());
        notifyItemChanged(olderSize,data.getData().getDatas().size());
    }

    public void setCollectionData(List<Integer> ids){
       if (ids!=null){
           if (ids.size()>0){
               this.mCollectionIds.clear();
               this.mCollectionIds.addAll(ids);
               LogUtils.d(RecommendAdapter.this,"idssssss ="+mCollectionIds);
               notifyDataSetChanged();
           }
       }
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

        @BindView(R.id.article_data)
        public LinearLayout mLayout;

        @BindView(R.id.article_title)
        public TextView RecommendTitleTv;

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

        public void setData(RecommendTitle.DataBean.DatasBean datasBean) {
            LogUtils.d(RecommendAdapter.this,"dataBean="+datasBean);
            RecommendTitleTv.setText(datasBean.getTitle());
            author.setText(datasBean.getAuthor().equals(" ")?"作者:"+datasBean.getAuthor():"分享人:"+datasBean.getShareUser());
            sort.setText(datasBean.getSuperChapterName()+"/"+datasBean.getChapterName());
            long t = datasBean.getPublishTime();
            time.setText(longTime2String(t));

            LogUtils.d(RecommendAdapter.this,"size ="+mCollectionIds.size());
            int collection = SearchUtil.Search(mCollectionIds, datasBean.getId());
            LogUtils.d(RecommendAdapter.this,"recomenda asofbasof "+datasBean.getId());
            if (collection!=-1){
                mLoveIv.setImageResource(R.mipmap.collect_press);
                mLoveIv.setTag(R.mipmap.collect_press);
            }

//            LogUtils.d(RecommendAdapter.this,"作者："+datasBean.getAuthor()+"分享人:"+datasBean.getShareUser());
//            LogUtils.d("DEBUG","datasBean.getTitlte="+datasBean.getTitle());

        }
        private String longTime2String(long time){
            Date date = new Date(time);
            return sdf.format(date);
        }

    }

    public void setOnRecommendTitleItemClickListener(OnRecommendTitleItemClickListener listener){
        this.mContentItemClickListener = listener;
    }

    public interface OnRecommendTitleItemClickListener{
        /**
         * item点击事件
         * @param data
         */
        void onItemClick(RecommendTitle.DataBean.DatasBean data);
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
