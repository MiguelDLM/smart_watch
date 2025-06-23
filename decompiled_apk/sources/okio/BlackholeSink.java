package okio;

import kotlin.jvm.internal.IIX0o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class BlackholeSink implements Sink {
    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.Sink
    @OXOo.OOXIXo
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(@OXOo.OOXIXo Buffer source, long j) {
        IIX0o.x0xO0oo(source, "source");
        source.skip(j);
    }
}
