package com.program.wanandroiddemo.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.program.wanandroiddemo.R;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

//收藏中的导航栏adapter
public class IndicatorAdapter extends CommonNavigatorAdapter {
    private final String[] mtitles;
    private OnIdicatorTapClickListener mOnTabClickListener;

    public IndicatorAdapter(Context context) {
        this.mtitles = context.getResources().getStringArray(R.array.indicator_title);
    }

    @Override
    public int getCount() {
        if (mtitles!=null){
            return mtitles.length;
        }
        return 0;
    }

    //获取UI
    @Override
    public IPagerTitleView getTitleView(Context context, int index) {
        //创建view
        ColorTransitionPagerTitleView colorTransitionPagerTitleView=new ColorTransitionPagerTitleView(context);
        //设置一般情况下的颜色为白色
        colorTransitionPagerTitleView.setNormalColor(Color.BLACK);
        //设置选中情况下的颜色为黑色
        colorTransitionPagerTitleView.setSelectedColor(Color.WHITE);
        //单位sp
        colorTransitionPagerTitleView.setTextSize(18);
        //设置显示的内容
        colorTransitionPagerTitleView.setText(mtitles[index]);
        //设置title的点击事件，这，如果点击title，那么就选中下面的viewPager到对应的index中
        //也就是说，点击了title的时候 ，下面的viewPager会对应着index进行切换内容
        colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换viewPager的内容，如果index不一样的话
                if (mOnTabClickListener!=null){
                    mOnTabClickListener.onTabClick(index);
                }
            }
        });
        //返回创建好的view
        return colorTransitionPagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
        linePagerIndicator.setColors(Color.WHITE);
        return linePagerIndicator;
    }


    //设置点击
    public void setOnIdicatorTapClickListener(OnIdicatorTapClickListener lister){
        this.mOnTabClickListener=lister;
    }

    public interface OnIdicatorTapClickListener{
        void onTabClick(int index);
    }
}
