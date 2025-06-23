package com.baidu.navisdk.pronavi.data.vm.devicestate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7702a;

    @OOXIXo
    private String b;
    private int c;

    public e(boolean z, @OOXIXo String vdrContent, int i) {
        IIX0o.x0xO0oo(vdrContent, "vdrContent");
        this.f7702a = z;
        this.b = vdrContent;
        this.c = i;
    }

    @OOXIXo
    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final boolean c() {
        return this.f7702a;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f7702a == eVar.f7702a && IIX0o.Oxx0IOOO(this.b, eVar.b) && this.c == eVar.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.f7702a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.b;
        return ((i + (str != null ? str.hashCode() : 0)) * 31) + this.c;
    }

    @OOXIXo
    public String toString() {
        return "RGVDRViewData(isShow=" + this.f7702a + ", vdrContent=" + this.b + ", vdrState=" + this.c + oIX0oI.I0Io.f4095I0Io;
    }

    public final void a(boolean z) {
        this.f7702a = z;
    }

    public final void a(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.b = str;
    }

    public final void a(int i) {
        this.c = i;
    }
}
