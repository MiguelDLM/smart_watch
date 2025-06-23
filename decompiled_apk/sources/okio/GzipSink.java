package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nGzipSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GzipSink.kt\nokio/GzipSink\n+ 2 RealBufferedSink.kt\nokio/RealBufferedSink\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,153:1\n51#2:154\n1#3:155\n86#4:156\n*S KotlinDebug\n*F\n+ 1 GzipSink.kt\nokio/GzipSink\n*L\n63#1:154\n131#1:156\n*E\n"})
/* loaded from: classes6.dex */
public final class GzipSink implements Sink {
    private boolean closed;

    @OXOo.OOXIXo
    private final CRC32 crc;

    @OXOo.OOXIXo
    private final Deflater deflater;

    @OXOo.OOXIXo
    private final DeflaterSink deflaterSink;

    @OXOo.OOXIXo
    private final RealBufferedSink sink;

    public GzipSink(@OXOo.OOXIXo Sink sink) {
        IIX0o.x0xO0oo(sink, "sink");
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink);
        this.sink = realBufferedSink;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new DeflaterSink((BufferedSink) realBufferedSink, deflater);
        this.crc = new CRC32();
        Buffer buffer = realBufferedSink.bufferField;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private final void updateCrc(Buffer buffer, long j) {
        Segment segment = buffer.head;
        IIX0o.ooOOo0oXI(segment);
        while (j > 0) {
            int min = (int) Math.min(j, segment.limit - segment.pos);
            this.crc.update(segment.data, segment.pos, min);
            j -= min;
            segment = segment.next;
            IIX0o.ooOOo0oXI(segment);
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "deflater", imports = {}))
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "-deprecated_deflater")
    /* renamed from: -deprecated_deflater, reason: not valid java name */
    public final Deflater m453deprecated_deflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        try {
            this.deflaterSink.finishDeflate$okio();
            writeFooter();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th == null) {
        } else {
            throw th;
        }
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "deflater")
    public final Deflater deflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override // okio.Sink
    @OXOo.OOXIXo
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink
    public void write(@OXOo.OOXIXo Buffer source, long j) throws IOException {
        IIX0o.x0xO0oo(source, "source");
        if (j >= 0) {
            if (j == 0) {
                return;
            }
            updateCrc(source, j);
            this.deflaterSink.write(source, j);
            return;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
    }
}
