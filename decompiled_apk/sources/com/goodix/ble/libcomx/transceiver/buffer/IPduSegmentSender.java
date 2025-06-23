package com.goodix.ble.libcomx.transceiver.buffer;

import com.goodix.ble.libcomx.transceiver.IFrameSender;

/* loaded from: classes9.dex */
public interface IPduSegmentSender extends IFrameSender {
    void clear();

    void nextSegment();

    void setMaxSegmentSize(int i);
}
