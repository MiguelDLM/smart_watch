package com.alimm.tanx.core.ut;

import com.alimm.tanx.core.ad.bean.BaseBean;

/* loaded from: classes.dex */
public class BiddingBean extends BaseBean {
    private String biddingPrice;
    private String creative_id;
    private String is_suc;
    private String pid;
    private String price;
    private String reqId;
    private String sessionId;
    private String template_id;

    public String getBiddingPrice() {
        return this.biddingPrice;
    }

    public String getCreative_id() {
        return this.creative_id;
    }

    public String getIs_suc() {
        return this.is_suc;
    }

    public String getPid() {
        return this.pid;
    }

    public String getPrice() {
        return this.price;
    }

    public String getReqId() {
        return this.reqId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getTemplate_id() {
        return this.template_id;
    }

    public void setBiddingPrice(String str) {
        this.biddingPrice = str;
    }

    public void setCreative_id(String str) {
        this.creative_id = str;
    }

    public void setIs_suc(String str) {
        this.is_suc = str;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setTemplate_id(String str) {
        this.template_id = str;
    }

    public String toString() {
        return "BiddingBean{pid='" + this.pid + "', reqId='" + this.reqId + "', template_id='" + this.template_id + "', creative_id='" + this.creative_id + "', is_suc='" + this.is_suc + "', price='" + this.price + "', biddingPrice='" + this.biddingPrice + "', sessionId='" + this.sessionId + "'} " + super.toString();
    }
}
