package com.baidu.navisdk.module.asr.busi;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.model.datastruct.t;
import com.baidu.navisdk.module.asr.i;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected String f7026a;
    protected com.baidu.navisdk.asr.i.e b;
    protected e c;
    protected boolean d;
    private boolean e;

    /* renamed from: com.baidu.navisdk.module.asr.busi.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0221a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f7027a;
        final /* synthetic */ t b;
        final /* synthetic */ boolean c;

        public RunnableC0221a(List list, t tVar, boolean z) {
            this.f7027a = list;
            this.b = tVar;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.model.datastruct.f fVar;
            GeoPoint e = com.baidu.navisdk.model.a.g().e();
            if (e != null) {
                fVar = com.baidu.navisdk.poisearch.c.a(e, 0);
            } else {
                fVar = null;
            }
            if (fVar == null) {
                com.baidu.navisdk.poisearch.model.a.k().a(com.baidu.navisdk.module.base.b.a());
            } else {
                com.baidu.navisdk.poisearch.model.a.k().a(fVar.d);
            }
            a.this.a(this.f7027a, this.b, this.c);
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        String a();

        String a(List<s> list, int i);

        void a(s sVar);

        void b();

        void b(s sVar);

        void c();
    }

    public a(com.baidu.navisdk.asr.i.e eVar, e eVar2) {
        this.b = eVar;
        this.c = eVar2;
    }

    private int c(List<s> list) {
        int i = 0;
        s sVar = list.get(0);
        int size = list.size();
        for (int i2 = 1; i2 < size; i2++) {
            if (list.get(i2).h < sVar.h) {
                i = i2;
            }
        }
        return i;
    }

    public void a(List<s> list, t tVar, boolean z) {
        if (tVar != null) {
            this.f7026a = a(tVar);
        }
        String str = z ? "2" : "1";
        if (list != null && list.size() != 0) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("XDVoiceAbstractAsrNearbySearchQuery", "poiSearchFinishByVoice() mVoiceKey: " + this.f7026a);
                LogUtil.e("XDVoiceAbstractAsrNearbySearchQuery", "route search. finish---> list:" + list.size());
            }
            for (int i = 0; i < list.size(); i++) {
                LogUtil.e("XDVoiceAbstractAsrNearbySearchQuery", "route search. finish---> poi :" + i + " :" + list.get(i).toString());
            }
            a(this.f7026a);
            if (a(list, this.f7026a) || b(list, this.f7026a)) {
                return;
            }
            a(list, this.f7026a, str);
            return;
        }
        this.b.a(com.baidu.navisdk.module.asr.f.a("未能找到" + this.f7026a + ",将继续当前导航"));
    }

    public void b(List<s> list, t tVar, boolean z) {
        i.a("XDVoiceAbstractAsrNearbySearchQuery", new RunnableC0221a(list, tVar, z));
    }

    public abstract String c();

    public boolean b(s sVar) {
        return (sVar == null || sVar.l == com.baidu.navisdk.poisearch.model.a.k().a()) ? false : true;
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.asr.i.b {
        final /* synthetic */ List b;

        public b(List list) {
            this.b = list;
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a(String str, int i) {
            super.a(str, i);
            if (i < 0 || i >= this.b.size()) {
                return;
            }
            a.this.c.a((s) this.b.get(i));
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void c() {
            a.this.c.b();
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a() {
            a.this.c.c();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.asr.i.b {
        final /* synthetic */ List b;

        public c(List list) {
            this.b = list;
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a(String str, int i) {
            super.a(str, i);
            if (i < 0 || i >= this.b.size()) {
                return;
            }
            a.this.c.a((s) this.b.get(i));
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void c() {
            a.this.c.b();
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a() {
            a.this.c.c();
        }
    }

    public boolean b(List<s> list) {
        boolean z;
        boolean z2;
        s next;
        int i = list.get(0).l;
        Iterator<s> it = list.iterator();
        do {
            if (it.hasNext()) {
                next = it.next();
                if (!b(next)) {
                    z = false;
                }
            } else {
                z = true;
            }
            z2 = true;
            break;
        } while (next.l == i);
        z = true;
        z2 = false;
        return z && !z2;
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.asr.i.b {
        final /* synthetic */ List b;

        public d(List list) {
            this.b = list;
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a(String str, int i) {
            super.a(str, i);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.n.3", "1", a.this.c(), a.this.b.d() ? "1" : "0");
            List list = this.b;
            if (list == null || list.isEmpty()) {
                return;
            }
            a.this.c.a((s) this.b.get(i));
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void c() {
            a.this.c.b();
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.n.3", "2", a.this.c(), a.this.b.d() ? "1" : "0");
            a.this.c.c();
        }
    }

    private boolean b(List<s> list, String str) {
        if (list == null) {
            return false;
        }
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < list.size(); i4++) {
            s sVar = list.get(i4);
            if (TextUtils.equals(sVar.t, "推荐")) {
                i = i4;
            }
            if (TextUtils.equals(sVar.t, "最顺路")) {
                i2 = i4;
            }
            if (TextUtils.equals(sVar.t, "最近")) {
                i3 = i4;
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("XDVoiceAbstractAsrNearbySearchQuery", "handleUnEmergencyPoi() directNearestIndex: " + i + "directIndex: " + i2 + "nearestIndex: " + i3);
        }
        if (str.contains(IBNRouteResultManager.NearbySearchKeyword.Bank) || str.contains(IBNRouteResultManager.NearbySearchKeyword.Hotel) || str.contains(IBNRouteResultManager.NearbySearchKeyword.Restaurant) || str.contains(IBNRouteResultManager.NearbySearchKeyword.Service)) {
            if (i >= 0 && this.d) {
                this.e = true;
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.n.3", "0", c(), this.b.d() ? "1" : "0");
                this.c.a(list.get(i));
                return true;
            }
            if (i3 >= 0 && this.d) {
                a(str, list, "最近", i3);
                return true;
            }
            if (i >= 0 || i2 >= 0) {
                if (i < 0) {
                    i = i2;
                }
                a(str, list, "最顺路", i);
                return true;
            }
        }
        return false;
    }

    private void a(String str) {
        int i;
        if (str.contains(IBNRouteResultManager.NearbySearchKeyword.Gas_Station)) {
            i = 0;
        } else if (str.contains(IBNRouteResultManager.NearbySearchKeyword.Charging_Station)) {
            i = 1;
        } else if (str.contains(IBNRouteResultManager.NearbySearchKeyword.Toilet)) {
            i = 2;
        } else if (str.contains(IBNRouteResultManager.NearbySearchKeyword.Bank)) {
            i = 3;
        } else if (str.contains(IBNRouteResultManager.NearbySearchKeyword.Hotel)) {
            i = 4;
        } else {
            i = str.contains(IBNRouteResultManager.NearbySearchKeyword.Restaurant) ? 5 : -1;
        }
        if (i >= 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.n.1", i + "", c(), this.b.d() ? "1" : "0");
        }
    }

    public void a(List<s> list, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        if (list.size() == 1) {
            s sVar = list.get(0);
            if (TextUtils.isEmpty(sVar.u)) {
                str5 = "";
            } else {
                str5 = ",预计" + sVar.u.replace(" ", ",");
            }
            StringBuilder sb = new StringBuilder();
            l0.a(sVar.h, l0.a.ZH, sb);
            if (b(sVar)) {
                com.baidu.navisdk.model.datastruct.f a2 = com.baidu.navisdk.poisearch.c.a(sVar.l);
                str6 = "找到" + (a2 != null ? a2.c : "") + "的" + str + ",距您" + ((Object) sb) + str5 + ",需要途经这里么？";
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.2", str2, "3", "2");
            } else if (a(sVar)) {
                str6 = "找到" + str + ",距您" + ((Object) sb) + ",预计" + sVar.u + ",需要途经这里么？";
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.2", str2, "4", "2");
            } else {
                str6 = "找到" + str + ",需要途经这里么？";
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.2", str2, "1", "2");
            }
            this.b.a(str6, this.c.a(list, 0), new b(list));
            return;
        }
        int c2 = c(list);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("XDVoiceAbstractAsrNearbySearchQuery", "normalVoiceResponse nearestIndex: " + c2);
        }
        s sVar2 = list.get(c2);
        int i = sVar2.h;
        if (TextUtils.isEmpty(sVar2.u)) {
            str3 = "";
        } else {
            str3 = ",预计" + sVar2.u.replace(" ", ",");
        }
        StringBuilder sb2 = new StringBuilder();
        l0.a(i, l0.a.ZH, sb2);
        if (a(list)) {
            if (b(list)) {
                str4 = "找到多个跨城的" + str + ",最近的距您" + ((Object) sb2) + str3 + ",需要途经第几个？";
            } else {
                com.baidu.navisdk.model.datastruct.f a3 = com.baidu.navisdk.poisearch.c.a(list.get(0).l);
                str4 = "找到多个" + (a3 != null ? a3.c : "") + "的" + str + ",最近的距您" + ((Object) sb2) + str3 + ",需要途经第几个？";
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.2", str2, "5", "2");
        } else if (i >= 10000) {
            str4 = "找到多个" + str + ",最近的距您" + ((Object) sb2) + str3 + ",需要途经第几个？";
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.2", str2, "6", "2");
        } else {
            str4 = "找到多个" + str + ",需要途经第几个？";
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.2", str2, "2", "2");
        }
        this.b.a(str4, this.c.a(list, c2), new c(list));
    }

    public e b() {
        return this.c;
    }

    public String a(t tVar) {
        if (tVar == null) {
            return null;
        }
        String j = tVar.j();
        if (TextUtils.isEmpty(tVar.q())) {
            return j;
        }
        if (!TextUtils.equals(j, IBNRouteResultManager.NearbySearchKeyword.Gas_Station) && !TextUtils.equals(j, IBNRouteResultManager.NearbySearchKeyword.Charging_Station)) {
            return tVar.q();
        }
        return tVar.q() + j;
    }

    public boolean a(List<s> list) {
        Iterator<s> it = list.iterator();
        while (it.hasNext()) {
            if (!b(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean a(s sVar) {
        return sVar != null && sVar.h >= 10000;
    }

    public String a(boolean z) {
        if (!z) {
            this.e = false;
            return JarUtils.getResources().getString(R.string.asr_rg_route_search_error);
        }
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(4, 2, bundle);
        String string = JarUtils.getResources().getString(this.e ? R.string.asr_rg_route_search_success_directjump : R.string.asr_rg_route_search_success, this.f7026a, bundle.getString("usWayRoadName"));
        this.e = false;
        return string;
    }

    private boolean a(List<s> list, String str) {
        if (list == null) {
            return false;
        }
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < list.size(); i3++) {
            s sVar = list.get(i3);
            if (TextUtils.equals(sVar.t, "推荐")) {
                i = i3;
            }
            if (TextUtils.equals(sVar.t, "最近")) {
                i2 = i3;
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("XDVoiceAbstractAsrNearbySearchQuery", "handleEmergencyPoi() directNearestIndex: " + i + "nearestIndex: " + i2);
        }
        if (str.contains(IBNRouteResultManager.NearbySearchKeyword.Toilet) || str.contains(IBNRouteResultManager.NearbySearchKeyword.Gas_Station) || str.contains(IBNRouteResultManager.NearbySearchKeyword.Charging_Station)) {
            if (i >= 0 && this.d) {
                this.e = true;
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.n.3", "0", c(), this.b.d() ? "1" : "0");
                this.c.a(list.get(i));
                return true;
            }
            if (i >= 0 || i2 >= 0) {
                if (i < 0) {
                    i = i2;
                }
                a(str, list, "最近", i);
                return true;
            }
        }
        return false;
    }

    public void a(String str, List<s> list, String str2, int i) {
        s sVar = list.get(i);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("XDVoiceAbstractAsrNearbySearchQuery", "poiTagResponse() index = " + i + " type = " + str2 + " searchPoi = " + sVar);
        }
        StringBuilder sb = new StringBuilder();
        l0.a(sVar.h, l0.a.ZH, sb);
        this.b.a(JarUtils.getResources().getString(R.string.nav_voice_add_vianode_poitag_response, str2, str, sb), this.c.a(list, i), new d(list));
    }

    public String a() {
        e eVar = this.c;
        return eVar == null ? "" : eVar.a();
    }
}
