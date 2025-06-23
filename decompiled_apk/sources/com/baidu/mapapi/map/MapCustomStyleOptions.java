package com.baidu.mapapi.map;

/* loaded from: classes7.dex */
public class MapCustomStyleOptions {

    /* renamed from: a, reason: collision with root package name */
    private String f5821a;
    private String b;

    public MapCustomStyleOptions customStyleId(String str) {
        this.b = str;
        return this;
    }

    public String getCustomMapStyleId() {
        return this.b;
    }

    public String getLocalCustomStyleFilePath() {
        return this.f5821a;
    }

    public MapCustomStyleOptions localCustomStylePath(String str) {
        this.f5821a = str;
        return this;
    }
}
