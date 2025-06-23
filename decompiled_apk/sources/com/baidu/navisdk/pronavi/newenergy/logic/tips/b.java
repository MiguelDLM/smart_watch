package com.baidu.navisdk.pronavi.newenergy.logic.tips;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.SystemClock;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.model.d;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private long f7806a;
    private final com.baidu.navisdk.pronavi.newenergy.logic.tips.a b;
    private final Observer<com.baidu.navisdk.pronavi.newenergy.logic.data.a> c;
    private com.baidu.navisdk.pronavi.ui.base.b d;
    private final LifecycleOwner e;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.newenergy.logic.tips.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0329b<T> implements Observer<com.baidu.navisdk.pronavi.newenergy.logic.data.a> {
        public C0329b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(com.baidu.navisdk.pronavi.newenergy.logic.data.a aVar) {
            b.this.c(aVar);
        }
    }

    static {
        new a(null);
    }

    public b(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar, @OOXIXo LifecycleOwner lifecycle) {
        IIX0o.x0xO0oo(lifecycle, "lifecycle");
        this.d = bVar;
        this.e = lifecycle;
        this.b = new com.baidu.navisdk.pronavi.newenergy.logic.tips.a();
        C0329b c0329b = new C0329b();
        this.c = c0329b;
        d g = d.g();
        IIX0o.oO(g, "RGChargeStationModel.getInstance()");
        MutableLiveData<com.baidu.navisdk.pronavi.newenergy.logic.data.a> a2 = g.a();
        if (a2 != null) {
            a2.observe(lifecycle, c0329b);
        }
    }

    private final void b(com.baidu.navisdk.pronavi.newenergy.logic.data.a aVar) {
        this.b.a();
        if (aVar != null) {
            this.b.h(aVar.g());
            this.b.b(aVar.h());
            this.b.g(R.color.bnav_ne_charge_title_color);
            this.b.b(R.color.bnav_ne_charge_count_color);
            if (aVar.g() != 0 && aVar.g() != 6) {
                if (aVar.a() > 0) {
                    this.b.d(aVar.a() + "备选");
                }
                int max = Math.max(0, aVar.d()) + Math.max(0, aVar.f());
                int max2 = Math.max(aVar.c(), 0) + Math.max(0, aVar.e());
                if (max > 0) {
                    if (1 <= max2 && max >= max2) {
                        com.baidu.navisdk.pronavi.newenergy.logic.tips.a aVar2 = this.b;
                        StringBuilder sb = new StringBuilder();
                        sb.append((char) 31354);
                        sb.append(max2);
                        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                        sb.append(max);
                        aVar2.a(sb.toString());
                    } else {
                        com.baidu.navisdk.pronavi.newenergy.logic.tips.a aVar3 = this.b;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append((char) 20849);
                        sb2.append(max);
                        aVar3.a(sb2.toString());
                    }
                }
            }
            switch (aVar.g()) {
                case 1:
                case 2:
                case 3:
                case 4:
                    this.b.c(R.drawable.bnav_ic_ne_charge_station_green_tip);
                    this.b.d(R.drawable.nsdk_rg_ne_charge_station_tip_bg_green);
                    this.b.a(R.drawable.nsdk_rg_ne_via_charge_count_bg);
                    this.b.e(R.color.banv_ne_via_other_charge_color);
                    this.b.c(a(aVar.b()));
                    this.b.f(a(aVar));
                    return;
                case 5:
                    this.b.c(R.drawable.bnav_ic_ne_charge_station_orange_tip);
                    this.b.d(R.drawable.nsdk_rg_ne_charge_station_tip_bg_orange);
                    this.b.a(R.drawable.nsdk_rg_ne_leave_highway_charge_count_bg);
                    this.b.e(R.color.banv_ne_leave_highway_other_charge_color);
                    this.b.c(a(aVar.b()));
                    this.b.f("下高速");
                    return;
                case 6:
                    this.b.c(R.drawable.bnav_ic_ne_charge_station_red_tip);
                    this.b.d(R.drawable.nsdk_rg_ne_charge_station_tip_bg_red);
                    this.b.f("沿途充电站不足");
                    this.b.e("关注续航");
                    this.b.f(R.color.bnav_ne_not_enough_charge_tip_color);
                    return;
                default:
                    this.b.a();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(com.baidu.navisdk.pronavi.newenergy.logic.data.a aVar) {
        com.baidu.navisdk.apicenter.a aVar2;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGChargeStationTipModel", "updateChargeStationTipData: " + aVar);
        }
        b(aVar);
        com.baidu.navisdk.pronavi.ui.base.b bVar = this.d;
        if (bVar != null) {
            aVar2 = bVar.j();
        } else {
            aVar2 = null;
        }
        IIX0o.ooOOo0oXI(aVar2);
        aVar2.e("RGBucketGroupComponent").a(2015).a(this.b).a();
    }

    public static /* synthetic */ void a(b bVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        bVar.a(z);
    }

    public final void a(boolean z) {
        if (SystemClock.elapsedRealtime() - this.f7806a > 1000 || z) {
            this.f7806a = SystemClock.elapsedRealtime();
            d.g().d();
        }
    }

    private final String a(int i) {
        if (i <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        l0.a(i, l0.a.EN, sb);
        return sb.toString();
    }

    private final String a(com.baidu.navisdk.pronavi.newenergy.logic.data.a aVar) {
        int g = aVar.g();
        return g != 1 ? g != 2 ? g != 3 ? g != 4 ? IBNRouteResultManager.NearbySearchKeyword.Charging_Station : "推荐" : "终点充电" : "途经充电" : IBNRouteResultManager.NearbySearchKeyword.Service;
    }
}
