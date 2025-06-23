package com.baidu.mapapi.map;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.util.DeviceId;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import java.util.HashMap;

/* loaded from: classes7.dex */
class t implements e.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomMapStyleCallBack f5911a;
    final /* synthetic */ MapCustomStyleOptions b;
    final /* synthetic */ MapView c;

    public t(MapView mapView, CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
        this.c = mapView;
        this.f5911a = customMapStyleCallBack;
        this.b = mapCustomStyleOptions;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.e.a
    public void a(String str) {
        CustomMapStyleCallBack customMapStyleCallBack = this.f5911a;
        if (customMapStyleCallBack == null || !customMapStyleCallBack.onPreLoadLastCustomMapStyle(str)) {
            this.c.a(str, this.b);
            this.c.C = true;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.e.a
    public void a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DeviceId.CUIDInfo.I_FIXED, "online");
        hashMap.put(ExifInterface.LONGITUDE_EAST, "1");
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "CS", "0", hashMap);
        CustomMapStyleCallBack customMapStyleCallBack = this.f5911a;
        if ((customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadSuccess(z, str)) && z && !TextUtils.isEmpty(str)) {
            this.c.a(str, "");
            this.c.setMapCustomStyleEnable(true);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.e.a
    public void a(int i, String str, String str2) {
        boolean z;
        HashMap hashMap = new HashMap();
        hashMap.put(DeviceId.CUIDInfo.I_FIXED, "local");
        hashMap.put(ExifInterface.LONGITUDE_EAST, "0");
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "CS", "0", hashMap);
        CustomMapStyleCallBack customMapStyleCallBack = this.f5911a;
        if (customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadFailed(i, str, str2)) {
            z = this.c.C;
            if (z) {
                return;
            }
            this.c.a(str2, this.b);
        }
    }
}
