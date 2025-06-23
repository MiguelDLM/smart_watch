package com.baidu.navisdk.jni.control;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.navisdk.framework.a;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.h0;
import java.util.List;

/* loaded from: classes7.dex */
public class EnvironmentUtil {
    public static String getAppVersion() {
        return a0.k();
    }

    public static String getCachePath() {
        Context a2 = a.c().a();
        if (a2 == null) {
            return "";
        }
        return a2.getFilesDir().getAbsolutePath() + "/";
    }

    public static String getCuid() {
        return a0.e();
    }

    public static String getImei() {
        return "000000000000000";
    }

    public static int getNetStatus() {
        return getNetStatus(a.c().a());
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getSdcardPath() {
        return h0.a();
    }

    public static String getZid() {
        return b.F();
    }

    public static int getsensortype() {
        int i;
        int i2;
        int i3;
        int i4;
        List<Sensor> sensorList = ((SensorManager) a.c().a().getSystemService("sensor")).getSensorList(-1);
        int size = sensorList.size();
        int i5 = 0;
        if (size > 0) {
            int i6 = 0;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            while (i5 < size) {
                int type = sensorList.get(i5).getType();
                if (type != 9) {
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                                if (type == 4) {
                                    i = 2;
                                }
                            } else {
                                i3 = 8;
                            }
                        } else {
                            i2 = 4;
                        }
                    } else {
                        i6 = 1;
                    }
                } else {
                    i4 = 16;
                }
                i5++;
            }
            i5 = i6;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        return i5 | i | i2 | i3 | i4;
    }

    public static String phonetype() {
        String str = Build.MODEL;
        if (str != null && !TextUtils.isEmpty(str)) {
            return str;
        }
        return "unKnown";
    }

    public static void startSensor() {
    }

    public static void stopSensor() {
    }

    public static int getNetStatus(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return 1;
        }
        int type = activeNetworkInfo.getType();
        if (!activeNetworkInfo.isConnected()) {
            return 1;
        }
        if (type != 0) {
            return type != 1 ? 1 : 2;
        }
        return 3;
    }
}
