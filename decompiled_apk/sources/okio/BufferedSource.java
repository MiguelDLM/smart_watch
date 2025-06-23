package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.DeprecationLevel;
import kotlin.XX;

/* loaded from: classes6.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @XX(expression = "buffer", imports = {}))
    @OXOo.OOXIXo
    Buffer buffer();

    boolean exhausted() throws IOException;

    @OXOo.OOXIXo
    Buffer getBuffer();

    long indexOf(byte b) throws IOException;

    long indexOf(byte b, long j) throws IOException;

    long indexOf(byte b, long j, long j2) throws IOException;

    long indexOf(@OXOo.OOXIXo ByteString byteString) throws IOException;

    long indexOf(@OXOo.OOXIXo ByteString byteString, long j) throws IOException;

    long indexOfElement(@OXOo.OOXIXo ByteString byteString) throws IOException;

    long indexOfElement(@OXOo.OOXIXo ByteString byteString, long j) throws IOException;

    @OXOo.OOXIXo
    InputStream inputStream();

    @OXOo.OOXIXo
    BufferedSource peek();

    boolean rangeEquals(long j, @OXOo.OOXIXo ByteString byteString) throws IOException;

    boolean rangeEquals(long j, @OXOo.OOXIXo ByteString byteString, int i, int i2) throws IOException;

    int read(@OXOo.OOXIXo byte[] bArr) throws IOException;

    int read(@OXOo.OOXIXo byte[] bArr, int i, int i2) throws IOException;

    long readAll(@OXOo.OOXIXo Sink sink) throws IOException;

    byte readByte() throws IOException;

    @OXOo.OOXIXo
    byte[] readByteArray() throws IOException;

    @OXOo.OOXIXo
    byte[] readByteArray(long j) throws IOException;

    @OXOo.OOXIXo
    ByteString readByteString() throws IOException;

    @OXOo.OOXIXo
    ByteString readByteString(long j) throws IOException;

    long readDecimalLong() throws IOException;

    void readFully(@OXOo.OOXIXo Buffer buffer, long j) throws IOException;

    void readFully(@OXOo.OOXIXo byte[] bArr) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    int readIntLe() throws IOException;

    long readLong() throws IOException;

    long readLongLe() throws IOException;

    short readShort() throws IOException;

    short readShortLe() throws IOException;

    @OXOo.OOXIXo
    String readString(long j, @OXOo.OOXIXo Charset charset) throws IOException;

    @OXOo.OOXIXo
    String readString(@OXOo.OOXIXo Charset charset) throws IOException;

    @OXOo.OOXIXo
    String readUtf8() throws IOException;

    @OXOo.OOXIXo
    String readUtf8(long j) throws IOException;

    int readUtf8CodePoint() throws IOException;

    @OXOo.oOoXoXO
    String readUtf8Line() throws IOException;

    @OXOo.OOXIXo
    String readUtf8LineStrict() throws IOException;

    @OXOo.OOXIXo
    String readUtf8LineStrict(long j) throws IOException;

    boolean request(long j) throws IOException;

    void require(long j) throws IOException;

    int select(@OXOo.OOXIXo Options options) throws IOException;

    void skip(long j) throws IOException;
}
