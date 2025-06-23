package com.baidu.platform.comapi.bmsdk;

/* loaded from: classes8.dex */
public class BmTextPathMarker extends BmDrawItem {
    public BmTextPathMarker() {
        super(6, nativeCreate());
    }

    private static native boolean nativeAddGeoElement(long j, long j2);

    private static native boolean nativeClearGeoElements(long j);

    private static native long nativeCreate();

    private static native boolean nativeSetGeoElement(long j, long j2);

    private static native boolean nativeSetStyle(long j, long j2);

    private static native boolean nativeSetText(long j, String str);
}
