package com.baidu.mapframework.nirvana.concurrent;

/* loaded from: classes7.dex */
public class QueueToken {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentQueueRunner f6087a;

    public QueueToken(ConcurrentQueueRunner concurrentQueueRunner) {
        this.f6087a = concurrentQueueRunner;
    }

    public ConcurrentQueueRunner a() {
        return this.f6087a;
    }
}
