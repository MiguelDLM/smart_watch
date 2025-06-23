package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class PressureDetection extends HealthData {
    private int detectionValue;

    public PressureDetection(int i, byte b, byte[] bArr) {
        super(5, b, bArr, i);
        parsePressureDetectionData(i, b, bArr);
    }

    private void parsePressureDetectionData(int i, byte b, byte[] bArr) {
        if (i == 0) {
            byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(b);
            int i2 = 0;
            for (int i3 = 0; i3 < booleanArrayBig.length; i3++) {
                if (booleanArrayBig[i3] == 1 && i3 == 0) {
                    this.detectionValue = CHexConver.byteToInt(bArr[i2]);
                    i2++;
                }
            }
            return;
        }
        JL_Log.e("PressureDetection", "parsePressureDetectionData", "no support version : " + i);
    }

    public int getDetectionValue() {
        return this.detectionValue;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.HealthData
    public String toString() {
        return "PressureDetection{detectionValue=" + this.detectionValue + "} " + super.toString();
    }
}
