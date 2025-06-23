package com.baidu.navisdk.ui.routeguide.brule.event;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeplan.v2.d;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.v;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.c;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.module.nearbysearch.model.b;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.comapi.routeplan.v2.a {

    /* renamed from: a, reason: collision with root package name */
    private RoutePlanNode f8515a;
    private List<com.baidu.navisdk.module.nearbysearch.model.a> b;

    private boolean c() {
        ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> b = b.INSTANCE.b();
        if (b != null && this.b != null && b.size() > this.b.size()) {
            return true;
        }
        return false;
    }

    private boolean d() {
        boolean z = false;
        if (this.f8515a == null) {
            return false;
        }
        RoutePlanNode g = ((f) c.a().a("RoutePlanModel")).g();
        if (!TextUtils.isEmpty(g.mUID) && TextUtils.equals(g.mUID, this.f8515a.mUID)) {
            z = true;
        }
        if (g.getGeoPoint().getLatitudeE6() == this.f8515a.getGeoPoint().getLatitudeE6() && g.getGeoPoint().getLongitudeE6() == this.f8515a.getGeoPoint().getLongitudeE6()) {
            z = true;
        }
        if (!TextUtils.isEmpty(g.getName()) && !TextUtils.equals(g.getName(), JarUtils.getResources().getString(R.string.nsdk_string_route_plan_map_point)) && TextUtils.equals(g.getName(), this.f8515a.getName())) {
            return true;
        }
        return z;
    }

    public RoutePlanNode a() {
        return this.f8515a;
    }

    public void b() {
        this.b = b.INSTANCE.b();
        this.f8515a = ((f) c.a().a("RoutePlanModel")).g();
    }

    @Override // com.baidu.navisdk.comapi.routeplan.v2.a
    public String getName() {
        return "XDSceneAid";
    }

    @Override // com.baidu.navisdk.comapi.routeplan.v2.a
    public boolean isPersist() {
        return true;
    }

    @Override // com.baidu.navisdk.comapi.routeplan.v2.a
    public void onRoutePlan(int i, int i2, d dVar, Bundle bundle) {
        String str;
        if (i == 2) {
            if (!d()) {
                com.baidu.navisdk.behavrules.util.a a2 = com.baidu.navisdk.behavrules.util.a.a();
                if (com.baidu.navisdk.ui.routeguide.b.W()) {
                    str = "asr_e_s_modify_dest_innavi";
                } else {
                    str = "asr_e_s_modify_dest_outnavi";
                }
                a2.a(new com.baidu.navisdk.behavrules.event.c(str));
            }
            if (c()) {
                if (com.baidu.navisdk.ui.routeguide.b.W()) {
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_add_approach_innavi"));
                } else {
                    v c = com.baidu.navisdk.framework.interfaces.c.p().c();
                    if (c != null && c.d()) {
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_add_approach_outnavi"));
                    }
                }
            }
            b();
        }
    }
}
