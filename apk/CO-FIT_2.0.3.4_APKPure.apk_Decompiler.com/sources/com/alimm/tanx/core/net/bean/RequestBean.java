package com.alimm.tanx.core.net.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.Map;

public class RequestBean extends BaseBean {
    private int cacheOfflineTime;
    private int cacheOnlineTime;
    private Map<String, String> heads;
    private String json;
    private boolean onlyOneNet;
    private boolean overrideError;
    private Map<String, String> params;
    private String tag;
    private int tryAgainCount;
    private String url;

    public static class Builder implements NotConfused {
        /* access modifiers changed from: private */
        public final int cacheOfflineTime = 0;
        /* access modifiers changed from: private */
        public final int cacheOnlineTime = 0;
        /* access modifiers changed from: private */
        public final boolean onlyOneNet = false;
        /* access modifiers changed from: private */
        public final boolean overrideError = false;
        private String tag;
        private final int tryAgainCount = 3;
    }

    public RequestBean build() {
        Builder builder = new Builder();
        this.cacheOfflineTime = builder.cacheOfflineTime;
        this.onlyOneNet = builder.onlyOneNet;
        this.cacheOfflineTime = builder.cacheOfflineTime;
        this.cacheOnlineTime = builder.cacheOnlineTime;
        this.overrideError = builder.overrideError;
        return this;
    }

    public int getCacheOfflineTime() {
        return this.cacheOfflineTime;
    }

    public int getCacheOnlineTime() {
        return this.cacheOnlineTime;
    }

    public Map<String, String> getHeads() {
        return this.heads;
    }

    public String getJson() {
        return this.json;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public String getTag() {
        return this.tag;
    }

    public int getTryAgainCount() {
        return this.tryAgainCount;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isOnlyOneNet() {
        return this.onlyOneNet;
    }

    public boolean isOverrideError() {
        return this.overrideError;
    }

    public RequestBean setCacheOfflineTime(int i) {
        this.cacheOfflineTime = i;
        return this;
    }

    public RequestBean setCacheOnlineTime(int i) {
        this.cacheOnlineTime = i;
        return this;
    }

    public RequestBean setHeads(Map<String, String> map) {
        this.heads = map;
        return this;
    }

    public void setJson(String str) {
        this.json = str;
    }

    public RequestBean setOnlyOneNet(boolean z) {
        this.onlyOneNet = z;
        return this;
    }

    public RequestBean setOverrideError(boolean z) {
        this.overrideError = z;
        return this;
    }

    public RequestBean setParams(Map<String, String> map) {
        this.params = map;
        return this;
    }

    public RequestBean setTag(String str) {
        this.tag = str;
        return this;
    }

    public RequestBean setTryAgainCount(int i) {
        this.tryAgainCount = i;
        return this;
    }

    public RequestBean setUrl(String str) {
        this.url = str;
        return this;
    }

    public String toString() {
        return "RequestBean{url='" + this.url + '\'' + ", heads=" + this.heads + ", params=" + this.params + ", tag='" + this.tag + '\'' + ", cacheOfflineTime=" + this.cacheOfflineTime + ", cacheOnlineTime=" + this.cacheOnlineTime + ", onlyOneNet=" + this.onlyOneNet + ", tryAgainCount=" + this.tryAgainCount + ", overrideError=" + this.overrideError + ", json='" + this.json + '\'' + "} ";
    }
}
