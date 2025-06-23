package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XUpdateFlash implements IFrameSdu4Tx {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16087a = 1;
    private static final int b = 4;
    private static final int c = 2;
    public int address;
    public byte[] data;
    public boolean extFlash;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 7;
        }
        return bArr.length + 7;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.extFlash ? 1 : 0, 1);
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
