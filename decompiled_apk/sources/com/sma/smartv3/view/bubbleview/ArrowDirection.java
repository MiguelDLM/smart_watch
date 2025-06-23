package com.sma.smartv3.view.bubbleview;

/* loaded from: classes12.dex */
public enum ArrowDirection {
    LEFT(0),
    RIGHT(1),
    TOP(2),
    BOTTOM(3),
    LEFT_CENTER(4),
    RIGHT_CENTER(5),
    TOP_CENTER(6),
    BOTTOM_CENTER(7),
    TOP_RIGHT(8),
    BOTTOM_RIGHT(9);

    private int value;

    ArrowDirection(int value) {
        this.value = value;
    }

    public static ArrowDirection fromInt(int value) {
        for (ArrowDirection arrowDirection : values()) {
            if (value == arrowDirection.getValue()) {
                return arrowDirection;
            }
        }
        return LEFT;
    }

    public int getValue() {
        return this.value;
    }
}
