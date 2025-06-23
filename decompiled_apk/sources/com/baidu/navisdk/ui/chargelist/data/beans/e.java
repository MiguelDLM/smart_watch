package com.baidu.navisdk.ui.chargelist.data.beans;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import com.baidu.navisdk.model.datastruct.chargestation.b;
import com.baidu.navisdk.util.common.l0;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class e extends b {
    private final int A;

    @OOXIXo
    private final com.baidu.navisdk.model.datastruct.chargestation.b B;
    private boolean h;

    @oOoXoXO
    private final String i;

    @oOoXoXO
    private final com.baidu.nplatform.comapi.basestruct.c j;

    @oOoXoXO
    private final GeoPoint k;
    private final boolean l;
    private final int m;

    @OOXIXo
    private final String n;

    @OOXIXo
    private final ArrayList<String> o;

    @OOXIXo
    private final String p;

    @OOXIXo
    private final String q;

    @OOXIXo
    private final String r;

    @OOXIXo
    private final String s;

    @OOXIXo
    private final String t;

    @OOXIXo
    private final ArrayList<b.d> u;
    private final int v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i, int i2, int i3, int i4, int i5, int i6, @OOXIXo com.baidu.navisdk.model.datastruct.chargestation.b csInfo) {
        super(csInfo.p(), i, i2, i3, i4, i5);
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        IIX0o.x0xO0oo(csInfo, "csInfo");
        this.v = i;
        this.w = i2;
        this.x = i3;
        this.y = i4;
        this.z = i5;
        this.A = i6;
        this.B = csInfo;
        this.h = csInfo.q();
        this.i = csInfo.j();
        this.j = csInfo.m();
        this.k = csInfo.g();
        this.l = csInfo.q();
        this.m = csInfo.h();
        String str6 = "";
        if (csInfo.h() == -1) {
            str = "终点推荐";
        } else if (csInfo.t()) {
            StringBuilder sb = new StringBuilder();
            sb.append((char) 31532);
            sb.append(i6 + 1);
            sb.append((char) 27425);
            str = sb.toString();
        } else {
            str = "";
        }
        this.n = str;
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb2 = new StringBuilder();
        l0.a(b(), l0.a.EN, sb2);
        arrayList.add(sb2.toString());
        arrayList.addAll(csInfo.f());
        this.o = arrayList;
        b.c d = csInfo.d();
        if (d.b() > 0 && d.c() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append((char) 31354);
            sb3.append(d.b());
            sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb3.append(d.c());
            str2 = sb3.toString();
        } else if (d.c() > 0) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append((char) 20849);
            sb4.append(d.c());
            str2 = sb4.toString();
        } else {
            str2 = "";
        }
        this.p = str2;
        b.c d2 = csInfo.d();
        if (d2.f() > 0 && d2.g() > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append((char) 31354);
            sb5.append(d2.f());
            sb5.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb5.append(d2.g());
            str3 = sb5.toString();
        } else if (d2.g() > 0) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append((char) 20849);
            sb6.append(d2.g());
            str3 = sb6.toString();
        } else {
            str3 = "";
        }
        this.q = str3;
        b.e o = csInfo.o();
        if (o.g() > 0 && o.d() > 0) {
            str4 = o.g() + '-' + o.d() + "kW";
        } else if (o.g() > 0) {
            str4 = o.g() + "kW";
        } else if (o.d() > 0) {
            str4 = o.d() + "kW";
        } else if (o.b() > 0) {
            str4 = o.b() + "kW";
        } else {
            str4 = "";
        }
        this.r = str4;
        b.e o2 = csInfo.o();
        float f = 0;
        if (o2.a() > f) {
            str6 = o2.a() + "元/度";
        } else if (o2.c() > f) {
            str6 = o2.c() + "元/度";
        } else if (o2.f() > f) {
            str6 = o2.f() + "元/度";
        }
        this.s = str6;
        b.e o3 = csInfo.o();
        if (o3.e() > f) {
            str5 = "停车费：" + o3.e() + "元/小时";
        } else {
            str5 = "停车费：实际为准";
        }
        this.t = str5;
        this.u = csInfo.i();
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int a() {
        return this.y;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int b() {
        return this.z;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int c() {
        return this.v;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int d() {
        return this.w;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int e() {
        return this.x;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (c() == eVar.c() && d() == eVar.d() && e() == eVar.e() && IIX0o.Oxx0IOOO(this.B, eVar.B) && g() == eVar.g() && this.h == eVar.h && IIX0o.Oxx0IOOO(this.i, eVar.i) && IIX0o.Oxx0IOOO(this.j, eVar.j) && IIX0o.Oxx0IOOO(this.k, eVar.k) && this.l == eVar.l && this.m == eVar.m && IIX0o.Oxx0IOOO(this.n, eVar.n) && IIX0o.Oxx0IOOO(this.o, eVar.o) && IIX0o.Oxx0IOOO(this.p, eVar.p) && IIX0o.Oxx0IOOO(this.q, eVar.q) && IIX0o.Oxx0IOOO(this.r, eVar.r) && IIX0o.Oxx0IOOO(this.s, eVar.s) && IIX0o.Oxx0IOOO(this.t, eVar.t) && IIX0o.Oxx0IOOO(this.u, eVar.u)) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final String h() {
        return this.s;
    }

    public int hashCode() {
        int i;
        int i2;
        int c = ((((((((((c() * 31) + d()) * 31) + e()) * 31) + this.B.hashCode()) * 31) + Boolean.valueOf(g()).hashCode()) * 31) + Boolean.valueOf(this.h).hashCode()) * 31;
        String str = this.i;
        int i3 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i4 = (c + i) * 31;
        com.baidu.nplatform.comapi.basestruct.c cVar = this.j;
        if (cVar != null) {
            i2 = cVar.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i4 + i2) * 31;
        GeoPoint geoPoint = this.k;
        if (geoPoint != null) {
            i3 = geoPoint.hashCode();
        }
        return ((((((((((((((((((((i5 + i3) * 31) + Boolean.valueOf(this.l).hashCode()) * 31) + this.m) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + this.t.hashCode()) * 31) + this.u.hashCode();
    }

    @OOXIXo
    public final String i() {
        return this.r;
    }

    @OOXIXo
    public final com.baidu.navisdk.model.datastruct.chargestation.b j() {
        return this.B;
    }

    @OOXIXo
    public final ArrayList<String> k() {
        return this.o;
    }

    @OOXIXo
    public final String l() {
        return this.p;
    }

    @oOoXoXO
    public final GeoPoint m() {
        return this.k;
    }

    @OOXIXo
    public final String n() {
        return this.n;
    }

    @OOXIXo
    public final ArrayList<b.d> o() {
        return this.u;
    }

    @oOoXoXO
    public final String p() {
        return this.i;
    }

    @OOXIXo
    public final String q() {
        return this.t;
    }

    @OOXIXo
    public final String r() {
        return this.q;
    }

    public final boolean s() {
        return this.l;
    }

    public final boolean t() {
        return this.h;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    @OOXIXo
    public String toString() {
        return "StationWrapper(" + super.toString() + ", groupIndex=" + c() + ", itemType=" + d() + ", positionType=" + e() + ", backgroundType=" + a() + ", distance=" + b() + ", recGroupNum=" + this.A + ", isPicked=" + this.h + ", name=" + this.i + ", point=" + this.j + ", geoPoint=" + this.k + ", isApproach=" + this.l + ", groupId=" + this.m + ", groupName='" + this.n + "', extendInfo=" + this.o + ", fastCount='" + this.p + "', slowCount='" + this.q + "', chargePower='" + this.r + "', chargeFee='" + this.s + "', parkFee='" + this.t + "', labels=" + this.u + "csInfo=" + this.B + ", " + oIX0oI.I0Io.f4095I0Io;
    }

    public final void b(boolean z) {
        this.h = z;
    }
}
