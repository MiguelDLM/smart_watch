package com.baidu.ar;

import android.opengl.Matrix;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class mx implements mr {
    private float Fv;
    private float Fw;
    private float[] GD = null;
    private List<mo> GE = new ArrayList();
    private List<mm> GF = new ArrayList();
    private mm GG;
    private mm GH;
    private mo GI;
    private mz GJ;
    private float[] GK;
    private boolean GL;
    private ms GM;
    private ml GN;

    public mx() {
        float[] fArr = new float[16];
        this.GK = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    private void iE() {
        for (int i = 0; i < this.GE.size(); i++) {
            this.GE.get(i).p(this.GK);
        }
    }

    private float[] t(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float[] fArr2 = {f, f2};
        float[] fArr3 = {f, f2 + 1.0f};
        float[] fArr4 = {f + 1.0f, f2};
        return new float[]{nn.d(fArr4[0], fArr4[1], fArr2[0], fArr2[1]), nn.d(fArr3[0], fArr3[1], fArr2[0], fArr2[1]), 0.0f, 1.0f};
    }

    public float[] A(float[] fArr) {
        return this.GN.s(fArr);
    }

    public void a(mm mmVar) {
        this.GF.add(mmVar);
    }

    public boolean b(mm mmVar) {
        if (!this.GF.contains(mmVar) || (mmVar.ir() & my.GeoLocation.Fr) == 0) {
            return false;
        }
        this.GG = mmVar;
        return true;
    }

    public boolean c(mm mmVar) {
        if (!this.GF.contains(mmVar) || (mmVar.ir() & my.GeoHeading.Fr) == 0) {
            return false;
        }
        this.GH = mmVar;
        return true;
    }

    public void clear() {
        List<mo> list = this.GE;
        if (list != null) {
            list.clear();
        }
        List<mm> list2 = this.GF;
        if (list2 != null) {
            list2.clear();
        }
        List<mm> list3 = this.GF;
        if (list3 != null) {
            list3.clear();
        }
        this.GH = null;
        this.GG = null;
        this.GI = null;
        this.GK = null;
        this.GL = false;
        this.GN = null;
        this.GJ = null;
    }

    public mz iC() {
        if (this.GN == null) {
            return null;
        }
        float[] fArr = this.GK;
        float[] fArr2 = {fArr[12], fArr[13], fArr[14], 1.0f};
        mz mzVar = new mz();
        float[] s = this.GN.s(fArr2);
        mj mjVar = new mj();
        mjVar.FG = s[1];
        mjVar.FH = s[0];
        mzVar.GU = mjVar;
        return mzVar;
    }

    public boolean iD() {
        if (iq() && is()) {
            float[] fArr = this.GK;
            float f = fArr[12];
            float f2 = fArr[13];
            Log.e("GeoLocalTransformx", "x:" + f + ", y:" + f2 + ", z:" + fArr[14]);
            float[] fArr2 = this.GK;
            float[] fArr3 = new float[fArr2.length];
            System.arraycopy(fArr2, 0, fArr3, 0, fArr2.length);
            mo moVar = this.GI;
            if (moVar instanceof mi) {
                ml mlVar = new ml();
                this.GN = mlVar;
                mlVar.q(((mi) moVar).iu());
                this.GN.FM = true;
                this.GN.FN = (float) ((nn.b((float) (((nn.I(fArr3) - (((-this.Fv) / 180.0f) * 3.141592653589793d)) / 180.0d) * 3.141592653589793d)) / 180.0d) * 3.141592653589793d);
            } else {
                mz mzVar = this.GJ;
                if (mzVar != null && mzVar.GU.FG > 0.0f) {
                    double I = nn.I(fArr3);
                    Log.e("GeoLocalTransform", "locYaw:" + Math.toDegrees(I));
                    double d = (((double) (-this.Fv)) / 180.0d) * 3.141592653589793d;
                    Log.e("GeoLocalTransform", "geoYaw:" + Math.toDegrees(d));
                    double b = (nn.b((double) ((float) (((I - d) / 3.141592653589793d) * 180.0d))) / 180.0d) * 3.141592653589793d;
                    Log.e("GeoLocalTransform", "diffYaw:" + Math.toDegrees(b));
                    float[] fArr4 = new float[16];
                    Matrix.setIdentityM(fArr4, 0);
                    Matrix.rotateM(fArr4, 0, (float) ((b / 3.141592653589793d) * 180.0d), 0.0f, 0.0f, 1.0f);
                    Log.e("GeoLocalTransform", "latlng:" + this.GJ.GU.FH + "," + this.GJ.GU.FG + ", mGeoHeading:" + this.Fv + ", transform:" + Arrays.toString(this.GK));
                    float[] fArr5 = {f, f2, 0.0f, 1.0f};
                    StringBuilder sb = new StringBuilder();
                    sb.append("T0: ");
                    sb.append(Arrays.toString(fArr5));
                    Log.e("GeoLocalTransform", sb.toString());
                    mj mjVar = this.GJ.GU;
                    float f3 = mjVar.FH;
                    float f4 = mjVar.FG;
                    float[] fArr6 = {f3, f4, 0.0f, 1.0f};
                    float[] t = t(new float[]{f3, f4});
                    ml mlVar2 = new ml();
                    this.GN = mlVar2;
                    mlVar2.a(fArr4, fArr5, fArr6, t);
                }
            }
            ms msVar = this.GM;
            if (msVar == null) {
                return true;
            }
            msVar.positioningServiceDidUpdateGeoLocalTransform();
            return true;
        }
        return false;
    }

    public boolean iq() {
        mm mmVar = this.GH;
        if (mmVar != null) {
            return mmVar.iq();
        }
        return false;
    }

    public boolean is() {
        mo moVar = this.GI;
        if (moVar != null) {
            return moVar.is();
        }
        return false;
    }

    public float[] r(float[] fArr) {
        ml mlVar = this.GN;
        if (mlVar == null) {
            return null;
        }
        return mlVar.r(new float[]{fArr[0] * 1.0f, fArr[1] * 1.0f, 0.0f, 1.0f});
    }

    @Override // com.baidu.ar.mr
    public void a(mq mqVar) {
        if (mqVar instanceof mw) {
            mw mwVar = (mw) mqVar;
            this.GJ = mwVar.in();
            this.Fv = mwVar.io();
            this.Fw = mwVar.ip();
            ms msVar = this.GM;
            if (msVar != null) {
                msVar.positioningServiceDidupdateGeoLocation(this.GJ);
                this.GM.positioningServiceDidUpdateGeoHeading(this.Fv, this.Fw);
            }
        }
        if (mqVar instanceof na) {
            na naVar = (na) mqVar;
            this.GK = naVar.it();
            this.Fv = (float) naVar.GY;
            this.Fw = naVar.Fw;
            ms msVar2 = this.GM;
            if (msVar2 != null) {
                msVar2.positioningServiceDidupdateGeoLocation(this.GJ);
                this.GM.positioningServiceDidUpdateGeoHeading(this.Fv, this.Fw);
                this.GM.positioningServiceDidUpdateLocalTransform(this.GK);
            }
        }
        if (mqVar instanceof nk) {
            float[] it = ((nk) mqVar).it();
            this.GK = it;
            ms msVar3 = this.GM;
            if (msVar3 != null) {
                msVar3.positioningServiceDidUpdateLocalTransform(it);
            }
        }
        if (mqVar instanceof nl) {
            float[] it2 = ((nl) mqVar).it();
            this.GK = it2;
            ms msVar4 = this.GM;
            if (msVar4 != null) {
                msVar4.positioningServiceDidUpdateLocalTransform(it2);
            }
        }
    }

    public boolean b(mo moVar) {
        if (!this.GE.contains(moVar) || !moVar.is()) {
            return false;
        }
        this.GI = moVar;
        this.GK = moVar.it();
        this.GL = true;
        iE();
        if (moVar instanceof mi) {
            ml mlVar = new ml();
            this.GN = mlVar;
            mlVar.q(((mi) moVar).iu());
            this.GN.FM = true;
        }
        return true;
    }

    public boolean c(mo moVar) {
        if (!this.GE.contains(moVar) || !moVar.is()) {
            return false;
        }
        if (this.GI == moVar) {
            return true;
        }
        this.GI = moVar;
        if (moVar instanceof mi) {
            mi miVar = (mi) moVar;
            if (this.GL && miVar.Fy != null) {
                ml mlVar = new ml();
                this.GN = mlVar;
                mlVar.q(miVar.iu());
                this.GN.FM = true;
            }
        }
        return true;
    }

    public void a(ms msVar) {
        this.GM = msVar;
    }

    public boolean a(mo moVar) {
        if (!moVar.is()) {
            return false;
        }
        if (this.GE.contains(moVar)) {
            return true;
        }
        this.GE.add(moVar);
        if (!this.GL) {
            return true;
        }
        moVar.p(this.GK);
        return true;
    }
}
