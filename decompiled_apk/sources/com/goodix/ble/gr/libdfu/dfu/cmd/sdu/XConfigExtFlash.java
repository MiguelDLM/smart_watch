package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XConfigExtFlash implements IFrameSdu4Tx {
    public static final int PIN_CLK = 1;
    public static final int PIN_CS = 0;
    public static final int PIN_IO2 = 4;
    public static final int PIN_IO3 = 5;
    public static final int PIN_MISO_IO1 = 3;
    public static final int PIN_MOSI_IO0 = 2;
    public static final int QSPI_PIN_CNT = 6;
    public static final int SPI_PIN_CNT = 4;
    public static final int SPI_TYPE_QSPI = 2;
    public static final int SPI_TYPE_SPI = 1;
    public int[] pinCfg = new int[18];
    public int qspiModule;
    public int spiType;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        int i;
        if (this.spiType == 2) {
            i = 19;
        } else {
            i = 12;
        }
        return i + 1;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.spiType, 1);
        int i = 0;
        if (this.spiType == 2) {
            while (i < 6) {
                int i2 = i * 3;
                hexBuilder.put(this.pinCfg[i2], 1);
                hexBuilder.put(this.pinCfg[i2 + 1], 1);
                hexBuilder.put(this.pinCfg[i2 + 2], 1);
                i++;
            }
            hexBuilder.put(this.qspiModule, 1);
            return;
        }
        while (i < 4) {
            int i3 = i * 3;
            hexBuilder.put(this.pinCfg[i3], 1);
            hexBuilder.put(this.pinCfg[i3 + 1], 1);
            hexBuilder.put(this.pinCfg[i3 + 2], 1);
            i++;
        }
    }

    public void setPin(int i, int i2, int i3, int i4) {
        int i5 = i * 3;
        int[] iArr = this.pinCfg;
        iArr[i5] = i2;
        iArr[i5 + 1] = i3;
        iArr[i5 + 2] = i4;
    }

    public void setQspiModule(int i) {
        this.qspiModule = i;
    }

    public void setSpiType(boolean z) {
        int i;
        if (z) {
            i = 2;
        } else {
            i = 1;
        }
        this.spiType = i;
    }
}
