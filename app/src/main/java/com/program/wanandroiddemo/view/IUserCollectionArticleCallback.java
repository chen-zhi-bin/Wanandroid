package com.program.wanandroiddemo.view;

import com.program.wanandroiddemo.base.IArticleCallback;
import com.program.wanandroiddemo.base.IBaseCallback;
import com.program.wanandroiddemo.model.domain.CollectionArticle;
import com.program.wanandroiddemo.model.domain.CollectionWebsite;

public interface IUserCollectionArticleCallback extends IArticleCallback {

    /**
     * 设置用户文章收藏
     *
     * @param collectionList
     */
    void onUserCollectionArticle(CollectionArticle collectionList);




}
