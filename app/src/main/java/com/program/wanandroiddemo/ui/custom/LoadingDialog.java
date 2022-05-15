package com.program.wanandroiddemo.ui.custom;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.program.wanandroiddemo.R;

import butterknife.BindView;

public class LoadingDialog extends Dialog{
    //在构造方法里提前加载了样式
    private Context context;//上下文
    private int layoutResID;//布局文件id


    //context必须为activity
    public LoadingDialog(Context context,int layoutResID){
        super(context,R.style.MyDialog);//加载dialog的样式
        this.context = context;
        this.layoutResID = layoutResID;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //提前设置Dialog的一些样式
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER);//设置dialog显示居中
        //dialogWindow.setWindowAnimations();设置动画效果
        setContentView(layoutResID);


        WindowManager windowManager = ((Activity)context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = display.getWidth()*4/5;// 设置dialog宽度为屏幕的4/5
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(true);//点击外部Dialog消失
        //遍历控件id添加点击注册

    }


//    private static LoadingDialog mLoadingDialog = null;
//
//    public static LoadingDialog getInstance(Context context){
//        if (mLoadingDialog ==null){
//            mLoadingDialog = new LoadingDialog(context);
//        }
//        return mLoadingDialog;
//    }
//
//    public LoadingDialog(Context context) {
//        AlertDialog.Builder dialog = new AlertDialog.Builder(context, R.style.MyDialog);
//        dialog.setView(R.layout.wait_dialog);
//        AlertDialog alertDialog = dialog.create();
//        alertDialog.show();
//    }
}
