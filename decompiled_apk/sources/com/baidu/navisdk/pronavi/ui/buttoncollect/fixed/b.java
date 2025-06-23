package com.baidu.navisdk.pronavi.ui.buttoncollect.fixed;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.data.model.i;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.d;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.h;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.a;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.k;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b extends com.baidu.navisdk.pronavi.base.b {
    private final ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a> b = new ArrayList<>(5);
    private final ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> c = new ArrayList<>(4);
    private final ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> d = new ArrayList<>(4);
    private final MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> e = new MutableLiveData<>();
    private final MutableLiveData<Pair<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a, Integer>> f = new MutableLiveData<>();
    private com.baidu.navisdk.pronavi.ui.buttoncollect.data.a g = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("");
    private final MutableLiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> h = new MutableLiveData<>();
    private final MutableLiveData<Pair<Boolean, Boolean>> i = new MutableLiveData<>();
    private int j = 5;

    @OOXIXo
    private final com.baidu.navisdk.framework.lifecycle.b<Integer> k = new com.baidu.navisdk.framework.lifecycle.b<>(8);
    private final ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> l;
    private final f<String, String> m;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0346b<T> implements Observer<Integer> {
        public C0346b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer it) {
            b bVar = b.this;
            IIX0o.oO(it, "it");
            bVar.b(it.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends f<String, String> {
        public c(String str, Object obj) {
            super(str, obj);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        @oOoXoXO
        public String execute() {
            b.this.m();
            return null;
        }
    }

    static {
        new a(null);
    }

    public b() {
        ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList = new ArrayList<>(3);
        this.l = arrayList;
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("");
        d.a aVar2 = d.b;
        Triple<Integer, Integer, Integer> a2 = aVar2.a(0, true);
        aVar.a(String.valueOf(0));
        aVar.a(a2.getFirst().intValue());
        String string = JarUtils.getResources().getString(a2.getSecond().intValue());
        IIX0o.oO(string, "JarUtils.getResources().getString(trip.second)");
        aVar.b(string);
        aVar.d(a2.getThird().intValue());
        arrayList.add(aVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar3 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("");
        Triple<Integer, Integer, Integer> a3 = aVar2.a(2, true);
        aVar3.a(String.valueOf(2));
        aVar3.a(a3.getFirst().intValue());
        String string2 = JarUtils.getResources().getString(a3.getSecond().intValue());
        IIX0o.oO(string2, "JarUtils.getResources().getString(trip.second)");
        aVar3.b(string2);
        aVar3.d(a3.getThird().intValue());
        arrayList.add(aVar3);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar4 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("");
        Triple<Integer, Integer, Integer> a4 = aVar2.a(3, true);
        aVar4.a(String.valueOf(3));
        aVar4.a(a4.getFirst().intValue());
        String string3 = JarUtils.getResources().getString(a4.getSecond().intValue());
        IIX0o.oO(string3, "JarUtils.getResources().getString(trip.second)");
        aVar4.b(string3);
        aVar4.d(a4.getThird().intValue());
        arrayList.add(aVar4);
        this.m = new c("RGFixedBtnCollectVM-autoHideTask", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        d dVar = (d) a("naviPlay", d.class);
        if (dVar != null) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a a2 = a(i);
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = dVar.b();
            if (b != null) {
                b.a(a2.b());
            }
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b2 = dVar.b();
            if (b2 != null) {
                b2.b(a2.f());
            }
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b3 = dVar.b();
            if (b3 != null) {
                b3.d(a2.g());
            }
            b("naviPlay");
        }
    }

    private final void l() {
        com.baidu.navisdk.util.worker.c.a().a((g) this.m, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectVM", "hideByTimeOut: ");
        }
        a(true);
    }

    private final void n() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("naviPlay");
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar2 = this.l.get(0);
        IIX0o.oO(aVar2, "mNaviPlayList[0]");
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar3 = aVar2;
        aVar.b(aVar3.f());
        aVar.a(aVar3.b());
        aVar.d(aVar3.g());
        d dVar = new d();
        dVar.a(aVar);
        this.b.add(dVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar4 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("ugc");
        aVar4.b("上报");
        aVar4.a(R.drawable.bnav_ic_ugc_report_new);
        k kVar = new k(true);
        kVar.a(aVar4);
        this.b.add(kVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar5 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("refresh");
        aVar5.b("刷新");
        aVar5.a(R.drawable.nsdk_drawable_common_ic_avoid_traffic_refresh);
        h hVar = new h();
        hVar.a(aVar5);
        this.b.add(hVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar6 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("offlineToOn");
        aVar6.b("转在线");
        aVar6.a(R.drawable.nsdk_drawable_common_ic_offline_to_online);
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.f fVar = new com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.f();
        fVar.a(aVar6);
        this.b.add(fVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar7 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("full");
        aVar7.b("全览");
        aVar7.a(R.drawable.nsdk_drawable_common_ic_fullview_mode);
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.b bVar = new com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.b();
        bVar.a(aVar7);
        this.b.add(bVar);
        k();
    }

    @OOXIXo
    public final LiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> c() {
        return this.h;
    }

    @OOXIXo
    public final LiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> d() {
        return this.e;
    }

    @OOXIXo
    public final LiveData<Pair<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a, Integer>> e() {
        return this.f;
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Integer> f() {
        return this.k;
    }

    @OOXIXo
    public final LiveData<Pair<Boolean, Boolean>> g() {
        return this.i;
    }

    public final void h() {
        a((MutableLiveData<MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>>) this.e, (MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>) this.d);
        a((MutableLiveData<MutableLiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>) this.h, (MutableLiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>) this.g);
    }

    public final void i() {
        String str;
        Integer num;
        i iVar;
        com.baidu.navisdk.framework.lifecycle.b<Integer> b;
        for (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar : this.l) {
            Triple<Integer, Integer, Integer> a2 = d.b.a(Integer.parseInt(aVar.e()), true);
            int intValue = a2.component1().intValue();
            int intValue2 = a2.component2().intValue();
            int intValue3 = a2.component3().intValue();
            String string = JarUtils.getResources().getString(intValue2);
            IIX0o.oO(string, "JarUtils.getResources().getString(titleId)");
            aVar.b(string);
            aVar.a(intValue);
            aVar.d(intValue3);
        }
        Iterator<T> it = this.b.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b2 = ((com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) it.next()).b();
            if (b2 != null) {
                b2.d(R.color.nsdk_cl_text_h);
            }
            if (b2 != null) {
                str = b2.e();
            } else {
                str = null;
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 115729) {
                    if (hashCode != 1085444827) {
                        if (hashCode == 2101819386 && str.equals("naviPlay")) {
                            com.baidu.navisdk.pronavi.ui.base.b a3 = a();
                            if (a3 == null || (iVar = (i) a3.b(i.class)) == null || (b = iVar.b()) == null || (num = b.getValue()) == null) {
                                num = 0;
                            }
                            IIX0o.oO(num, "context?.getMData(RGVoic…ava)?.voiceMode?.value?:0");
                            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a a4 = a(num.intValue());
                            b2.b(a4.f());
                            b2.a(a4.b());
                            b2.d(a4.g());
                        }
                    } else if (str.equals("refresh")) {
                        b2.a(R.drawable.nsdk_drawable_common_ic_avoid_traffic_refresh);
                    }
                } else if (str.equals("ugc")) {
                    b2.b(0);
                }
            }
        }
        h();
    }

    public final void j() {
        a(10000L);
    }

    public final void k() {
        com.baidu.navisdk.pronavi.ui.base.b a2;
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar;
        this.c.clear();
        Iterator<com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a> it = this.b.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a next = it.next();
            if (next.a(a()) && next.b() != null) {
                next.g();
                ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList = this.c;
                com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = next.b();
                IIX0o.ooOOo0oXI(b);
                arrayList.add(b);
            }
            if (this.c.size() >= this.j) {
                break;
            }
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectVM", "updateAllData: " + this.c);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) OxI.xI0oxI00(this.c);
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectVM", "updateAllData bottomItem: " + aVar + ", last:" + this.g);
        }
        if (aVar != null) {
            if (!IIX0o.Oxx0IOOO(this.g, aVar) && (a2 = a()) != null && (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) a2.c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class)) != null) {
                bVar.b(!IIX0o.Oxx0IOOO(aVar.e(), "ugc"));
            }
            this.g = aVar;
            a((MutableLiveData<MutableLiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>) this.h, (MutableLiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>) aVar);
        }
        this.d.clear();
        this.d.addAll(this.c);
        a((MutableLiveData<MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>>) this.e, (MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>) this.d);
        this.c.clear();
    }

    public final void c(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectVM", "openBtnCollect: " + z);
        }
        a((MutableLiveData<MutableLiveData<Pair<Boolean, Boolean>>>) this.i, (MutableLiveData<Pair<Boolean, Boolean>>) new Pair(Boolean.TRUE, Boolean.valueOf(z)));
    }

    @Override // com.baidu.navisdk.pageframe.store.data.c
    public void a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        super.a((b) bVar);
        n();
    }

    public final void a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar, @OOXIXo LifecycleOwner owner) {
        i iVar;
        com.baidu.navisdk.framework.lifecycle.b<Integer> b;
        IIX0o.x0xO0oo(owner, "owner");
        if (bVar == null || (iVar = (i) bVar.b(i.class)) == null || (b = iVar.b()) == null) {
            return;
        }
        b.observe(owner, new C0346b());
    }

    public final void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectVM", "closeBtnCollect: " + z);
        }
        a((MutableLiveData<MutableLiveData<Pair<Boolean, Boolean>>>) this.i, (MutableLiveData<Pair<Boolean, Boolean>>) new Pair(Boolean.FALSE, Boolean.valueOf(z)));
    }

    public final void b(@oOoXoXO String str, @OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a a2 = a(str);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onClickDynamicItem: ");
            sb.append(str);
            sb.append((char) 65307);
            sb.append(a2 != null ? a2.b() : null);
            gVar.e("RGFixedBtnCollectVM", sb.toString());
        }
        if (a2 == null || a() == null) {
            return;
        }
        com.baidu.navisdk.pronavi.ui.base.b a3 = a();
        IIX0o.ooOOo0oXI(a3);
        if (a.C0342a.a(a2, a3, view, null, 4, null)) {
            a(this, a2, false, 2, null);
            if (a2.e()) {
                k();
            } else if (a2.f()) {
                a2.g();
                a((MutableLiveData<MutableLiveData<Pair<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a, Integer>>>) this.f, (MutableLiveData<Pair<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a, Integer>>) new Pair(a2.b(), Integer.valueOf(a(a2.b()))));
            }
        }
    }

    public final void a(int i, @OOXIXo String title, int i2) {
        IIX0o.x0xO0oo(title, "title");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectVM", "updateUgcReportBtnState: " + i + ", " + title + ',' + i2);
        }
        k kVar = (k) a("ugc", k.class);
        if (kVar != null) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = kVar.b();
            if (b != null) {
                b.b(title);
            }
            if (i == 0) {
                com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b2 = kVar.b();
                if (b2 != null) {
                    b2.a(R.drawable.bnav_ic_ugc_report_new);
                }
            } else {
                com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b3 = kVar.b();
                if (b3 != null) {
                    b3.a(i2);
                }
            }
            kVar.a(i);
            b(kVar.c());
        }
    }

    private final com.baidu.navisdk.pronavi.ui.buttoncollect.data.a a(int i) {
        Object obj;
        String valueOf = String.valueOf(i);
        Iterator<T> it = this.l.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (IIX0o.Oxx0IOOO(((com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) obj).e(), valueOf)) {
                break;
            }
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) obj;
        if (aVar != null) {
            return aVar;
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar2 = this.l.get(0);
        IIX0o.oO(aVar2, "mNaviPlayList[0]");
        return aVar2;
    }

    private final void b(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectVM", "updateBtnItem: " + str);
        }
        if (IIX0o.Oxx0IOOO(this.g.e(), str)) {
            a((MutableLiveData<MutableLiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>) this.h, (MutableLiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>) this.g);
            return;
        }
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            if (IIX0o.Oxx0IOOO(this.d.get(i).e(), str)) {
                a((MutableLiveData<MutableLiveData<Pair<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a, Integer>>>) this.f, (MutableLiveData<Pair<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a, Integer>>) new Pair(this.d.get(i), Integer.valueOf(i)));
                return;
            }
        }
    }

    public final void a(@oOoXoXO String str, @OOXIXo View view) {
        Object obj;
        boolean z;
        IIX0o.x0xO0oo(view, "view");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectVM", "onClickBottomFixedItem: " + str + ", " + this.g);
        }
        if (str == null || str.length() == 0 || !IIX0o.Oxx0IOOO(str, this.g.e()) || a() == null) {
            return;
        }
        Iterator<T> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (IIX0o.Oxx0IOOO(((com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) obj).c(), str)) {
                    break;
                }
            }
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) obj;
        if (aVar != null) {
            com.baidu.navisdk.pronavi.ui.base.b a2 = a();
            IIX0o.ooOOo0oXI(a2);
            z = a.C0342a.a(aVar, a2, view, null, 4, null);
        } else {
            z = false;
        }
        if (z) {
            a(aVar, false);
            if (aVar != null && aVar.e()) {
                k();
            } else {
                if (aVar == null || !aVar.f()) {
                    return;
                }
                aVar.g();
                a((MutableLiveData<MutableLiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>) this.h, (MutableLiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>) this.g);
            }
        }
    }

    public final void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectVM", "onFixedBtnCollectStatusChange: " + z);
        }
        if (z) {
            com.baidu.navisdk.pronavi.ui.base.b a2 = a();
            if (a2 == null || a2.c(RGFSMTable.FsmState.BrowseMap)) {
                return;
            }
            a(10000L);
            return;
        }
        l();
    }

    private final int a(com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar) {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            if (IIX0o.Oxx0IOOO(this.d.get(i).e(), aVar != null ? aVar.e() : null)) {
                return i;
            }
        }
        return -1;
    }

    public static /* synthetic */ void a(b bVar, com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a aVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        bVar.a(aVar, z);
    }

    private final void a(com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a aVar, boolean z) {
        if (aVar != null && aVar.d()) {
            a(true);
        } else if (z) {
            a(10000L);
        }
    }

    private final com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a a(String str) {
        Object obj;
        Iterator<T> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (IIX0o.Oxx0IOOO(((com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) obj).c(), str)) {
                break;
            }
        }
        return (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) obj;
    }

    private final <T extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a> T a(String str, Class<T> cls) {
        Object obj;
        Iterator<T> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (IIX0o.Oxx0IOOO(((com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) obj).c(), str)) {
                break;
            }
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) obj;
        if (cls.isInstance(aVar)) {
            return cls.cast(aVar);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0069, code lost:
    
        r3 = a("full");
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x006f, code lost:
    
        if (r3 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0071, code lost:
    
        r3.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0074, code lost:
    
        b("full");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r5.equals(com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState.Car3D) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        if (r5.equals(com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState.North2D) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
    
        if (r5.equals(com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState.Fullview) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(@OXOo.oOoXoXO java.lang.String r5, @OXOo.oOoXoXO java.lang.String r6) {
        /*
            r4 = this;
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r1 = r0.d()
            if (r1 == 0) goto L2b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "enterFSMState "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " -> "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = ": "
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RGFixedBtnCollectVM"
            r0.e(r2, r1)
        L2b:
            r0 = 1
            java.lang.String r1 = "BrowseMap"
            if (r5 != 0) goto L31
            goto L77
        L31:
            int r2 = r5.hashCode()
            switch(r2) {
                case -502482441: goto L61;
                case 64876837: goto L58;
                case 661670346: goto L4c;
                case 1028825682: goto L42;
                case 1396695508: goto L39;
                default: goto L38;
            }
        L38:
            goto L77
        L39:
            java.lang.String r2 = "Fullview"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L77
            goto L69
        L42:
            boolean r2 = r5.equals(r1)
            if (r2 == 0) goto L77
            r4.c(r0)
            goto L77
        L4c:
            java.lang.String r2 = "EnlargeRoadmap"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L77
            r4.a(r0)
            goto L77
        L58:
            java.lang.String r2 = "Car3D"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L77
            goto L69
        L61:
            java.lang.String r2 = "North2D"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L77
        L69:
            java.lang.String r2 = "full"
            com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a r3 = r4.a(r2)
            if (r3 == 0) goto L74
            r3.g()
        L74:
            r4.b(r2)
        L77:
            boolean r6 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r6)
            if (r6 == 0) goto L86
            boolean r5 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r5)
            if (r5 != 0) goto L86
            r4.a(r0)
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.a(java.lang.String, java.lang.String):void");
    }

    private final void a(long j) {
        com.baidu.navisdk.util.worker.c.a().a((g) this.m, false);
        com.baidu.navisdk.util.worker.c.a().a(this.m, new e(2, 0), j);
    }

    public final void a(@OOXIXo String tag, int i, int i2) {
        Object obj;
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b;
        IIX0o.x0xO0oo(tag, "tag");
        Iterator<T> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b2 = ((com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) next).b();
            if (IIX0o.Oxx0IOOO(b2 != null ? b2.e() : null, tag)) {
                obj = next;
                break;
            }
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) obj;
        if (aVar == null || (b = aVar.b()) == null) {
            return;
        }
        if (i != 0) {
            b.d(i);
        }
        if (i2 != 0) {
            b.a(i2);
        }
    }

    public final void a(int i, int i2, int i3) {
        Integer num;
        Object obj;
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b;
        i iVar;
        com.baidu.navisdk.framework.lifecycle.b<Integer> b2;
        for (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar : this.l) {
            int parseInt = Integer.parseInt(aVar.e());
            if (parseInt == 0 || parseInt == 1) {
                if (i != 0) {
                    aVar.d(i);
                }
                if (i2 != 0) {
                    aVar.a(i2);
                }
            } else if (parseInt == 3) {
                if (i != 0) {
                    aVar.d(i);
                }
                if (i3 != 0) {
                    aVar.a(i3);
                }
            }
        }
        com.baidu.navisdk.pronavi.ui.base.b a2 = a();
        if (a2 == null || (iVar = (i) a2.b(i.class)) == null || (b2 = iVar.b()) == null || (num = b2.getValue()) == null) {
            num = 0;
        }
        IIX0o.oO(num, "context?.getMData(RGVoic…ava)?.voiceMode?.value?:0");
        int intValue = num.intValue();
        Iterator<T> it = this.b.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (IIX0o.Oxx0IOOO(((com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) obj).c(), "naviPlay")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a aVar2 = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) obj;
        if (aVar2 == null || (b = aVar2.b()) == null) {
            return;
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a a3 = a(intValue);
        b.b(a3.f());
        b.a(a3.b());
        b.d(a3.g());
    }

    public final void a(int i, int i2) {
        Object obj;
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b;
        Iterator<T> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b2 = ((com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) next).b();
            if (IIX0o.Oxx0IOOO(b2 != null ? b2.e() : null, "ugc")) {
                obj = next;
                break;
            }
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) obj;
        if (aVar == null || (b = aVar.b()) == null) {
            return;
        }
        if (i != 0) {
            b.d(i);
        }
        b.b(i2);
    }
}
