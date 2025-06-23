package androidx.core.util;

import OXOo.OOXIXo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.I0Io;
import kotlin.oXIO0o0XI;

final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    @OOXIXo
    private final I0Io<oXIO0o0XI> continuation;

    public ContinuationRunnable(@OOXIXo I0Io<? super oXIO0o0XI> i0Io) {
        super(false);
        this.continuation = i0Io;
    }

    public void run() {
        if (compareAndSet(false, true)) {
            I0Io<oXIO0o0XI> i0Io = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            i0Io.resumeWith(Result.m42constructorimpl(oXIO0o0XI.f19155oIX0oI));
        }
    }

    @OOXIXo
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + HexStringBuilder.COMMENT_END_CHAR;
    }
}
