package com.baidu.ar.bean;

import android.graphics.Bitmap;
import android.graphics.Point;

/* loaded from: classes7.dex */
public class Watermark {
    private Bitmap mBitmap;
    private String mFilePath;
    private float[] mRenderRect;
    private Point mStartPoint;
    private StorageType mStorageType = StorageType.SDCARD;
    private CoordinateType mCoordinateType = CoordinateType.LEFT_BOTTOM;
    private RotationType mRotationType = RotationType.ROTATE_0;
    private float mScale = 1.0f;

    /* loaded from: classes7.dex */
    public enum CoordinateType {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public Watermark(Bitmap bitmap, Point point) {
        this.mBitmap = bitmap;
        this.mStartPoint = point;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public CoordinateType getCoordinateType() {
        return this.mCoordinateType;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public float[] getRenderRect() {
        return this.mRenderRect;
    }

    public RotationType getRotationType() {
        return this.mRotationType;
    }

    public float getScale() {
        return this.mScale;
    }

    public Point getStartPoint() {
        return this.mStartPoint;
    }

    public StorageType getStorageType() {
        return this.mStorageType;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setCoordinateType(CoordinateType coordinateType) {
        this.mCoordinateType = coordinateType;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setRenderRect(float[] fArr) {
        this.mRenderRect = fArr;
    }

    public void setRotationType(RotationType rotationType) {
        this.mRotationType = rotationType;
    }

    public void setScale(float f) {
        this.mScale = f;
    }

    public void setStartPoint(Point point) {
        this.mStartPoint = point;
    }

    public void setStorageType(StorageType storageType) {
        this.mStorageType = storageType;
    }

    public Watermark(String str, Point point) {
        this.mFilePath = str;
        this.mStartPoint = point;
    }
}
