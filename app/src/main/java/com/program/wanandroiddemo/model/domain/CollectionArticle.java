package com.program.wanandroiddemo.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//收藏文章列表

public class CollectionArticle implements Serializable {


    /**
     * data : {"curPage":1,"datas":[{"author":"郭霖","chapterId":409,"chapterName":"郭霖","courseId":13,"desc":"","envelopePic":"","id":255312,"link":"http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650242888&idx=1&sn=d44a7d339fda6bc21775eb7dcbdbac24&chksm=88638e27bf140731b1675d0157bede873c1f9643928873c5689c7420a42dac0a464a89579412&scene=38#wechat_redirect","niceDate":"20小时前","origin":"","originId":4408,"publishTime":1651233023000,"title":"自定义炫酷动画之旅","userId":124591,"visible":0,"zan":0},{"author":"郭霖","chapterId":409,"chapterName":"郭霖","courseId":13,"desc":"","envelopePic":"","id":255311,"link":"http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650242770&idx=1&sn=484a4b37754aaf7445a9e515671b8b96&chksm=88638fbdbf1406abc554291a70f15c819ff4aa37b1c14474393b8c1a0e8cf152e81a879ad6c6&scene=38#wechat_redirect","niceDate":"20小时前","origin":"","originId":4115,"publishTime":1651233022000,"title":"自定义View之文字路径动画控件","userId":124591,"visible":0,"zan":0},{"author":"xiaoyang","chapterId":440,"chapterName":"官方","courseId":13,"desc":"<p>前两天看公众号文章：<br><a href=\"https://mp.weixin.qq.com/s/XHbJ1L5_rdvKs3AjLCvGiA\">分享一个困惑很久的问题：App前台，Activity会被回收吗？<\/a><\/p>\r\n<p>文章中源码分析阶段，看到了一些核心类：<\/p>\r\n<pre><code> ActivityRecord、TaskRecord、ActivityStack、ActivityDisplay、ActivityStackSupervisor\r\n<\/code><\/pre><p>绕起来有点晕。<\/p>\r\n<p>问题来了：<\/p>\r\n<ol>\r\n<li>这些类分别起到什么作用？<\/li>\r\n<li>有什么好的方式帮助记忆吗？<\/li>\r\n<\/ol>","envelopePic":"","id":254309,"link":"https://wanandroid.com/wenda/show/21681","niceDate":"2022-04-22 15:07","origin":"","originId":21681,"publishTime":1650611276000,"title":"每日一问 | ActivityRecord、TaskRecord、ActivityStack、ActivityDisplay、ActivityStackSupervisor 分别是干什么的？","userId":124591,"visible":0,"zan":0},{"author":"xiaoyang","chapterId":360,"chapterName":"小编发布","courseId":13,"desc":"<p>这是一个收集建议、功能的帖子。<\/p>\r\n<p>如果你有：<\/p>\r\n<ol>\r\n<li>想要添加的功能；<\/li>\r\n<li>觉得目前需要改进的地方；<\/li>\r\n<\/ol>\r\n<p>欢迎提出，会在评估后安排更新~<\/p>","envelopePic":"","id":254213,"link":"https://www.wanandroid.com/wenda/show/20087","niceDate":"2022-04-21 22:27","origin":"","originId":20087,"publishTime":1650551271000,"title":"给 wanandroid 提个意见吧！","userId":124591,"visible":0,"zan":0},{"author":"鸿洋","chapterId":360,"chapterName":"小编发布","courseId":13,"desc":"","envelopePic":"","id":252897,"link":"https://www.wanandroid.com/blog/show/2","niceDate":"2022-04-14 19:36","origin":"","originId":18752,"publishTime":1649936209000,"title":"开放 API 昨晚更新 | 开放了消息列表、问答评论列表","userId":124591,"visible":0,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":5}
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
        return "CollectionArticle{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * curPage : 1
         * datas : [{"author":"郭霖","chapterId":409,"chapterName":"郭霖","courseId":13,"desc":"","envelopePic":"","id":255312,"link":"http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650242888&idx=1&sn=d44a7d339fda6bc21775eb7dcbdbac24&chksm=88638e27bf140731b1675d0157bede873c1f9643928873c5689c7420a42dac0a464a89579412&scene=38#wechat_redirect","niceDate":"20小时前","origin":"","originId":4408,"publishTime":1651233023000,"title":"自定义炫酷动画之旅","userId":124591,"visible":0,"zan":0},{"author":"郭霖","chapterId":409,"chapterName":"郭霖","courseId":13,"desc":"","envelopePic":"","id":255311,"link":"http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650242770&idx=1&sn=484a4b37754aaf7445a9e515671b8b96&chksm=88638fbdbf1406abc554291a70f15c819ff4aa37b1c14474393b8c1a0e8cf152e81a879ad6c6&scene=38#wechat_redirect","niceDate":"20小时前","origin":"","originId":4115,"publishTime":1651233022000,"title":"自定义View之文字路径动画控件","userId":124591,"visible":0,"zan":0},{"author":"xiaoyang","chapterId":440,"chapterName":"官方","courseId":13,"desc":"<p>前两天看公众号文章：<br><a href=\"https://mp.weixin.qq.com/s/XHbJ1L5_rdvKs3AjLCvGiA\">分享一个困惑很久的问题：App前台，Activity会被回收吗？<\/a><\/p>\r\n<p>文章中源码分析阶段，看到了一些核心类：<\/p>\r\n<pre><code> ActivityRecord、TaskRecord、ActivityStack、ActivityDisplay、ActivityStackSupervisor\r\n<\/code><\/pre><p>绕起来有点晕。<\/p>\r\n<p>问题来了：<\/p>\r\n<ol>\r\n<li>这些类分别起到什么作用？<\/li>\r\n<li>有什么好的方式帮助记忆吗？<\/li>\r\n<\/ol>","envelopePic":"","id":254309,"link":"https://wanandroid.com/wenda/show/21681","niceDate":"2022-04-22 15:07","origin":"","originId":21681,"publishTime":1650611276000,"title":"每日一问 | ActivityRecord、TaskRecord、ActivityStack、ActivityDisplay、ActivityStackSupervisor 分别是干什么的？","userId":124591,"visible":0,"zan":0},{"author":"xiaoyang","chapterId":360,"chapterName":"小编发布","courseId":13,"desc":"<p>这是一个收集建议、功能的帖子。<\/p>\r\n<p>如果你有：<\/p>\r\n<ol>\r\n<li>想要添加的功能；<\/li>\r\n<li>觉得目前需要改进的地方；<\/li>\r\n<\/ol>\r\n<p>欢迎提出，会在评估后安排更新~<\/p>","envelopePic":"","id":254213,"link":"https://www.wanandroid.com/wenda/show/20087","niceDate":"2022-04-21 22:27","origin":"","originId":20087,"publishTime":1650551271000,"title":"给 wanandroid 提个意见吧！","userId":124591,"visible":0,"zan":0},{"author":"鸿洋","chapterId":360,"chapterName":"小编发布","courseId":13,"desc":"","envelopePic":"","id":252897,"link":"https://www.wanandroid.com/blog/show/2","niceDate":"2022-04-14 19:36","origin":"","originId":18752,"publishTime":1649936209000,"title":"开放 API 昨晚更新 | 开放了消息列表、问答评论列表","userId":124591,"visible":0,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 5
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
             * author : 郭霖
             * chapterId : 409
             * chapterName : 郭霖
             * courseId : 13
             * desc :
             * envelopePic :
             * id : 255312
             * link : http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650242888&idx=1&sn=d44a7d339fda6bc21775eb7dcbdbac24&chksm=88638e27bf140731b1675d0157bede873c1f9643928873c5689c7420a42dac0a464a89579412&scene=38#wechat_redirect
             * niceDate : 20小时前
             * origin :
             * originId : 4408
             * publishTime : 1651233023000
             * title : 自定义炫酷动画之旅
             * userId : 124591
             * visible : 0
             * zan : 0
             */

