package com.baidu.ar;

import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Matrix;
import java.util.Observer;

/* loaded from: classes7.dex */
public class fj implements Observer {
    private static final String TAG = "fj";
    private static final float[] sT = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] sU = {0.0f, 0.0f, -1.0f, 0.0f};
    private float[] jz;
    private fk sC;
    private float sR;
    private fl sV;
    private fi sW;
    private float[] sX = new float[16];
    private float sY = -1.0f;
    private float sZ = 10000.0f;
    private boolean ta = true;
    private boolean tb = false;
    private float[] tc = new float[4];
    private float[] td = new float[16];

    public fj() {
        float[] fArr = new float[16];
        this.jz = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    private fl a(fd fdVar, SensorManager sensorManager) {
        fl fmVar;
        if (fdVar != fd.RELATIVE) {
            fmVar = this.sC.ec() ? new fm(sensorManager) : new ff(sensorManager);
        } else if (this.sC.dZ()) {
            fmVar = new fg(sensorManager);
            if (!this.ta) {
                fmVar.tr = true;
                fmVar.ts.matrix = this.jz;
            }
            this.ta = false;
        } else {
            fmVar = new fc(sensorManager);
        }
        fmVar.addObserver(this);
        return fmVar;
    }

    private void b(float[] fArr) {
        Matrix.invertM(this.sX, 0, fArr, 0);
        Matrix.multiplyMM(this.td, 0, sT, 0, this.sX, 0);
        float d = d(this.td);
        this.sY = d;
        if (d > 0.0f) {
            float pow = (float) (Math.pow(1.13d, d) + 600.0d);
            this.sZ = pow;
            if (pow > 15000.0f) {
                this.sZ = 15000.0f;
            }
        }
        Matrix.multiplyMV(this.tc, 0, this.td, 0, new float[]{0.0f, 0.0f, -this.sZ, 1.0f}, 0);
        float[] fArr2 = this.td;
        float[] fArr3 = this.tc;
        fArr2[12] = -fArr3[0];
        fArr2[13] = -fArr3[1];
        fArr2[14] = -fArr3[2];
        Matrix.invertM(this.sX, 0, fArr2, 0);
        float c = c(this.tc);
        this.sR = c;
        Matrix.rotateM(this.sX, 0, c, 0.0f, 0.0f, 1.0f);
    }

    private float c(float[] fArr) {
        float f = -fArr[0];
        float f2 = -fArr[1];
        if (f2 == 0.0f && f < 0.0f) {
            return 0.0f;
        }
        if (f2 == 0.0f && f > 0.0f) {
            return 180.0f;
        }
        if (f == 0.0f && f2 < 0.0f) {
            return 90.0f;
        }
        if (f == 0.0f && f2 > 0.0f) {
            return 270.0f;
        }
        float atan = (float) ((Math.atan(Math.abs(f2) / Math.abs(f)) / 3.141592653589793d) * 180.0d);
        if (f > 0.0f && f2 < 0.0f) {
            atan = 180.0f - atan;
        }
        if (f > 0.0f && f2 > 0.0f) {
            atan += 180.0f;
        }
        return (f >= 0.0f || f2 <= 0.0f) ? atan : 360.0f - atan;
    }

    private float d(float[] fArr) {
        Matrix.multiplyMV(this.tc, 0, fArr, 0, sU, 0);
        float[] fArr2 = this.tc;
        if (fArr2[2] > 0.0f) {
            return -1.0f;
        }
        float f = fArr2[0];
        float f2 = fArr2[1];
        return 90.0f - ((float) ((Math.atan(Math.abs(this.tc[2]) / ((float) Math.sqrt((f * f) + (f2 * f2)))) / 3.141592653589793d) * 180.0d));
    }

    private void dW() {
        fl flVar = this.sV;
        if (flVar != null) {
            flVar.release();
            this.sV = null;
        }
    }

    public void stop() {
        fk fkVar;
        if (this.sV != null && (fkVar = this.sC) != null && fkVar.dX() == fd.RELATIVE && !this.tb && this.sC.dZ()) {
            this.jz = this.sV.ts.matrix;
            this.tb = true;
        }
        try {
            dW();
            this.sW = null;
            this.sC = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:2:0x0000, B:4:0x0004, B:9:0x0009, B:11:0x0019, B:14:0x0027, B:16:0x003a, B:17:0x0043, B:20:0x0040, B:21:0x0024), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040 A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:2:0x0000, B:4:0x0004, B:9:0x0009, B:11:0x0019, B:14:0x0027, B:16:0x003a, B:17:0x0043, B:20:0x0040, B:21:0x0024), top: B:1:0x0000 }] */
    @Override // java.util.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(java.util.Observable r3, java.lang.Object r4) {
        /*
            r2 = this;
            com.baidu.ar.fk r3 = r2.sC     // Catch: java.lang.Throwable -> L22
            if (r3 == 0) goto L5a
            com.baidu.ar.fi r3 = r2.sW     // Catch: java.lang.Throwable -> L22
            if (r3 != 0) goto L9
            goto L5a
        L9:
            com.baidu.ar.fl r3 = r2.sV     // Catch: java.lang.Throwable -> L22
            com.baidu.ar.arplay.representation.Matrixf4x4 r3 = r3.ee()     // Catch: java.lang.Throwable -> L22
            float[] r3 = r3.matrix     // Catch: java.lang.Throwable -> L22
            com.baidu.ar.fk r4 = r2.sC     // Catch: java.lang.Throwable -> L22
            boolean r4 = r4.eb()     // Catch: java.lang.Throwable -> L22
            if (r4 != 0) goto L24
            com.baidu.ar.fk r4 = r2.sC     // Catch: java.lang.Throwable -> L22
            boolean r4 = r4.ea()     // Catch: java.lang.Throwable -> L22
            if (r4 == 0) goto L27
            goto L24
        L22:
            r3 = move-exception
            goto L5b
        L24:
            r2.b(r3)     // Catch: java.lang.Throwable -> L22
        L27:
            com.baidu.ar.fl r4 = r2.sV     // Catch: java.lang.Throwable -> L22
            float[] r4 = r4.dV()     // Catch: java.lang.Throwable -> L22
            com.baidu.ar.fh r0 = new com.baidu.ar.fh     // Catch: java.lang.Throwable -> L22
            r0.<init>()     // Catch: java.lang.Throwable -> L22
            com.baidu.ar.fk r1 = r2.sC     // Catch: java.lang.Throwable -> L22
            boolean r1 = r1.ea()     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L40
            float[] r3 = r2.sX     // Catch: java.lang.Throwable -> L22
            r0.setMatrix(r3)     // Catch: java.lang.Throwable -> L22
            goto L43
        L40:
            r0.setMatrix(r3)     // Catch: java.lang.Throwable -> L22
        L43:
            float r3 = r2.sR     // Catch: java.lang.Throwable -> L22
            r0.a(r3)     // Catch: java.lang.Throwable -> L22
            com.baidu.ar.fk r3 = r2.sC     // Catch: java.lang.Throwable -> L22
            int r3 = r3.dY()     // Catch: java.lang.Throwable -> L22
            r0.B(r3)     // Catch: java.lang.Throwable -> L22
            r0.a(r4)     // Catch: java.lang.Throwable -> L22
            com.baidu.ar.fi r3 = r2.sW     // Catch: java.lang.Throwable -> L22
            r3.onImuUpdate(r0)     // Catch: java.lang.Throwable -> L22
            goto L5e
        L5a:
            return
        L5b:
            r3.printStackTrace()
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.fj.update(java.util.Observable, java.lang.Object):void");
    }

    public boolean a(SensorManager sensorManager, fk fkVar, fi fiVar) {
        if (fkVar == null) {
            return false;
        }
        this.sC = fkVar;
        this.sW = fiVar;
        if (fkVar.dX() == fd.RELATIVE && !this.sC.dZ()) {
            this.ta = true;
        }
        try {
            if (this.sV == null) {
                this.sV = a(this.sC.dX(), sensorManager);
            }
            if (!this.sV.ed()) {
                return false;
            }
            this.sV.start();
            return true;
        } catch (Throwable th) {
            kf.b(TAG, "IMUController start: " + th.getMessage());
            return false;
        }
    }
}
