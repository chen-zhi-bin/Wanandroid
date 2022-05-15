package com.program.wanandroiddemo.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//推荐列表
public class RecommendTitle implements Serializable {


    /**
     * data : {"curPage":2,"datas":[{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22288,"link":"https://mp.weixin.qq.com/s/paLIsF_0yvHU06VSu_pRrA","niceDate":"2022-04-06 00:00","niceShareDate":"2022-04-06 22:57","origin":"","prefix":"","projectLink":"","publishTime":1649174400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1649257024000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"使用新 Android Gradle 插件加速你的应用构建","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22245,"link":"https://www.jianshu.com/p/befd4b86cc42","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-02 15:47","origin":"","prefix":"","projectLink":"","publishTime":1649161495000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648885621000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android-Stability【Fdleak】: Android Fd泄漏问题分析","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22246,"link":"https://zhuanlan.zhihu.com/p/74229762","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 16:34","origin":"","prefix":"","projectLink":"","publishTime":1649161492000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648974866000,"shareUser":"wangzhengyi","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"第1期：抛开IDE，了解一下javac如何编译","type":0,"userId":38889,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22256,"link":"https://juejin.cn/post/7081639125480112135","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 20:47","origin":"","prefix":"","projectLink":"","publishTime":1649161485000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648990050000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"深入理解JVM1 -- Java代码是怎么运行的？","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22255,"link":"https://juejin.cn/post/7081920364732743717","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 20:45","origin":"","prefix":"","projectLink":"","publishTime":1649161482000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648989906000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"【安卓基础知识】getPackageArchiveInfo的了解","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22266,"link":"https://juejin.cn/post/6951608145537925128","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-04 11:09","origin":"","prefix":"","projectLink":"","publishTime":1649161476000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1649041745000,"shareUser":"goweii","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android悬浮窗看这篇就够了","type":0,"userId":20382,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22257,"link":"https://juejin.cn/post/7081614840606785550","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 20:48","origin":"","prefix":"","projectLink":"","publishTime":1649161464000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648990100000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"显示图形系统分析之SurfaceFlinger和VSync信号","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22260,"link":"https://juejin.cn/post/7081589563134574628","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 20:50","origin":"","prefix":"","projectLink":"","publishTime":1649161462000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648990203000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 使用 MvRx+Epoxy 构建 MVVM 应用","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22258,"link":"https://juejin.cn/post/7081606242212413447","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 20:48","origin":"","prefix":"","projectLink":"","publishTime":1649161459000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648990129000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"雪球 Android App 秒开实践","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22261,"link":"https://juejin.cn/post/7063394962087346189","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 21:04","origin":"","prefix":"","projectLink":"","publishTime":1649161456000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648991057000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android JankStats 发布 Alpha 版本啦","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22262,"link":"https://juejin.cn/post/7078957393446453285","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 21:08","origin":"","prefix":"","projectLink":"","publishTime":1649161453000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648991316000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android Freezer 简介","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22263,"link":"https://juejin.cn/post/7079263706881720333#heading-0","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 21:11","origin":"","prefix":"","projectLink":"","publishTime":1649161451000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648991519000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"山川湖海 - Android无障碍代理的那些事","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22265,"link":"https://www.jianshu.com/p/d2f1a1d400f0","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 21:17","origin":"","prefix":"","projectLink":"","publishTime":1649161448000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648991872000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"JNI调用速度优化","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22267,"link":"https://blog.csdn.net/kq1983/article/details/113406715","niceDate":"2022-04-05 20:23","niceShareDate":"2022-04-04 13:11","origin":"","prefix":"","projectLink":"","publishTime":1649161438000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1649049114000,"shareUser":"wangzhengyi","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"JVM字节码之整型iconst、istore、iload指令","type":0,"userId":38889,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22272,"link":"https://mp.weixin.qq.com/s/KLszW0H7fFjEL6jB47WZ9A","niceDate":"2022-04-02 00:00","niceShareDate":"2022-04-05 22:37","origin":"","prefix":"","projectLink":"","publishTime":1648828800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1649169431000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android 12 自动适配 exported 深入解析避坑","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22273,"link":"https://mp.weixin.qq.com/s/oy3Ae92B1rB2MMC2ydnsvw","niceDate":"2022-04-02 00:00","niceShareDate":"2022-04-05 22:37","origin":"","prefix":"","projectLink":"","publishTime":1648828800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1649169446000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"找到卡顿来源，BlockCanary源码精简分析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22241,"link":"https://blog.csdn.net/CSDNno/article/details/123698442","niceDate":"2022-04-01 21:39","niceShareDate":"2022-04-01 21:39","origin":"","prefix":"","projectLink":"","publishTime":1648820390000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648820390000,"shareUser":"gaoandroid","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android-模块化-项目实践和探索分享","type":0,"userId":26628,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22229,"link":"https://juejin.cn/post/7081161976445059109","niceDate":"2022-04-01 21:06","niceShareDate":"2022-04-01 08:47","origin":"","prefix":"","projectLink":"","publishTime":1648818413000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648774052000,"shareUser":"goweii","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"如何设计 MVVM 架构的 Repository 接口","type":0,"userId":20382,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22231,"link":"https://www.jianshu.com/p/d903bf5cade6","niceDate":"2022-04-01 09:18","niceShareDate":"2022-04-01 09:18","origin":"","prefix":"","projectLink":"","publishTime":1648775890000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648775890000,"shareUser":"hp1451193026","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"NDK-概览","type":0,"userId":2058,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22230,"link":"https://blog.csdn.net/willway_wang/article/details/123768008?spm=1001.2014.3001.5501","niceDate":"2022-04-01 09:07","niceShareDate":"2022-04-01 09:07","origin":"","prefix":"","projectLink":"","publishTime":1648775229000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648775229000,"shareUser":"willwaywang6","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"《Android开发艺术探索》第12章- Bitmap 的加载和 Cache 读书笔记","type":0,"userId":833,"visible":1,"zan":0}],"offset":20,"over":false,"pageCount":607,"size":20,"total":12123}
     * errorCode : 0
     * errorMsg :
     */

