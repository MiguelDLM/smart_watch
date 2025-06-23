package com.baidu.navisdk.debug;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes7.dex */
public class e {
    private static final String d = "e";

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f6787a = null;
    private Handler b = null;
    private List<b> c = new ArrayList();

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                for (int size = e.this.c.size() - 1; size >= 0; size--) {
                    if (size < e.this.c.size() && e.this.c.get(size) != null) {
                        b bVar = (b) e.this.c.get(size);
                        if (bVar.b(message.what)) {
                            bVar.a(message);
                        }
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
                LogUtil.f(e.d, "ex=" + e.getMessage());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private Set<Integer> f6789a = new HashSet();

        public abstract void a();

        public final void a(int i) {
            this.f6789a.add(Integer.valueOf(i));
        }

        public abstract void a(Message message);

        public String b() {
            return "default";
        }

        public final boolean b(int i) {
            return this.f6789a.contains(Integer.valueOf(i));
        }
    }

    public e(String str) {
        a(str);
    }

    public Handler a() {
        return this.b;
    }

    public void b(b bVar) {
        if (bVar == null || !this.c.contains(bVar)) {
            return;
        }
        this.c.remove(bVar);
        if (LogUtil.LOGGABLE) {
            Log.e(d, "unregisterCallback.cbname=" + bVar.b());
        }
    }

    public boolean a(int i, int i2, int i3, Object obj, long j) {
        Handler handler = this.b;
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
            this.b.sendMessage(obtainMessage);
            return true;
        }
        this.b.sendMessageDelayed(obtainMessage, j);
        return true;
    }

    public void a(b bVar) {
        if (bVar == null || this.c.contains(bVar)) {
            return;
        }
        bVar.a();
        this.c.add(bVar);
        if (LogUtil.LOGGABLE) {
            Log.e(d, "registerCallback.cbname=" + bVar.b());
        }
    }

    private void a(String str) {
        if (this.f6787a != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread(str);
        this.f6787a = handlerThread;
        handlerThread.start();
        this.b = new a(this.f6787a.getLooper());
    }
}
