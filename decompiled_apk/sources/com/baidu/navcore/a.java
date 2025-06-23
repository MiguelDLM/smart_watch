package com.baidu.navcore;

import android.content.Context;
import com.baidu.lbsapi.auth.LBSAuthManager;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f6452a;

    public static a d() {
        if (f6452a == null) {
            f6452a = new a();
        }
        return f6452a;
    }

    public String a() {
        return "";
    }

    public Context b() {
        return com.baidu.navisdk.framework.a.c().a();
    }

    public String c() {
        return LBSAuthManager.getInstance(com.baidu.navisdk.framework.a.c().a()).getCUID();
    }
}
