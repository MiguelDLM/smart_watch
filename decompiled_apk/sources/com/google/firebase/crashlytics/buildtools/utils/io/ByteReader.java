package com.google.firebase.crashlytics.buildtools.utils.io;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes10.dex */
public class ByteReader implements Closeable {
    private static final int BUFFER_SIZE = 64;
    private static final int INT_WIDTH = 4;
    private static final int LONG_WIDTH = 8;
    private static final int SHORT_WIDTH = 2;
    private final ByteBuffer _buffer;
    private final byte[] _bytes;
    private final SeekableInputStream _source;

    public ByteReader(SeekableInputStream seekableInputStream) {
        byte[] bArr = new byte[64];
        this._bytes = bArr;
        this._buffer = ByteBuffer.allocate(bArr.length);
        this._source = seekableInputStream;
    }

    private byte[] padBytes(byte[] bArr, int i, int i2, ByteOrder byteOrder) {
        int i3;
        byte[] bArr2 = new byte[i2];
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i3 = i2 - i;
        } else {
            i3 = 0;
        }
        System.arraycopy(bArr, 0, bArr2, i3, i);
        return bArr2;
    }

    private byte[] readNumber(byte[] bArr, int i, int i2, ByteOrder byteOrder) throws IOException {
        if (i <= i2) {
            this._source.readFully(bArr, 0, i);
            return padBytes(bArr, i, i2, byteOrder);
        }
        throw new IllegalArgumentException(String.format("Requested number of bytes (%d) was greater than available bytes (%d).", Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._source.close();
    }

    public ByteOrder getByteOrder() {
        return this._buffer.order();
    }

    public long getCurrentOffset() throws IOException {
        return this._source.getCurrentOffset();
    }

    public byte readByte() throws IOException {
        int read = this._source.read();
        if (read >= 0) {
            return (byte) (read & 255);
        }
        throw new EOFException();
    }

    public byte[] readBytes(int i) throws IOException {
        byte[] bArr = new byte[i];
        this._source.readFully(bArr, 0, i);
        return bArr;
    }

    public int readInt(int i) throws IOException {
        ByteBuffer byteBuffer = this._buffer;
        byteBuffer.put(readNumber(this._bytes, i, 4, byteBuffer.order()));
        int i2 = this._buffer.getInt();
        return i2;
    }

    public long readLong(int i) throws IOException {
        ByteBuffer byteBuffer = this._buffer;
        byteBuffer.put(readNumber(this._bytes, i, 8, byteBuffer.order()));
        long j = this._buffer.getLong();
        return j;
    }

    public String readNullTerminatedString(Charset charset) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = this._source.read();
            if (read != 0) {
                if (read >= 0) {
                    byteArrayOutputStream.write(read);
                } else {
                    throw new EOFException();
                }
            } else {
                return new String(byteArrayOutputStream.toByteArray(), charset);
            }
        }
    }

    public int readSLEB128() throws IOException {
        byte readByte;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        do {
            readByte = readByte();
            i++;
            i2 |= (readByte & Byte.MAX_VALUE) << i3;
            i3 += 7;
        } while ((readByte & 128) != 0);
        if (i3 < i * 8 && (readByte & 64) != 0) {
            return i2 | (-(1 << i3));
        }
        return i2;
    }

    public short readShort(int i) throws IOException {
        ByteBuffer byteBuffer = this._buffer;
        byteBuffer.put(readNumber(this._bytes, i, 2, byteBuffer.order()));
        short s = this._buffer.getShort();
        return s;
    }

    public int readULEB128() throws IOException {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte readByte = readByte();
            i |= (readByte & Byte.MAX_VALUE) << i2;
            if ((readByte & 128) == 0) {
                return i;
            }
            i2 += 7;
        }
    }

    public void seek(long j) throws IOException {
        this._source.seek(j);
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this._buffer.order(byteOrder);
    }
}
