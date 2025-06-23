package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f9528a;
    final /* synthetic */ SearchResult b;
    final /* synthetic */ Object c;
    final /* synthetic */ a d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.d = aVar;
        this.f9528a = dVar;
        this.b = searchResult;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9528a != null) {
            this.d.f9526a.lock();
            try {
                this.f9528a.a(this.b, this.c);
            } finally {
                this.d.f9526a.unlock();
            }
        }
    }
}
