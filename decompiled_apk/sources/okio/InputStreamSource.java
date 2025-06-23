package okio;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

/* JADX INFO: Access modifiers changed from: package-private */
@XX({"SMAP\nJvmOkio.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmOkio.kt\nokio/InputStreamSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,239:1\n1#2:240\n86#3:241\n*S KotlinDebug\n*F\n+ 1 JvmOkio.kt\nokio/InputStreamSource\n*L\n92#1:241\n*E\n"})
/* loaded from: classes6.dex */
public class InputStreamSource implements Source {

    @OXOo.OOXIXo
    private final InputStream input;

    @OXOo.OOXIXo
    private final Timeout timeout;

    public InputStreamSource(@OXOo.OOXIXo InputStream input, @OXOo.OOXIXo Timeout timeout) {
        IIX0o.x0xO0oo(input, "input");
        IIX0o.x0xO0oo(timeout, "timeout");
        this.input = input;
        this.timeout = timeout;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.input.close();
    }

    @Override // okio.Source
    public long read(@OXOo.OOXIXo Buffer sink, long j) {
        IIX0o.x0xO0oo(sink, "sink");
        if (j == 0) {
            return 0L;
        }
        if (j >= 0) {
            try {
                this.timeout.throwIfReached();
                Segment writableSegment$okio = sink.writableSegment$okio(1);
                int read = this.input.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j, 8192 - writableSegment$okio.limit));
                if (read == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        sink.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                        return -1L;
                    }
                    return -1L;
                }
                writableSegment$okio.limit += read;
                long j2 = read;
                sink.setSize$okio(sink.size() + j2);
                return j2;
            } catch (AssertionError e) {
                if (Okio.isAndroidGetsocknameError(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
    }

    @Override // okio.Source
    @OXOo.OOXIXo
    public Timeout timeout() {
        return this.timeout;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "source(" + this.input + HexStringBuilder.COMMENT_END_CHAR;
    }
}
