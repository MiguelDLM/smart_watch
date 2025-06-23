package com.baidu.ar.recg;

import com.baidu.ar.fn;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class ImgRecognitionClient {
    private long mRecgHandler = 0;

    static {
        fn.require("ImgRecognition");
    }

    private native long createImageSearcherMultiInstanceC();

    public static native CornerPoint[] extractCornerPoints(byte[] bArr, int i, int i2);

    private native CornerPoint[] extractCornerPointsMultiInstanceC(long j, byte[] bArr, int i, int i2);

    public static native String getVersionImgSearch();

    private native String getVersionImgSearchMultiInstanceC();

    public static native boolean init(String[] strArr);

    private native boolean loadFeatureMultiInstanceC(long j, String[] strArr);

    public static native RecognitionResult recogniseImage(byte[] bArr, int i, int i2);

    public static native RecognitionResult recogniseImageByteBuffer(ByteBuffer byteBuffer, int i, int i2);

    private native RecognitionResult recogniseImageMultiInstanceC(long j, byte[] bArr, int i, int i2);

    public static native boolean release();

    private native boolean releaseMultiInstanceC(long j);

    public void createImageSearcherMultiInstance() {
        this.mRecgHandler = createImageSearcherMultiInstanceC();
    }

    public CornerPoint[] extractCornerPointsMultiInstance(byte[] bArr, int i, int i2) {
        return extractCornerPointsMultiInstanceC(this.mRecgHandler, bArr, i, i2);
    }

    public String getVersionImgSearchMultiInstance() {
        return getVersionImgSearchMultiInstanceC();
    }

    public boolean loadFeatureMultiInstance(String[] strArr) {
        long j = this.mRecgHandler;
        if (j == 0) {
            return false;
        }
        return loadFeatureMultiInstanceC(j, strArr);
    }

    public RecognitionResult recogniseImageMultiInstance(byte[] bArr, int i, int i2) {
        long j = this.mRecgHandler;
        return j == 0 ? new RecognitionResult() : recogniseImageMultiInstanceC(j, bArr, i, i2);
    }

    public boolean releaseMultiInstance() {
        long j = this.mRecgHandler;
        if (j == 0) {
            return false;
        }
        this.mRecgHandler = 0L;
        boolean releaseMultiInstanceC = releaseMultiInstanceC(j);
        this.mRecgHandler = 0L;
        return releaseMultiInstanceC;
    }
}
