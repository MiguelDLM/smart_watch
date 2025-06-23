package com.baidu.ar.face.algo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class FaceAlgoConfig implements Parcelable {
    public static final Parcelable.Creator<FaceAlgoConfig> CREATOR = new Parcelable.Creator<FaceAlgoConfig>() { // from class: com.baidu.ar.face.algo.FaceAlgoConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FaceAlgoConfig createFromParcel(Parcel parcel) {
            return new FaceAlgoConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FaceAlgoConfig[] newArray(int i) {
            return new FaceAlgoConfig[i];
        }
    };
    boolean autoCalibrate;
    boolean debug;
    float eyeCloseProbThreshold;
    int failureThreshold;
    boolean forceLost;
    boolean isAnimojiMode;
    int maxTrackingFace;
    float minDetectionWidth;
    boolean mirror;
    boolean needExpression;
    boolean needHeadPose;
    boolean needRefineEyes;
    boolean needRefineIris;
    boolean needRefineMouth;
    boolean needSkeleton;
    boolean needTriggers;
    int runningMode;
    float trackingMouthSmoothAlpha;
    float trackingMouthThreshold;
    int trackingQuality;
    int trackingRotation;
    float trackingSmoothAlpha;
    float trackingSmoothThreshold;

    public FaceAlgoConfig(int i) {
        this.runningMode = 0;
        this.maxTrackingFace = 1;
        this.failureThreshold = 5;
        this.minDetectionWidth = 100.0f;
        this.trackingSmoothAlpha = 0.1f;
        this.trackingSmoothThreshold = 1.0f;
        this.trackingMouthThreshold = -1.0f;
        this.trackingMouthSmoothAlpha = 0.0075f;
        this.eyeCloseProbThreshold = -1.0f;
        this.mirror = true;
        this.isAnimojiMode = false;
        this.needRefineEyes = false;
        this.needRefineIris = false;
        this.needHeadPose = true;
        this.needSkeleton = true;
        this.needTriggers = true;
        this.forceLost = false;
        this.needRefineMouth = false;
        this.needExpression = false;
        this.debug = false;
        this.trackingRotation = i;
    }

    public FaceAlgoConfig cloneInstance() {
        FaceAlgoConfig faceAlgoConfig = new FaceAlgoConfig(this.trackingRotation, this.failureThreshold, this.trackingSmoothAlpha, this.trackingSmoothThreshold);
        faceAlgoConfig.setAnimateRunningMode(this.needHeadPose, this.needSkeleton, this.needTriggers);
        faceAlgoConfig.setAutoCalibrate(this.autoCalibrate);
        faceAlgoConfig.setRunningMode(this.runningMode);
        faceAlgoConfig.setMirror(this.mirror);
        faceAlgoConfig.setIsAnimojiMode(this.isAnimojiMode);
        faceAlgoConfig.setMaxTrackingFace(this.maxTrackingFace);
        faceAlgoConfig.setNeedRefineEyes(this.needRefineEyes);
        faceAlgoConfig.setForceLost(this.forceLost);
        faceAlgoConfig.setNeedRefineMouth(this.needRefineMouth);
        faceAlgoConfig.setNeedExpression(this.needExpression);
        faceAlgoConfig.setTrackingMouthThreshold(this.trackingMouthThreshold);
        faceAlgoConfig.setTrackingMouthSmoothAlpha(this.trackingMouthSmoothAlpha);
        return faceAlgoConfig;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setAnimateRunningMode(boolean z, boolean z2, boolean z3) {
        this.needHeadPose = z;
        this.needSkeleton = z2;
        this.needTriggers = z3;
    }

    public void setAutoCalibrate(boolean z) {
        this.autoCalibrate = z;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setEyeCloseProbThreshold(float f) {
        this.eyeCloseProbThreshold = f;
    }

    public void setFailureThreshold(int i) {
        this.failureThreshold = i;
    }

    public void setForceLost(boolean z) {
        this.forceLost = z;
    }

    public void setIsAnimojiMode(boolean z) {
        this.isAnimojiMode = z;
    }

    public void setMaxTrackingFace(int i) {
        this.maxTrackingFace = i;
    }

    public void setMirror(boolean z) {
        this.mirror = z;
    }

    public void setNeedExpression(boolean z) {
        this.needExpression = z;
    }

    public void setNeedHeadPose(boolean z) {
        this.needHeadPose = z;
    }

    public void setNeedRefineEyes(boolean z) {
        this.needRefineEyes = z;
        this.needRefineIris = z;
    }

    public void setNeedRefineMouth(boolean z) {
        this.needRefineMouth = z;
    }

    public void setNeedSkeleton(boolean z) {
        this.needSkeleton = z;
    }

    public void setNeedTriggers(boolean z) {
        this.needTriggers = z;
    }

    public void setRunningMode(int i) {
        this.runningMode = i;
    }

    public void setTrackingMouthSmoothAlpha(float f) {
        this.trackingMouthSmoothAlpha = f;
    }

    public void setTrackingMouthThreshold(float f) {
        this.trackingMouthThreshold = f;
    }

    public void setTrackingRT(int i) {
        this.trackingRotation = i;
    }

    public void setTrackingSmoothAlpha(float f) {
        this.trackingSmoothAlpha = f;
    }

    public void setTrackingSmoothThreshold(float f) {
        this.trackingSmoothThreshold = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.runningMode);
        parcel.writeInt(this.maxTrackingFace);
        parcel.writeInt(this.trackingRotation);
        parcel.writeInt(this.failureThreshold);
        parcel.writeFloat(this.minDetectionWidth);
        parcel.writeFloat(this.trackingSmoothAlpha);
        parcel.writeFloat(this.trackingSmoothThreshold);
        parcel.writeFloat(this.trackingMouthThreshold);
        parcel.writeFloat(this.trackingMouthSmoothAlpha);
        parcel.writeFloat(this.eyeCloseProbThreshold);
        parcel.writeByte(this.mirror ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAnimojiMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needRefineEyes ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needRefineIris ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needRefineMouth ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needHeadPose ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needSkeleton ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needTriggers ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needExpression ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.forceLost ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.debug ? (byte) 1 : (byte) 0);
    }

    public FaceAlgoConfig(int i, int i2, float f, float f2) {
        this.runningMode = 0;
        this.maxTrackingFace = 1;
        this.minDetectionWidth = 100.0f;
        this.trackingMouthThreshold = -1.0f;
        this.trackingMouthSmoothAlpha = 0.0075f;
        this.eyeCloseProbThreshold = -1.0f;
        this.mirror = true;
        this.isAnimojiMode = false;
        this.needRefineEyes = false;
        this.needRefineIris = false;
        this.needHeadPose = true;
        this.needSkeleton = true;
        this.needTriggers = true;
        this.forceLost = false;
        this.needRefineMouth = false;
        this.needExpression = false;
        this.debug = false;
        this.trackingRotation = i;
        this.failureThreshold = i2;
        this.trackingSmoothAlpha = f;
        this.trackingSmoothThreshold = f2;
    }

    public FaceAlgoConfig(Parcel parcel) {
        this.runningMode = 0;
        this.maxTrackingFace = 1;
        this.trackingRotation = -1;
        this.failureThreshold = 5;
        this.minDetectionWidth = 100.0f;
        this.trackingSmoothAlpha = 0.1f;
        this.trackingSmoothThreshold = 1.0f;
        this.trackingMouthThreshold = -1.0f;
        this.trackingMouthSmoothAlpha = 0.0075f;
        this.eyeCloseProbThreshold = -1.0f;
        this.mirror = true;
        this.isAnimojiMode = false;
        this.needRefineEyes = false;
        this.needRefineIris = false;
        this.needHeadPose = true;
        this.needSkeleton = true;
        this.needTriggers = true;
        this.forceLost = false;
        this.needRefineMouth = false;
        this.needExpression = false;
        this.debug = false;
        this.runningMode = parcel.readInt();
        this.maxTrackingFace = parcel.readInt();
        this.trackingRotation = parcel.readInt();
        this.failureThreshold = parcel.readInt();
        this.minDetectionWidth = parcel.readFloat();
        this.trackingSmoothAlpha = parcel.readFloat();
        this.trackingSmoothThreshold = parcel.readFloat();
        this.trackingMouthThreshold = parcel.readFloat();
        this.trackingMouthSmoothAlpha = parcel.readFloat();
        this.eyeCloseProbThreshold = parcel.readFloat();
        this.mirror = parcel.readByte() != 0;
        this.isAnimojiMode = parcel.readByte() != 0;
        this.needRefineEyes = parcel.readByte() != 0;
        this.needRefineIris = parcel.readByte() != 0;
        this.needRefineMouth = parcel.readByte() != 0;
        this.needHeadPose = parcel.readByte() != 0;
        this.needSkeleton = parcel.readByte() != 0;
        this.needTriggers = parcel.readByte() != 0;
        this.needExpression = parcel.readByte() != 0;
        this.forceLost = parcel.readByte() != 0;
        this.debug = parcel.readByte() != 0;
    }
}
