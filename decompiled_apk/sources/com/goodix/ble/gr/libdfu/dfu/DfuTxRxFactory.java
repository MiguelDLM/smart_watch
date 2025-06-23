package com.goodix.ble.gr.libdfu.dfu;

import com.goodix.ble.libcomx.transceiver.IFrameSender;
import com.goodix.ble.libcomx.transceiver.Transceiver;
import com.realsil.sdk.dfu.image.constants.SubBinId;

/* loaded from: classes9.dex */
public class DfuTxRxFactory {
    public Transceiver create() {
        return new Transceiver(SubBinId.Bbpro.FACTORY_IAMGE, new DfuCmdDetector(), new DfuCmdParser(), new DfuCmdBuilder(), (IFrameSender) null);
    }
}
