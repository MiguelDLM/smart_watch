package kotlinx.datetime;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class IllegalTimeZoneException extends IllegalArgumentException {
    public IllegalTimeZoneException() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalTimeZoneException(@OOXIXo String message) {
        super(message);
        IIX0o.x0xO0oo(message, "message");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalTimeZoneException(@OOXIXo Throwable cause) {
        super(cause);
        IIX0o.x0xO0oo(cause, "cause");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalTimeZoneException(@OOXIXo String message, @OOXIXo Throwable cause) {
        super(message, cause);
        IIX0o.x0xO0oo(message, "message");
        IIX0o.x0xO0oo(cause, "cause");
    }
}
