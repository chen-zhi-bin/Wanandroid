package com.program.wanandroiddemo.utils;

import android.content.Context;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseApplication;

public class Constants {

    public static final String BASE_URL="https://www.wanandroid.com/";

    public static final int BULE_LOVE= R.mipmap.collect_press;
    public static final int WHITE_LOVE= R.mipmap.collect_normal;

    public static final String TITLE="TITLE";
    public static final String LINK="LINK";

    public static final int DIALOG_CHOICE_ARTICLE=1;
    public static final int DIALOG_CHOICE_WEB=2;

    public static final int MESSAGE_WHAT_COLLECTION=0;

    public static final int[] LISTENEDITEM={
            R.id.dialog_collect_article,    //单选--文章
            R.id.dialog_collect_web,        //单选--web
            R.id.dialog_collect_title,      //标题
            R.id.dialog_collect_author,     //作者
            R.id.dialog_collect_link,       //url
            R.id.dialog_cancel_btn,         //取消按钮
            R.id.dialog_sure_btn            //确定
    };

    public static String getCookie() {
        //拿cookie
        SharedPreferencesUtils sp = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
        return sp.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE);
    }

}
