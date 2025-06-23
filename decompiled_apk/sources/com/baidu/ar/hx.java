package com.baidu.ar;

import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class hx extends ht {
    private static final String TAG = "hx";
    private Surface xC;

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
        this.xw.presentationTimeUs -= this.xz;
        kf.c(TAG, "syncTimestamp mVideoEncoder = " + this.xw.size + "|" + this.xw.presentationTimeUs);
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

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.baidu.ar.record.EncoderParams r3, com.baidu.ar.hv r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L57
            if (r4 == 0) goto L57
            r2.xu = r4
            java.lang.String r4 = r3.getVideoCodec()
            int r0 = r3.getVideoWidth()
            int r1 = r3.getVideoHeight()
            android.media.MediaFormat r4 = android.media.MediaFormat.createVideoFormat(r4, r0, r1)
            java.lang.String r0 = "color-format"
            r1 = 2130708361(0x7f000789, float:1.701803E38)
            r4.setInteger(r0, r1)
            java.lang.String r0 = "bitrate"
            int r1 = r3.getVideoBitrate()
            r4.setInteger(r0, r1)
            java.lang.String r0 = "frame-rate"
            int r1 = r3.getVideoFrameRate()
            r4.setInteger(r0, r1)
            java.lang.String r0 = "i-frame-interval"
            int r1 = r3.getVideoIFrameInterval()
            r4.setInteger(r0, r1)
            java.lang.String r3 = r3.getVideoCodec()     // Catch: java.lang.Exception -> L53
            android.media.MediaCodec r3 = android.media.MediaCodec.createEncoderByType(r3)     // Catch: java.lang.Exception -> L53
            r2.xv = r3     // Catch: java.lang.Exception -> L53
            r0 = 0
            r1 = 1
            r3.configure(r4, r0, r0, r1)     // Catch: java.lang.Exception -> L53
            android.media.MediaCodec r3 = r2.xv     // Catch: java.lang.Exception -> L53
            android.view.Surface r3 = r3.createInputSurface()     // Catch: java.lang.Exception -> L53
            r2.xC = r3     // Catch: java.lang.Exception -> L53
            r2.xy = r1     // Catch: java.lang.Exception -> L53
            goto L58
        L53:
            r3 = move-exception
            r3.printStackTrace()
        L57:
            r1 = 0
        L58:
            com.baidu.ar.hu r3 = r2.f5572xx
            if (r3 == 0) goto L61
            android.view.Surface r4 = r2.xC
            r3.a(r1, r4)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.hx.a(com.baidu.ar.record.EncoderParams, com.baidu.ar.hv):void");
    }

    @Override // com.baidu.ar.ht
    public /* bridge */ /* synthetic */ void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        super.a(z, byteBuffer, i, j);
    }
}
