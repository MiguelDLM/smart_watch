package com.realsil.sdk.dfu.l;

import java.util.Locale;

/* loaded from: classes11.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public int f19571a;
    public int b;
    public int c;
    public byte d;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f19572a;
        public int b;
        public int c;
        public byte d;

        public b(int i, int i2) {
            this.f19572a = i;
            this.b = i2;
        }

        public b a(int i) {
            this.c = i;
            return this;
        }

        public b a(byte b) {
            this.d = b;
            return this;
        }

        public q a() {
            return new q(this.f19572a, this.b, this.c, this.d);
        }
    }

    public byte[] a() {
        int i = this.f19571a;
        if (i != 20 && i != 21) {
            if (this.b >= 2) {
                int i2 = this.c;
                return new byte[]{c(), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), this.d};
            }
            int i3 = this.c;
            return new byte[]{c(), (byte) (i3 & 255), (byte) ((i3 >> 8) & 255)};
        }
        return b();
    }

    public final byte[] b() {
        byte c = c();
        int i = this.c;
        return new byte[]{c, (byte) (i & 255), (byte) ((i >> 8) & 255), this.d};
    }

    public byte c() {
        return (byte) 3;
    }

    public String toString() {
        return String.format("ValidateFwImageCmd(0x%04X-0x%02X:0x%02X) {", Integer.valueOf(this.f19571a), Integer.valueOf(this.b), Byte.valueOf(c())) + String.format(Locale.US, "\n\timageId=0x%04X, flag=0x%02X", Integer.valueOf(this.c), Byte.valueOf(this.d)) + "\n}";
    }

    public q(int i, int i2, int i3, byte b2) {
        this.f19571a = i;
        this.b = i2;
        this.c = i3;
        this.d = b2;
    }
}
