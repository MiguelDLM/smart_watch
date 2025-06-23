package com.baidu.location.b;

import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f5638a;

    public f(e eVar) {
        this.f5638a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ExecutorService c = aj.a().c();
        if (c != null) {
            this.f5638a.a(c, com.baidu.location.e.e.d);
        } else {
            this.f5638a.b(com.baidu.location.e.e.d);
        }
    }
}
