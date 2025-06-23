package com.baidu.mapsdkplatform.comapi.map;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.longlink.BNLongLink;
import com.baidu.platform.comjni.engine.NAEngine;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static int f6186a;
    private static Context b = BMapManager.getContext();

    static {
        if (!com.baidu.mapsdkplatform.comapi.b.a()) {
            NativeLoader.getInstance().loadLibrary(com.baidu.mapapi.VersionInfo.getKitName());
        }
        if (com.baidu.mapapi.VersionInfo.getApiVersion().equals(VersionInfo.getApiVersion())) {
            NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
            return;
        }
        throw new BaiduMapSDKException("the version of map is not match with base");
    }

    public static void a() {
        if (f6186a == 0) {
            if (b == null) {
                Context cachedContext = JNIInitializer.getCachedContext();
                b = cachedContext;
                if (cachedContext == null) {
                    Log.e("BDMapSDK", "you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                    return;
                }
            }
            SysOSUtil.updateCuid();
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().b();
            JNIInitializer.attach((Application) b, true, false, false, true);
            JNIInitializer.initEngine();
            JNIInitializer.initEngineResource(new AppResList());
            com.baidu.platform.comapi.util.f.b();
            BNLongLink.initLongLink();
            NAEngine.c();
            NAEngine.startRunningRequest();
            SysUpdateObservable.getInstance().addObserver(new SysUpdateUtil());
            SysUpdateObservable.getInstance().init("");
            com.baidu.platform.comapi.util.f.a();
        }
        f6186a++;
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap init mRef = " + f6186a);
        }
    }

    public static void b() {
        f6186a--;
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap destroy mRef = " + f6186a);
        }
        if (f6186a == 0) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().c();
            JNIInitializer.destroy();
        }
    }

    public static int c() {
        return f6186a;
    }
}
