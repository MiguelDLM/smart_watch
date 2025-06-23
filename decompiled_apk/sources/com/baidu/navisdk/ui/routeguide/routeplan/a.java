package com.baidu.navisdk.ui.routeguide.routeplan;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.framework.interfaces.pronavi.g;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.y;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f9088a = Integer.MIN_VALUE;

    /* renamed from: com.baidu.navisdk.ui.routeguide.routeplan.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0474a extends com.baidu.navisdk.util.worker.loop.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f9089a;
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0474a(String str, g gVar, int i) {
            super(str);
            this.f9089a = gVar;
            this.b = i;
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4099);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            if (message.what == 4099) {
                if (message.arg1 == 0) {
                    Bundle bundle = new Bundle();
                    BNRoutePlaner.getInstance().a(new ArrayList<>(), bundle);
                    if (bundle.containsKey("unRoutePlanID")) {
                        if (a.this.f9088a == bundle.getInt("unRoutePlanID")) {
                            g gVar = this.f9089a;
                            if (gVar != null) {
                                gVar.a(0, this.b);
                            }
                            com.baidu.navisdk.module.vehiclemanager.a.a(bundle, com.baidu.navisdk.module.vehiclemanager.b.i().b());
                        }
                    }
                } else {
                    g gVar2 = this.f9089a;
                    if (gVar2 != null) {
                        gVar2.a(-1, this.b);
                    }
                }
                com.baidu.navisdk.vi.b.b(this);
            }
        }
    }

    public void a(int i, g gVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNPreferenceRoute", "changePrefer -> preferType = " + i);
        }
        if (!BNRoutePlaner.getInstance().B() && y.d(com.baidu.navisdk.framework.a.c().a())) {
            if ((com.baidu.navisdk.ui.routeguide.b.V().d().d() & i) != 0) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNPreferenceRoute", "changePrefer -> ERROR_PREFER_NOT_CHANGED");
                }
                if (gVar != null) {
                    gVar.a(1, i);
                    return;
                }
                return;
            }
            com.baidu.navisdk.ui.routeguide.b.V().d().d(i);
            a0.G = 7;
            boolean i2 = l.l().i();
            if (gVar != null) {
                if (i2) {
                    com.baidu.navisdk.vi.b.a(new HandlerC0474a("PRoute", gVar, i));
                    this.f9088a = BNRoutePlaner.getInstance().v();
                    return;
                } else {
                    gVar.a(3, i);
                    return;
                }
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNPreferenceRoute", "changePrefer -> ERROR_IS_OFF_LINE");
        }
        if (gVar != null) {
            gVar.a(2, i);
        }
    }
}
