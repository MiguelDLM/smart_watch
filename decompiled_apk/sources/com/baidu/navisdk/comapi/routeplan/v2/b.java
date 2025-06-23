package com.baidu.navisdk.comapi.routeplan.v2;

import XXO0.oIX0oI;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b {
    public int[] o;

    /* renamed from: a, reason: collision with root package name */
    public RoutePlanNode f6726a = null;
    public RoutePlanNode b = null;
    public List<RoutePlanNode> c = null;
    public int d = 0;
    public int e = 0;
    public int f = 29;
    public int g = 1;
    public int h = -1;
    public int i = -1;
    public boolean j = false;
    public String k = "";
    String l = "";
    public int m = 30;
    public int n = 1440;
    public a p = null;
    public Handler q = null;
    public Bundle r = null;
    public int s = -1;
    public Bundle t = new Bundle();
    public Bundle u = new Bundle();

    private String a(int i) {
        if (i == 2) {
            return "导航内的算路";
        }
        if (i == 10) {
            return "路线算路结果页算路(轻导航)";
        }
        if (i == 15) {
            return "快捷方式调起的算路(导航)";
        }
        if (i == 16) {
            return "静默自动进入轻导航";
        }
        if (i == 102) {
            return "du eta";
        }
        if (i == 103) {
            return "外部sdk算路";
        }
        switch (i) {
            case 4:
                return "路线入口算路";
            case 5:
                return "POI页面点导航";
            case 6:
                return "POI页面点到这去";
            case 7:
                return "OPEN API 调用算路";
            case 8:
                return "pbdata 调用算路";
            default:
                switch (i) {
                    case 20:
                        return "点击回家";
                    case 21:
                        return "点击去公司";
                    case 22:
                        return "crash恢复算路导航";
                    case 23:
                        return "驾车页刷新按钮算路";
                    case 24:
                        return "驾车页改偏好重新算路";
                    case 25:
                        return "驾车页修改途经点算路";
                    case 26:
                        return "驾车页进入导航因二次分片数据获取失败发起的全量算路";
                    case 27:
                        return "驾车页点击小黄条上离线转在线按钮";
                    case 28:
                        return "驾车页进入导航因mrsl失效发起的算路";
                    case 29:
                        return "其他入口，比如收藏夹等";
                    case 30:
                        return "行程助手发起算路";
                    case 31:
                        return "预加载算路";
                    case 32:
                        return "用车，仅算路并获取路线全量cars";
                    case 33:
                        return "路线算路来源 － 驾车首页 - 历史记录";
                    case 34:
                        return "从语音进入算路结果页";
                    case 35:
                        return "OpenAPI直接发起导航";
                    case 36:
                        return "终点通知型消息";
                    case 37:
                        return "综合出行";
                    case 38:
                        return "行前语音更新个性化路线，走XX路，不走XX路";
                    case 39:
                        return "直接语音进导航";
                    case 40:
                        return "路线雷达点击刷新";
                    case 41:
                        return "路线雷达其他入口";
                    case 42:
                        return "前置算路，地图首页大框模糊检索预加载算路";
                    case 43:
                        return "未来出行";
                    case 44:
                        return "ugc躲避拥堵";
                    case 45:
                        return "拥堵路段躲避拥堵";
                    case 46:
                        return "驾车页定位方式和精度变化后刷新路线";
                    case 47:
                        return "新版收藏夹发起算路";
                    default:
                        switch (i) {
                            case 49:
                                return "moss 回家";
                            case 50:
                                return "moss 去公司";
                            case 51:
                                return "moss 回家带路线";
                            case 52:
                                return "moss 去公司带路线";
                            case 53:
                                return "护航";
                            case 54:
                                return "moss 关注路线";
                            case 55:
                                return "极速导航";
                            default:
                                switch (i) {
                                    case 57:
                                        return "室内导航，最近一个绑路点发起算路";
                                    case 58:
                                        return "轨迹还原路线";
                                    case 59:
                                        return "moss 去常用地址";
                                    default:
                                        return "算路 entry 异常，请注意";
                                }
                        }
                }
        }
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : this.u.keySet()) {
                jSONObject.put(str, this.u.getString(str));
            }
        } catch (JSONException e) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.a()) {
                gVar.a("getClientInfo err", e.toString());
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("", e);
            }
        }
        Bundle bundle = this.r;
        if (bundle != null && bundle.containsKey(BNaviCommonParams.RoutePlanKey.ASSIGN_ROUTE)) {
            try {
                jSONObject.put("extra", this.r.getString(BNaviCommonParams.RoutePlanKey.ASSIGN_ROUTE));
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String c() {
        int i = this.f;
        if (i != 39 && i != 41 && i != 2) {
            Bundle bundle = this.r;
            if (bundle != null && bundle.containsKey("src_open_api")) {
                return this.r.getString("src_open_api");
            }
            return null;
        }
        Bundle bundle2 = this.r;
        if (bundle2 != null && bundle2.containsKey("speech_id")) {
            return this.r.getString("speech_id");
        }
        return null;
    }

    public float d() {
        Bundle bundle = this.r;
        if (bundle != null && bundle.containsKey("map_level")) {
            return this.r.getFloat("map_level");
        }
        return 0.0f;
    }

    public byte[] e() {
        Bundle bundle = this.r;
        if (bundle != null && bundle.containsKey("pb_data")) {
            return this.r.getByteArray("pb_data");
        }
        return null;
    }

    public int f() {
        Bundle bundle = this.r;
        if (bundle != null && bundle.containsKey("pb_data")) {
            return this.r.getByteArray("pb_data").length;
        }
        return 0;
    }

    public int g() {
        Bundle bundle = this.r;
        if (bundle != null && bundle.containsKey("pb_data_route_data_mode")) {
            return this.r.getInt("pb_data_route_data_mode");
        }
        return -1;
    }

    public int h() {
        Bundle bundle = this.r;
        if (bundle != null && bundle.containsKey("pb_data_type")) {
            return this.r.getInt("pb_data_type");
        }
        return -1;
    }

    public String i() {
        Bundle bundle = this.r;
        if (bundle != null && bundle.containsKey("place_name")) {
            return this.r.getString("place_name");
        }
        return null;
    }

    public int j() {
        Bundle bundle = this.r;
        if (bundle != null && bundle.containsKey("place_type")) {
            return this.r.getInt("place_type");
        }
        return 0;
    }

    public int k() {
        Bundle bundle = this.r;
        if (bundle == null) {
            return 0;
        }
        int i = bundle.getInt("calc_route_sub_vehicle_type", 0);
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (this.r.containsKey("calc_route_sub_vehicle_type") && this.r.getInt("calc_route_sub_vehicle_type") == 1 && k != null && !k.T()) {
            LogUtil.out("RPRequest", "getSubVehicleType() sdk 鉴权 --> 无新能源算路权限，已返回普通车辆类型");
            return 0;
        }
        return i;
    }

    public int l() {
        Bundle bundle = this.r;
        if (bundle != null && bundle.containsKey("user_action")) {
            return this.r.getInt("user_action");
        }
        return 0;
    }

    public int m() {
        Bundle bundle = this.r;
        if (bundle == null) {
            return 1;
        }
        return bundle.getInt(BNaviCommonParams.RoutePlanKey.VEHICLE_TYPE, 1);
    }

    public int n() {
        if (this.h != 1) {
            return 0;
        }
        if (e() != null && e().length > 0) {
            if (h() == 0 || h() == 1 || h() == 2) {
                return 0;
            }
            return 5061;
        }
        return 5061;
    }

    public String o() {
        StringBuilder sb = new StringBuilder();
        if (this.f6726a != null) {
            sb.append("|uid=" + this.f6726a.mUID + ", from=" + this.f6726a.mFrom + ", geoP=" + this.f6726a.mGeoPoint);
        }
        if (this.b != null) {
            sb.append("|uid=" + this.b.mUID + ", from=" + this.b.mFrom + ", geoP=" + this.b.mGeoPoint);
        }
        sb.append("|prefer=");
        sb.append(this.d);
        sb.append("|entry=");
        sb.append(this.f);
        sb.append("|extra=");
        sb.append(this.r);
        sb.append("|carPlate=");
        sb.append(this.l);
        sb.append("|vehicle=");
        sb.append(m());
        return sb.toString();
    }

    public String p() {
        String str;
        try {
            RoutePlanNode routePlanNode = this.f6726a;
            String str2 = null;
            if (routePlanNode != null) {
                str = routePlanNode.toStringForAutoCheck();
            } else {
                str = null;
            }
            RoutePlanNode routePlanNode2 = this.b;
            if (routePlanNode2 != null) {
                str2 = routePlanNode2.toStringForAutoCheck();
            }
            return "{\"startNode\":" + str + ", \"endNode\":" + str2 + ", \"preference\":" + this.d + ", \"subPreference\":" + this.e + ", \"entry\":" + this.f + ", \"source\":" + this.g + ", \"intent\":" + this.h + ", \"networkMode\":" + this.i + ", \"hasMrsl\":" + this.j + ", \"mrsl\":\"" + this.k + "\", \"carNumber\":\"" + this.l + "\", \"localRouteCarInfo\":\"" + this.t.toString() + "\", \"mDriveRefTimeInterval\":" + this.m + ", \"mDriveRefTimeDuration\":" + this.n + ", \"outRoutePlanID\":" + this.s + ", \"vehicle\":" + m() + ", \"subVehicle\":" + k() + '}';
        } catch (Exception unused) {
            return "";
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hashCode=" + hashCode());
        if (this.f6726a != null) {
            stringBuffer.append("|start:name=" + this.f6726a.mName + ", uid=" + this.f6726a.mUID + ", from=" + this.f6726a.mFrom + ", did=" + this.f6726a.mDistrictID + ", geoP=" + this.f6726a.mGeoPoint + ", viewP=" + this.f6726a.mViewPoint);
        }
        if (this.b != null) {
            stringBuffer.append("|end:name=" + this.b.mName + ", uid=" + this.b.mUID + ", from=" + this.b.mFrom + ", did=" + this.b.mDistrictID + ", geoP=" + this.b.mGeoPoint + ", viewP=" + this.b.mViewPoint);
        }
        List<RoutePlanNode> list = this.c;
        if (list != null) {
            for (RoutePlanNode routePlanNode : list) {
                stringBuffer.append("|via:name=" + routePlanNode.mName + ", uid=" + routePlanNode.mUID + ", from=" + routePlanNode.mFrom + ", did=" + routePlanNode.mDistrictID + ", geoP=" + routePlanNode.mGeoPoint + ", viewP=" + routePlanNode.mViewPoint);
            }
        }
        stringBuffer.append("|prefer=" + this.d);
        stringBuffer.append("|entry=" + this.f);
        if (LogUtil.LOGGABLE) {
            stringBuffer.append(oIX0oI.I0Io.f4096II0xO0);
            stringBuffer.append(a(this.f));
            stringBuffer.append(oIX0oI.I0Io.f4095I0Io);
        }
        stringBuffer.append("|intent=" + this.h);
        stringBuffer.append("|source=" + this.g);
        stringBuffer.append("|car=" + this.l);
        stringBuffer.append("|listener=" + this.p);
        stringBuffer.append("|handler=" + this.q);
        stringBuffer.append("|extra=" + this.r);
        stringBuffer.append("|networkMode=" + this.i);
        stringBuffer.append("|localRouteCarInfo=" + this.t.toString());
        stringBuffer.append("|carPlate=");
        stringBuffer.append(this.l);
        stringBuffer.append("|vehicle=");
        stringBuffer.append(m());
        stringBuffer.append("|subVehicle=");
        stringBuffer.append(k());
        return stringBuffer.toString();
    }

    public void a(String str) {
        this.l = str;
    }

    public String a() {
        return this.l;
    }
}
