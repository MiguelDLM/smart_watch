package com.garmin.fit;

import com.baidu.ai.speech.realtime.Util;

/* loaded from: classes9.dex */
public class X00IoxXI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int[] f13502oIX0oI = {0, 52225, 55297, Util.BYTES_PER_FRAME, 61441, 15360, 10240, 58369, 40961, 27648, 30720, 46081, 20480, 39937, 34817, 17408};

    public static final int oIX0oI(int i, byte b) {
        int[] iArr = f13502oIX0oI;
        int i2 = (((i >> 4) & xxXXXxIxo.f15726I0Io) ^ iArr[i & 15]) ^ iArr[b & 15];
        return (((i2 >> 4) & xxXXXxIxo.f15726I0Io) ^ iArr[i2 & 15]) ^ iArr[(b >> 4) & 15];
    }
}
