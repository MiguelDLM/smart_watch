package com.realsil.sdk.dfu.r;

import java.util.Locale;

/* loaded from: classes11.dex */
public class c extends com.realsil.sdk.dfu.j.c {

    /* renamed from: a, reason: collision with root package name */
    public com.realsil.sdk.dfu.s.c f19597a;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public com.realsil.sdk.dfu.s.c f19598a;

        public b a(com.realsil.sdk.dfu.s.c cVar) {
            this.f19598a = cVar;
            return this;
        }

        public c a() {
            return new c(this.f19598a);
        }
    }

    @Override // com.realsil.sdk.dfu.j.c
    public byte[] a() {
        byte[] a2 = this.f19597a.a();
        byte[] bArr = new byte[a2.length + 1];
        bArr[0] = (byte) (b() & 255);
        if (a2.length == 32) {
            System.arraycopy(a2, 0, bArr, 1, a2.length);
        }
        return bArr;
    }

    @Override // com.realsil.sdk.dfu.j.c
    public short b() {
        return (short) 15;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CheckSha256Req(0x%04X) {", Short.valueOf(b())));
        com.realsil.sdk.dfu.s.c cVar = this.f19597a;
        if (cVar != null) {
            sb.append(String.format(Locale.US, "\n\tsha256=%s", cVar.toString()));
        }
        sb.append("\n}");
        return sb.toString();
    }

    public c(com.realsil.sdk.dfu.s.c cVar) {
        this.f19597a = cVar;
    }
}
