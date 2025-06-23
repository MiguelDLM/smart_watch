package com.baidu.platform.comjni.map.dataengine;

import android.os.Bundle;
import com.baidu.platform.comjni.NativeComponent;

/* loaded from: classes8.dex */
public class NADataEngine extends NativeComponent {
    private native void nativeCancelThumbImageRequest(long j);

    private native long nativeCreate();

    private native String nativeGetCurrentStreetId(long j);

    private native String nativeGetCurrentStreetInfo(long j, Bundle bundle);

    private native boolean nativeGetHotMapCityInfo(long j, Bundle bundle);

    private native boolean nativeGetStreetCityInfo(long j, Bundle bundle);

    private native boolean nativeQueryThumbImage(long j, String str);

    private native int nativeRelease(long j);

    private native void nativeSetStreetPOIUID(long j, String str);

    private native boolean nativeStreetSwitchByUID(long j, String str, String str2);

    private native boolean nativeStreetSwitchToID(long j, String str, int i);

    private native boolean nativeStreetSwitchToIDFromReGeo(long j, String str, String str2, long j2, long j3);

    private native boolean nativeStreetSwitchToIID(long j, String str, String str2, boolean z);

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer != 0) {
            int nativeRelease = nativeRelease(this.mNativePointer);
            this.mNativePointer = 0L;
            return nativeRelease;
        }
        return 0;
    }
}
