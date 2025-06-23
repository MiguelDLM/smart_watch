package com.baidu.navisdk.model.datastruct.chargestation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.collections.o00;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class e {

    @OOXIXo
    public static final a l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private boolean f6912a;
    private boolean b;
    private int c;
    private int d;

    @oOoXoXO
    private com.baidu.navisdk.model.datastruct.chargestation.a h;

    @OOXIXo
    private final ArrayList<com.baidu.navisdk.model.datastruct.chargestation.b> e = new ArrayList<>();

    @OOXIXo
    private final ArrayList<Object> f = new ArrayList<>();
    private final SparseArray<com.baidu.navisdk.model.datastruct.chargestation.c> g = new SparseArray<>();

    @OOXIXo
    private ArrayList<com.baidu.navisdk.model.datastruct.chargestation.a> i = new ArrayList<>();
    private final d j = new d();
    private final Comparator<Object> k = c.f6913a;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        @OOXIXo
        public final e a(@OOXIXo ArrayList<Bundle> csInfos, @OOXIXo ArrayList<Bundle> extBubbles, @OOXIXo Bundle data, @oOoXoXO b bVar) {
            IIX0o.x0xO0oo(csInfos, "csInfos");
            IIX0o.x0xO0oo(extBubbles, "extBubbles");
            IIX0o.x0xO0oo(data, "data");
            e eVar = new e();
            if (bVar == null) {
                bVar = eVar.j;
            }
            eVar.a(data.getInt("need_recommend_charge", 1) != 0);
            int size = csInfos.size();
            for (int i = 0; i < size; i++) {
                com.baidu.navisdk.model.datastruct.chargestation.b a2 = com.baidu.navisdk.model.datastruct.chargestation.b.B.a(csInfos.get(i));
                if (a2 != null) {
                    g gVar = g.COMMON;
                    if (gVar.d()) {
                        gVar.e("SingleRouteCsData", "parseByBundle --> 当前路线，第" + i + "个充电站，info = " + a2);
                    }
                    if (!bVar.a(a2)) {
                        com.baidu.navisdk.model.datastruct.chargestation.c cVar = (com.baidu.navisdk.model.datastruct.chargestation.c) eVar.g.get(a2.h());
                        if (cVar == null) {
                            cVar = new com.baidu.navisdk.model.datastruct.chargestation.c();
                            eVar.g.append(a2.h(), cVar);
                        }
                        cVar.a(a2.p(), a2);
                    } else if (gVar.d()) {
                        gVar.e("SingleRouteCsData", "parseByBundle --> 当前路线，第" + i + "个充电站，过滤！");
                    }
                }
            }
            int size2 = extBubbles.size();
            for (int i2 = 0; i2 < size2; i2++) {
                com.baidu.navisdk.model.datastruct.chargestation.a a3 = com.baidu.navisdk.model.datastruct.chargestation.a.l.a(extBubbles.get(i2));
                if (a3 != null) {
                    g gVar2 = g.COMMON;
                    if (gVar2.d()) {
                        gVar2.e("SingleRouteCsData", "parseByBundle --> 当前路线，第" + i2 + "个额外气泡，extraBubble = " + a3);
                    }
                    eVar.b().add(a3);
                }
            }
            e.l.a(eVar);
            return eVar;
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }

        private final void a(e eVar) {
            int size = eVar.g.size();
            com.baidu.navisdk.model.datastruct.chargestation.b bVar = null;
            for (int i = 0; i < size; i++) {
                com.baidu.navisdk.model.datastruct.chargestation.c cVar = (com.baidu.navisdk.model.datastruct.chargestation.c) eVar.g.valueAt(i);
                if (cVar != null) {
                    cVar.a(eVar.k);
                    if (cVar.e() == -1) {
                        bVar = cVar.f();
                    } else {
                        eVar.a(eVar.a() + cVar.b());
                        com.baidu.navisdk.model.datastruct.chargestation.b a2 = cVar.a();
                        if (a2 != null) {
                            eVar.d().add(a2);
                            eVar.c().add(a2);
                        } else {
                            com.baidu.navisdk.model.datastruct.chargestation.b f = cVar.f();
                            if (f != null) {
                                eVar.d().add(f);
                                eVar.c().add(f);
                            }
                        }
                    }
                }
            }
            eVar.c().addAll(eVar.b());
            o00.OO0x0xX(eVar.d(), eVar.k);
            o00.OO0x0xX(eVar.c(), eVar.k);
            if (bVar != null) {
                eVar.d().add(bVar);
                eVar.c().add(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a(@OOXIXo com.baidu.navisdk.model.datastruct.chargestation.b bVar);
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements Comparator<Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f6913a = new c();

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i;
            int i2 = 0;
            if (obj instanceof com.baidu.navisdk.model.datastruct.chargestation.b) {
                i = ((com.baidu.navisdk.model.datastruct.chargestation.b) obj).a();
            } else if (obj instanceof com.baidu.navisdk.model.datastruct.chargestation.a) {
                i = ((com.baidu.navisdk.model.datastruct.chargestation.a) obj).d();
            } else {
                i = 0;
            }
            if (obj2 instanceof com.baidu.navisdk.model.datastruct.chargestation.b) {
                i2 = ((com.baidu.navisdk.model.datastruct.chargestation.b) obj2).a();
            } else if (obj2 instanceof com.baidu.navisdk.model.datastruct.chargestation.a) {
                i2 = ((com.baidu.navisdk.model.datastruct.chargestation.a) obj2).d();
            }
            return i - i2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements b {
        @Override // com.baidu.navisdk.model.datastruct.chargestation.e.b
        public boolean a(@OOXIXo com.baidu.navisdk.model.datastruct.chargestation.b info) {
            IIX0o.x0xO0oo(info, "info");
            return false;
        }
    }

    @OOXIXo
    public final ArrayList<com.baidu.navisdk.model.datastruct.chargestation.b> d() {
        return this.e;
    }

    public final boolean e() {
        return this.b;
    }

    @OOXIXo
    public String toString() {
        return "SingleRouteCsData(isMd5NotMatch=" + this.f6912a + ", isRecommendCharge=" + this.b + ", alongWayRecGroupRange=" + this.c + ", backupCsCount=" + this.d + ", neCsInfoGroupArray=" + this.g + ", endBubble=" + this.h + ", extraBubbles=" + this.i + oIX0oI.I0Io.f4095I0Io;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    @OOXIXo
    public final ArrayList<com.baidu.navisdk.model.datastruct.chargestation.a> b() {
        return this.i;
    }

    @OOXIXo
    public final ArrayList<Object> c() {
        return this.f;
    }

    public final int a() {
        return this.d;
    }

    public final void a(int i) {
        this.d = i;
    }

    @oOoXoXO
    public final com.baidu.navisdk.model.datastruct.chargestation.c a(@oOoXoXO String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.equals("77778888", str)) {
            return this.g.get(-1);
        }
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            com.baidu.navisdk.model.datastruct.chargestation.c valueAt = this.g.valueAt(i);
            if (valueAt != null && valueAt.d().containsKey(str)) {
                return valueAt;
            }
        }
        return null;
    }
}
