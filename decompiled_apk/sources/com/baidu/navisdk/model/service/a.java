package com.baidu.navisdk.model.service;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f6954a;
    private int b;
    private int c;
    private int d;

    public a() {
        this(0, 0, 0, 0, 15, null);
    }

    public final boolean a(int i) {
        return (this.b & i) == i;
    }

    public final boolean b(int i) {
        return (this.c & i) == i;
    }

    public final void c(int i) {
        this.b = i;
    }

    public final void d(int i) {
        this.d = i;
    }

    public final void e(int i) {
        this.c = i;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6954a == aVar.f6954a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
    }

    public final void f(int i) {
        this.f6954a = i;
    }

    public int hashCode() {
        return (((((this.f6954a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    @OOXIXo
    public String toString() {
        return "ServiceGasInfo(stationStatus=" + this.f6954a + ", brand=" + this.b + ", label=" + this.c + ", gasType=" + this.d + oIX0oI.I0Io.f4095I0Io;
    }

    public a(int i, int i2, int i3, int i4) {
        this.f6954a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @OOXIXo
    public final String a() {
        StringBuilder sb = new StringBuilder();
        int i = this.b;
        if (i != 0 && i != 32) {
            if (a(1)) {
                sb.append("中石化");
            }
            if (a(2)) {
                sb.append("中石油");
            }
            if (a(4)) {
                sb.append("中海油");
            }
            if (a(8)) {
                sb.append("道达尔");
            }
            if (a(16)) {
                sb.append("壳牌");
            }
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "builder.toString()");
            return sb2;
        }
        String sb3 = sb.toString();
        IIX0o.oO(sb3, "builder.toString()");
        return sb3;
    }

    @OOXIXo
    public final String b() {
        StringBuilder sb = new StringBuilder();
        int i = this.c;
        if (i != 0 && i != 8192) {
            if (b(1)) {
                sb.append("89#");
            }
            if (b(2)) {
                sb.append("92#");
            }
            if (b(4)) {
                sb.append("95#");
            }
            if (b(8)) {
                sb.append("98#");
            }
            if (b(16)) {
                sb.append("e90");
            }
            if (b(32)) {
                sb.append("e93");
            }
            if (b(64)) {
                sb.append("e95");
            }
            if (b(128)) {
                sb.append("e97");
            }
            if (b(256)) {
                sb.append("M15甲醇");
            }
            if (b(512)) {
                sb.append("M20甲醇");
            }
            if (b(1024)) {
                sb.append("M30甲醇");
            }
            if (b(2048)) {
                sb.append("M85甲醇");
            }
            if (b(4096)) {
                sb.append("柴油");
            }
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "builder.toString()");
            return sb2;
        }
        String sb3 = sb.toString();
        IIX0o.oO(sb3, "builder.toString()");
        return sb3;
    }

    public /* synthetic */ a(int i, int i2, int i3, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 1 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }
}
