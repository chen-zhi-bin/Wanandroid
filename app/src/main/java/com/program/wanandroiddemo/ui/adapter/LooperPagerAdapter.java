package com.program.wanandroiddemo.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.program.wanandroiddemo.model.domain.RecommendPagerContent;
import com.program.wanandroiddemo.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class LooperPagerAdapter extends PagerAdapter {

    private OnLoopPagerItemClickListener mItemClickListener=null;
    private List<RecommendPagerContent.DataBean> mData = new ArrayList<>();

    public int getDataSize(){
        return mData.size();
    }

    //销毁
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    //加载item
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //处理越界问题
        int realPosition = position % mData.size();
        RecommendPagerContent.DataBean dataBean = mData.get(realPosition);
        int measuredHeight = container.getMeasuredHeight();
        int measuredWidth = container.getMeasuredWidth();
        int ivrSize=(measuredWidth>measuredHeight?measuredWidth:measuredHeight)/2;
        ImageView iv=new ImageView(container.getContext());
        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        iv.setLayoutParams(layoutParams);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Glide.with(container.getContext()).load(dataBean.getImagePath()).into(iv);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    RecommendPagerContent.DataBean item = mData.get(realPosition);
                    mItemClickListener.onLoopereItemClick(item);
                }
            }
        });

        container.addView(iv);
        return iv;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    public void setData(List<RecommendPagerContent.DataBean> contents) {
        mData.clear();
        mData.addAll(contents);
        notifyDataSetChanged();
    }

    public void setOnLoopPagerItemClickListener(OnLoopPagerItemClickListener listener){
        this.mItemClickListener=listener;
    }

    public interface OnLoopPagerItemClickListener{
        void onLoopereItemClick(RecommendPagerContent.DataBean item);
    }
}
