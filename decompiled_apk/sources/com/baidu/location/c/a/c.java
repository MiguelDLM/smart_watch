package com.baidu.location.c.a;

import com.baidu.location.c.a.a;
import com.baidu.location.c.k;

/* loaded from: classes7.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a.d f5687a;

    public c(a.d dVar) {
        this.f5687a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                k.h().a("cell received cellinfo change");
            }
            a.this.f();
        } catch (Exception e) {
            if (com.baidu.location.c.b.a.c) {
                e.printStackTrace();
            }
        }
    }
}
