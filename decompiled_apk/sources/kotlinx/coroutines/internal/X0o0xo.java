package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public final class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static final Method f30277oIX0oI;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        f30277oIX0oI = method;
    }

    public static final boolean I0Io(@OXOo.OOXIXo Executor executor) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        Method method;
        try {
            if (executor instanceof ScheduledThreadPoolExecutor) {
                scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) executor;
            } else {
                scheduledThreadPoolExecutor = null;
            }
            if (scheduledThreadPoolExecutor == null || (method = f30277oIX0oI) == null) {
                return false;
            }
            method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @OXOo.OOXIXo
    public static final <E> Set<E> II0xO0(int i) {
        return Collections.newSetFromMap(new IdentityHashMap(i));
    }

    public static /* synthetic */ void oIX0oI() {
    }

    public static final <T> T oxoX(@OXOo.OOXIXo ReentrantLock reentrantLock, @OXOo.OOXIXo Oox.oIX0oI<? extends T> oix0oi) {
        reentrantLock.lock();
        try {
            return oix0oi.invoke();
        } finally {
            kotlin.jvm.internal.xxX.oxoX(1);
            reentrantLock.unlock();
            kotlin.jvm.internal.xxX.I0Io(1);
        }
    }
}
