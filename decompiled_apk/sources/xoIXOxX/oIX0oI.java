package xoIXOxX;

import XO0OX.xxIXOIIO;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import xx0o0O.XO;

@xxIXOIIO(name = "LocksKt")
@XX({"SMAP\nLocks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Locks.kt\nkotlin/concurrent/LocksKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
/* loaded from: classes6.dex */
public final class oIX0oI {
    @XO
    public static final <T> T I0Io(ReentrantReadWriteLock reentrantReadWriteLock, Oox.oIX0oI<? extends T> action) {
        int i;
        IIX0o.x0xO0oo(reentrantReadWriteLock, "<this>");
        IIX0o.x0xO0oo(action, "action");
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
            i = reentrantReadWriteLock.getReadHoldCount();
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            return action.invoke();
        } finally {
            xxX.oxoX(1);
            while (i2 < i) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
            xxX.I0Io(1);
        }
    }

    @XO
    public static final <T> T II0xO0(Lock lock, Oox.oIX0oI<? extends T> action) {
        IIX0o.x0xO0oo(lock, "<this>");
        IIX0o.x0xO0oo(action, "action");
        lock.lock();
        try {
            return action.invoke();
        } finally {
            xxX.oxoX(1);
            lock.unlock();
            xxX.I0Io(1);
        }
    }

    @XO
    public static final <T> T oIX0oI(ReentrantReadWriteLock reentrantReadWriteLock, Oox.oIX0oI<? extends T> action) {
        IIX0o.x0xO0oo(reentrantReadWriteLock, "<this>");
        IIX0o.x0xO0oo(action, "action");
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            return action.invoke();
        } finally {
            xxX.oxoX(1);
            readLock.unlock();
            xxX.I0Io(1);
        }
    }
}
