package okhttp3.internal.sse;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import org.apache.commons.lang3.xXOx;

@XX({"SMAP\nServerSentEventReader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerSentEventReader.kt\nokhttp3/internal/sse/ServerSentEventReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1#2:160\n*E\n"})
/* loaded from: classes6.dex */
public final class ServerSentEventReader {

    @OOXIXo
    private static final ByteString CRLF;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final Options options;

    @OOXIXo
    private final Callback callback;

    @oOoXoXO
    private String lastId;

    @OOXIXo
    private final BufferedSource source;

    /* loaded from: classes6.dex */
    public interface Callback {
        void onEvent(@oOoXoXO String str, @oOoXoXO String str2, @OOXIXo String str3);

        void onRetryChange(long j);
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void readData(BufferedSource bufferedSource, Buffer buffer) throws IOException {
            buffer.writeByte(10);
            bufferedSource.readFully(buffer, bufferedSource.indexOfElement(ServerSentEventReader.CRLF));
            bufferedSource.select(getOptions());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long readRetryMs(BufferedSource bufferedSource) throws IOException {
            return Util.toLongOrDefault(bufferedSource.readUtf8LineStrict(), -1L);
        }

        @OOXIXo
        public final Options getOptions() {
            return ServerSentEventReader.options;
        }

        private Companion() {
        }
    }

    static {
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        options = companion.of(companion2.encodeUtf8("\r\n"), companion2.encodeUtf8(xXOx.f32950X0o0xo), companion2.encodeUtf8("\n"), companion2.encodeUtf8("data: "), companion2.encodeUtf8("data:"), companion2.encodeUtf8("data\r\n"), companion2.encodeUtf8("data\r"), companion2.encodeUtf8("data\n"), companion2.encodeUtf8("id: "), companion2.encodeUtf8("id:"), companion2.encodeUtf8("id\r\n"), companion2.encodeUtf8("id\r"), companion2.encodeUtf8("id\n"), companion2.encodeUtf8("event: "), companion2.encodeUtf8("event:"), companion2.encodeUtf8("event\r\n"), companion2.encodeUtf8("event\r"), companion2.encodeUtf8("event\n"), companion2.encodeUtf8("retry: "), companion2.encodeUtf8("retry:"));
        CRLF = companion2.encodeUtf8("\r\n");
    }

    public ServerSentEventReader(@OOXIXo BufferedSource source, @OOXIXo Callback callback) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(callback, "callback");
        this.source = source;
        this.callback = callback;
    }

    private final void completeEvent(String str, String str2, Buffer buffer) throws IOException {
        if (buffer.size() != 0) {
            this.lastId = str;
            buffer.skip(1L);
            this.callback.onEvent(str, str2, buffer.readUtf8());
        }
    }

    public final boolean processNextEvent() throws IOException {
        String str = this.lastId;
        Buffer buffer = new Buffer();
        while (true) {
            String str2 = null;
            while (true) {
                BufferedSource bufferedSource = this.source;
                Options options2 = options;
                int select = bufferedSource.select(options2);
                if (select >= 0 && select < 3) {
                    completeEvent(str, str2, buffer);
                    return true;
                }
                if (3 <= select && select < 5) {
                    Companion.readData(this.source, buffer);
                } else if (5 <= select && select < 8) {
                    buffer.writeByte(10);
                } else if (8 <= select && select < 10) {
                    str = this.source.readUtf8LineStrict();
                    if (str.length() <= 0) {
                        str = null;
                    }
                } else if (10 <= select && select < 13) {
                    str = null;
                } else if (13 <= select && select < 15) {
                    str2 = this.source.readUtf8LineStrict();
                    if (str2.length() > 0) {
                    }
                } else if (15 > select || select >= 18) {
                    if (18 <= select && select < 20) {
                        long readRetryMs = Companion.readRetryMs(this.source);
                        if (readRetryMs != -1) {
                            this.callback.onRetryChange(readRetryMs);
                        }
                    } else if (select == -1) {
                        long indexOfElement = this.source.indexOfElement(CRLF);
                        if (indexOfElement != -1) {
                            this.source.skip(indexOfElement);
                            this.source.select(options2);
                        } else {
                            return false;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
        }
    }
}
