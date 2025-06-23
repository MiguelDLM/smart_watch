package androidx.core.os;

import OXOo.OOXIXo;
import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import kotlin.coroutines.I0Io;

@RequiresApi(31)
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    @OOXIXo
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> asOutcomeReceiver(@OOXIXo I0Io<? super R> i0Io) {
        return xxIXOIIO.oIX0oI(new ContinuationOutcomeReceiver(i0Io));
    }
}
