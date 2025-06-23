package androidx.lifecycle;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

public final class LifecycleOwnerKt {
    @OOXIXo
    public static final LifecycleCoroutineScope getLifecycleScope(@OOXIXo LifecycleOwner lifecycleOwner) {
        IIX0o.x0xO0oo(lifecycleOwner, "<this>");
        return LifecycleKt.getCoroutineScope(lifecycleOwner.getLifecycle());
    }
}
