package com.sma.smartv3.util.video;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;
import xoIXOxX.II0xO0;

/* loaded from: classes12.dex */
public final class VideoEncoder {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f24546I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f24547II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final File f24548II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f24549Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @oOoXoXO
    public MediaMuxer f24550X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f24551XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final oIX0oI<Bitmap> f24552oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @oOoXoXO
    public MediaCodec f24553oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public final long f24554xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f24555xxIXOIIO;

    public VideoEncoder(@OOXIXo oIX0oI<Bitmap> IProvider, @OOXIXo File out, int i) {
        IIX0o.x0xO0oo(IProvider, "IProvider");
        IIX0o.x0xO0oo(out, "out");
        this.f24552oIX0oI = IProvider;
        this.f24548II0xO0 = out;
        this.f24546I0Io = i;
        this.f24554xoIox = 10000L;
    }

    public final void I0Io(byte[] bArr, int[] iArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 / 4) + i3;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = 0;
            while (i8 < i) {
                int i9 = iArr[i6];
                int i10 = (16711680 & i9) >> 16;
                int i11 = (65280 & i9) >> 8;
                int i12 = 255;
                int i13 = i9 & 255;
                int i14 = (((((i10 * 66) + (i11 * 129)) + (i13 * 25)) + 128) >> 8) + 16;
                int i15 = (((((i10 * 112) - (i11 * 94)) - (i13 * 18)) + 128) >> 8) + 128;
                int i16 = (((((i10 * (-38)) - (i11 * 74)) + (i13 * 112)) + 128) >> 8) + 128;
                int i17 = i5 + 1;
                if (i14 < 0) {
                    i14 = 0;
                } else if (i14 > 255) {
                    i14 = 255;
                }
                bArr[i5] = (byte) i14;
                if (i7 % 2 == 0 && i6 % 2 == 0) {
                    int i18 = i4 + 1;
                    if (i15 < 0) {
                        i15 = 0;
                    } else if (i15 > 255) {
                        i15 = 255;
                    }
                    bArr[i4] = (byte) i15;
                    int i19 = i3 + 1;
                    if (i16 < 0) {
                        i12 = 0;
                    } else if (i16 <= 255) {
                        i12 = i16;
                    }
                    bArr[i3] = (byte) i12;
                    i3 = i19;
                    i4 = i18;
                }
                i6++;
                i8++;
                i5 = i17;
            }
        }
    }

    public final int[] II0XooXoX() {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        int i = 0;
        while (i < codecCount && mediaCodecInfo == null) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                boolean z = false;
                for (int i2 = 0; i2 < supportedTypes.length && !z; i2++) {
                    if (IIX0o.Oxx0IOOO(supportedTypes[i2], MimeTypes.VIDEO_H264)) {
                        z = true;
                    }
                }
                if (z) {
                    i++;
                    mediaCodecInfo = codecInfoAt;
                }
            }
            i++;
        }
        IIX0o.ooOOo0oXI(mediaCodecInfo);
        int[] colorFormats = mediaCodecInfo.getCapabilitiesForType(MimeTypes.VIDEO_H264).colorFormats;
        IIX0o.oO(colorFormats, "colorFormats");
        return colorFormats;
    }

    public final void II0xO0(boolean z, MediaCodec.BufferInfo bufferInfo) {
        ByteBuffer[] byteBufferArr;
        ByteBuffer outputBuffer;
        if (Build.VERSION.SDK_INT <= 21) {
            MediaCodec mediaCodec = this.f24553oxoX;
            IIX0o.ooOOo0oXI(mediaCodec);
            byteBufferArr = mediaCodec.getOutputBuffers();
        } else {
            byteBufferArr = null;
        }
        if (z) {
            try {
                MediaCodec mediaCodec2 = this.f24553oxoX;
                IIX0o.ooOOo0oXI(mediaCodec2);
                mediaCodec2.signalEndOfInputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true) {
            MediaCodec mediaCodec3 = this.f24553oxoX;
            IIX0o.ooOOo0oXI(mediaCodec3);
            final int dequeueOutputBuffer = mediaCodec3.dequeueOutputBuffer(bufferInfo, this.f24554xoIox);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f24551XO) {
                    MediaCodec mediaCodec4 = this.f24553oxoX;
                    IIX0o.ooOOo0oXI(mediaCodec4);
                    MediaFormat outputFormat = mediaCodec4.getOutputFormat();
                    IIX0o.oO(outputFormat, "getOutputFormat(...)");
                    MediaMuxer mediaMuxer = this.f24550X0o0xo;
                    IIX0o.ooOOo0oXI(mediaMuxer);
                    this.f24547II0XooXoX = mediaMuxer.addTrack(outputFormat);
                    MediaMuxer mediaMuxer2 = this.f24550X0o0xo;
                    IIX0o.ooOOo0oXI(mediaMuxer2);
                    mediaMuxer2.start();
                    this.f24551XO = true;
                } else {
                    throw new IllegalStateException(new Oox.oIX0oI<String>() { // from class: com.sma.smartv3.util.video.VideoEncoder$drainEncoder$1
                        @Override // Oox.oIX0oI
                        @OOXIXo
                        public final String invoke() {
                            return "format changed twice";
                        }
                    }.toString());
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.d("YapVideoEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                if (Build.VERSION.SDK_INT <= 21) {
                    IIX0o.ooOOo0oXI(byteBufferArr);
                    outputBuffer = byteBufferArr[dequeueOutputBuffer];
                } else {
                    MediaCodec mediaCodec5 = this.f24553oxoX;
                    IIX0o.ooOOo0oXI(mediaCodec5);
                    outputBuffer = mediaCodec5.getOutputBuffer(dequeueOutputBuffer);
                }
                if (outputBuffer != null) {
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    if (bufferInfo.size != 0) {
                        if (!this.f24551XO) {
                            Log.d("YapVideoEncoder", "error:muxer hasn't started");
                        }
                        outputBuffer.position(bufferInfo.offset);
                        outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        try {
                            MediaMuxer mediaMuxer3 = this.f24550X0o0xo;
                            IIX0o.ooOOo0oXI(mediaMuxer3);
                            mediaMuxer3.writeSampleData(this.f24547II0XooXoX, outputBuffer, bufferInfo);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    MediaCodec mediaCodec6 = this.f24553oxoX;
                    IIX0o.ooOOo0oXI(mediaCodec6);
                    mediaCodec6.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        if (!z) {
                            Log.d("YapVideoEncoder", "reached end of stream unexpectedly");
                            this.f24552oIX0oI.progress(-1.0f);
                            return;
                        } else {
                            Log.d("YapVideoEncoder", "end of stream reached");
                            return;
                        }
                    }
                } else {
                    throw new IllegalStateException(new Oox.oIX0oI<String>() { // from class: com.sma.smartv3.util.video.VideoEncoder$drainEncoder$outputBuffer$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // Oox.oIX0oI
                        @OOXIXo
                        public final String invoke() {
                            return "encoderOutputBuffer " + dequeueOutputBuffer + " was null";
                        }
                    }.toString());
                }
            }
        }
    }

    public final void OOXIXo(Bitmap bitmap) {
        Bitmap bitmap2;
        long j;
        ByteBuffer[] byteBufferArr;
        ByteBuffer inputBuffer;
        this.f24549Oxx0IOOO = true;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        if (Build.VERSION.SDK_INT <= 21) {
            MediaCodec mediaCodec = this.f24553oxoX;
            IIX0o.ooOOo0oXI(mediaCodec);
            j = 0;
            byteBufferArr = mediaCodec.getInputBuffers();
            bitmap2 = bitmap;
        } else {
            bitmap2 = bitmap;
            j = 0;
            byteBufferArr = null;
        }
        while (this.f24549Oxx0IOOO) {
            MediaCodec mediaCodec2 = this.f24553oxoX;
            IIX0o.ooOOo0oXI(mediaCodec2);
            int dequeueInputBuffer = mediaCodec2.dequeueInputBuffer(this.f24554xoIox);
            if (dequeueInputBuffer >= 0) {
                long oIX0oI2 = oIX0oI(j);
                this.f24552oIX0oI.progress(((float) j) / r5.size());
                if (j >= this.f24552oIX0oI.size()) {
                    MediaCodec mediaCodec3 = this.f24553oxoX;
                    IIX0o.ooOOo0oXI(mediaCodec3);
                    mediaCodec3.queueInputBuffer(dequeueInputBuffer, 0, 0, oIX0oI2, 4);
                    this.f24549Oxx0IOOO = false;
                    II0xO0(true, bufferInfo);
                } else {
                    if (bitmap2 == null) {
                        bitmap2 = this.f24552oIX0oI.next();
                    }
                    int width = bitmap2.getWidth();
                    if (width % 2 != 0) {
                        width--;
                    }
                    int height = bitmap2.getHeight();
                    if (height % 2 != 0) {
                        height--;
                    }
                    byte[] xxIXOIIO2 = xxIXOIIO(width, height, bitmap2);
                    if (Build.VERSION.SDK_INT <= 21) {
                        IIX0o.ooOOo0oXI(byteBufferArr);
                        inputBuffer = byteBufferArr[dequeueInputBuffer];
                    } else {
                        MediaCodec mediaCodec4 = this.f24553oxoX;
                        IIX0o.ooOOo0oXI(mediaCodec4);
                        inputBuffer = mediaCodec4.getInputBuffer(dequeueInputBuffer);
                    }
                    IIX0o.ooOOo0oXI(inputBuffer);
                    inputBuffer.clear();
                    inputBuffer.put(xxIXOIIO2);
                    MediaCodec mediaCodec5 = this.f24553oxoX;
                    IIX0o.ooOOo0oXI(mediaCodec5);
                    mediaCodec5.queueInputBuffer(dequeueInputBuffer, 0, xxIXOIIO2.length, oIX0oI2, 0);
                    II0xO0(false, bufferInfo);
                    bitmap2 = null;
                }
                j++;
            } else {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException unused) {
                    this.f24552oIX0oI.progress(-1.0f);
                }
            }
        }
    }

    public final void Oxx0IOOO() {
        this.f24549Oxx0IOOO = false;
        try {
            MediaCodec mediaCodec = this.f24553oxoX;
            if (mediaCodec != null) {
                IIX0o.ooOOo0oXI(mediaCodec);
                mediaCodec.stop();
                MediaCodec mediaCodec2 = this.f24553oxoX;
                IIX0o.ooOOo0oXI(mediaCodec2);
                mediaCodec2.release();
            }
            MediaMuxer mediaMuxer = this.f24550X0o0xo;
            if (mediaMuxer != null && this.f24551XO) {
                IIX0o.ooOOo0oXI(mediaMuxer);
                mediaMuxer.stop();
                MediaMuxer mediaMuxer2 = this.f24550X0o0xo;
                IIX0o.ooOOo0oXI(mediaMuxer2);
                mediaMuxer2.release();
            }
        } catch (Exception e) {
            this.f24552oIX0oI.progress(-1.0f);
            e.printStackTrace();
        }
    }

    public final void X0o0xo(byte[] bArr, int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = 0; i6 < i; i6++) {
                int i7 = iArr[i4];
                int i8 = (16711680 & i7) >> 16;
                int i9 = (65280 & i7) >> 8;
                int i10 = 255;
                int i11 = i7 & 255;
                int i12 = (((((i8 * 66) + (i9 * 129)) + (i11 * 25)) + 128) >> 8) + 16;
                int i13 = (((((i8 * 112) - (i9 * 94)) - (i11 * 18)) + 128) >> 8) + 128;
                int i14 = (((((i8 * (-38)) - (i9 * 74)) + (i11 * 112)) + 128) >> 8) + 128;
                int i15 = i3 + 1;
                if (i12 < 0) {
                    i12 = 0;
                } else if (i12 > 255) {
                    i12 = 255;
                }
                bArr[i3] = (byte) i12;
                if (i5 % 2 == 0 && i4 % 2 == 0) {
                    int i16 = i3 + 2;
                    if (i14 < 0) {
                        i14 = 0;
                    } else if (i14 > 255) {
                        i14 = 255;
                    }
                    bArr[i16] = (byte) i14;
                    int i17 = i3 + 4;
                    if (i13 < 0) {
                        i10 = 0;
                    } else if (i13 <= 255) {
                        i10 = i13;
                    }
                    bArr[i17] = (byte) i10;
                }
                if (i4 % 2 == 0) {
                    i3 += 2;
                } else {
                    i3 = i15;
                }
                i4++;
            }
        }
    }

    public final void XO(byte[] bArr, int[] iArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = 0;
            while (i7 < i) {
                int i8 = iArr[i5];
                int i9 = (16711680 & i8) >> 16;
                int i10 = (65280 & i8) >> 8;
                int i11 = 255;
                int i12 = i8 & 255;
                int i13 = (((((i9 * 66) + (i10 * 129)) + (i12 * 25)) + 128) >> 8) + 16;
                int i14 = (((((i9 * 112) - (i10 * 94)) - (i12 * 18)) + 128) >> 8) + 128;
                int i15 = (((((i9 * (-38)) - (i10 * 74)) + (i12 * 112)) + 128) >> 8) + 128;
                int i16 = i4 + 1;
                if (i13 < 0) {
                    i13 = 0;
                } else if (i13 > 255) {
                    i13 = 255;
                }
                bArr[i4] = (byte) i13;
                if (i6 % 2 == 0 && i5 % 2 == 0) {
                    int i17 = i3 + 1;
                    if (i15 < 0) {
                        i15 = 0;
                    } else if (i15 > 255) {
                        i15 = 255;
                    }
                    bArr[i3] = (byte) i15;
                    i3 += 2;
                    if (i14 < 0) {
                        i11 = 0;
                    } else if (i14 <= 255) {
                        i11 = i14;
                    }
                    bArr[i17] = (byte) i11;
                }
                i5++;
                i7++;
                i4 = i16;
            }
        }
    }

    public final long oIX0oI(long j) {
        return 132 + ((j * 1000000) / this.f24546I0Io);
    }

    public final void oOoXoXO() {
        if (IIX0o.Oxx0IOOO(Looper.myLooper(), Looper.getMainLooper())) {
            II0xO0.I0Io(true, false, null, null, 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.util.video.VideoEncoder$start$1
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VideoEncoder.this.oOoXoXO();
                }
            }, 30, null);
            return;
        }
        try {
            if (this.f24552oIX0oI.size() > 0) {
                Bitmap next = this.f24552oIX0oI.next();
                xoIox(next.getWidth(), next.getHeight());
                OOXIXo(next);
            }
        } finally {
            Oxx0IOOO();
        }
    }

    public final void oxoX(byte[] bArr, int[] iArr, int i, int i2) {
        int length = bArr.length / 2;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = 0; i6 < i; i6++) {
                int i7 = iArr[i4];
                int i8 = (16711680 & i7) >> 16;
                int i9 = (65280 & i7) >> 8;
                int i10 = 255;
                int i11 = i7 & 255;
                int i12 = (((((i8 * 66) + (i9 * 129)) + (i11 * 25)) + 128) >> 8) + 16;
                int i13 = (((((i8 * 112) - (i9 * 94)) - (i11 * 18)) + 128) >> 8) + 128;
                int i14 = (((((i8 * (-38)) - (i9 * 74)) + (i11 * 112)) + 128) >> 8) + 128;
                int i15 = i5 % 2;
                if (i15 == 0 && i4 % 2 == 0) {
                    if (i12 < 0) {
                        i12 = 0;
                    } else if (i12 > 255) {
                        i12 = 255;
                    }
                    bArr[i3] = (byte) i12;
                    i3 += 2;
                    if (i14 < 0) {
                        i14 = 0;
                    } else if (i14 > 255) {
                        i14 = 255;
                    }
                    bArr[i3] = (byte) i14;
                    int i16 = length + 1;
                    if (i13 < 0) {
                        i10 = 0;
                    } else if (i13 <= 255) {
                        i10 = i13;
                    }
                    bArr[i16] = (byte) i10;
                } else if (i15 == 0 && i4 % 2 == 1) {
                    int i17 = i3 + 1;
                    if (i12 < 0) {
                        i10 = 0;
                    } else if (i12 <= 255) {
                        i10 = i12;
                    }
                    bArr[i3] = (byte) i10;
                    i3 = i17;
                } else if (i15 == 1 && i4 % 2 == 0) {
                    if (i12 < 0) {
                        i10 = 0;
                    } else if (i12 <= 255) {
                        i10 = i12;
                    }
                    bArr[length] = (byte) i10;
                    length += 2;
                } else if (i15 == 1 && i4 % 2 == 1) {
                    int i18 = length + 1;
                    if (i12 < 0) {
                        i10 = 0;
                    } else if (i12 <= 255) {
                        i10 = i12;
                    }
                    bArr[length] = (byte) i10;
                    length = i18;
                }
                i4++;
            }
        }
    }

    public final void xoIox(int i, int i2) {
        int[] II0XooXoX2 = II0XooXoX();
        if (II0XooXoX2.length > 0) {
            int i3 = II0XooXoX2[0];
            if (i3 != 39) {
                switch (i3) {
                    case 19:
                        this.f24555xxIXOIIO = i3;
                        break;
                    case 20:
                        this.f24555xxIXOIIO = i3;
                        break;
                    case 21:
                        this.f24555xxIXOIIO = i3;
                        break;
                }
            } else {
                this.f24555xxIXOIIO = i3;
            }
        }
        if (this.f24555xxIXOIIO <= 0) {
            this.f24555xxIXOIIO = 21;
        }
        if (i % 2 != 0) {
            i--;
        }
        if (i2 % 2 != 0) {
            i2--;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, i, i2);
        IIX0o.oO(createVideoFormat, "createVideoFormat(...)");
        createVideoFormat.setInteger("color-format", this.f24555xxIXOIIO);
        createVideoFormat.setInteger("bitrate", i * i2);
        createVideoFormat.setInteger("frame-rate", this.f24546I0Io);
        createVideoFormat.setInteger("i-frame-interval", 10);
        try {
            this.f24553oxoX = MediaCodec.createEncoderByType(MimeTypes.VIDEO_H264);
            if (!this.f24548II0xO0.exists()) {
                this.f24548II0xO0.createNewFile();
            }
            this.f24550X0o0xo = new MediaMuxer(this.f24548II0xO0.getAbsolutePath(), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MediaCodec mediaCodec = this.f24553oxoX;
        IIX0o.ooOOo0oXI(mediaCodec);
        mediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        MediaCodec mediaCodec2 = this.f24553oxoX;
        IIX0o.ooOOo0oXI(mediaCodec2);
        mediaCodec2.start();
        this.f24549Oxx0IOOO = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final byte[] xxIXOIIO(int i, int i2, Bitmap bitmap) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        IIX0o.ooOOo0oXI(bitmap);
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        byte[] bArr = new byte[(i3 * 3) / 2];
        int i4 = this.f24555xxIXOIIO;
        if (i4 != 39) {
            switch (i4) {
                case 19:
                    I0Io(bArr, iArr, i, i2);
                    break;
                case 20:
                    oxoX(bArr, iArr, i, i2);
                    break;
                case 21:
                    XO(bArr, iArr, i, i2);
                    break;
            }
        } else {
            X0o0xo(bArr, iArr, i, i2);
        }
        return bArr;
    }

    public /* synthetic */ VideoEncoder(oIX0oI oix0oi, File file, int i, int i2, IIXOooo iIXOooo) {
        this(oix0oi, file, (i2 & 4) != 0 ? 60 : i);
    }
}
