package androidx.lifecycle;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.x0;

public final class LifecycleKt {
    @OOXIXo
    public static final LifecycleCoroutineScope getCoroutineScope(@OOXIXo Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        IIX0o.x0xO0oo(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, x0.I0Io((oXIO0o0XI) null, 1, (Object) null).plus(Xo0.X0o0xo().IIXOooo()));
        } while (!Oxx0IOOO.oIX0oI(lifecycle.getInternalScopeRef(), (Object) null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }
}
