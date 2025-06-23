package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.i.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f26401a;
    private final Map<String, c> b;
    private final Map<String, d> c;

    /* renamed from: com.ss.android.socialbase.downloader.network.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C1079a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f26402a = new a();
    }

    public void a(String str, c cVar) {
        synchronized (this.b) {
            this.b.put(str, cVar);
        }
    }

    public d b(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        d remove;
        synchronized (this.c) {
            remove = this.c.remove(str);
        }
        if (remove != null) {
            if (f.a(remove.f(), list)) {
                try {
                    remove.e();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (remove.h() && remove.g()) {
                    return remove;
                }
            }
            try {
                remove.d();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private a() {
        this.b = new HashMap();
        this.c = new LinkedHashMap(3);
        this.f26401a = 3;
    }

    public void a(int i) {
        this.f26401a = i;
    }

    public c a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        c remove;
        synchronized (this.b) {
            remove = this.b.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (f.a(remove.h(), list)) {
            try {
                remove.d();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (remove.f() && remove.e()) {
                return remove;
            }
        }
        try {
            remove.c();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a(String str) {
        c cVar = this.b.get(str);
        if (cVar == null) {
            return false;
        }
        if (cVar.g()) {
            return true;
        }
        return cVar.f() && cVar.e();
    }

    public static a a() {
        return C1079a.f26402a;
    }
}
