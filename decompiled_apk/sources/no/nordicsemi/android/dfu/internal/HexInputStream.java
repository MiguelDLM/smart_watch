package no.nordicsemi.android.dfu.internal;

import androidx.annotation.NonNull;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;

/* loaded from: classes6.dex */
public class HexInputStream extends FilterInputStream {
    private final int LINE_LENGTH;
    private final int MBRSize;
    private final int available;
    private int bytesRead;
    private int lastAddress;
    private final byte[] localBuf;
    private int localPos;
    private int pos;
    private int size;

    public HexInputStream(@NonNull InputStream inputStream, int i) throws HexFileValidationException, IOException {
        super(new BufferedInputStream(inputStream));
        this.LINE_LENGTH = 128;
        byte[] bArr = new byte[128];
        this.localBuf = bArr;
        this.localPos = 128;
        this.size = bArr.length;
        this.lastAddress = 0;
        this.MBRSize = i;
        this.available = calculateBinSize(i);
    }

    private int asciiToInt(int i) {
        if (i >= 65) {
            return i - 55;
        }
        if (i >= 48) {
            return i - 48;
        }
        return -1;
    }

    private int calculateBinSize(int i) throws HexFileValidationException, IOException {
        int readAddress;
        InputStream inputStream = ((FilterInputStream) this).in;
        inputStream.mark(inputStream.available());
        try {
            int read = inputStream.read();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                checkComma(read);
                int readByte = readByte(inputStream);
                int readAddress2 = readAddress(inputStream);
                int readByte2 = readByte(inputStream);
                if (readByte2 != 0) {
                    if (readByte2 != 1) {
                        if (readByte2 != 2) {
                            if (readByte2 == 4) {
                                int readAddress3 = readAddress(inputStream);
                                if (i3 > 0 && readAddress3 != (i2 >> 16) + 1) {
                                    inputStream.reset();
                                    return i3;
                                }
                                readAddress = readAddress3 << 16;
                                skip(inputStream, 2L);
                            }
                        } else {
                            readAddress = readAddress(inputStream) << 4;
                            if (i3 > 0 && (readAddress >> 16) != (i2 >> 16) + 1) {
                                inputStream.reset();
                                return i3;
                            }
                            skip(inputStream, 2L);
                        }
                        i2 = readAddress;
                        while (true) {
                            read = inputStream.read();
                            if (read != 10 || read == 13) {
                            }
                        }
                    } else {
                        inputStream.reset();
                        return i3;
                    }
                } else if (readAddress2 + i2 >= i) {
                    i3 += readByte;
                }
                skip(inputStream, (readByte * 2) + 2);
                while (true) {
                    read = inputStream.read();
                    if (read != 10) {
                    }
                }
            }
        } catch (Throwable th) {
            inputStream.reset();
            throw th;
        }
    }

    private void checkComma(int i) throws HexFileValidationException {
        if (i == 58) {
        } else {
            throw new HexFileValidationException("Not a HEX file");
        }
    }

    private int readAddress(@NonNull InputStream inputStream) throws IOException {
        return readByte(inputStream) | (readByte(inputStream) << 8);
    }

    private int readByte(@NonNull InputStream inputStream) throws IOException {
        return asciiToInt(inputStream.read()) | (asciiToInt(inputStream.read()) << 4);
    }

    private int readLine() throws IOException {
        if (this.pos == -1) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        while (true) {
            int read = inputStream.read();
            this.pos++;
            if (read != 10 && read != 13) {
                checkComma(read);
                int readByte = readByte(inputStream);
                this.pos += 2;
                int readAddress = readAddress(inputStream);
                this.pos += 4;
                int readByte2 = readByte(inputStream);
                int i = this.pos + 2;
                this.pos = i;
                if (readByte2 != 0) {
                    if (readByte2 != 1) {
                        if (readByte2 != 2) {
                            if (readByte2 != 4) {
                                this.pos = (int) (i + skip(inputStream, (readByte * 2) + 2));
                            } else {
                                int readAddress2 = readAddress(inputStream);
                                int i2 = this.pos + 4;
                                this.pos = i2;
                                if (this.bytesRead > 0 && readAddress2 != (this.lastAddress >> 16) + 1) {
                                    return 0;
                                }
                                this.lastAddress = readAddress2 << 16;
                                this.pos = (int) (i2 + skip(inputStream, 2L));
                            }
                        } else {
                            int readAddress3 = readAddress(inputStream) << 4;
                            int i3 = this.pos + 4;
                            this.pos = i3;
                            if (this.bytesRead > 0 && (readAddress3 >> 16) != (this.lastAddress >> 16) + 1) {
                                return 0;
                            }
                            this.lastAddress = readAddress3;
                            this.pos = (int) (i3 + skip(inputStream, 2L));
                        }
                    } else {
                        this.pos = -1;
                        return 0;
                    }
                } else if (this.lastAddress + readAddress < this.MBRSize) {
                    this.pos = (int) (i + skip(inputStream, (readByte * 2) + 2));
                    readByte2 = -1;
                }
                if (readByte2 == 0) {
                    for (int i4 = 0; i4 < this.localBuf.length && i4 < readByte; i4++) {
                        int readByte3 = readByte(inputStream);
                        this.pos += 2;
                        this.localBuf[i4] = (byte) readByte3;
                    }
                    this.pos = (int) (this.pos + skip(inputStream, 2L));
                    this.localPos = 0;
                    return readByte;
                }
            }
        }
    }

    private long skip(@NonNull InputStream inputStream, long j) throws IOException {
        long skip = inputStream.skip(j);
        if (skip < j) {
            return skip + inputStream.skip(j - skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.available - this.bytesRead;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        try {
            super.mark(((FilterInputStream) this).in.available());
        } catch (IOException unused) {
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public int readPacket(@NonNull byte[] bArr) throws IOException {
        int i = 0;
        while (i < bArr.length) {
            int i2 = this.localPos;
            if (i2 < this.size) {
                byte[] bArr2 = this.localBuf;
                this.localPos = i2 + 1;
                bArr[i] = bArr2[i2];
                i++;
            } else {
                int i3 = this.bytesRead;
                int readLine = readLine();
                this.size = readLine;
                this.bytesRead = i3 + readLine;
                if (readLine == 0) {
                    break;
                }
            }
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.pos = 0;
        this.bytesRead = 0;
        this.localPos = 128;
    }

    public int sizeInBytes() {
        return this.available;
    }

    public int sizeInPackets(int i) {
        int i2;
        int sizeInBytes = sizeInBytes();
        int i3 = sizeInBytes / i;
        if (sizeInBytes % i > 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        return i3 + i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        return readPacket(bArr);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public HexInputStream(@NonNull byte[] bArr, int i) throws HexFileValidationException, IOException {
        super(new ByteArrayInputStream(bArr));
        this.LINE_LENGTH = 128;
        byte[] bArr2 = new byte[128];
        this.localBuf = bArr2;
        this.localPos = 128;
        this.size = bArr2.length;
        this.lastAddress = 0;
        this.MBRSize = i;
        this.available = calculateBinSize(i);
    }
}
