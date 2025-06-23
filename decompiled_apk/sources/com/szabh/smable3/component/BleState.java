package com.szabh.smable3.component;

import OXOo.OOXIXo;

/* loaded from: classes13.dex */
public final class BleState {
    public static final int CONNECTED = 0;
    public static final int DISCONNECTED = -1;

    @OOXIXo
    public static final BleState INSTANCE = new BleState();
    public static final int READY = 1;

    private BleState() {
    }
}
