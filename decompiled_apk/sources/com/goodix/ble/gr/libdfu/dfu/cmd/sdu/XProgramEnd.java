package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XProgramEnd implements IFrameSdu4Tx {
    public static final int RESET_FLAG_FIRMWARE_NOT_RESET = 0;
    public static final int RESET_FLAG_FIRMWARE_RESET_AND_RUN = 1;
    public static final int RESET_FLAG_RESOURCE_EXT_FLASH = 18;
    public static final int RESET_FLAG_RESOURCE_INNER_FLASH = 2;

    /* renamed from: a, reason: collision with root package name */
    private static final int f16081a = 1;
    private static final int b = 4;
    public int checksum;
    public int resetFlag;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        return 5;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.resetFlag, 1);
        hexBuilder.put(this.checksum, 4);
    }
}
