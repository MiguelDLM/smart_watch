package com.baidu.navisdk.util.common;

import XXO0.oIX0oI;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.tenmeter.smlibrary.utils.FileUtils;
import com.vtrump.vtble.Oxx0IOOO;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/* loaded from: classes8.dex */
public enum g {
    COMMON,
    PRO_NAV,
    LIGHT,
    MOSS,
    CRUISE,
    ROUTE_RESULT,
    VOICE_PAGE,
    LOCATION_SHARE,
    FUTURE_TRIP,
    HUD,
    TTS,
    GPS,
    VDR,
    ASR,
    UGC,
    TRAJECTORY,
    ROUTE_GUIDE,
    ROUTE_PLAN,
    MAP,
    POWER_SAVE_MODE,
    SEARCH,
    LIMIT_FRAME,
    DIY_SPEAK,
    STATISTICS,
    AB_TEST,
    CAR_PLATE,
    NAV_RESULT,
    EYE_SPY,
    INIT,
    F_BASE,
    WORKER_CENTER,
    B4NAV,
    TANGRAM,
    CAR_HOME,
    OPEN_SDK,
    OPEN_API,
    COMMON_UI,
    BRULE,
    INDOOR_PARK,
    ROAD_TRIP,
    PAGE,
    APM,
    HEAT_MONITOR,
    FILE_DOWNLOAD,
    WEB_CORE,
    IMLog,
    BUSINESS_QUEST,
    TRUCK_PROFESSIONAL,
    DYNA_DATA,
    DEST_RECOMMEND,
    ACE;


    /* renamed from: a, reason: collision with root package name */
    private boolean f9227a = false;
    private static final SimpleDateFormat a0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    public static boolean b0 = false;
    public static boolean c0 = false;
    private static boolean d0 = false;
    private static boolean e0 = false;
    private static boolean f0 = false;

    g() {
    }

    private String a(int i) {
        switch (i) {
            case 1:
                return "C";
            case 2:
                return ExifInterface.LONGITUDE_EAST;
            case 3:
                return "W";
            case 4:
                return Oxx0IOOO.f27277xI;
            case 5:
                return "D";
            case 6:
                return "F";
            default:
                return "";
        }
    }

    public void b(String str, String str2) {
    }

    public boolean c() {
        return d0 && this.f9227a;
    }

    public boolean d() {
        return f0 && this.f9227a;
    }

    public boolean e() {
        return e0 && this.f9227a;
    }

    public void f() {
        f("");
    }

    public void g(String str) {
        g(null, str);
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return false;
    }

    public void c(String str) {
        c(null, str);
    }

    public void d(String str) {
        d(null, str);
    }

    public void e(String str) {
        e(null, str);
    }

