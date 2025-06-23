package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public class c implements g {
    private static final ArrayList<String> e;

    /* renamed from: a, reason: collision with root package name */
    protected final String f26405a;
    protected final long b;
    protected List<com.ss.android.socialbase.downloader.model.c> c;
    private int g;
    private long h;
    private boolean i;
    private boolean j;
    private g k;
    private Map<String, String> f = null;
    protected final Object d = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        e = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) {
        this.f26405a = str;
        this.c = list;
        this.b = j;
    }

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar = this.k;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.d) {
            try {
                if (this.j && this.f == null) {
                    this.d.wait();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        if (System.currentTimeMillis() - this.h < b.b) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return this.j;
    }

    public List<com.ss.android.socialbase.downloader.model.c> h() {
        return this.c;
    }

    public Map<String, String> i() {
        return this.f;
    }

    public void a() throws Exception {
        if (this.f != null) {
            return;
        }
        try {
            this.j = true;
            this.k = com.ss.android.socialbase.downloader.downloader.c.a(this.f26405a, this.c);
            synchronized (this.d) {
                try {
                    if (this.k != null) {
                        HashMap hashMap = new HashMap();
                        this.f = hashMap;
                        a(this.k, hashMap);
                        this.g = this.k.b();
                        this.h = System.currentTimeMillis();
                        this.i = a(this.g);
                    }
                    this.j = false;
                    this.d.notifyAll();
                } finally {
                }
            }
        } catch (Throwable th) {
            synchronized (this.d) {
                try {
                    if (this.k != null) {
                        HashMap hashMap2 = new HashMap();
                        this.f = hashMap2;
                        a(this.k, hashMap2);
                        this.g = this.k.b();
                        this.h = System.currentTimeMillis();
                        this.i = a(this.g);
                    }
                    this.j = false;
                    this.d.notifyAll();
                    throw th;
                } finally {
                }
            }
        }
    }

    private void a(g gVar, Map<String, String> map) {
        if (gVar == null || map == null) {
            return;
        }
        Iterator<String> it = e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, gVar.a(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        Map<String, String> map = this.f;
        if (map != null) {
            return map.get(str);
        }
        g gVar = this.k;
        if (gVar != null) {
            return gVar.a(str);
        }
        return null;
    }
}
