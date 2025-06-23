package com.baidu.ar.arplay.core.pixel;

/* loaded from: classes7.dex */
public enum PixelType {
    RGBA(0),
    BGRA(1),
    BGR(2),
    NV12(3),
    NV21(4),
    I420(5),
    YV12(6),
    GRAY(7),
    RGB(8),
    RED(9),
    GREEN(10),
    BLUE(11),
    ALPHA(12);

    private final int value;

    PixelType(int i) {
        this.value = i;
    }

    public static PixelType valueOf(int i) {
        PixelType pixelType = RGBA;
        if (i == pixelType.getValue()) {
            return pixelType;
        }
        PixelType pixelType2 = BGRA;
        if (i == pixelType2.getValue()) {
            return pixelType2;
        }
        PixelType pixelType3 = BGR;
        if (i == pixelType3.getValue()) {
            return pixelType3;
        }
        PixelType pixelType4 = NV12;
        if (i == pixelType4.getValue()) {
            return pixelType4;
        }
        PixelType pixelType5 = NV21;
        if (i == pixelType5.getValue()) {
            return pixelType5;
        }
        PixelType pixelType6 = I420;
        if (i == pixelType6.getValue()) {
            return pixelType6;
        }
        PixelType pixelType7 = YV12;
        if (i == pixelType7.getValue()) {
            return pixelType7;
        }
        PixelType pixelType8 = GRAY;
        if (i == pixelType8.getValue()) {
            return pixelType8;
        }
        PixelType pixelType9 = RGB;
        if (i == pixelType9.getValue()) {
            return pixelType9;
        }
        PixelType pixelType10 = RED;
        if (i == pixelType10.getValue()) {
            return pixelType10;
        }
        PixelType pixelType11 = GREEN;
        if (i == pixelType11.getValue()) {
            return pixelType11;
        }
        PixelType pixelType12 = BLUE;
        if (i == pixelType12.getValue()) {
            return pixelType12;
        }
        PixelType pixelType13 = ALPHA;
        return i == pixelType13.getValue() ? pixelType13 : pixelType;
    }

    public int getValue() {
        return this.value;
    }
}
