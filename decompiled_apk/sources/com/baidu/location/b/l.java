package com.baidu.location.b;

import com.baidu.location.b.j;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class l extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Timer f5648a;
    final /* synthetic */ j.b b;

    public l(j.b bVar, Timer timer) {
        this.b = bVar;
        this.f5648a = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        j.b bVar = this.b;
        if (!bVar.d) {
            bVar.c();
        }
        this.f5648a.cancel();
        this.f5648a.purge();
    }
}
