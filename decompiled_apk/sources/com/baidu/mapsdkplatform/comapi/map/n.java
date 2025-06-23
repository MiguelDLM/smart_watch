package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6188a = "n";
    private static n c;

    @SuppressLint({"HandlerLeak"})
    private static Handler e;
    private AppBaseMap b;
    private s d;

    private n() {
    }

    private void g() {
        h();
        this.d = new s();
        o oVar = new o(this);
        e = oVar;
        MessageCenter.registMessage(65289, oVar);
    }

    private void h() {
        String str;
        EnvironmentUtilities.initAppDirectory(BMapManager.getContext());
        AppBaseMap appBaseMap = new AppBaseMap();
        this.b = appBaseMap;
        appBaseMap.Create();
        String moduleFileName = SysOSUtil.getModuleFileName();
        String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
        String appCachePath = EnvironmentUtilities.getAppCachePath();
        String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
        int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
        int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
        int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
        int ssgTmpStgMax = EnvironmentUtilities.getSsgTmpStgMax();
        if (com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI() >= 180) {
            str = "/h/";
        } else {
            str = "/l/";
        }
        String str2 = moduleFileName + "/cfg";
        String str3 = appSDCardPath + "/vmp";
        String str4 = str2 + "/idrres/";
        String str5 = str3 + str;
        String str6 = str3 + str;
        String str7 = appCachePath + "/tmp/";
        this.b.Init(str2 + "/a/", str4, str5, str7, appSecondCachePath + "/tmp/", str6, str2 + "/a/", com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenWidth(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenHeight(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, ssgTmpStgMax, false, false);
        this.b.OnResume();
    }

    public void b() {
        MessageCenter.unregistMessage(65289, e);
        this.b.releaseFromOfflineMap();
        c = null;
    }

    public boolean c(int i) {
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap == null || i < 0) {
            return false;
        }
        return appBaseMap.OnRecordSuspend(i, false, 0);
    }

    public boolean d(int i) {
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.OnRecordSuspend(0, true, i);
    }

    public boolean e(int i) {
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap == null || i < 0) {
            return false;
        }
        return appBaseMap.OnRecordRemove(i, false);
    }

    public static n a() {
        if (c == null) {
            n nVar = new n();
            c = nVar;
            nVar.g();
        }
        return c;
    }

    public boolean f(int i) {
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return appBaseMap.OnRecordReload(i, false);
        }
        return false;
    }

    public ArrayList<m> c() {
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap == null) {
            return null;
        }
        String OnHotcityGet = appBaseMap.OnHotcityGet();
        ArrayList<m> arrayList = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(OnHotcityGet).optJSONArray("dataset");
            if (optJSONArray == null) {
                return null;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                m mVar = new m();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                mVar.f6187a = optJSONObject.optInt("id");
                mVar.b = optJSONObject.optString("name");
                mVar.c = optJSONObject.optInt("mapsize");
                mVar.d = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                if (optJSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        m mVar2 = new m();
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        mVar2.f6187a = optJSONObject2.optInt("id");
                        mVar2.b = optJSONObject2.optString("name");
                        mVar2.c = optJSONObject2.optInt("mapsize");
                        mVar2.d = optJSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                        arrayList2.add(mVar2);
                    }
                    mVar.a(arrayList2);
                }
                arrayList.add(mVar);
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public ArrayList<m> d() {
        AppBaseMap appBaseMap = this.b;
        ArrayList<m> arrayList = null;
        if (appBaseMap == null) {
            return null;
        }
        String OnSchcityGet = appBaseMap.OnSchcityGet("");
        ArrayList<m> arrayList2 = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(OnSchcityGet).optJSONArray("dataset");
            if (optJSONArray == null) {
                return null;
            }
            int i = 0;
            while (i < optJSONArray.length()) {
                m mVar = new m();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                int optInt = optJSONObject.optInt("id");
                if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                    mVar.f6187a = optInt;
                    mVar.b = optJSONObject.optString("name");
                    mVar.c = optJSONObject.optInt("mapsize");
                    mVar.d = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                    if (optJSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                        ArrayList<m> arrayList3 = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            m mVar2 = new m();
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            try {
                                mVar2.f6187a = optJSONObject2.optInt("id");
                                mVar2.b = optJSONObject2.optString("name");
                                mVar2.c = optJSONObject2.optInt("mapsize");
                                mVar2.d = optJSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                                arrayList3.add(mVar2);
                            } catch (JSONException unused) {
                                return null;
                            } catch (Exception unused2) {
                                return null;
                            }
                        }
                        mVar.a(arrayList3);
                    }
                    arrayList2.add(mVar);
                }
                i++;
                arrayList = null;
            }
            return arrayList2;
        } catch (JSONException unused3) {
            return arrayList;
        } catch (Exception unused4) {
            return arrayList;
        }
    }

    public ArrayList<q> e() {
        String OnRecordGetAll;
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap != null && (OnRecordGetAll = appBaseMap.OnRecordGetAll()) != null && !OnRecordGetAll.equals("")) {
            ArrayList<q> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(OnRecordGetAll);
                if (jSONObject.length() == 0) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("dataset");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    q qVar = new q();
                    p pVar = new p();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    pVar.f6190a = optJSONObject.optInt("id");
                    pVar.b = optJSONObject.optString("name");
                    pVar.c = optJSONObject.optString("pinyin");
                    pVar.h = optJSONObject.optInt("mapoldsize");
                    pVar.i = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
                    pVar.l = optJSONObject.optInt("status");
                    pVar.g = new GeoPoint(optJSONObject.optInt("y"), optJSONObject.optInt("x"));
                    boolean z = true;
                    if (optJSONObject.optInt("up") != 1) {
                        z = false;
                    }
                    pVar.j = z;
                    pVar.e = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);
                    if (pVar.j) {
                        pVar.k = optJSONObject.optInt("mapsize");
                    } else {
                        pVar.k = 0;
                    }
                    qVar.a(pVar);
                    arrayList.add(qVar);
                }
                return arrayList;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public void b(r rVar) {
        s sVar = this.d;
        if (sVar != null) {
            sVar.b(rVar);
        }
    }

    public q g(int i) {
        String OnRecordGetAt;
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap != null && i >= 0 && (OnRecordGetAt = appBaseMap.OnRecordGetAt(i)) != null && !OnRecordGetAt.equals("")) {
            q qVar = new q();
            p pVar = new p();
            try {
                JSONObject jSONObject = new JSONObject(OnRecordGetAt);
                if (jSONObject.length() == 0) {
                    return null;
                }
                int optInt = jSONObject.optInt("id");
                if (optInt > 2000 && optInt != 2912 && optInt != 2911 && optInt != 9000) {
                    return null;
                }
                pVar.f6190a = optInt;
                pVar.b = jSONObject.optString("name");
                pVar.c = jSONObject.optString("pinyin");
                pVar.d = jSONObject.optString("headchar");
                pVar.h = jSONObject.optInt("mapoldsize");
                pVar.i = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
                pVar.l = jSONObject.optInt("status");
                pVar.g = new GeoPoint(jSONObject.optInt("y"), jSONObject.optInt("x"));
                boolean z = true;
                if (jSONObject.optInt("up") != 1) {
                    z = false;
                }
                pVar.j = z;
                pVar.e = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);
                if (pVar.j) {
                    pVar.k = jSONObject.optInt("mapsize");
                } else {
                    pVar.k = 0;
                }
                pVar.f = jSONObject.optInt("ver");
                qVar.a(pVar);
                return qVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public void a(r rVar) {
        s sVar = this.d;
        if (sVar != null) {
            sVar.a(rVar);
        }
    }

    public boolean b(int i) {
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return appBaseMap.OnRecordStart(i, false, 0);
        }
        return false;
    }

    public boolean a(int i) {
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return appBaseMap.OnRecordAdd(i);
        }
        return false;
    }

    public boolean a(boolean z, boolean z2) {
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.OnRecordImport(z, z2);
    }

    public ArrayList<m> a(String str) {
        AppBaseMap appBaseMap;
        JSONArray optJSONArray;
        if (!str.equals("") && (appBaseMap = this.b) != null) {
            String OnSchcityGet = appBaseMap.OnSchcityGet(str);
            if (OnSchcityGet == null || OnSchcityGet.equals("")) {
                return null;
            }
            ArrayList<m> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(OnSchcityGet);
                if (jSONObject.length() == 0 || (optJSONArray = jSONObject.optJSONArray("dataset")) == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    m mVar = new m();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    int optInt = jSONObject2.optInt("id");
                    if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                        mVar.f6187a = optInt;
                        mVar.b = jSONObject2.optString("name");
                        mVar.c = jSONObject2.optInt("mapsize");
                        mVar.d = jSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                        if (jSONObject2.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                            ArrayList<m> arrayList2 = new ArrayList<>();
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                m mVar2 = new m();
                                JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                                mVar2.f6187a = optJSONObject.optInt("id");
                                mVar2.b = optJSONObject.optString("name");
                                mVar2.c = optJSONObject.optInt("mapsize");
                                mVar2.d = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                                arrayList2.add(mVar2);
                            }
                            mVar.a(arrayList2);
                        }
                        arrayList.add(mVar);
                    }
                }
                return arrayList;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
