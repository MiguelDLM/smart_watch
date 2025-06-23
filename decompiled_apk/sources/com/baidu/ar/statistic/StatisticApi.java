package com.baidu.ar.statistic;

import android.content.Context;
import android.os.HandlerThread;
import com.baidu.ar.io;
import com.baidu.ar.ip;
import com.baidu.ar.ix;
import com.baidu.ar.kf;
import com.baidu.ar.kr;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class StatisticApi {
    private static ip zt;
    private static io zu;

    public static io getPerformanceApi() {
        if (zu == null) {
            zu = new ix();
        }
        return zu;
    }

    public static void init(Context context) {
        if (zt == null) {
            try {
                Constructor<?> a2 = kr.a("com.baidu.ar.statistic.StatisticApiImpl", (Class<?>[]) new Class[]{Context.class, HandlerThread.class});
                if (a2 != null) {
                    zt = (ip) kr.a(a2, context, null);
                }
            } catch (Throwable th) {
                zt = null;
                kf.cl("Statistic init fail");
                th.printStackTrace();
            }
        }
        if (zu == null) {
            zu = new ix();
        }
    }

    public static boolean isAllowPerformanceEvent(String str) {
        ip ipVar = zt;
        if (ipVar != null) {
            return ipVar.isAllowPerformanceEvent(str);
        }
        return true;
    }

    public static void onEvent(String str) {
        onEvent(str, "");
    }

    public static void onEventDebounce(String str, long j, String str2) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.onEventDebounce(str, j, str2);
        }
    }

    public static void onEventEnd(String str) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.onEventEnd(str);
        }
    }

    public static void onEventStart(String str) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.onEventStart(str);
        }
    }

    public static void onEventStatus(String str, String str2, boolean z) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.onEventStatus(str, str2, z);
        }
    }

    public static void onPerformance(String str, Map<String, String> map) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.onPerformance(str, map);
        }
    }

    public static void pause() {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.pause();
        }
    }

    public static void release() {
        zu = null;
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.release();
            zt = null;
        }
    }

    public static void resume() {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.resume();
        }
    }

    public static void setPubParam(String str, String str2) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.setPubParam(str, str2);
        }
    }

    public static void setPubParams(Map<String, String> map) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.setPubParams(map);
        }
    }

    public static void onEvent(String str, String str2) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.onEvent(str, str2);
        }
    }

    public static void onEventDebounce(String str, long j, Map<String, String> map) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.onEventDebounce(str, j, map);
        }
    }

    public static void onPerformance(String str, JSONObject jSONObject) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.onPerformance(str, jSONObject);
        }
    }

    public static void onEvent(String str, Map<String, String> map) {
        ip ipVar = zt;
        if (ipVar != null) {
            ipVar.onEvent(str, map);
        }
    }
}
