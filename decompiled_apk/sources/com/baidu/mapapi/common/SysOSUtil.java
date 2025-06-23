package com.baidu.mapapi.common;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.util.i;

/* loaded from: classes7.dex */
public class SysOSUtil {
    public static String getAuthToken() {
        return i.b();
    }

    public static float getDensity() {
        return i.b;
    }

    public static int getDensityDpi() {
        return i.o();
    }

    public static String getDeviceID() {
        String s = i.s();
        if (TextUtils.isEmpty(s)) {
            return s;
        }
        return s.substring(0, s.indexOf("|"));
    }

    public static String getModuleFileName() {
        return i.r();
    }

    public static String getPhoneType() {
        return i.j();
    }

    public static int getScreenSizeX() {
        return i.k();
    }

    public static int getScreenSizeY() {
        return i.m();
    }

    public static void updateCuid() {
        i.s();
    }
}
