package com.baidu.navisdk.util.worker.loop;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class a extends Handler {
    private String mName;

    /* renamed from: com.baidu.navisdk.util.worker.loop.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0511a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Message f9398a;

        public RunnableC0511a(Message message) {
            this.f9398a = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a().a(this.f9398a);
            a.this.onMessage(this.f9398a);
            c.a().c(this.f9398a);
            this.f9398a.recycle();
        }
    }

    public a() {
        super(Looper.getMainLooper());
        this.mName = "CarNavi-DefaultMainLooper";
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
        c.a().a(new RunnableC0511a(obtain));
    }

    public void onMessage(Message message) {
    }

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message message, long j) {
        c.a().b(message);
        return super.sendMessageAtTime(message, j);
    }

    public a(String str) {
        super(Looper.getMainLooper());
        this.mName = null;
        if (TextUtils.isEmpty(str)) {
            this.mName = "CarNavi-DefaultMainLooper";
        } else {
            this.mName = str;
        }
    }
}
