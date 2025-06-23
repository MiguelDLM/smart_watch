package com.baidu.platform.core.f;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.huawei.openalliance.ad.constant.x;
import java.util.List;

/* loaded from: classes8.dex */
public class b extends com.baidu.platform.base.e {
    public b(BikingRoutePlanOption bikingRoutePlanOption) {
        a(bikingRoutePlanOption);
    }

    private void a(BikingRoutePlanOption bikingRoutePlanOption) {
        this.f9530a.a("mode", "riding");
        PlanNode planNode = bikingRoutePlanOption.mFrom;
        PlanNode planNode2 = bikingRoutePlanOption.mTo;
        if (planNode == null || planNode2 == null) {
            return;
        }
        LatLng location = planNode.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            if (location != null) {
                this.f9530a.a("origin", location.latitude + "," + location.longitude);
            }
        } else {
            this.f9530a.a("origin", planNode.getName());
            this.f9530a.a("origin_region", planNode.getCity());
        }
        if (planNode.getPoiId() != null && planNode.getPoiId().length() > 0) {
            this.f9530a.a("origin_uid", planNode.getPoiId());
        }
        LatLng location2 = planNode2.getLocation();
        if (location2 == null) {
            this.f9530a.a("destination", planNode2.getName());
            this.f9530a.a("destination_region", planNode2.getCity());
        } else {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            if (location2 != null) {
                this.f9530a.a("destination", location2.latitude + "," + location2.longitude);
            }
        }
        if (planNode2.getPoiId() != null && planNode2.getPoiId().length() > 0) {
            this.f9530a.a("destination_uid", planNode2.getPoiId());
        }
        int i = bikingRoutePlanOption.mRidingType;
        if (i == 1) {
            this.f9530a.a("riding_type", String.valueOf(i));
        }
        List<PlanNode> wayPoints = bikingRoutePlanOption.getWayPoints();
        if (wayPoints != null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < wayPoints.size(); i2++) {
                PlanNode planNode3 = wayPoints.get(i2);
                if (i2 == 0) {
                    sb.append(a(planNode3, this.f9530a));
                } else {
                    sb.append("|");
                    sb.append(a(planNode3, this.f9530a));
                }
            }
            this.f9530a.a("waypoints", sb.toString());
        }
        this.f9530a.a("output", "json");
        this.f9530a.a(TypedValues.TransitionType.S_FROM, "android_map_sdk");
    }

    private String a(PlanNode planNode, com.baidu.platform.util.a aVar) {
        String str;
        String str2;
        String str3;
        if (planNode != null && aVar != null) {
            LatLng location = planNode.getLocation();
            if (planNode.getPoiId() == null) {
                str = "";
            } else {
                str = planNode.getPoiId();
            }
            if (location != null) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    location = CoordTrans.gcjToBaidu(location);
                }
                if (location != null) {
                    return location.latitude + "," + location.longitude + x.aL + str;
                }
            } else {
                if (planNode.getCityCode() == null) {
                    str2 = "";
                } else {
                    str2 = planNode.getCityCode();
                }
                if (planNode.getCityName() == null) {
                    str3 = "";
                } else {
                    str3 = planNode.getCityName();
                }
                if (planNode.getName() != null && planNode.getName().length() > 0) {
                    return planNode.getName() + x.aL + str + x.aL + str3 + x.aL + str2;
                }
            }
        }
        return "";
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.j();
    }
}
