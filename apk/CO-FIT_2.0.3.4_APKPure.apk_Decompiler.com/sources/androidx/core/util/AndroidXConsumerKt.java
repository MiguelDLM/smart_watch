package androidx.core.util;

import OXOo.OOXIXo;
import kotlin.coroutines.I0Io;

public final class AndroidXConsumerKt {
    @OOXIXo
    public static final <T> Consumer<T> asAndroidXConsumer(@OOXIXo I0Io<? super T> i0Io) {
        return new AndroidXContinuationConsumer(i0Io);
    }
}
