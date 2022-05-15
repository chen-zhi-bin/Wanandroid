package com.program.wanandroiddemo.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//个人信息
public class UserInfo implements Serializable {

    /**
     * data : {"coinInfo":{"coinCount":980,"level":10,"nickname":"","rank":"2032","userId":124591,"username":"s**ak_dream"},"collectArticleInfo":{"count":3},"userInfo":{"admin":false,"chapterTops":[],"coinCount":980,"collectIds":[18752,20087,21681],"email":"815172923@qq.com","icon":"","id":124591,"nickname":"初学者","password":"","publicName":"初学者","token":"","type":0,"username":"speak_dream"}}
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
        return "UserInfo{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * coinInfo : {"coinCount":980,"level":10,"nickname":"","rank":"2032","userId":124591,"username":"s**ak_dream"}
         * collectArticleInfo : {"count":3}
         * userInfo : {"admin":false,"chapterTops":[],"coinCount":980,"collectIds":[18752,20087,21681],"email":"815172923@qq.com","icon":"","id":124591,"nickname":"初学者","password":"","publicName":"初学者","token":"","type":0,"username":"speak_dream"}
         */

        @SerializedName("coinInfo")
        private CoinInfoBean coinInfo;
        @SerializedName("collectArticleInfo")
        private CollectArticleInfoBean collectArticleInfo;
        @SerializedName("userInfo")
        private UserInfoBean userInfo;

        public CoinInfoBean getCoinInfo() {
            return coinInfo;
        }

        public void setCoinInfo(CoinInfoBean coinInfo) {
            this.coinInfo = coinInfo;
        }

        public CollectArticleInfoBean getCollectArticleInfo() {
            return collectArticleInfo;
        }

        public void setCollectArticleInfo(CollectArticleInfoBean collectArticleInfo) {
            this.collectArticleInfo = collectArticleInfo;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "coinInfo=" + coinInfo +
                    ", collectArticleInfo=" + collectArticleInfo +
                    ", userInfo=" + userInfo +
                    '}';
        }

        public static class CoinInfoBean implements Serializable {
            /**
             * coinCount : 980
             * level : 10
             * nickname :
             * rank : 2032
             * userId : 124591
             * username : s**ak_dream
             */

            @SerializedName("coinCount")
            private Integer coinCount;
            @SerializedName("level")
            private Integer level;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("rank")
            private String rank;
            @SerializedName("userId")
            private Integer userId;
            @SerializedName("username")
            private String username;

            public Integer getCoinCount() {
                return coinCount;
            }

            public void setCoinCount(Integer coinCount) {
                this.coinCount = coinCount;
            }

            public Integer getLevel() {
                return level;
            }

            public void setLevel(Integer level) {
                this.level = level;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            @Override
            public String toString() {
                return "CoinInfoBean{" +
                        "coinCount=" + coinCount +
                        ", level=" + level +
                        ", nickname='" + nickname + '\'' +
                        ", rank='" + rank + '\'' +
                        ", userId=" + userId +
                        ", username='" + username + '\'' +
                        '}';
            }
        }

        public static class CollectArticleInfoBean implements Serializable {
            /**
             * count : 3
             */

            @SerializedName("count")
            private Integer count;

            public Integer getCount() {
                return count;
            }

            public void setCount(Integer count) {
                this.count = count;
            }

            @Override
            public String toString() {
                return "CollectArticleInfoBean{" +
                        "count=" + count +
                        '}';
            }
        }

        public static class UserInfoBean implements Serializable {
            /**
             * admin : false
             * chapterTops : []
             * coinCount : 980
             * collectIds : [18752,20087,21681]
             * email : 815172923@qq.com
             * icon :
             * id : 124591
             * nickname : 初学者
             * password :
             * publicName : 初学者
             * token :
             * type : 0
             * username : speak_dream
             */

            @SerializedName("admin")
            private Boolean admin;
            @SerializedName("coinCount")
            private Integer coinCount;
            @SerializedName("email")
            private String email;
            @SerializedName("icon")
            private String icon;
            @SerializedName("id")
            private Integer id;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("password")
            private String password;
            @SerializedName("publicName")
            private String publicName;
            @SerializedName("token")
            private String token;
            @SerializedName("type")
            private Integer type;
            @SerializedName("username")
            private String username;
            @SerializedName("chapterTops")
            private List<?> chapterTops;
            @SerializedName("collectIds")
            private List<Integer> collectIds;

            public Boolean getAdmin() {
                return admin;
            }

            public void setAdmin(Boolean admin) {
                this.admin = admin;
            }

            public Integer getCoinCount() {
                return coinCount;
            }

            public void setCoinCount(Integer coinCount) {
                this.coinCount = coinCount;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
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

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getPublicName() {
                return publicName;
            }

            public void setPublicName(String publicName) {
                this.publicName = publicName;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public Integer getType() {
                return type;
            }

            public void setType(Integer type) {
                this.type = type;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public List<?> getChapterTops() {
                return chapterTops;
            }

            public void setChapterTops(List<?> chapterTops) {
                this.chapterTops = chapterTops;
            }

            public List<Integer> getCollectIds() {
                return collectIds;
            }

            public void setCollectIds(List<Integer> collectIds) {
                this.collectIds = collectIds;
            }

            @Override
            public String toString() {
                return "UserInfoBean{" +
                        "admin=" + admin +
                        ", coinCount=" + coinCount +
                        ", email='" + email + '\'' +
                        ", icon='" + icon + '\'' +
                        ", id=" + id +
                        ", nickname='" + nickname + '\'' +
                        ", password='" + password + '\'' +
                        ", publicName='" + publicName + '\'' +
                        ", token='" + token + '\'' +
                        ", type=" + type +
                        ", username='" + username + '\'' +
                        ", chapterTops=" + chapterTops +
                        ", collectIds=" + collectIds +
                        '}';
            }
        }
    }
}
