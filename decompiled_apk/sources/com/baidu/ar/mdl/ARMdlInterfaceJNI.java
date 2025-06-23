package com.baidu.ar.mdl;

import android.content.res.AssetManager;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class ARMdlInterfaceJNI {
    public static native int getVersion();

    public static native int initBodyKeyPoint(String str, String str2);

    public static native int initBodyKeyPointFromAssetDir(String str, String str2);

    public static native int initGesture(String str, String str2, String str3, int i, int i2, float f, float f2, float f3, int i3);

    public static native int initGestureFromAsset(String str, String str2, String str3, int i, int i2, float f, float f2, float f3, int i3);

    public static native int initHairSeg(String str);

    public static native int initHairSegFromAssetDir(String str);

    public static native int initHandSkeleton(String str, String str2);

    public static native int initHandSkeletonFromAsset(String str, String str2);

    public static native int initHeadSeg(String str);

    public static native int initHeadSegFromAsset(String str);

    public static native int initHumanSeg(String str, int i, int[] iArr, boolean z);

    public static native int initHumanSegFromAssetDir(String str, int i, int[] iArr, boolean z);

    public static native int initObjDetect(String str, String str2);

    public static native int initObjDetectFromAsset(String str, String str2);

    public static native int initPose(String str, String str2, String str3, int i, float f, float[] fArr, float[] fArr2);

    public static native int initPoseFromAsset(String str, String str2, String str3, int i, float f, float[] fArr, float[] fArr2);

    public static native int initSkySeg(String str);

    public static native int initSkySegFromAssetDir(String str);

    public static native int predictBodyKeyPoint(ByteBuffer byteBuffer, int i, int i2, int i3, float[] fArr);

    public static native int predictGesture(ByteBuffer byteBuffer, int i, int i2, int i3, boolean z, float[] fArr);

    public static native int predictHairSeg(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr, long j);

    public static native float[] predictHandSkeleton(ByteBuffer byteBuffer, int i, int i2, int i3, boolean z);

    public static native int predictHandSkeletonByHandle(long j, int i);

    public static native int predictHeadSeg(long j, boolean z);

    public static native int predictHumanSeg(ByteBuffer byteBuffer, int i, int i2, int i3, boolean z, byte[] bArr, int[] iArr, long j);

    public static native int predictObjDetect(ByteBuffer byteBuffer, int i, int i2, int i3, boolean z, float[] fArr);

    public static native int predictPose(ByteBuffer byteBuffer, int i, int i2, int i3, boolean z, float[] fArr);

    public static native int predictSkySeg(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr, long j);

    public static native int releaseBodyKeyPoint();

    public static native int releaseGesture();

    public static native int releaseHairSeg();

    public static native int releaseHandSkeleton();

    public static native int releaseHeadSeg();

    public static native int releaseHumanSeg();

    public static native int releaseObjDetect();

    public static native int releasePose();

    public static native int releaseSkySeg();

    public static native int setAssetManager(AssetManager assetManager);

    public static native int setCacheDir(String str);

    public static native int updateLastFaceInfo(long j);
}
