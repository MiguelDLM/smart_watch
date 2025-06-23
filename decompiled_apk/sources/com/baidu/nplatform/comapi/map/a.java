package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9493a = "a";

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static a f9494a = new a();
    }

    public static a c() {
        return b.f9494a;
    }

    public void a(Context context, Bundle bundle) {
        LogUtil.e(f9493a, "init: -->");
        BNMapController.getInstance().initMapController(context, bundle);
    }

    public void b() {
        LogUtil.e(f9493a, "unInit: -->");
        BNMapController.destory();
    }

    private a() {
    }

    public void a(BNMapObserver bNMapObserver) {
        if (bNMapObserver != null) {
            BNMapController.getInstance().addObserver(bNMapObserver);
        }
    }

    public void b(BNMapObserver bNMapObserver) {
        if (bNMapObserver != null) {
            BNMapController.getInstance().deleteObserver(bNMapObserver);
        }
    }

    public void a(int i, Object obj) {
        String str = f9493a;
        LogUtil.e(str, "onAction: actionType --> " + i);
        switch (i) {
            case 513:
                LogUtil.e(str, " --> onDoubleTap");
                BNMapController.getInstance().handleDoubleTouch(obj);
                return;
            case 514:
                LogUtil.e(str, " --> onSingleTapConfirmed");
                BNMapController.getInstance().handleSingleTouch(obj);
                return;
            case 515:
                LogUtil.e(str, " --> onDown");
                BNMapController.getInstance().notifyMapObservers(2, 515, null);
                return;
            case 516:
                LogUtil.e(str, " --> onFling");
                com.baidu.navisdk.comapi.statistics.b.f().d("td");
                BNMapController.getInstance().notifyMapObservers(2, 516, null);
                return;
            case 517:
                LogUtil.e(str, " --> onLongPress");
                com.baidu.navisdk.comapi.statistics.b.f().d("dc");
                BNMapController.getInstance().notifyMapObservers(2, 517, obj);
                return;
            case 518:
                LogUtil.e(str, " --> onScroll");
                BNMapController.getInstance().notifyMapObservers(2, 518, null);
                return;
            case 519:
            default:
                return;
            case 520:
                LogUtil.e(str, " --> onDoubleFingerZoom");
                BNMapController.getInstance().notifyMapObservers(2, 520, null);
                return;
            case 521:
                LogUtil.e(str, " --> onDoubleFingerRotate");
                BNMapController.getInstance().notifyMapObservers(2, 520, null);
                return;
        }
    }

    public com.baidu.nplatform.comapi.basestruct.c a(com.baidu.nplatform.comapi.basestruct.c cVar) {
        if (cVar != null) {
            String str = f9493a;
            LogUtil.e(str, "onTap: input --> x: " + cVar.c() + ", y: " + cVar.d());
            if (RouteGuideParams.getRouteGuideMode() == 2) {
                cVar.b((cVar.d() + ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.framework.a.c().b())) - ScreenUtil.getInstance().dip2px(20));
                LogUtil.e(str, "onTap: output --> x: " + cVar.c() + ", y: " + cVar.d());
            }
        }
        return cVar;
    }

    public boolean a(String str, int i, int i2) {
        LogUtil.e(f9493a, "onItemClick: jsonStr --> " + str);
        return BNMapController.getInstance().onMapItemClick(str, i, i2);
    }

    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.e()) {
            gVar.g(f9493a, "onMapAnimationFinish:  --> ");
        }
        BNMapController.getInstance().onMapAnimationFinish();
    }
}
