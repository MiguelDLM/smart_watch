package com.fd.aliiot.core.entity;

import IXX.oIX0oI;
import com.alibaba.fastjson.JSON;

/* loaded from: classes8.dex */
public class Id2ReplyPack {
    private int code;
    private String data;
    private String id;

    public static String addData(Id2ReplyPack id2ReplyPack) {
        return addData(id2ReplyPack, "{\"Result\":0}");
    }

    public static Id2ReplyPack getInstance() {
        Id2ReplyPack id2ReplyPack = new Id2ReplyPack();
        id2ReplyPack.setId(String.valueOf(oIX0oI.f745oIX0oI.incrementAndGet()));
        id2ReplyPack.setCode(200);
        return id2ReplyPack;
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

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public static String addData(Id2ReplyPack id2ReplyPack, String str) {
        id2ReplyPack.setData("");
        String[] split = JSON.toJSONString(id2ReplyPack).split("\"data\":\"\"");
        return split[0] + "\"data\":" + str + split[1];
    }
}
