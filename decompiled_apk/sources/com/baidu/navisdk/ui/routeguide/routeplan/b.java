package com.baidu.navisdk.ui.routeguide.routeplan;

import android.app.Activity;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.widget.RoutePlanObserver;
import com.baidu.navisdk.util.common.x;

/* loaded from: classes8.dex */
public class b extends RoutePlanObserver {
    public b(Activity activity, com.baidu.navisdk.module.offlinedownload.a aVar) {
        super(activity, aVar);
    }

    @Override // com.baidu.navisdk.ui.widget.RoutePlanObserver
    public void handleRoutePlanBefore() {
        if (BNRoutePlaner.getInstance().d() != 16 && BNRoutePlaner.getInstance().d() != 7 && !x.t() && !com.baidu.navisdk.ui.routeguide.control.x.b().S2()) {
            showWaitProgressDialog(this.mActivity.get());
        }
    }

    @Override // com.baidu.navisdk.ui.widget.RoutePlanObserver
    public void showReCalRouteQuitDialog() {
        com.baidu.navisdk.ui.routeguide.control.x.b().q4();
    }
}
