package com.baidu.navisdk.module.routeresultbase.logic.calcroute.msgreceiver;

import android.app.Activity;
import android.os.SystemClock;
import com.baidu.navisdk.comapi.base.c;
import com.baidu.navisdk.comapi.routeplan.e;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.ui.widget.RoutePlanObserver;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class a extends RoutePlanObserver {
    public a(Activity activity, com.baidu.navisdk.module.offlinedownload.a aVar) {
        super(activity, aVar);
    }

    @Override // com.baidu.navisdk.ui.widget.RoutePlanObserver, com.baidu.navisdk.comapi.base.b
    public void update(c cVar, int i, int i2, Object obj) {
        if (i == 1) {
            if (i2 != 3) {
                if (i2 != 18) {
                    if (i2 != 6) {
                        if (i2 == 7) {
                            LogUtil.e("BNRRRoutePlanObserver", "update()  EVENT_ENGINE_FAIL");
                            b.a(SystemClock.elapsedRealtime());
                            return;
                        }
                        return;
                    }
                    LogUtil.e("BNRRRoutePlanObserver", "update()  EVENT_GENERAL_FAIL");
                    b.a(SystemClock.elapsedRealtime());
                    return;
                }
                b.a(SystemClock.elapsedRealtime());
                LogUtil.e("route_plan_time", "failed.navi_time=" + (b.w() - b.x()) + "ms");
                return;
            }
            LogUtil.e("BNRRRoutePlanObserver", "update()  EVENT_RP_FAIL");
            b.a(SystemClock.elapsedRealtime());
            LogUtil.e("route_plan_time", "failed.navi_time=" + (b.w() - b.x()) + "ms");
            if (obj instanceof e.c) {
                b.k(((e.c) obj).f6721a);
            }
        }
    }
}
