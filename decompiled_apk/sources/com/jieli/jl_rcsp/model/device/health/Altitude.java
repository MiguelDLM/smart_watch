package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class Altitude extends HealthData {
    private static final int DATA_INTERVAL = 4;
    private int maxValue;
    private int minValue;
    private int realTimeValue;

    public Altitude(int i, byte b, byte[] bArr) {
        super(2, b, bArr, i);
        parseAltitudeData(i, b, bArr);
    }

    private int getValueFromData(int i, byte[] bArr) {
        if (bArr != null && i + 4 <= bArr.length) {
            return CHexConver.bytesToInt(bArr, i, 4);
        }
        return 0;
    }

    private void parseAltitudeData(int i, byte b, byte[] bArr) {
        if (i == 0) {
            byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(b);
            int i2 = 0;
            for (int i3 = 0; i3 < booleanArrayBig.length; i3++) {
                if (booleanArrayBig[i3] == 1) {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                this.maxValue = getValueFromData(i2, bArr);
                            }
                        } else {
                            this.minValue = getValueFromData(i2, bArr);
                        }
                    } else {
                        this.realTimeValue = getValueFromData(i2, bArr);
                    }
                    i2 += 4;
                }
            }
            return;
        }
        JL_Log.e("Altitude", "parseAltitudeData", "no support version : " + i);
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public int getMinValue() {
        return this.minValue;
    }

    public int getRealTimeValue() {
        return this.realTimeValue;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.HealthData
    public String toString() {
        return "Altitude{realTimeValue=" + this.realTimeValue + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + "} " + super.toString();
    }
}
