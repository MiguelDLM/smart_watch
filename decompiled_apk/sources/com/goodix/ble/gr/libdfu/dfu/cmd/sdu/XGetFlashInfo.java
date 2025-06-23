package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XGetFlashInfo implements IFrameSdu4Tx {

    /* renamed from: a, reason: collision with root package name */
    private boolean f16079a;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        return 1;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.f16079a ? 1 : 0, 1);
    }

    public XGetFlashInfo setFlashType(boolean z) {
        this.f16079a = z;
        return this;
    }
}
