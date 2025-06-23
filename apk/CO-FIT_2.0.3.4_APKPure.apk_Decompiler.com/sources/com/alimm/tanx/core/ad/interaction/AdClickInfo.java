package com.alimm.tanx.core.ad.interaction;

import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdClickInfo implements NotConfused {
    private int adType = -1;
    private AdUtConstants adUtConstants;
    private String clickThroughUrl;
    private String creativeId;
    private String deepLinkUrl;
    private List<NewTrackItem> eventTrack;
    private int openType = -1;
    private String pid;
    private String pidStyleId;
    private String rawJsonStr;
    private String reqId;
    private String sessionId;
    private String templateId;
    private Map<String, String> utArgs = new HashMap();
    private String webClickThroughUrl;
    private String webDeepLinkUrl;

    public AdClickInfo(int i, String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, AdUtConstants adUtConstants2, String str9, String str10, String str11, List<NewTrackItem> list) {
        this.adType = i;
        this.creativeId = str;
        this.openType = i2;
        this.templateId = str2;
        this.sessionId = str3;
        this.pidStyleId = str4;
        this.pid = str5;
        this.reqId = str6;
        this.clickThroughUrl = str7;
        this.deepLinkUrl = str8;
        this.adUtConstants = adUtConstants2;
        this.webClickThroughUrl = str9;
        this.webDeepLinkUrl = str10;
        this.rawJsonStr = str11;
        this.eventTrack = list;
    }

    public int getAdType() {
        return this.adType;
    }

    public AdUtConstants getAdUtConstants() {
        return this.adUtConstants;
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

    public String getPidStyleId() {
        return this.pidStyleId;
    }

    public String getRawJsonStr() {
        return this.rawJsonStr;
    }

    public String getReqId() {
        return this.reqId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public Map<String, String> getUtArgs() {
        return this.utArgs;
    }

    public String getWebClickThroughUrl() {
        return this.webClickThroughUrl;
    }

    public String getWebDeepLinkUrl() {
        return this.webDeepLinkUrl;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setAdUtConstants(AdUtConstants adUtConstants2) {
        this.adUtConstants = adUtConstants2;
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

    public void setPidStyleId(String str) {
        this.pidStyleId = str;
    }

    public void setRawJsonStr(String str) {
        this.rawJsonStr = str;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setUtArgs(Map<String, String> map) {
        this.utArgs = map;
    }

    public void setWebClickThroughUrl(String str) {
        this.webClickThroughUrl = str;
    }

    public void setWebDeepLinkUrl(String str) {
        this.webDeepLinkUrl = str;
    }
}
