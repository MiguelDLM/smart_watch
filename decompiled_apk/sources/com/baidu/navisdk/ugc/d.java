package com.baidu.navisdk.ugc;

import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f8019a = false;

    public static void a(boolean z) {
        f8019a = z;
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_External", "setIsUserOperating: " + f8019a);
        }
    }

    public static boolean a() {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_External", "isUserOperating: " + f8019a);
        }
        return f8019a;
    }
}
