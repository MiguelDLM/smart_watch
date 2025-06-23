package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.channels.BufferOverflow;

@OX00O0xII
/* loaded from: classes6.dex */
public interface xxIXOIIO<T> extends kotlinx.coroutines.flow.X0o0xo<T> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public static /* synthetic */ kotlinx.coroutines.flow.X0o0xo oIX0oI(xxIXOIIO xxixoiio, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    coroutineContext = EmptyCoroutineContext.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    i = -3;
                }
                if ((i2 & 4) != 0) {
                    bufferOverflow = BufferOverflow.SUSPEND;
                }
                return xxixoiio.X0o0xo(coroutineContext, i, bufferOverflow);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    @OXOo.OOXIXo
    kotlinx.coroutines.flow.X0o0xo<T> X0o0xo(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow);
}
