package com.baidu.mapapi.map;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class MapBaseIndoorMapInfo {
    private static final String d = "MapBaseIndoorMapInfo";

    /* renamed from: a, reason: collision with root package name */
    String f5819a;
    String b;
    ArrayList<String> c;

    /* loaded from: classes7.dex */
    public enum SwitchFloorError {
        SWITCH_OK,
        FLOOR_INFO_ERROR,
        FLOOR_OVERLFLOW,
        FOCUSED_ID_ERROR,
        SWITCH_ERROR
    }

    public MapBaseIndoorMapInfo() {
    }

    public String getCurFloor() {
        return this.b;
    }

    public ArrayList<String> getFloors() {
        return this.c;
    }

    public String getID() {
        return this.f5819a;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f5819a = str;
        this.b = str2;
        this.c = arrayList;
    }

    public MapBaseIndoorMapInfo(MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
        this.f5819a = mapBaseIndoorMapInfo.f5819a;
        this.b = mapBaseIndoorMapInfo.b;
        this.c = mapBaseIndoorMapInfo.c;
    }
}
