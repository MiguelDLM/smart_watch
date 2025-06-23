package com.realsil.sdk.dfu.v;

import java.util.Locale;

/* loaded from: classes11.dex */
public class c extends com.realsil.sdk.dfu.j.c {

    /* renamed from: a, reason: collision with root package name */
    public int f19632a;
    public int b;

    @Override // com.realsil.sdk.dfu.j.c
    public short b() {
        return (short) 1544;
    }

    public String toString() {
        return String.format("BufferCheckReq(0x%04X) {", Short.valueOf(b())) + String.format(Locale.US, "\n\tbufferSize=%d, crc16=0x%02X", Integer.valueOf(this.f19632a), Integer.valueOf(this.b)) + "\n}";
    }

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f19633a;
        public int b;

        public b a(byte[] bArr, int i) {
            this.f19633a = bArr;
            this.b = i;
            return this;
        }

        public c a() {
            return new c(this.b, c.b(this.f19633a, this.b));
        }
    }

    public c(int i, int i2) {
        this.f19632a = i;
        this.b = i2;
    }

    public static short b(byte[] bArr, int i) {
        short s = 0;
        for (int i2 = 0; i2 < i; i2 += 2) {
            s = (short) (s ^ ((short) ((bArr[i2 + 1] << 8) | (bArr[i2] & 255))));
        }
        return (short) (((s & 255) << 8) | ((65280 & s) >> 8));
    }

    @Override // com.realsil.sdk.dfu.j.c
    public byte[] a() {
        int i = this.f19632a;
        int i2 = this.b;
        return new byte[]{(byte) (i & 255), (byte) (i >> 8), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255)};
    }
}
