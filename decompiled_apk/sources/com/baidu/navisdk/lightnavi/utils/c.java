package com.baidu.navisdk.lightnavi.utils;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.map.j;

/* loaded from: classes7.dex */
public class c {
    public static void a() {
        j mapController = BNMapController.getInstance().getMapController();
        if (mapController != null && mapController.j()) {
            BNMapController.getInstance().getMapController().k(false);
        }
        BNMapController.getInstance().setSlightScreenStatus(2);
        BNRoutePlaner.getInstance().b(false);
        BNMapController.getInstance().setNightMode(false);
        BNRouteGuider.getInstance().SetFullViewState(true);
    }

    public static void b() {
        a(0, 0, 0, 0, 0, 0);
    }

    public static void a(int i, int i2, int i3, int i4, int i5, int i6) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isVertical", true);
        if (i5 == 0) {
            i5 = ScreenUtil.getInstance().getHeightPixels();
        }
        if (i6 == 0) {
            i6 = ScreenUtil.getInstance().getWidthPixels();
        }
        if (i < 0) {
            i = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i4 < 0) {
            i4 = 0;
        }
        bundle.putInt("unLeftHeight", i);
        bundle.putInt("unTopHeight", i2);
        bundle.putInt("unRightHeight", i3);
        bundle.putInt("unBottomHeight", i4);
        bundle.putInt("widthP", i6);
        bundle.putInt("heightP", i5);
        BNRouteGuider.getInstance().setBrowseStatus(false);
        BNMapController.getInstance().zoomToSlightNaviFullView(bundle, true);
        BNMapController.getInstance().updateLayer(13);
        BNMapController.getInstance().setMapShowScreenRect(i, i2, i6 - i3, i5 - i4);
    }

    public static void a(int i) {
        a(false, i);
    }

    @Deprecated
    public static void a(boolean z, int i) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isVertical", true);
        int a2 = d.a((Context) null) + JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_58dp);
        if (i == 0) {
            i = ScreenUtil.getInstance().getHeightPixels();
        }
        int a3 = d.a(false);
        bundle.putInt("unLeftHeight", 0);
        bundle.putInt("unTopHeight", a2);
        bundle.putInt("unRightHeight", 0);
        bundle.putInt("unBottomHeight", a3);
        bundle.putInt("widthP", ScreenUtil.getInstance().getWidthPixels());
        bundle.putInt("heightP", i);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LightNaviMapHelper", "zoomToFullView topHeight=" + a2 + " ,bottomHeight=" + a3 + " ,height=" + i + " ,ScreenUtil.getInstance().getWidthPixels()=" + ScreenUtil.getInstance().getWidthPixels());
        }
        BNMapController.getInstance().zoomToSlightNaviFullView(bundle, true);
        BNMapController.getInstance().updateLayer(13);
    }
}
