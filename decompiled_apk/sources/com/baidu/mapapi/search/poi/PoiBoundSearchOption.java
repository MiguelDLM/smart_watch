package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.LanguageType;

/* loaded from: classes7.dex */
public class PoiBoundSearchOption {
    public LatLngBounds mBound = null;
    public boolean mIsExtendAdcode = true;
    public String mKeyword = null;
    public int mPageNum = 0;
    public int mPageCapacity = 10;
    public String mTag = "";
    public int mScope = 1;
    public PoiFilter mPoiFilter = null;
    public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;

    public PoiBoundSearchOption bound(LatLngBounds latLngBounds) {
        this.mBound = latLngBounds;
        return this;
    }

    public PoiBoundSearchOption extendAdcode(boolean z) {
        this.mIsExtendAdcode = z;
        return this;
    }

    public boolean isExtendAdcode() {
        return this.mIsExtendAdcode;
    }

    public PoiBoundSearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public PoiBoundSearchOption language(LanguageType languageType) {
        this.mLanguageType = languageType;
        return this;
    }

    public PoiBoundSearchOption pageCapacity(int i) {
        this.mPageCapacity = i;
        return this;
    }

    public PoiBoundSearchOption pageNum(int i) {
        this.mPageNum = i;
        return this;
    }

    public PoiBoundSearchOption poiFilter(PoiFilter poiFilter) {
        this.mPoiFilter = poiFilter;
        return this;
    }

    public PoiBoundSearchOption scope(int i) {
        this.mScope = i;
        return this;
    }

    public PoiBoundSearchOption tag(String str) {
        this.mTag = str;
        return this;
    }
}
