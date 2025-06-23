package com.garmin.fit;

/* loaded from: classes9.dex */
public enum CameraOrientationType {
    CAMERA_ORIENTATION_0(0),
    CAMERA_ORIENTATION_90(1),
    CAMERA_ORIENTATION_180(2),
    CAMERA_ORIENTATION_270(3),
    INVALID(255);

    protected short value;

    CameraOrientationType(short s) {
        this.value = s;
    }

    public static CameraOrientationType getByValue(Short sh) {
        for (CameraOrientationType cameraOrientationType : values()) {
            if (sh.shortValue() == cameraOrientationType.value) {
                return cameraOrientationType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(CameraOrientationType cameraOrientationType) {
        return cameraOrientationType.name();
    }

    public short getValue() {
        return this.value;
    }
}
