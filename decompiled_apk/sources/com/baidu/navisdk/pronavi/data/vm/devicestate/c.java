package com.baidu.navisdk.pronavi.data.vm.devicestate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7700a;
    private int b;

    @OOXIXo
    private String c;
    private int d;
    private int e;
    private boolean f;

    public c(boolean z, int i, @OOXIXo String signalText, int i2, int i3, boolean z2) {
        IIX0o.x0xO0oo(signalText, "signalText");
        this.f7700a = z;
        this.b = i;
        this.c = signalText;
        this.d = i2;
        this.e = i3;
        this.f = z2;
    }

    public final void a(boolean z) {
        this.f7700a = z;
    }

    public final int b() {
        return this.e;
    }

    @OOXIXo
    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final boolean e() {
        return this.f;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f7700a == cVar.f7700a && this.b == cVar.b && IIX0o.Oxx0IOOO(this.c, cVar.c) && this.d == cVar.d && this.e == cVar.e && this.f == cVar.f;
    }

    public final boolean f() {
        return this.f7700a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.f7700a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = ((r0 * 31) + this.b) * 31;
        String str = this.c;
        int hashCode = (((((i + (str != null ? str.hashCode() : 0)) * 31) + this.d) * 31) + this.e) * 31;
        boolean z2 = this.f;
        return hashCode + (z2 ? 1 : z2 ? 1 : 0);
    }

    @OOXIXo
    public String toString() {
        return "RGSatelliteSignalData(isShow=" + this.f7700a + ", gpsIconId=" + this.b + ", signalText=" + this.c + ", signalTextColor=" + this.d + ", gpsSignal=" + this.e + ", supportBeiDou=" + this.f + oIX0oI.I0Io.f4095I0Io;
    }

    public final int a() {
        return this.b;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final void a(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.c = str;
    }
}
