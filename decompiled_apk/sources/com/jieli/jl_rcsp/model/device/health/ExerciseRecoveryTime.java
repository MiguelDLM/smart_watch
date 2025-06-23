package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

@Deprecated
/* loaded from: classes10.dex */
public class ExerciseRecoveryTime extends HealthData {
    private int hour;
    private int min;

    public ExerciseRecoveryTime(int i, byte b, byte[] bArr) {
        super(8, b, bArr, i);
        parseExerciseRecoveryTimeData(i, b, bArr);
    }

    private void parseExerciseRecoveryTimeData(int i, byte b, byte[] bArr) {
        if (i == 0) {
            byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(b);
            int i2 = 0;
            for (int i3 = 0; i3 < booleanArrayBig.length; i3++) {
                if (booleanArrayBig[i3] == 1 && i3 == 0) {
                    byte b2 = bArr[i2];
                    this.min = (b2 & 3) * 15;
                    this.hour = b2 >> 2;
                    i2++;
                }
            }
            return;
        }
        JL_Log.e("ExerciseRecoveryTime", "parseExerciseRecoveryTimeData", "no support version : " + i);
    }

    public int getHour() {
        return this.hour;
    }

    public int getMin() {
        return this.min;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.HealthData
    public String toString() {
        return "ExerciseRecoveryTime{hour=" + this.hour + ", min=" + this.min + "} " + super.toString();
    }
}