    @SerializedName("data")
    private DataBean data;
    @SerializedName("errorCode")
    private Integer errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;

    @Override
    public String toString() {
        return "RecommendTitle{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean implements Serializable {
        /**
         * curPage : 2
         * datas : [{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22288,"link":"https://mp.weixin.qq.com/s/paLIsF_0yvHU06VSu_pRrA","niceDate":"2022-04-06 00:00","niceShareDate":"2022-04-06 22:57","origin":"","prefix":"","projectLink":"","publishTime":1649174400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1649257024000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"使用新 Android Gradle 插件加速你的应用构建","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22245,"link":"https://www.jianshu.com/p/befd4b86cc42","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-02 15:47","origin":"","prefix":"","projectLink":"","publishTime":1649161495000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648885621000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android-Stability【Fdleak】: Android Fd泄漏问题分析","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22246,"link":"https://zhuanlan.zhihu.com/p/74229762","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 16:34","origin":"","prefix":"","projectLink":"","publishTime":1649161492000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648974866000,"shareUser":"wangzhengyi","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"第1期：抛开IDE，了解一下javac如何编译","type":0,"userId":38889,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22256,"link":"https://juejin.cn/post/7081639125480112135","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 20:47","origin":"","prefix":"","projectLink":"","publishTime":1649161485000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648990050000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"深入理解JVM1 -- Java代码是怎么运行的？","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22255,"link":"https://juejin.cn/post/7081920364732743717","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 20:45","origin":"","prefix":"","projectLink":"","publishTime":1649161482000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648989906000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"【安卓基础知识】getPackageArchiveInfo的了解","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22266,"link":"https://juejin.cn/post/6951608145537925128","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-04 11:09","origin":"","prefix":"","projectLink":"","publishTime":1649161476000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1649041745000,"shareUser":"goweii","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android悬浮窗看这篇就够了","type":0,"userId":20382,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22257,"link":"https://juejin.cn/post/7081614840606785550","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 20:48","origin":"","prefix":"","projectLink":"","publishTime":1649161464000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648990100000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"显示图形系统分析之SurfaceFlinger和VSync信号","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22260,"link":"https://juejin.cn/post/7081589563134574628","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 20:50","origin":"","prefix":"","projectLink":"","publishTime":1649161462000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648990203000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 使用 MvRx+Epoxy 构建 MVVM 应用","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22258,"link":"https://juejin.cn/post/7081606242212413447","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 20:48","origin":"","prefix":"","projectLink":"","publishTime":1649161459000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648990129000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"雪球 Android App 秒开实践","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22261,"link":"https://juejin.cn/post/7063394962087346189","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 21:04","origin":"","prefix":"","projectLink":"","publishTime":1649161456000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648991057000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android JankStats 发布 Alpha 版本啦","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22262,"link":"https://juejin.cn/post/7078957393446453285","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 21:08","origin":"","prefix":"","projectLink":"","publishTime":1649161453000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648991316000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android Freezer 简介","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22263,"link":"https://juejin.cn/post/7079263706881720333#heading-0","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 21:11","origin":"","prefix":"","projectLink":"","publishTime":1649161451000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648991519000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"山川湖海 - Android无障碍代理的那些事","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22265,"link":"https://www.jianshu.com/p/d2f1a1d400f0","niceDate":"2022-04-05 20:24","niceShareDate":"2022-04-03 21:17","origin":"","prefix":"","projectLink":"","publishTime":1649161448000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648991872000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"JNI调用速度优化","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22267,"link":"https://blog.csdn.net/kq1983/article/details/113406715","niceDate":"2022-04-05 20:23","niceShareDate":"2022-04-04 13:11","origin":"","prefix":"","projectLink":"","publishTime":1649161438000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1649049114000,"shareUser":"wangzhengyi","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"JVM字节码之整型iconst、istore、iload指令","type":0,"userId":38889,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22272,"link":"https://mp.weixin.qq.com/s/KLszW0H7fFjEL6jB47WZ9A","niceDate":"2022-04-02 00:00","niceShareDate":"2022-04-05 22:37","origin":"","prefix":"","projectLink":"","publishTime":1648828800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1649169431000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android 12 自动适配 exported 深入解析避坑","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22273,"link":"https://mp.weixin.qq.com/s/oy3Ae92B1rB2MMC2ydnsvw","niceDate":"2022-04-02 00:00","niceShareDate":"2022-04-05 22:37","origin":"","prefix":"","projectLink":"","publishTime":1648828800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1649169446000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"找到卡顿来源，BlockCanary源码精简分析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22241,"link":"https://blog.csdn.net/CSDNno/article/details/123698442","niceDate":"2022-04-01 21:39","niceShareDate":"2022-04-01 21:39","origin":"","prefix":"","projectLink":"","publishTime":1648820390000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648820390000,"shareUser":"gaoandroid","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android-模块化-项目实践和探索分享","type":0,"userId":26628,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22229,"link":"https://juejin.cn/post/7081161976445059109","niceDate":"2022-04-01 21:06","niceShareDate":"2022-04-01 08:47","origin":"","prefix":"","projectLink":"","publishTime":1648818413000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648774052000,"shareUser":"goweii","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"如何设计 MVVM 架构的 Repository 接口","type":0,"userId":20382,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22231,"link":"https://www.jianshu.com/p/d903bf5cade6","niceDate":"2022-04-01 09:18","niceShareDate":"2022-04-01 09:18","origin":"","prefix":"","projectLink":"","publishTime":1648775890000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648775890000,"shareUser":"hp1451193026","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"NDK-概览","type":0,"userId":2058,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":22230,"link":"https://blog.csdn.net/willway_wang/article/details/123768008?spm=1001.2014.3001.5501","niceDate":"2022-04-01 09:07","niceShareDate":"2022-04-01 09:07","origin":"","prefix":"","projectLink":"","publishTime":1648775229000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1648775229000,"shareUser":"willwaywang6","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"《Android开发艺术探索》第12章- Bitmap 的加载和 Cache 读书笔记","type":0,"userId":833,"visible":1,"zan":0}]
         * offset : 20
         * over : false
         * pageCount : 607
         * size : 20
         * total : 12123
         */

        @SerializedName("curPage")
        private Integer curPage;
        @SerializedName("offset")
        private Integer offset;
        @SerializedName("over")
        private Boolean over;
        @SerializedName("pageCount")
        private Integer pageCount;
        @SerializedName("size")
        private Integer size;
        @SerializedName("total")
        private Integer total;
        @SerializedName("datas")
        private List<DatasBean> datas;

        @Override
        public String toString() {
            return "DataBean{" +
                    "curPage=" + curPage +
                    ", offset=" + offset +
                    ", over=" + over +
                    ", pageCount=" + pageCount +
                    ", size=" + size +
                    ", total=" + total +
                    ", datas=" + datas +
                    '}';
        }

        public Integer getCurPage() {
            return curPage;
        }

        public void setCurPage(Integer curPage) {
            this.curPage = curPage;
        }

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Boolean getOver() {
            return over;
        }

        public void setOver(Boolean over) {
            this.over = over;
        }

        public Integer getPageCount() {
            return pageCount;
        }

        public void setPageCount(Integer pageCount) {
            this.pageCount = pageCount;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean implements Serializable {
            /**
             * apkLink :
             * audit : 1
             * author : 郭霖
             * canEdit : false
             * chapterId : 409
             * chapterName : 郭霖
             * collect : false
             * courseId : 13
             * desc :
             * descMd :
             * envelopePic :
             * fresh : false
             * host :
             * id : 22288
             * link : https://mp.weixin.qq.com/s/paLIsF_0yvHU06VSu_pRrA
             * niceDate : 2022-04-06 00:00
             * niceShareDate : 2022-04-06 22:57
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1649174400000
             * realSuperChapterId : 407
             * selfVisible : 0
             * shareDate : 1649257024000
             * shareUser :
             * superChapterId : 408
             * superChapterName : 公众号
             * tags : [{"name":"公众号","url":"/wxarticle/list/409/1"}]
             * title : 使用新 Android Gradle 插件加速你的应用构建
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            @SerializedName("apkLink")
            private String apkLink;
            @SerializedName("audit")
            private Integer audit;
            @SerializedName("author")
            private String author;
            @SerializedName("canEdit")
            private Boolean canEdit;
            @SerializedName("chapterId")
            private Integer chapterId;
            @SerializedName("chapterName")
            private String chapterName;
            @SerializedName("collect")
            private Boolean collect;
            @SerializedName("courseId")
            private Integer courseId;
            @SerializedName("desc")
            private String desc;
            @SerializedName("descMd")
            private String descMd;
            @SerializedName("envelopePic")
            private String envelopePic;
            @SerializedName("fresh")
            private Boolean fresh;
            @SerializedName("host")
            private String host;
            @SerializedName("id")
            private Integer id;
            @SerializedName("link")
            private String link;
            @SerializedName("niceDate")
            private String niceDate;
            @SerializedName("niceShareDate")
            private String niceShareDate;
            @SerializedName("origin")
            private String origin;
            @SerializedName("prefix")
            private String prefix;
            @SerializedName("projectLink")
            private String projectLink;
            @SerializedName("publishTime")
            private Long publishTime;
            @SerializedName("realSuperChapterId")
            private Integer realSuperChapterId;
            @SerializedName("selfVisible")
            private Integer selfVisible;
            @SerializedName("shareDate")
            private Long shareDate;
            @SerializedName("shareUser")
            private String shareUser;
            @SerializedName("superChapterId")
            private Integer superChapterId;
            @SerializedName("superChapterName")
            private String superChapterName;
            @SerializedName("title")
            private String title;
            @SerializedName("type")
            private Integer type;
            @SerializedName("userId")
            private Integer userId;
            @SerializedName("visible")
            private Integer visible;
            @SerializedName("zan")
            private Integer zan;
            @SerializedName("tags")
            private List<TagsBean> tags;

            @Override
            public String toString() {
                return "DatasBean{" +
                        "apkLink='" + apkLink + '\'' +
                        ", audit=" + audit +
                        ", author='" + author + '\'' +
                        ", canEdit=" + canEdit +
                        ", chapterId=" + chapterId +
                        ", chapterName='" + chapterName + '\'' +
                        ", collect=" + collect +
                        ", courseId=" + courseId +
                        ", desc='" + desc + '\'' +
                        ", descMd='" + descMd + '\'' +
                        ", envelopePic='" + envelopePic + '\'' +
                        ", fresh=" + fresh +
                        ", host='" + host + '\'' +
                        ", id=" + id +
                        ", link='" + link + '\'' +
                        ", niceDate='" + niceDate + '\'' +
                        ", niceShareDate='" + niceShareDate + '\'' +
                        ", origin='" + origin + '\'' +
                        ", prefix='" + prefix + '\'' +
                        ", projectLink='" + projectLink + '\'' +
                        ", publishTime=" + publishTime +
                        ", realSuperChapterId=" + realSuperChapterId +
                        ", selfVisible=" + selfVisible +
                        ", shareDate=" + shareDate +
                        ", shareUser='" + shareUser + '\'' +
                        ", superChapterId=" + superChapterId +
                        ", superChapterName='" + superChapterName + '\'' +
                        ", title='" + title + '\'' +
                        ", type=" + type +
                        ", userId=" + userId +
                        ", visible=" + visible +
                        ", zan=" + zan +
                        ", tags=" + tags +
                        '}';
            }

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public Integer getAudit() {
                return audit;
            }

            public void setAudit(Integer audit) {
                this.audit = audit;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public Boolean getCanEdit() {
                return canEdit;
            }

            public void setCanEdit(Boolean canEdit) {
                this.canEdit = canEdit;
            }

            public Integer getChapterId() {
                return chapterId;
            }

            public void setChapterId(Integer chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public Boolean getCollect() {
                return collect;
            }

            public void setCollect(Boolean collect) {
                this.collect = collect;
            }

            public Integer getCourseId() {
                return courseId;
            }

            public void setCourseId(Integer courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDescMd() {
                return descMd;
            }

            public void setDescMd(String descMd) {
                this.descMd = descMd;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public Boolean getFresh() {
                return fresh;
            }

            public void setFresh(Boolean fresh) {
                this.fresh = fresh;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getNiceShareDate() {
                return niceShareDate;
            }

            public void setNiceShareDate(String niceShareDate) {
                this.niceShareDate = niceShareDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public Long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(Long publishTime) {
                this.publishTime = publishTime;
            }

            public Integer getRealSuperChapterId() {
                return realSuperChapterId;
            }

            public void setRealSuperChapterId(Integer realSuperChapterId) {
                this.realSuperChapterId = realSuperChapterId;
            }

            public Integer getSelfVisible() {
                return selfVisible;
            }

            public void setSelfVisible(Integer selfVisible) {
                this.selfVisible = selfVisible;
            }

            public Long getShareDate() {
                return shareDate;
            }

            public void setShareDate(Long shareDate) {
                this.shareDate = shareDate;
            }

            public String getShareUser() {
                return shareUser;
            }

            public void setShareUser(String shareUser) {
                this.shareUser = shareUser;
            }

            public Integer getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(Integer superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Integer getType() {
                return type;
            }

            public void setType(Integer type) {
                this.type = type;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public Integer getVisible() {
                return visible;
            }

            public void setVisible(Integer visible) {
                this.visible = visible;
            }

            public Integer getZan() {
                return zan;
            }

            public void setZan(Integer zan) {
                this.zan = zan;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean implements Serializable {
                /**
                 * name : 公众号
                 * url : /wxarticle/list/409/1
                 */

                @SerializedName("name")
                private String name;
                @SerializedName("url")
                private String url;

                @Override
                public String toString() {
                    return "TagsBean{" +
                            "name='" + name + '\'' +
                            ", url='" + url + '\'' +
                            '}';
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
