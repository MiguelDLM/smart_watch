package com.jieli.jl_rcsp.util;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;

/* loaded from: classes10.dex */
public class TestLog {
    public static void a(String str, String str2, String str3) {
        System.out.println(str + "--->" + str2 + ":" + str3);
    }

    public static void d(String str, String str2) {
        a("d", str, str2);
    }

    public static void e(String str, String str2) {
        a(e.TAG, str, str2);
    }

    public static void i(String str, String str2) {
        a("i", str, str2);
    }

    public static void v(String str, String str2) {
        a(t.c, str, str2);
    }

    public static void w(String str, String str2) {
        a(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }
}
