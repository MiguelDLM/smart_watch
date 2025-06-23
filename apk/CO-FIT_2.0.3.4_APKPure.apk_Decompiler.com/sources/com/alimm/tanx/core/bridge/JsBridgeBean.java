package com.alimm.tanx.core.bridge;

import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.List;

public class JsBridgeBean implements NotConfused {
    private String clickThroughUrl;
    private String creativeId;
    private String deepLinkUrl;
    private List<NewTrackItem> eventTrack;
    private int openType;
    private String pid;
    private String rawJsonStr;
    private String reqId;
    private String templateId;

    public JsBridgeBean() {
    }

    public String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public String getCreativeId() {
        return this.creativeId;
    }

    public String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public List<NewTrackItem> getEventTrack() {
        return this.eventTrack;
    }

    public int getOpenType() {
        return this.openType;
    }

    public String getPid() {
        return this.pid;
    }

    public String getRawJsonStr() {
        return this.rawJsonStr;
    }

    public String getReqId() {
        return this.reqId;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public void setClickThroughUrl(String str) {
        this.clickThroughUrl = str;
    }

    public void setCreativeId(String str) {
        this.creativeId = str;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public void setEventTrack(List<NewTrackItem> list) {
        this.eventTrack = list;
    }

    public void setOpenType(int i) {
        this.openType = i;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setRawJsonStr(String str) {
        this.rawJsonStr = str;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public JsBridgeBean(BidInfo bidInfo, TanxAdSlot tanxAdSlot) {
        if (tanxAdSlot != null) {
            this.pid = tanxAdSlot.getPid();
            this.reqId = tanxAdSlot.getReqId();
        }
        if (bidInfo != null) {
            this.rawJsonStr = bidInfo.getRawJsonStr();
            this.eventTrack = bidInfo.getEventTrack();
            this.templateId = bidInfo.getTemplateId();
            this.creativeId = bidInfo.getCreativeId();
            this.openType = bidInfo.getOpenType();
            this.deepLinkUrl = bidInfo.getDeepLinkUrl();
            this.clickThroughUrl = bidInfo.getClickThroughUrl();
        }
    }

    public JsBridgeBean(String str, String str2, String str3, List<NewTrackItem> list, String str4, String str5, int i, String str6, String str7) {
        this.pid = str;
        this.reqId = str2;
        this.rawJsonStr = str3;
        this.eventTrack = list;
        this.templateId = str4;
        this.creativeId = str5;
        this.openType = i;
        this.deepLinkUrl = str6;
        this.clickThroughUrl = str7;
    }
}
