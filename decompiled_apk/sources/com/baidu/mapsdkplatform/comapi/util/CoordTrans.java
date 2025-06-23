package com.baidu.mapsdkplatform.comapi.util;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;

/* loaded from: classes7.dex */
public class CoordTrans {
    public static LatLng baiduToGcj(LatLng latLng) {
        double[] baiduToGcj;
        if (latLng == null || (baiduToGcj = JNITools.baiduToGcj(latLng.latitude, latLng.longitude)) == null) {
            return null;
        }
        return new LatLng(baiduToGcj[0], baiduToGcj[1]);
    }

    public static LatLng gcjToBaidu(LatLng latLng) {
        double[] gcjToBaidu;
        if (latLng == null || (gcjToBaidu = JNITools.gcjToBaidu(latLng.latitude, latLng.longitude)) == null) {
            return null;
        }
        return new LatLng(gcjToBaidu[0], gcjToBaidu[1]);
    }

    public static LatLng wgsToBaidu(LatLng latLng) {
        double[] wgsToBaidu;
        if (latLng == null || (wgsToBaidu = JNITools.wgsToBaidu(latLng.latitude, latLng.longitude)) == null) {
            return null;
        }
        return new LatLng(wgsToBaidu[0], wgsToBaidu[1]);
    }
}
