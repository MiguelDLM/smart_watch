package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class SportsSteps extends HealthData {
    private int calorie;
    private int distance;
    private int stepNum;

    public SportsSteps(int i, byte b, byte[] bArr) {
        super(3, b, bArr, i);
        parseSportsStepsData(i, b, bArr);
    }

    private int getValueFromData(int i, int i2, byte[] bArr) {
        if (bArr != null && i + i2 <= bArr.length) {
            return CHexConver.bytesToInt(bArr, i, i2);
        }
        return 0;
    }

    private void parseSportsStepsData(int i, byte b, byte[] bArr) {
        if (i == 0) {
            byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(b);
            int i2 = 0;
            for (int i3 = 0; i3 < booleanArrayBig.length; i3++) {
                if (booleanArrayBig[i3] == 1) {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                this.calorie = getValueFromData(i2, 2, bArr);
                            }
                        } else {
                            this.distance = getValueFromData(i2, 2, bArr);
                        }
                        i2 += 2;
                    } else {
                        this.stepNum = getValueFromData(i2, 4, bArr);
                        i2 += 4;
                    }
                }
            }
            return;
        }
        JL_Log.e("SportsSteps", "parseSportsStepsData", "no support version : " + i);
    }

    public int getCalorie() {
        return this.calorie;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getStepNum() {
        return this.stepNum;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.HealthData
    public String toString() {
        return "SportsSteps{stepNum=" + this.stepNum + ", distance=" + this.distance + ", calorie=" + this.calorie + "} " + super.toString();
    }
}
