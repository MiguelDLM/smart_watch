package androidx.core.util;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import androidx.annotation.RequiresApi;
import java.util.function.Consumer;
import kotlin.coroutines.I0Io;

@RequiresApi(24)
@xxIXOIIO(name = "ConsumerKt")
public final class ConsumerKt {
    @RequiresApi(24)
    @OOXIXo
    public static final <T> Consumer<T> asConsumer(@OOXIXo I0Io<? super T> i0Io) {
        return oIX0oI.oIX0oI(new ContinuationConsumer(i0Io));
    }
}
