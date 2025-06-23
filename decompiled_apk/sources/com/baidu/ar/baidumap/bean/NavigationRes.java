package com.baidu.ar.baidumap.bean;

import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class NavigationRes {
    private String arkey;
    private Object extra;
    private List<HashMap<String, Object>> navigationContents;
    private String url;
    private String version;

    public String getArkey() {
        return this.arkey;
    }

    public Object getExtra() {
        return this.extra;
    }

    public List<HashMap<String, Object>> getNavigationContents() {
        return this.navigationContents;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setArkey(String str) {
        this.arkey = str;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public void setNavigationContents(List<HashMap<String, Object>> list) {
        this.navigationContents = list;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
