package com.baidu.mapapi.walknavi;

import com.baidu.entity.pb.WalkPlan;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.platform.comapi.walknavi.f.c;
import com.baidu.platform.comapi.wnplatform.j.f;
import com.baidu.platform.comapi.wnplatform.j.h;
import com.baidu.platform.comapi.wnplatform.p.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a implements f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IWRoutePlanListener f6027a;
    final /* synthetic */ WalkNaviLaunchParam b;
    final /* synthetic */ WalkNavigateHelper c;

    public a(WalkNavigateHelper walkNavigateHelper, IWRoutePlanListener iWRoutePlanListener, WalkNaviLaunchParam walkNaviLaunchParam) {
        this.c = walkNavigateHelper;
        this.f6027a = iWRoutePlanListener;
        this.b = walkNaviLaunchParam;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.f
    public void a() {
        this.f6027a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.f
    public void b() {
        c cVar;
        WalkPlan V = com.baidu.platform.comapi.walknavi.b.a().V();
        if (V != null && V.hasOption() && V.getOption() != null && V.getOption().hasStart() && V.getOption().getStart() != null && V.getOption().getStart().getSptCount() == 2 && V.getOption().getStart().hasWd() && V.getOption().getStart().getWd() != null) {
            if (g.a()) {
                this.c.i = true;
            }
            if (g.c()) {
                com.baidu.platform.comapi.wnplatform.f.a().a(true);
            } else {
                com.baidu.platform.comapi.wnplatform.f.a().a(false);
                if (g.d()) {
                    this.f6027a.onRoutePlanFail(WalkRoutePlanError.IS_NOT_SUPPORT_INDOOR_NAVI);
                    return;
                }
            }
            h.a().a(V);
            WNavigatorWrapper.getWNavigator().e(1);
            WNavigatorWrapper.getWNavigator().f(this.b.getExtraNaviMode());
            this.c.g = h.a().a(V, this.b);
            h a2 = h.a();
            cVar = this.c.g;
            if (a2.a(cVar)) {
                this.f6027a.onRoutePlanSuccess();
                return;
            } else {
                this.f6027a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
                return;
            }
        }
        this.f6027a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.f
    public void a(int i) {
        if (i == 16777214) {
            this.f6027a.onRoutePlanFail(WalkRoutePlanError.FORWARD_AK_ERROR);
            return;
        }
        if (i == 16777216) {
            this.f6027a.onRoutePlanFail(WalkRoutePlanError.SERVER_UNUSUAL);
        } else if (i != 805306368) {
            this.f6027a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
        } else {
            this.f6027a.onRoutePlanFail(WalkRoutePlanError.NET_ERR);
        }
    }
}
