package com.baidu.mapapi.search.core;

import java.util.List;

/* loaded from: classes7.dex */
public class RecommendStationStopInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f5943a;
    private List<RecommendStopInfo> b;

    public List<RecommendStopInfo> getRecommendStopInfoList() {
        return this.b;
    }

    public String getStationName() {
        return this.f5943a;
    }

    public void setRecommendStopInfoList(List<RecommendStopInfo> list) {
        this.b = list;
    }

    public void setStationName(String str) {
        this.f5943a = str;
    }
}
