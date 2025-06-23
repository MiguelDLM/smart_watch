package androidx.lifecycle;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class LifecycleOwnerKt {
    @OXOo.OOXIXo
    public static final LifecycleCoroutineScope getLifecycleScope(@OXOo.OOXIXo LifecycleOwner lifecycleOwner) {
        IIX0o.x0xO0oo(lifecycleOwner, "<this>");
        return LifecycleKt.getCoroutineScope(lifecycleOwner.getLifecycle());
    }
}
