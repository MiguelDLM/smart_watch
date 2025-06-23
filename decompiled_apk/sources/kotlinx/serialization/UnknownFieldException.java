package kotlinx.serialization;

import kotlin.o0;

@o0
/* loaded from: classes6.dex */
public final class UnknownFieldException extends SerializationException {
    public UnknownFieldException(@OXOo.oOoXoXO String str) {
        super(str);
    }

    public UnknownFieldException(int i) {
        this("An unknown field for index " + i);
    }
}
