package com.baidu.mapapi.search.poi;

/* loaded from: classes7.dex */
public class PoiDetailSearchOption {

    /* renamed from: a, reason: collision with root package name */
    private String f5959a = "";
    private boolean b = true;
    private String c = "";
    private boolean d = false;

    public PoiDetailSearchOption extendAdcode(boolean z) {
        this.b = z;
        return this;
    }

    public String getUid() {
        return this.f5959a;
    }

    public String getUids() {
        return this.c;
    }

    public boolean isExtendAdcode() {
        return this.b;
    }

    public boolean isSearchByUids() {
        return this.d;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.d = false;
        this.f5959a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.d = true;
        this.c = str;
        return this;
    }
}
