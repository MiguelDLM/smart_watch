package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XReadRam implements IFrameSdu4Tx {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16084a = 4;
    private static final int b = 2;
    public int address;
    public int length;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        return 6;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.address, 4);
        hexBuilder.put(this.length, 2);
    }
}
