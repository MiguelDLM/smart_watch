package com.baidu.ar.marker;

/* loaded from: classes7.dex */
public enum WorkType {
    WORK_LOCALIZATION(2),
    WORK_NAVIGATION(3);

    private int value;

    WorkType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
