package com.baidu.ar;

/* loaded from: classes7.dex */
public enum NavigationConfiguration {
    VPAS(0),
    VIO(1),
    IMU(2),
    ARPedometer(3),
    NPC_VIO(4),
    NPC_IMU(5);

    private int value;

    NavigationConfiguration(int i) {
        this.value = i;
    }
}
