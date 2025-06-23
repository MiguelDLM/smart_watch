package okhttp3.internal.http;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* loaded from: classes6.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;

    @oOoXoXO
    private final String contentTypeString;

    @OOXIXo
    private final BufferedSource source;

    public RealResponseBody(@oOoXoXO String str, long j, @OOXIXo BufferedSource source) {
        IIX0o.x0xO0oo(source, "source");
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = source;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    @oOoXoXO
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    @OOXIXo
    public BufferedSource source() {
        return this.source;
    }
}
