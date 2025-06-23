package com.alimm.tanx.ui.image.glide.gifdecoder;

import android.util.Log;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import oOxxXI.oIX0oI;

/* loaded from: classes.dex */
public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 3;
    public static final String TAG = "GifHeaderParser";
    private final byte[] block = new byte[256];
    private int blockSize = 0;
    private GifHeader header;
    private ByteBuffer rawData;

    private boolean err() {
        if (this.header.status != 0) {
            return true;
        }
        return false;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    private void readBitmap() {
        boolean z;
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int read = read();
        boolean z2 = false;
        if ((read & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        int pow = (int) Math.pow(2.0d, (read & 7) + 1);
        GifFrame gifFrame = this.header.currentFrame;
        if ((read & 64) != 0) {
            z2 = true;
        }
        gifFrame.interlace = z2;
        if (z) {
            gifFrame.lct = readColorTable(pow);
        } else {
            gifFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (err()) {
            return;
        }
        GifHeader gifHeader = this.header;
        gifHeader.frameCount++;
        gifHeader.frames.add(gifHeader.currentFrame);
    }

    private int readBlock() {
        int read = read();
        this.blockSize = read;
        int i = 0;
        if (read > 0) {
            int i2 = 0;
            while (true) {
                try {
                    i2 = this.blockSize;
                    if (i >= i2) {
                        break;
                    }
                    i2 -= i;
                    this.rawData.get(this.block, i, i2);
                    i += i2;
                } catch (Exception e) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.blockSize, e);
                    }
                    this.header.status = 1;
                }
            }
        }
        return i;
    }

    private int[] readColorTable(int i) {
        int[] iArr;
        byte[] bArr = new byte[i * 3];
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = bArr[i3] & 255;
                    int i6 = i3 + 2;
                    int i7 = bArr[i4] & 255;
                    i3 += 3;
                    int i8 = i2 + 1;
                    iArr[i2] = (i7 << 8) | (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (bArr[i6] & 255);
                    i2 = i8;
                } catch (BufferUnderflowException e) {
                    e = e;
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Format Error Reading Color Table", e);
                    }
                    this.header.status = 1;
                    return iArr;
                }
            }
        } catch (BufferUnderflowException e2) {
            e = e2;
            iArr = null;
        }
        return iArr;
    }

    private void readContents() {
        boolean z = false;
        while (!z && !err()) {
            int read = read();
            if (read != 33) {
                if (read != 44) {
                    if (read != 59) {
                        this.header.status = 1;
                    } else {
                        z = true;
                    }
                } else {
                    GifHeader gifHeader = this.header;
                    if (gifHeader.currentFrame == null) {
                        gifHeader.currentFrame = new GifFrame();
                    }
                    readBitmap();
                }
            } else {
                int read2 = read();
                if (read2 != 1) {
                    if (read2 != 249) {
                        if (read2 != 254) {
                            if (read2 != 255) {
                                skip();
                            } else {
                                readBlock();
                                String str = "";
                                for (int i = 0; i < 11; i++) {
                                    StringBuilder oIX0oI2 = oIX0oI.oIX0oI(str);
                                    oIX0oI2.append((char) this.block[i]);
                                    str = oIX0oI2.toString();
                                }
                                if (str.equals("NETSCAPE2.0")) {
                                    readNetscapeExt();
                                } else {
                                    skip();
                                }
                            }
                        } else {
                            skip();
                        }
                    } else {
                        this.header.currentFrame = new GifFrame();
                        readGraphicControlExt();
                    }
                } else {
                    skip();
                }
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        GifFrame gifFrame = this.header.currentFrame;
        int i = (read & 28) >> 2;
        gifFrame.dispose = i;
        boolean z = true;
        if (i == 0) {
            gifFrame.dispose = 1;
        }
        if ((read & 1) == 0) {
            z = false;
        }
        gifFrame.transparency = z;
        int readShort = readShort();
        if (readShort < 3) {
            readShort = 10;
        }
        GifFrame gifFrame2 = this.header.currentFrame;
        gifFrame2.delay = readShort * 10;
        gifFrame2.transIndex = read();
        read();
    }

    private void readHeader() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            StringBuilder oIX0oI2 = oIX0oI.oIX0oI(str);
            oIX0oI2.append((char) read());
            str = oIX0oI2.toString();
        }
        if (!str.startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (this.header.gctFlag && !err()) {
            GifHeader gifHeader = this.header;
            gifHeader.gct = readColorTable(gifHeader.gctSize);
            GifHeader gifHeader2 = this.header;
            gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
        }
    }

    private void readLSD() {
        boolean z;
        this.header.width = readShort();
        this.header.height = readShort();
        int read = read();
        GifHeader gifHeader = this.header;
        if ((read & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        gifHeader.gctFlag = z;
        gifHeader.gctSize = 2 << (read & 7);
        gifHeader.bgIndex = read();
        this.header.pixelAspect = read();
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.header.loopCount = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    private void skip() {
        int read;
        do {
            read = read();
            ByteBuffer byteBuffer = this.rawData;
            byteBuffer.position(byteBuffer.position() + read);
        } while (read > 0);
    }

    private void skipImageData() {
        read();
        skip();
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    public GifHeader parseHeader() {
        if (this.rawData != null) {
            if (err()) {
                return this.header;
            }
            readHeader();
            if (!err()) {
                readContents();
                GifHeader gifHeader = this.header;
                if (gifHeader.frameCount < 0) {
                    gifHeader.status = 1;
                }
            }
            return this.header;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public GifHeaderParser setData(byte[] bArr) {
        reset();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.rawData = wrap;
            wrap.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }
}
