package com.alimm.tanx.core.utils;

import android.text.TextUtils;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;

/* loaded from: classes.dex */
public class EncryptUtils implements NotConfused {
    private static final String TAG = "EncryptUtils";

    static {
        long currentTimeMillis = System.currentTimeMillis();
        System.loadLibrary(ExposeManager.UtArgsNames.nameSpace);
        LogUtils.d(TAG, "so加载耗时：" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static native byte[] d(String str, String str2);

    public static native byte[] d1(String str);

    public static String decrypt(String str, boolean z) {
        String str2;
        String str3 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                LogUtils.d(TAG, "decrypt()中decryptStr为空 ");
                str = "";
            } else {
                if (TanxCoreSdk.getConfig().isDebugMode()) {
                    if (SharedPreferencesHelper.getInstance().getEncryptBoolean()) {
                        str2 = new String(d1(str));
                    }
                } else {
                    str2 = new String(d1(str));
                }
                str = str2;
            }
            str3 = str;
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
            if (z) {
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e), "");
            }
            e.printStackTrace();
        }
        LogUtils.d(TAG, str3);
        return str3;
    }

    public static native byte[] e(String str, String str2);

    public static String encrypt(String str, boolean z) {
        String str2;
        try {
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
            str2 = "";
            if (z) {
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e), "");
            }
            e.printStackTrace();
        }
        if (TanxCoreSdk.getConfig().isDebugMode()) {
            if (SharedPreferencesHelper.getInstance().getEncryptBoolean()) {
                str2 = new String(e(str, TanxCoreSdk.getConfig().getAppKey()));
            }
            LogUtils.d(TAG, str);
            return str;
        }
        str2 = new String(e(str, TanxCoreSdk.getConfig().getAppKey()));
        str = str2;
        LogUtils.d(TAG, str);
        return str;
    }

    public static String encrypt(String str) {
        return encrypt(str, true);
    }

    public static String decrypt(String str) {
        return decrypt(str, true);
    }
}
