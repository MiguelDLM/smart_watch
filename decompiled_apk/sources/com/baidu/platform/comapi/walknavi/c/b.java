package com.baidu.platform.comapi.walknavi.c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.platform.comjni.bikenavi.JNIEngineManager;
import com.baidu.platform.comjni.jninative.EngineCommonConfig;

/* loaded from: classes8.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a, reason: collision with root package name */
    private JNIEngineManager f9705a = null;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private com.baidu.platform.comapi.walknavi.c.a e = null;
    private int f = 0;
    private Handler g = new c(this);

    /* loaded from: classes8.dex */
    public class a extends Thread {
        private EngineCommonConfig b;
        private long c;

        public a(long j, EngineCommonConfig engineCommonConfig) {
            this.c = j;
            this.b = engineCommonConfig;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long[] jArr = {0};
            int initBaseManager = b.this.f9705a.initBaseManager(this.b, this.c, jArr);
            Log.d("ret====", "ret：" + initBaseManager);
            if (initBaseManager == 0) {
                b.this.b = jArr[0];
                Message.obtain(b.this.g, 16).sendToTarget();
            } else {
                Message.obtain(b.this.g, 1).sendToTarget();
            }
        }
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0533b extends Thread {
        private Context b;

        public C0533b(Context context) {
            this.b = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (com.baidu.platform.comapi.wnplatform.p.a.a.a(this.b)) {
                Message.obtain(b.this.g, 32).sendToTarget();
                return;
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("InitResourceThread  error");
            Log.d("InitResourceThread", "InitResourceThread  error");
            Message.obtain(b.this.g, 1).sendToTarget();
        }
    }

    private synchronized void e() {
        JNIEngineManager jNIEngineManager = this.f9705a;
        if (jNIEngineManager != null) {
            jNIEngineManager.uninitBaseManager(this.b);
            this.c = 0L;
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public synchronized void release() {
        e();
        this.f9705a = null;
        this.c = 0L;
        this.d = 0L;
        this.f = 0;
        this.b = 0L;
        this.e = null;
    }

    public void b() {
        JNIEngineManager jNIEngineManager = this.f9705a;
        if (jNIEngineManager != null) {
            jNIEngineManager.unInitBaseAr(this.b);
        }
    }

    public long c() {
        if (this.c == 0) {
            this.c = a(0);
        }
        return this.c;
    }

    public long d() {
        if (this.d == 0) {
            this.d = a(1);
        }
        return this.d;
    }

    public int a() {
        return this.f;
    }

    public void a(Context context, long j, com.baidu.platform.comapi.walknavi.c.a aVar) {
        this.e = aVar;
        if (this.f == 48) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        EngineCommonConfig engineCommonConfig = new EngineCommonConfig();
        int min = Math.min(com.baidu.platform.comapi.wnplatform.p.b.b.a().b(), 800);
        engineCommonConfig.mStreetPicWidth = min;
        engineCommonConfig.mStreetPicHeight = (min * 3) / 5;
        engineCommonConfig.mStreetPicQuality = 80;
        engineCommonConfig.mNoExistSensor = !com.baidu.platform.comapi.walknavi.b.a().f();
        this.f9705a = new JNIEngineManager();
        new a(j, engineCommonConfig).start();
        new C0533b(context).start();
    }

    public boolean a(long j) {
        return this.f9705a.initBaseAr(this.b, j) == 0;
    }

    private long a(int i) {
        JNIEngineManager jNIEngineManager = this.f9705a;
        if (jNIEngineManager != null) {
            long j = this.b;
            if (j != 0) {
                long[] jArr = {0};
                try {
                    jNIEngineManager.getSubSysHandle(j, i, jArr);
                } catch (Exception e) {
                    com.baidu.platform.comapi.wnplatform.d.a.b(e.getMessage());
                }
                return jArr[0];
            }
        }
        return 0L;
    }
}
