package com.tencent.bugly.crashreport;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.p;
import com.vtrump.vtble.Oxx0IOOO;

/* loaded from: classes13.dex */
public class BuglyLog {
    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.c) {
            Log.d(str, str2);
        }
        ao.a("D", str, str2);
    }

    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.c) {
            Log.e(str, str2);
        }
        ao.a(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.c) {
            Log.i(str, str2);
        }
        ao.a(Oxx0IOOO.f27277xI, str, str2);
    }

    public static void setCache(int i) {
        ao.a(i);
    }

    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.c) {
            Log.v(str, str2);
        }
        ao.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.c) {
            Log.w(str, str2);
        }
        ao.a("W", str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.c) {
            Log.e(str, str2, th);
        }
        ao.a(ExifInterface.LONGITUDE_EAST, str, th);
    }
}
