package com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.e;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.g;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.j;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.k;
import com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.l;
import com.baidu.navisdk.util.jar.JarUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.apache.commons.text.oIX0oI;

/* loaded from: classes7.dex */
public final class b extends com.baidu.navisdk.pronavi.base.b {
    private final ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a> b = new ArrayList<>(5);
    private final ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> c = new ArrayList<>(4);
    private final ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> d = new ArrayList<>(2);
    private final MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> e = new MutableLiveData<>();
    private final MutableLiveData<Integer> f = new MutableLiveData<>();
    private boolean g;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    private final void i() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("parkBtn");
        aVar.b(IBNRouteResultManager.NearbySearchKeyword.Park);
        aVar.a(R.drawable.nsdk_drawable_common_ic_park);
        aVar.c(0);
        g gVar = new g();
        gVar.a(aVar);
        this.b.add(gVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar2 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("saveParkBtn");
        aVar2.b("记录车位");
        aVar2.a(R.drawable.nsdk_drawable_common_ic_save_park);
        aVar2.c(1);
        i iVar = new i();
        iVar.a(aVar2);
        this.b.add(iVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar3 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("weatherBtn");
        aVar3.b("天气");
        aVar3.a(R.drawable.nsdk_drawable_common_ic_weather);
        aVar3.c(2);
        l lVar = new l();
        lVar.a(aVar3);
        this.b.add(lVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar4 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("bridgeOnUnder");
        String string = JarUtils.getResources().getString(R.string.nsdk_string_rg_on_bridge);
        IIX0o.oO(string, "JarUtils.getResources().…nsdk_string_rg_on_bridge)");
        aVar4.b(string);
        aVar4.a(R.drawable.nsdk_drawable_switch_on_bridge);
        aVar4.c(3);
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a aVar5 = new com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a();
        aVar5.a(aVar4);
        this.b.add(aVar5);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar6 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("mainAuxiliaryRoad");
        String string2 = JarUtils.getResources().getString(R.string.nsdk_string_rg_in_main_road);
        IIX0o.oO(string2, "JarUtils.getResources().…k_string_rg_in_main_road)");
        aVar6.b(string2);
        aVar6.a(R.drawable.nsdk_drawable_switch_main_road);
        aVar6.c(4);
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c cVar = new com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c();
        cVar.a(aVar6);
        this.b.add(cVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar7 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("normalHD");
        aVar7.b("车道引导");
        int i = R.drawable.bnav_ic_normal_hd_btn;
        aVar7.a(i);
        aVar7.c(5);
        e eVar = new e();
        eVar.a(aVar7);
        this.b.add(eVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar8 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("HD");
        aVar8.b("车道引导");
        aVar8.a(i);
        aVar8.c(6);
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.c cVar2 = new com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.c();
        cVar2.a(aVar8);
        this.b.add(cVar2);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar9 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("ugc");
        aVar9.b("上报");
        aVar9.a(R.drawable.bnav_ic_ugc_report_new);
        aVar9.c(7);
        k kVar = new k(false);
        kVar.a(aVar9);
        this.b.add(kVar);
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar10 = new com.baidu.navisdk.pronavi.ui.buttoncollect.data.a("scenicBroadcast");
        aVar10.b("景区介绍");
        aVar10.a(R.drawable.nsdk_drawable_audio_play);
        aVar10.c(8);
        j jVar = new j();
        jVar.a(aVar10);
        this.b.add(jVar);
        g();
    }

    private final void j() {
        int i;
        if (!this.g && !this.d.isEmpty()) {
            i = 0;
        } else {
            i = 8;
        }
        Integer value = this.f.getValue();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "updateDynamicBtnVisible " + value + oIX0oI.f33048oxoX + i + TokenParser.SP);
        }
        if (value == null || i != value.intValue()) {
            a((MutableLiveData<MutableLiveData<Integer>>) this.f, (MutableLiveData<Integer>) Integer.valueOf(i));
        }
    }

    public final void b(int i) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a) a("bridgeOnUnder", com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a.class);
        if (aVar != null) {
            aVar.d(i);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c cVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c) a("mainAuxiliaryRoad", com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c.class);
        if (cVar != null) {
            cVar.d(i);
        }
        g();
    }

    @OOXIXo
    public final LiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> c() {
        return this.e;
    }

    @OOXIXo
    public final LiveData<Integer> d() {
        return this.f;
    }

