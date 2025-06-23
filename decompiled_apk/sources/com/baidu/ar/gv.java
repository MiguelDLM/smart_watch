package com.baidu.ar;

import com.baidu.ar.recg.ImgRecognitionClient;
import com.baidu.ar.recg.RecognitionResult;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class gv {
    private static gv vy;
    private boolean mh = false;
    private ImgRecognitionClient vz = new ImgRecognitionClient();

    private gv() {
    }

    public static synchronized gv eQ() {
        gv gvVar;
        synchronized (gv.class) {
            try {
                if (vy == null) {
                    vy = new gv();
                }
                gvVar = vy;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gvVar;
    }

    public RecognitionResult a(ByteBuffer byteBuffer, int i, int i2) {
        String str;
        if (this.vz == null) {
            return null;
        }
        RecognitionResult recogniseImageByteBuffer = ImgRecognitionClient.recogniseImageByteBuffer(byteBuffer, i, i2);
        int i3 = recogniseImageByteBuffer.errCode;
        if (i3 != 1) {
            if (i3 == 0) {
                str = "model process fail!";
            }
            this.mh = false;
            return recogniseImageByteBuffer;
        }
        str = "model process success! process score = " + recogniseImageByteBuffer.score + " process time = " + recogniseImageByteBuffer.time;
        kf.c("AlgoRecg", str);
        this.mh = false;
        return recogniseImageByteBuffer;
    }

    public boolean init(String[] strArr) {
        if (this.vz == null || strArr == null) {
            return false;
        }
        return ImgRecognitionClient.init(strArr);
    }

    public boolean release() {
        if (this.vz != null && !this.mh) {
            this.mh = ImgRecognitionClient.release();
        }
        this.vz = null;
        vy = null;
        return this.mh;
    }
}
