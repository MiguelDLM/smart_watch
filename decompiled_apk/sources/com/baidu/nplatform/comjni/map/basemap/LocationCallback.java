package com.baidu.nplatform.comjni.map.basemap;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class LocationCallback {
    private static String strJsonData;

    public static boolean GetLocationLayerData(Bundle bundle) {
        if (TextUtils.isEmpty(strJsonData)) {
            return false;
        }
        if (bundle != null) {
            bundle.putString("jsondata", strJsonData);
            return true;
        }
        return true;
    }

    public static void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            strJsonData = str;
        }
    }
}
