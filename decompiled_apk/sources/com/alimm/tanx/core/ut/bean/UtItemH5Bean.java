package com.alimm.tanx.core.ut.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class UtItemH5Bean extends BaseBean {
    public String arg1;
    public String arg2;
    public String arg3;
    public Map<String, Object> args;
    public int eventId;
    public int eventStatus;
    public long eventTime;
    public String page;
    public String pid;
    public String reqId;

    public UtItemH5Bean() {
        this.args = new HashMap();
        this.eventTime = System.currentTimeMillis();
    }

    public UtItemH5Bean buildH5UtItemBean(UtItemH5Bean utItemH5Bean) {
        this.page = utItemH5Bean.page;
        this.eventId = utItemH5Bean.eventId;
        this.eventStatus = utItemH5Bean.eventStatus;
        this.arg1 = utItemH5Bean.arg1;
        this.arg2 = utItemH5Bean.arg2;
        this.arg3 = utItemH5Bean.arg3;
        this.args = utItemH5Bean.args;
        return this;
    }

    public UtItemH5Bean(String str, int i, String str2, String str3, String str4, Map<String, Object> map) {
        this.args = new HashMap();
        this.page = str;
        this.eventId = i;
        this.eventTime = System.currentTimeMillis();
        this.arg1 = str2;
        this.arg2 = str3;
        this.arg3 = str4;
        this.args = map;
    }

    public UtItemH5Bean(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, Map<String, Object> map) {
        this.args = new HashMap();
        this.reqId = str;
        this.pid = str2;
        this.page = str3;
        this.eventId = i;
        this.eventTime = System.currentTimeMillis();
        this.eventStatus = i2;
        this.arg1 = str4;
        this.arg2 = str5;
        this.arg3 = str6;
        this.args = map;
    }
}
