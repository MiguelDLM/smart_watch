package com.baidu.navcore.http;

import com.baidu.mapframework.nirvana.concurrent.ConcurrentCallable;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.concurrent.QueueToken;
import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.DataTaskType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.ScheduleTag;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.g;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes7.dex */
public class f extends com.baidu.navisdk.util.worker.d {
    private Module c;
    private QueueToken d;
    private Map<Integer, WeakReference<LooperTask>> e;

    /* loaded from: classes7.dex */
    public class a extends ConcurrentTask {
        final /* synthetic */ com.baidu.navisdk.util.worker.f d;

        public a(f fVar, com.baidu.navisdk.util.worker.f fVar2) {
            this.d = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.util.worker.f fVar = this.d;
            if (fVar != null) {
                try {
                    fVar.call();
                } catch (Exception e) {
                    LogUtil.e(g.TAG, "quenetask:" + this.d.getTaskName() + " - execute ex. ex=" + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends LooperTask {
        final /* synthetic */ com.baidu.navisdk.util.worker.f f;

        public b(f fVar, com.baidu.navisdk.util.worker.f fVar2) {
            this.f = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.util.worker.f fVar = this.f;
            if (fVar != null) {
                try {
                    fVar.call();
                } catch (Exception e) {
                    LogUtil.e(g.TAG, "mianthreadtask:" + this.f.getTaskName() + " - execute ex. ex=" + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c<K, T> extends ConcurrentCallable<T> {
        private g<K, T> d;

        public c(g<K, T> gVar) {
            this.d = gVar;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            g<K, T> gVar = this.d;
            if (gVar != null) {
                try {
                    return gVar.call();
                } catch (Exception e) {
                    LogUtil.e(g.TAG, "concurrenttask:" + this.d.getTaskName() + " - execute ex. ex=" + e.getMessage());
                    return null;
                }
            }
            return null;
        }
    }

    public f() {
        Module module = Module.NAV_MODULE;
        this.c = module;
        this.d = ConcurrentManager.obtainTaskQueue(module);
        this.e = new ConcurrentHashMap();
    }

    @Override // com.baidu.navisdk.util.worker.d, com.baidu.navisdk.util.worker.h
    public <K, T> Future<?> a(g<K, T> gVar, com.baidu.navisdk.util.worker.e eVar) {
        if (!b(gVar)) {
            return null;
        }
        FutureTask submitTask = ConcurrentManager.submitTask(this.c, new c(gVar), a(eVar));
        if (submitTask != null) {
            this.f9394a.put(gVar, submitTask);
        }
        return submitTask;
    }

    @Override // com.baidu.navisdk.util.worker.d, com.baidu.navisdk.util.worker.h
    public <K, T> void b(com.baidu.navisdk.util.worker.f<K, T> fVar, com.baidu.navisdk.util.worker.e eVar) {
        a aVar = new a(this, fVar);
        aVar.setQueueToken(this.d);
        ConcurrentManager.executeTask(this.c, aVar, a(eVar));
    }

    @Override // com.baidu.navisdk.util.worker.d, com.baidu.navisdk.util.worker.h
    public <K, T> void a(com.baidu.navisdk.util.worker.f<K, T> fVar, com.baidu.navisdk.util.worker.e eVar) {
        if (fVar == null) {
            return;
        }
        b bVar = new b(this, fVar);
        this.e.put(Integer.valueOf(fVar.hashCode()), new WeakReference<>(bVar));
        LooperManager.executeTask(this.c, bVar, a(eVar));
    }

    @Override // com.baidu.navisdk.util.worker.d, com.baidu.navisdk.util.worker.h
    public <K, T> boolean a(g<K, T> gVar, boolean z) {
        boolean a2 = super.a(gVar, z);
        if (gVar != null) {
            LogUtil.e(g.TAG, "cancelTask() taskid=" + gVar.hashCode());
            if (this.e.containsKey(Integer.valueOf(gVar.hashCode()))) {
                WeakReference<LooperTask> weakReference = this.e.get(Integer.valueOf(gVar.hashCode()));
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().cancel();
                    this.e.remove(Integer.valueOf(gVar.hashCode()));
                    LogUtil.e(g.TAG, "cancelTask() cancel ok in base.");
                }
            } else {
                LogUtil.e(g.TAG, "cancelTask() not found in base queue.");
            }
        }
        LogUtil.e(g.TAG, "cancelTask() superRet=" + a2);
        return a2;
    }

    private ScheduleConfig a(com.baidu.navisdk.util.worker.e eVar) {
        DataTaskType forUpdateData;
        ScheduleTag scheduleTag;
        if (eVar == null) {
            return new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
        }
        switch (eVar.f9397a) {
            case 200:
                forUpdateData = DataTaskType.forUpdateData();
                break;
            case 201:
                forUpdateData = DataTaskType.forDownload();
                break;
            case 202:
                forUpdateData = DataTaskType.forStatictics();
                break;
            default:
                forUpdateData = DataTaskType.forUpdateData();
                break;
        }
        if (eVar.b != 1) {
            scheduleTag = ScheduleTag.NULL;
        } else {
            scheduleTag = ScheduleTag.SETUP;
        }
        if (forUpdateData != null && scheduleTag != null) {
            return new ScheduleConfig(forUpdateData, scheduleTag);
        }
        return new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
    }
}
