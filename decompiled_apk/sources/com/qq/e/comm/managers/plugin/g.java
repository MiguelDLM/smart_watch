package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final File f19452a;
    private final File b;
    private String c;
    private int d;
    private String e;

    public g(File file, File file2) {
        this.f19452a = file;
        this.b = file2;
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public boolean a(File file, File file2, Context context) {
        if (file.equals(this.f19452a) || h.a(this.f19452a, file, context, true)) {
            return file2.equals(this.b) || h.a(this.b, file2, context, false);
        }
        return false;
    }

    public boolean a(Context context, boolean z) {
        int i;
        try {
            if (this.b.exists() && this.f19452a.exists()) {
                String a2 = h.a(this.b);
                this.e = a2;
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                String[] split = this.e.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    try {
                        i = Integer.parseInt(split[0]);
                    } catch (Throwable unused) {
                        i = 0;
                    }
                    if (c.b.f19450a.a(str, this.f19452a)) {
                        this.c = str;
                        this.d = i;
                        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34 || !z) {
                            return true;
                        }
                        if (!this.f19452a.canWrite() && !this.f19452a.canExecute()) {
                            return this.f19452a.canRead();
                        }
                        return this.f19452a.setReadOnly();
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }
}
