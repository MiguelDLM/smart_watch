package okhttp3.internal.sse;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.sse.ServerSentEventReader;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

/* loaded from: classes6.dex */
public final class RealEventSource implements EventSource, ServerSentEventReader.Callback, Callback {
    private RealCall call;

    @OOXIXo
    private final EventSourceListener listener;

    @OOXIXo
    private final Request request;

    public RealEventSource(@OOXIXo Request request, @OOXIXo EventSourceListener listener) {
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(listener, "listener");
        this.request = request;
        this.listener = listener;
    }

    private final boolean isEventStream(ResponseBody responseBody) {
        MediaType contentType = responseBody.contentType();
        if (contentType == null || !IIX0o.Oxx0IOOO(contentType.type(), "text") || !IIX0o.Oxx0IOOO(contentType.subtype(), "event-stream")) {
            return false;
        }
        return true;
    }

    @Override // okhttp3.sse.EventSource
    public void cancel() {
        RealCall realCall = this.call;
        if (realCall == null) {
            IIX0o.XOxIOxOx(NotificationCompat.CATEGORY_CALL);
            realCall = null;
        }
        realCall.cancel();
    }

    public final void connect(@OOXIXo OkHttpClient client) {
        IIX0o.x0xO0oo(client, "client");
        Call newCall = client.newBuilder().eventListener(EventListener.NONE).build().newCall(this.request);
        IIX0o.x0XOIxOo(newCall, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall");
        RealCall realCall = (RealCall) newCall;
        this.call = realCall;
        if (realCall == null) {
            IIX0o.XOxIOxOx(NotificationCompat.CATEGORY_CALL);
            realCall = null;
        }
        realCall.enqueue(this);
    }

    @Override // okhttp3.internal.sse.ServerSentEventReader.Callback
    public void onEvent(@oOoXoXO String str, @oOoXoXO String str2, @OOXIXo String data) {
        IIX0o.x0xO0oo(data, "data");
        this.listener.onEvent(this, str, str2, data);
    }

    @Override // okhttp3.Callback
    public void onFailure(@OOXIXo Call call, @OOXIXo IOException e) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(e, "e");
        this.listener.onFailure(this, e, null);
    }

    @Override // okhttp3.Callback
    public void onResponse(@OOXIXo Call call, @OOXIXo Response response) {
        IIX0o.x0xO0oo(call, "call");
        IIX0o.x0xO0oo(response, "response");
        processResponse(response);
    }

    @Override // okhttp3.internal.sse.ServerSentEventReader.Callback
    public void onRetryChange(long j) {
    }

    public final void processResponse(@OOXIXo Response response) {
        IIX0o.x0xO0oo(response, "response");
        try {
            if (!response.isSuccessful()) {
                this.listener.onFailure(this, null, response);
                II0xO0.oIX0oI(response, null);
                return;
            }
            ResponseBody body = response.body();
            IIX0o.ooOOo0oXI(body);
            if (!isEventStream(body)) {
                this.listener.onFailure(this, new IllegalStateException("Invalid content-type: " + body.contentType()), response);
                II0xO0.oIX0oI(response, null);
                return;
            }
            RealCall realCall = this.call;
            if (realCall == null) {
                IIX0o.XOxIOxOx(NotificationCompat.CATEGORY_CALL);
                realCall = null;
            }
            realCall.timeoutEarlyExit();
            Response build = response.newBuilder().body(Util.EMPTY_RESPONSE).build();
            ServerSentEventReader serverSentEventReader = new ServerSentEventReader(body.source(), this);
            try {
                this.listener.onOpen(this, build);
                do {
                } while (serverSentEventReader.processNextEvent());
                this.listener.onClosed(this);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                II0xO0.oIX0oI(response, null);
            } catch (Exception e) {
                this.listener.onFailure(this, e, build);
                II0xO0.oIX0oI(response, null);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                II0xO0.oIX0oI(response, th);
                throw th2;
            }
        }
    }

    @Override // okhttp3.sse.EventSource
    @OOXIXo
    public Request request() {
        return this.request;
    }
}
