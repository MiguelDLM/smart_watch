package com.baidu.navisdk.util.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes8.dex */
public class n {
    private static final String d = "n";
    private static n e;

    /* renamed from: a, reason: collision with root package name */
    private List<b> f9242a = new ArrayList();
    private HandlerThread b = null;
    private Handler c = null;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                for (int size = n.this.f9242a.size() - 1; size >= 0; size--) {
                    if (size < n.this.f9242a.size() && n.this.f9242a.get(size) != null) {
                        b bVar = (b) n.this.f9242a.get(size);
                        if (bVar.b(message.what)) {
                            try {
                                bVar.a(message);
                            } catch (Exception e) {
                                if (LogUtil.LOGGABLE) {
                                    e.printStackTrace();
                                }
                                LogUtil.printException(n.d, e);
                            }
                        }
                    } else {
                        return;
                    }
                }
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    e2.printStackTrace();
                }
                LogUtil.f(n.d, "ex=" + e2.getMessage());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private Set<Integer> f9244a = new HashSet();

        public abstract void a();

        public final void a(int i) {
            this.f9244a.add(Integer.valueOf(i));
        }

        public abstract void a(Message message);

        public String b() {
            return "default";
        }

        public final boolean b(int i) {
            return this.f9244a.contains(Integer.valueOf(i));
        }
    }

    public n(String str) {
        a(str);
    }

    public static n d() {
        if (e == null) {
            synchronized (n.class) {
                try {
                    if (e == null) {
                        e = new n("CommonHandlerThread");
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public Looper b() {
        HandlerThread handlerThread = this.b;
        if (handlerThread == null) {
            return null;
        }
        return handlerThread.getLooper();
    }

    public Handler a() {
        return this.c;
    }

    public void a(b bVar) {
        if (bVar == null || this.f9242a.contains(bVar)) {
            return;
        }
        bVar.a();
        this.f9242a.add(bVar);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(d, "registerCallback.cbname=" + bVar.b());
        }
    }

    public void b(b bVar) {
        if (bVar == null || !this.f9242a.contains(bVar)) {
            return;
        }
        this.f9242a.remove(bVar);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(d, "unregisterCallback.cbname=" + bVar.b());
        }
    }

    public boolean b(int i) {
        return a(i, 0, 0, null, 0L);
    }

    public void a(int i) {
        Handler handler = this.c;
        if (handler == null || !handler.hasMessages(i)) {
            return;
        }
        this.c.removeMessages(i);
    }

    public boolean a(int i, int i2, int i3, Object obj, long j) {
        Handler handler = this.c;
        if (handler == null) {
            LogUtil.e(d, "warning: sendMessage() handler is null.");
            return false;
        }
        Message obtainMessage = handler.obtainMessage(i);
        obtainMessage.arg1 = i2;
        obtainMessage.arg2 = i3;
        if (obj != null) {
            obtainMessage.obj = obj;
        }
        if (j <= 0) {
            this.c.sendMessage(obtainMessage);
            return true;
        }
        this.c.sendMessageDelayed(obtainMessage, j);
        return true;
    }

    private void a(String str) {
        if (this.b != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread(str);
        this.b = handlerThread;
        handlerThread.start();
        this.c = new a(this.b.getLooper());
    }
}
