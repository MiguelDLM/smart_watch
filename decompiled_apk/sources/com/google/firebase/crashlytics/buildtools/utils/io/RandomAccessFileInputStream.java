package com.google.firebase.crashlytics.buildtools.utils.io;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes10.dex */
public class RandomAccessFileInputStream extends SeekableInputStream {
    private static final int BUFFER_SIZE = 8192;
    private byte[] _buffer;
    private RandomAccessFile _file;
    private long _filePointer;
    private int _bufferPos = 0;
    private int _bufferCount = 0;

    public RandomAccessFileInputStream(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this._file = randomAccessFile;
        this._buffer = new byte[8192];
        this._filePointer = randomAccessFile.getFilePointer();
    }

    private void fillBuffer() throws IOException {
        this._bufferPos = 0;
        this._bufferCount = 0;
        byte[] bArr = this._buffer;
        int readFromFile = readFromFile(bArr, 0, bArr.length);
        if (readFromFile > 0) {
            this._bufferCount = readFromFile;
        }
    }

    private int readFromFile(byte[] bArr, int i, int i2) throws IOException {
        int read = this._file.read(bArr, i, i2);
        this._filePointer = this._file.getFilePointer();
        return read;
    }

    private int readOnce(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this._bufferCount - this._bufferPos;
        if (i3 <= 0) {
            if (i2 >= this._buffer.length) {
                return readFromFile(bArr, i, i2);
            }
            fillBuffer();
            i3 = this._bufferCount - this._bufferPos;
            if (i3 <= 0) {
                return -1;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        System.arraycopy(this._buffer, this._bufferPos, bArr, i, i2);
        this._bufferPos += i2;
        return i2;
    }

    private void validateOpen() throws IOException {
        if (this._file != null && this._buffer != null) {
        } else {
            throw new IOException("Stream closed.");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._file.close();
        this._file = null;
        this._buffer = null;
    }

    @Override // com.google.firebase.crashlytics.buildtools.utils.io.SeekableInputStream
    public long getCurrentOffset() throws IOException {
        validateOpen();
        return this._filePointer - Math.max(this._bufferCount - this._bufferPos, 0);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        validateOpen();
        if (this._bufferPos >= this._bufferCount) {
            fillBuffer();
            if (this._bufferPos >= this._bufferCount) {
                return -1;
            }
        }
        byte[] bArr = this._buffer;
        int i = this._bufferPos;
        this._bufferPos = i + 1;
        return bArr[i] & 255;
    }

    @Override // com.google.firebase.crashlytics.buildtools.utils.io.SeekableInputStream
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        validateOpen();
        int i3 = 0;
        do {
            int read = read(bArr, i + i3, i2 - i3);
            if (read >= 0) {
                i3 += read;
            } else {
                throw new EOFException();
            }
        } while (i3 < i2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.utils.io.SeekableInputStream
    public void seek(long j) throws IOException {
        validateOpen();
        if (j >= 0) {
            long j2 = this._filePointer;
            long j3 = j2 - this._bufferCount;
            if (j >= j3 && j < j2) {
                this._bufferPos = (int) (j - j3);
                return;
            }
            this._file.seek(j);
            this._bufferCount = 0;
            this._filePointer = this._file.getFilePointer();
            return;
        }
        throw new IOException("Seek offset must be greater than 0");
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        validateOpen();
        int i = this._bufferCount;
        int i2 = this._bufferPos;
        if (j <= i - i2) {
            this._bufferPos = (int) (i2 + j);
            return j;
        }
        long currentOffset = getCurrentOffset();
        long length = this._file.length();
        long j2 = j + currentOffset;
        if (j2 <= length) {
            length = j2;
        }
        seek(length);
        return length - currentOffset;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        validateOpen();
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return i2;
        }
        validateOpen();
        int i4 = 0;
        do {
            int readOnce = readOnce(bArr, i + i4, i2 - i4);
            if (readOnce <= 0) {
                return i4 == 0 ? readOnce : i4;
            }
            i4 += readOnce;
        } while (i4 < i2);
        return i4;
    }
}
