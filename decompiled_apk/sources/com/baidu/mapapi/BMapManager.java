package com.baidu.mapapi;

import android.content.Context;

/* loaded from: classes7.dex */
public class BMapManager {
    public static void destroy() {
        com.baidu.mapsdkplatform.comapi.a.a().d();
    }

    public static Context getContext() {
        try {
            return com.baidu.mapsdkplatform.comapi.a.a().e();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void init() {
        try {
            com.baidu.mapsdkplatform.comapi.a.a().b();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
