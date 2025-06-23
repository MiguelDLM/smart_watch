package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class TrainingLoad extends HealthData {
    private int value;

    public TrainingLoad(int i, byte b, byte[] bArr) {
        super(6, b, bArr, i);
        parseTrainingLoadData(i, b, bArr);
    }

    private void parseTrainingLoadData(int i, byte b, byte[] bArr) {
        if (i == 0) {
            byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(b);
            int i2 = 0;
            for (int i3 = 0; i3 < booleanArrayBig.length; i3++) {
                if (booleanArrayBig[i3] == 1 && i3 == 0) {
                    this.value = CHexConver.byteToInt(bArr[i2]);
                    i2++;
                }
            }
            return;
        }
        JL_Log.e("TrainingLoad", "parseTrainingLoadData", "no support version : " + i);
    }

    public int getValue() {
        return this.value;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.HealthData
    public String toString() {
        return "TrainingLoad{value=" + this.value + "} " + super.toString();
    }
}
