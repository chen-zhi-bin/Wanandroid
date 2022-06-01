package com.program.wanandroiddemo.ui.adapter;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseApplication;
import com.program.wanandroiddemo.model.domain.RecommendTitle;
import com.program.wanandroiddemo.model.domain.SystemArticleList;
import com.program.wanandroiddemo.model.domain.SystemCategories;
import com.program.wanandroiddemo.model.domain.SystemChild;
import com.program.wanandroiddemo.ui.activity.SystemDetailsActivity;
import com.program.wanandroiddemo.ui.custom.FlowTextLayout;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;
import com.program.wanandroiddemo.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SystemAdapter extends RecyclerView.Adapter<SystemAdapter.InnerHolder> {

    private List<SystemCategories.DataBean> mData = new ArrayList<>();
    private static final int TO_DTEAILS=0;

    private OnSystemItemClickListener mListener;
    private final Handler mHandler = new Handler(Looper.myLooper()) {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TO_DTEAILS:
                    String name = msg.obj.toString();
                    int id = msg.arg1;
                    LogUtils.d(SystemAdapter.this,"id ="+id);
                    if (mListener != null) {
                        mListener.systemItemClick(name,id);
                    }
                    break;
            }
        }
    };

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_system_categories, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
            SystemCategories.DataBean dataBean = mData.get(position);
            holder.setData(dataBean);
            holder.setViewheight();
    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<SystemCategories.DataBean> data){
        this.mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder implements FlowTextLayout.OnItemClickListener {

        @BindView(R.id.item_system_title)
        public TextView mTitle;

        @BindView(R.id.item_system_data)
        public FlowTextLayout mFlowTextLayout;

        @BindView(R.id.item_system_layout)
        public RelativeLayout mLayout;

        private int iphoneHeight=0;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(SystemCategories.DataBean dataBean) {
            LogUtils.d(SystemAdapter.this,"data ="+dataBean.toString());
            mTitle.setText(dataBean.getName());
            List<SystemChild> childName = new ArrayList<>();
            for (int i = 0; i < dataBean.getChildren().size(); i++) {
                String name = dataBean.getChildren().get(i).getName();
                Integer id = dataBean.getChildren().get(i).getId();
                SystemChild systemChild = new SystemChild(id, name);
                childName.add(systemChild);
            }
            LogUtils.d(SystemAdapter.this,"system data="+childName.toString());
                mFlowTextLayout.setTextList(childName);
                mFlowTextLayout.setOnItemClickListener(this);
        }

        public void setViewheight() {
            ViewTreeObserver vto = mFlowTextLayout.getViewTreeObserver();
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if (iphoneHeight==0){
                        mFlowTextLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        LogUtils.d(SystemAdapter.this,"mTextLayout height="+mFlowTextLayout.getAllItemFinalBottom());
                        ViewGroup.LayoutParams layoutParams = mLayout.getLayoutParams();
                        iphoneHeight=mLayout.getHeight();
                        LogUtils.d(SystemAdapter.this,"layout height ="+mLayout.getHeight());
                        layoutParams.height  = mFlowTextLayout.getAllItemFinalBottom()+mTitle.getHeight();
                        mLayout.setLayoutParams(layoutParams);
//                    mLayout.getLayoutParams().height=mFlowTextLayout.getAllItemFinalBottom()+mTitle.getHeight();
                    }

                }
            });

        }

        @Override
        public void onItemClickListener(View v, String text,Integer id) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = TO_DTEAILS;
                    message.obj = text;
                    message.arg1 = id;
                    mHandler.sendMessage(message);
                }
            }).start();
        }
    }

    public void setOnSystemItemClickListener(OnSystemItemClickListener systemItemClickListener){
        this.mListener = systemItemClickListener;
    }

    public interface OnSystemItemClickListener{
        void systemItemClick(String name, int id);
    }

}
