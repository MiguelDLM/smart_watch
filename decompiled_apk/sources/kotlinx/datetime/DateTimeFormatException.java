package kotlinx.datetime;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class DateTimeFormatException extends IllegalArgumentException {
    public DateTimeFormatException() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTimeFormatException(@OOXIXo String message) {
        super(message);
        IIX0o.x0xO0oo(message, "message");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTimeFormatException(@OOXIXo Throwable cause) {
        super(cause);
        IIX0o.x0xO0oo(cause, "cause");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTimeFormatException(@OOXIXo String message, @OOXIXo Throwable cause) {
        super(message, cause);
        IIX0o.x0xO0oo(message, "message");
        IIX0o.x0xO0oo(cause, "cause");
    }
}
