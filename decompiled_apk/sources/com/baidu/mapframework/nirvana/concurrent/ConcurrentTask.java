package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.NirvanaTask;

/* loaded from: classes7.dex */
public abstract class ConcurrentTask extends NirvanaTask implements Runnable {
    private QueueToken c = null;

    public QueueToken a() {
        return this.c;
    }

    public void setQueueToken(QueueToken queueToken) {
        this.c = queueToken;
    }
}
