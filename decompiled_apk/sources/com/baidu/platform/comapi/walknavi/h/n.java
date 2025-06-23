package com.baidu.platform.comapi.walknavi.h;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9812a;

    public n(b bVar) {
        this.f9812a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Message obtain = Message.obtain();
        obtain.what = 1;
        handler = this.f9812a.W;
        if (handler != null) {
            handler2 = this.f9812a.W;
            handler2.dispatchMessage(obtain);
        }
    }
}
