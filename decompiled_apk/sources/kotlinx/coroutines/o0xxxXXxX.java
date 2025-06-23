package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.XoX;

/* loaded from: classes6.dex */
public final class o0xxxXXxX extends ExecutorCoroutineDispatcher implements XoX {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Executor f30335Oo;

    public o0xxxXXxX(@OXOo.OOXIXo Executor executor) {
        this.f30335Oo = executor;
        kotlinx.coroutines.internal.X0o0xo.I0Io(IIXOooo());
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @OXOo.OOXIXo
    public Executor IIXOooo() {
        return this.f30335Oo;
    }

    @Override // kotlinx.coroutines.XoX
    public void OOXIXo(long j, @OXOo.OOXIXo oO<? super kotlin.oXIO0o0XI> oOVar) {
        ScheduledExecutorService scheduledExecutorService;
        Executor IIXOooo2 = IIXOooo();
        ScheduledFuture<?> scheduledFuture = null;
        if (IIXOooo2 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) IIXOooo2;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = o00(scheduledExecutorService, new Ix00oIoI(this, oOVar), oOVar.getContext(), j);
        }
        if (scheduledFuture != null) {
            IIX0.xoXoI(oOVar, scheduledFuture);
        } else {
            o0.f30326IIXOooo.OOXIXo(j, oOVar);
        }
    }

    @Override // kotlinx.coroutines.XoX
    @OXOo.OOXIXo
    public I0oOIX Oxx0xo(long j, @OXOo.OOXIXo Runnable runnable, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        ScheduledExecutorService scheduledExecutorService;
        Executor IIXOooo2 = IIXOooo();
        ScheduledFuture<?> scheduledFuture = null;
        if (IIXOooo2 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) IIXOooo2;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = o00(scheduledExecutorService, runnable, coroutineContext, j);
        }
        if (scheduledFuture != null) {
            return new O0Xx(scheduledFuture);
        }
        return o0.f30326IIXOooo.Oxx0xo(j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.XoX
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @OXOo.oOoXoXO
    public Object OxxIIOOXO(long j, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        return XoX.oIX0oI.oIX0oI(this, j, i0Io);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ExecutorService executorService;
        Executor IIXOooo2 = IIXOooo();
        if (IIXOooo2 instanceof ExecutorService) {
            executorService = (ExecutorService) IIXOooo2;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        Runnable runnable2;
        try {
            Executor IIXOooo2 = IIXOooo();
            II0xO0 II0xO02 = I0Io.II0xO0();
            if (II0xO02 != null) {
                runnable2 = II0xO02.xxIXOIIO(runnable);
                if (runnable2 == null) {
                }
                IIXOooo2.execute(runnable2);
            }
            runnable2 = runnable;
            IIXOooo2.execute(runnable2);
        } catch (RejectedExecutionException e) {
            II0xO0 II0xO03 = I0Io.II0xO0();
            if (II0xO03 != null) {
                II0xO03.XO();
            }
            xoXoI(coroutineContext, e);
            Xo0.I0Io().dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if ((obj instanceof o0xxxXXxX) && ((o0xxxXXxX) obj).IIXOooo() == IIXOooo()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(IIXOooo());
    }

    public final ScheduledFuture<?> o00(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j) {
        try {
            return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            xoXoI(coroutineContext, e);
            return null;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public String toString() {
        return IIXOooo().toString();
    }

    public final void xoXoI(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        IIX0.XO(coroutineContext, XX0xXo.oIX0oI("The task was rejected", rejectedExecutionException));
    }
}
