package com.baidu.platform.comapi.bmsdk.cluster;

import com.baidu.platform.comapi.bmsdk.BmDrawItem;

/* loaded from: classes8.dex */
public class BmClusterGroup extends BmDrawItem {
    private BmClusterGroup() {
        super(14, nativeCreate());
    }

    private static native boolean nativeAddMarker(long j, long j2);

    private static native boolean nativeClearMarkers(long j);

    private static native long nativeCreate();

    private static native boolean nativeRemoveMarker(long j, long j2);

    private static native boolean nativeSetClusterTemplate(long j, long j2);
}
