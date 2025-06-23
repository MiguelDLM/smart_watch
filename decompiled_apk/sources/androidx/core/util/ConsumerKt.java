package androidx.core.util;

import androidx.annotation.RequiresApi;

@XO0OX.xxIXOIIO(name = "ConsumerKt")
@RequiresApi(24)
/* loaded from: classes.dex */
public final class ConsumerKt {
    @OXOo.OOXIXo
    @RequiresApi(24)
    public static final <T> java.util.function.Consumer<T> asConsumer(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return oIX0oI.oIX0oI(new ContinuationConsumer(i0Io));
    }
}
