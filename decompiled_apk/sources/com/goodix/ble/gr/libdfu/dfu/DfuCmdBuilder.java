package com.goodix.ble.gr.libdfu.dfu;

import com.goodix.ble.gr.libdfu.dfu.entity.ImgInfo;
import com.goodix.ble.libcomx.transceiver.IFrameBuilder;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class DfuCmdBuilder implements IFrameBuilder {
    public static int calcChecksum(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            i2 = bArr.length - i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += bArr[i] & 255;
            i++;
        }
        return i3;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameBuilder
    public void buildFrame(HexBuilder hexBuilder, int i, IFrameSdu4Tx iFrameSdu4Tx) {
        hexBuilder.put(ImgInfo.VALID_PATTERN, 2);
        hexBuilder.put(i, 2);
        int sduSize = iFrameSdu4Tx.getSduSize();
        hexBuilder.put(sduSize, 2);
        hexBuilder.setRange(6, sduSize);
        hexBuilder.setPos(0);
        iFrameSdu4Tx.serialize(hexBuilder);
        int calcChecksum = calcChecksum(hexBuilder.getBuffer(), 2, sduSize + 4);
        hexBuilder.setRange(sduSize + 6, 2);
        hexBuilder.setPos(0);
        hexBuilder.put(calcChecksum, 2);
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameBuilder
    public int calcFrameSize(int i, IFrameSdu4Tx iFrameSdu4Tx) {
        return iFrameSdu4Tx.getSduSize() + 8;
    }
}
