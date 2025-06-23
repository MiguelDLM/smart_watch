package androidx.core.os;

import OXOo.OOXIXo;
import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.I0Io;

@RequiresApi(31)
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {
    @OOXIXo
    private final I0Io<R> continuation;

    public ContinuationOutcomeReceiver(@OOXIXo I0Io<? super R> i0Io) {
        super(false);
        this.continuation = i0Io;
    }

    public void onError(@OOXIXo E e) {
        if (compareAndSet(false, true)) {
            I0Io<R> i0Io = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            i0Io.resumeWith(Result.m42constructorimpl(I0oOoX.oIX0oI(e)));
        }
    }

    public void onResult(R r) {
        if (compareAndSet(false, true)) {
            I0Io<R> i0Io = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            i0Io.resumeWith(Result.m42constructorimpl(r));
        }
    }

    @OOXIXo
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + HexStringBuilder.COMMENT_END_CHAR;
    }
}
