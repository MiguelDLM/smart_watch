package com.alimm.tanx.core.ut.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class UtItemBean extends BaseBean {
    public String arg1;
    public String arg2;
    public String arg3;
    public Map args;
    public int eventId;
    public int eventStatus;
    public long eventTime = System.currentTimeMillis();
    public String page;
    public String pid;
    public String reqId;
    public String sessionId;

    public UtItemBean() {
    }

    public boolean equals(UtItemBean utItemBean) {
        if (hashCode() == utItemBean.hashCode()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.reqId, this.pid, this.page, Integer.valueOf(this.eventId), Integer.valueOf(this.eventStatus), this.arg1, this.arg2, this.arg3, this.args, this.sessionId);
    }

    public String toString() {
        return "UtItemBean{ eventId=" + this.eventId + ", reqId='" + this.reqId + "', pid='" + this.pid + "', page='" + this.page + "', eventTime=" + this.eventTime + ", eventStatus=" + this.eventStatus + ", arg1='" + this.arg1 + "', arg2='" + this.arg2 + "', arg3='" + this.arg3 + "', args='" + this.args + "', sessionId='" + this.sessionId + "'} " + super.toString();
    }

    public UtItemBean(String str, int i, String str2, String str3, String str4, Map<String, Object> map) {
        this.page = str;
        this.eventId = i;
        this.arg1 = str2;
        this.arg2 = str3;
        this.arg3 = str4;
        this.args = map;
    }

    public UtItemBean(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, Map<String, Object> map, String str7) {
        this.reqId = str;
        this.pid = str2;
        this.page = str3;
        this.eventId = i;
        this.eventStatus = i2;
        this.arg1 = str4;
        this.arg2 = str5;
        this.arg3 = str6;
        this.args = map;
        this.sessionId = str7;
    }
}
