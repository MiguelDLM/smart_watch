package com.baidu.tts.tools;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.tts.x2;
import com.baidu.tts.y4;
import java.io.UnsupportedEncodingException;

/* loaded from: classes8.dex */
public class ResourceTools {
    public static final int TEXT_LENGTH_LIMIT = 1024;

    public static y4 format(String str, String str2, y4 y4Var) {
        try {
            y4Var.f10206a = new String(y4Var.f10206a.getBytes(str), str2);
            y4Var.b = str2;
            return y4Var;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppExtDir() {
        return "/sdcard/bds-tts/";
    }

    public static String getAppFilesDirPath(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/";
    }

    public static String getAppFilesPath(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir + "/files/";
        } catch (Exception unused) {
            return context.getFilesDir().getAbsolutePath() + "/";
        }
    }

    public static String getByteMapAbsName(Context context, String str) {
        return getModelFileAbsName(context, str + ".bm");
    }

    public static String getModelFileAbsName(Context context, String str) {
        return FileTools.jointPathAndName(getAppFilesPath(context) + "modelDir/", str);
    }

    public static String getNetworkOperatorName(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static x2 isTextValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return x2.u0;
        }
        try {
            if (str.getBytes("gbk").length > 1024) {
                return x2.v0;
            }
            return null;
        } catch (UnsupportedEncodingException unused) {
            return x2.w0;
        }
    }

    public static byte[] stringToByteArrayAddNull(String str) {
        if (str == null) {
            str = "";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(new byte[]{0}, 0, bArr, bytes.length, 1);
        return bArr;
    }
}
