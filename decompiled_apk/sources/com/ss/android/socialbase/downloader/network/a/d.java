package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes13.dex */
public class d implements i {

    /* renamed from: a, reason: collision with root package name */
    protected final Object f26406a;
    private final List<com.ss.android.socialbase.downloader.model.c> b;
    private i c;
    private boolean d;
    private long e;
    private InputStream f;

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        i iVar = this.c;
        if (iVar != null) {
            return iVar.b();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public void d() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.d();
        }
    }

    public void e() throws InterruptedException {
        synchronized (this.f26406a) {
            try {
                if (this.d && this.c == null) {
                    this.f26406a.wait();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        return this.b;
    }

    public boolean g() {
        try {
            i iVar = this.c;
            if (iVar == null) {
                return false;
            }
            if (!a(iVar.b())) {
                return false;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        if (System.currentTimeMillis() - this.e < b.f26403a) {
            return true;
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public InputStream a() throws IOException {
        InputStream inputStream = this.f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        i iVar = this.c;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }
}
