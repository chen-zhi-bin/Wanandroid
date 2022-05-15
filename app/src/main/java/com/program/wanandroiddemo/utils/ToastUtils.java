package com.program.wanandroiddemo.utils;

import android.widget.Toast;

import com.program.wanandroiddemo.base.BaseApplication;

public class ToastUtils {
    //防止Toast堆积太多

    private static Toast sToast;

    public static void showToast(String tips){
        if (sToast == null) {
            sToast = Toast.makeText(BaseApplication.getAppContext(), tips, Toast.LENGTH_SHORT);
        }else {
            sToast.setText(tips);
        }
        sToast.show();
    }
}
