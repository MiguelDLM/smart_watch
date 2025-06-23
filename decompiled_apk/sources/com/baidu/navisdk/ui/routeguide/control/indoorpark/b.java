package com.baidu.navisdk.ui.routeguide.control.indoorpark;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.baidunavis.maplayer.d;
import com.baidu.baidunavis.maplayer.e;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.indoorpark.BluetoothListenerReceiver;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private BluetoothListenerReceiver f8549a;

    public void a(String str, String str2) {
        boolean a2 = e.k().a(str, str2);
        if (g.PRO_NAV.d()) {
            Activity b = com.baidu.navisdk.framework.a.c().b();
            StringBuilder sb = new StringBuilder();
            sb.append("切换楼层-");
            sb.append(str);
            sb.append(a2 ? "成功" : "失败");
            TipTool.onCreateToastDialog(b, sb.toString());
        }
    }

    public String b() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(34, bundle);
        String string = bundle.isEmpty() ? "" : bundle.getString("floorInfo", "");
        g gVar = g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("indoorPark getFloorInfo() --> floor=" + string);
        }
        return string;
    }

    public boolean c() {
        boolean isEnabled = BluetoothAdapter.getDefaultAdapter().isEnabled();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("IndoorParkHelper", "isBluetoothEnable-> enable:" + isEnabled);
        }
        return isEnabled;
    }

    public void a(boolean z) {
        e.k().a(z);
    }

    public i0 a(i0.f fVar) {
        return x.b().k(129).D(100).d(JarUtils.getResources().getDrawable(R.drawable.nsdk_notification_indoor_park_bluetooth_icon)).a("室内导航需要蓝牙定位,是否现在开启蓝牙?").z(2).v(-1).y(false).A(false).g("去设置").f("结束导航").a(fVar);
    }

    public void b(boolean z) {
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        int d = aVar.d();
        BNMapController.getInstance().zoomToFullView(new Rect(10, ScreenUtil.getInstance().dip2px(52), aVar.e() - 10, d - ScreenUtil.getInstance().dip2px(72)), true, d, aVar.e(), z);
    }

    public i0 a(String str, boolean z, i0.f fVar) {
        i0 a2 = x.b().k(128).D(100).d(JarUtils.getResources().getDrawable(R.drawable.nsdk_notification_success)).a(str).z(1).b("已到达").v(20000).y(false).g("结束导航").a(fVar);
        if (z) {
            a2.f("更多车位");
        }
        return a2;
    }

    public i0 a(String str, i0.f fVar) {
        return x.b().k(130).D(100).d(JarUtils.getResources().getDrawable(R.drawable.nsdk_notification_success)).a(str).z(1).b("可停放").v(-1).y(false).g("停在这").f("取消").a(fVar);
    }

    public void a(boolean z, int i) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("bShow", z);
        BNMapController.getInstance().setMapFuncInfoMapClass(i, bundle);
    }

    public void a(double d, double d2) {
        com.baidu.nplatform.comapi.basestruct.c cVar = new com.baidu.nplatform.comapi.basestruct.c();
        cVar.a(d);
        cVar.b(d2);
        d dVar = new d(cVar, "", "");
        dVar.a(JarUtils.getResources().getDrawable(R.drawable.bnav_icon_gcoding));
        e.k().b(dVar, null);
    }

    public void a() {
        e.k().a();
    }

    public String a(boolean z, int i, int i2, String str) {
        String format;
        if (z) {
            String string = JarUtils.getResources().getString(R.string.nsdk_indoorpark_more_stall_card_text);
            if (!TextUtils.isEmpty(str)) {
                format = String.format(string, str);
            }
            format = null;
        } else if (i2 > 0) {
            format = String.format(JarUtils.getResources().getString(R.string.nsdk_indoorpark_more_stall_card_unoccupied_stall_text), Integer.valueOf(i2));
        } else {
            String string2 = JarUtils.getResources().getString(R.string.nsdk_indoorpark_more_stall_card_total_stall_text);
            if (i > 0) {
                format = String.format(string2, Integer.valueOf(i));
            }
            format = null;
        }
        if (TextUtils.isEmpty(format)) {
            format = JarUtils.getResources().getString(R.string.nsdk_indoorpark_more_stall_not_info);
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("IndoorParkHelper", "presetIndoorStallText-> cardText=" + format);
        }
        return format;
    }

    public void a(Context context, BluetoothListenerReceiver.a aVar) {
        if (this.f8549a == null) {
            this.f8549a = new BluetoothListenerReceiver(aVar);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            context.registerReceiver(this.f8549a, intentFilter);
        }
    }

    public void a(Context context) {
        BluetoothListenerReceiver bluetoothListenerReceiver = this.f8549a;
        if (bluetoothListenerReceiver == null || context == null) {
            return;
        }
        context.unregisterReceiver(bluetoothListenerReceiver);
        this.f8549a = null;
    }

    public void a(String str) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            String str2 = "--------" + str + "---------";
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().b(), str2);
            gVar.e("IndoorParkHelper", "室内导航错误!! " + str2);
        }
    }
}
