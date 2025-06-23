package com.baidu.ar.databasic;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class AlgoHandleAdapter {
    public static native long createHandle();

    public static native int destroyHandle(long j);

    public static native boolean getHandleEnableSync(long j);

    public static native long getHandleFaceHandle(long j);

    public static native byte[] getHandleImageData(long j);

    public static native int getHandleImageHeight(long j);

    public static native int getHandleImageWidth(long j);

    public static native boolean getHandleIsFront(long j);

    public static native float getHandleMaskBottom(long j);

    public static native byte[] getHandleMaskData(long j);

    public static native int getHandleMaskFormat(long j);

    public static native int getHandleMaskHeight(long j);

    public static native float getHandleMaskThreshold(long j);

    public static native float getHandleMaskTop(long j);

    public static native int getHandleMaskWidth(long j);

    public static native int getHandleOrientation(long j);

    public static native int getHandleReferenceCount(long j);

    public static native int getHandleReserveData(long j, ReserveHandleData reserveHandleData);

    public static native float[] getHandleResult(long j);

    public static native int getHandleResultLength(long j);

    public static native long getHandleTimeStamp(long j);

    public static native int getHandleType(long j);

    public static native int getVersion();

    public static native int increaseHandleReference(long j);

    public static native int setHandleFaceHandle(long j, long j2);

    public static native int setHandleInput(long j, int i, long j2, int i2, int i3, int i4, boolean z, int i5, boolean z2, ByteBuffer byteBuffer);

    public static native int setHandleMaskData(long j, int i, int i2, int i3, byte[] bArr);

    public static native int setHandleMaskThreshold(long j, float f);

    public static native int setHandleReserveData(long j, ReserveHandleData reserveHandleData);

    public static native int setHandleResult(long j, int i, float[] fArr);
}
