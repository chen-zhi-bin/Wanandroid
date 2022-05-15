package com.program.wanandroiddemo.base;

public interface IArticlePresenter<T> extends IBasePresenter<T>{

    /**
     * 收藏站内文章
     * @param id
     */
    void CollectArticle(int id);

    /**
     * 取消收藏
     * @param id
     * @param originId
     */
    void unCollect(int id,int originId);


}
