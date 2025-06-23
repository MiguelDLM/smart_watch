package com.baidu.platform.comapi.util;

import android.os.Build;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;
import com.baidu.vi.VIContext;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import o0oIxXOx.oO;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static NACommonMemCache f9692a = new NACommonMemCache();

    public static void a() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        jsonBuilder.key("sw").value(SysOSUtil.getInstance().getScreenWidth());
        jsonBuilder.key("sh").value(SysOSUtil.getInstance().getScreenHeight());
        jsonBuilder.putStringValue("ver", "2");
        jsonBuilder.putStringValue("pd", "mapsdk");
        jsonBuilder.putStringValue(oO.f31192XO, "android");
        jsonBuilder.putStringValue("sv", SyncSysInfo.getSoftWareVer());
        jsonBuilder.putStringValue("ov", "Android" + Build.VERSION.SDK_INT);
        jsonBuilder.putStringValue("cuid", SyncSysInfo.getCid());
        jsonBuilder.putStringValue("ch", "mapsdk");
        jsonBuilder.putStringValue("channel", "mapsdk");
        jsonBuilder.putStringValue("mb", SyncSysInfo.getPhoneType());
        jsonBuilder.putStringValue("path", SysOSUtil.getInstance().getExternalFilesDir());
        jsonBuilder.endObject();
        f9692a.b("logstatistics", jsonBuilder.getJson());
    }

    public static void b() {
        d();
    }

    public static NACommonMemCache c() {
        return f9692a;
    }

    private static void d() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        f9692a.a(SyncSysInfo.initPhoneInfo());
        a();
        jsonBuilder.reset();
        jsonBuilder.object();
        jsonBuilder.putStringValue("cuid", SyncSysInfo.getCid());
        jsonBuilder.putStringValue("app", "1");
        jsonBuilder.putStringValue("path", VIContext.getContext().getCacheDir().getAbsolutePath() + "/");
        jsonBuilder.putStringValue(ClientCookie.DOMAIN_ATTR, "");
        jsonBuilder.endObject();
        f9692a.b("longlink", jsonBuilder.getJson());
    }
}
