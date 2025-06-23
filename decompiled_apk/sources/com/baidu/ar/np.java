package com.baidu.ar;

import XIXIX.OOXIXo;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector4f;

/* loaded from: classes7.dex */
public class np {
    public static double a(double d, double d2) {
        nf nfVar = new nf(d, d2);
        if (nfVar.iN() == OOXIXo.f3760XO && nfVar.iO() == OOXIXo.f3760XO) {
            return OOXIXo.f3760XO;
        }
        if (nfVar.iN() == OOXIXo.f3760XO && nfVar.iO() > OOXIXo.f3760XO) {
            return OOXIXo.f3760XO;
        }
        if (nfVar.iN() == OOXIXo.f3760XO && nfVar.iO() < OOXIXo.f3760XO) {
            return 180.0d;
        }
        if (nfVar.iO() == OOXIXo.f3760XO && nfVar.iN() > OOXIXo.f3760XO) {
            return 90.0d;
        }
        if (nfVar.iO() != OOXIXo.f3760XO || nfVar.iN() >= OOXIXo.f3760XO) {
            return (nfVar.iN() <= OOXIXo.f3760XO || nfVar.iO() <= OOXIXo.f3760XO) ? (nfVar.iN() <= OOXIXo.f3760XO || nfVar.iO() >= OOXIXo.f3760XO) ? (nfVar.iN() >= OOXIXo.f3760XO || nfVar.iO() >= OOXIXo.f3760XO) ? (nfVar.iN() >= OOXIXo.f3760XO || nfVar.iO() <= OOXIXo.f3760XO) ? OOXIXo.f3760XO : ((Math.atan(nfVar.iO() / (-nfVar.iN())) / 3.141592653589793d) * 180.0d) + 270.0d : ((Math.atan(nfVar.iN() / nfVar.iO()) / 3.141592653589793d) * 180.0d) + 180.0d : ((Math.atan((-nfVar.iO()) / nfVar.iN()) / 3.141592653589793d) * 180.0d) + 90.0d : (Math.atan(nfVar.iN() / nfVar.iO()) / 3.141592653589793d) * 180.0d;
        }
        return 270.0d;
    }

    public static Vector4f a(double d, double d2, int i) {
        double a2 = a(d, d2);
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, (float) (-a2), 0.0f, 0.0f, 1.0f);
        Quaternion quaternion = new Quaternion();
        if (i == 1) {
            float[] fArr2 = new float[16];
            Matrix.setIdentityM(fArr2, 0);
            Matrix.rotateM(fArr2, 0, -90.0f, 0.0f, 1.0f, 0.0f);
            float[] fArr3 = new float[16];
            Matrix.setIdentityM(fArr3, 0);
            Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
            quaternion.setRowMajor(fArr3);
        } else {
            quaternion.setRowMajor(fArr);
        }
        return new Vector4f(quaternion.getX(), quaternion.getY(), quaternion.getZ(), quaternion.getW());
    }
}
