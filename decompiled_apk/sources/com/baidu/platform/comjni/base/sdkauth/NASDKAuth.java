package com.baidu.platform.comjni.base.sdkauth;

import com.baidu.platform.comjni.NativeComponent;

/* loaded from: classes8.dex */
public class NASDKAuth extends NativeComponent {
    public NASDKAuth() {
        create();
    }

    private static native long nativeCreate();

    private static native int nativeRelease(long j);

    public static native boolean nativeSetParkAuth(long j, String str);

    public boolean a(String str) {
        return nativeSetParkAuth(this.mNativePointer, str);
    }

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
