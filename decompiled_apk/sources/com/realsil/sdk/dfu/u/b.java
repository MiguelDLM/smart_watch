package com.realsil.sdk.dfu.u;

import java.util.Locale;

/* loaded from: classes11.dex */
public class b extends com.realsil.sdk.dfu.j.c {

    /* renamed from: a, reason: collision with root package name */
    public int f19610a;

    /* renamed from: com.realsil.sdk.dfu.u.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0920b {

        /* renamed from: a, reason: collision with root package name */
        public int f19611a;

        public C0920b(int i) {
            this.f19611a = i;
        }

        public b a() {
            return new b(this.f19611a);
        }
    }

    @Override // com.realsil.sdk.dfu.j.c
    public byte[] a() {
        int i = this.f19610a;
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    @Override // com.realsil.sdk.dfu.j.c
    public short b() {
        return (short) 1545;
    }

    public String toString() {
        return String.format("GeTargetImageInfoReq(0x%04X) {", Short.valueOf(b())) + String.format(Locale.US, "\n\timageId=0x%02X", Integer.valueOf(this.f19610a)) + "\n}";
    }

    public b(int i) {
        this.f19610a = i;
    }
}
