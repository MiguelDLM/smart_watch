package com.baidu.tts;

import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes8.dex */
public class y0 {
    public static volatile y0 g;
    public ExecutorService b;
    public b1 c;
    public z0 d = new z0();
    public a e = a.RELEASE;
    public boolean f = false;

    /* renamed from: a, reason: collision with root package name */
    public List<w0> f10199a = a();

    /* loaded from: classes8.dex */
    public enum a {
        DEVELOP,
        RELEASE
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public x0 f10201a;

        public b(x0 x0Var) {
            this.f10201a = x0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<w0> it = y0.this.f10199a.iterator();
            while (it.hasNext()) {
                it.next().a(this.f10201a, null, y0.g);
            }
        }
    }

    public y0() {
        b1 b1Var = new b1();
        this.c = b1Var;
        this.f10199a.add(b1Var);
        this.b = Executors.newSingleThreadExecutor(new a3("LoggerChainPoolThread"));
    }

    public final List<w0> a() {
        List<w0> list = this.f10199a;
        return list == null ? new CopyOnWriteArrayList() : list;
    }

    public void a(int i, String str, String str2) {
        x0 x0Var = new x0();
        x0Var.d = System.currentTimeMillis();
        x0Var.f10189a = i;
        x0Var.b = str;
        x0Var.c = str2;
        int ordinal = this.e.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                return;
            }
            int i2 = x0Var.f10189a;
            if (this.f || Log.isLoggable("TTSLOG", i2)) {
                this.d.a(x0Var);
                return;
            }
            return;
        }
        this.d.a(x0Var);
        try {
            ExecutorService executorService = this.b;
            if (executorService == null || executorService.isShutdown()) {
                return;
            }
            this.b.execute(new b(x0Var));
        } catch (Exception e) {
            Log.e("LoggerChain", "executeWork exception=" + e.toString());
        }
    }
}
