package okhttp3.internal.http;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okio.Sink;
import okio.Source;

/* loaded from: classes6.dex */
public interface ExchangeCodec {

    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

        private Companion() {
        }
    }

    void cancel();

    @OOXIXo
    Sink createRequestBody(@OOXIXo Request request, long j) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    @OOXIXo
    RealConnection getConnection();

    @OOXIXo
    Source openResponseBodySource(@OOXIXo Response response) throws IOException;

    @oOoXoXO
    Response.Builder readResponseHeaders(boolean z) throws IOException;

    long reportedContentLength(@OOXIXo Response response) throws IOException;

    @OOXIXo
    Headers trailers() throws IOException;

    void writeRequestHeaders(@OOXIXo Request request) throws IOException;
}
