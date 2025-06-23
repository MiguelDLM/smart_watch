package okhttp3.internal.connection;

import OXOo.OOXIXo;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import kotlin.oO;

/* loaded from: classes6.dex */
public final class RouteException extends RuntimeException {

    @OOXIXo
    private final IOException firstConnectException;

    @OOXIXo
    private IOException lastConnectException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteException(@OOXIXo IOException firstConnectException) {
        super(firstConnectException);
        IIX0o.x0xO0oo(firstConnectException, "firstConnectException");
        this.firstConnectException = firstConnectException;
        this.lastConnectException = firstConnectException;
    }

    public final void addConnectException(@OOXIXo IOException e) {
        IIX0o.x0xO0oo(e, "e");
        oO.oIX0oI(this.firstConnectException, e);
        this.lastConnectException = e;
    }

    @OOXIXo
    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    @OOXIXo
    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}