    public void f(String str) {
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            th = new Throwable();
        } else {
            th = new Throwable(str);
        }
        a(th);
    }

    public void g(String str, String str2) {
        if (e0 && this.f9227a) {
            a(str, str2, 3);
        }
    }

    public void a(boolean z) {
        this.f9227a = z;
    }

    public void b(String str) {
        b(null, str);
    }

    public void c(String str, String str2) {
        if (d0 && this.f9227a) {
            a(str, str2, 2);
        }
    }

    public void d(String str, String str2) {
        a(str, str2, 6);
    }

    public void e(String str, String str2) {
        if (f0 && this.f9227a) {
            a(str, str2, 4);
        }
    }

    public static void b(boolean z) {
        b0 = z;
        b(0);
        a(0L);
    }

    public void a(String str) {
        a((String) null, str);
    }

    public void a(String str, String str2) {
        a(str, str2, 1);
    }

    private void a(String str, String str2, int i) {
        if (b0) {
            StringBuilder sb = new StringBuilder();
            String str3 = " ";
            if (str != null) {
                str3 = str + " ";
            }
            sb.append(str3);
            sb.append(str2);
            String sb2 = sb.toString();
            switch (i) {
                case 1:
                case 4:
                    Log.i(name(), sb2);
                    break;
                case 2:
                case 6:
                    Log.e(name(), sb2);
                    break;
                case 3:
                    Log.w(name(), sb2);
                    break;
                case 5:
                    Log.d(name(), sb2);
                    break;
            }
            SDKDebugFileUtil.get(SDKDebugFileUtil.NORMAL_ALL_LOG).asyncAddV2(a(name(), str, str2, i));
        }
        if (!b0 || i == 1 || i == 6) {
            com.baidu.navisdk.debug.b.k().a(this, i, a(name(), str, i, str2));
        }
    }

    public void f(String str, String str2) {
        if (c0) {
            String a2 = a(name(), str, str2, 4);
            Log.e("BaiduNavi", a2);
            SDKDebugFileUtil.get(SDKDebugFileUtil.NORMAL_ALL_LOG).asyncAdd(a2);
        }
    }

    public static void b(int i) {
        boolean z = b0;
        d0 = z || (i & 1) > 0;
        e0 = z || (i & 16) > 0;
        f0 = z || (i & 256) > 0;
    }

    public void a(String str, Throwable th) {
        c("printException", "start exception");
        c(str, th.toString());
        a(th);
    }

    public void a(String str, Throwable th, boolean z) {
        c("printException", "start exception");
        c(str, th.toString());
        a(th);
    }

    private String a(String str, String str2, String str3, int i) {
        return a0.format(new Date()) + " " + Process.myPid() + " " + Process.myTid() + "[" + a(i) + "][" + str + "][" + str2 + "]" + str3;
    }

    private String a(String str, String str2, int i, String str3) {
        if (str2 != null) {
            str = str2;
        }
        return Process.myTid() + " " + a(i) + " " + str + " " + str3;
    }

    private void a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        if (stackTrace != null) {
            sb.append("printCallStack --> ");
            sb.append(th.getMessage());
            sb.append("\n");
            sb.append("----------start----------");
            sb.append("\n");
            for (int i = 0; i < stackTrace.length; i++) {
                sb.append("        at ");
                sb.append(stackTrace[i].getClassName());
                sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                sb.append(stackTrace[i].getMethodName());
                sb.append(oIX0oI.I0Io.f4096II0xO0);
                sb.append(stackTrace[i].getFileName());
                sb.append(":");
                sb.append(stackTrace[i].getLineNumber());
                sb.append(oIX0oI.I0Io.f4095I0Io);
                sb.append("\n");
            }
            sb.append("--------end---------");
        }
        c("printCallStack", sb.toString());
    }

    public static void a(long j) {
        g[] values = values();
        int length = values.length;
        for (int i = 0; i < length; i++) {
            values[i].a(((1 << i) & j) > 0 || b0);
        }
    }

    public <T> void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable Collection<T> collection) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("----------------------------------------------------------------------------");
        sb.append(str2);
        sb.append("----------------------------------------------------------------------------");
        sb.append("\n");
        if (collection == null) {
            sb.append(str3);
            sb.append(" is null!!!");
            sb.append("\n");
            sb.append("----------------------------------------------------------------------------");
            sb.append(str2);
            sb.append("----------------------------------------------------------------------------");
            sb.append("\n");
            e(str, sb.toString());
            return;
        }
        if (collection.isEmpty()) {
            sb.append(str3);
            sb.append(" is empty!!!");
            sb.append("\n");
            sb.append("----------------------------------------------------------------------------");
            sb.append(str2);
            sb.append("----------------------------------------------------------------------------");
            sb.append("\n");
            e(str, sb.toString());
            return;
        }
        sb.append(str3);
        sb.append(" size is ");
        sb.append(collection.size());
        sb.append("\n");
        sb.append(str3);
        sb.append(" is ⬇⬇⬇⬇⬇⬇⬇⬇⬇\n");
        int i = 0;
        for (T t : collection) {
            sb.append("        --> ");
            sb.append(str3);
            sb.append(": 第");
            sb.append(i);
            sb.append("个: ");
            sb.append(t);
            sb.append("\n");
            i++;
        }
        sb.append("\n");
        sb.append("----------------------------------------------------------------------------");
        sb.append("end");
        sb.append("----------------------------------------------------------------------------");
        sb.append("\n");
        e(str, sb.toString());
    }

    public <K, V> void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable Map<K, V> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("----------------------------------------------------------------------------");
        sb.append(str2);
        sb.append("----------------------------------------------------------------------------");
        sb.append("\n");
        if (map == null) {
            sb.append(str3);
            sb.append(" is null!!!");
            sb.append("\n");
            sb.append("----------------------------------------------------------------------------");
            sb.append(str2);
            sb.append("----------------------------------------------------------------------------");
            sb.append("\n");
            e(str, sb.toString());
            return;
        }
        if (map.isEmpty()) {
            sb.append(str3);
            sb.append(" is empty!!!");
            sb.append("\n");
            sb.append("----------------------------------------------------------------------------");
            sb.append(str2);
            sb.append("----------------------------------------------------------------------------");
            sb.append("\n");
            e(str, sb.toString());
            return;
        }
        sb.append(str3);
        sb.append(" size is ");
        sb.append(map.size());
        sb.append("\n");
        sb.append(str3);
        sb.append(" is ⬇⬇⬇⬇⬇⬇⬇⬇⬇\n");
        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append("        --> ");
            sb.append(str3);
            sb.append("key = ");
            sb.append(entry.getKey());
            sb.append(", value = ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("----------------------------------------------------------------------------");
        sb.append("end");
        sb.append("----------------------------------------------------------------------------");
        sb.append("\n");
        e(str, sb.toString());
    }
}
