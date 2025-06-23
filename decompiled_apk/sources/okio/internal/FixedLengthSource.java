package okio.internal;

import OXOo.OOXIXo;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

/* loaded from: classes6.dex */
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(@OOXIXo Source delegate, long j, boolean z) {
        super(delegate);
        IIX0o.x0xO0oo(delegate, "delegate");
        this.size = j;
        this.truncate = z;
    }

    private final void truncateToSize(Buffer buffer, long j) {
        Buffer buffer2 = new Buffer();
        buffer2.writeAll(buffer);
        buffer.write(buffer2, j);
        buffer2.clear();
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(@OOXIXo Buffer sink, long j) {
        IIX0o.x0xO0oo(sink, "sink");
        long j2 = this.bytesReceived;
        long j3 = this.size;
        if (j2 > j3) {
            j = 0;
        } else if (this.truncate) {
            long j4 = j3 - j2;
            if (j4 == 0) {
                return -1L;
            }
            j = Math.min(j, j4);
        }
        long read = super.read(sink, j);
        if (read != -1) {
            this.bytesReceived += read;
        }
        long j5 = this.bytesReceived;
        long j6 = this.size;
        if ((j5 < j6 && read == -1) || j5 > j6) {
            if (read > 0 && j5 > j6) {
                truncateToSize(sink, sink.size() - (this.bytesReceived - this.size));
            }
            throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
        }
        return read;
    }
}
