package com.realsil.sdk.dfu.l;

import java.util.Locale;

/* loaded from: classes11.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public int f19566a;
    public int b;
    public int c;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f19567a;
        public int b;
        public int c;

        public b(int i) {
            this.f19567a = i;
        }

        public b a(int i) {
            this.b = i;
            return this;
        }

        public b b(int i) {
            this.c = i;
            return this;
        }

        public n a() {
            return new n(this.f19567a, this.b, this.c);
        }
    }

    public byte[] a() {
        byte b2 = b();
        int i = this.b;
        int i2 = this.c;
        return new byte[]{b2, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)};
    }

    public byte b() {
        return (byte) 2;
    }

    public String toString() {
        return String.format("ValidateFwImageCmd(0x%02X) {", Byte.valueOf(b())) + String.format(Locale.US, "\n\timageId=0x%04X, offset=0x%08X(%d)", Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.c)) + "\n}";
    }

    public n(int i, int i2, int i3) {
        this.f19566a = i;
        this.b = i2;
        this.c = i3;
    }
}
