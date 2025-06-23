package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class OxygenSaturation extends HealthData {
    private static final int DATA_INTERVAL = 1;
    private int maxValue;
    private int minValue;
    private int percent;
    private int singleTestValue;

    public OxygenSaturation(int i, byte b, byte[] bArr) {
        super(5, b, bArr, i);
        parseOxygenSaturationData(i, b, bArr);
    }

    private int getValueFromData(int i, byte[] bArr) {
        if (bArr != null && i + 1 <= bArr.length) {
            return CHexConver.byteToInt(bArr[i]);
        }
        return 0;
    }

    private void parseOxygenSaturationData(int i, byte b, byte[] bArr) {
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
                                this.minValue = getValueFromData(i2, bArr);
                            }
                        } else {
                            this.maxValue = getValueFromData(i2, bArr);
                        }
                    } else {
                        this.percent = getValueFromData(i2, bArr);
                    }
                    i2++;
                }
            }
            return;
        }
        JL_Log.e("OxygenSaturation", "parseOxygenSaturationData", "no support version : " + i);
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public int getMinValue() {
        return this.minValue;
    }

    public int getPercent() {
        return this.percent;
    }

    public int getSingleTestValue() {
        return this.singleTestValue;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.HealthData
    public String toString() {
        return "OxygenSaturation{percent=" + this.percent + ", maxValue=" + this.maxValue + ", minValue=" + this.minValue + ", singleTestValue=" + this.singleTestValue + "} " + super.toString();
    }
}
