package com.baidu.ar;

import android.util.Log;

/* loaded from: classes7.dex */
public class mk {
    private float[] FI;
    private float FK;
    private float FJ = -1.0f;
    private long dK = System.currentTimeMillis();
    private long FL = 60000;

    public boolean a(float[] fArr, float f) {
        if (this.FI == null) {
            this.FI = fArr;
        }
        if (f < this.FK) {
            Log.e("CoordinateStrategy", "The condition of rebinding coordinate system is satisfied: accuracy < mLatlonAcuracy: accuracy:" + f + ", mLatlonAcuracy:" + this.FK);
            this.FK = f;
            return true;
        }
        float[] fArr2 = this.FI;
        float d = nn.d(fArr2[0], fArr2[1], fArr[0], fArr[1]);
        Log.e("CoordinateStrategy", "distance:" + d);
        if (d < 20.0f) {
            return false;
        }
        this.FI = fArr;
        Log.e("CoordinateStrategy", "The condition of rebinding coordinate system is satisfied: latlng diatance >=20");
        return true;
    }

    public boolean g(float f) {
        float f2 = this.FJ;
        if (f2 == -1.0f) {
            this.FJ = f;
            return false;
        }
        if (f <= f2) {
            return false;
        }
        Log.e("CoordinateStrategy", "The condition of rebinding coordinate system is satisfied: heading accuracy > localAccuracy");
        this.FJ = f;
        return true;
    }
}
