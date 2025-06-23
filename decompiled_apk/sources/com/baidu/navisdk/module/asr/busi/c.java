package com.baidu.navisdk.module.asr.busi;

import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public class c {
    public static int a() {
        GeoPoint e = com.baidu.navisdk.model.a.g().e();
        com.baidu.navisdk.model.datastruct.f a2 = e != null ? com.baidu.navisdk.poisearch.c.a(e, 0) : null;
        if (a2 == null) {
            return com.baidu.navisdk.module.base.b.a();
        }
        return a2.d;
    }

    public static int a(float f) {
        return (int) ((f * JarUtils.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
