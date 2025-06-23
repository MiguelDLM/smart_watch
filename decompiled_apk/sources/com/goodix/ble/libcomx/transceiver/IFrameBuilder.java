package com.goodix.ble.libcomx.transceiver;

import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public interface IFrameBuilder {
    void buildFrame(HexBuilder hexBuilder, int i, IFrameSdu4Tx iFrameSdu4Tx);

    int calcFrameSize(int i, IFrameSdu4Tx iFrameSdu4Tx);
}
