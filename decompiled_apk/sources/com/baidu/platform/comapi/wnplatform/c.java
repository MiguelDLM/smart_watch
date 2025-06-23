package com.baidu.platform.comapi.wnplatform;

import android.content.Context;
import android.os.Handler;
import com.baidu.ar.baidumap.EglCoreDownloader;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9895a = "c";
    private Context c;
    private EglCoreDownloader d;
    private b f;
    private boolean b = false;
    private boolean e = false;
    private Handler g = new d(this);

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static final c f9896a = new c();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void b();
    }

    public static c a() {
        return a.f9896a;
    }

    public void a(Context context, b bVar) {
        this.f = bVar;
        this.c = context;
        if (context == null || this.b) {
            return;
        }
        if (this.d == null) {
            this.d = EglCoreDownloader.getInstance(context);
        }
        this.d.download(new e(this));
    }
}
