package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.NirvanaTask;
import java.util.concurrent.Callable;

/* loaded from: classes7.dex */
public abstract class ConcurrentCallable<T> extends NirvanaTask implements Callable<T> {
    private QueueToken c = null;

    public QueueToken a() {
        return this.c;
    }

    public void setQueueToken(QueueToken queueToken) {
        this.c = queueToken;
    }
}
