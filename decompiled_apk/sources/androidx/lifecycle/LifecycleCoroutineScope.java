package androidx.lifecycle;

import Oox.x0xO0oo;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.xII;

/* loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements xII {
    @OXOo.OOXIXo
    public abstract Lifecycle getLifecycle$lifecycle_common();

    @kotlin.OOXIXo(message = "launchWhenCreated is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.CREATED.")
    @OXOo.OOXIXo
    public final oXIO0o0XI launchWhenCreated(@OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, ? extends Object> block) {
        oXIO0o0XI XO2;
        IIX0o.x0xO0oo(block, "block");
        XO2 = kotlinx.coroutines.xoIox.XO(this, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(this, block, null), 3, null);
        return XO2;
    }

    @kotlin.OOXIXo(message = "launchWhenResumed is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.RESUMED.")
    @OXOo.OOXIXo
    public final oXIO0o0XI launchWhenResumed(@OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, ? extends Object> block) {
        oXIO0o0XI XO2;
        IIX0o.x0xO0oo(block, "block");
        XO2 = kotlinx.coroutines.xoIox.XO(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, block, null), 3, null);
        return XO2;
    }

    @kotlin.OOXIXo(message = "launchWhenStarted is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.STARTED.")
    @OXOo.OOXIXo
    public final oXIO0o0XI launchWhenStarted(@OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, ? extends Object> block) {
        oXIO0o0XI XO2;
        IIX0o.x0xO0oo(block, "block");
        XO2 = kotlinx.coroutines.xoIox.XO(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, block, null), 3, null);
        return XO2;
    }
}
