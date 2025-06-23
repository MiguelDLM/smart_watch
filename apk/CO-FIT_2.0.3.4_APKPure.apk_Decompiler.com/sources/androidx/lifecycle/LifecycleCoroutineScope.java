package androidx.lifecycle;

import OXOo.OOXIXo;
import Oox.x0xO0oo;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.xII;
import kotlinx.coroutines.xoIox;

public abstract class LifecycleCoroutineScope implements xII {
    @OOXIXo
    public abstract Lifecycle getLifecycle$lifecycle_common();

    @kotlin.OOXIXo(message = "launchWhenCreated is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.CREATED.")
    @OOXIXo
    public final oXIO0o0XI launchWhenCreated(@OOXIXo x0xO0oo<? super xII, ? super I0Io<? super kotlin.oXIO0o0XI>, ? extends Object> x0xo0oo) {
        IIX0o.x0xO0oo(x0xo0oo, "block");
        return xoIox.XO(this, (CoroutineContext) null, (CoroutineStart) null, new LifecycleCoroutineScope$launchWhenCreated$1(this, x0xo0oo, (I0Io<? super LifecycleCoroutineScope$launchWhenCreated$1>) null), 3, (Object) null);
    }

    @kotlin.OOXIXo(message = "launchWhenResumed is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.RESUMED.")
    @OOXIXo
    public final oXIO0o0XI launchWhenResumed(@OOXIXo x0xO0oo<? super xII, ? super I0Io<? super kotlin.oXIO0o0XI>, ? extends Object> x0xo0oo) {
        IIX0o.x0xO0oo(x0xo0oo, "block");
        return xoIox.XO(this, (CoroutineContext) null, (CoroutineStart) null, new LifecycleCoroutineScope$launchWhenResumed$1(this, x0xo0oo, (I0Io<? super LifecycleCoroutineScope$launchWhenResumed$1>) null), 3, (Object) null);
    }

    @kotlin.OOXIXo(message = "launchWhenStarted is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.STARTED.")
    @OOXIXo
    public final oXIO0o0XI launchWhenStarted(@OOXIXo x0xO0oo<? super xII, ? super I0Io<? super kotlin.oXIO0o0XI>, ? extends Object> x0xo0oo) {
        IIX0o.x0xO0oo(x0xo0oo, "block");
        return xoIox.XO(this, (CoroutineContext) null, (CoroutineStart) null, new LifecycleCoroutineScope$launchWhenStarted$1(this, x0xo0oo, (I0Io<? super LifecycleCoroutineScope$launchWhenStarted$1>) null), 3, (Object) null);
    }
}
