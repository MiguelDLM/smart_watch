package com.goodix.ble.libcomx.transceiver;

import com.goodix.ble.libcomx.util.HexBuilder;
import com.goodix.ble.libcomx.util.HexReader;

/* loaded from: classes9.dex */
public class EmptySdu implements IFrameSdu4Tx, IFrameSdu4Rx {
    private static final EmptySdu INSTANCE = new EmptySdu();

    public static EmptySdu getInstance() {
        return INSTANCE;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx
    public void deserialize(HexReader hexReader) {
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        return 0;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
    }
}
