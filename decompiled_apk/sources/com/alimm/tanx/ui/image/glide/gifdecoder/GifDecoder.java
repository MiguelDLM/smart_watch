package com.alimm.tanx.ui.image.glide.gifdecoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GifDecoder {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG = "GifDecoder";
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;
    private int[] act;
    private BitmapProvider bitmapProvider;
    private byte[] data;
    private int framePointer;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    private final int[] pct = new int[256];
    private final byte[] block = new byte[256];
    private GifHeader header = new GifHeader();

    /* loaded from: classes.dex */
    public interface BitmapProvider {
        Bitmap obtain(int i, int i2, Bitmap.Config config);

        void release(Bitmap bitmap);
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.bitmapProvider = bitmapProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16, types: [short] */
    /* JADX WARN: Type inference failed for: r3v18 */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        short s;
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = this.header;
            i = gifHeader.width;
            i2 = gifHeader.height;
        } else {
            i = gifFrame.iw;
            i2 = gifFrame.ih;
        }
        int i4 = i * i2;
        byte[] bArr = this.mainPixels;
        if (bArr == null || bArr.length < i4) {
            this.mainPixels = new byte[i4];
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int read = read();
        int i5 = 1;
        int i6 = 1 << read;
        int i7 = i6 + 1;
        int i8 = i6 + 2;
        int i9 = read + 1;
        int i10 = (1 << i9) - 1;
        for (int i11 = 0; i11 < i6; i11++) {
            this.prefix[i11] = 0;
            this.suffix[i11] = (byte) i11;
        }
        int i12 = -1;
        int i13 = i9;
        int i14 = i8;
        int i15 = i10;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        while (true) {
            if (i16 >= i4) {
                break;
            }
            if (i17 == 0) {
                i17 = readBlock();
                if (i17 <= 0) {
                    this.status = 3;
                    break;
                }
                i19 = 0;
            }
            i18 += (this.block[i19] & 255) << i20;
            i20 += 8;
            i19 += i5;
            i17 += i12;
            int i25 = i22;
            int i26 = i14;
            int i27 = i13;
            int i28 = i24;
            while (i20 >= i27) {
                int i29 = i18 & i15;
                i18 >>= i27;
                i20 -= i27;
                if (i29 == i6) {
                    i27 = i9;
                    i26 = i8;
                    i15 = i10;
                    i28 = -1;
                } else {
                    if (i29 > i26) {
                        i3 = i9;
                        this.status = 3;
                    } else {
                        i3 = i9;
                        if (i29 != i7) {
                            int i30 = i7;
                            int i31 = i28;
                            if (i31 == -1) {
                                this.pixelStack[i23] = this.suffix[i29];
                                i23++;
                                i25 = i29;
                                i28 = i25;
                                i7 = i30;
                                i9 = i3;
                            } else {
                                if (i29 >= i26) {
                                    this.pixelStack[i23] = (byte) i25;
                                    s = i31;
                                    i23++;
                                } else {
                                    s = i29;
                                }
                                while (s >= i6) {
                                    this.pixelStack[i23] = this.suffix[s];
                                    s = this.prefix[s];
                                    i23++;
                                    i6 = i6;
                                }
                                int i32 = i6;
                                byte[] bArr2 = this.suffix;
                                i25 = bArr2[s] & 255;
                                int i33 = i23 + 1;
                                int i34 = i8;
                                byte b = (byte) i25;
                                this.pixelStack[i23] = b;
                                if (i26 < 4096) {
                                    this.prefix[i26] = (short) i31;
                                    bArr2[i26] = b;
                                    i26++;
                                    if ((i26 & i15) == 0 && i26 < 4096) {
                                        i27++;
                                        i15 += i26;
                                    }
                                }
                                i23 = i33;
                                while (i23 > 0) {
                                    i23--;
                                    this.mainPixels[i21] = this.pixelStack[i23];
                                    i16++;
                                    i21++;
                                }
                                i28 = i29;
                                i7 = i30;
                                i9 = i3;
                                i6 = i32;
                                i8 = i34;
                            }
                        }
                    }
                    i22 = i25;
                    i14 = i26;
                    i13 = i27;
                    i9 = i3;
                    i24 = i28;
                    i5 = 1;
                    i12 = -1;
                    break;
                }
            }
            i22 = i25;
            i14 = i26;
            i13 = i27;
            i5 = 1;
            i12 = -1;
            i24 = i28;
            i9 = i9;
        }
        for (int i35 = i21; i35 < i4; i35++) {
            this.mainPixels[i35] = 0;
        }
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        BitmapProvider bitmapProvider = this.bitmapProvider;
        GifHeader gifHeader = this.header;
        int i = gifHeader.width;
        int i2 = gifHeader.height;
        Bitmap.Config config = BITMAP_CONFIG;
        Bitmap obtain = bitmapProvider.obtain(i, i2, config);
        if (obtain == null) {
            GifHeader gifHeader2 = this.header;
            obtain = Bitmap.createBitmap(gifHeader2.width, gifHeader2.height, config);
        }
        setAlpha(obtain);
        return obtain;
    }

    private int readBlock() {
        int read = read();
        int i = 0;
        if (read > 0) {
            while (i < read) {
                int i2 = read - i;
                try {
                    this.rawData.get(this.block, i, i2);
                    i += i2;
                } catch (Exception e) {
                    Log.w(TAG, "Error Reading Block", e);
                    this.status = 1;
                }
            }
        }
        return i;
    }

    @TargetApi(12)
    private static void setAlpha(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r4.bgIndex == r17.transIndex) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc A[EDGE_INSN: B:59:0x00bc->B:60:0x00bc BREAK  A[LOOP:2: B:29:0x0067->B:56:0x00b7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap setPixels(com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame r17, com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame r18) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.setPixels(com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame, com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame):android.graphics.Bitmap");
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDelay(int i) {
        if (i >= 0) {
            GifHeader gifHeader = this.header;
            if (i < gifHeader.frameCount) {
                return gifHeader.frames.get(i).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    @Deprecated
    public int getLoopCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getNextDelay() {
        int i;
        if (this.header.frameCount > 0 && (i = this.framePointer) >= 0) {
            return getDelay(i);
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0039, B:13:0x0042, B:15:0x0056, B:16:0x0062, B:19:0x006b, B:21:0x006f, B:23:0x0077, B:24:0x007c, B:28:0x0080, B:30:0x0084, B:31:0x0092, B:34:0x0067, B:36:0x0098, B:38:0x00a0, B:41:0x0011, B:43:0x0019, B:44:0x0037), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0039, B:13:0x0042, B:15:0x0056, B:16:0x0062, B:19:0x006b, B:21:0x006f, B:23:0x0077, B:24:0x007c, B:28:0x0080, B:30:0x0084, B:31:0x0092, B:34:0x0067, B:36:0x0098, B:38:0x00a0, B:41:0x0011, B:43:0x0019, B:44:0x0037), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080 A[Catch: all -> 0x000e, TRY_ENTER, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0039, B:13:0x0042, B:15:0x0056, B:16:0x0062, B:19:0x006b, B:21:0x006f, B:23:0x0077, B:24:0x007c, B:28:0x0080, B:30:0x0084, B:31:0x0092, B:34:0x0067, B:36:0x0098, B:38:0x00a0, B:41:0x0011, B:43:0x0019, B:44:0x0037), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0039, B:13:0x0042, B:15:0x0056, B:16:0x0062, B:19:0x006b, B:21:0x006f, B:23:0x0077, B:24:0x007c, B:28:0x0080, B:30:0x0084, B:31:0x0092, B:34:0x0067, B:36:0x0098, B:38:0x00a0, B:41:0x0011, B:43:0x0019, B:44:0x0037), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0 A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0039, B:13:0x0042, B:15:0x0056, B:16:0x0062, B:19:0x006b, B:21:0x006f, B:23:0x0077, B:24:0x007c, B:28:0x0080, B:30:0x0084, B:31:0x0092, B:34:0x0067, B:36:0x0098, B:38:0x00a0, B:41:0x0011, B:43:0x0019, B:44:0x0037), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized android.graphics.Bitmap getNextFrame() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r0 = r7.header     // Catch: java.lang.Throwable -> Le
            int r0 = r0.frameCount     // Catch: java.lang.Throwable -> Le
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L11
            int r0 = r7.framePointer     // Catch: java.lang.Throwable -> Le
            if (r0 >= 0) goto L39
            goto L11
        Le:
            r0 = move-exception
            goto Lb4
        L11:
            java.lang.String r0 = com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.TAG     // Catch: java.lang.Throwable -> Le
            boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            if (r3 == 0) goto L37
            java.lang.String r3 = "unable to decode frame, frameCount="
            java.lang.StringBuilder r3 = oOxxXI.oIX0oI.oIX0oI(r3)     // Catch: java.lang.Throwable -> Le
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r4 = r7.header     // Catch: java.lang.Throwable -> Le
            int r4 = r4.frameCount     // Catch: java.lang.Throwable -> Le
            r3.append(r4)     // Catch: java.lang.Throwable -> Le
            java.lang.String r4 = " framePointer="
            r3.append(r4)     // Catch: java.lang.Throwable -> Le
            int r4 = r7.framePointer     // Catch: java.lang.Throwable -> Le
            r3.append(r4)     // Catch: java.lang.Throwable -> Le
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Le
            android.util.Log.d(r0, r3)     // Catch: java.lang.Throwable -> Le
        L37:
            r7.status = r2     // Catch: java.lang.Throwable -> Le
        L39:
            int r0 = r7.status     // Catch: java.lang.Throwable -> Le
            r3 = 0
            if (r0 == r2) goto L98
            r4 = 2
            if (r0 != r4) goto L42
            goto L98
        L42:
            r0 = 0
            r7.status = r0     // Catch: java.lang.Throwable -> Le
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r4 = r7.header     // Catch: java.lang.Throwable -> Le
            java.util.List<com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame> r4 = r4.frames     // Catch: java.lang.Throwable -> Le
            int r5 = r7.framePointer     // Catch: java.lang.Throwable -> Le
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> Le
            com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame r4 = (com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame) r4     // Catch: java.lang.Throwable -> Le
            int r5 = r7.framePointer     // Catch: java.lang.Throwable -> Le
            int r5 = r5 - r2
            if (r5 < 0) goto L61
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r6 = r7.header     // Catch: java.lang.Throwable -> Le
            java.util.List<com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame> r6 = r6.frames     // Catch: java.lang.Throwable -> Le
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Throwable -> Le
            com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame r5 = (com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame) r5     // Catch: java.lang.Throwable -> Le
            goto L62
        L61:
            r5 = r3
        L62:
            int[] r6 = r4.lct     // Catch: java.lang.Throwable -> Le
            if (r6 == 0) goto L67
            goto L6b
        L67:
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r6 = r7.header     // Catch: java.lang.Throwable -> Le
            int[] r6 = r6.gct     // Catch: java.lang.Throwable -> Le
        L6b:
            r7.act = r6     // Catch: java.lang.Throwable -> Le
            if (r6 != 0) goto L80
            java.lang.String r0 = com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.TAG     // Catch: java.lang.Throwable -> Le
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L7c
            java.lang.String r1 = "No Valid Color Table"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> Le
        L7c:
            r7.status = r2     // Catch: java.lang.Throwable -> Le
            monitor-exit(r7)
            return r3
        L80:
            boolean r1 = r4.transparency     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L92
            int[] r1 = r7.pct     // Catch: java.lang.Throwable -> Le
            int r2 = r6.length     // Catch: java.lang.Throwable -> Le
            java.lang.System.arraycopy(r6, r0, r1, r0, r2)     // Catch: java.lang.Throwable -> Le
            int[] r1 = r7.pct     // Catch: java.lang.Throwable -> Le
            r7.act = r1     // Catch: java.lang.Throwable -> Le
            int r2 = r4.transIndex     // Catch: java.lang.Throwable -> Le
            r1[r2] = r0     // Catch: java.lang.Throwable -> Le
        L92:
            android.graphics.Bitmap r0 = r7.setPixels(r4, r5)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r7)
            return r0
        L98:
            java.lang.String r0 = com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.TAG     // Catch: java.lang.Throwable -> Le
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto Lb2
            java.lang.String r1 = "Unable to decode frame, status="
            java.lang.StringBuilder r1 = oOxxXI.oIX0oI.oIX0oI(r1)     // Catch: java.lang.Throwable -> Le
            int r2 = r7.status     // Catch: java.lang.Throwable -> Le
            r1.append(r2)     // Catch: java.lang.Throwable -> Le
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Le
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> Le
        Lb2:
            monitor-exit(r7)
            return r3
        Lb4:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Le
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.getNextFrame():android.graphics.Bitmap");
    }

    public int getStatus() {
        return this.status;
    }

    public int getTotalIterationCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(TAG, "Error closing stream", e2);
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        this.header = gifHeader;
        this.data = bArr;
        this.status = 0;
        this.framePointer = -1;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.rawData = wrap;
        wrap.rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        Iterator<GifFrame> it = gifHeader.frames.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        int i = gifHeader.width * gifHeader.height;
        this.mainPixels = new byte[i];
        this.mainScratch = new int[i];
    }

    public int read(byte[] bArr) {
        this.data = bArr;
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.rawData = wrap;
            wrap.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            GifHeader gifHeader = this.header;
            int i = gifHeader.width * gifHeader.height;
            this.mainPixels = new byte[i];
            this.mainScratch = new int[i];
            this.savePrevious = false;
            Iterator<GifFrame> it = gifHeader.frames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
        }
        return this.status;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }
}
