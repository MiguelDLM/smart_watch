package com.baidu.mapapi.navi;

import com.baidu.mapapi.navi.NaviParaOption;

/* loaded from: classes7.dex */
/* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f5929a;

    static {
        int[] iArr = new int[NaviParaOption.NaviRoutePolicy.values().length];
        f5929a = iArr;
        try {
            iArr[NaviParaOption.NaviRoutePolicy.BLK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f5929a[NaviParaOption.NaviRoutePolicy.TIME.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f5929a[NaviParaOption.NaviRoutePolicy.DIS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f5929a[NaviParaOption.NaviRoutePolicy.FEE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f5929a[NaviParaOption.NaviRoutePolicy.HIGHWAY.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f5929a[NaviParaOption.NaviRoutePolicy.DEFAULT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
