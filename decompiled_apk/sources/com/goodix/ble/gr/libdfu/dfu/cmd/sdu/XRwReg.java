package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XRwReg implements IFrameSdu4Tx {
    private static final int d = 1;
    private static final int e = 4;
    private static final int f = 4;

    /* renamed from: a, reason: collision with root package name */
    private int f16085a;
    private int b;
    private Integer c;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        int i;
        if (this.c == null) {
            i = 0;
        } else {
            i = 4;
        }
        return i + 5;
    }

    public XRwReg readReg(int i) {
        this.b = i;
        this.c = null;
        this.f16085a = 1;
        return this;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.f16085a, 1);
        hexBuilder.put(this.b, 4);
        Integer num = this.c;
        if (num != null) {
            hexBuilder.put(num.intValue(), 4);
        }
    }

    public XRwReg writeReg(int i, int i2) {
        this.b = i;
        this.c = Integer.valueOf(i2);
        this.f16085a = 0;
        return this;
    }
}
