package androidx.core.os;

import OXOo.OOXIXo;
import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;

@RequiresApi(31)
/* loaded from: classes.dex */
public final class OutcomeReceiverKt {
    @OOXIXo
    @RequiresApi(31)
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> asOutcomeReceiver(@OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        return xxIXOIIO.oIX0oI(new ContinuationOutcomeReceiver(i0Io));
    }
}
