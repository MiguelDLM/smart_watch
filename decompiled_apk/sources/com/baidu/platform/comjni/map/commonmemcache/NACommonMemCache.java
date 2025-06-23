package com.baidu.platform.comjni.map.commonmemcache;

import com.baidu.platform.comjni.NativeComponent;

/* loaded from: classes8.dex */
public class NACommonMemCache extends NativeComponent {
    public NACommonMemCache() {
        create();
    }

    private static native long nativeCreate();

    private static native String nativeDecodeUsync(long j, String str);

    private static native String nativeEnCrypt(long j, String str);

    private static native String nativeEnCryptWithType(long j, String str, String str2);

    private static native String nativeEnCryptWithUsync(long j, String str);

    private static native String nativeGetKeyBundleString(long j, String str);

    private static native String nativeGetKeyString(long j, String str);

    private static native String nativeGetPhoneInfoBundle(long j, boolean z);

    private static native String nativeGetPhoneInfoUrl(long j);

    private static native String nativeGetSataInfo(long j, boolean z, int i, int i2);

    private static native void nativeInit(long j, String str);

    private static native int nativeRelease(long j);

    private static native void nativeSetKeyBundle(long j, String str, String str2);

    private static native void nativeSetKeyDouble(long j, String str, double d);

    private static native void nativeSetKeyFloat(long j, String str, float f);

    private static native void nativeSetKeyInt(long j, String str, int i);

    private static native void nativeSetKeyString(long j, String str, String str2);

    public void a(String str) {
        nativeInit(this.mNativePointer, str);
    }

    public String b(String str) {
        return nativeGetKeyBundleString(this.mNativePointer, str);
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

    public void a(String str, String str2) {
        nativeSetKeyString(this.mNativePointer, str, str2);
    }

    public void b(String str, String str2) {
        nativeSetKeyBundle(this.mNativePointer, str, str2);
    }
}
