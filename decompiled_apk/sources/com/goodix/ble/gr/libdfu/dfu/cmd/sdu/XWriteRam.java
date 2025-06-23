package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XWriteRam implements IFrameSdu4Tx {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16088a = 4;
    private static final int b = 2;
    public int address;
    public byte[] data;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 6;
        }
        return bArr.length + 6;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.address, 4);
        byte[] bArr = this.data;
        if (bArr != null) {
            hexBuilder.put(bArr.length, 2);
            hexBuilder.put(this.data);
        } else {
            hexBuilder.put(0, 2);
        }
    }
}
