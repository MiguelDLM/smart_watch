package com.baidu.navisdk.adapter.impl;

import android.text.TextUtils;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.navisdk.framework.interfaces.s;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class BNVdrController implements s {

    /* renamed from: a, reason: collision with root package name */
    private final LocationClient f6483a;
    private final BDAbstractLocationListener b;

    public BNVdrController() {
        BDAbstractLocationListener bDAbstractLocationListener = new BDAbstractLocationListener() { // from class: com.baidu.navisdk.adapter.impl.BNVdrController.1
            @Override // com.baidu.location.BDAbstractLocationListener
            public void onReceiveLocation(BDLocation bDLocation) {
                String upperCase;
                LogUtil.out("BNVdrController", "onReceiveLocation：" + bDLocation.toString());
                int locType = bDLocation.getLocType();
                if (locType != 61 && locType != 161 && locType != 66) {
                    return;
                }
                com.baidu.navisdk.model.datastruct.g gVar = new com.baidu.navisdk.model.datastruct.g();
                gVar.i = locType;
                if (locType == 61) {
                    gVar.k = 1;
                } else {
                    gVar.k = 2;
                }
                gVar.f6926a = bDLocation.getLatitude();
                gVar.b = bDLocation.getLongitude();
                gVar.c = bDLocation.getSpeed();
                gVar.f = Math.min(2000.0f, bDLocation.getRadius());
                gVar.e = bDLocation.getDirection();
                gVar.g = bDLocation.getSatelliteNumber();
                gVar.q = bDLocation.getBuildingID();
                if (bDLocation.getFloor() == null) {
                    upperCase = null;
                } else {
                    upperCase = bDLocation.getFloor().toUpperCase();
                }
                gVar.p = upperCase;
                gVar.l = bDLocation.getUserIndoorState();
                gVar.m = bDLocation.getNetworkLocationType();
                gVar.h = bDLocation.getAltitude();
                gVar.n = bDLocation.getRoadLocString();
                gVar.d = bDLocation.getGpsBiasProb();
                gVar.r = bDLocation.getExtraInfo();
                gVar.n = bDLocation.getRoadLocString();
                com.baidu.navisdk.util.logic.a.j().d(gVar);
                com.baidu.navisdk.util.logic.a.j().b(gVar);
            }

            @Override // com.baidu.location.BDAbstractLocationListener
            public void onReceiveVdrLocation(BDLocation bDLocation) {
                LogUtil.out("BNVdrController", "onReceiveVdrLocation: " + bDLocation.getVdrJsonString());
                com.baidu.navisdk.module.vdr.a.a(bDLocation.getVdrJsonString());
            }
        };
        this.b = bDAbstractLocationListener;
        try {
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setLocationNotify(true);
            locationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
            locationClientOption.setScanSpan(3000);
            locationClientOption.setIsNeedAltitude(true);
            LocationClient.setAgreePrivacy(true);
            LocationClient locationClient = new LocationClient(com.baidu.navisdk.framework.a.c().a(), locationClientOption);
            this.f6483a = locationClient;
            locationClient.requestLocation();
            locationClient.registerLocationListener(bDAbstractLocationListener);
        } catch (Exception unused) {
            throw new RuntimeException("使用VDR功能，请先集成百度定位SDK！");
        }
    }

    private int b(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1) {
            return -1;
        }
        String str = arrayList.get(0);
        if (TextUtils.isEmpty(str) || !str.contains("navi_status")) {
            return -1;
        }
        try {
            return new JSONObject(str).optInt("navi_status");
        } catch (JSONException unused) {
            return -1;
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.s
    public boolean a(ArrayList<String> arrayList) {
        if (this.f6483a == null) {
            return false;
        }
        int b = b(arrayList);
        LogUtil.out("BNVdrController", "state:" + b);
        if (b == 0) {
            this.f6483a.unRegisterLocationListener(this.b);
        } else if (b == 1) {
            this.f6483a.registerLocationListener(this.b);
        }
        return this.f6483a.startVdr(arrayList);
    }

    @Override // com.baidu.navisdk.framework.interfaces.s
    public boolean d0() {
        return this.f6483a.isStarted();
    }

    @Override // com.baidu.navisdk.framework.interfaces.s
    public void k(boolean z) {
        if (z) {
            this.f6483a.start();
        } else {
            this.f6483a.stop();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.s
    public boolean o() {
        return false;
    }
}
