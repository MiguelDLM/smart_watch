package com.baidu.navisdk.util.worker.loop;

import android.os.Looper;
import android.os.Message;

/* loaded from: classes8.dex */
public abstract class b extends com.baidu.navisdk.comapi.base.d {

    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Message f9399a;

        public a(Message message) {
            this.f9399a = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a().a(this.f9399a);
            b.this.onMessage(this.f9399a);
            c.a().c(this.f9399a);
            this.f9399a.recycle();
        }
    }

    public b() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.copyFrom(message);
        c.a().a(new a(obtain));
    }

    public abstract void onMessage(Message message);

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message message, long j) {
        c.a().b(message);
        return super.sendMessageAtTime(message, j);
    }

    public b(String str) {
        super(Looper.getMainLooper());
    }
}
