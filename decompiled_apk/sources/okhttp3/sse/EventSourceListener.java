package okhttp3.sse;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import okhttp3.Response;

/* loaded from: classes6.dex */
public abstract class EventSourceListener {
    public void onClosed(@OOXIXo EventSource eventSource) {
        IIX0o.x0xO0oo(eventSource, "eventSource");
    }

    public void onEvent(@OOXIXo EventSource eventSource, @oOoXoXO String str, @oOoXoXO String str2, @OOXIXo String data) {
        IIX0o.x0xO0oo(eventSource, "eventSource");
        IIX0o.x0xO0oo(data, "data");
    }

    public void onFailure(@OOXIXo EventSource eventSource, @oOoXoXO Throwable th, @oOoXoXO Response response) {
        IIX0o.x0xO0oo(eventSource, "eventSource");
    }

    public void onOpen(@OOXIXo EventSource eventSource, @OOXIXo Response response) {
        IIX0o.x0xO0oo(eventSource, "eventSource");
        IIX0o.x0xO0oo(response, "response");
    }
}
