package com.baidu.navisdk.module.ar.record;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes7.dex */
public class d extends Thread implements Runnable {
    private int b;
    private int d;
    private int e;
    private int f;
    byte[] h;
    byte[] i;
    private WeakReference<b> k;
    private MediaCodec l;

    /* renamed from: a, reason: collision with root package name */
    private int f6995a = 24;
    private int c = 10;
    public Queue<byte[]> j = new LinkedList();
    private boolean g = false;

    public d(b bVar, int i, int i2, int i3) {
        this.k = new WeakReference<>(bVar);
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.b = ((((i2 * 2) * i) * 24) * this.f6995a) / 64;
        int i4 = ((i * i2) * 3) / 2;
        this.h = new byte[i4];
        this.i = new byte[i4];
    }

    private long d() {
        return System.nanoTime() / 1000;
    }

    private boolean e() {
        MediaFormat createVideoFormat;
        try {
            int i = this.f;
            if (i != 90 && i != 270) {
                createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, this.d, this.e);
            } else {
                createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, this.e, this.d);
            }
            createVideoFormat.setInteger("color-format", 2135033992);
            createVideoFormat.setInteger("bitrate", this.b);
            createVideoFormat.setInteger("frame-rate", this.f6995a);
            createVideoFormat.setInteger("i-frame-interval", this.c);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(MimeTypes.VIDEO_H264);
            this.l = createEncoderByType;
            createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.l.start();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void f() {
        try {
            this.l.stop();
            this.l.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(byte[] bArr) {
        if (this.g) {
            this.j.offer(bArr);
        }
    }

    public void b() {
        this.g = false;
    }

    public void c() {
        e();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    @RequiresApi(api = 21)
    public void run() {
        while (this.g) {
            byte[] poll = this.j.poll();
            if (poll != null) {
                if (this.f == 0) {
                    a(poll, this.h, this.d * this.e);
                } else {
                    a(poll, this.i, this.d * this.e);
                    int i = this.f;
                    if (i == 90) {
                        c(this.i, this.h, this.d, this.e);
                    } else if (i == 270) {
                        b(this.i, this.h, this.d, this.e);
                    } else if (i == 180) {
                        a(this.i, this.h, this.d, this.e);
                    }
                }
                b(this.h);
            }
        }
        f();
    }

    @RequiresApi(api = 21)
    private void b(byte[] bArr) {
        b bVar;
        b bVar2;
        if (bArr != null) {
            try {
                int dequeueInputBuffer = this.l.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    long d = d();
                    ByteBuffer inputBuffer = this.l.getInputBuffer(dequeueInputBuffer);
                    inputBuffer.clear();
                    inputBuffer.put(bArr);
                    inputBuffer.limit(bArr.length);
                    this.l.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, d, 0);
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.l.dequeueOutputBuffer(bufferInfo, 10000L);
                if (dequeueOutputBuffer == -2 && (bVar2 = this.k.get()) != null && !bVar2.b()) {
                    bVar2.a(this.l.getOutputFormat());
                }
                while (dequeueOutputBuffer >= 0) {
                    ByteBuffer outputBuffer = this.l.getOutputBuffer(dequeueOutputBuffer);
                    if (bufferInfo.flags == 2) {
                        bufferInfo.size = 0;
                    }
                    if (bufferInfo.size > 0 && (bVar = this.k.get()) != null) {
                        byte[] bArr2 = new byte[bufferInfo.size];
                        outputBuffer.get(bArr2);
                        outputBuffer.position(bufferInfo.offset);
                        outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        bufferInfo.presentationTimeUs = d();
                        bVar.a(new c(true, bArr2, bufferInfo));
                    }
                    this.l.releaseOutputBuffer(dequeueOutputBuffer, false);
                    bufferInfo = new MediaCodec.BufferInfo();
                    dequeueOutputBuffer = this.l.dequeueOutputBuffer(bufferInfo, 10000L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private byte[] c(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                bArr2[i3] = bArr[(i5 * i) + i4];
                i3++;
            }
        }
        int i6 = i * i2;
        int i7 = ((i6 * 3) / 2) - 1;
        for (int i8 = i - 1; i8 > 0; i8 -= 2) {
            for (int i9 = 0; i9 < i2 / 2; i9++) {
                int i10 = (i9 * i) + i6;
                bArr2[i7] = bArr[i10 + i8];
                bArr2[i7 - 1] = bArr[i10 + (i8 - 1)];
                i7 -= 2;
            }
        }
        return bArr2;
    }

    public void a() {
        this.j.clear();
        this.g = true;
        start();
    }

    private void a(byte[] bArr, byte[] bArr2, int i) {
        int i2;
        if (bArr == null || bArr2 == null) {
            return;
        }
        System.arraycopy(bArr, 0, bArr2, 0, i);
        int i3 = 0;
        while (true) {
            i2 = i / 2;
            if (i3 >= i2) {
                break;
            }
            int i4 = i + i3;
            bArr2[i4] = bArr[i4 + 1];
            i3 += 2;
        }
        for (int i5 = 0; i5 < i2; i5 += 2) {
            int i6 = i + i5;
            bArr2[i6 + 1] = bArr[i6];
        }
    }

    private byte[] a(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = i * i2;
        int i4 = 0;
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            bArr2[i4] = bArr[i5];
            i4++;
        }
        for (int i6 = ((i3 * 3) / 2) - 1; i6 >= i3; i6 -= 2) {
            int i7 = i4 + 1;
            bArr2[i4] = bArr[i6 - 1];
            i4 += 2;
            bArr2[i7] = bArr[i6];
        }
        return bArr2;
    }

    private byte[] b(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        for (int i5 = i3; i5 >= 0; i5--) {
            for (int i6 = 0; i6 < i2; i6++) {
                bArr2[i4] = bArr[(i6 * i) + i5];
                i4++;
            }
        }
        int i7 = i * i2;
        int i8 = i7;
        while (i3 > 0) {
            for (int i9 = 0; i9 < i2 / 2; i9++) {
                int i10 = (i9 * i) + i7;
                bArr2[i8] = bArr[(i3 - 1) + i10];
                bArr2[i8 + 1] = bArr[i10 + i3];
                i8 += 2;
            }
            i3 -= 2;
        }
        return bArr2;
    }
}
