package com.baidu.platform.comapi.bmsdk;

/* loaded from: classes8.dex */
public class BmTextMarker extends BmBaseMarker {
    public BmTextMarker() {
        super(5, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetStyle(long j, long j2);

    private static native boolean nativeSetText(long j, String str);
}
