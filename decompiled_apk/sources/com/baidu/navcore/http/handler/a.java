package com.baidu.navcore.http.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class a {
    private static final String d = "a";

    /* renamed from: a, reason: collision with root package name */
    private Handler f6462a;
    private Looper b;
    private boolean c;

    /* renamed from: com.baidu.navcore.http.handler.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC0151a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final a f6463a;

        public HandlerC0151a(a aVar, Looper looper) {
            super(looper);
            this.f6463a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f6463a.a(message);
        }
    }

    public a() {
        if (this.b == null) {
            this.b = Looper.myLooper();
        }
        a(false);
    }

    public abstract void a(int i, byte[] bArr);

    public abstract void a(int i, byte[] bArr, Throwable th);

    public void a(boolean z) {
        g gVar = g.OPEN_SDK;
        if (gVar.d()) {
            gVar.e(d, "handleMessage --> sync = " + z + ", mLooper = " + this.b + ", mHandler = " + this.f6462a);
        }
        if (!z && this.b == null) {
            if (gVar.d()) {
                gVar.e("Current thread has not called Looper.prepare().");
            }
            z = true;
        }
        if (!z && this.f6462a == null) {
            this.f6462a = new HandlerC0151a(this, this.b);
        } else if (z && this.f6462a != null) {
            this.f6462a = null;
        }
        this.c = z;
    }

    public final void b(int i, byte[] bArr) {
        b(a(0, new Object[]{Integer.valueOf(i), bArr}));
    }

    public final void b(int i, byte[] bArr, Throwable th) {
        b(a(1, new Object[]{Integer.valueOf(i), bArr, th}));
    }

    public void b(Message message) {
        g gVar = g.OPEN_SDK;
        if (gVar.d()) {
            gVar.e(d, "sendMessage --> mUseSynchronousMode = " + this.c + ", mHandler = " + this.f6462a + ", msg = " + message);
        }
        if (!this.c && this.f6462a != null) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            Handler handler = this.f6462a;
            if (handler != null) {
                handler.sendMessage(message);
                return;
            } else {
                if (gVar.d()) {
                    gVar.e(d, "sendMessage --> handler should not be null!");
                    return;
                }
                return;
            }
        }
        a(message);
    }

    public void a(Message message) {
        g gVar = g.OPEN_SDK;
        if (gVar.d()) {
            gVar.e(d, "handleMessage --> message = " + message);
        }
        try {
            int i = message.what;
            if (i == 0) {
                Object[] objArr = (Object[]) message.obj;
                if (objArr != null && objArr.length >= 2) {
                    a(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                    return;
                } else {
                    if (gVar.d()) {
                        gVar.e(d, "handleMessage --> SUCCESS_MESSAGE didn't got enough params");
                        return;
                    }
                    return;
                }
            }
            if (i != 1) {
                return;
            }
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2 != null && objArr2.length >= 3) {
                a(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], (Throwable) objArr2[2]);
            } else if (gVar.d()) {
                gVar.e(d, "handleMessage --> FAILURE_MESSAGE didn't got enough params");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Message a(int i, Object obj) {
        return Message.obtain(this.f6462a, i, obj);
    }
}
