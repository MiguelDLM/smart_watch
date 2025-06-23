package com.baidu.navisdk.util.worker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.n;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public abstract class d implements h {

    /* renamed from: a, reason: collision with root package name */
    protected Map<g<?, ?>, Future<?>> f9394a = new ConcurrentHashMap();
    private Handler b = new a(n.d().b());

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            Object obj2;
            Object obj3;
            if (LogUtil.LOGGABLE) {
                LogUtil.e(g.TAG, "handleMessage() what=hashcode=" + message.what);
            }
            int i = message.arg1;
            if (i == 1 && (obj3 = message.obj) != null && (obj3 instanceof b)) {
                b bVar = (b) obj3;
                d.this.a((g) bVar.f9396a, bVar.b);
                return;
            }
            if (i == 2 && (obj2 = message.obj) != null && (obj2 instanceof b)) {
                b bVar2 = (b) obj2;
                d.this.a((f) bVar2.f9396a, bVar2.b);
            } else if (i == 3 && (obj = message.obj) != null && (obj instanceof b)) {
                b bVar3 = (b) obj;
                d.this.b((f) bVar3.f9396a, bVar3.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b<K, T> {

        /* renamed from: a, reason: collision with root package name */
        public g<K, T> f9396a;
        public e b;

        public b(g<K, T> gVar, e eVar) {
            this.f9396a = gVar;
            this.b = eVar;
        }
    }

    @Override // com.baidu.navisdk.util.worker.h
    public abstract <K, T> Future<?> a(g<K, T> gVar, e eVar);

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void a(com.baidu.navisdk.util.worker.b<K, T> bVar, e eVar) {
        a((g) bVar, eVar);
    }

    @Override // com.baidu.navisdk.util.worker.h
    public abstract <K, T> void a(f<K, T> fVar, e eVar);

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void b(f<K, T> fVar, e eVar) {
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void c(f<K, T> fVar, e eVar) {
        a((g) fVar, eVar);
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void a(f<K, T> fVar, e eVar, long j) {
        if (fVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(g.TAG, "submitMainThreadTaskDelay() task is null !!!");
                return;
            }
            return;
        }
        b bVar = new b(fVar, eVar);
        Message obtainMessage = this.b.obtainMessage(fVar.hashCode());
        if (LogUtil.LOGGABLE) {
            LogUtil.e(g.TAG, "submitMainThreadTaskDelay() what=hashcode=" + fVar.hashCode() + " taskName" + fVar.getTaskName());
        }
        obtainMessage.arg1 = 2;
        obtainMessage.obj = bVar;
        this.b.sendMessageDelayed(obtainMessage, j);
    }

    public boolean b(g<?, ?> gVar) {
        if (gVar == null) {
            if (!LogUtil.LOGGABLE) {
                return false;
            }
            LogUtil.e(g.TAG, "checkTask() task is null.");
            return false;
        }
        if (!LogUtil.LOGGABLE) {
            return true;
        }
        LogUtil.e(g.TAG, "checkTask() taskname=" + gVar.getTaskName());
        return true;
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void c(f<K, T> fVar, e eVar, long j) {
        if (fVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(g.TAG, "submitQueneTaskDelay() task is null !!!");
                return;
            }
            return;
        }
        b bVar = new b(fVar, eVar);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(g.TAG, "submitQueneTaskDelay() what=hashcode=" + fVar.hashCode() + " taskName:" + fVar.getTaskName());
        }
        Message obtainMessage = this.b.obtainMessage(fVar.hashCode());
        obtainMessage.arg1 = 3;
        obtainMessage.obj = bVar;
        this.b.sendMessageDelayed(obtainMessage, j);
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void b(f<K, T> fVar, e eVar, long j) {
        if (fVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(g.TAG, "submitNormalTaskDelay() task is null !!!");
                return;
            }
            return;
        }
        b bVar = new b(fVar, eVar);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(g.TAG, "submitNormalTaskDelay() what=hashcode=" + fVar.hashCode());
        }
        Message obtainMessage = this.b.obtainMessage(fVar.hashCode());
        obtainMessage.arg1 = 1;
        obtainMessage.obj = bVar;
        this.b.sendMessageDelayed(obtainMessage, j);
    }

    @Override // com.baidu.navisdk.util.worker.h
    @Deprecated
    public <K, T> Future<?> a(g<K, T> gVar) {
        if (gVar == null || !this.f9394a.containsKey(gVar)) {
            return null;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.printCallStack();
        }
        return this.f9394a.remove(gVar);
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> boolean a(g<K, T> gVar, boolean z) {
        boolean z2 = false;
        if (gVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(g.TAG, "cancelTask() return for the task is null.");
            }
            return false;
        }
        boolean z3 = LogUtil.LOGGABLE;
        if (z3 && z3) {
            LogUtil.e(g.TAG, "cancelTask() task.hashcode=" + gVar.hashCode());
        }
        boolean z4 = true;
        try {
            gVar.isCancelled = true;
            if (this.b.hasMessages(gVar.hashCode())) {
                this.b.removeMessages(gVar.hashCode());
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(g.TAG, "cancelTask() find in messages queue. task.hashcode=" + gVar.hashCode() + " taskName:" + gVar.getTaskName());
                }
            } else {
                z4 = false;
            }
            if (this.f9394a.containsKey(gVar)) {
                boolean cancel = this.f9394a.remove(gVar).cancel(z);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(g.TAG, "cancelTask() find in taskFutures. task.hashcode=" + gVar.hashCode() + " taskName:" + gVar.getTaskName());
                }
                z2 = cancel;
            } else {
                z2 = z4;
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(g.TAG, "cancelTask() taskName=" + gVar.getTaskName() + ", isCancelOK=" + z2);
        }
        return z2;
    }
}
