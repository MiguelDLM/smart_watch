package androidx.lifecycle;

import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.x0;

/* loaded from: classes.dex */
public final class LifecycleKt {
    @OXOo.OOXIXo
    public static final LifecycleCoroutineScope getCoroutineScope(@OXOo.OOXIXo Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        IIX0o.x0xO0oo(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, x0.I0Io(null, 1, null).plus(Xo0.X0o0xo().IIXOooo()));
        } while (!Oxx0IOOO.oIX0oI(lifecycle.getInternalScopeRef(), null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }
}
