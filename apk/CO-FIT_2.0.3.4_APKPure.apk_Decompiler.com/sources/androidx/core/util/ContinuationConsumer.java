package androidx.core.util;

import OXOo.OOXIXo;
import androidx.annotation.RequiresApi;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.Result;
import kotlin.coroutines.I0Io;

@RequiresApi(24)
final class ContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    @OOXIXo
    private final I0Io<T> continuation;

    public ContinuationConsumer(@OOXIXo I0Io<? super T> i0Io) {
        super(false);
        this.continuation = i0Io;
    }

    public void accept(T t) {
        if (compareAndSet(false, true)) {
            I0Io<T> i0Io = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            i0Io.resumeWith(Result.m42constructorimpl(t));
        }
    }

    @OOXIXo
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + HexStringBuilder.COMMENT_END_CHAR;
    }
}
