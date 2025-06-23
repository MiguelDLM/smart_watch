package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: classes6.dex */
public interface Sink extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    @OXOo.OOXIXo
    Timeout timeout();

    void write(@OXOo.OOXIXo Buffer buffer, long j) throws IOException;
}
