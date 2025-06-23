package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.DeprecationLevel;
import kotlin.XX;

/* loaded from: classes6.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @XX(expression = "buffer", imports = {}))
    @OXOo.OOXIXo
    Buffer buffer();

    @OXOo.OOXIXo
    BufferedSink emit() throws IOException;

    @OXOo.OOXIXo
    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    @OXOo.OOXIXo
    Buffer getBuffer();

    @OXOo.OOXIXo
    OutputStream outputStream();

    @OXOo.OOXIXo
    BufferedSink write(@OXOo.OOXIXo ByteString byteString) throws IOException;

    @OXOo.OOXIXo
    BufferedSink write(@OXOo.OOXIXo ByteString byteString, int i, int i2) throws IOException;

    @OXOo.OOXIXo
    BufferedSink write(@OXOo.OOXIXo Source source, long j) throws IOException;

    @OXOo.OOXIXo
    BufferedSink write(@OXOo.OOXIXo byte[] bArr) throws IOException;

    @OXOo.OOXIXo
    BufferedSink write(@OXOo.OOXIXo byte[] bArr, int i, int i2) throws IOException;

    long writeAll(@OXOo.OOXIXo Source source) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeByte(int i) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeDecimalLong(long j) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeHexadecimalUnsignedLong(long j) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeInt(int i) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeIntLe(int i) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeLong(long j) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeLongLe(long j) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeShort(int i) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeShortLe(int i) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeString(@OXOo.OOXIXo String str, int i, int i2, @OXOo.OOXIXo Charset charset) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeString(@OXOo.OOXIXo String str, @OXOo.OOXIXo Charset charset) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeUtf8(@OXOo.OOXIXo String str) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeUtf8(@OXOo.OOXIXo String str, int i, int i2) throws IOException;

    @OXOo.OOXIXo
    BufferedSink writeUtf8CodePoint(int i) throws IOException;
}
