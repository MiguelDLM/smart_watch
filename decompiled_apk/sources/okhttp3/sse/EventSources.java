package okhttp3.sse;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import kotlin.jvm.internal.IIX0o;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.sse.RealEventSource;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import okhttp3.sse.EventSources;

/* loaded from: classes6.dex */
public final class EventSources {

    @OOXIXo
    public static final EventSources INSTANCE = new EventSources();

    private EventSources() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final EventSource.Factory createFactory(@OOXIXo final OkHttpClient client) {
        IIX0o.x0xO0oo(client, "client");
        return new EventSource.Factory() { // from class: OXxx0OO.oIX0oI
            @Override // okhttp3.sse.EventSource.Factory
            public final EventSource newEventSource(Request request, EventSourceListener eventSourceListener) {
                EventSource createFactory$lambda$1;
                createFactory$lambda$1 = EventSources.createFactory$lambda$1(OkHttpClient.this, request, eventSourceListener);
                return createFactory$lambda$1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventSource createFactory$lambda$1(OkHttpClient client, Request request, EventSourceListener listener) {
        IIX0o.x0xO0oo(client, "$client");
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(listener, "listener");
        if (request.header("Accept") == null) {
            request = request.newBuilder().addHeader("Accept", "text/event-stream").build();
        }
        RealEventSource realEventSource = new RealEventSource(request, listener);
        realEventSource.connect(client);
        return realEventSource;
    }

    @x0XOIxOo
    public static final void processResponse(@OOXIXo Response response, @OOXIXo EventSourceListener listener) {
        IIX0o.x0xO0oo(response, "response");
        IIX0o.x0xO0oo(listener, "listener");
        new RealEventSource(response.request(), listener).processResponse(response);
    }
}
