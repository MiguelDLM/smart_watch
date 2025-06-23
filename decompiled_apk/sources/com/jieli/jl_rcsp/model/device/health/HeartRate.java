package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class HeartRate extends HealthData {
    private static final int DATA_INTERVAL = 1;
    private int maxValue;
    private int realTimeValue;
    private int restingValue;
    private int singleTestValue;

    public HeartRate(int i, byte b, byte[] bArr) {
        super(0, b, bArr, i);
        parseHeartRateData(i, b, bArr);
    }

    private int getValueFromData(int i, byte[] bArr) {
        if (bArr != null && i + 1 <= bArr.length) {
            return CHexConver.byteToInt(bArr[i]);
        }
        return 0;
    }

    private void parseHeartRateData(int i, byte b, byte[] bArr) {
        if (i == 0) {
            byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(b);
            int i2 = 0;
            for (int i3 = 0; i3 < booleanArrayBig.length; i3++) {
                if (booleanArrayBig[i3] == 1) {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    this.singleTestValue = getValueFromData(i2, bArr);
                                }
                            } else {
                                this.maxValue = getValueFromData(i2, bArr);
                            }
                        } else {
                            this.restingValue = getValueFromData(i2, bArr);
                        }
                    } else {
                        this.realTimeValue = getValueFromData(i2, bArr);
                    }
                    i2++;
                }
            }
            return;
        }
        JL_Log.e("HeartRate", "parseHeartRateData", "no support version : " + i);
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public int getRealTimeValue() {
        return this.realTimeValue;
    }

    public int getRestingValue() {
        return this.restingValue;
    }

    public int getSingleTestValue() {
        return this.singleTestValue;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.HealthData
    public String toString() {
        return "HeartRate{realTimeValue=" + this.realTimeValue + ", restingValue=" + this.restingValue + ", maxValue=" + this.maxValue + ", singleTestValue=" + this.singleTestValue + "} " + super.toString();
    }
}
