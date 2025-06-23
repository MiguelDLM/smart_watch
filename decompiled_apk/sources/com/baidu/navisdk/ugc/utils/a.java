package com.baidu.navisdk.ugc.utils;

import android.content.Intent;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class a {
    public static boolean a(int i) {
        return i == 4640;
    }

    public static boolean a(boolean z) {
        return com.baidu.navisdk.ugc.report.data.datarepository.d.o && z && TextUtils.isEmpty(com.baidu.navisdk.framework.b.e());
    }

    public static void a(int i, int i2, Intent intent, com.baidu.navisdk.ugc.listener.a aVar) {
        if (i != 4640 || aVar == null) {
            return;
        }
        if (i2 == -1) {
            if (!TextUtils.isEmpty(com.baidu.navisdk.framework.b.e())) {
                aVar.m();
                return;
            } else {
                aVar.c("登录失败");
                return;
            }
        }
        aVar.c("用户取消登录");
    }
}
