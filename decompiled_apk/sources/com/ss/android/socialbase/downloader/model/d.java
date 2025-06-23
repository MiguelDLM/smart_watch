package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;

/* loaded from: classes13.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f26399a;
    public final g b;
    public final int c;
    private long d;
    private long e;

    public d(String str, g gVar) throws IOException {
        this.f26399a = str;
        this.c = gVar.b();
        this.b = gVar;
    }

    public boolean a() {
        return f.c(this.c);
    }

    public boolean b() {
        return f.a(this.c, this.b.a("Accept-Ranges"));
    }

    public String c() {
        return this.b.a("Etag");
    }

    public String d() {
        return this.b.a("Content-Type");
    }

    public String e() {
        return f.b(this.b, "Content-Range");
    }

    public String f() {
        String b = f.b(this.b, "last-modified");
        if (TextUtils.isEmpty(b)) {
            return f.b(this.b, "Last-Modified");
        }
        return b;
    }

    public String g() {
        return f.b(this.b, "Cache-Control");
    }

    public long h() {
        if (this.d <= 0) {
            this.d = f.a(this.b);
        }
        return this.d;
    }

    public boolean i() {
        if (com.ss.android.socialbase.downloader.i.a.a(8)) {
            return f.c(this.b);
        }
        return f.b(h());
    }

    public long j() {
        if (this.e <= 0) {
            if (!i()) {
                String e = e();
                if (!TextUtils.isEmpty(e)) {
                    this.e = f.b(e);
                }
            } else {
                this.e = -1L;
            }
        }
        return this.e;
    }

    public long k() {
        return f.i(g());
    }
}
