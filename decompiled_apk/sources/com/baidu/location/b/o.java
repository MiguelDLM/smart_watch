package com.baidu.location.b;

import android.location.Location;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Location f5654a;
    final /* synthetic */ n b;

    public o(n nVar, Location location) {
        this.b = nVar;
        this.f5654a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f5654a);
    }
}
