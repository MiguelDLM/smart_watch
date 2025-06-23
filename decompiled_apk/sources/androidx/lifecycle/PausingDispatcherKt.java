package androidx.lifecycle;

import Oox.x0xO0oo;
import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.xII;

/* loaded from: classes.dex */
public final class PausingDispatcherKt {
    @kotlin.OOXIXo(message = "whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    @OXOo.oOoXoXO
    public static final <T> Object whenCreated(@OXOo.OOXIXo LifecycleOwner lifecycleOwner, @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return whenCreated(lifecycleOwner.getLifecycle(), x0xo0oo, i0Io);
    }

    @kotlin.OOXIXo(message = "whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    @OXOo.oOoXoXO
    public static final <T> Object whenResumed(@OXOo.OOXIXo LifecycleOwner lifecycleOwner, @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return whenResumed(lifecycleOwner.getLifecycle(), x0xo0oo, i0Io);
    }

    @kotlin.OOXIXo(message = "whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    @OXOo.oOoXoXO
    public static final <T> Object whenStarted(@OXOo.OOXIXo LifecycleOwner lifecycleOwner, @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return whenStarted(lifecycleOwner.getLifecycle(), x0xo0oo, i0Io);
    }

    @kotlin.OOXIXo(message = "whenStateAtLeast has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStateAtLeast for non-suspending work that needs to run only once when the Lifecycle changes.")
    @OXOo.oOoXoXO
    public static final <T> Object whenStateAtLeast(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo Lifecycle.State state, @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return kotlinx.coroutines.II0XooXoX.II0XooXoX(Xo0.X0o0xo().o00(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, x0xo0oo, null), i0Io);
    }

    @kotlin.OOXIXo(message = "whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    @OXOo.oOoXoXO
    public static final <T> Object whenCreated(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, x0xo0oo, i0Io);
    }

    @kotlin.OOXIXo(message = "whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    @OXOo.oOoXoXO
    public static final <T> Object whenResumed(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, x0xo0oo, i0Io);
    }

    @kotlin.OOXIXo(message = "whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    @OXOo.oOoXoXO
    public static final <T> Object whenStarted(@OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, x0xo0oo, i0Io);
    }
}
