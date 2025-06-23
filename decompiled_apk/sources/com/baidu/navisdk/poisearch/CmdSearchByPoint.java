package com.baidu.navisdk.poisearch;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.cmdrequest.f;
import com.baidu.navisdk.cmdrequest.i;
import com.baidu.navisdk.cmdrequest.j;
import com.baidu.navisdk.framework.message.bean.r;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public class CmdSearchByPoint extends com.baidu.navisdk.cmdrequest.a implements JNISearchConst {
    s c;
    Integer d;
    GeoPoint e;
    int f = -1;
    int g = -1;
    Integer h = 3;

    public static void a(i iVar, int i, GeoPoint geoPoint) {
        iVar.d.put("param.search.subtype", Integer.valueOf(i));
        iVar.d.put("param.search.point", geoPoint);
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void b(i iVar) {
        this.e = (GeoPoint) iVar.d.get("param.search.point");
        this.d = (Integer) iVar.d.get("param.search.subtype");
        this.h = (Integer) iVar.d.get("param.search.netmode");
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void c() {
        if (this.d.intValue() == 2) {
            i iVar = this.b;
            if (!iVar.f) {
                Message obtainMessage = iVar.e.obtainMessage(iVar.g);
                obtainMessage.arg1 = 0;
                Bundle bundle = new Bundle();
                bundle.putInt("city", this.f);
                bundle.putInt("provice", this.g);
                bundle.putInt("LatitudeE6", this.e.getLatitudeE6());
                bundle.putInt("LongitudeE6", this.e.getLongitudeE6());
                obtainMessage.obj = new j(this.b, bundle);
                obtainMessage.sendToTarget();
                this.b.f = true;
                return;
            }
            return;
        }
        com.baidu.navisdk.model.modelfactory.e eVar = (com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel");
        if (eVar != null) {
            eVar.a(this.c);
        }
        i iVar2 = this.b;
        if (!iVar2.f) {
            Message obtainMessage2 = iVar2.e.obtainMessage(iVar2.g);
            obtainMessage2.arg1 = 0;
            obtainMessage2.obj = new j(this.b, this.c);
            obtainMessage2.sendToTarget();
            this.b.f = true;
        }
    }

    public static void a(i iVar, int i, GeoPoint geoPoint, int i2) {
        iVar.d.put("param.search.subtype", Integer.valueOf(i));
        iVar.d.put("param.search.point", geoPoint);
        iVar.d.put("param.search.netmode", Integer.valueOf(i2));
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public f a() {
        int i;
        if (this.d.intValue() == 1) {
            Integer num = this.h;
            if (num != null) {
                this.c = a(this.e, num.intValue());
            } else {
                com.baidu.navisdk.model.datastruct.f[] districtsByPoint = JNISearchControl.sInstance.getDistrictsByPoint(this.e);
                if (districtsByPoint != null && districtsByPoint.length > 1) {
                    com.baidu.navisdk.model.datastruct.f fVar = districtsByPoint[1];
                    if (fVar != null && ((i = fVar.f6925a) == 2 || i == 3)) {
                        int i2 = (i == 2 && BNOfflineDataManager.getInstance().isProvinceDataDownload(fVar.b)) ? 0 : 1;
                        com.baidu.navisdk.framework.message.a.a().d(new r(this.e, districtsByPoint[0], districtsByPoint[1]));
                        this.c = a(this.e, i2, fVar.b);
                    } else {
                        return this.f6680a;
                    }
                }
            }
            if (this.c != null) {
                this.f6680a.c();
            }
        } else if (this.d.intValue() == 2) {
            com.baidu.navisdk.model.datastruct.f[] districtsByPoint2 = JNISearchControl.sInstance.getDistrictsByPoint(this.e);
            if (districtsByPoint2 != null && districtsByPoint2.length > 1) {
                for (int i3 = 0; i3 < 2; i3++) {
                    com.baidu.navisdk.model.datastruct.f fVar2 = districtsByPoint2[i3];
                    if (fVar2 == null) {
                        return this.f6680a;
                    }
                    int i4 = fVar2.f6925a;
                    if (i4 == 3) {
                        this.f = fVar2.b;
                    } else if (i4 == 2) {
                        this.g = fVar2.b;
                    }
                }
                com.baidu.navisdk.framework.message.a.a().d(new r(this.e, districtsByPoint2[0], districtsByPoint2[1]));
                this.f6680a.c();
            } else {
                this.f6680a.a(-9999);
            }
        }
        return this.f6680a;
    }

    public s a(GeoPoint geoPoint, int i) {
        com.baidu.navisdk.model.datastruct.f districtByPoint;
        int i2;
        if (geoPoint == null || (districtByPoint = JNISearchControl.sInstance.getDistrictByPoint(geoPoint, i)) == null || ((i2 = districtByPoint.f6925a) != 2 && i2 != 3)) {
            return null;
        }
        return a(geoPoint, i, districtByPoint.b);
    }

    public s a(GeoPoint geoPoint, int i, int i2) {
        if (geoPoint != null && i2 != 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("CenterX", geoPoint.getLongitudeE6());
            bundle.putInt("CenterY", geoPoint.getLatitudeE6());
            bundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(i2));
            Bundle bundle2 = new Bundle();
            if (JNISearchControl.sInstance.getNearestPoiByPoint(bundle, bundle2) != 0) {
                return null;
            }
            if (!bundle2.containsKey("DistrictId") || bundle2.getInt("DistrictId", 0) == 0) {
                bundle2.putInt("DistrictId", i2);
            }
            return JNISearchControl.sInstance.parsePoiBundle(bundle2);
        }
        LogUtil.e("", "getPoiByPoint: invalid args!");
        return null;
    }
}
