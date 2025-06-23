package com.baidu.platform.comapi.util;

import com.baidu.vi.VIContext;

/* loaded from: classes8.dex */
public class SysOSUtil {
    private static SysOSUtil g = new SysOSUtil();

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.platform.comapi.util.a.b f9685a = null;
    private com.baidu.platform.comapi.util.a.a b = null;
    private boolean c = false;
    private String d = "";
    private String e = "";
    private String f = "";

    private SysOSUtil() {
    }

    public static SysOSUtil getInstance() {
        return g;
    }

    public String getCompatibleSdcardPath() {
        com.baidu.platform.comapi.util.a.b bVar = this.f9685a;
        if (bVar != null) {
            return bVar.c();
        }
        return "";
    }

    public float getDensity() {
        com.baidu.platform.comapi.util.a.a aVar = this.b;
        if (aVar != null) {
            return aVar.c();
        }
        return 1.0f;
    }

    public int getDensityDPI() {
        com.baidu.platform.comapi.util.a.a aVar = this.b;
        if (aVar != null) {
            return aVar.d();
        }
        return 1;
    }

    public String getExternalFilesDir() {
        com.baidu.platform.comapi.util.a.b bVar = this.f9685a;
        if (bVar != null) {
            return bVar.e();
        }
        return "";
    }

    public String getGLRenderer() {
        return this.f;
    }

    public String getGLVersion() {
        return this.e;
    }

    public String getNetType() {
        return this.d;
    }

    public String getOutputCache() {
        com.baidu.platform.comapi.util.a.b bVar = this.f9685a;
        if (bVar != null) {
            return bVar.d();
        }
        return "";
    }

    public String getOutputDirPath() {
        com.baidu.platform.comapi.util.a.b bVar = this.f9685a;
        if (bVar != null) {
            return bVar.a();
        }
        return "";
    }

    public int getScreenHeight() {
        com.baidu.platform.comapi.util.a.a aVar = this.b;
        if (aVar != null) {
            return aVar.b();
        }
        return 0;
    }

    public int getScreenWidth() {
        com.baidu.platform.comapi.util.a.a aVar = this.b;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public String getSdcardPath() {
        com.baidu.platform.comapi.util.a.b bVar = this.f9685a;
        if (bVar != null) {
            return bVar.b();
        }
        return "";
    }

    public void init(com.baidu.platform.comapi.util.a.b bVar, com.baidu.platform.comapi.util.a.a aVar) {
        if (!this.c) {
            this.f9685a = bVar;
            this.b = aVar;
            if (bVar == null) {
                this.f9685a = new com.baidu.platform.comapi.util.a.b();
            }
            if (this.b == null) {
                this.b = new com.baidu.platform.comapi.util.a.a();
            }
            this.f9685a.a(VIContext.getContext());
            this.b.a(VIContext.getContext());
            NetworkUtil.registerNetwork(VIContext.getContext());
            this.c = true;
        }
    }

    public void setGLInfo(String str, String str2) {
        if (!this.f.equals(str2) || !this.e.equals(str)) {
            this.e = str;
            this.f = str2;
        }
    }

    public void updateNetType(String str) {
        this.d = str;
    }
}
