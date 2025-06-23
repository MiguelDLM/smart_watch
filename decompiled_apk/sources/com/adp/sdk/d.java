package com.adp.sdk;

import android.content.Context;
import android.util.Log;
import com.adp.sdk.dto.ADPConfig;
import com.adp.sdk.dto.AdInfo;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BDDialogParams;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4707a = false;

    /* loaded from: classes.dex */
    public static class a implements BDAdConfig.BDAdInitListener {
        @Override // com.baidu.mobads.sdk.api.BDAdConfig.BDAdInitListener
        public void fail() {
        }

        @Override // com.baidu.mobads.sdk.api.BDAdConfig.BDAdInitListener
        public void success() {
            boolean unused = d.f4707a = true;
        }
    }

    public static synchronized boolean a(Context context, com.adp.sdk.listener.a aVar) {
        synchronized (d.class) {
            try {
                if (f4707a) {
                    return true;
                }
                if (context == null) {
                    return false;
                }
                AdInfo adInfo = com.adp.sdk.a.b;
                if (adInfo != null && !a(adInfo.getBaidu())) {
                    ADPConfig aDPConfig = ADP.adpConfig;
                    try {
                        new BDAdConfig.Builder().setAppsid(com.adp.sdk.a.b.getBaidu()).setDialogParams(new BDDialogParams.Builder().setDlDialogType(0).setDlDialogAnimStyle(0).build()).setDebug(false).setWXAppid("").setBDAdInitListener(new a()).build(context).init();
                        if (aDPConfig != null && !aDPConfig.isEnablePersonalRecommend()) {
                            Log.i("adsplus", "允许");
                            MobadsPermissionSettings.setPermissionReadDeviceID(true);
                            MobadsPermissionSettings.setPermissionLocation(true);
                            MobadsPermissionSettings.setPermissionStorage(true);
                            MobadsPermissionSettings.setPermissionAppList(aDPConfig.getPermissionAppListBoolean());
                        } else {
                            Log.i("adsplus", "不允许");
                        }
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return false;
            } finally {
            }
        }
    }

    public static boolean a() {
        return f4707a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
