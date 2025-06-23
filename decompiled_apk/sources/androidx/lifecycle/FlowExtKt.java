package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class FlowExtKt {
    @OXOo.OOXIXo
    public static final <T> kotlinx.coroutines.flow.X0o0xo<T> flowWithLifecycle(@OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Lifecycle lifecycle, @OXOo.OOXIXo Lifecycle.State minActiveState) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(lifecycle, "lifecycle");
        IIX0o.x0xO0oo(minActiveState, "minActiveState");
        return kotlinx.coroutines.flow.Oxx0IOOO.Oxx0xo(new FlowExtKt$flowWithLifecycle$1(lifecycle, minActiveState, x0o0xo, null));
    }

    public static /* synthetic */ kotlinx.coroutines.flow.X0o0xo flowWithLifecycle$default(kotlinx.coroutines.flow.X0o0xo x0o0xo, Lifecycle lifecycle, Lifecycle.State state, int i, Object obj) {
        if ((i & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(x0o0xo, lifecycle, state);
    }
}
