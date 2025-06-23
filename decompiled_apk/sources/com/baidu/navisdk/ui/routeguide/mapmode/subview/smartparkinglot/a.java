package com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private final String f8875a;

    @oOoXoXO
    private final String b;

    @oOoXoXO
    private final String c;
    private final int d;
    private final int e;
    private final int f;

    @oOoXoXO
    private final String g;
    private final boolean h;

    @oOoXoXO
    private final String i;
    private boolean j;

    public a(@oOoXoXO String str, @oOoXoXO String str2, @oOoXoXO String str3, int i, int i2, int i3, @oOoXoXO String str4, boolean z, @oOoXoXO String str5, boolean z2) {
        this.f8875a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = str4;
        this.h = z;
        this.i = str5;
        this.j = z2;
    }

    @oOoXoXO
    public final String a() {
        return this.i;
    }

    @oOoXoXO
    public final String b() {
        return this.g;
    }

    @oOoXoXO
    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    @oOoXoXO
    public final String e() {
        return this.b;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return IIX0o.Oxx0IOOO(this.f8875a, aVar.f8875a) && IIX0o.Oxx0IOOO(this.b, aVar.b) && IIX0o.Oxx0IOOO(this.c, aVar.c) && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && IIX0o.Oxx0IOOO(this.g, aVar.g) && this.h == aVar.h && IIX0o.Oxx0IOOO(this.i, aVar.i) && this.j == aVar.j;
    }

    public final int f() {
        return this.f;
    }

    @oOoXoXO
    public final String g() {
        return this.f8875a;
    }

    public final int h() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.f8875a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (((((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        String str4 = this.g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.h;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode4 + i) * 31;
        String str5 = this.i;
        int hashCode5 = (i2 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z2 = this.j;
        return hashCode5 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final boolean i() {
        return this.j;
    }

    public final boolean j() {
        return this.h;
    }

    @OOXIXo
    public String toString() {
        return "ParkingLotItemInfo(title=" + this.f8875a + ", recommendText=" + this.b + ", info=" + this.c + ", lotNum=" + this.d + ", totalNum=" + this.e + ", status=" + this.f + ", fee=" + this.g + ", isSupportSmartPark=" + this.h + ", buttonText=" + this.i + ", isChecked=" + this.j + oIX0oI.I0Io.f4095I0Io;
    }

    public /* synthetic */ a(String str, String str2, String str3, int i, int i2, int i3, String str4, boolean z, String str5, boolean z2, int i4, IIXOooo iIXOooo) {
        this(str, str2, str3, i, i2, i3, str4, z, str5, (i4 & 512) != 0 ? false : z2);
    }

    public final void a(boolean z) {
        this.j = z;
    }
}
