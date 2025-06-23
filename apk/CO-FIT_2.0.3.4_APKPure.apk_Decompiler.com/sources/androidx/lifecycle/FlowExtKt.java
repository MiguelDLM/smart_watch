package androidx.lifecycle;

import OXOo.OOXIXo;
import androidx.lifecycle.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;

public final class FlowExtKt {
    @OOXIXo
    public static final <T> X0o0xo<T> flowWithLifecycle(@OOXIXo X0o0xo<? extends T> x0o0xo, @OOXIXo Lifecycle lifecycle, @OOXIXo Lifecycle.State state) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        IIX0o.x0xO0oo(state, "minActiveState");
        return Oxx0IOOO.Oxx0xo(new FlowExtKt$flowWithLifecycle$1(lifecycle, state, x0o0xo, (I0Io<? super FlowExtKt$flowWithLifecycle$1>) null));
    }

    public static /* synthetic */ X0o0xo flowWithLifecycle$default(X0o0xo x0o0xo, Lifecycle lifecycle, Lifecycle.State state, int i, Object obj) {
        if ((i & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(x0o0xo, lifecycle, state);
    }
}
