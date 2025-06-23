package okhttp3.internal.cache;

import OXOo.OOXIXo;
import java.io.IOException;
import okio.Sink;

/* loaded from: classes6.dex */
public interface CacheRequest {
    void abort();

    @OOXIXo
    Sink body() throws IOException;
}
