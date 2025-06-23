package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class HeartRateMeasure implements IHealthSettingToAttr {
    public static final byte MODE_BRIGHT = 0;
    public static final byte MODE_SHAKE = 1;
    private boolean enable;
    private int maxHeartRate = -1;
    private int minHeartRate = -1;
    private byte mode;

    public HeartRateMeasure(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            boolean z = false;
            int i = 1;
            if (CHexConver.byteToInt(bArr[0]) == 1) {
                z = true;
            }
            this.enable = z;
            if (bArr.length > 1) {
                this.mode = bArr[1];
                i = 2;
            }
            if (bArr.length > 2) {
                this.maxHeartRate = CHexConver.byteToInt(bArr[i]);
                i++;
            }
            if (bArr.length > 3) {
                this.minHeartRate = CHexConver.byteToInt(bArr[i]);
            }
        }
    }

    private byte[] toData() {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{this.enable ? (byte) 1 : (byte) 0, this.mode});
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = this.maxHeartRate;
        if (i == -1 && this.minHeartRate == -1) {
            bArr = null;
        } else {
            if (i == -1) {
                this.maxHeartRate = 0;
            }
            if (this.minHeartRate == -1) {
                this.minHeartRate = 0;
            }
            bArr = new byte[]{CHexConver.intToByte(this.maxHeartRate), CHexConver.intToByte(this.minHeartRate)};
        }
        if (bArr != null) {
            try {
                byteArrayOutputStream.write(bArr);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int getMaxHeartRate() {
        return this.maxHeartRate;
    }

    public int getMinHeartRate() {
        return this.minHeartRate;
    }

    public byte getMode() {
        return this.mode;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public int getType() {
        return 3;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public HeartRateMeasure setEnable(boolean z) {
        this.enable = z;
        return this;
    }

    public HeartRateMeasure setMaxHeartRate(int i) {
        this.maxHeartRate = i;
        return this;
    }

    public HeartRateMeasure setMinHeartRate(int i) {
        this.minHeartRate = i;
        return this;
    }

    public HeartRateMeasure setMode(byte b) {
        this.mode = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        return new AttrBean().setType((byte) getType()).setAttrData(toData());
    }

    public String toString() {
        return "HeartRateMeasure{enable=" + this.enable + ", mode=" + ((int) this.mode) + ", maxHeartRate=" + this.maxHeartRate + ", minHeartRate=" + this.minHeartRate + '}';
    }
}
