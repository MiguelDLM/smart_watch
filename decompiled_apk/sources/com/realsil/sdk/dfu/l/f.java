package com.realsil.sdk.dfu.l;

import java.util.Locale;

/* loaded from: classes11.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public int f19555a;
    public int b;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f19556a;
        public int b;

        public b a(int i) {
            this.b = i;
            return this;
        }

        public f a() {
            return new f(this.f19556a, this.b);
        }
    }

    public byte[] a() {
        byte b2 = b();
        int i = this.b;
        return new byte[]{b2, (byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    public byte b() {
        return (byte) 12;
    }

    public String toString() {
        return String.format("CopyImageReq(0x%02X) {", Byte.valueOf(b())) + String.format(Locale.US, "\n\timageId=0x%04X", Integer.valueOf(this.b)) + "\n}";
    }

    public f(int i, int i2) {
        this.f19555a = i;
        this.b = i2;
    }
}
