package com.realsil.sdk.dfu.v;

import java.util.Locale;

/* loaded from: classes11.dex */
public class e extends com.realsil.sdk.dfu.j.c {

    /* renamed from: a, reason: collision with root package name */
    public com.realsil.sdk.dfu.s.c f19636a;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public com.realsil.sdk.dfu.s.c f19637a;

        public b a(com.realsil.sdk.dfu.s.c cVar) {
            this.f19637a = cVar;
            return this;
        }

        public e a() {
            return new e(this.f19637a);
        }
    }

    @Override // com.realsil.sdk.dfu.j.c
    public byte[] a() {
        return a(false);
    }

    @Override // com.realsil.sdk.dfu.j.c
    public short b() {
        return (short) 1552;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CheckSha256Req(0x%04X) {", Short.valueOf(b())));
        com.realsil.sdk.dfu.s.c cVar = this.f19636a;
        if (cVar != null) {
            sb.append(String.format(Locale.US, "\n\t%s", cVar.toString()));
        }
        sb.append("\n}");
        return sb.toString();
    }

    public e(com.realsil.sdk.dfu.s.c cVar) {
        this.f19636a = cVar;
    }

    public byte[] a(boolean z) {
        com.realsil.sdk.dfu.s.c cVar = this.f19636a;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }
}
