package com.baidu.mapsdkplatform.comapi.commonutils;

import android.text.TextUtils;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comapi.util.j;
import com.baidu.platform.comjni.engine.NAEngine;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6155a = true;
    private static boolean b = false;

    /* loaded from: classes7.dex */
    public enum a {
        eMonitorConsole(1),
        eMonitorNative(2),
        eMonitorNet(4);

        private int d;

        a(int i) {
            this.d = i;
        }

        public int a() {
            return this.d;
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.commonutils.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public enum EnumC0140b {
        eNone,
        eMonitorVerbose,
        eMonitorDebug,
        eMonitorInfo,
        eMonitorWarn,
        eMonitorError,
        eMonitorRealTime
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final b f6158a = new b(null);
    }

    /* loaded from: classes7.dex */
    public enum d {
        SDK_MAP,
        Net,
        Engine
    }

    public /* synthetic */ b(com.baidu.mapsdkplatform.comapi.commonutils.c cVar) {
        this();
    }

    public static b a() {
        return c.f6158a;
    }

    private void d() {
        NAEngine.a(new String[]{d.SDK_MAP.name(), d.Engine.name()});
    }

    public void b() {
        boolean isMapLogEnable = OpenLogUtil.isMapLogEnable();
        f6155a = isMapLogEnable;
        if (isMapLogEnable && !b) {
            String mapLogFilePath = OpenLogUtil.getMapLogFilePath();
            if (TextUtils.isEmpty(mapLogFilePath)) {
                mapLogFilePath = SysOSUtil.getInstance().getExternalFilesDir();
            }
            NAEngine.a(false);
            NAEngine.a(mapLogFilePath);
            NAEngine.a(a.eMonitorNative.a());
            NAEngine.b(EnumC0140b.eMonitorError.ordinal());
            d();
            NAEngine.a(true);
            b = true;
        }
    }

    public void c() {
        if (f6155a && b) {
            b = false;
            f6155a = false;
            NAEngine.a(false);
        }
    }

    private b() {
    }

    public void a(String str) {
        a(EnumC0140b.eMonitorRealTime, d.SDK_MAP.name(), str);
    }

    private void a(EnumC0140b enumC0140b, String str, String str2) {
        if (f6155a) {
            j.a().submit(new com.baidu.mapsdkplatform.comapi.commonutils.c(this, enumC0140b, str, str2));
        }
    }
}
