package okio;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes6.dex */
public interface Source extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(@OXOo.OOXIXo Buffer buffer, long j) throws IOException;

    @OXOo.OOXIXo
    Timeout timeout();
}
