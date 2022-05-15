package com.program.wanandroiddemo.utils;

import com.program.wanandroiddemo.base.BaseFragment;
import com.program.wanandroiddemo.ui.fragment.userCollection.UserArticleCollectionFragment;
import com.program.wanandroiddemo.ui.fragment.userCollection.UserWebsiteCollectionFragment;

import java.util.HashMap;
import java.util.Map;

//用于控制管理导航栏
public class CollectionFragmentCreator {


    //缓冲显示
    public final static int INDEX_ARTICLE =0;
    public final static int INDEX_WEBSITE =1;

    public final static int PAGE_COUNT=2;

    private static Map<Integer, BaseFragment> sCache = new HashMap<>();

    public static BaseFragment getFragment(int index){
        BaseFragment baseFragment=sCache.get(index);
        if (baseFragment!=null){
            return baseFragment;
        }
        switch (index){
            case INDEX_ARTICLE:
                baseFragment = new UserArticleCollectionFragment();
                break;
            case INDEX_WEBSITE:
                baseFragment = new UserWebsiteCollectionFragment();
                break;

        }
        sCache.put(index,baseFragment);
        return baseFragment;
    }

}
