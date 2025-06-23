package com.qq.e.comm.managers.plugin;

/* loaded from: classes11.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f19451a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", com.kwad.sdk.m.e.TAG, com.baidu.mapsdkplatform.comapi.f.f6163a};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = f19451a;
            sb.append(strArr[i / 16]);
            sb.append(strArr[i % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
