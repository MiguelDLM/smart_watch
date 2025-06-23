package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public class SuggestionSearchOption {
    public String mCity = null;
    public String mKeyword = null;
    public LatLng mLocation = null;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6001a = true;
    public Boolean mCityLimit = Boolean.FALSE;

    public SuggestionSearchOption city(String str) {
        this.mCity = str;
        return this;
    }

    public SuggestionSearchOption citylimit(Boolean bool) {
        this.mCityLimit = bool;
        return this;
    }

    public SuggestionSearchOption extendAdcode(boolean z) {
        this.f6001a = z;
        return this;
    }

    public boolean isExtendAdcode() {
        return this.f6001a;
    }

    public SuggestionSearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public SuggestionSearchOption location(LatLng latLng) {
        this.mLocation = latLng;
        return this;
    }
}
