package com.baidu.datahub;

/* loaded from: classes7.dex */
public enum NavigationType {
    DRIVER(0),
    WALK(1),
    BIKE(2),
    ELECTRIC_BIKE(3);

    private int value;

    NavigationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }
}
