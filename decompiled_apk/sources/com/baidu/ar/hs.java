package com.baidu.ar;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.ar.record.EncoderParams;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class hs extends ht {
    private static final String TAG = "hs";
    private long xr = 0;

    @Override // com.baidu.ar.ht
    public /* bridge */ /* synthetic */ void N(boolean z) {
        super.N(z);
    }

    @Override // com.baidu.ar.ht
    public /* bridge */ /* synthetic */ void a(hu huVar) {
        super.a(huVar);
    }

    @Override // com.baidu.ar.ht
    public void fE() {
        if (this.xz == 0) {
            this.xz = this.xw.presentationTimeUs;
        }
        MediaCodec.BufferInfo bufferInfo = this.xw;
        long j = bufferInfo.presentationTimeUs - this.xz;
        bufferInfo.presentationTimeUs = j;
        long j2 = this.xr;
        if (j < j2) {
            long j3 = j2 + 10000;
            this.xr = j3;
            bufferInfo.presentationTimeUs = j3;
        }
        this.xr = bufferInfo.presentationTimeUs;
        kf.c(TAG, "syncTimestamp mAudioEncoder = " + this.xw.size + "|" + this.xw.presentationTimeUs);
    }

    @Override // com.baidu.ar.ht
    public /* bridge */ /* synthetic */ void fF() {
        super.fF();
    }

    @Override // com.baidu.ar.ht
    public /* bridge */ /* synthetic */ void fG() {
        super.fG();
    }

    @Override // com.baidu.ar.ht
    public /* bridge */ /* synthetic */ void fH() {
        super.fH();
    }

    public void a(EncoderParams encoderParams, hv hvVar) {
        boolean z = false;
        if (encoderParams != null && hvVar != null) {
            this.xu = hvVar;
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", encoderParams.getAudioCodec());
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("sample-rate", encoderParams.getAudioSampleRate());
            mediaFormat.setInteger("channel-count", encoderParams.getAudioChannel());
            mediaFormat.setInteger("bitrate", encoderParams.getAudioBitrate());
            mediaFormat.setInteger("max-input-size", encoderParams.getAudioFrameSize());
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(encoderParams.getAudioCodec());
                this.xv = createEncoderByType;
                createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (encoderParams.isVideoIncluded()) {
                    this.xy = false;
                } else {
                    this.xy = true;
                }
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        hu huVar = this.f5572xx;
        if (huVar != null) {
            huVar.a(z, null);
        }
    }

    @Override // com.baidu.ar.ht
    public /* bridge */ /* synthetic */ void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.a(z, byteBuffer, i, j);
    }
}
