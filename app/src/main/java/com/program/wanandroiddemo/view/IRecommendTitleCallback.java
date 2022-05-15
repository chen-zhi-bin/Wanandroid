package com.program.wanandroiddemo.view;

import com.program.wanandroiddemo.base.IArticleCallback;
import com.program.wanandroiddemo.base.IBaseCallback;
import com.program.wanandroiddemo.model.domain.RecommendTitle;

public interface IRecommendTitleCallback extends IArticleCallback {

    /**
     * 内容
     * @param content
     */
    void onContentLoadedSuccess(RecommendTitle content);

}
