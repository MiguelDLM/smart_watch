package com.baidu.mapapi;

/* loaded from: classes7.dex */
public class PermissionUtils {

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final PermissionUtils f5753a = new PermissionUtils();
    }

    public static PermissionUtils getInstance() {
        return a.f5753a;
    }

    public boolean isEnglishMapAuthorized() {
        return com.baidu.mapsdkplatform.comapi.util.c.a().d();
    }

    public boolean isIndoorNaviAuthorized() {
        return com.baidu.mapsdkplatform.comapi.util.c.a().b();
    }

    public boolean isWalkARNaviAuthorized() {
        return com.baidu.mapsdkplatform.comapi.util.c.a().c();
    }

    private PermissionUtils() {
    }
}
