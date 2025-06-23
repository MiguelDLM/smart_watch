package com.baidu.navisdk.adapter.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.navisdk.adapter.BNRoutePlanNode;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.adapter.IBNRoutePlanManager;
import com.baidu.navisdk.adapter.impl.base.BNaviAuthManager;
import com.baidu.navisdk.adapter.struct.BNRoutePlanInfos;
import com.baidu.navisdk.adapter.struct.VehicleConstant;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.RoutePlanTime;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g0;
import com.baidu.navisdk.util.statistic.l;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comjni.tools.JNITools;
import com.tencent.connect.common.II0xO0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* loaded from: classes7.dex */
public final class d implements IBNRoutePlanManager {
    private static final String f = "d";
    private static d g;
    private IBNRoutePlanManager.RouteLinkDataListener b;
    private IBNRoutePlanManager.SelectRouteListener c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6499a = false;
    private final com.baidu.navisdk.util.worker.loop.b d = new a("LNM");
    private final com.baidu.navisdk.comapi.routeplan.v2.a e = new c(this);

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.b {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4115);
            observe(4525);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            if (LogUtil.LOGGABLE) {
                String str = d.f;
                StringBuilder sb = new StringBuilder();
                sb.append("msg.what =");
                sb.append(message.what);
                sb.append("-->");
                sb.append(message.what - 4096);
                sb.append("，msg.arg1 = ");
                sb.append(message.arg1);
                sb.append("，msg.arg2 = ");
                sb.append(message.arg2);
                LogUtil.e(str, sb.toString());
            }
            int i = message.what;
            if (i != 4115) {
                if (i == 4525 && d.this.b != null) {
                    ArrayList<Bundle> arrayList = new ArrayList<>();
                    JNIGuidanceControl.getInstance().getRouteLinkData(arrayList);
                    d.this.b.onDataChange(arrayList);
                    return;
                }
                return;
            }
            if (message.arg1 == 3) {
                if (d.this.c != null) {
                    d.this.c.onSelectComplete();
                    d.this.c = null;
                }
                com.baidu.navisdk.vi.b.b(d.this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f6501a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, Handler handler) {
            super(looper);
            this.f6501a = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1000) {
                if (this.f6501a != null) {
                    Message message2 = new Message();
                    message2.what = 1000;
                    this.f6501a.sendMessage(message2);
                    return;
                }
                return;
            }
            if (i == 1002) {
                LogUtil.out(d.f, "百度导航算路成功");
                ArrayList<RoutePlanNode> k = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).k();
                l.b().a(r9.q(), r9.p());
                if (k != null && k.size() >= 2) {
                    if (this.f6501a != null) {
                        Message message3 = new Message();
                        message3.what = 1002;
                        message3.obj = d.this.c();
                        this.f6501a.sendMessage(message3);
                    }
                    com.baidu.navisdk.adapter.impl.c.f().a(false, this.f6501a);
                    return;
                }
                Handler handler = this.f6501a;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage(1003);
                    obtainMessage.arg1 = 5000;
                    this.f6501a.sendMessage(obtainMessage);
                    return;
                }
                return;
            }
            if (i == 1003) {
                LogUtil.out(d.f, "百度导航算路失败， ec=" + message.arg1);
                Handler handler2 = this.f6501a;
                if (handler2 != null) {
                    Message obtainMessage2 = handler2.obtainMessage(1003);
                    obtainMessage2.arg1 = message.arg1;
                    obtainMessage2.arg2 = message.arg2;
                    obtainMessage2.obj = message.obj;
                    this.f6501a.sendMessage(obtainMessage2);
                }
                d.this.removeRequestByHandler(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.comapi.routeplan.v2.a {
        public c(d dVar) {
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public String getName() {
            return "AD-RP-Single";
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public void onRoutePlan(int i, int i2, com.baidu.navisdk.comapi.routeplan.v2.d dVar, Bundle bundle) {
            int i3;
            Handler handler;
            LogUtil.out(d.f, "onRoutePlan resultType=" + i + ", subType=" + i2);
            Message message = null;
            if (dVar != null && dVar.e() != null) {
                int i4 = dVar.e().f;
                i3 = dVar.e().h;
                if (dVar.e().q != null) {
                    handler = dVar.e().q;
                } else {
                    handler = null;
                }
                LogUtil.out(d.f, "ad.listener entry=" + i4 + ", outH=" + dVar.e().q);
            } else {
                i3 = 0;
                handler = null;
            }
            if (handler != null) {
                message = handler.obtainMessage();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_rp_request_id", dVar.g());
                message.obj = bundle2;
            }
            if (i != 97) {
                if (i != 98) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3 && i != 4) {
                                return;
                            }
                        }
                    } else {
                        if (i3 != 2 && message != null) {
                            message.what = 1000;
                            message.sendToTarget();
                            return;
                        }
                        return;
                    }
                }
                Bundle bundle3 = new Bundle();
                BNRoutePlaner.getInstance().a(new ArrayList<>(), bundle3);
                if (i2 >= 0 && message != null) {
                    message.what = 1003;
                    message.arg1 = i2;
                    if (bundle3.containsKey("nErrorCode")) {
                        message.arg2 = bundle3.getInt("nErrorCode");
                    }
                    if (bundle3.containsKey("usErrorMsg")) {
                        message.obj = bundle3.getString("usErrorMsg");
                    }
                    message.sendToTarget();
                    return;
                }
                return;
            }
            Bundle bundle4 = new Bundle();
            BNRoutePlaner.getInstance().a(new ArrayList<>(), bundle4);
            if (bundle4.containsKey("enNaviType") && bundle4.getInt("enNaviType") == 2 && message != null) {
                message.what = 1003;
                message.arg1 = 5400;
                message.sendToTarget();
            } else if (message != null) {
                message.what = 1002;
                message.sendToTarget();
            }
        }
    }

    private d() {
    }

    @Override // com.baidu.navisdk.adapter.IBNRoutePlanManager
    public BNRoutePlanInfos getRoutePlanInfo() {
        return e.a(new BNRoutePlanInfos());
    }

    @Override // com.baidu.navisdk.adapter.IBNRoutePlanManager
    public int getSelectRouteId() {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out(f, "getSelectRouteId --> init is failed.");
            return -1;
        }
        int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
        LogUtil.out(f, "getSelectRouteId:" + selectRouteIdx);
        return selectRouteIdx;
    }

    @Override // com.baidu.navisdk.adapter.IBNRoutePlanManager
    public void removeRequestByHandler(Handler handler) {
        BNRoutePlaner.getInstance().a(handler);
    }

    @Override // com.baidu.navisdk.adapter.IBNRoutePlanManager
    public boolean routePlan(List<BNRoutePlanNode> list, int i, Bundle bundle, Handler handler) {
        return a(list, i, bundle, new b(Looper.getMainLooper(), handler));
    }

    @Override // com.baidu.navisdk.adapter.IBNRoutePlanManager
    public void selectRoute(int i, IBNRoutePlanManager.SelectRouteListener selectRouteListener) {
        this.c = selectRouteListener;
        com.baidu.navisdk.vi.b.a(this.d);
        LogUtil.out(f, "selectRoute:" + i);
        BNRoutePlaner.getInstance().n(i);
    }

    @Override // com.baidu.navisdk.adapter.IBNRoutePlanManager
    public void setAvoidBlockedRoad(boolean z) {
        BNRoutePlaner.getInstance().c("dest_bind_strategy=" + (z ? 1 : 0));
    }

    @Override // com.baidu.navisdk.adapter.IBNRoutePlanManager
    public void setRouteLinkDataListener(IBNRoutePlanManager.RouteLinkDataListener routeLinkDataListener) {
        this.b = routeLinkDataListener;
        if (routeLinkDataListener != null) {
            com.baidu.navisdk.vi.b.a(this.d);
        } else {
            com.baidu.navisdk.vi.b.b(this.d);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRoutePlanManager
    public void setRoutePlanTime(Date date) {
        RoutePlanTime routePlanTime = new RoutePlanTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        routePlanTime.setYear(calendar.get(1));
        routePlanTime.setMonth(calendar.get(2) + 1);
        routePlanTime.setDay(calendar.get(5));
        routePlanTime.setHour(calendar.get(11));
        routePlanTime.setMinute(calendar.get(12));
        routePlanTime.setValid(true);
        RoutePlanTime routePlanTime2 = new RoutePlanTime();
        routePlanTime2.setValid(true);
        g0.g().a(routePlanTime, new Pair<>(routePlanTime, routePlanTime2));
    }

    @Override // com.baidu.navisdk.adapter.IBNRoutePlanManager
    public void setViaPreferRoutePlanEnable(boolean z) {
        BNSettingManager.setViaPreferRoutePlanEnable(z);
    }

    public static d b() {
        if (g == null) {
            synchronized (d.class) {
                g = new d();
            }
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle c() {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out(f, "initRouteInfo --> init is failed.");
            return null;
        }
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        JNIGuidanceControl.getInstance().GetLocalRouteInfo(bundle2);
        if (bundle2.getInt("type") == 1) {
            String string = bundle2.getString("info");
            if (string != null && string.contains(">")) {
                int indexOf = string.indexOf(">");
                string = string.substring(indexOf + 1, string.indexOf("<", indexOf));
            }
            bundle.putString(BNaviCommonParams.BNRouteInfoKey.TRAFFIC_LIMIT_INFO, string);
        }
        return bundle;
    }

    public GeoPoint a(BNRoutePlanNode bNRoutePlanNode) {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out(f, "getRoutePlanGeoPoint --> init is failed.");
            return null;
        }
        if (bNRoutePlanNode == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint();
        if (SDKInitializer.getCoordType().equals(CoordType.BD09LL)) {
            Bundle Bd09llToGcj02 = JNITools.Bd09llToGcj02(bNRoutePlanNode.getLongitude(), bNRoutePlanNode.getLatitude());
            int i = (int) (Bd09llToGcj02.getDouble("LLx") * 100000.0d);
            geoPoint.setLatitudeE6((int) (Bd09llToGcj02.getDouble("LLy") * 100000.0d));
            geoPoint.setLongitudeE6(i);
        } else if (SDKInitializer.getCoordType().equals(CoordType.GCJ02)) {
            geoPoint.setLatitudeE6((int) (bNRoutePlanNode.getLatitude() * 100000.0d));
            geoPoint.setLongitudeE6((int) (bNRoutePlanNode.getLongitude() * 100000.0d));
        }
        return geoPoint;
    }

    public RoutePlanNode b(BNRoutePlanNode bNRoutePlanNode) {
        if (bNRoutePlanNode == null) {
            return null;
        }
        RoutePlanNode routePlanNode = new RoutePlanNode(a(bNRoutePlanNode), bNRoutePlanNode.getFrom(), bNRoutePlanNode.getName(), bNRoutePlanNode.getDescription(), bNRoutePlanNode.getNodePrefer());
        if (!TextUtils.isEmpty(bNRoutePlanNode.getId())) {
            routePlanNode.setUID(bNRoutePlanNode.getId());
            routePlanNode.setFrom(8);
            routePlanNode.setNodeType(0);
        }
        if (bNRoutePlanNode.getFrom() == 3) {
            routePlanNode.setNodeType(3);
        }
        routePlanNode.setBuildingID(bNRoutePlanNode.getBuildingId());
        routePlanNode.setFloorId(bNRoutePlanNode.getFloorId());
        return routePlanNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(List<BNRoutePlanNode> list, int i, Bundle bundle, Handler handler) {
        if (!SDKInitializer.getAgreePrivacy()) {
            LogUtil.out(f, "SDKInitializer.getAgreePrivacy()返回false");
            if (handler != null) {
                Message message = new Message();
                message.what = 1003;
                message.obj = "请先调用隐私权限接口";
                handler.sendMessage(message);
            }
            return false;
        }
        if (BNSettingManager.isTestEnvironment()) {
            if (BNSettingManager.grtTestEnvironmentUrl() != null) {
                try {
                    JNIGuidanceControl.getInstance().loadUrlAddrConfigParams("routeplan", BNSettingManager.grtTestEnvironmentUrl());
                    LogUtil.out(f, "loadUrlAddrConfigParams 设置算路环境url：" + BNSettingManager.grtTestEnvironmentUrl());
                } catch (UnsatisfiedLinkError e) {
                    com.baidu.navisdk.util.common.g.OPEN_SDK.f(f, e.getMessage());
                }
            } else {
                LogUtil.out(f, "loadUrlAddrConfigParams 未设置算路环境url");
            }
        }
        String str = f;
        LogUtil.out(str, "routePlan() authSuccess=" + BNaviAuthManager.getInstance().isAuthSuccess());
        if (!BNaviAuthManager.getInstance().isAuthSuccess()) {
            return false;
        }
        com.baidu.navisdk.comapi.routeplan.v2.b bVar = new com.baidu.navisdk.comapi.routeplan.v2.b();
        if (bundle != null && bundle.containsKey(BNaviCommonParams.RoutePlanKey.VEHICLE_TYPE)) {
            int i2 = bundle.getInt(BNaviCommonParams.RoutePlanKey.VEHICLE_TYPE);
            if (i2 == 2) {
                if (!BNaviAuthManager.getInstance().hasMotorPermission()) {
                    LogUtil.out(str, "无摩托车使用权限，请先开通权限再使用摩托车算路功能");
                    if (handler != null) {
                        Message message2 = new Message();
                        message2.what = 1003;
                        message2.obj = "无摩托车使用权限，请先开通权限再使用摩托车算路功能";
                        handler.sendMessage(message2);
                    }
                    return false;
                }
            } else if (i2 == 3) {
                if (!BNaviAuthManager.getInstance().hasTruckPermission()) {
                    LogUtil.out(str, "无货车使用权限，请先开通权限再使用货车算路功能");
                    if (handler != null) {
                        Message message3 = new Message();
                        message3.what = 1003;
                        message3.obj = "无货车使用权限，请先开通权限再使用货车算路功能";
                        handler.sendMessage(message3);
                    }
                    return false;
                }
                if (com.baidu.navisdk.module.trucknavi.logic.plate.c.g().a().q.equals(II0xO0.f26886xIXX) && !BNaviAuthManager.getInstance().hasRiskTruckPermission()) {
                    LogUtil.out(str, "无危化货车的高级使用权限，请先开通权限再使用危化货车算路功能");
                    if (handler != null) {
                        Message message4 = new Message();
                        message4.what = 1003;
                        message4.obj = "无危化货车的高级使用权限，请先开通权限再使用危化货车算路功能";
                        handler.sendMessage(message4);
                    }
                    return false;
                }
                bVar.t.putInt(VehicleConstant.PlateBundleKey.POWER_TYPE, com.baidu.navisdk.module.trucknavi.logic.plate.c.g().c());
            } else {
                bVar.t.putInt(VehicleConstant.PlateBundleKey.POWER_TYPE, BNSettingManager.getPowerTypeFromLocal());
            }
        } else {
            bVar.t.putInt(VehicleConstant.PlateBundleKey.POWER_TYPE, BNSettingManager.getPowerTypeFromLocal());
        }
        if (bundle != null && bundle.containsKey(BNaviCommonParams.RoutePlanKey.SUB_VEHICLE) && bundle.getInt(BNaviCommonParams.RoutePlanKey.SUB_VEHICLE) == 1) {
            bundle.putInt("calc_route_sub_vehicle_type", 1);
        }
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (bundle != null && bundle.containsKey(BNaviCommonParams.RoutePlanKey.SUB_VEHICLE) && bundle.getInt(BNaviCommonParams.RoutePlanKey.SUB_VEHICLE) == 1 && k != null && !k.T()) {
            bundle.putInt("calc_route_sub_vehicle_type", 0);
            bundle.putInt(BNaviCommonParams.RoutePlanKey.SUB_VEHICLE, 0);
            LogUtil.out(str, "routePlan() --> 无新能源算路权限，已设为普通车辆");
        }
        if (list == null) {
            LogUtil.out(str, "routePlan() return for the origin nodes is null.");
            return false;
        }
        if (this.f6499a) {
            LogUtil.out(str, "Cruiser is running, please close it!");
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size() && list.get(i3) != null; i3++) {
            arrayList.add(b(list.get(i3)));
        }
        if (arrayList.size() < 2) {
            LogUtil.out(f, "routeplan() return for the nodes size < 2 or >5, size=" + arrayList.size());
            return false;
        }
        bVar.f6726a = (RoutePlanNode) arrayList.get(0);
        if (arrayList.size() > 2) {
            bVar.c = new ArrayList();
            for (int i4 = 1; i4 < arrayList.size() - 1; i4++) {
                bVar.c.add(arrayList.get(i4));
            }
        }
        bVar.b = (RoutePlanNode) arrayList.get(arrayList.size() - 1);
        bVar.d = i;
        bVar.f = 103;
        if (bundle != null && bundle.containsKey(BNaviCommonParams.RoutePlanKey.ASSIGN_ROUTE)) {
            bVar.f = 60;
        } else if (a(bundle)) {
            bVar.f = 105;
        } else if (bundle != null && bundle.containsKey(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_IS_FUTURE) && bundle.getBoolean(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_IS_FUTURE)) {
            bVar.f = 43;
            bundle.putInt("future_trip_cal_type_tx", 0);
            bundle.putBoolean("is_new_future_trip_calc", true);
            BNMapController.getInstance().showLayer(35, false);
        }
        if (BNRouteGuider.getInstance().isNavigating() && !a(bundle)) {
            bVar.f = 2;
        }
        if (BNRouteGuider.getInstance().isNavigating()) {
            bVar.g = 0;
        } else {
            bVar.g = 1;
        }
        bVar.h = 0;
        bVar.p = this.e;
        bVar.q = handler;
        bVar.r = bundle;
        if (bundle == null) {
            bVar.r = new Bundle();
        }
        bVar.r.putBoolean("extra_key_enter_routeguide", false);
        LogUtil.out(f, "calcRoute Param = " + bVar.o());
        com.baidu.navisdk.util.statistic.userop.b.r().a("4.0.4.2", a0.g(), bVar.o());
        BNRoutePlaner.getInstance().a(bVar);
        return true;
    }

    private boolean a(Bundle bundle) {
        return (bundle == null || !bundle.containsKey(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_MRSL) || TextUtils.isEmpty(bundle.getString(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_MRSL)) || !bundle.containsKey(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_SESSION_ID) || TextUtils.isEmpty(bundle.getString(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_SESSION_ID))) ? false : true;
    }

    public void a(boolean z) {
        this.f6499a = z;
    }
}
