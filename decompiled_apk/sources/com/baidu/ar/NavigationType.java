package com.baidu.ar;

/* loaded from: classes7.dex */
public enum NavigationType {
    None(-1),
    AREngine(0),
    ARCore(1),
    ARIMU(2),
    ARPedometer(3);

    private int value;

    NavigationType(int i) {
        this.value = i;
    }
}
