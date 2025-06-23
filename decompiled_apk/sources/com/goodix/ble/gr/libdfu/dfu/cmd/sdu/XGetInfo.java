package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;
import com.goodix.ble.libcomx.util.HexReader;

/* loaded from: classes9.dex */
public class XGetInfo implements IFrameSdu4Tx, IFrameSdu4Rx {
    public int sdkBuild;
    public int sdkMajor;
    public int sdkMinor;
    public int sdkSvn;
    public int stackBuild;
    public int stackMajor;
    public int stackMinor;
    public int stackSvn;
    public boolean success;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx
    public void deserialize(HexReader hexReader) {
        boolean z;
        if (hexReader.get(1) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.success = z;
        if (!z) {
            return;
        }
        this.stackMajor = hexReader.get(1);
        this.stackMinor = hexReader.get(1);
        this.stackBuild = hexReader.get(2);
        this.stackSvn = hexReader.get(4);
        this.sdkMajor = hexReader.get(1);
        this.sdkMinor = hexReader.get(1);
        this.sdkBuild = hexReader.get(2);
        this.sdkSvn = hexReader.get(4);
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        if (this.success) {
            return 17;
        }
        return 1;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        int i;
        if (this.success) {
            i = 1;
        } else {
            i = 2;
        }
        hexBuilder.put(i, 1);
        if (this.success) {
            hexBuilder.put(this.stackMajor, 1);
            hexBuilder.put(this.stackMinor, 1);
            hexBuilder.put(this.stackBuild, 2);
            hexBuilder.put(this.stackSvn, 4);
            hexBuilder.put(this.sdkMajor, 1);
            hexBuilder.put(this.sdkMinor, 1);
            hexBuilder.put(this.sdkBuild, 2);
            hexBuilder.put(this.sdkSvn, 4);
        }
    }
}
