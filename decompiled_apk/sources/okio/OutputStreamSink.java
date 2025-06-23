package okio;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.OutputStream;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

/* JADX INFO: Access modifiers changed from: package-private */
@XX({"SMAP\nJvmOkio.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmOkio.kt\nokio/OutputStreamSink\n+ 2 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,239:1\n86#2:240\n*S KotlinDebug\n*F\n+ 1 JvmOkio.kt\nokio/OutputStreamSink\n*L\n55#1:240\n*E\n"})
/* loaded from: classes6.dex */
public final class OutputStreamSink implements Sink {

    @OXOo.OOXIXo
    private final OutputStream out;

    @OXOo.OOXIXo
    private final Timeout timeout;

    public OutputStreamSink(@OXOo.OOXIXo OutputStream out, @OXOo.OOXIXo Timeout timeout) {
        IIX0o.x0xO0oo(out, "out");
        IIX0o.x0xO0oo(timeout, "timeout");
        this.out = out;
        this.timeout = timeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    @Override // okio.Sink
    @OXOo.OOXIXo
    public Timeout timeout() {
        return this.timeout;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "sink(" + this.out + HexStringBuilder.COMMENT_END_CHAR;
    }

    @Override // okio.Sink
    public void write(@OXOo.OOXIXo Buffer source, long j) {
        IIX0o.x0xO0oo(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j);
        while (j > 0) {
            this.timeout.throwIfReached();
            Segment segment = source.head;
            IIX0o.ooOOo0oXI(segment);
            int min = (int) Math.min(j, segment.limit - segment.pos);
            this.out.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j2 = min;
            j -= j2;
            source.setSize$okio(source.size() - j2);
            if (segment.pos == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }
}
