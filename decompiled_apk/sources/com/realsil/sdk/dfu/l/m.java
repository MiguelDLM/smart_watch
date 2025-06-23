package com.realsil.sdk.dfu.l;

import java.util.Locale;

/* loaded from: classes11.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public int f19564a;
    public int b;
    public int c;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f19565a;
        public int b;
        public int c;
        public int d;

        public b(int i) {
            this.f19565a = i;
        }

        public b a(int i) {
            this.b = i;
            return this;
        }

        public b a(int i, int i2) {
            this.c = i;
            this.d = i2;
            return this;
        }

        public m a() {
            return new m(this.b, this.c, this.d);
        }
    }

    public byte[] a() {
        byte b2 = b();
        int i = this.f19564a;
        return new byte[]{b2, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) (this.b & 255), (byte) (this.c & 255)};
    }

    public byte b() {
        return (byte) 18;
    }

    public String toString() {
        return String.format("ReportImageNumberCmd(0x%02X) {", Byte.valueOf(b())) + String.format(Locale.US, "\n\t%d/%d imageId=0x%04X", Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.f19564a)) + "\n}";
    }

    public m(int i, int i2, int i3) {
        this.f19564a = i;
        this.b = i2;
        this.c = i3;
    }
}
