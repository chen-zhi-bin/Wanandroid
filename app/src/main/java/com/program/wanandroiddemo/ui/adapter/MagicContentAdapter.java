package com.program.wanandroiddemo.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.program.wanandroiddemo.utils.CollectionFragmentCreator;

import net.lucode.hackware.magicindicator.MagicIndicator;

//用于控制管理导航栏
public class MagicContentAdapter extends FragmentPagerAdapter {
    public MagicContentAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return CollectionFragmentCreator.getFragment(position);
    }

    @Override
    public int getCount() {
        return CollectionFragmentCreator.PAGE_COUNT;
    }
}
