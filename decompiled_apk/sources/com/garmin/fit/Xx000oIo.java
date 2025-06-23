package com.garmin.fit;

import com.baidu.ai.speech.realtime.Util;
import java.util.zip.Checksum;

/* loaded from: classes9.dex */
public class Xx000oIo implements Checksum {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int[] f14142II0xO0 = {0, 52225, 55297, Util.BYTES_PER_FRAME, 61441, 15360, 10240, 58369, 40961, 27648, 30720, 46081, 20480, 39937, 34817, 17408};

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f14143oIX0oI;

    public Xx000oIo() {
        reset();
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.f14143oIX0oI;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.f14143oIX0oI = 0;
    }

    @Override // java.util.zip.Checksum
    public void update(int i) {
        int[] iArr = f14142II0xO0;
        int i2 = this.f14143oIX0oI;
        int i3 = iArr[i2 & 15];
        int i4 = (i2 >> 4) & xxXXXxIxo.f15726I0Io;
        this.f14143oIX0oI = i4;
        int i5 = (i4 ^ i3) ^ iArr[i & 15];
        this.f14143oIX0oI = i5;
        int i6 = iArr[i5 & 15];
        int i7 = (i5 >> 4) & xxXXXxIxo.f15726I0Io;
        this.f14143oIX0oI = i7;
        this.f14143oIX0oI = iArr[(i >> 4) & 15] ^ (i7 ^ i6);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i, int i2) {
        while (i < i2) {
            update(bArr[i]);
            i++;
        }
    }
}
