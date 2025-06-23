package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import okio.ByteString;

/* loaded from: classes6.dex */
public interface WebSocket {

    /* loaded from: classes6.dex */
    public interface Factory {
        @OOXIXo
        WebSocket newWebSocket(@OOXIXo Request request, @OOXIXo WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i, @oOoXoXO String str);

    long queueSize();

    @OOXIXo
    Request request();

    boolean send(@OOXIXo String str);

    boolean send(@OOXIXo ByteString byteString);
}
