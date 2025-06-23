package com.alibaba.aliagentsdk.domain;

/* loaded from: classes.dex */
public class ID2Data {
    private String msg;
    private String topic;

    public ID2Data(String str, String str2) {
        this.topic = str;
        this.msg = str2;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setTopic(String str) {
        this.topic = str;
    }
}
