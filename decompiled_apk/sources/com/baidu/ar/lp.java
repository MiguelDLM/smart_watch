package com.baidu.ar;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.IARRenderer;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class lp implements lm {
    private IARRenderer Aw;
    private lb Ej;
    private lc Ek;
    private ky El;
    private boolean Em = true;
    private int En = 0;
    private volatile Runnable Eo;
    private int mPreviewHeight;
    private int mPreviewWidth;

    public lp(IARRenderer iARRenderer, lb lbVar, lc lcVar, ky kyVar) {
        this.Aw = iARRenderer;
        this.Ej = lbVar;
        this.Ek = lcVar;
        this.El = kyVar;
    }

    private boolean hT() {
        if (this.En == 0) {
            this.En = this.Aw.isDriverdByARPVersion() ? 1 : -1;
        }
        return this.En == 1;
    }

    private float[] k(float[] fArr) {
        if (fArr == null || fArr.length != 16) {
            return null;
        }
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        Matrixf4x4 matrixf4x42 = new Matrixf4x4();
        Matrix.invertM(matrixf4x4.getMatrix(), 0, fArr, 0);
        matrixf4x42.setMatrixValues(matrixf4x4.getMatrix());
        Quaternion quaternion = new Quaternion();
        quaternion.setAxisAngle(new Vector3f(1.0f, 0.0f, 0.0f), -90.0f);
        Matrix.multiplyMM(matrixf4x4.getMatrix(), quaternion.getMatrix4x4().getMatrix(), matrixf4x42.getMatrix());
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        Matrix.invertM(matrixf4x43.getMatrix(), 0, matrixf4x4.getMatrix(), 0);
        return matrixf4x43.getMatrix();
    }

    private void n(int i, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 4101);
        hashMap.put("guideDirection", Integer.valueOf(i2));
        hashMap.put("switchGuide", Integer.valueOf(i));
        this.El.d(hashMap);
    }

    @Override // com.baidu.ar.lm
    public void hP() {
        n(1, 0);
    }

    @Override // com.baidu.ar.lm
    public void hQ() {
        n(1, 1);
    }

    @Override // com.baidu.ar.lm
    public void hR() {
        n(0, 1);
    }

    @Override // com.baidu.ar.lm
    public void hS() {
        this.Aw.setOffScreenGuideWork(true);
    }

    @Override // com.baidu.ar.lm
    public void j(float[] fArr) {
        if (this.Aw == null || fArr == null || fArr.length != 16) {
            return;
        }
        if (this.Eo != null) {
            this.Eo.run();
            this.Eo = null;
        }
        this.Aw.setEnvironmentDataPipKV(ARPScriptEnvironment.KEY_DATA_PIP_SLAM, fArr);
        if (this.Em) {
            this.Em = false;
            this.El.b(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, null);
        }
        if (hT()) {
            fArr = k(fArr);
        }
        bk bkVar = new bk();
        bkVar.u("ability_vo");
        bkVar.setMatrix(fArr);
        this.Aw.updateRenderCameraData(bkVar);
    }

    @Override // com.baidu.ar.lm
    public void release() {
        this.Ek = null;
        this.Eo = null;
        this.Aw = null;
        this.El = null;
    }

    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    @Override // com.baidu.ar.lm
    public String a(lb lbVar) {
        return (lbVar == null || TextUtils.isEmpty(lbVar.getId())) ? "slam_model_1" : lbVar.getId();
    }

    @Override // com.baidu.ar.lm
    public void a(lk lkVar) {
        float f;
        float f2;
        Runnable runnable;
        if (lkVar == null) {
            return;
        }
        if (lkVar.Ei) {
            int[] a2 = a(lkVar.x, lkVar.y);
            f = a2[0];
            f2 = a2[1];
        } else {
            f = lkVar.x;
            f2 = lkVar.y;
        }
        String a3 = a(this.Ej);
        int i = lkVar.type;
        if (i == 3) {
            this.Ek.hM();
            a(a3, (int) f, (int) f2, null, (int) lkVar.Eh);
            runnable = new Runnable() { // from class: com.baidu.ar.lp.1
                @Override // java.lang.Runnable
                public void run() {
                    if (lp.this.Aw != null) {
                        lp.this.Aw.sceneRotateToCamera();
                    }
                }
            };
        } else {
            if (i != 2) {
                return;
            }
            this.Ek.hM();
            a(a3, (int) f, (int) f2, null, (int) lkVar.Eh);
            runnable = new Runnable() { // from class: com.baidu.ar.lp.2
                @Override // java.lang.Runnable
                public void run() {
                    if (lp.this.Aw != null) {
                        lp.this.Aw.sceneWorldPositionToOrigin();
                    }
                }
            };
        }
        this.Eo = runnable;
    }

    @Override // com.baidu.ar.lm
    public void a(String str, int i, int i2, float[] fArr, float f) {
        lc lcVar = this.Ek;
        if (lcVar != null) {
            lcVar.insertModel(str, i, i2, fArr, f);
        }
    }

    @Override // com.baidu.ar.lm
    public int[] a(float f, float f2) {
        int[] iArr = new int[2];
        if (this.mPreviewWidth != 0) {
            iArr[1] = this.mPreviewHeight - ((int) (f * 720.0f));
            iArr[0] = (int) (f2 * 1280.0f);
        } else {
            iArr[1] = 640;
            iArr[0] = 360;
        }
        return iArr;
    }
}
