package com.alimm.tanx.ui.image.glide.gifencoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import com.garmin.fit.X0xOO;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class AnimatedGifEncoder {
    private static final double MIN_TRANSPARENT_PERCENTAGE = 4.0d;
    private static final String TAG = "AnimatedGifEncoder";
    private int colorDepth;
    private byte[] colorTab;
    private boolean hasTransparentPixels;
    private int height;
    private Bitmap image;
    private byte[] indexedPixels;
    private OutputStream out;
    private byte[] pixels;
    private int transIndex;
    private int width;
    private Integer transparent = null;
    private int repeat = -1;
    private int delay = 0;
    private boolean started = false;
    private boolean[] usedEntry = new boolean[256];
    private int palSize = 7;
    private int dispose = -1;
    private boolean closeStream = false;
    private boolean firstFrame = true;
    private boolean sizeSet = false;
    private int sample = 10;

    private void analyzePixels() {
        byte[] bArr = this.pixels;
        int length = bArr.length;
        int i = length / 3;
        this.indexedPixels = new byte[i];
        NeuQuant neuQuant = new NeuQuant(bArr, length, this.sample);
        this.colorTab = neuQuant.process();
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.colorTab;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b = bArr2[i2];
            int i3 = i2 + 2;
            bArr2[i2] = bArr2[i3];
            bArr2[i3] = b;
            this.usedEntry[i2 / 3] = false;
            i2 += 3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            byte[] bArr3 = this.pixels;
            int i6 = bArr3[i4] & 255;
            int i7 = i4 + 2;
            int i8 = bArr3[i4 + 1] & 255;
            i4 += 3;
            int map = neuQuant.map(i6, i8, bArr3[i7] & 255);
            this.usedEntry[map] = true;
            this.indexedPixels[i5] = (byte) map;
        }
        this.pixels = null;
        this.colorDepth = 8;
        this.palSize = 7;
        Integer num = this.transparent;
        if (num != null) {
            this.transIndex = findClosest(num.intValue());
        } else if (this.hasTransparentPixels) {
            this.transIndex = findClosest(0);
        }
    }

    private int findClosest(int i) {
        if (this.colorTab == null) {
            return -1;
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int length = this.colorTab.length;
        int i2 = 0;
        int i3 = 16777216;
        for (int i4 = 0; i4 < length; i4 += 3) {
            byte[] bArr = this.colorTab;
            int i5 = red - (bArr[i4] & 255);
            int i6 = i4 + 2;
            int i7 = green - (bArr[i4 + 1] & 255);
            int i8 = blue - (bArr[i6] & 255);
            int i9 = i8 * i8;
            int i10 = i9 + (i7 * i7) + (i5 * i5);
            int i11 = i6 / 3;
            if (this.usedEntry[i11] && i10 < i3) {
                i3 = i10;
                i2 = i11;
            }
        }
        return i2;
    }

    private void getImagePixels() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        int i = this.width;
        if (width != i || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(i, this.height, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
            this.image = createBitmap;
        }
        int i2 = width * height;
        int[] iArr = new int[i2];
        this.image.getPixels(iArr, 0, width, 0, 0, width, height);
        this.pixels = new byte[i2 * 3];
        boolean z = false;
        this.hasTransparentPixels = false;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = iArr[i5];
            if (i6 == 0) {
                i3++;
            }
            byte[] bArr = this.pixels;
            bArr[i4] = (byte) (i6 & 255);
            int i7 = i4 + 2;
            bArr[i4 + 1] = (byte) ((i6 >> 8) & 255);
            i4 += 3;
            bArr[i7] = (byte) ((i6 >> 16) & 255);
        }
        double d = (i3 * 100) / i2;
        if (d > 4.0d) {
            z = true;
        }
        this.hasTransparentPixels = z;
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "got pixels for frame with " + d + "% transparent pixels");
        }
    }

    private void writeGraphicCtrlExt() throws IOException {
        int i;
        int i2;
        this.out.write(33);
        this.out.write(249);
        this.out.write(4);
        if (this.transparent == null && !this.hasTransparentPixels) {
            i = 0;
            i2 = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        int i3 = this.dispose;
        if (i3 >= 0) {
            i2 = i3 & 7;
        }
        this.out.write(i | (i2 << 2));
        writeShort(this.delay);
        this.out.write(this.transIndex);
        this.out.write(0);
    }

    private void writeImageDesc() throws IOException {
        this.out.write(44);
        writeShort(0);
        writeShort(0);
        writeShort(this.width);
        writeShort(this.height);
        if (this.firstFrame) {
            this.out.write(0);
        } else {
            this.out.write(this.palSize | 128);
        }
    }

    private void writeLSD() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.palSize | 240);
        this.out.write(0);
        this.out.write(0);
    }

    private void writeNetscapeExt() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.repeat);
        this.out.write(0);
    }

    private void writePalette() throws IOException {
        OutputStream outputStream = this.out;
        byte[] bArr = this.colorTab;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.colorTab.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    private void writePixels() throws IOException {
        new LZWEncoder(this.width, this.height, this.indexedPixels, this.colorDepth).encode(this.out);
    }

    private void writeShort(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
    }

    private void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.out.write((byte) str.charAt(i));
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public boolean addFrame(android.graphics.Bitmap r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L43
            boolean r1 = r3.started
            if (r1 != 0) goto L8
            goto L43
        L8:
            boolean r1 = r3.sizeSet     // Catch: java.io.IOException -> L43
            if (r1 != 0) goto L17
            int r1 = r4.getWidth()     // Catch: java.io.IOException -> L43
            int r2 = r4.getHeight()     // Catch: java.io.IOException -> L43
            r3.setSize(r1, r2)     // Catch: java.io.IOException -> L43
        L17:
            r3.image = r4     // Catch: java.io.IOException -> L43
            r3.getImagePixels()     // Catch: java.io.IOException -> L43
            r3.analyzePixels()     // Catch: java.io.IOException -> L43
            boolean r4 = r3.firstFrame     // Catch: java.io.IOException -> L43
            if (r4 == 0) goto L30
            r3.writeLSD()     // Catch: java.io.IOException -> L43
            r3.writePalette()     // Catch: java.io.IOException -> L43
            int r4 = r3.repeat     // Catch: java.io.IOException -> L43
            if (r4 < 0) goto L30
            r3.writeNetscapeExt()     // Catch: java.io.IOException -> L43
        L30:
            r3.writeGraphicCtrlExt()     // Catch: java.io.IOException -> L43
            r3.writeImageDesc()     // Catch: java.io.IOException -> L43
            boolean r4 = r3.firstFrame     // Catch: java.io.IOException -> L43
            if (r4 != 0) goto L3d
            r3.writePalette()     // Catch: java.io.IOException -> L43
        L3d:
            r3.writePixels()     // Catch: java.io.IOException -> L43
            r3.firstFrame = r0     // Catch: java.io.IOException -> L43
            r0 = 1
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.gifencoder.AnimatedGifEncoder.addFrame(android.graphics.Bitmap):boolean");
    }

    public boolean finish() {
        boolean z;
        if (!this.started) {
            return false;
        }
        this.started = false;
        try {
            this.out.write(59);
            this.out.flush();
            if (this.closeStream) {
                this.out.close();
            }
            z = true;
        } catch (IOException unused) {
            z = false;
        }
        this.transIndex = 0;
        this.out = null;
        this.image = null;
        this.pixels = null;
        this.indexedPixels = null;
        this.colorTab = null;
        this.closeStream = false;
        this.firstFrame = true;
        return z;
    }

    public void setDelay(int i) {
        this.delay = Math.round(i / 10.0f);
    }

    public void setDispose(int i) {
        if (i >= 0) {
            this.dispose = i;
        }
    }

    public void setFrameRate(float f) {
        if (f != 0.0f) {
            this.delay = Math.round(100.0f / f);
        }
    }

    public void setQuality(int i) {
        if (i < 1) {
            i = 1;
        }
        this.sample = i;
    }

    public void setRepeat(int i) {
        if (i >= 0) {
            this.repeat = i;
        }
    }

    public void setSize(int i, int i2) {
        if (this.started && !this.firstFrame) {
            return;
        }
        this.width = i;
        this.height = i2;
        if (i < 1) {
            this.width = X0xOO.f13583O0o0;
        }
        if (i2 < 1) {
            this.height = 240;
        }
        this.sizeSet = true;
    }

    public void setTransparent(int i) {
        this.transparent = Integer.valueOf(i);
    }

    public boolean start(OutputStream outputStream) {
        boolean z = false;
        if (outputStream == null) {
            return false;
        }
        this.closeStream = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
            z = true;
        } catch (IOException unused) {
        }
        this.started = z;
        return z;
    }

    public boolean start(String str) {
        boolean z;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            this.out = bufferedOutputStream;
            z = start(bufferedOutputStream);
            this.closeStream = true;
        } catch (IOException unused) {
            z = false;
        }
        this.started = z;
        return z;
    }
}
