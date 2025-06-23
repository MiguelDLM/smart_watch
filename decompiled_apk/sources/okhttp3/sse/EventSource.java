package okhttp3.sse;

import OXOo.OOXIXo;
import okhttp3.Request;

/* loaded from: classes6.dex */
public interface EventSource {

    /* loaded from: classes6.dex */
    public interface Factory {
        @OOXIXo
        EventSource newEventSource(@OOXIXo Request request, @OOXIXo EventSourceListener eventSourceListener);
    }

    void cancel();

    @OOXIXo
    Request request();
}
