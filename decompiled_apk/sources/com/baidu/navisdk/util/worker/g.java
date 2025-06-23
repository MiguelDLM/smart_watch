package com.baidu.navisdk.util.worker;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public abstract class g<K, T> implements Callable<T> {
    public static final String TAG = "BNWorkerCenter";
    protected K inData;
    protected K[] inDatas;
    volatile boolean isCancelled;
    private String taskName;

    public g(String str, K k) {
        this.taskName = "CarNavi-poly";
        this.inData = null;
        this.inDatas = null;
        this.isCancelled = false;
        if (str != null) {
            this.taskName = "CarNavi-" + str;
        }
        this.inData = k;
    }

    @Override // java.util.concurrent.Callable
    public final T call() throws Exception {
        return executeWrapper();
    }

    public abstract T execute();

    public final T executeWrapper() {
        long j;
        boolean z;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.WORKER_CENTER;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("start task execute. task=");
            sb.append(getTaskName());
            sb.append(",isMainThread:");
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append(",thread id:");
            sb.append(Thread.currentThread().getId());
            gVar.e(sb.toString());
            j = System.currentTimeMillis();
        } else {
            j = 0;
        }
        T t = null;
        try {
            if (!isCancelled()) {
                t = execute();
                Future<?> a2 = c.a().a(this);
                if (a2 == null || (!isCancelled() && !a2.isCancelled())) {
                    if (a2 != null) {
                        notifyResult(t);
                    } else if (Looper.getMainLooper() == Looper.myLooper()) {
                        if (gVar.d()) {
                            gVar.e("task is main thread task=" + getTaskName());
                        }
                    } else if (gVar.d()) {
                        gVar.e("task not found. task=" + getTaskName());
                    }
                }
                if (gVar.d()) {
                    gVar.e("task has been cancelled. task=" + getTaskName());
                }
            } else {
                c.a().a(this);
                if (gVar.d()) {
                    gVar.e("not execute for the task has been cancelled. task=" + getTaskName());
                }
            }
        } catch (Exception e) {
            c.a().a(this);
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar2.c()) {
                gVar2.a("task execute exception. ex=", e);
            }
        }
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.WORKER_CENTER;
        if (gVar3.d()) {
            gVar3.e("end task execute. task=" + getTaskName() + ", executeTime=" + (System.currentTimeMillis() - j));
        }
        return t;
    }

    public K getInData() {
        return this.inData;
    }

    public K[] getInDatas() {
        return this.inDatas;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public abstract void notifyResult(T t);

    public g(String str, K[] kArr) {
        this.taskName = "CarNavi-poly";
        this.inData = null;
        this.inDatas = null;
        this.isCancelled = false;
        if (str != null) {
            this.taskName = "CarNavi-" + str;
        }
        this.inDatas = kArr;
    }
}
