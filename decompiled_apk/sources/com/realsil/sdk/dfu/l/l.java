package com.realsil.sdk.dfu.l;

import java.util.Locale;

/* loaded from: classes11.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public int f19562a;
    public int b;

    public byte b() {
        return (byte) 10;
    }

    public String toString() {
        return String.format("ReportBufferCheckResultCmd(0x%04X) {", Byte.valueOf(b())) + String.format(Locale.US, "\n\tbufferSize=%d, crc16=0x%02X", Integer.valueOf(this.f19562a), Integer.valueOf(this.b)) + "\n}";
    }

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f19563a;
        public int b;

        public b a(byte[] bArr, int i) {
            this.f19563a = bArr;
            this.b = i;
            return this;
        }

        public l a() {
            return new l(this.b, l.b(this.f19563a, this.b));
        }
    }

    public l(int i, int i2) {
        this.f19562a = i;
        this.b = i2;
    }

    public static short b(byte[] bArr, int i) {
        short s = 0;
        for (int i2 = 0; i2 < i; i2 += 2) {
            s = (short) (s ^ ((short) ((bArr[i2 + 1] << 8) | (bArr[i2] & 255))));
        }
        return (short) (((s & 255) << 8) | ((65280 & s) >> 8));
    }

    public byte[] a() {
        byte b2 = b();
        int i = this.f19562a;
        int i2 = this.b;
        return new byte[]{b2, (byte) (i & 255), (byte) (i >> 8), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255)};
    }
}
