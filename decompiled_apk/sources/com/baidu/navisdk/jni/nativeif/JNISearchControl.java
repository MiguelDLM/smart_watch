package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import androidx.core.internal.view.SupportMenu;
import com.baidu.navisdk.framework.a;
import com.baidu.navisdk.model.datastruct.f;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.z;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class JNISearchControl implements JNISearchConst {
    public static JNISearchControl sInstance = new JNISearchControl();

    private JNISearchControl() {
    }

    private f parseDistrictBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        f fVar = new f();
        fVar.f6925a = bundle.getInt("Type", -1);
        fVar.b = bundle.getInt("Id", 0);
        fVar.d = bundle.getInt("CityId", -1);
        fVar.e = bundle.getInt("ProvinceId", -1);
        fVar.c = bundle.getString("Name");
        new GeoPoint(bundle.getInt("CenterX", Integer.MIN_VALUE), bundle.getInt("CenterY", Integer.MIN_VALUE));
        bundle.getInt("ChildCount", 0);
        return fVar;
    }

    public native int GetNetMode();

    public native int GetNetModeOfLastResult();

    public native int SetNetMode(int i);

    public native int clearBkgCache();

    public native int clearFavPoiCache();

    public native int clearPoiCache();

    public native int getChildDistrict(int i, ArrayList<Bundle> arrayList);

    public int getChildDistrictAndParse(int i, ArrayList<f> arrayList) {
        if (arrayList == null) {
            return -1;
        }
        ArrayList<Bundle> arrayList2 = new ArrayList<>();
        if (sInstance.getChildDistrict(i, arrayList2) != 0) {
            return -3;
        }
        int size = arrayList2.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            f parseDistrictBundle = parseDistrictBundle(arrayList2.get(i3));
            if (parseDistrictBundle != null) {
                arrayList.add(parseDistrictBundle);
                i2++;
            }
        }
        return i2;
    }

    public int getCompDistrictId(int i) {
        if (i == -1) {
            return i;
        }
        f districtById = sInstance.getDistrictById(i);
        if (districtById == null) {
            districtById = new f();
            districtById.b = i;
        }
        int i2 = districtById.b;
        int i3 = districtById.f6925a;
        if (i3 == 3) {
            f parentDistrict = sInstance.getParentDistrict(i2);
            if (parentDistrict != null && parentDistrict.f6925a == 2) {
                i2 = ((parentDistrict.b << 16) & SupportMenu.CATEGORY_MASK) | (districtById.b & 65535);
            }
        } else if (i3 == 2) {
            i2 = (i2 << 16) & SupportMenu.CATEGORY_MASK;
        }
        LogUtil.e("", "compDistrictId: " + i2);
        return i2;
    }

    public f getDistrictById(int i) {
        Bundle bundle = new Bundle();
        try {
            if (sInstance.getDistrictInfoById(i, bundle) != 0) {
                return null;
            }
            return parseDistrictBundle(bundle);
        } catch (Throwable unused) {
            return null;
        }
    }

    public f getDistrictByPoint(GeoPoint geoPoint, int i) {
        if (geoPoint == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("CenterX", geoPoint.getLongitudeE6());
        bundle.putInt("CenterY", geoPoint.getLatitudeE6());
        Bundle bundle2 = new Bundle();
        try {
            if (sInstance.getDistrictInfoByPoint(bundle, bundle2) != 0) {
                return null;
            }
            return parseDistrictBundle(bundle2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public native int getDistrictInfoById(int i, Bundle bundle);

    public native int getDistrictInfoByPoint(Bundle bundle, Bundle bundle2);

    public f[] getDistrictsByPoint(GeoPoint geoPoint) {
        f fVar;
        f[] fVarArr = new f[2];
        if (geoPoint != null) {
            if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
                f districtByPoint = sInstance.getDistrictByPoint(geoPoint, 0);
                fVarArr[0] = districtByPoint;
                if (districtByPoint != null) {
                    int i = districtByPoint.f6925a;
                    if (i <= 2) {
                        fVarArr[0] = null;
                    } else if (i == 4) {
                        f parentDistrict = getParentDistrict(districtByPoint.b, 0);
                        if (parentDistrict != null && parentDistrict.f6925a == 3) {
                            fVarArr[0] = parentDistrict;
                            fVarArr[1] = getParentDistrict(parentDistrict.b, 0);
                        } else {
                            fVarArr[0] = null;
                        }
                    } else {
                        f parentDistrict2 = getParentDistrict(districtByPoint.b, 0);
                        fVarArr[1] = parentDistrict2;
                        if (parentDistrict2 != null && parentDistrict2.f6925a != 2) {
                            fVarArr[1] = null;
                        }
                    }
                }
            }
            if (z.a(a.c().a())) {
                if (fVarArr[0] == null) {
                    fVarArr[0] = sInstance.getDistrictByPoint(geoPoint, 1);
                    LogUtil.e("", "get online, district: " + fVarArr[0]);
                    f fVar2 = fVarArr[0];
                    if (fVar2 != null && fVar2.f6925a == 3) {
                        fVarArr[1] = getParentDistrict(fVar2.b, 1);
                        LogUtil.e("", "get online, parent district: " + fVarArr[1]);
                    }
                }
                if (fVarArr[1] == null && (fVar = fVarArr[0]) != null) {
                    fVarArr[1] = getParentDistrict(fVar.b, 1);
                }
            }
        }
        return fVarArr;
    }

    public native int getNearestPoiByPoint(Bundle bundle, Bundle bundle2);

    public native int getParentDistrict(int i, Bundle bundle);

    public f getParentDistrict(int i) {
        try {
            Bundle bundle = new Bundle();
            if (sInstance.getParentDistrict(i, bundle) != 0) {
                return null;
            }
            return parseDistrictBundle(bundle);
        } catch (Throwable unused) {
            return null;
        }
    }

    public native int getTopDistrict(Bundle bundle);

    public f getTopDistrict() {
        try {
            Bundle bundle = new Bundle();
            if (sInstance.getTopDistrict(bundle) != 0) {
                return null;
            }
            return parseDistrictBundle(bundle);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s parseParChildPoiBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        s sVar = new s();
        sVar.e = l0.d(bundle.getString("Name"));
        sVar.f = l0.d(bundle.getString(JNISearchConst.JNI_ALIAS_NAME));
        sVar.g = l0.d(bundle.getString(JNISearchConst.JNI_ADDRESS));
        Bundle bundle2 = bundle.getBundle(JNISearchConst.JNI_VIEW_POINT);
        sVar.k = new GeoPoint(bundle2.getInt("lon"), bundle2.getInt("lat"));
        Bundle bundle3 = bundle.getBundle(JNISearchConst.JNI_VIEW_POINT);
        sVar.j = new GeoPoint(bundle3.getInt("lon"), bundle3.getInt("lat"));
        sVar.l = bundle.getInt("DistrictId", 0);
        sVar.m = bundle.getInt("Type", 0);
        String string = bundle.getString(JNISearchConst.JNI_STREET_ID);
        sVar.n = string;
        if (string != null && string.length() <= 0) {
            sVar.n = null;
        }
        sVar.o = bundle.getInt("Id", 0);
        if (bundle.containsKey(JNISearchConst.JNI_POI_ORIGIN_UID)) {
            sVar.p = bundle.getString(JNISearchConst.JNI_POI_ORIGIN_UID);
        }
        if (bundle.containsKey(JNISearchConst.KEY_UID)) {
            sVar.p = String.valueOf(bundle.getCharArray(JNISearchConst.KEY_UID));
        }
        sVar.q = bundle.getInt(JNISearchConst.JNI_WEIGHT, 0);
        sVar.f6941a = bundle.getInt(JNISearchConst.JNI_CHILD_CNT, 0);
        sVar.c = bundle.getInt(JNISearchConst.JNI_SHOW_CATALOG, 0);
        sVar.b = bundle.getInt(JNISearchConst.JNI_FC_TYPE, 0);
        sVar.d = bundle.getInt("PoiCount", 0);
        sVar.r = bundle.getInt(JNISearchConst.JNI_WAN_DA, -1);
        return sVar;
    }

    public s parsePoiBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        s sVar = new s();
        sVar.e = l0.d(bundle.getString("Name"));
        sVar.h = bundle.getInt(JNISearchConst.JNI_UN_CUR_POS_DISTANCE);
        sVar.g = l0.d(bundle.getString(JNISearchConst.JNI_ADDRESS));
        sVar.i = bundle.getString(JNISearchConst.JNI_PHONE);
        sVar.j = new GeoPoint(bundle.getInt(JNISearchConst.JNI_GUIDE_LONGITUDE, Integer.MIN_VALUE), bundle.getInt(JNISearchConst.JNI_GUIDE_LATITUDE, Integer.MIN_VALUE));
        sVar.k = new GeoPoint(bundle.getInt(JNISearchConst.JNI_VIEW_LONGITUDE, Integer.MIN_VALUE), bundle.getInt(JNISearchConst.JNI_VIEW_LATITUDE, Integer.MIN_VALUE));
        sVar.l = bundle.getInt("DistrictId", 0);
        sVar.m = bundle.getInt("Type", 0);
        String string = bundle.getString(JNISearchConst.JNI_STREET_ID);
        sVar.n = string;
        if (string != null && string.length() <= 0) {
            sVar.n = null;
        }
        sVar.o = bundle.getInt("Id", 0);
        if (bundle.containsKey(JNISearchConst.JNI_POI_ORIGIN_UID)) {
            sVar.p = bundle.getString(JNISearchConst.JNI_POI_ORIGIN_UID);
        }
        sVar.q = bundle.getInt(JNISearchConst.JNI_WEIGHT, 0);
        sVar.s = bundle.getInt(JNISearchConst.JNI_POI_BRAND_ID, 0);
        sVar.t = bundle.getString(JNISearchConst.JNI_POI_TAG, "");
        sVar.u = bundle.getString(JNISearchConst.JNI_ROUTE_COST, "");
        sVar.y = bundle.getString(JNISearchConst.JNI_SHOP_OPEN_TIME, "");
        sVar.x = bundle.getInt(JNISearchConst.JNI_SHOP_OPEN_TIME_COLOR, 1);
        return sVar;
    }

    public native int searchByCircle(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int searchByCircleWithPager(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int searchByKeyInRouteWithPager(Bundle bundle, Bundle bundle2, ArrayList<Bundle> arrayList);

    public native int searchByNameWithPager(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int updateBkgCache(ArrayList<Bundle> arrayList, int i, int i2, int i3);

    public boolean updateBkgPoiCache(GeoPoint geoPoint, boolean z, int i) {
        if (geoPoint == null) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("Id", 0);
            bundle.putString("Name", JNISearchConst.LAYER_POI);
            bundle.putInt(JNISearchConst.JNI_LONGITUDE, geoPoint.getLongitudeE6());
            bundle.putInt("Latitude", geoPoint.getLatitudeE6());
            bundle.putBoolean(JNISearchConst.JNI_IS_MADIAN, z);
            bundle.putInt(JNISearchConst.JNI_FOCUS_INDEX, i);
            if (sInstance.updatePoiCache(bundle) != 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public native int updatePoiCache(Bundle bundle);

    public boolean updatePoiCache(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("Id", 0);
            bundle.putString("Name", JNISearchConst.LAYER_POI);
            bundle.putInt(JNISearchConst.JNI_LONGITUDE, geoPoint.getLongitudeE6());
            bundle.putInt("Latitude", geoPoint.getLatitudeE6());
            return sInstance.updatePoiCache(bundle) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public native int updatePoiCacheWithList(ArrayList<Bundle> arrayList);

    public f getParentDistrict(int i, int i2) {
        try {
            Bundle bundle = new Bundle();
            if (sInstance.getParentDistrict(i, bundle) != 0) {
                return null;
            }
            return parseDistrictBundle(bundle);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getCompDistrictId(f fVar) {
        int i = fVar.b;
        int i2 = fVar.f6925a;
        if (i2 == 3) {
            int i3 = fVar.e;
            if (i3 == -1) {
                f parentDistrict = sInstance.getParentDistrict(i);
                if (parentDistrict != null && parentDistrict.f6925a == 2) {
                    i = ((parentDistrict.b << 16) & SupportMenu.CATEGORY_MASK) | (fVar.b & 65535);
                }
            } else {
                i = (i & 65535) | ((i3 << 16) & SupportMenu.CATEGORY_MASK);
            }
        } else if (i2 == 2) {
            i = (i << 16) & SupportMenu.CATEGORY_MASK;
        }
        LogUtil.e("", "compDistrictId: " + i);
        return i;
    }
}
