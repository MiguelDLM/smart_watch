package com.baidu.navisdk.ui.chargelist.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.model.datastruct.chargestation.d;
import com.baidu.navisdk.ui.chargelist.data.beans.e;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class a {
    private boolean b;
    private int d;
    private int e;
    private ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> f;
    private boolean g;

    @oOoXoXO
    private Set<Integer> h;
    private com.baidu.navisdk.ui.chargelist.data.beans.b i;
    private b j;
    private d k;
    private d l;

    @OOXIXo
    private final MutableLiveData<Boolean> v;

    @OOXIXo
    private final MutableLiveData<Boolean> w;

    /* renamed from: a, reason: collision with root package name */
    private int f8395a = 1;
    private int c = 15;
    private final LinkedHashMap<Integer, b> m = new LinkedHashMap<>();
    private final HashMap<String, com.baidu.navisdk.ui.chargelist.data.beans.b> n = new HashMap<>();
    private final ArrayList<String> o = new ArrayList<>();

    @OOXIXo
    private Set<com.baidu.navisdk.ui.chargelist.data.beans.b> p = new HashSet();

    @OOXIXo
    private Set<com.baidu.navisdk.ui.chargelist.data.beans.b> q = new HashSet();

    @OOXIXo
    private final MutableLiveData<d> r = new MutableLiveData<>();

    @OOXIXo
    private final MutableLiveData<c> s = new MutableLiveData<>();

    @OOXIXo
    private final MutableLiveData<ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b>> t = new MutableLiveData<>();

    @OOXIXo
    private final MutableLiveData<Integer> u = new MutableLiveData<>(0);

    /* renamed from: com.baidu.navisdk.ui.chargelist.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0408a {
        private C0408a() {
        }

        public /* synthetic */ C0408a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8396a;
        private final int b;
        private int c;

        @OOXIXo
        private final ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> d;

        @oOoXoXO
        private final com.baidu.navisdk.ui.chargelist.data.beans.d e;

        public b(int i, int i2, @OOXIXo ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> dataList, @oOoXoXO com.baidu.navisdk.ui.chargelist.data.beans.d dVar) {
            IIX0o.x0xO0oo(dataList, "dataList");
            this.b = i;
            this.c = i2;
            this.d = dataList;
            this.e = dVar;
        }

        @OOXIXo
        public final ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> a() {
            return this.d;
        }

        public final int b() {
            return this.c;
        }

        @oOoXoXO
        public final com.baidu.navisdk.ui.chargelist.data.beans.d c() {
            return this.e;
        }

        @OOXIXo
        public final ArrayList<String> d() {
            String f;
            ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> arrayList = this.d;
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (com.baidu.navisdk.ui.chargelist.data.beans.b bVar : arrayList) {
                if ((bVar instanceof e) && ((e) bVar).t() && (f = bVar.f()) != null && f.length() != 0) {
                    String f2 = bVar.f();
                    IIX0o.ooOOo0oXI(f2);
                    arrayList2.add(f2);
                }
            }
            return arrayList2;
        }

        public final boolean e() {
            com.baidu.navisdk.ui.chargelist.data.beans.d dVar = this.e;
            if (dVar != null) {
                return dVar.i();
            }
            return false;
        }

        public final boolean f() {
            return this.f8396a;
        }

        @OOXIXo
        public String toString() {
            return "Group(groupType=" + this.b + ", groupIndex=" + this.c + ", isSelected=" + this.f8396a + "dataList=" + this.d + ", more=" + this.e + ", " + oIX0oI.I0Io.f4095I0Io;
        }

        public final void a(boolean z) {
            this.f8396a = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @OOXIXo
        public final ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> a(boolean z, @oOoXoXO Set<Integer> set) {
            com.baidu.navisdk.model.datastruct.chargestation.b j;
            if (this.d.size() <= 0) {
                return new ArrayList<>();
            }
            if (!z && this.b == 1) {
                return new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = set != null ? new HashSet(set) : null;
            if (hashSet != null && !hashSet.isEmpty()) {
                if (hashSet.size() == 1 && hashSet.contains(0)) {
                    arrayList.addAll(this.d);
                } else {
                    int i = this.b;
                    if (i == 1 || i == 0) {
                        hashSet.remove(0);
                        boolean contains = hashSet.contains(1);
                        hashSet.remove(1);
                        boolean isEmpty = hashSet.isEmpty();
                        for (com.baidu.navisdk.ui.chargelist.data.beans.b bVar : this.d) {
                            if (bVar instanceof e) {
                                e eVar = (e) bVar;
                                if (contains && (j = eVar.j()) != null && !j.u()) {
                                    eVar = null;
                                }
                                if (!isEmpty && eVar != null && !hashSet.contains(Integer.valueOf(eVar.j().c()))) {
                                    eVar = null;
                                }
                                if (eVar != null) {
                                    arrayList.add(eVar);
                                }
                            }
                        }
                    }
                }
            } else {
                arrayList.addAll(this.d);
            }
            if (arrayList.size() <= 0) {
                return new ArrayList<>();
            }
            ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> arrayList2 = new ArrayList<>();
            int i2 = this.b;
            if (i2 != 0 && i2 != 1) {
                arrayList2.addAll(arrayList);
            } else {
                if (e()) {
                    arrayList2.addAll(arrayList);
                } else {
                    arrayList2.add(arrayList.get(0));
                }
                com.baidu.navisdk.ui.chargelist.data.beans.d dVar = this.e;
                if (dVar != null) {
                    arrayList2.add(dVar);
                }
            }
            return arrayList2;
        }
    }

    static {
        new C0408a(null);
    }

    public a() {
        Boolean bool = Boolean.FALSE;
        this.v = new MutableLiveData<>(bool);
        this.w = new MutableLiveData<>(bool);
    }

    private final int d(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i != 2) {
            return i != 3 ? -1 : 3;
        }
        return 2;
    }

    private final void l() {
        Iterator<Map.Entry<Integer, b>> it = this.m.entrySet().iterator();
        ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (it.hasNext()) {
            b value = it.next().getValue();
            ArrayList<String> d = value.d();
            arrayList2.addAll(d);
            i += d.size();
            arrayList.addAll(value.a(this.g, this.h));
        }
        this.f = arrayList;
        this.t.postValue(arrayList);
        this.u.postValue(Integer.valueOf(i));
        this.v.postValue(Boolean.valueOf(!IIX0o.Oxx0IOOO(arrayList2.toString(), this.o.toString())));
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.a("ChargeListModel", "updateListData", "chargeList", arrayList);
            gVar.e("ChargeListModel", "updateListData ");
        }
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void b(boolean z) {
        this.b = z;
    }

    public final void c(int i) {
        this.f8395a = i;
    }

    @oOoXoXO
    public final Set<Integer> e() {
        return this.h;
    }

    @OOXIXo
    public final MutableLiveData<Integer> f() {
        return this.u;
    }

    @OOXIXo
    public final MutableLiveData<c> g() {
        return this.s;
    }

    public final int h() {
        return this.f8395a;
    }

    @OOXIXo
    public final MutableLiveData<d> i() {
        return this.r;
    }

    @OOXIXo
    public final MutableLiveData<Boolean> j() {
        return this.w;
    }

    public final boolean k() {
        return this.b;
    }

    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8397a;
        private final int b;

        public c(int i) {
            this.b = i;
            this.f8397a = true;
        }

        public final boolean a() {
            return this.f8397a;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this != obj) {
                return (obj instanceof c) && this.b == ((c) obj).b;
            }
            return true;
        }

        public int hashCode() {
            return this.b;
        }

        @OOXIXo
        public String toString() {
            return "SelectInfo(position=" + this.b + oIX0oI.I0Io.f4095I0Io;
        }

        public c(int i, boolean z) {
            this(i);
            this.f8397a = z;
        }
    }

    @OOXIXo
    public final Set<com.baidu.navisdk.ui.chargelist.data.beans.b> a() {
        return this.p;
    }

    public final void b(int i) {
        this.c = i;
    }

    @OOXIXo
    public final MutableLiveData<ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b>> c() {
        return this.t;
    }

    @OOXIXo
    public final MutableLiveData<Boolean> d() {
        return this.v;
    }

    public final void a(@oOoXoXO d dVar, @oOoXoXO d dVar2, @oOoXoXO String str, @oOoXoXO com.baidu.navisdk.model.datastruct.chargestation.e eVar, int i, boolean z) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("ChargeListModel", "updateRouteCsData --> recData = " + dVar + ", allData = " + dVar2 + ", selectedUid = " + str + ", carAddDist = " + i + ", all = " + z + ", singleRouteCsData = " + eVar);
        }
        this.k = dVar;
        this.l = dVar2;
        this.g = z;
        if (eVar != null) {
            a(eVar, i);
            if (str != null) {
                com.baidu.navisdk.ui.chargelist.data.beans.b it = this.n.get(str);
                if (it != null) {
                    if (it.d() == 1 && !z) {
                        this.g = true;
                    }
                    IIX0o.oO(it, "it");
                    a(it, true);
                } else {
                    l();
                }
            } else {
                l();
            }
        } else {
            l();
        }
        MutableLiveData<d> mutableLiveData = this.r;
        if (z) {
            dVar = dVar2;
        }
        mutableLiveData.postValue(dVar);
        this.w.postValue(Boolean.valueOf(this.g));
    }

    @OOXIXo
    public final Set<com.baidu.navisdk.ui.chargelist.data.beans.b> b() {
        return this.q;
    }

    public final void a(boolean z) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("ChargeListModel", "setAll --> all = " + z);
        }
        this.g = z;
        b bVar = this.j;
        if (bVar != null) {
            bVar.a(false);
        }
        com.baidu.navisdk.ui.chargelist.data.beans.b bVar2 = this.i;
        if (bVar2 != null) {
            bVar2.a(false);
        }
        this.j = null;
        this.i = null;
        Iterator<Map.Entry<Integer, b>> it = this.m.entrySet().iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.chargelist.data.beans.d c2 = it.next().getValue().c();
            if (c2 != null) {
                c2.b(false);
            }
        }
        l();
        this.r.postValue(z ? this.l : this.k);
        this.w.postValue(Boolean.valueOf(z));
        this.s.postValue(new c(0));
    }

    public final void a(@OOXIXo Set<Integer> filterSet) {
        IIX0o.x0xO0oo(filterSet, "filterSet");
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("ChargeListModel", "setFilter --> filterSet = " + filterSet);
        }
        this.h = filterSet;
        b bVar = this.j;
        if (bVar != null) {
            bVar.a(false);
        }
        com.baidu.navisdk.ui.chargelist.data.beans.b bVar2 = this.i;
        if (bVar2 != null) {
            bVar2.a(false);
        }
        this.j = null;
        this.i = null;
        Iterator<Map.Entry<Integer, b>> it = this.m.entrySet().iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.chargelist.data.beans.d c2 = it.next().getValue().c();
            if (c2 != null) {
                c2.b(false);
            }
        }
        l();
        this.s.postValue(new c(0));
    }

    public final boolean a(@OOXIXo e stationWrapper) {
        IIX0o.x0xO0oo(stationWrapper, "stationWrapper");
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("ChargeListModel", "pick --> stationWrapper = " + stationWrapper);
        }
        if (!stationWrapper.t()) {
            Integer value = this.u.getValue();
            if (value == null) {
                value = 0;
            }
            if (value.intValue() + this.e >= this.c) {
                return false;
            }
        }
        stationWrapper.b(!stationWrapper.t());
        Set<com.baidu.navisdk.ui.chargelist.data.beans.b> OoOoxX0xo = CollectionsKt___CollectionsKt.OoOoxX0xo(this.p);
        Set<com.baidu.navisdk.ui.chargelist.data.beans.b> OoOoxX0xo2 = CollectionsKt___CollectionsKt.OoOoxX0xo(this.q);
        OoOoxX0xo.remove(stationWrapper);
        OoOoxX0xo2.remove(stationWrapper);
        if (stationWrapper.t() != stationWrapper.s()) {
            if (stationWrapper.t()) {
                OoOoxX0xo.add(stationWrapper);
            } else {
                OoOoxX0xo2.add(stationWrapper);
            }
        }
        this.p = OoOoxX0xo;
        this.q = OoOoxX0xo2;
        l();
        return true;
    }

    public final boolean a(@oOoXoXO String str) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("ChargeListModel", "selectChargeFromClickMap --> selectedUid = " + str);
        }
        com.baidu.navisdk.ui.chargelist.data.beans.b it = this.n.get(str);
        if (it == null) {
            return false;
        }
        if (it.g()) {
            return true;
        }
        IIX0o.oO(it, "it");
        return a(it, true);
    }

    public final boolean a(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.b chargeWrapper, boolean z) {
        ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> arrayList;
        com.baidu.navisdk.ui.chargelist.data.beans.d c2;
        IIX0o.x0xO0oo(chargeWrapper, "chargeWrapper");
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("ChargeListModel", "select --> needScrollToTop = " + z + ", chargeWrapper = " + chargeWrapper);
        }
        b bVar = this.m.get(Integer.valueOf(chargeWrapper.c()));
        boolean g = chargeWrapper.g();
        b bVar2 = this.j;
        if (bVar2 != null) {
            bVar2.a(false);
        }
        com.baidu.navisdk.ui.chargelist.data.beans.b bVar3 = this.i;
        if (bVar3 != null) {
            bVar3.a(false);
        }
        if (bVar != null) {
            boolean z2 = !g;
            bVar.a(z2);
            chargeWrapper.a(z2);
            if (bVar.f() && bVar.a().indexOf(chargeWrapper) != 0 && (c2 = bVar.c()) != null) {
                c2.b(true);
            }
        }
        if (chargeWrapper.g()) {
            this.i = chargeWrapper;
            this.j = bVar;
        } else {
            this.i = null;
            this.j = null;
        }
        l();
        if (chargeWrapper.g() && z && (arrayList = this.f) != null) {
            this.s.postValue(new c(arrayList.indexOf(chargeWrapper)));
        }
        return true;
    }

    @oOoXoXO
    public final com.baidu.navisdk.ui.chargelist.data.beans.b a(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.b chargeWrapper) {
        ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> arrayList;
        com.baidu.navisdk.ui.chargelist.data.beans.b bVar;
        IIX0o.x0xO0oo(chargeWrapper, "chargeWrapper");
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("ChargeListModel", "expand --> chargeWrapper = " + chargeWrapper);
        }
        if (!(chargeWrapper instanceof com.baidu.navisdk.ui.chargelist.data.beans.d)) {
            return null;
        }
        com.baidu.navisdk.ui.chargelist.data.beans.d dVar = (com.baidu.navisdk.ui.chargelist.data.beans.d) chargeWrapper;
        dVar.b(!dVar.i());
        b bVar2 = this.m.get(Integer.valueOf(chargeWrapper.c()));
        com.baidu.navisdk.ui.chargelist.data.beans.b bVar3 = this.i;
        if (dVar.i() || bVar2 == null || !IIX0o.Oxx0IOOO(bVar2, this.j) || bVar3 == null || !(bVar3 instanceof e) || bVar2.b() != bVar3.c() || bVar2.a().indexOf(bVar3) <= 0) {
            bVar3 = null;
        } else {
            bVar3.a(false);
            bVar2.a(false);
            this.i = null;
            this.j = null;
        }
        l();
        if (!dVar.i()) {
            ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> a2 = bVar2 != null ? bVar2.a() : null;
            if ((a2 != null ? a2.size() : 0) > 0 && (arrayList = this.f) != null) {
                MutableLiveData<c> mutableLiveData = this.s;
                if (a2 == null || (bVar = a2.get(0)) == null) {
                    bVar = -1;
                }
                mutableLiveData.postValue(new c(CollectionsKt___CollectionsKt.ox0I(arrayList, bVar), false));
            }
        }
        return bVar3;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01af A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(com.baidu.navisdk.model.datastruct.chargestation.e r26, int r27) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.chargelist.model.a.a(com.baidu.navisdk.model.datastruct.chargestation.e, int):void");
    }

    private final int a(com.baidu.navisdk.model.datastruct.chargestation.b bVar) {
        if (bVar.k() == 2) {
            return 1;
        }
        return !bVar.t() ? 3 : 0;
    }
}
