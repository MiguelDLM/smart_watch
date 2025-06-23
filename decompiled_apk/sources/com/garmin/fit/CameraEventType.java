package com.garmin.fit;

/* loaded from: classes9.dex */
public enum CameraEventType {
    VIDEO_START(0),
    VIDEO_SPLIT(1),
    VIDEO_END(2),
    PHOTO_TAKEN(3),
    VIDEO_SECOND_STREAM_START(4),
    VIDEO_SECOND_STREAM_SPLIT(5),
    VIDEO_SECOND_STREAM_END(6),
    VIDEO_SPLIT_START(7),
    VIDEO_SECOND_STREAM_SPLIT_START(8),
    VIDEO_PAUSE(11),
    VIDEO_SECOND_STREAM_PAUSE(12),
    VIDEO_RESUME(13),
    VIDEO_SECOND_STREAM_RESUME(14),
    INVALID(255);

    protected short value;

    CameraEventType(short s) {
        this.value = s;
    }

    public static CameraEventType getByValue(Short sh) {
        for (CameraEventType cameraEventType : values()) {
            if (sh.shortValue() == cameraEventType.value) {
                return cameraEventType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(CameraEventType cameraEventType) {
        return cameraEventType.name();
    }

    public short getValue() {
        return this.value;
    }
}
