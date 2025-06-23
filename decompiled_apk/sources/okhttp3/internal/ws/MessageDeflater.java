package okhttp3.internal.ws;

import OXOo.OOXIXo;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Sink;

/* loaded from: classes6.dex */
public final class MessageDeflater implements Closeable {

    @OOXIXo
    private final Buffer deflatedBytes;

    @OOXIXo
    private final Deflater deflater;

    @OOXIXo
    private final DeflaterSink deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z) {
        this.noContextTakeover = z;
        Buffer buffer = new Buffer();
        this.deflatedBytes = buffer;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new DeflaterSink((Sink) buffer, deflater);
    }

    private final boolean endsWith(Buffer buffer, ByteString byteString) {
        return buffer.rangeEquals(buffer.size() - byteString.size(), byteString);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.deflaterSink.close();
    }

    public final void deflate(@OOXIXo Buffer buffer) throws IOException {
        ByteString byteString;
        IIX0o.x0xO0oo(buffer, "buffer");
        if (this.deflatedBytes.size() == 0) {
            if (this.noContextTakeover) {
                this.deflater.reset();
            }
            this.deflaterSink.write(buffer, buffer.size());
            this.deflaterSink.flush();
            Buffer buffer2 = this.deflatedBytes;
            byteString = MessageDeflaterKt.EMPTY_DEFLATE_BLOCK;
            if (endsWith(buffer2, byteString)) {
                long size = this.deflatedBytes.size() - 4;
                Buffer.UnsafeCursor readAndWriteUnsafe$default = Buffer.readAndWriteUnsafe$default(this.deflatedBytes, null, 1, null);
                try {
                    readAndWriteUnsafe$default.resizeBuffer(size);
                    II0xO0.oIX0oI(readAndWriteUnsafe$default, null);
                } finally {
                }
            } else {
                this.deflatedBytes.writeByte(0);
            }
            Buffer buffer3 = this.deflatedBytes;
            buffer.write(buffer3, buffer3.size());
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }
}
