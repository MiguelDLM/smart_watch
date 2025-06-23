package com.realsil.sdk.dfu.v;

import java.util.Locale;

/* loaded from: classes11.dex */
public class j extends com.realsil.sdk.dfu.j.c {

    /* renamed from: a, reason: collision with root package name */
    public int f19639a;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f19640a;

        public b(int i) {
            this.f19640a = i;
        }

        public j a() {
            return new j(this.f19640a);
        }
    }

    @Override // com.realsil.sdk.dfu.j.c
    public byte[] a() {
        int i = this.f19639a;
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    @Override // com.realsil.sdk.dfu.j.c
    public short b() {
        return (short) 1545;
    }

    public String toString() {
        return String.format("GeTargetImageInfoReq(0x%04X) {", Short.valueOf(b())) + String.format(Locale.US, "\n\timageId=0x%02X", Integer.valueOf(this.f19639a)) + "\n}";
    }

    public j(int i) {
        this.f19639a = i;
    }
}
