package com.szabh.smable3.watchface;

import OXOo.OOXIXo;

/* loaded from: classes13.dex */
public final class WatchFaceBuilder {
    public static final int BMP_565 = 2;
    public static final int ELEMENT_BACKGROUND = 2;
    public static final int ELEMENT_BG_DYNAMIC = 23;
    public static final int ELEMENT_BG_IMAGE_ARRAY = 44;
    public static final int ELEMENT_DIGITAL_AMPM = 12;
    public static final int ELEMENT_DIGITAL_BAT = 18;
    public static final int ELEMENT_DIGITAL_BT = 19;
    public static final int ELEMENT_DIGITAL_CALORIE = 16;
    public static final int ELEMENT_DIGITAL_DAY = 8;
    public static final int ELEMENT_DIGITAL_DISTANCE = 17;
    public static final int ELEMENT_DIGITAL_DIV_HOUR = 20;
    public static final int ELEMENT_DIGITAL_DIV_MONTH = 21;
    public static final int ELEMENT_DIGITAL_HEART = 15;
    public static final int ELEMENT_DIGITAL_HOUR = 9;
    public static final int ELEMENT_DIGITAL_ICON = 22;
    public static final int ELEMENT_DIGITAL_MIN = 10;
    public static final int ELEMENT_DIGITAL_MONTH = 7;
    public static final int ELEMENT_DIGITAL_SEC = 11;
    public static final int ELEMENT_DIGITAL_STEP = 14;
    public static final int ELEMENT_DIGITAL_WEEKDAY = 13;
    public static final int ELEMENT_DIGITAL_YEAR = 6;
    public static final int ELEMENT_NEEDLE_HOUR = 3;
    public static final int ELEMENT_NEEDLE_MIN = 4;
    public static final int ELEMENT_NEEDLE_SEC = 5;
    public static final int ELEMENT_PREVIEW = 1;
    public static final int GRAVITY_X_CENTER = 4;
    public static final int GRAVITY_X_CENTER_R = 2;
    public static final int GRAVITY_X_LEFT = 1;
    public static final int GRAVITY_X_RIGHT = 2;
    public static final int GRAVITY_X_RIGHT_R = 4;
    public static final int GRAVITY_Y_BOTTOM = 16;
    public static final int GRAVITY_Y_BOTTOM_R = 32;
    public static final int GRAVITY_Y_CENTER = 32;
    public static final int GRAVITY_Y_CENTER_R = 16;
    public static final int GRAVITY_Y_TOP = 8;

    @OOXIXo
    public static final WatchFaceBuilder INSTANCE;
    public static final int PNG_ARGB_8888 = 1;

    static {
        WatchFaceBuilder watchFaceBuilder = new WatchFaceBuilder();
        INSTANCE = watchFaceBuilder;
        System.loadLibrary("smawatchface");
        watchFaceBuilder.initLib();
    }

    private WatchFaceBuilder() {
    }

    @OOXIXo
    public final native byte[] build(@OOXIXo Element[] elementArr, int i);

    public final native void initLib();
}
