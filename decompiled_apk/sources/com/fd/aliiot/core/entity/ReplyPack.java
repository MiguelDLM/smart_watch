package com.fd.aliiot.core.entity;

import IXX.oIX0oI;

/* loaded from: classes8.dex */
public class ReplyPack {
    private int code;
    private String data;
    private String id;
    private String message;
    private String method;
    private String version;

    public static ReplyPack getInstance() {
        ReplyPack replyPack = new ReplyPack();
        replyPack.setId(String.valueOf(oIX0oI.f745oIX0oI.incrementAndGet()));
        replyPack.setVersion("1.0");
        replyPack.setCode(200);
        replyPack.setMessage("success");
        replyPack.setData("{}");
        return replyPack;
    }

    public int getCode() {
        return this.code;
    }

    public String getData() {
        return this.data;
    }

    public String getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMethod() {
        return this.method;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
