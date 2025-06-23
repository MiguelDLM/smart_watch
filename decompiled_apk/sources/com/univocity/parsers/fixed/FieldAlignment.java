package com.univocity.parsers.fixed;

/* loaded from: classes13.dex */
public enum FieldAlignment {
    LEFT,
    CENTER,
    RIGHT;

    public int calculatePadding(int i, int i2) {
        if (this != LEFT && i > i2) {
            if (this == RIGHT) {
                return i - i2;
            }
            int i3 = (i / 2) - (i2 / 2);
            if (i2 + i3 > i) {
                return i3 - 1;
            }
            return i3;
        }
        return 0;
    }
}
