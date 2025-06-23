package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.h;
import java.io.File;
import xIoXXXIXo.O0xOxO;

/* loaded from: classes7.dex */
public class EnvironmentUtilities {

    /* renamed from: a, reason: collision with root package name */
    static String f5778a;
    static String b;
    static String c;
    static int d;
    static int e;
    static int f;
    static int g;
    private static h h;

    public static String getAppCachePath() {
        return b;
    }

    public static String getAppSDCardPath() {
        String str = f5778a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return c;
    }

    public static int getDomTmpStgMax() {
        return e;
    }

    public static int getItsTmpStgMax() {
        return f;
    }

    public static int getMapTmpStgMax() {
        return d;
    }

    public static String getSDCardPath() {
        return f5778a;
    }

    public static int getSsgTmpStgMax() {
        return g;
    }

    public static void initAppDirectory(Context context) {
        if (h == null) {
            h a2 = h.a();
            h = a2;
            a2.a(context);
        }
        String str = f5778a;
        if (str != null && str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(f5778a);
            String str2 = File.separator;
            sb.append(str2);
            sb.append("BaiduMapSDKNew");
            sb.append(str2);
            sb.append("cache");
            b = sb.toString();
        } else {
            f5778a = h.b().a();
            b = h.b().c();
        }
        c = h.b().d();
        d = 52428800;
        e = 52428800;
        f = O0xOxO.f34202xXxxox0I;
        g = 52428800;
    }

    public static void setSDCardPath(String str) {
        f5778a = str;
    }
}
