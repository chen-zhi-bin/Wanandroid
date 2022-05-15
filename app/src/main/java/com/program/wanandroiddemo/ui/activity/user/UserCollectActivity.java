package com.program.wanandroiddemo.ui.activity.user;

import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseActivity;
import com.program.wanandroiddemo.presenter.ICollectPresenter;
import com.program.wanandroiddemo.ui.activity.test.TestActivity;
import com.program.wanandroiddemo.ui.adapter.IndicatorAdapter;
import com.program.wanandroiddemo.ui.adapter.MagicContentAdapter;
import com.program.wanandroiddemo.ui.custom.CollectDialog;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.PresenterManager;
import com.program.wanandroiddemo.utils.ToastUtils;
import com.program.wanandroiddemo.view.ICollectBallback;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import butterknife.BindView;

public class UserCollectActivity extends BaseActivity implements CollectDialog.OnCenterItemClickListener, ICollectBallback {
    @BindView(R.id.magic_indicator)
    public MagicIndicator mMagicIndicator;

    @BindView(R.id.collect_floating_btn)
    public FloatingActionButton mCollectBtn;

    private ViewPager mcontentPager;

    private IndicatorAdapter mIndicatorAdapter;
    private CollectDialog mDialog;
    private ICollectPresenter mCollectPresenterlmpl;

    @Override
    protected void initPresenter() {
        mCollectPresenterlmpl = PresenterManager.getInstance().getCollectPresenterlmpl();
        mCollectPresenterlmpl.registerViewCallback(this);
    }



    @Override
    protected void initView() {

        //创建indicator的适配器
        mIndicatorAdapter = new IndicatorAdapter(this);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);    //自我调节屏幕上的大类导航
        commonNavigator.setAdapter(mIndicatorAdapter);

        mcontentPager = this.findViewById(R.id.content_pager);

        //创建适配器
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        MagicContentAdapter mainContenAdapter = new MagicContentAdapter(supportFragmentManager);
        mcontentPager.setAdapter(mainContenAdapter);
        //把ViewPagerHelper和IndicatorAdapter绑定
        mMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mMagicIndicator, mcontentPager);


        //dialog设置
        mDialog = new CollectDialog(UserCollectActivity.this);
        Window dialogWindow = mDialog.getWindow();
        WindowManager.LayoutParams attributes = dialogWindow.getAttributes();
        attributes.alpha=0.8f;
        attributes.dimAmount=0.5f;      //不透明度
        dialogWindow.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialogWindow.setAttributes(attributes);

    }

    @Override
    protected void initEvent() {
        super.initEvent();

        mDialog.setOnCenterItemClickListener(this);

        initListener();
    }

    private void initListener() {
        mIndicatorAdapter.setOnIdicatorTapClickListener(new IndicatorAdapter.OnIdicatorTapClickListener() {
            @Override
            public void onTabClick(int index) {
                LogUtils.d(UserCollectActivity.this, "click index -->" + index);
                LogUtils.d(UserCollectActivity.this, "=====================================================");
                if (mcontentPager != null) {
                    mcontentPager.setCurrentItem(index, false);
                }
            }
        });

        mCollectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.show();
            }
        });
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_user_collect;
    }


    //默认选中文章
    int choice = Constants.DIALOG_CHOICE_ARTICLE;
    @Override
    public void OnCenterItemClick(CollectDialog dialog, View view) {
        switch (view.getId()){
            case R.id.dialog_collect_article:
                //文章
                dialog.mAuthor.setVisibility(View.VISIBLE);
                choice= Constants.DIALOG_CHOICE_ARTICLE;
                break;
            case R.id.dialog_collect_web:
                //网站
                dialog.mAuthor.setVisibility(View.GONE);
                choice=Constants.DIALOG_CHOICE_WEB;
                break;
            case R.id.dialog_cancel_btn:
                mDialog.cancel();
                dialog.mAuthor.setText("");
                dialog.mTitle.setText("");
                dialog.mLink.setText("");
                break;
            case R.id.dialog_sure_btn:
                String title = dialog.mTitle.getText().toString().trim();
                String link = dialog.mLink.getText().toString().trim();

                if (choice==1){
                    String author = dialog.mAuthor.getText().toString().trim();
                    LogUtils.d(UserCollectActivity.this,"title=="+title+"//"+"link=="+link+"//author=="+author);
                }
                if (choice==2){
                    LogUtils.d(UserCollectActivity.this,"title=="+title+"//"+"link=="+link);
                    mCollectPresenterlmpl.setCollectWeb(title,link);
                }
                break;
        }
    }

    @Override
    public void resultError() {
        ToastUtils.showToast("网络错误，请稍后重试");
    }

    @Override
    public void resultSuccess() {
        ToastUtils.showToast("收藏成功");
        mDialog.mAuthor.setText("");
        mDialog.mTitle.setText("");
        mDialog.mLink.setText("");
        mDialog.dismiss();
    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }
}
