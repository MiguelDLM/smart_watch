package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.util.HexReader;

/* loaded from: classes9.dex */
public class XGetFlashInfoResponse implements IFrameSdu4Rx {
    public int id;
    public int response;
    public int size;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx
    public void deserialize(HexReader hexReader) {
        this.response = hexReader.get(1);
        this.id = hexReader.get(4);
        this.size = hexReader.get(4);
    }
}
