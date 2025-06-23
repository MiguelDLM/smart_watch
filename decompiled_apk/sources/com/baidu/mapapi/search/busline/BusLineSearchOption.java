package com.baidu.mapapi.search.busline;

/* loaded from: classes7.dex */
public class BusLineSearchOption {
    public String mUid = null;
    public String mCity = null;

    public BusLineSearchOption city(String str) {
        this.mCity = str;
        return this;
    }

    public BusLineSearchOption uid(String str) {
        this.mUid = str;
        return this;
    }
}
