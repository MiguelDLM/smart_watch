package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f6203a = Executors.newSingleThreadExecutor();
    private static int b = -1;
    private int c;
    private Context d;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f6204a = new c(null);
    }

    public /* synthetic */ c(d dVar) {
        this();
    }

    public boolean c() {
        int i = this.c;
        if (i >= 0 && (i & 1024) == 1024) {
            return true;
        }
        return false;
    }

    public boolean d() {
        int i = this.c;
        if (i >= 0 && (i & 65536) == 65536) {
            return true;
        }
        return false;
    }

    private c() {
    }

    public static c a() {
        return a.f6204a;
    }

    public boolean b() {
        int i = this.c;
        return i >= 0 && (i & 1) == 1;
    }

    public void a(Context context) {
        this.d = context;
    }

    public void a(int i) {
        if (i == -1 && (i = a("ad_key")) == -101) {
            return;
        }
        this.c = i;
        a("ad_key", i);
    }

    private int a(String str) {
        if (this.d == null) {
            return -101;
        }
        if (b == -1) {
            f6203a.execute(new d(this, str));
        }
        return b;
    }

    private void a(String str, int i) {
        if (this.d == null) {
            return;
        }
        b = i;
        f6203a.execute(new e(this, str, i));
    }
}
