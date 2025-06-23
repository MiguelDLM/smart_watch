package com.baidu.ar.marker;

import com.baidu.ar.algo.FrameType;
import com.baidu.ar.fn;
import com.baidu.ar.ga;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.marker.model.TranslationPrior;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class MarkerARAlgoJniClient implements ILibLoader.c {
    private static final int ALGO_RESULT_CODE_INIT = -1;
    private static final int ALGO_RESULT_CODE_SUCCESS = 0;
    private a onAlgoSoLoadedComplteCallback;
    private long querySystemHandler = 0;
    private int isAlgoRelease = -1;

    /* loaded from: classes7.dex */
    public interface a {
        void em();

        void en();
    }

    public static String getVersion() {
        return nativeGetQueryVersion();
    }

    private native int nativeCreateQuerierSystem(long j, int i, int i2, float[] fArr, float[] fArr2, WorkType workType, TrackerType trackerType, String str, ReturnType returnType, int i3);

    private native int nativeGetFinalStepCount(long j);

    private native int nativeGetLocationPoint(long j, int[] iArr);

    private native int nativeGetPose(long j, double[] dArr);

    private static native String nativeGetQueryVersion();

    private native float nativeGetStepLength(long j);

    private native int nativeGetVpasSuccessCount(long j);

    private native long nativeInitQuerySystem();

    private native int nativePauseSendingFrame(long j);

    private native int nativeQueryFrame(long j, byte[] bArr, double d, float[] fArr, float[] fArr2, int i, FrameType frameType);

    private native int nativeQueryFrameByteBuffer(long j, ByteBuffer byteBuffer, double d, float[] fArr, float[] fArr2, int i, FrameType frameType);

    private native int nativeRelease(long j);

    private native int nativeReset(long j);

    private native int nativeResumeSendingFrame(long j);

    private native int nativeTrackFrame(long j, byte[] bArr, int i, int i2, float[] fArr, float[] fArr2, double d, float[] fArr3, float[] fArr4, TrackerStatus trackerStatus, double[] dArr, int i3, FrameType frameType);

    private native int nativeTrackFrame2(long j, byte[] bArr, int i, int i2, float[] fArr, float[] fArr2, double d, float[] fArr3, float[] fArr4, TrackerStatus trackerStatus, double[] dArr, TranslationPrior translationPrior, float[] fArr5, int i3, FrameType frameType);

    private native int nativeTrackFrame3(long j, byte[] bArr, int i, int i2, float[] fArr, float[] fArr2, double d, float[] fArr3, float[] fArr4, TrackerStatus trackerStatus, double[] dArr, float[] fArr5, int i3, FrameType frameType);

    private native int nativeVpsChoice(long j, int i);

    private native int nativeVpsServerReceiver(long j, byte[] bArr);

    private boolean timeEffect(TranslationPrior translationPrior) {
        return Math.abs(System.currentTimeMillis() - translationPrior.getTime()) <= 5000;
    }

    public int chooseMap(int i) {
        long j = this.querySystemHandler;
        if (j == 0) {
            return -2;
        }
        return nativeVpsChoice(j, i);
    }

    public int createQuerierSystem(int i, int i2, float[] fArr, float[] fArr2, int i3, TrackerType trackerType, String str, int i4) {
        long nativeInitQuerySystem = nativeInitQuerySystem();
        this.querySystemHandler = nativeInitQuerySystem;
        this.isAlgoRelease = -1;
        WorkType workType = WorkType.WORK_LOCALIZATION;
        if (i3 == 3) {
            workType = WorkType.WORK_NAVIGATION;
        }
        return nativeCreateQuerierSystem(nativeInitQuerySystem, i, i2, fArr, fArr2, workType, trackerType, str, ReturnType.RETURN_LONGTITUDE_LATITUDE_6DOF_POSE, i4);
    }

    public int getFinalStepCount() {
        long j = this.querySystemHandler;
        if (j == 0) {
            return -1;
        }
        return nativeGetFinalStepCount(j);
    }

    public int getLocationPoint(double[] dArr) {
        long j = this.querySystemHandler;
        if (j == 0) {
            return -2;
        }
        return nativeGetPose(j, dArr);
    }

    public float getStepLength() {
        long j = this.querySystemHandler;
        if (j == 0) {
            return -1.0f;
        }
        return nativeGetStepLength(j);
    }

    public int getVpasSuccessCount() {
        long j = this.querySystemHandler;
        if (j == 0) {
            return -1;
        }
        return nativeGetVpasSuccessCount(j);
    }

    public void loadSoLibs() {
        try {
            fn.require("dumixar");
            a aVar = this.onAlgoSoLoadedComplteCallback;
            if (aVar != null) {
                aVar.em();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a aVar2 = this.onAlgoSoLoadedComplteCallback;
            if (aVar2 != null) {
                aVar2.en();
            }
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader.c
    public void onError() {
        a aVar = this.onAlgoSoLoadedComplteCallback;
        if (aVar != null) {
            aVar.en();
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader.c
    public void onReady() {
        a aVar = this.onAlgoSoLoadedComplteCallback;
        if (aVar != null) {
            aVar.em();
        }
    }

    public boolean queryFrame(byte[] bArr, double d, float[] fArr, float[] fArr2, int i, FrameType frameType) {
        long j = this.querySystemHandler;
        return j != 0 && nativeQueryFrame(j, bArr, d, fArr, fArr2, i, frameType) == 0;
    }

    public boolean receivProtoBuf(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        long j = this.querySystemHandler;
        return j != 0 && nativeVpsServerReceiver(j, bArr) == 0;
    }

    public int release() {
        long j = this.querySystemHandler;
        if (j == 0) {
            return 0;
        }
        int nativeRelease = nativeRelease(j);
        this.isAlgoRelease = nativeRelease;
        this.querySystemHandler = 0L;
        return nativeRelease;
    }

    public boolean reset() {
        long j = this.querySystemHandler;
        return j != 0 && nativeReset(j) == 0;
    }

    public void setOnAlgoSoLoadedComplteCallback(a aVar) {
        this.onAlgoSoLoadedComplteCallback = aVar;
    }

    public boolean trackFrameBytes(byte[] bArr, ga gaVar) {
        if (this.querySystemHandler == 0 || gaVar == null || this.isAlgoRelease == 0) {
            return false;
        }
        TranslationPrior eo = gaVar.eo();
        if (eo != null && !timeEffect(eo)) {
            eo = null;
        }
        return nativeTrackFrame2(this.querySystemHandler, bArr, gaVar.getWidth(), gaVar.getHeight(), gaVar.getIntrinsics(), gaVar.getDistort(), gaVar.eq(), gaVar.er(), gaVar.getPose(), gaVar.es(), gaVar.getMagnet(), eo, gaVar.ep(), gaVar.et(), gaVar.eu()) == 0;
    }
}
