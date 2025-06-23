package com.baidu.navisdk;

import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.navisdk.adapter.IBNUIController;
import com.baidu.navisdk.adapter.IBNaviListener;
import com.baidu.navisdk.adapter.sl.BNCarPoolManager;
import com.baidu.navisdk.adapter.sl.BNShareLocationManager;
import com.baidu.navisdk.adapter.struct.BNHighwayInfo;
import com.baidu.navisdk.adapter.struct.BNRoadCondition;
import com.baidu.navisdk.adapter.struct.BNavLineItem;
import com.baidu.navisdk.adapter.struct.BNaviInfo;
import com.baidu.navisdk.adapter.struct.BNaviLocation;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.garmin.fit.xOxOoo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class b extends IBNaviListener {
    private static final String i = "b";

    /* renamed from: a, reason: collision with root package name */
    private int f6564a;
    private int b;
    private BNaviLocation c;
    private ImageView d;
    private com.baidu.nplatform.comapi.map.e e;
    private IBNaviListener f;
    private IBNUIController g;
    private final com.baidu.navisdk.comapi.commontool.b h;

    /* loaded from: classes7.dex */
    public class a implements com.baidu.navisdk.comapi.commontool.b {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            if (i == 1) {
                if (i2 != 2 && i2 != 4) {
                    if (i2 == 3 || i2 == 5) {
                        b.this.onDayNightChanged(IBNaviListener.DayNightMode.NIGHT);
                        return;
                    }
                    return;
                }
                b.this.onDayNightChanged(IBNaviListener.DayNightMode.DAY);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0169b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f6566a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b f() {
        return C0169b.f6566a;
    }

    public void a(IBNaviListener iBNaviListener) {
        this.f = iBNaviListener;
        com.baidu.navisdk.comapi.commontool.a.getInstance().addObserver(this.h);
    }

    public List<BNRoadCondition> b() {
        List<com.baidu.navisdk.model.datastruct.m> value;
        ArrayList arrayList = new ArrayList();
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s == null) {
            return arrayList;
        }
        com.baidu.navisdk.pronavi.data.model.g gVar = (com.baidu.navisdk.pronavi.data.model.g) s.b(com.baidu.navisdk.pronavi.data.model.g.class);
        if (gVar != null && gVar.d().getValue() != null && (value = gVar.d().getValue()) != null && !value.isEmpty()) {
            for (com.baidu.navisdk.model.datastruct.m mVar : value) {
                BNRoadCondition bNRoadCondition = new BNRoadCondition();
                bNRoadCondition.setIndex(mVar.f6935a);
                bNRoadCondition.setType(mVar.b);
                arrayList.add(bNRoadCondition);
            }
        }
        return arrayList;
    }

    public IBNUIController c() {
        if (this.g == null) {
            this.g = new com.baidu.navisdk.adapter.impl.h();
        }
        return this.g;
    }

    public void d() {
        if (BNRoutePlaner.getInstance().t() >= 1) {
            Bundle bundle = new Bundle();
            int i2 = bundle.getInt("totaldistance");
            int i3 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
            int i4 = bundle.getInt("tollfees");
            int i5 = bundle.getInt("trafficlightcnt");
            int i6 = bundle.getInt("gasmoney");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(xOxOoo.f15470o00, i2);
            bundle2.putInt("time", i3);
            bundle2.putInt("toll_fees", i4);
            bundle2.putInt("lights_count", i5);
            bundle2.putInt("gas_money", i6);
            com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(27, 0, 0, bundle2);
        }
    }

    public void e() {
        this.f = null;
        com.baidu.navisdk.comapi.commontool.a.getInstance().deleteObserver(this.h);
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onArriveDestination() {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onArriveDestination();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onArrivedWayPoint(int i2) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onArrivedWayPoint(i2);
        }
        BNCarPoolManager.getInstance().onCommonMessageCallback(38, Integer.valueOf(i2), 0, null);
        BNShareLocationManager.getInstance().onCommonMessageCallback(38, Integer.valueOf(i2), 0, null);
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onAutoScaleChanged(boolean z) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onAutoScaleChanged(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onCarLogoToEndRedLineChanged(boolean z) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onCarLogoToEndRedLineChanged(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onDayNightChanged(IBNaviListener.DayNightMode dayNightMode) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onDayNightChanged(dayNightMode);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onDiyVoiceModeChanged(int i2) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onDiyVoiceModeChanged(i2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onEnlargeMapUpdate(IBNaviListener.Action action, View view, String str, int i2, String str2, Bitmap bitmap) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onEnlargeMapUpdate(action, view, str, i2, str2, bitmap);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onFastExitWayInfoUpdate(IBNaviListener.Action action, String str, int i2, String str2) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onFastExitWayInfoUpdate(action, str, i2, str2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onFullViewModeChanged(int i2) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onFullViewModeChanged(i2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onGuideInfoUpdate(BNaviInfo bNaviInfo) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onGuideInfoUpdate(bNaviInfo);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onGuideModeChanged(int i2) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onGuideModeChanged(i2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onGuideViewModeChanged(int i2) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onGuideViewModeChanged(i2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onHeavyTraffic() {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onHeavyTraffic();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onHighWayInfoUpdate(IBNaviListener.Action action, BNHighwayInfo bNHighwayInfo) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onHighWayInfoUpdate(action, bNHighwayInfo);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onLaneInfoUpdate(IBNaviListener.Action action, List<BNavLineItem> list) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onLaneInfoUpdate(action, list);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onLocationChange(BNaviLocation bNaviLocation) {
        this.c = bNaviLocation;
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onLocationChange(bNaviLocation);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onMainRouteChange(int i2) {
        if (LogUtil.OUT_LOGGABLE) {
            LogUtil.out(i, "onMainRouteChange");
        }
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onMainRouteChange(i2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onMainSideBridgeUpdate(int i2) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onMainSideBridgeUpdate(i2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onMapStateChange(IBNaviListener.MapStateMode mapStateMode) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onMapStateChange(mapStateMode);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onNaviGuideEnd() {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onNaviGuideEnd();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onNotificationShow(String str) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onNotificationShow(str);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onOverSpeed(int i2, int i3) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onOverSpeed(i2, i3);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onRemainInfoUpdate(int i2, int i3) {
        com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(36, i2, i3, null);
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onRemainInfoUpdate(i2, i3);
        }
        this.f6564a = i2;
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onRoadConditionInfoUpdate(double d, List<BNRoadCondition> list) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onRoadConditionInfoUpdate(d, list);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onRoadEnlargeViewChanged(boolean z) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onRoadEnlargeViewChanged(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onRoadNameUpdate(String str) {
        new Bundle().putString("current_road_name", str);
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onRoadNameUpdate(str);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onSpeedUpdate(int i2, int i3) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onSpeedUpdate(i2, i3);
        }
        if (i3 != -1 && i2 > i3) {
            int i4 = this.b;
            if (i4 == -1 || i4 - this.f6564a > 1000) {
                this.b = this.f6564a;
                onOverSpeed(i2, i3);
            }
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onStartYawing(String str) {
        this.b = -1;
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onStartYawing(str);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onViaListRemainInfoUpdate(Message message) {
        com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(37, 0, 0, null);
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onViaListRemainInfoUpdate(message);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onVoiceModeChanged(int i2) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onVoiceModeChanged(i2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onYawingArriveViaPoint(int i2) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onYawingArriveViaPoint(i2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onYawingSuccess() {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onYawingSuccess();
        }
    }

    private b() {
        this.b = -1;
        this.f = null;
        this.g = null;
        this.h = new a();
    }

    public void a(String str) {
        IBNaviListener iBNaviListener = this.f;
        if (iBNaviListener != null) {
            iBNaviListener.onRouteForceSwitch(str, System.currentTimeMillis(), this.f6564a, this.c);
        }
    }

    public void a(int i2) {
        onMainRouteChange(i2);
        this.b = -1;
        Bundle bundle = new Bundle();
        BNRoutePlaner.getInstance().c(bundle);
        bundle.putInt("BNRouteChangeType", i2);
        com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(35, 0, 0, bundle);
    }

    public void a(Activity activity, String str, Bundle bundle, IBNaviListener.Action action) {
        int i2 = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.TotalDist);
        int i3 = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.RemainDist);
        String string = bundle.getString("road_name");
        int i4 = (i3 <= 0 || i2 <= 0) ? 100 : ((i2 - i3) * 100) / i2;
        Bitmap bitmap = ((BitmapDrawable) a0.I().d(a0.I().h().getString("icon_name"))).getBitmap();
        LogUtil.e(i, "enlargeMapType=" + str + "action=" + action + ", remainedDistance=" + i3 + ",totalDistance=" + i2 + ", progress=" + i4);
        if (!"Raster".equals(str) && !"Street".equals(str)) {
            if ("Dynamic".equals(str)) {
                if (this.e == null) {
                    this.e = new com.baidu.nplatform.comapi.map.e(activity);
                }
                f().onEnlargeMapUpdate(action, this.e, i3 + "", i4, string, bitmap);
                return;
            }
            return;
        }
        if (this.d == null) {
            ImageView imageView = new ImageView(activity);
            this.d = imageView;
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.d.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ("Raster".equals(str)) {
            this.d.setBackgroundDrawable(new BitmapDrawable(com.baidu.navisdk.ui.routeguide.model.i.s().c()));
            this.d.setImageBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().b());
        } else {
            this.d.setImageBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().c());
            this.d.setBackgroundResource(R.color.transparent);
        }
        f().onEnlargeMapUpdate(action, this.d, i3 + "", i4, string, bitmap);
    }

    public BNHighwayInfo a() {
        BNHighwayInfo bNHighwayInfo = new BNHighwayInfo();
        bNHighwayInfo.directionText = com.baidu.navisdk.ui.routeguide.model.m.y().a();
        bNHighwayInfo.exitRemainDist = com.baidu.navisdk.ui.routeguide.model.m.y().h();
        bNHighwayInfo.exitCode = com.baidu.navisdk.ui.routeguide.model.m.y().d();
        bNHighwayInfo.exitName = com.baidu.navisdk.ui.routeguide.model.m.y().g();
        bNHighwayInfo.gateName = com.baidu.navisdk.ui.routeguide.model.m.y().k();
        bNHighwayInfo.gateRemainDist = com.baidu.navisdk.ui.routeguide.model.m.y().l();
        bNHighwayInfo.serviceName = com.baidu.navisdk.ui.routeguide.model.m.y().q();
        bNHighwayInfo.service2Name = com.baidu.navisdk.ui.routeguide.model.m.y().o();
        bNHighwayInfo.serviceRemainDist = com.baidu.navisdk.ui.routeguide.model.m.y().r();
        bNHighwayInfo.service2RemainDist = com.baidu.navisdk.ui.routeguide.model.m.y().p();
        bNHighwayInfo.highWayName = com.baidu.navisdk.ui.routeguide.model.m.y().b();
        return bNHighwayInfo;
    }

    public void a(String str, int i2, String str2) {
        Drawable d = a0.I().d(str2);
        BNaviInfo bNaviInfo = new BNaviInfo();
        bNaviInfo.roadName = str;
        bNaviInfo.distance = i2;
        bNaviInfo.turnIcon = ((BitmapDrawable) d).getBitmap();
        bNaviInfo.turnIconName = str2;
        onGuideInfoUpdate(bNaviInfo);
    }

    public void a(String str, int i2, String str2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("first_service_name", str);
        bundle.putInt("first_service_distance", i2);
        bundle.putString("second_service_name", str2);
        bundle.putInt("second_service_distance", i3);
        com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(31, 0, 0, bundle);
        LogUtil.e(i, "onServiceAreaUpdate " + str + "," + i2);
    }

    public void a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_along", z);
        com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(33, 0, 0, bundle);
    }
}
