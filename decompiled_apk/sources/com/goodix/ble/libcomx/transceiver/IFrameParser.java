package com.goodix.ble.libcomx.transceiver;

import com.goodix.ble.libcomx.util.HexReader;

/* loaded from: classes9.dex */
public interface IFrameParser {
    IFrameSdu4Rx parseSdu(int i, HexReader hexReader);
}
