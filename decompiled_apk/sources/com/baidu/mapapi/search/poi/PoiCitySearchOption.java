package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.search.base.LanguageType;

/* loaded from: classes7.dex */
public class PoiCitySearchOption {
    public String mCity = null;
    public String mKeyword = null;
    public int mPageNum = 0;
    public int mPageCapacity = 10;
    public boolean mIsReturnAddr = true;
    public String mTag = "";
    public int mScope = 1;
    public boolean mIsCityLimit = true;
    public PoiFilter mPoiFilter = null;
    public boolean mIsExtendAdcode = true;
    public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;

    public PoiCitySearchOption city(String str) {
        this.mCity = str;
        return this;
    }

    public PoiCitySearchOption cityLimit(boolean z) {
        this.mIsCityLimit = z;
        return this;
    }

    public PoiCitySearchOption extendAdcode(boolean z) {
        this.mIsExtendAdcode = z;
        return this;
    }

    public boolean isExtendAdcode() {
        return this.mIsExtendAdcode;
    }

    public PoiCitySearchOption isReturnAddr(boolean z) {
        this.mIsReturnAddr = z;
        return this;
    }

    public PoiCitySearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public PoiCitySearchOption language(LanguageType languageType) {
        this.mLanguageType = languageType;
        return this;
    }

    public PoiCitySearchOption pageCapacity(int i) {
        this.mPageCapacity = i;
        return this;
    }

    public PoiCitySearchOption pageNum(int i) {
        this.mPageNum = i;
        return this;
    }

    public PoiCitySearchOption poiFilter(PoiFilter poiFilter) {
        this.mPoiFilter = poiFilter;
        return this;
    }

    public PoiCitySearchOption scope(int i) {
        this.mScope = i;
        return this;
    }

    public PoiCitySearchOption tag(String str) {
        this.mTag = str;
        return this;
    }
}
