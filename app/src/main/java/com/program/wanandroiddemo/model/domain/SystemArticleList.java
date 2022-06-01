package com.program.wanandroiddemo.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SystemArticleList implements Serializable {

    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":12871,"link":"https://juejin.im/post/5e94815551882573af79b2a0","niceDate":"2020-04-14 00:05","niceShareDate":"2020-04-13 23:58","origin":"","prefix":"","projectLink":"","publishTime":1586793921000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1586793515000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"数据库还可以这么看？（Android Studio 4.1 新特性）","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":12470,"link":"https://juejin.im/post/5e7194b6e51d4526cd1e0903","niceDate":"2020-03-19 00:39","niceShareDate":"2020-03-18 16:56","origin":"","prefix":"","projectLink":"","publishTime":1584549582000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1584521810000,"shareUser":"goweii","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android 11 中的存储机制更新","type":0,"userId":20382,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":10022,"link":"https://juejin.im/post/5db8cee351882557134d0411#comment","niceDate":"2019-10-31 22:59","niceShareDate":"2019-10-31 22:52","origin":"","prefix":"","projectLink":"","publishTime":1572533960000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1572533520000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio 4.0 更新进展","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9653,"link":"https://www.jianshu.com/p/05865076b12b","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:27","origin":"","prefix":"","projectLink":"","publishTime":1570978476000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976842000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发7--ProjectViewPopupMenu的创建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9652,"link":"https://www.jianshu.com/p/6e41b83b5505","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:27","origin":"","prefix":"","projectLink":"","publishTime":1570978470000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976838000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发6--Settings创建配置页","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9651,"link":"https://www.jianshu.com/p/16607caffb63","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:27","origin":"","prefix":"","projectLink":"","publishTime":1570978464000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976834000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发5--JBPopup创建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9650,"link":"https://www.jianshu.com/p/d55ca4dbc821","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:27","origin":"","prefix":"","projectLink":"","publishTime":1570978457000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976829000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发4--ToolWindow创建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9649,"link":"https://www.jianshu.com/p/e4c0acbd6714","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:27","origin":"","prefix":"","projectLink":"","publishTime":1570978450000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976824000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发3--Dialog创建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9648,"link":"https://www.jianshu.com/p/3078cbde2245","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:26","origin":"","prefix":"","projectLink":"","publishTime":1570978443000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976816000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发2--Action创建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9647,"link":"https://www.jianshu.com/p/7fce3f10ea17","niceDate":"2019-10-13 22:53","niceShareDate":"2019-10-13 22:26","origin":"","prefix":"","projectLink":"","publishTime":1570978433000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976809000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发1--环境搭建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"波波维奇c","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9008,"link":"https://www.jianshu.com/p/5d0a1879fd6f","niceDate":"2019-08-22 00:55","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1566406520000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"View.Post () 的身世大揭秘","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":" ztq","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":8201,"link":"https://juejin.im/post/5c9f2412f265da30bd3e428c","niceDate":"2019-04-06 16:22","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1554538973000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"零报错基于Virtualbox虚拟机搭建Linux(Ubuntu)的Android开发环境","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"西瓜皮TWO","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":8173,"link":"https://www.jianshu.com/p/dd1faa99dcf1","niceDate":"2019-03-30 22:33","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1553956399000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android 寻找极限编码的「快感」","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":" coder-pig","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":7654,"link":"https://juejin.im/post/5c09f9daf265da61193ba4f2","niceDate":"2018-12-13 00:17","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1544631421000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"逮虾户！Android程序调试竟简单如斯","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"HuYounger","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":7649,"link":"https://www.jianshu.com/p/aaee2d27068e","niceDate":"2018-12-13 00:09","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1544630985000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Monitor使用介绍","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"辰之猫","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":7629,"link":"https://www.jianshu.com/p/e54db232df62","niceDate":"2018-12-07 00:30","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1544113821000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"让你明明白白的使用RecyclerView&mdash;&mdash;SnapHelper详解","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"浪淘沙xud","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":3373,"link":"https://www.jianshu.com/p/88e32ef66ef2","niceDate":"2018-09-09 23:06","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1536505616000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android 技能图谱学习路线","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":3236,"link":"https://mp.weixin.qq.com/s/2RC2vlvoFTVNgtAAnDnWuQ","niceDate":"2018-08-07 21:10","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1533647424000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"grepcode都无法访问了，如何更好的阅读源码","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"Wing_Li","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":3046,"link":"https://www.jianshu.com/p/533240d222d3","niceDate":"2018-06-24 22:25","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1529850301000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Gradle多渠道打包(动态设定App名称，应用图标，替换常量，更改包名，变更渠道)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"HuangTao_Zoey ","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":3029,"link":"https://www.jianshu.com/p/f406d535a8bc","niceDate":"2018-06-20 11:51","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1529466669000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android trace文件抓取原理","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":3,"size":20,"total":42}
     * errorCode : 0
     * errorMsg :
     */

    @SerializedName("data")
    private DataBean data;
    @SerializedName("errorCode")
    private Integer errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;

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

    @Override
    public String toString() {
        return "SystemArticleList{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":12871,"link":"https://juejin.im/post/5e94815551882573af79b2a0","niceDate":"2020-04-14 00:05","niceShareDate":"2020-04-13 23:58","origin":"","prefix":"","projectLink":"","publishTime":1586793921000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1586793515000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"数据库还可以这么看？（Android Studio 4.1 新特性）","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":12470,"link":"https://juejin.im/post/5e7194b6e51d4526cd1e0903","niceDate":"2020-03-19 00:39","niceShareDate":"2020-03-18 16:56","origin":"","prefix":"","projectLink":"","publishTime":1584549582000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1584521810000,"shareUser":"goweii","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android 11 中的存储机制更新","type":0,"userId":20382,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":10022,"link":"https://juejin.im/post/5db8cee351882557134d0411#comment","niceDate":"2019-10-31 22:59","niceShareDate":"2019-10-31 22:52","origin":"","prefix":"","projectLink":"","publishTime":1572533960000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1572533520000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio 4.0 更新进展","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9653,"link":"https://www.jianshu.com/p/05865076b12b","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:27","origin":"","prefix":"","projectLink":"","publishTime":1570978476000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976842000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发7--ProjectViewPopupMenu的创建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9652,"link":"https://www.jianshu.com/p/6e41b83b5505","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:27","origin":"","prefix":"","projectLink":"","publishTime":1570978470000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976838000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发6--Settings创建配置页","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9651,"link":"https://www.jianshu.com/p/16607caffb63","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:27","origin":"","prefix":"","projectLink":"","publishTime":1570978464000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976834000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发5--JBPopup创建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9650,"link":"https://www.jianshu.com/p/d55ca4dbc821","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:27","origin":"","prefix":"","projectLink":"","publishTime":1570978457000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976829000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发4--ToolWindow创建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9649,"link":"https://www.jianshu.com/p/e4c0acbd6714","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:27","origin":"","prefix":"","projectLink":"","publishTime":1570978450000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976824000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发3--Dialog创建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9648,"link":"https://www.jianshu.com/p/3078cbde2245","niceDate":"2019-10-13 22:54","niceShareDate":"2019-10-13 22:26","origin":"","prefix":"","projectLink":"","publishTime":1570978443000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976816000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发2--Action创建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9647,"link":"https://www.jianshu.com/p/7fce3f10ea17","niceDate":"2019-10-13 22:53","niceShareDate":"2019-10-13 22:26","origin":"","prefix":"","projectLink":"","publishTime":1570978433000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1570976809000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Studio插件开发1--环境搭建","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"波波维奇c","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":9008,"link":"https://www.jianshu.com/p/5d0a1879fd6f","niceDate":"2019-08-22 00:55","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1566406520000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"View.Post () 的身世大揭秘","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":" ztq","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":8201,"link":"https://juejin.im/post/5c9f2412f265da30bd3e428c","niceDate":"2019-04-06 16:22","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1554538973000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"零报错基于Virtualbox虚拟机搭建Linux(Ubuntu)的Android开发环境","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"西瓜皮TWO","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":8173,"link":"https://www.jianshu.com/p/dd1faa99dcf1","niceDate":"2019-03-30 22:33","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1553956399000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android 寻找极限编码的「快感」","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":" coder-pig","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":7654,"link":"https://juejin.im/post/5c09f9daf265da61193ba4f2","niceDate":"2018-12-13 00:17","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1544631421000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"逮虾户！Android程序调试竟简单如斯","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"HuYounger","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":7649,"link":"https://www.jianshu.com/p/aaee2d27068e","niceDate":"2018-12-13 00:09","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1544630985000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android Monitor使用介绍","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"辰之猫","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":7629,"link":"https://www.jianshu.com/p/e54db232df62","niceDate":"2018-12-07 00:30","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1544113821000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"让你明明白白的使用RecyclerView&mdash;&mdash;SnapHelper详解","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"浪淘沙xud","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":3373,"link":"https://www.jianshu.com/p/88e32ef66ef2","niceDate":"2018-09-09 23:06","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1536505616000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android 技能图谱学习路线","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":3236,"link":"https://mp.weixin.qq.com/s/2RC2vlvoFTVNgtAAnDnWuQ","niceDate":"2018-08-07 21:10","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1533647424000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"grepcode都无法访问了，如何更好的阅读源码","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"Wing_Li","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":3046,"link":"https://www.jianshu.com/p/533240d222d3","niceDate":"2018-06-24 22:25","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1529850301000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Gradle多渠道打包(动态设定App名称，应用图标，替换常量，更改包名，变更渠道)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"HuangTao_Zoey ","canEdit":false,"chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":3029,"link":"https://www.jianshu.com/p/f406d535a8bc","niceDate":"2018-06-20 11:51","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1529466669000,"realSuperChapterId":150,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android trace文件抓取原理","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 3
         * size : 20
         * total : 42
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

        public static class DatasBean implements Serializable {
            /**
             * apkLink :
             * audit : 1
             * author :
             * canEdit : false
             * chapterId : 60
             * chapterName : Android Studio相关
             * collect : false
             * courseId : 13
             * desc :
             * descMd :
             * envelopePic :
             * fresh : false
             * host :
             * id : 12871
             * link : https://juejin.im/post/5e94815551882573af79b2a0
             * niceDate : 2020-04-14 00:05
             * niceShareDate : 2020-04-13 23:58
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1586793921000
             * realSuperChapterId : 150
             * selfVisible : 0
             * shareDate : 1586793515000
             * shareUser : 鸿洋
             * superChapterId : 60
             * superChapterName : 开发环境
             * tags : []
             * title : 数据库还可以这么看？（Android Studio 4.1 新特性）
             * type : 0
             * userId : 2
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
            private List<?> tags;

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

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }

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
        }
    }
}
