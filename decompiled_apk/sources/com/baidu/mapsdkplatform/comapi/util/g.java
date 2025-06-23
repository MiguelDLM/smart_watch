package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;

/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6207a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    public g(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null && externalFilesDir.exists()) {
                this.b = externalFilesDir.getPath();
            } else {
                this.b = context.getFilesDir().getPath();
            }
        } else if (com.baidu.mapsdkplatform.comapi.b.c()) {
            this.b = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            this.b = context.getFilesDir().getAbsolutePath();
        }
        this.f6207a = false;
        this.c = this.b + File.separator + "BaiduMapSDKNew";
        this.d = context.getCacheDir().getAbsolutePath();
        this.e = "";
        this.f = "";
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.b + File.separator + "BaiduMapSDKNew";
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj != null && g.class.isInstance(obj)) {
            return this.b.equals(((g) obj).b);
        }
        return false;
    }
}
