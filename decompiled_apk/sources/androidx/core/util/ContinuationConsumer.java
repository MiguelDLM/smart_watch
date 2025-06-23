package androidx.core.util;

import androidx.annotation.RequiresApi;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;

@RequiresApi(24)
/* loaded from: classes.dex */
final class ContinuationConsumer<T> extends AtomicBoolean implements java.util.function.Consumer<T> {

    @OXOo.OOXIXo
    private final kotlin.coroutines.I0Io<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationConsumer(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        super(false);
        this.continuation = i0Io;
    }

    @Override // java.util.function.Consumer
    public void accept(T t) {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.I0Io<T> i0Io = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            i0Io.resumeWith(Result.m287constructorimpl(t));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @OXOo.OOXIXo
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + HexStringBuilder.COMMENT_END_CHAR;
    }
}
