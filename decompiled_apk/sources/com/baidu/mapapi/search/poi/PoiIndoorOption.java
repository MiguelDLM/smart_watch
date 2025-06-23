package com.baidu.mapapi.search.poi;

/* loaded from: classes7.dex */
public class PoiIndoorOption {
    public String bid;
    public String floor;
    public String wd;
    public int currentPage = 0;
    public int pageSize = 10;

    public PoiIndoorOption poiCurrentPage(int i) {
        this.currentPage = i;
        return this;
    }

    public PoiIndoorOption poiFloor(String str) {
        this.floor = str;
        return this;
    }

    public PoiIndoorOption poiIndoorBid(String str) {
        this.bid = str;
        return this;
    }

    public PoiIndoorOption poiIndoorWd(String str) {
        this.wd = str;
        return this;
    }

    public PoiIndoorOption poiPageSize(int i) {
        this.pageSize = i;
        return this;
    }
}
