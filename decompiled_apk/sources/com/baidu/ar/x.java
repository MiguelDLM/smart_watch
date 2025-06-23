package com.baidu.ar;

import com.baidu.ar.camera.CameraManager;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public class x {
    private static x eU;
    private static x eV;
    private static x eW;
    private float[] eX;
    private float[] eY;
    private boolean eZ;
    public int height;
    private float scale;
    public int width;

    static {
        x xVar = new x();
        eU = xVar;
        xVar.width = 1280;
        xVar.height = CameraManager.DEFAULTHEIGHT;
        xVar.eZ = true;
        xVar.eX = new float[]{1110.8284f, 0.0f, 640.0f, 0.0f, 1111.2183f, 360.0f, 0.0f, 0.0f, 1.0f};
        xVar.eY = new float[]{1.0E-5f, 0.0f, 0.0f, 0.0f, 0.0f};
        x xVar2 = new x();
        eV = xVar2;
        xVar2.width = ScreenUtil.SCREEN_SIZE_Y_LARGE;
        xVar2.height = 480;
        eU.eZ = true;
        xVar2.eX = new float[]{594.25995f, 0.0f, 313.4141f, 0.0f, 594.826f, 237.53111f, 0.0f, 0.0f, 1.0f};
        xVar2.eY = new float[]{0.184825f, -0.433983f, -0.003168f, -0.010542f, 0.0f};
        x xVar3 = new x();
        eW = xVar3;
        xVar3.width = ScreenUtil.SCREEN_SIZE_Y_LARGE;
        xVar3.height = 360;
        xVar3.eZ = true;
        xVar3.eX = new float[]{585.7661f, 0.0f, 310.29126f, 0.0f, 585.70685f, 174.72643f, 0.0f, 0.0f, 1.0f};
        xVar3.eY = new float[]{0.170531f, -0.380857f, -0.005316f, 0.011078f, 0.0f};
    }

    private x() {
        this.scale = 1.0f;
        this.eZ = false;
    }

    public static x a(int i, int i2, boolean z) {
        if (!z) {
            return d(i, i2);
        }
        x xVar = new x(i, i2);
        float f = i;
        x xVar2 = eW;
        if (Math.abs((f / i2) - (xVar2.width / xVar2.height)) < 0.03d) {
            xVar.a(eW, f / r5.width);
        }
        return xVar;
    }

    public static x d(int i, int i2) {
        x xVar;
        x xVar2 = new x(i, i2);
        float f = i;
        float f2 = f / i2;
        x xVar3 = eU;
        if (Math.abs(f2 - (xVar3.width / xVar3.height)) < 0.03d) {
            xVar = eU;
        } else {
            x xVar4 = eV;
            if (Math.abs(f2 - (xVar4.width / xVar4.height)) >= 0.03d) {
                return xVar2;
            }
            xVar = eV;
        }
        xVar2.a(xVar, f / xVar.width);
        return xVar2;
    }

    public float[] aw() {
        return this.eX;
    }

    public float[] ax() {
        return this.eY;
    }

    public float getScale() {
        return 1.0f;
    }

    public x(int i, int i2) {
        this.scale = 1.0f;
        this.eZ = false;
        this.width = i;
        this.height = i2;
        this.scale = i > 640 ? 0.5f : 1.0f;
    }

    private void a(x xVar, float f) {
        this.eX = new float[9];
        this.eY = new float[5];
        this.eZ = true;
        for (int i = 0; i < 8; i++) {
            this.eX[i] = xVar.eX[i] * f;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            this.eY[i2] = xVar.eY[i2];
        }
    }
}
