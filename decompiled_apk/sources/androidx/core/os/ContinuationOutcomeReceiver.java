package androidx.core.os;

import OXOo.OOXIXo;
import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.I0oOoX;
import kotlin.Result;

@RequiresApi(31)
/* loaded from: classes.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {

    @OOXIXo
    private final kotlin.coroutines.I0Io<R> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationOutcomeReceiver(@OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        super(false);
        this.continuation = i0Io;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(@OOXIXo E e) {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.I0Io<R> i0Io = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            i0Io.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(e)));
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(R r) {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.I0Io<R> i0Io = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            i0Io.resumeWith(Result.m287constructorimpl(r));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @OOXIXo
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + HexStringBuilder.COMMENT_END_CHAR;
    }
}
