package okhttp3.internal.http1;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okhttp3.Headers;
import okio.BufferedSource;

/* loaded from: classes6.dex */
public final class HeadersReader {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;

    @OOXIXo
    private final BufferedSource source;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public HeadersReader(@OOXIXo BufferedSource source) {
        IIX0o.x0xO0oo(source, "source");
        this.source = source;
        this.headerLimit = 262144L;
    }

    @OOXIXo
    public final BufferedSource getSource() {
        return this.source;
    }

    @OOXIXo
    public final Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readLine = readLine();
            if (readLine.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(readLine);
        }
    }

    @OOXIXo
    public final String readLine() {
        String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }
}
