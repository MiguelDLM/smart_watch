package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.vi.VIContext;
import java.io.File;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f9689a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public void a(Context context) {
        this.f9689a = context.getFilesDir().getAbsolutePath();
        String absolutePath = context.getCacheDir().getAbsolutePath();
        this.d = absolutePath;
        this.e = absolutePath;
        this.b = Environment.getExternalStorageDirectory().getPath();
        this.c = Environment.getExternalStorageDirectory().getPath();
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            this.f = externalFilesDir.getAbsolutePath();
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            this.g = externalCacheDir.getAbsolutePath();
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.b)) {
            a(VIContext.getContext());
        }
        return this.b;
    }

    public String c() {
        if (TextUtils.isEmpty(this.c)) {
            a(VIContext.getContext());
        }
        return this.c;
    }

    public String d() {
        if (TextUtils.isEmpty(this.d)) {
            a(VIContext.getContext());
        }
        return this.d;
    }

    public String e() {
        if (TextUtils.isEmpty(this.f)) {
            a(VIContext.getContext());
        }
        return this.f;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f9689a)) {
            a(VIContext.getContext());
        }
        return this.f9689a;
    }
}
