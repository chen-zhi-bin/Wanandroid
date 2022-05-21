package com.program.wanandroiddemo.model;

import com.program.wanandroiddemo.model.domain.CollectArticle;
import com.program.wanandroiddemo.model.domain.CollectArticleOut;
import com.program.wanandroiddemo.model.domain.CollectWebsite;
import com.program.wanandroiddemo.model.domain.CollectionArticle;
import com.program.wanandroiddemo.model.domain.CollectionWebsite;
import com.program.wanandroiddemo.model.domain.Loginout;
import com.program.wanandroiddemo.model.domain.RecommendPagerContent;
import com.program.wanandroiddemo.model.domain.RecommendTitle;
import com.program.wanandroiddemo.model.domain.UnCollectArticle;
import com.program.wanandroiddemo.model.domain.UnCollectWeb;
import com.program.wanandroiddemo.model.domain.UserInfo;
import com.program.wanandroiddemo.model.domain.UserInformation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {

    /**
     * 获取推荐
     *
     * @param url
     * @return
     */
    @GET
    Call<RecommendTitle> getRecommend(@Url String url);

    /**
     * 获取推荐banner
     */
    @GET
    Call<RecommendPagerContent> getRecommendPagerLoop(@Url String url);

    /**
     * 登录
     *
     * @param name     用户名
     * @param password 密码
     * @return
     */
    @POST("user/login")
    Call<UserInformation> getUserLogin(@Query("username") String name, @Query("password") String password);

    /**
     * 登出
     *
     * @param token
     * @return
     */
    @GET("user/logout/json")
    Call<Loginout> getLoginout(@Header("Cookie") String token);


    /**
     * 获取个人信息
     *
     * @param token
     * @return
     */
    @GET("user/lg/userinfo/json")
    Call<UserInfo> getUserInfo(@Header("Cookie") String token);

    /**
     * 获取收藏文章列表
     *
     * @param url
     * @return
     */
    @GET
    Call<CollectionArticle> getUserCollection(@Url String url, @Header("Cookie") String token);

    /**
     * 获取收藏网站列表
     *
     * @param token
     * @return
     */
    @GET("lg/collect/usertools/json")
    Call<CollectionWebsite> getUserCollectionWeb(@Header("Cookie") String token);

    /**
     * 收藏站内文章
     * @param url
     * @param token
     * @return
     */
    @POST
    Call<CollectArticle> setCollectArticle(
            @Url String url,
            @Header("Cookie") String token);

    /**
     * 收藏站外文章
     * @param token
     * @param title         标题
     * @param author        作者
     * @param link          url
     * @return
     */
    @POST("lg/collect/add/json")
    Call<CollectArticleOut> setCollectArticleOut(
            @Header("Cookie") String token,
            @Query("title")String title,
            @Query("author")String author,
            @Query("link")String link);



    /**
     * 取消收藏（文章）
     *
     * @param url       url
     * @param token     token
     * @param originId  id
     * @return
     */
    @POST
    Call<UnCollectArticle> unCollectArticle(@Url String url, @Header("Cookie") String token, @Query("originId") int originId);

    /**
     * 收藏网站
     * @param token
     * @param name
     * @param link
     * @return
     */
    @POST("lg/collect/addtool/json")
    Call<CollectWebsite> collectWeb(@Header("Cookie")String token,@Query("name") String name,@Query("link") String link);

    /**
     * 删除收藏网站
     * @param token
     * @param id
     * @return
     */
    @POST("lg/collect/deletetool/json")
    Call<UnCollectWeb> unCollectWeb(@Header("Cookie") String token, @Query("id") int id);
}
