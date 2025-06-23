package com.kwad.sdk.core.diskcache.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes11.dex */
public final class b implements Closeable {
    private final Charset avr;
    private byte[] buf;
    private int end;
    private final InputStream in;
    private int pos;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void DL() {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.pos = 0;
            this.end = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.in) {
            try {
                if (this.buf != null) {
                    this.buf = null;
                    com.kwad.sdk.crash.utils.b.closeQuietly(this.in);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String readLine() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.in) {
            try {
                if (this.buf != null) {
                    if (this.pos >= this.end) {
                        DL();
                    }
                    for (int i3 = this.pos; i3 != this.end; i3++) {
                        byte[] bArr2 = this.buf;
                        if (bArr2[i3] == 10) {
                            int i4 = this.pos;
                            if (i3 != i4) {
                                i2 = i3 - 1;
                                if (bArr2[i2] == 13) {
                                    String str = new String(bArr2, i4, i2 - i4, this.avr.name());
                                    this.pos = i3 + 1;
                                    return str;
                                }
                            }
                            i2 = i3;
                            String str2 = new String(bArr2, i4, i2 - i4, this.avr.name());
                            this.pos = i3 + 1;
                            return str2;
                        }
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                        @Override // java.io.ByteArrayOutputStream
                        public final String toString() {
                            int i5 = ((ByteArrayOutputStream) this).count;
                            if (i5 > 0 && ((ByteArrayOutputStream) this).buf[i5 - 1] == 13) {
                                i5--;
                            }
                            try {
                                return new String(((ByteArrayOutputStream) this).buf, 0, i5, b.this.avr.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1: while (true) {
                        byte[] bArr3 = this.buf;
                        int i5 = this.pos;
                        byteArrayOutputStream.write(bArr3, i5, this.end - i5);
                        this.end = -1;
                        DL();
                        i = this.pos;
                        while (i != this.end) {
                            bArr = this.buf;
                            if (bArr[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    int i6 = this.pos;
                    if (i != i6) {
                        byteArrayOutputStream.write(bArr, i6, i - i6);
                    }
                    this.pos = i + 1;
                    return byteArrayOutputStream.toString();
                }
                throw new IOException("LineReader is closed");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private b(InputStream inputStream, int i, Charset charset) {
        if (inputStream != null && charset != null) {
            if (charset.equals(com.kwad.sdk.crash.utils.a.US_ASCII)) {
                this.in = inputStream;
                this.avr = charset;
                this.buf = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }
}
