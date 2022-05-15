package com.program.wanandroiddemo.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 收藏文章
 */

public class CollectArticle implements Serializable {

    /**
     * data : null
     * errorCode : 0
     * errorMsg :
     */

    @SerializedName("data")
    private Object data;
    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
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
        return "CollectArticle{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
