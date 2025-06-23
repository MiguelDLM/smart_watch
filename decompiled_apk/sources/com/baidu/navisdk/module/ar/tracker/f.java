package com.baidu.navisdk.module.ar.tracker;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    String f7003a;
    MediaCodec c;
    Surface d;
    MediaFormat e;
    long m;
    MediaExtractor b = new MediaExtractor();
    boolean f = false;
    boolean g = false;
    boolean h = false;
    int i = 0;
    int j = 0;
    boolean k = false;
    int l = 0;
    int n = 0;
    int o = 0;
    int p = 0;
    ByteBuffer q = null;
    long r = 0;
    int s = -1;

    public boolean a(String str, int i, Surface surface) {
        this.f7003a = str;
        this.d = surface;
        try {
            this.b.setDataSource(str);
            int a2 = a(this.b);
            if (a2 < 0) {
                return false;
            }
            this.b.selectTrack(a2);
            MediaFormat trackFormat = this.b.getTrackFormat(a2);
            this.e = trackFormat;
            this.c = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
            this.e.setInteger("color-format", 2135033992);
            this.e.setInteger("rotation-degrees", 0);
            this.g = false;
            this.h = false;
            this.i = this.e.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            this.j = this.e.getInteger("height");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int b() {
        return this.i;
    }

    public int c() {
        return this.j;
    }

    public boolean d() {
        if (this.g) {
            return false;
        }
        int dequeueInputBuffer = this.c.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer >= 0) {
            int readSampleData = this.b.readSampleData(this.c.getInputBuffers()[dequeueInputBuffer], 0);
            if (readSampleData < 0) {
                this.c.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                this.g = true;
            } else {
                this.c.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.b.getSampleTime(), 0);
                this.b.advance();
                this.n++;
            }
        }
        if (dequeueInputBuffer < 0) {
            return false;
        }
        return true;
    }

    public void e() {
        MediaCodec mediaCodec = this.c;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.c = null;
        }
        MediaExtractor mediaExtractor = this.b;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.b = null;
        }
    }

    public void f() {
        boolean z;
        if (!this.k) {
            if (this.d != null) {
                z = true;
            } else {
                z = false;
            }
            a(z);
            this.c.configure(this.e, this.d, (MediaCrypto) null, 0);
            this.c.start();
            this.n = 0;
            this.l = 0;
            this.q = null;
        }
        this.k = true;
    }

    public void g() {
        this.c.stop();
        this.k = false;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(long j) {
        MediaExtractor mediaExtractor = this.b;
        if (mediaExtractor != null) {
            mediaExtractor.seekTo(j * 1000, 2);
        }
    }

    private static int a(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            if (mediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/")) {
                return i;
            }
        }
        return -1;
    }

    public void a(Surface surface) {
        if (this.k) {
            this.c.stop();
        }
        this.d = surface;
        if (this.k) {
            a(surface != null);
            this.c.configure(this.e, this.d, (MediaCrypto) null, 0);
            this.c.start();
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        this.p = i3;
        this.o = i4;
        if (i4 == 0) {
            if (i3 == 0) {
                for (int i6 = 16; i6 <= 128; i6 <<= 1) {
                    for (int i7 = 16; i7 <= i6; i7 <<= 1) {
                        int i8 = (((i - 1) / i6) + 1) * i6;
                        this.p = i8;
                        int i9 = (((i2 - 1) / i7) + 1) * i7;
                        this.o = i9;
                        if (((i8 * i9) * 3) / 2 == i5) {
                            break;
                        }
                    }
                }
            } else {
                for (int i10 = 16; i10 <= 128; i10 <<= 1) {
                    int i11 = (((i2 - 1) / i10) + 1) * i10;
                    this.o = i11;
                    if (((this.p * i11) * 3) / 2 == i5) {
                        break;
                    }
                }
            }
            if (((this.p * this.o) * 3) / 2 != i5) {
                this.p = i;
                this.o = i2;
            }
        }
    }

    private boolean a(ByteBuffer byteBuffer, byte[] bArr) {
        MediaFormat outputFormat = this.c.getOutputFormat();
        outputFormat.getInteger("color-format");
        int integer = outputFormat.getInteger("slice-height");
        int integer2 = outputFormat.getInteger("stride");
        outputFormat.getInteger("crop-top");
        outputFormat.getInteger("crop-bottom");
        outputFormat.getInteger("crop-left");
        outputFormat.getInteger("crop-right");
        a(this.i, this.j, integer2, integer, byteBuffer.remaining());
        return true;
    }

    @SuppressLint({"WrongConstant"})
    public boolean a(byte[] bArr, long j) {
        int i;
        if (this.h) {
            return false;
        }
        if (this.q == null) {
            d();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            try {
                i = this.c.dequeueOutputBuffer(bufferInfo, 10000L);
            } catch (IllegalStateException e) {
                e.printStackTrace();
                i = -1;
            }
            if (i < 0) {
                return false;
            }
            if ((bufferInfo.flags & 4) != 0) {
                this.h = true;
            }
            if (bufferInfo.size == 0) {
                return false;
            }
            this.q = this.c.getOutputBuffers()[i];
            this.r = bufferInfo.presentationTimeUs / 1000;
            this.s = i;
            this.n--;
        }
        ByteBuffer byteBuffer = this.q;
        if (byteBuffer == null || this.r > j) {
            return false;
        }
        if (!this.f) {
            a(byteBuffer, bArr);
        }
        try {
            this.c.releaseOutputBuffer(this.s, this.f);
            this.m = this.r;
            this.q = null;
            this.s = -1;
            this.r = 0L;
            this.l++;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
        return true;
    }

    public long a() {
        return this.m;
    }

    public static long a(String str) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(str);
            mediaPlayer.prepare();
            return mediaPlayer.getDuration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
