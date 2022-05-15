package com.program.wanandroiddemo.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


//收藏网站列表
public class CollectionWebsite implements Serializable {

    /**
     * data : [{"desc":"","icon":"","id":15395,"link":"https://www.iconfont.cn/","name":"icon","order":0,"userId":124591,"visible":1},{"desc":"","icon":"","id":15400,"link":"https://github.com/","name":"GitHub","order":0,"userId":124591,"visible":1}]
     * errorCode : 0
     * errorMsg :
     */

    @SerializedName("errorCode")
    private Integer errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;
    @SerializedName("data")
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CollectionWebsite{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * desc :
         * icon :
         * id : 15395
         * link : https://www.iconfont.cn/
         * name : icon
         * order : 0
         * userId : 124591
         * visible : 1
         */

        @SerializedName("desc")
        private String desc;
        @SerializedName("icon")
        private String icon;
        @SerializedName("id")
        private Integer id;
        @SerializedName("link")
        private String link;
        @SerializedName("name")
        private String name;
        @SerializedName("order")
        private Integer order;
        @SerializedName("userId")
        private Integer userId;
        @SerializedName("visible")
        private Integer visible;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "desc='" + desc + '\'' +
                    ", icon='" + icon + '\'' +
                    ", id=" + id +
                    ", link='" + link + '\'' +
                    ", name='" + name + '\'' +
                    ", order=" + order +
                    ", userId=" + userId +
                    ", visible=" + visible +
                    '}';
        }
    }
}
