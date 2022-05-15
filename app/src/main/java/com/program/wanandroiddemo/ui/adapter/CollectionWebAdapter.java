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
import com.program.wanandroiddemo.model.domain.CollectionWebsite;
import com.program.wanandroiddemo.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionWebAdapter extends RecyclerView.Adapter<CollectionWebAdapter.InnerHolder> {

    private List<CollectionWebsite.DataBean> mData = new ArrayList<>();
    private OnCollectionWebItemCClickListener mItemClickListener=null;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_web, parent, false);
        return new CollectionWebAdapter.InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        CollectionWebsite.DataBean dataBean = mData.get(position);
        holder.setData(dataBean);

        holder.webLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onWebItemClick(dataBean);
                }
            }
        });

        holder.mLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    int tag = Integer.parseInt(holder.mLove.getTag() + "");
                    if (isCollection(tag)){
//                        ((ImageView) v).setImageResource(R.mipmap.collect_normal);
//                        ((ImageView) v).setTag(R.mipmap.collect_normal);

                        mItemClickListener.onUnCollectClick((ImageView) v,dataBean);
                    }else {
//                        ((ImageView) v).setImageResource(R.mipmap.collect_press);
//                        ((ImageView) v).setTag(R.mipmap.collect_press);
                        mItemClickListener.onCollectionClick((ImageView) v,dataBean);
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

    public void setData(CollectionWebsite data){
        this.mData.clear();
        this.mData.addAll(data.getData());
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.collection_web_layout)
        public LinearLayout webLayout;

        @BindView(R.id.web_title)
        public TextView webTitleTv;

        @BindView(R.id.web_link)
        public TextView webLinkTv;

        @BindView(R.id.web_love_icon)
        public ImageView mLove;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(CollectionWebsite.DataBean dataBean) {
            webTitleTv.setText(dataBean.getName());
            webLinkTv.setText(dataBean.getLink());
            mLove.setImageResource(R.mipmap.collect_press);
            mLove.setTag(R.mipmap.collect_press);
        }
    }

    public void setOnCollectionWebItemCClickListener(OnCollectionWebItemCClickListener listener){
        this.mItemClickListener=listener;
    }

    public interface OnCollectionWebItemCClickListener{
        /**
         * 网站item点击事件
         * @param dataBean
         */
        void onWebItemClick(CollectionWebsite.DataBean dataBean);

        /**
         * 收藏网站点击事件，用于防止不小心点击到取消收藏可以再收藏回来
         * @param view
         * @param dataBean
         */
        void onCollectionClick(ImageView view,CollectionWebsite.DataBean dataBean);

        /**
         * 取消收藏
         * @param view
         * @param dataBean
         */
        void onUnCollectClick(ImageView view,CollectionWebsite.DataBean dataBean);
    }
}