            @SerializedName("author")
            private String author;
            @SerializedName("chapterId")
            private Integer chapterId;
            @SerializedName("chapterName")
            private String chapterName;
            @SerializedName("courseId")
            private Integer courseId;
            @SerializedName("desc")
            private String desc;
            @SerializedName("envelopePic")
            private String envelopePic;
            @SerializedName("id")
            private Integer id;
            @SerializedName("link")
            private String link;
            @SerializedName("niceDate")
            private String niceDate;
            @SerializedName("origin")
            private String origin;
            @SerializedName("originId")
            private Integer originId;
            @SerializedName("publishTime")
            private Long publishTime;
            @SerializedName("title")
            private String title;
            @SerializedName("userId")
            private Integer userId;
            @SerializedName("visible")
            private Integer visible;
            @SerializedName("zan")
            private Integer zan;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
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

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
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

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public Integer getOriginId() {
                return originId;
            }

            public void setOriginId(Integer originId) {
                this.originId = originId;
            }

            public Long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(Long publishTime) {
                this.publishTime = publishTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            @Override
            public String toString() {
                return "DatasBean{" +
                        "author='" + author + '\'' +
                        ", chapterId=" + chapterId +
                        ", chapterName='" + chapterName + '\'' +
                        ", courseId=" + courseId +
                        ", desc='" + desc + '\'' +
                        ", envelopePic='" + envelopePic + '\'' +
                        ", id=" + id +
                        ", link='" + link + '\'' +
                        ", niceDate='" + niceDate + '\'' +
                        ", origin='" + origin + '\'' +
                        ", originId=" + originId +
                        ", publishTime=" + publishTime +
                        ", title='" + title + '\'' +
                        ", userId=" + userId +
                        ", visible=" + visible +
                        ", zan=" + zan +
                        '}';
            }
        }
    }
}
