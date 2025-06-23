package okhttp3.internal.http2;

import OXOo.OOXIXo;
import XO0OX.XO;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class StreamResetException extends IOException {

    @OOXIXo
    @XO
    public final ErrorCode errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(@OOXIXo ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        IIX0o.x0xO0oo(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
}
