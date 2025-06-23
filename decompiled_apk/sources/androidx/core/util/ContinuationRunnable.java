package androidx.core.util;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {

    @OXOo.OOXIXo
    private final kotlin.coroutines.I0Io<oXIO0o0XI> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        super(false);
        this.continuation = i0Io;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.I0Io<oXIO0o0XI> i0Io = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            i0Io.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @OXOo.OOXIXo
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + HexStringBuilder.COMMENT_END_CHAR;
    }
}
