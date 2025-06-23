package com.baidu.navisdk.model.datastruct.chargestation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    @OOXIXo
    public static final C0208a l = new C0208a(null);

    @oOoXoXO
    private com.baidu.navisdk.model.datastruct.b b;
    private int e;
    private int f;
    private int h;

    @oOoXoXO
    private com.baidu.nplatform.comapi.basestruct.c j;
    private int k;

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private String f6905a = "77778888";
    private int c = -1;
    private int d = -1;

    @OOXIXo
    private ArrayList<String> g = new ArrayList<>();

    @OOXIXo
    private final ArrayList<com.baidu.nplatform.comapi.basestruct.c> i = new ArrayList<>();

    /* renamed from: com.baidu.navisdk.model.datastruct.chargestation.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0208a {
        private C0208a() {
        }

        @oOoXoXO
        public final a a(@oOoXoXO Bundle bundle) {
            if (bundle != null) {
                a aVar = new a();
                aVar.d(bundle.getInt("start_link_idx", 0));
                aVar.b(bundle.getInt("end_link_idx", 0));
                aVar.c(bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.StartDist, 0));
                aVar.a(bundle.getInt("end_dist", 0));
                aVar.e(bundle.getInt("type", 0));
                aVar.a(aVar.g() + '_' + aVar.e() + '_' + aVar.c());
                return aVar;
            }
            return null;
        }

        public /* synthetic */ C0208a(IIXOooo iIXOooo) {
            this();
        }
    }

    public final void a(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f6905a = str;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final int c() {
        return this.d;
    }

    public final void d(int i) {
        this.c = i;
    }

    public final int e() {
        return this.c;
    }

    public final int f() {
        return this.h;
    }

    @OOXIXo
    public final String g() {
        return this.f6905a;
    }

    @OOXIXo
    public String toString() {
        com.baidu.nplatform.comapi.basestruct.c cVar;
        StringBuilder sb = new StringBuilder();
        sb.append("CsBubble(");
        sb.append("uid='");
        sb.append(this.f6905a);
        sb.append("', ");
        sb.append("mapGData=");
        sb.append(this.b);
        sb.append(", ");
        sb.append("startLinkIdx=");
        sb.append(this.c);
        sb.append(", ");
        sb.append("endLindIdx=");
        sb.append(this.d);
        sb.append(", ");
        sb.append("startDist=");
        sb.append(this.e);
        sb.append(", ");
        sb.append("endDist=");
        sb.append(this.f);
        sb.append(", ");
        sb.append("contents=");
        sb.append(this.g);
        sb.append(", ");
        sb.append("type=");
        sb.append(this.h);
        sb.append(", ");
        sb.append("shapePointListSize=");
        sb.append(this.i.size());
        sb.append(", ");
        sb.append("startPoint=");
        com.baidu.nplatform.comapi.basestruct.c cVar2 = null;
        if (this.i.size() > 0) {
            cVar = this.i.get(0);
        } else {
            cVar = null;
        }
        sb.append(cVar);
        sb.append(", ");
        sb.append("endPoint=");
        if (this.i.size() > 0) {
            cVar2 = this.i.get(r2.size() - 1);
        }
        sb.append(cVar2);
        sb.append(", ");
        sb.append("middlePoint=");
        sb.append(this.j);
        sb.append(", ");
        sb.append("roadPatternID=");
        sb.append(this.k);
        sb.append(oIX0oI.I0Io.f4095I0Io);
        return sb.toString();
    }

    public final void a(int i) {
        this.f = i;
    }

    public final int b() {
        return this.f;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final int d() {
        return this.e;
    }

    public final void e(int i) {
        this.h = i;
    }

    @OOXIXo
    public final ArrayList<String> a() {
        return this.g;
    }
}
