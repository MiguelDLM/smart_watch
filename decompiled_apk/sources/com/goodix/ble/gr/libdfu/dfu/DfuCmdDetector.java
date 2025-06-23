package com.goodix.ble.gr.libdfu.dfu;

import com.goodix.ble.libcomx.transceiver.IFrameDetector;
import com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBuffer;

/* loaded from: classes9.dex */
public class DfuCmdDetector implements IFrameDetector {
    @Override // com.goodix.ble.libcomx.transceiver.IFrameDetector
    public boolean detectFrame(IRingBuffer iRingBuffer, IFrameDetector.ResultHolder resultHolder) {
        int i;
        int size = iRingBuffer.getSize();
        int i2 = 0;
        while (i2 < size) {
            if (iRingBuffer.get(i2) == 68) {
                int i3 = i2 + 1;
                if (iRingBuffer.get(i3) != 71) {
                    continue;
                } else {
                    if (i2 + 8 <= size) {
                        resultHolder.sduPos = 6;
                        int i4 = iRingBuffer.get(i2 + 4) + (iRingBuffer.get(i2 + 5) << 8);
                        resultHolder.sduSize = i4;
                        resultHolder.framePos = i2;
                        int i5 = i4 + 8;
                        resultHolder.frameSize = i5;
                        if (i4 <= 2048 && i5 + i2 <= size) {
                            int i6 = 0;
                            int i7 = 0;
                            while (true) {
                                i = resultHolder.sduSize;
                                if (i6 >= i + 4) {
                                    break;
                                }
                                i7 += iRingBuffer.get(i2 + 2 + i6);
                                i6++;
                            }
                            if (iRingBuffer.get(i2 + 6 + i) + (iRingBuffer.get((i2 + 7) + resultHolder.sduSize) << 8) == (65535 & i7)) {
                                resultHolder.frameType = iRingBuffer.get(i2 + 2) + (iRingBuffer.get(i2 + 3) << 8);
                                return true;
                            }
                        }
                    }
                    i2 = i3;
                }
            }
            i2++;
        }
        return false;
    }
}
