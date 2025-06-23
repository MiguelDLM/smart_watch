package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.util.HexReader;

/* loaded from: classes9.dex */
public class XReadRamResponse implements IFrameSdu4Rx {
    public int address;
    public byte[] data;
    public int length;
    public int response;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx
    public void deserialize(HexReader hexReader) {
        this.response = hexReader.get(1);
        this.address = hexReader.get(4);
        int i = hexReader.get(2);
        this.length = i;
        if (i > hexReader.getRemainSize()) {
            this.length = hexReader.getRemainSize();
        }
        if (this.length < 0) {
            this.length = 0;
        }
        int i2 = this.length;
        byte[] bArr = new byte[i2];
        this.data = bArr;
        hexReader.get(bArr, 0, i2);
    }
}
