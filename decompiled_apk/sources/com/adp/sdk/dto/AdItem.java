package com.adp.sdk.dto;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class AdItem implements Serializable {
    private String adSize;
    private List<SourceVO> adSource;
    private String adUnitId;
    private String baidu;
    private ButtonVO button;
    private String bytedance;
    private boolean enable;
    private String facebook;
    private boolean fullScreen;
    private List<GameDTO> games;
    private String google;
    private String googleSplash;
    private AdItem interstitial;
    private String interval;
    private boolean isOpenLogs = true;
    private String orientation;
    private String rate;
    private String showCount;
    private String showType;
    private String style;
    private String tencent;
    private String time;
    private String timeout;
    private String type;

    public String getAdSize() {
        return this.adSize;
    }

    public List<SourceVO> getAdSource() {
        return this.adSource;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getBaidu() {
        return this.baidu;
    }

    public ButtonVO getButton() {
        return this.button;
    }

    public String getBytedance() {
        return this.bytedance;
    }

    public String getFacebook() {
        return this.facebook;
    }

    public boolean getFullScreen() {
        return this.fullScreen;
    }

    public List<GameDTO> getGames() {
        return this.games;
    }

    public String getGoogle() {
        return this.google;
    }

    public String getGoogleSplash() {
        return this.googleSplash;
    }

    public AdItem getInterstitial() {
        return this.interstitial;
    }

    public String getInterval() {
        return this.interval;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public String getRate() {
        return this.rate;
    }

    public String getShowCount() {
        return this.showCount;
    }

    public String getShowType() {
        return this.showType;
    }

    public String getStyle() {
        return this.style;
    }

    public String getTencent() {
        return this.tencent;
    }

    public String getTime() {
        return this.time;
    }

    public String getTimeout() {
        return this.timeout;
    }

    public String getType() {
        return this.type;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isFullScreen() {
        return this.fullScreen;
    }

    public boolean isOpenLogs() {
        return this.isOpenLogs;
    }

    public void setAdSize(String str) {
        this.adSize = str;
    }

    public void setAdSource(List<SourceVO> list) {
        this.adSource = list;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setBaidu(String str) {
        this.baidu = str;
    }

    public void setButton(ButtonVO buttonVO) {
        this.button = buttonVO;
    }

    public void setBytedance(String str) {
        this.bytedance = str;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setFacebook(String str) {
        this.facebook = str;
    }

    public void setFullScreen(boolean z) {
        this.fullScreen = z;
    }

    public void setGames(List<GameDTO> list) {
        this.games = list;
    }

    public void setGoogle(String str) {
        this.google = str;
    }

    public void setGoogleSplash(String str) {
        this.googleSplash = str;
    }

    public void setInterstitial(AdItem adItem) {
        this.interstitial = adItem;
    }

    public void setInterval(String str) {
        this.interval = str;
    }

    public void setOpenLogs(boolean z) {
        this.isOpenLogs = z;
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public void setRate(String str) {
        this.rate = str;
    }

    public void setShowCount(String str) {
        this.showCount = str;
    }

    public void setShowType(String str) {
        this.showType = str;
    }

    public void setStyle(String str) {
        this.style = str;
    }

    public void setTencent(String str) {
        this.tencent = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setTimeout(String str) {
        this.timeout = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
