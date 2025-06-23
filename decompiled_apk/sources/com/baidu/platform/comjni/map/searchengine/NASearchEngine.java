package com.baidu.platform.comjni.map.searchengine;

import com.baidu.platform.comjni.NativeComponent;

/* loaded from: classes8.dex */
public class NASearchEngine extends NativeComponent {
    public NASearchEngine() {
        create();
    }

    private static native boolean nativeCancelRequest(long j, int i);

    private static native long nativeCreate();

    private static native String nativeGetJsonResult(long j, int i);

    private static native byte[] nativeGetProtobufResult(long j, int i);

    private static native boolean nativeInit(long j, int i);

    private static native boolean nativeInitWithBundle(long j, String str);

    private static native int nativeRelease(long j);

    private static native int nativeRequest(long j, String str);

    private static native boolean nativeRequestData(long j, byte[] bArr);

    private static native void nativeUpdateOfflineSearchPath(long j, String str);

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer != 0) {
            return nativeRelease(this.mNativePointer);
        }
        return 0;
    }
}
