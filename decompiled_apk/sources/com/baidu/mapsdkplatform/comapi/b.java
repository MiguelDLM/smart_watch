package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.CommonInfo;
import com.baidu.mapapi.ISDKInitializerListener;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.i;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.io.File;
import java.io.IOException;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6143a = false;
    private static CommonInfo b = null;
    private static boolean c = false;

    public static void a(Context context, boolean z, String str, String str2, String str3, ISDKInitializerListener iSDKInitializerListener) {
        if (f6143a) {
            return;
        }
        if (context != null) {
            if (context instanceof Application) {
                NativeLoader.setContext(context);
                NativeLoader.a(z, str);
                JNIInitializer.setContext((Application) context);
                SysOSUtil.getInstance().init(new com.baidu.platform.comapi.util.a.b(), new com.baidu.platform.comapi.util.a.a());
                if (a(str2)) {
                    EnvironmentUtilities.setSDCardPath(str2);
                }
                EnvironmentUtilities.initAppDirectory(context);
                a.a().a(context);
                a.a().c();
                if (OpenLogUtil.isNativeLogAnalysisEnable()) {
                    com.baidu.mapsdkplatform.comapi.b.a.c.a().a(context);
                }
                f6143a = true;
                if (iSDKInitializerListener != null) {
                    iSDKInitializerListener.initializerFinish();
                    return;
                }
                return;
            }
            throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
        }
        throw new IllegalArgumentException("BDMapSDKException: context can not be null");
    }

    public static CommonInfo b() {
        return b;
    }

    public static boolean c() {
        return c;
    }

    public static void d() {
        i.b(true);
    }

    public static void e() {
        i.b(false);
    }

    public static boolean a() {
        return f6143a;
    }

    public static void a(CommonInfo commonInfo) {
        b = commonInfo;
    }

    public static void a(Context context, boolean z) {
        if (context != null) {
            if (context instanceof Application) {
                c = z;
                PermissionCheck.setPrivacyMode(z);
                i.a(z);
                LBSAuthManager.getInstance(context).setPrivacyMode(z);
                return;
            }
            throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
        }
        throw new IllegalArgumentException("BDMapSDKException: context can not be null");
    }

    private static boolean a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            File file = new File(str + "/check.0");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            if (!file.exists()) {
                return true;
            }
            file.delete();
            return true;
        } catch (IOException e) {
            Log.e("SDKInitializer", "SDCard cache path invalid", e);
            throw new IllegalArgumentException("BDMapSDKException: Provided sdcard cache path invalid can not used.");
        }
    }
}
