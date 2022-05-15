package com.program.wanandroiddemo.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 收藏站外文章
 */
public class CollectArticleOut implements Serializable {

    /**
     * data : {"author":"asd","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":256914,"link":"qweqw","niceDate":"刚刚","origin":"","originId":-1,"publishTime":1652354269397,"title":"qwe","userId":124591,"visible":0,"zan":0}
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
        return "CollectArticleOut{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * author : asd
         * chapterId : 0
         * chapterName :
         * courseId : 13
         * desc :
         * envelopePic :
         * id : 256914
         * link : qweqw
         * niceDate : 刚刚
         * origin :
         * originId : -1
         * publishTime : 1652354269397
         * title : qwe
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
            return "DataBean{" +
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
