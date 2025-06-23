package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.IIX0o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class SocketAsyncTimeout extends AsyncTimeout {

    @OXOo.OOXIXo
    private final Socket socket;

    public SocketAsyncTimeout(@OXOo.OOXIXo Socket socket) {
        IIX0o.x0xO0oo(socket, "socket");
        this.socket = socket;
    }

    @Override // okio.AsyncTimeout
    @OXOo.OOXIXo
    public IOException newTimeoutException(@OXOo.oOoXoXO IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    public void timedOut() {
        Logger logger;
        Logger logger2;
        try {
            this.socket.close();
        } catch (AssertionError e) {
            if (Okio.isAndroidGetsocknameError(e)) {
                logger2 = Okio__JvmOkioKt.logger;
                logger2.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e);
                return;
            }
            throw e;
        } catch (Exception e2) {
            logger = Okio__JvmOkioKt.logger;
            logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e2);
        }
    }
}
