package com.baidu.navisdk.util.common;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private Handler f9248a;
    private b b;
    private int c;
    private long d;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (p0.b(p0.this) > 0 && p0.this.b != null) {
                p0.this.b.onTick(p0.this.c);
            }
            if (p0.this.c != 0 && !p0.this.f9248a.hasMessages(0)) {
                p0.this.f9248a.sendEmptyMessageDelayed(0, p0.this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onTick(int i);
    }

    public p0() {
        this("UT");
    }

    public static /* synthetic */ int b(p0 p0Var) {
        int i = p0Var.c;
        p0Var.c = i - 1;
        return i;
    }

    public p0(String str) {
        this.d = 1000L;
        this.f9248a = new a(TextUtils.isEmpty(str) ? "UT" : str);
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public void b() {
        this.b = null;
    }

    public void a(long j) {
        this.d = Math.max(1000L, j);
    }

    public void a(int i) {
        a();
        this.c = i;
        Handler handler = this.f9248a;
        if (handler == null) {
            LogUtil.e("TimerUtil", "handler is null");
        } else {
            if (handler.hasMessages(0)) {
                return;
            }
            this.f9248a.sendEmptyMessageDelayed(0, this.d);
        }
    }

    public void a() {
        this.f9248a.removeMessages(0);
        this.f9248a.removeCallbacks(null);
    }
}
