package com.program.wanandroiddemo.presenter.Impl;

import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.presenter.IMainActivityDataHandle;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.SharedPreferencesUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivityDataHandleImpl implements IMainActivityDataHandle {

    private SharedPreferencesUtils mSPUtils;

    public MainActivityDataHandleImpl() {
        mSPUtils = SharedPreferencesUtils.getInstance(BaseApplication.getAppContext());
    }

    @Override
    public void initToken() {
        long timeNow = 0;
        long time = 0;
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            time = Long.parseLong(mSPUtils.getString(SharedPreferencesUtils.USER_TOKEN_COOKIE_TIME));
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            String s = dateFormat.format(new Date());
            timeNow = dateFormat.parse(s).getTime();
            LogUtils.d(MainActivityDataHandleImpl.this, "timeNow =" + timeNow);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.d(MainActivityDataHandleImpl.this, "time  =" + e.getMessage());
        }
        LogUtils.d(MainActivityDataHandleImpl.this, "time ==" + time + "   timeNow==" + timeNow);
        LogUtils.d(MainActivityDataHandleImpl.this, "time x==" +(time<timeNow));
        LogUtils.d(MainActivityDataHandleImpl.this, "time x==" +(time<timeNow));
        if (time <= timeNow) {
            mSPUtils.clear();
        }
    }
}
