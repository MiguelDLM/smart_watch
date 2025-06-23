package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import okio.ByteString;

/* loaded from: classes6.dex */
public abstract class WebSocketListener {
    public void onClosed(@OOXIXo WebSocket webSocket, int i, @OOXIXo String reason) {
        IIX0o.x0xO0oo(webSocket, "webSocket");
        IIX0o.x0xO0oo(reason, "reason");
    }

    public void onClosing(@OOXIXo WebSocket webSocket, int i, @OOXIXo String reason) {
        IIX0o.x0xO0oo(webSocket, "webSocket");
        IIX0o.x0xO0oo(reason, "reason");
    }

    public void onFailure(@OOXIXo WebSocket webSocket, @OOXIXo Throwable t, @oOoXoXO Response response) {
        IIX0o.x0xO0oo(webSocket, "webSocket");
        IIX0o.x0xO0oo(t, "t");
    }

    public void onMessage(@OOXIXo WebSocket webSocket, @OOXIXo String text) {
        IIX0o.x0xO0oo(webSocket, "webSocket");
        IIX0o.x0xO0oo(text, "text");
    }

    public void onOpen(@OOXIXo WebSocket webSocket, @OOXIXo Response response) {
        IIX0o.x0xO0oo(webSocket, "webSocket");
        IIX0o.x0xO0oo(response, "response");
    }

    public void onMessage(@OOXIXo WebSocket webSocket, @OOXIXo ByteString bytes) {
        IIX0o.x0xO0oo(webSocket, "webSocket");
        IIX0o.x0xO0oo(bytes, "bytes");
    }
}
