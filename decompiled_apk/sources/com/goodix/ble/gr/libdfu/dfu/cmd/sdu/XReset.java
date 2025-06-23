package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.gr.libdfu.dfu.entity.BootInfo;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XReset implements IFrameSdu4Tx {
    public BootInfo info;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        BootInfo bootInfo = this.info;
        if (bootInfo != null) {
            return bootInfo.getSerializeSize();
        }
        return 0;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        BootInfo bootInfo = this.info;
        if (bootInfo != null) {
            bootInfo.serialize(hexBuilder);
        }
    }
}
