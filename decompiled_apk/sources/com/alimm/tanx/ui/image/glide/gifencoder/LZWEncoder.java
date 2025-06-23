package com.alimm.tanx.ui.image.glide.gifencoder;

import com.garmin.fit.OOxOOxIO;
import com.garmin.fit.xxXXXxIxo;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
class LZWEncoder {
    static final int BITS = 12;
    private static final int EOF = -1;
    static final int HSIZE = 5003;
    int ClearCode;
    int EOFCode;
    int a_count;
    private int curPixel;
    int g_init_bits;
    private int imgH;
    private int imgW;
    private int initCodeSize;
    int maxcode;
    int n_bits;
    private byte[] pixAry;
    private int remaining;
    int maxbits = 12;
    int maxmaxcode = 4096;
    int[] htab = new int[5003];
    int[] codetab = new int[5003];
    int hsize = 5003;
    int free_ent = 0;
    boolean clear_flg = false;
    int cur_accum = 0;
    int cur_bits = 0;
    int[] masks = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, xxXXXxIxo.f15726I0Io, 8191, OOxOOxIO.f12624oIX0oI, 32767, 65535};
    byte[] accum = new byte[256];

    public LZWEncoder(int i, int i2, byte[] bArr, int i3) {
        this.imgW = i;
        this.imgH = i2;
        this.pixAry = bArr;
        this.initCodeSize = Math.max(2, i3);
    }

    private int nextPixel() {
        int i = this.remaining;
        if (i == 0) {
            return -1;
        }
        this.remaining = i - 1;
        byte[] bArr = this.pixAry;
        int i2 = this.curPixel;
        this.curPixel = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int MAXCODE(int i) {
        return (1 << i) - 1;
    }

    public void char_out(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.accum;
        int i = this.a_count;
        int i2 = i + 1;
        this.a_count = i2;
        bArr[i] = b;
        if (i2 >= 254) {
            flush_char(outputStream);
        }
    }

    public void cl_block(OutputStream outputStream) throws IOException {
        cl_hash(this.hsize);
        int i = this.ClearCode;
        this.free_ent = i + 2;
        this.clear_flg = true;
        output(i, outputStream);
    }

    public void cl_hash(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.htab[i2] = -1;
        }
    }

    public void compress(int i, OutputStream outputStream) throws IOException {
        int i2;
        this.g_init_bits = i;
        int i3 = 0;
        this.clear_flg = false;
        this.n_bits = i;
        this.maxcode = MAXCODE(i);
        int i4 = 1 << (i - 1);
        this.ClearCode = i4;
        this.EOFCode = i4 + 1;
        this.free_ent = i4 + 2;
        this.a_count = 0;
        int nextPixel = nextPixel();
        for (int i5 = this.hsize; i5 < 65536; i5 *= 2) {
            i3++;
        }
        int i6 = 8 - i3;
        int i7 = this.hsize;
        cl_hash(i7);
        output(this.ClearCode, outputStream);
        while (true) {
            int nextPixel2 = nextPixel();
            if (nextPixel2 != -1) {
                int i8 = (nextPixel2 << this.maxbits) + nextPixel;
                int i9 = (nextPixel2 << i6) ^ nextPixel;
                int i10 = this.htab[i9];
                if (i10 == i8) {
                    nextPixel = this.codetab[i9];
                } else {
                    if (i10 >= 0) {
                        int i11 = i7 - i9;
                        if (i9 == 0) {
                            i11 = 1;
                        }
                        do {
                            i9 -= i11;
                            if (i9 < 0) {
                                i9 += i7;
                            }
                            i2 = this.htab[i9];
                            if (i2 == i8) {
                                nextPixel = this.codetab[i9];
                                break;
                            }
                        } while (i2 >= 0);
                    }
                    output(nextPixel, outputStream);
                    int i12 = this.free_ent;
                    if (i12 < this.maxmaxcode) {
                        int[] iArr = this.codetab;
                        this.free_ent = i12 + 1;
                        iArr[i9] = i12;
                        this.htab[i9] = i8;
                    } else {
                        cl_block(outputStream);
                    }
                    nextPixel = nextPixel2;
                }
            } else {
                output(nextPixel, outputStream);
                output(this.EOFCode, outputStream);
                return;
            }
        }
    }

    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.initCodeSize);
        this.remaining = this.imgW * this.imgH;
        this.curPixel = 0;
        compress(this.initCodeSize + 1, outputStream);
        outputStream.write(0);
    }

    public void flush_char(OutputStream outputStream) throws IOException {
        int i = this.a_count;
        if (i > 0) {
            outputStream.write(i);
            outputStream.write(this.accum, 0, this.a_count);
            this.a_count = 0;
        }
    }

    public void output(int i, OutputStream outputStream) throws IOException {
        int i2 = this.cur_accum;
        int[] iArr = this.masks;
        int i3 = this.cur_bits;
        int i4 = i2 & iArr[i3];
        this.cur_accum = i4;
        if (i3 > 0) {
            this.cur_accum = i4 | (i << i3);
        } else {
            this.cur_accum = i;
        }
        this.cur_bits = i3 + this.n_bits;
        while (this.cur_bits >= 8) {
            char_out((byte) (this.cur_accum & 255), outputStream);
            this.cur_accum >>= 8;
            this.cur_bits -= 8;
        }
        if (this.free_ent > this.maxcode || this.clear_flg) {
            if (this.clear_flg) {
                int i5 = this.g_init_bits;
                this.n_bits = i5;
                this.maxcode = MAXCODE(i5);
                this.clear_flg = false;
            } else {
                int i6 = this.n_bits + 1;
                this.n_bits = i6;
                if (i6 == this.maxbits) {
                    this.maxcode = this.maxmaxcode;
                } else {
                    this.maxcode = MAXCODE(i6);
                }
            }
        }
        if (i == this.EOFCode) {
            while (this.cur_bits > 0) {
                char_out((byte) (this.cur_accum & 255), outputStream);
                this.cur_accum >>= 8;
                this.cur_bits -= 8;
            }
            flush_char(outputStream);
        }
    }
}
