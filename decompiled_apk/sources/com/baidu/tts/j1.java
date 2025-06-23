package com.baidu.tts;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes8.dex */
public class j1 {

    /* renamed from: a, reason: collision with root package name */
    public m3 f10114a;
    public i1 b;
    public ReadWriteLock c;
    public Lock d;
    public Lock e;

    public j1(m3 m3Var) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.writeLock();
        this.e = this.c.readLock();
        this.f10114a = m3Var;
        this.b = new i1(this.f10114a.b());
    }
}
