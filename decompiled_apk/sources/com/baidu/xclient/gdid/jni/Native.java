package com.baidu.xclient.gdid.jni;

import com.baidu.xclient.gdid.e.g;
import com.huawei.openalliance.ad.constant.x;

/* loaded from: classes8.dex */
public class Native {

    /* renamed from: a, reason: collision with root package name */
    public static String f10237a = "";

    static {
        try {
            System.loadLibrary("tiny_magic");
        } catch (Throwable th) {
            f10237a = g.b(th).replaceAll("\t", x.aL).replaceAll("\n", x.aL);
            throw th;
        }
    }

    public String a() {
        return f10237a;
    }

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] acn(byte[] bArr, byte[] bArr2);

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native byte[] dcn(byte[] bArr, byte[] bArr2);

    public native Object jnictl(int i, Object obj, Object obj2, Object obj3);
}
