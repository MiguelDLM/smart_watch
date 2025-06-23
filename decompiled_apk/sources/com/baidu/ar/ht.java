package com.baidu.ar;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
abstract class ht {
    private static final String TAG = "ht";
    protected hv xu;
    protected MediaCodec xv;

    /* renamed from: xx, reason: collision with root package name */
    protected hu f5572xx;
    protected boolean xy;
    private int xs = -1;
    private boolean xt = false;
    protected long xz = 0;
    protected MediaCodec.BufferInfo xw = new MediaCodec.BufferInfo();

    private void O(boolean z) {
        ByteBuffer[] byteBufferArr;
        int i;
        String str;
        String str2;
        kf.c(TAG, "drainEncoder endOfStream = " + z);
        try {
            byteBufferArr = this.xv.getOutputBuffers();
        } catch (Exception e) {
            e.printStackTrace();
            byteBufferArr = null;
        }
        if (byteBufferArr == null) {
            return;
        }
        while (true) {
            try {
                i = this.xv.dequeueOutputBuffer(this.xw, 10000L);
            } catch (Exception e2) {
                e2.printStackTrace();
                i = 0;
            }
            str = TAG;
            kf.c(str, "drainEncoder encoderStatus = " + i);
            if (i == -1) {
                if (!z) {
                    return;
                } else {
                    kf.c(str, "no output available, spinning to await EOS");
                }
            } else if (i == -3) {
                byteBufferArr = this.xv.getOutputBuffers();
            } else if (i == -2) {
                if (this.xu.fI()) {
                    str2 = "format changed twice!!!!";
                    break;
                }
                MediaFormat outputFormat = this.xv.getOutputFormat();
                kf.c(str, "encoder output format changed: " + outputFormat);
                this.xs = this.xu.a(outputFormat);
                this.xt = true;
                hu huVar = this.f5572xx;
                if (huVar != null) {
                    huVar.J(true);
                }
                if (this.xy) {
                    this.xu.fJ();
                }
            } else if (i < 0) {
                kf.v(str, "unexpected result from encoder.dequeueOutputBuffer: " + i);
            } else {
                ByteBuffer byteBuffer = byteBufferArr[i];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + i + " was null");
                }
                if ((this.xw.flags & 2) != 0) {
                    kf.c(str, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                    this.xw.size = 0;
                }
                if (this.xw.size != 0) {
                    if (this.xu.fI()) {
                        byteBuffer.position(this.xw.offset);
                        MediaCodec.BufferInfo bufferInfo = this.xw;
                        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        fE();
                        kf.c(str, "drainEncoder writeSampleData mBufferInfo = " + this.xw.presentationTimeUs + "&& size = " + this.xw.size);
                        this.xu.a(this.xs, byteBuffer, this.xw);
                    } else {
                        kf.c(str, "drainEncoder wait for mMuxer start !!!");
                    }
                }
                this.xv.releaseOutputBuffer(i, false);
                if ((this.xw.flags & 4) != 0) {
                    if (z) {
                        if (this.xy) {
                            this.xu.fK();
                        }
                        hu huVar2 = this.f5572xx;
                        if (huVar2 != null) {
                            huVar2.K(true);
                            return;
                        }
                        return;
                    }
                    str2 = "reached end of stream unexpectedly";
                }
            }
        }
        kf.b(str, str2);
    }

    public void N(boolean z) {
        kf.c(TAG, "drainSurface endOfStream = " + z);
        if (z) {
            hv hvVar = this.xu;
            if (hvVar == null || !hvVar.fI()) {
                hu huVar = this.f5572xx;
                if (huVar != null) {
                    huVar.K(true);
                    return;
                }
                return;
            }
            this.xv.signalEndOfInputStream();
        }
        O(z);
    }

    public void a(hu huVar) {
        this.f5572xx = huVar;
    }

    public abstract void fE();

    public void fF() {
        this.xv.release();
        this.xv = null;
        this.xu = null;
    }

    public void fG() {
        kf.c(TAG, "stopEncoder !!!");
        MediaCodec mediaCodec = this.xv;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void fH() {
        boolean z;
        kf.c(TAG, "startEncoder !!!");
        MediaCodec mediaCodec = this.xv;
        if (mediaCodec != null) {
            try {
                mediaCodec.start();
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
        }
        z = true;
        hu huVar = this.f5572xx;
        if (huVar != null) {
            huVar.I(z);
        }
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        MediaCodec mediaCodec;
        int i2;
        int i3;
        long j2;
        int i4;
        MediaCodec mediaCodec2 = this.xv;
        if (mediaCodec2 != null) {
            int i5 = -1;
            if (this.xt && this.xs == -1) {
                return;
            }
            try {
                i5 = mediaCodec2.dequeueInputBuffer(10000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i5 >= 0) {
                if (z) {
                    kf.c(TAG, "drainBuffer sending EOS to drainBufferEncoder");
                    mediaCodec = this.xv;
                    j2 = 0;
                    i4 = 4;
                    i2 = 0;
                    i3 = 0;
                } else {
                    if (!a(i5, byteBuffer, i, j)) {
                        return;
                    }
                    mediaCodec = this.xv;
                    MediaCodec.BufferInfo bufferInfo = this.xw;
                    i2 = bufferInfo.offset;
                    i3 = bufferInfo.size;
                    j2 = bufferInfo.presentationTimeUs;
                    i4 = 0;
                }
                mediaCodec.queueInputBuffer(i5, i2, i3, j2, i4);
            } else {
                kf.c(TAG, "drainBuffer encode input buffer not available");
            }
            O(z);
        }
    }

    private boolean a(int i, ByteBuffer byteBuffer, int i2, long j) {
        ByteBuffer byteBuffer2 = this.xv.getInputBuffers()[i];
        if (byteBuffer2.capacity() < byteBuffer.capacity()) {
            return false;
        }
        byteBuffer2.position(0);
        byteBuffer2.put(byteBuffer);
        byteBuffer2.flip();
        MediaCodec.BufferInfo bufferInfo = this.xw;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.presentationTimeUs = j / 1000;
        return true;
    }
}
