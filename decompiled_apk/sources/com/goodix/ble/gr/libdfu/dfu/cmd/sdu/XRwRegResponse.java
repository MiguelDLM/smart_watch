package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.util.HexReader;

/* loaded from: classes9.dex */
public class XRwRegResponse implements IFrameSdu4Rx {
    public int response;
    public Integer value;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx
    public void deserialize(HexReader hexReader) {
        this.response = hexReader.get(1);
        if (hexReader.getRemainSize() >= 4) {
            this.value = Integer.valueOf(hexReader.get(4));
        }
    }
}
