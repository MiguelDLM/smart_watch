package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.NirvanaTask;

/* loaded from: classes7.dex */
public abstract class ScheduleTask extends NirvanaTask implements Runnable {
    private long c;

    public ScheduleTask(long j) {
        this.c = j;
    }

    public long getDelay() {
        return this.c;
    }
}
