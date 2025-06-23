package com.baidu.mapapi.map;

/* loaded from: classes7.dex */
public class OverlayUtil {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5843a = false;
    private static boolean b = true;

    public static boolean isOverlayUpgrade() {
        return b;
    }

    public static void setOverlayUpgrade(boolean z) {
        if (com.baidu.mapsdkplatform.comapi.map.i.c() == 0) {
            b = z;
        }
    }
}
