package com.program.wanandroiddemo.utils;

public class UrlUitl {

    /**
     * 推荐
     * @param page
     * @return
     */
    public static String getRecommendTitle(int page){
        return "article/list/"+page+"/json";
    }

    /**
     * 用户收藏文章列表
     * @param page
     * @return
     */
    public static String getCollectionList(int page){
        return "lg/collect/list/"+page+"/json";
    }

    /**
     * 取消收藏
     * @param id
     * @return
     */
    public static String unCollectUrl(int id){
        return "lg/uncollect/"+id+"/json";
    }

    /**
     * 收藏文章
     * @param id
     * @return
     */
    public static String CollectArticle(int id){
        return "lg/collect/"+id+"/json";
    }
}
