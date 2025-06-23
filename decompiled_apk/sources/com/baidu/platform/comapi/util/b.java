package com.baidu.platform.comapi.util;

import com.baidu.platform.comapi.util.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a.C0531a f9690a;
    final /* synthetic */ Object b;
    final /* synthetic */ a c;

    public b(a aVar, a.C0531a c0531a, Object obj) {
        this.c = aVar;
        this.f9690a = c0531a;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.f9690a, this.b);
    }
}
