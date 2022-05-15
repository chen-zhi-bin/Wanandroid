package com.program.wanandroiddemo.ui.custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectDialog extends Dialog implements View.OnClickListener {

    @BindView(R.id.dialog_collect_article)
    public RadioButton mArticleBtn;
    @BindView(R.id.dialog_collect_web)
    public RadioButton mWebBtn;
    @BindView(R.id.dialog_collect_title)
    public EditText mTitle;
    @BindView(R.id.dialog_collect_author)
    public EditText mAuthor;
    @BindView(R.id.dialog_collect_link)
    public EditText mLink;
    @BindView(R.id.dialog_cancel_btn)
    public TextView mCancel;
    @BindView(R.id.dialog_sure_btn)
    public TextView mSure;

    private Context context;//上下文

    private int[] listenedItem;//监听的控件id
    public CollectDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
        this.context = context;
        this.listenedItem = Constants.LISTENEDITEM;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //提前设置Dialog的一些样式
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER);//设置dialog显示居中
        //dialogWindow.setWindowAnimations();设置动画效果
        setContentView(R.layout.dialog_collect);
        ButterKnife.bind((CollectDialog)this);

        WindowManager windowManager = ((Activity)context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = display.getWidth()*4/5;// 设置dialog宽度为屏幕的4/5
        getWindow().setAttributes(lp);
       // setCanceledOnTouchOutside(true);//点击外部Dialog消失
        setCancelable(false);               //不允许点击外部关闭
        //遍历控件id添加点击注册
        for(int id:listenedItem){
            findViewById(id).setOnClickListener(this);
        }
        initLinsener();
    }

    private void initLinsener() {
//        mLink.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                LogUtils.d(CollectDialog.class,"beforeTextChanged::s="+s+"//start="+start+"//count="+count+"//after="+after);
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                LogUtils.d(CollectDialog.class,"onTextChanged::s="+s+"//start="+start+"//before="+before+"//count="+count);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                LogUtils.d(CollectDialog.class,"afterTextChanged::s="+s);
//            }
//        });
    }

    private OnCenterItemClickListener listener;
    //点击接口
    public interface OnCenterItemClickListener {
        void OnCenterItemClick(CollectDialog dialog, View view);
    }
    //很明显我们要在这里面写个接口，然后添加一个方法
    public void setOnCenterItemClickListener(OnCenterItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.OnCenterItemClick(this,v);
    }
}
