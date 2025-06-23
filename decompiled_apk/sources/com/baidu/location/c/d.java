package com.baidu.location.c;

import java.util.TimerTask;

/* loaded from: classes7.dex */
class d extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f5695a;

    public d(c cVar) {
        this.f5695a = cVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f5695a.c();
    }
}
