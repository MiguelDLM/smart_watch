package com.baidu.tts;

/* loaded from: classes8.dex */
public class f4 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10087a = x3.class.getSimpleName();

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f10088a;
        public byte b;
        public byte[] c;
    }

    public static int a(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = i; i3 < i + 4; i3++) {
            i2 += (bArr[i3] & 255) << (i3 * 8);
        }
        return i2;
    }
}
