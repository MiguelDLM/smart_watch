package com.baidu.mapapi.search.geocode;

/* loaded from: classes7.dex */
public class GeoCodeOption {
    public String mCity = null;
    public String mAddress = null;

    public GeoCodeOption address(String str) {
        this.mAddress = str;
        return this;
    }

    public GeoCodeOption city(String str) {
        this.mCity = str;
        return this;
    }

    public String getAddress() {
        return this.mAddress;
    }
}
