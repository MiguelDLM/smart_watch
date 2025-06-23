package com.baidu.navisdk.pronavi.hd.hdnavi.map;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager;
import com.baidu.navisdk.pronavi.hd.b;
import com.baidu.navisdk.pronavi.hd.c;
import com.baidu.navisdk.pronavi.hd.hdnavi.model.a;
import com.baidu.navisdk.ui.routeguide.navicenter.impl.d;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class RGHDMapView extends b {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    public static final String TAG = "RGMapView";
    private final a hdSize;

    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }
    }

    public RGHDMapView(@OOXIXo a hdSize) {
        IIX0o.x0xO0oo(hdSize, "hdSize");
        this.hdSize = hdSize;
    }

    @Override // com.baidu.navisdk.pronavi.hd.b
    @OOXIXo
    public c obtainMapConfig() {
        c cVar = new c(true);
        cVar.k(true);
        cVar.i(false);
        cVar.j(false);
        cVar.f(false);
        cVar.g(false);
        cVar.h(false);
        cVar.b(true);
        cVar.a(true);
        cVar.e(true);
        cVar.d(false);
        cVar.l(true);
        cVar.c(false);
        return cVar;
    }

    @OOXIXo
    public final View onCreate(@OOXIXo Context context, int i) {
        IIX0o.x0xO0oo(context, "context");
        return super.onCreate(context, i, "hdMapView");
    }

    @Override // com.baidu.navisdk.pronavi.hd.b
    public void onHdStateSwitch(int i, int i2, boolean z) {
        boolean z2;
        super.onHdStateSwitch(i, i2, z);
        RGHDMapGestureManager mGestureManager = getMGestureManager();
        if (mGestureManager != null) {
            if (i2 != 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            mGestureManager.a(z2);
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.b
    public boolean setHdDataToMap(@OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "bundle");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setHdDataToMap: " + bundle);
        }
        if (getMNaviMapController() != null) {
            com.baidu.navisdk.navimap.a mNaviMapController = getMNaviMapController();
            IIX0o.ooOOo0oXI(mNaviMapController);
            return mNaviMapController.a(bundle);
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.e
    public void setShowRect(int i, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setShowRect: " + i + ",:" + z);
        }
        Rect rect = new Rect();
        int d = com.baidu.navisdk.ui.routeguide.utils.a.f9151a.d();
        if (z) {
            rect.left = 0;
            com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
            rect.right = aVar.e();
            if (i == 2) {
                rect.top = 0;
                rect.bottom = this.hdSize.d();
            } else if (i == 3) {
                rect.top = 0;
                com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
                IIX0o.oO(V, "BNavigator.getInstance()");
                d r = V.r();
                IIX0o.oO(r, "BNavigator.getInstance().uiAction");
                if (r.g()) {
                    int i2 = rect.top;
                    com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
                    IIX0o.oO(V2, "BNavigator.getInstance()");
                    rect.top = i2 + aVar.a(V2.b());
                }
                rect.bottom = d;
            }
        } else {
            rect.left = 0;
            rect.bottom = com.baidu.navisdk.pronavi.util.a.h.e();
            rect.top = 0;
            ScreenUtil screenUtil = ScreenUtil.getInstance();
            com.baidu.navisdk.ui.routeguide.b V3 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V3, "BNavigator.getInstance()");
            int statusBarHeight = screenUtil.getStatusBarHeight(V3.b());
            com.baidu.navisdk.ui.routeguide.b V4 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V4, "BNavigator.getInstance()");
            d r2 = V4.r();
            IIX0o.oO(r2, "BNavigator.getInstance().uiAction");
            if (r2.g()) {
                rect.top += statusBarHeight;
            }
            if (i == 2) {
                rect.right = this.hdSize.b();
            } else if (i == 3) {
                rect.left = com.baidu.navisdk.ui.routeguide.utils.b.q();
                com.baidu.navisdk.ui.routeguide.mapmode.subview.a c = com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c();
                IIX0o.oO(c, "DisplayCutoutManager.getInstance()");
                if (c.b()) {
                    rect.left += statusBarHeight;
                }
                rect.right = d;
            }
        }
        if (gVar.d()) {
            gVar.e(TAG, "setShowRect: " + rect);
        }
        com.baidu.navisdk.navimap.a mNaviMapController = getMNaviMapController();
        if (mNaviMapController != null) {
            mNaviMapController.a(rect);
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.b
    public void setXYOffset(@oOoXoXO com.baidu.nplatform.comapi.basestruct.b bVar, int i, boolean z) {
        if (bVar == null) {
            return;
        }
        bVar.j = this.hdSize.a(i, z);
        if (z) {
            bVar.i = 0L;
            return;
        }
        if (i != 2) {
            if (i != 3) {
                bVar.i = 0L;
                return;
            } else {
                bVar.i = com.baidu.navisdk.ui.routeguide.utils.b.q() / 2;
                return;
            }
        }
        bVar.i = 0L;
    }
}
