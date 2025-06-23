package com.baidu.mapsdkplatform.comapi.map;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class x {
    private String b(String str) {
        String authToken = SyncSysInfo.getAuthToken();
        if (TextUtils.isEmpty(authToken)) {
            return null;
        }
        String aESSaltKey = JNITools.getAESSaltKey(authToken);
        String aESViKey = JNITools.getAESViKey(authToken);
        if (!TextUtils.isEmpty(aESSaltKey) && !TextUtils.isEmpty(aESViKey) && !TextUtils.isEmpty(str)) {
            try {
                return new String(AlgorithmUtil.getDecryptInfo(aESViKey, aESSaltKey, c(str))).trim();
            } catch (Exception unused) {
                Log.e("PrismBuildingInfo", "getBuildingGeom Decrypt failed");
            }
        }
        return null;
    }

    private byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }

    public ArrayList<LatLng> a(String str) {
        String b = b(str);
        ArrayList<LatLng> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(b)) {
            for (String str2 : b.split(com.huawei.openalliance.ad.constant.x.aL)) {
                String[] split = str2.split(",");
                if (split.length == 2) {
                    String str3 = split[0];
                    try {
                        arrayList.add(new LatLng(Double.parseDouble(split[1]), Double.parseDouble(str3)));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return arrayList;
    }
}
