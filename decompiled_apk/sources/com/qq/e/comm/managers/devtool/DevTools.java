package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes11.dex */
public class DevTools {

    /* renamed from: a, reason: collision with root package name */
    private String f19444a;

    public String getDemoGameUrl() {
        String str = this.f19444a;
        this.f19444a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f19444a = str;
        }
    }
}
