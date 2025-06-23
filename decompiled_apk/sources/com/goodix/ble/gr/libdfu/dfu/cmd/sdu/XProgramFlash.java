package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XProgramFlash implements IFrameSdu4Tx {
    private static final int e = 1;
    private static final int f = 4;
    private static final int g = 2;

    /* renamed from: a, reason: collision with root package name */
    private int f16082a;
    public int address;
    private byte[] b;
    private int c;
    private int d;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        return this.d + 7;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.f16082a, 1);
        hexBuilder.put(this.address, 4);
        hexBuilder.put(this.d, 2);
        hexBuilder.put(this.b, this.c, this.d);
    }

    public void setData(byte[] bArr, int i, int i2) {
        this.b = bArr;
        this.c = i;
        this.d = i2;
    }

    public void setType(boolean z, int i) {
        int i2 = i & 15;
        this.f16082a = i2;
        if (z) {
            this.f16082a = i2 | 16;
        }
    }
}
