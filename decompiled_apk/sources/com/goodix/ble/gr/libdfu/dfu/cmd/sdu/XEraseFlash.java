package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XEraseFlash implements IFrameSdu4Tx {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16078a = 1;
    private static final int b = 2;
    public boolean extFlash;
    public int page;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        return 3;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.extFlash ? 1 : 0, 1);
        hexBuilder.put(this.page, 2);
    }
}
