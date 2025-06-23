package com.baidu.ar.baidumap.bean;

import java.util.List;

/* loaded from: classes7.dex */
public class VpasResource {
    private List<NavigationContent> mNavigationContents;
    private NavigationRes mNavigationRes;

    public List<NavigationContent> getNavigationContents() {
        return this.mNavigationContents;
    }

    public NavigationRes getNavigationRes() {
        return this.mNavigationRes;
    }

    public void setNavigationContents(List<NavigationContent> list) {
        this.mNavigationContents = list;
    }

    public void setNavigationRes(NavigationRes navigationRes) {
        this.mNavigationRes = navigationRes;
    }
}