    public final void e(boolean z) {
        l lVar = (l) a("weatherBtn", l.class);
        if (lVar == null || !lVar.a(z)) {
            return;
        }
        b("weatherBtn");
    }

    public final void f(boolean z) {
        e eVar = (e) a("normalHD", e.class);
        if (eVar != null) {
            eVar.a(z);
        }
        b("normalHD");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            r6 = this;
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r0 = r6.c
            r0.clear()
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a> r0 = r6.b
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        Ld:
            if (r2 >= r0) goto L44
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a> r3 = r6.b
            java.lang.Object r3 = r3.get(r2)
            java.lang.String r4 = "mAllBtnList[index]"
            kotlin.jvm.internal.IIX0o.oO(r3, r4)
            com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a r3 = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a) r3
            com.baidu.navisdk.uiframe.framework.a r4 = r6.a()
            com.baidu.navisdk.pronavi.ui.base.b r4 = (com.baidu.navisdk.pronavi.ui.base.b) r4
            boolean r4 = r3.a(r4)
            if (r4 == 0) goto L41
            r3.g()
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r4 = r6.c
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a r3 = r3.b()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r3)
            r4.add(r1, r3)
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r3 = r6.c
            int r3 = r3.size()
            r4 = 2
            if (r3 < r4) goto L41
            goto L44
        L41:
            int r2 = r2 + 1
            goto Ld
        L44:
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r2 = r0.d()
            java.lang.String r3 = "RGDynamicBtnCollectVM"
            if (r2 == 0) goto L65
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "updateAllData: "
            r2.append(r4)
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r4 = r6.c
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.e(r3, r2)
        L65:
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r0 = r6.d
            int r0 = r0.size()
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r2 = r6.c
            int r2 = r2.size()
            if (r0 == r2) goto L74
            goto L93
        L74:
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r0 = r6.d
            int r0 = r0.size()
            r2 = 0
        L7b:
            if (r2 >= r0) goto L98
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r4 = r6.d
            java.lang.Object r4 = r4.get(r2)
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a r4 = (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) r4
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r5 = r6.c
            java.lang.Object r5 = r5.get(r2)
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a r5 = (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) r5
            boolean r4 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r4, r5)
            if (r4 != 0) goto L95
        L93:
            r1 = 1
            goto L98
        L95:
            int r2 = r2 + 1
            goto L7b
        L98:
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r2 = r0.d()
            if (r2 == 0) goto Lb5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "updateAllData: isNeedUpdateList-"
            r2.append(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r0.e(r3, r2)
        Lb5:
            if (r1 == 0) goto Lca
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r0 = r6.d
            r0.clear()
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r0 = r6.d
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r1 = r6.c
            r0.addAll(r1)
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> r0 = r6.e
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r1 = r6.d
            r6.a(r0, r1)
        Lca:
            java.util.ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> r0 = r6.c
            r0.clear()
            r6.j()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.g():void");
    }

    public final void h() {
        a((MutableLiveData<MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>>) this.e, (MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>) this.d);
    }

    @Override // com.baidu.navisdk.pageframe.store.data.c
    public void a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        super.a((b) bVar);
        i();
    }

    public final void c(boolean z) {
        this.g = z;
        j();
    }

    public final void d(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "updateHDBtnEnable: " + z);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.c cVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.c) a("HD", com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.c.class);
        if (cVar != null) {
            cVar.a(z);
        }
        b("HD");
    }

    public final void a(int i) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a) a("bridgeOnUnder", com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a.class);
        if (aVar != null) {
            aVar.d(i);
        }
        b("bridgeOnUnder");
    }

    public final void c(int i) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c cVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c) a("mainAuxiliaryRoad", com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c.class);
        if (cVar != null) {
            cVar.d(i);
        }
        b("mainAuxiliaryRoad");
    }

    public final void e() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "refreshBroadcastVisible: ");
        }
        b("scenicBroadcast");
    }

    public final void f() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a) a("bridgeOnUnder", com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a.class);
        if (aVar != null) {
            aVar.a(R.drawable.nsdk_drawable_switch_on_bridge, R.drawable.nsdk_drawable_switch_under_bridge);
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = aVar.b();
            if (b != null) {
                b.d(R.color.nsdk_cl_text_h);
            }
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c cVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c) a("mainAuxiliaryRoad", com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c.class);
        if (cVar != null) {
            cVar.a(R.drawable.nsdk_drawable_switch_main_road, R.drawable.nsdk_drawable_switch_auxiliary_road);
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b2 = cVar.b();
            if (b2 != null) {
                b2.d(R.color.nsdk_cl_text_h);
            }
        }
        int i = R.color.nsdk_cl_text_h;
        a(i, 0);
        a("parkBtn", i, R.drawable.nsdk_drawable_common_ic_park);
        a("saveParkBtn", i, R.drawable.nsdk_drawable_common_ic_save_park);
        h();
    }

    private final void b(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "refreshItemVisible: " + str);
        }
        a(a(str));
    }

    private final void c(String str) {
        Object obj;
        Iterator<T> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (IIX0o.Oxx0IOOO(((com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) obj).e(), str)) {
                    break;
                }
            }
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) obj;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "updateDynamicItem: " + aVar);
        }
        if (aVar != null) {
            a((MutableLiveData<MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>>) this.e, (MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>) this.d);
        } else {
            g();
        }
    }

    private final void d(String str) {
        Object obj;
        Iterator<T> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (IIX0o.Oxx0IOOO(((com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) obj).e(), str)) {
                    break;
                }
            }
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) obj;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "updateShowedItem: " + aVar);
        }
        if (aVar != null) {
            a((MutableLiveData<MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>>) this.e, (MutableLiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>>) this.d);
        }
    }

    public final void a(@oOoXoXO com.baidu.navisdk.module.park.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "updateSaveParkData: saveParkData = " + aVar);
        }
        i iVar = (i) a("saveParkBtn", i.class);
        if (iVar != null) {
            iVar.a(aVar);
        }
        b("saveParkBtn");
    }

    public final void b(int i, int i2, int i3) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c cVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c) a("mainAuxiliaryRoad", com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.c.class);
        if (cVar != null) {
            cVar.a(i2, i3);
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = cVar.b();
            if (b != null) {
                b.d(i);
            }
        }
    }

    public final void a(int i, @OOXIXo String title, int i2) {
        IIX0o.x0xO0oo(title, "title");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "updateUgcReportBtnState: " + i + ", " + title + ',' + i2);
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
            d("ugc");
        }
    }

    public final void b(boolean z) {
        k kVar = (k) a("ugc", k.class);
        if (kVar == null || !kVar.b(z)) {
            return;
        }
        a(kVar);
    }

    @Override // com.baidu.navisdk.pageframe.store.data.c
    public void b() {
        super.b();
    }

    public final void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "setAllowShowingUgcBtn: " + z);
        }
        k kVar = (k) a("ugc", k.class);
        if (kVar == null || !kVar.a(z)) {
            return;
        }
        b("ugc");
    }

    public final void g(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "updateParkBtnState: isEnable = " + z);
        }
        g gVar2 = (g) a("parkBtn", g.class);
        if (gVar2 != null) {
            gVar2.a(z);
        }
        b("parkBtn");
    }

    public final void a(@oOoXoXO String str, @OOXIXo View view) {
        com.baidu.navisdk.pronavi.ui.base.b a2;
        IIX0o.x0xO0oo(view, "view");
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a a3 = a(str);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "onClickDynamicItem: " + str + (char) 65307 + a3);
        }
        if (a3 == null || (a2 = a()) == null) {
            return;
        }
        boolean a4 = a3.a(a2, view, null);
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectVM", "handleClickItem:" + a4 + ", " + str + ", " + a3);
        }
        if (a4) {
            if (a3.e()) {
                g();
            } else if (a3.f()) {
                a3.g();
                c(str);
            }
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

    private final void a(com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a aVar) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        Object obj = null;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("refreshItemVisible:");
            sb.append(aVar != null ? aVar.b() : null);
            gVar.e("RGDynamicBtnCollectVM", sb.toString());
        }
        int d = (aVar == null || (b = aVar.b()) == null) ? Integer.MAX_VALUE : b.d();
        Iterator<T> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) next).d() >= d) {
                obj = next;
                break;
            }
        }
        if (((com.baidu.navisdk.pronavi.ui.buttoncollect.data.a) obj) != null || this.d.size() < 2) {
            g();
        }
    }

    public final void a(int i, int i2, int i3) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a) a("bridgeOnUnder", com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.a.class);
        if (aVar != null) {
            aVar.a(i2, i3);
            com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = aVar.b();
            if (b != null) {
                b.d(i);
            }
        }
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
}
