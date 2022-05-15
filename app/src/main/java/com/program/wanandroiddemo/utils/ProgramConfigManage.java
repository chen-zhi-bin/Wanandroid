package com.program.wanandroiddemo.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

public class ProgramConfigManage {
    // 单例模式类对象
    private ContextWrapper mWrapper = null;
    private static ProgramConfigManage m_ProgramConfig = null;
    private SharedPreferences mPreferences = null;

    public static final String SP_USER_LOGIN_TOKEN="token_press";

    // 单例模式获取实例
    public static ProgramConfigManage GetInstance(Context base) {
        if (m_ProgramConfig == null) {
            m_ProgramConfig = new ProgramConfigManage(base);
        }

        return m_ProgramConfig;
    }

    // 配置getSharedPreferences
    private ProgramConfigManage(Context base) {
        // super(base);
        mWrapper = new ContextWrapper(base);
        mPreferences = mWrapper.getSharedPreferences("dataUser",
                ContextWrapper.MODE_PRIVATE);

    }

    // 设置
    public void setString(String name,String value) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(name, value);

        editor.commit();

    }

    public String getString(String name){
        SharedPreferences.Editor editor = mPreferences.edit();

      return m_ProgramConfig.mPreferences.getString(name,"");
    }




}
