package com.baidu.ar;

import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.track2d.ITrack2DState;
import com.baidu.ar.track2d.ITrack2DStateChangedListener;
import com.baidu.ar.track2d.Track2DStateMessage;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class jk {
    private boolean AA;
    private boolean AB;
    private ITrack2DStateChangedListener Ap;
    private IARRenderer Aw;
    private ji Ax;
    private jp Ay;
    private fk sC;
    private boolean Az = false;
    private boolean sO = false;
    private Matrixf4x4 sD = new Matrixf4x4();
    private Matrixf4x4 sE = new Matrixf4x4();
    private Matrixf4x4 sF = new Matrixf4x4();
    private Matrixf4x4 sG = new Matrixf4x4();
    private boolean sH = true;
    private float[] sI = new float[16];
    private boolean sJ = false;
    private int sK = 0;
    private boolean sL = false;
    private boolean sM = false;
    private boolean AD = false;
    private jl AC = new jl();

    public jk(IARRenderer iARRenderer, jp jpVar, ji jiVar) {
        this.Aw = iARRenderer;
        this.Ax = jiVar;
        this.Ay = jpVar;
    }

    private Matrixf4x4 a(Matrixf4x4 matrixf4x4, Matrixf4x4 matrixf4x42, Vector3f vector3f) {
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        if (this.sK != 1) {
            Matrixf4x4 matrixf4x44 = new Matrixf4x4();
            matrixf4x44.setW0(vector3f.x());
            matrixf4x44.setW1(vector3f.y());
            matrixf4x44.setW2(vector3f.z());
            float[] fArr = new float[16];
            Matrix.multiplyMM(fArr, matrixf4x44.getMatrix(), matrixf4x4.getMatrix());
            float[] fArr2 = new float[16];
            Matrix.invertM(fArr2, 0, fArr, 0);
            matrixf4x43.setMatrixValues(fArr2);
        } else if (this.sH) {
            this.sH = false;
            this.sE.setMatrixValues(matrixf4x4.getMatrix());
            this.sF.loadIndentity();
            Matrix.translateM(this.sF.getMatrix(), 0, vector3f.getX(), vector3f.getY(), vector3f.getZ());
            float[] fArr3 = new float[16];
            Matrix.multiplyMM(fArr3, matrixf4x4.getMatrix(), this.sF.getMatrix());
            float[] fArr4 = new float[16];
            Matrix.invertM(fArr4, 0, fArr3, 0);
            this.sF.setMatrixValues(fArr4);
            matrixf4x43.setMatrixValues(matrixf4x42.getMatrix());
        } else {
            Matrixf4x4 matrixf4x45 = new Matrixf4x4();
            float[] fArr5 = new float[16];
            Matrix.transposeM(fArr5, 0, this.sE.getMatrix(), 0);
            float[] fArr6 = new float[16];
            Matrix.multiplyMM(fArr6, fArr5, matrixf4x4.getMatrix());
            matrixf4x45.setMatrixValues(fArr6);
            Matrix.transposeM(fArr6, 0, matrixf4x45.getMatrix(), 0);
            float[] fArr7 = new float[16];
            Matrix.multiplyMM(fArr7, fArr6, this.sF.getMatrix());
            matrixf4x43.setMatrixValues(fArr7);
        }
        return matrixf4x43;
    }

    private void b(Matrixf4x4 matrixf4x4) {
        float[] fArr = new float[16];
        Matrix.invertM(fArr, 0, matrixf4x4.getMatrix(), 0);
        Matrixf4x4 matrixf4x42 = new Matrixf4x4();
        matrixf4x42.setMatrix(fArr);
        matrixf4x42.setW0(0.0f);
        matrixf4x42.setW1(0.0f);
        matrixf4x42.setW2(0.0f);
        matrixf4x42.setW3(1.0f);
        Vector3f vector3f = new Vector3f(-fArr[12], -fArr[13], -fArr[14]);
        Vector4f vector4f = new Vector4f(0.0f, 0.0f, 1.0f, 1.0f);
        matrixf4x42.multiplyVector4fByMatrix(vector4f);
        Vector3f vector3f2 = new Vector3f(vector4f.x(), vector4f.y(), vector4f.z());
        vector3f2.add(vector3f);
        Vector4f vector4f2 = new Vector4f(0.0f, -1.0f, 0.0f, 1.0f);
        matrixf4x42.multiplyVector4fByMatrix(vector4f2);
        Matrixf4x4 lookAtLH = Matrixf4x4.lookAtLH(vector3f, vector3f2, new Vector3f(vector4f2.x(), vector4f2.y(), vector4f2.z()));
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        matrixf4x43.setX0(-1.0f);
        Matrix.multiplyMM(matrixf4x4.getMatrix(), matrixf4x43.getMatrix(), lookAtLH.getMatrix());
    }

    private Matrixf4x4 c(Matrixf4x4 matrixf4x4) {
        if (matrixf4x4 == null) {
            return null;
        }
        Matrixf4x4 matrixf4x42 = new Matrixf4x4();
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        Matrix.invertM(matrixf4x42.getMatrix(), 0, matrixf4x4.getMatrix(), 0);
        matrixf4x43.setMatrixValues(matrixf4x42.getMatrix());
        Quaternion quaternion = new Quaternion();
        quaternion.setAxisAngle(new Vector3f(1.0f, 0.0f, 0.0f), -90.0f);
        Matrix.multiplyMM(matrixf4x42.getMatrix(), quaternion.getMatrix4x4().getMatrix(), matrixf4x43.getMatrix());
        Matrixf4x4 matrixf4x44 = new Matrixf4x4();
        Matrix.invertM(matrixf4x44.getMatrix(), 0, matrixf4x42.getMatrix(), 0);
        return matrixf4x44;
    }

    private void dT() {
        IARRenderer iARRenderer = this.Aw;
        if (this.sJ && !this.sL) {
            this.sL = true;
            if (iARRenderer != null) {
                this.sM = iARRenderer.isDriverdByARPVersion();
            }
        }
        if (iARRenderer != null) {
            Matrixf4x4 initialTransform = iARRenderer.getInitialTransform();
            Vector3f a2 = a(initialTransform);
            Matrixf4x4 a3 = a(a(a2), initialTransform, a2);
            if (this.sO) {
                b(a3);
            }
            fk fkVar = this.sC;
            if (fkVar != null && fkVar.dX() == fd.WORLD && this.sM) {
                a3 = c(a3);
            }
            bk bkVar = new bk();
            bkVar.u("ability_image_track");
            bkVar.setMatrix(a3.getMatrix());
            iARRenderer.setOffScreenGuideWork(true);
            iARRenderer.updateRenderCameraData(bkVar);
        }
    }

    public void R(boolean z) {
        this.sO = z;
    }

    public void S(boolean z) {
        this.AD = z;
    }

    public void g(float[] fArr) {
        if (this.Aw == null || fArr == null || fArr.length < 12) {
            return;
        }
        float[] fArr2 = {fArr[0], fArr[3], fArr[6], 0.0f, fArr[1], fArr[4], fArr[7], 0.0f, fArr[2], fArr[5], fArr[8], 0.0f, fArr[9], fArr[10], fArr[11], 1.0f};
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrix(fArr2);
        Vector4f vector4f = new Vector4f(fArr[0], fArr[1], fArr[2], fArr[9]);
        Vector4f vector4f2 = new Vector4f(fArr[3], fArr[4], fArr[5], fArr[10]);
        Vector4f vector4f3 = new Vector4f(fArr[6], fArr[7], fArr[8], fArr[11]);
        Vector4f vector4f4 = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
        Vector4f vector4f5 = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (new Vector4f(Math.abs(vector4f.dotProduct(vector4f5)), Math.abs(vector4f2.dotProduct(vector4f5)), Math.abs(vector4f3.dotProduct(vector4f5)), Math.abs(vector4f4.dotProduct(vector4f5))).dotProduct(vector4f5) > 0.001f) {
            this.Aw.setEnvironmentDataPipKV(ARPScriptEnvironment.KEY_DATA_PIP_TRACK, matrixf4x4);
            this.Aw.setOffScreenGuideWork(true);
        }
        bk bkVar = new bk();
        bkVar.u("ability_image_track");
        bkVar.setMatrix(matrixf4x4.getMatrix());
        this.Aw.updateRenderCameraData(bkVar);
    }

    public boolean go() {
        IARRenderer iARRenderer = this.Aw;
        if (iARRenderer == null || iARRenderer.getLuaApplicationState() == null) {
            return false;
        }
        return this.Aw.getLuaApplicationState().Y();
    }

    public boolean isTracked() {
        return this.AC.isTrackFound();
    }

    public void release() {
        this.Aw = null;
        this.Ap = null;
        this.Ax = null;
    }

    public void resume() {
        IARRenderer iARRenderer;
        if (this.AC.AE || (iARRenderer = this.Aw) == null) {
            return;
        }
        iARRenderer.pauseScene();
    }

    public void s(HashMap<String, Object> hashMap) {
        int i;
        int i2;
        if (hashMap != null) {
            i2 = hashMap.containsKey("show_immediately") ? ((Integer) hashMap.get("show_immediately")).intValue() : 0;
            i = hashMap.containsKey("imu_relay_ctrl_when_track_lost") ? ((Integer) hashMap.get("imu_relay_ctrl_when_track_lost")).intValue() : 0;
        } else {
            i = 0;
            i2 = 0;
        }
        boolean z = i2 == 1;
        this.AA = z;
        this.AC.AA = z;
        this.AB = i == 1;
        if (this.Aw != null) {
            if (z) {
                this.Ax.b(101, null);
                this.Aw.resumeScene();
                this.AC.AE = this.Aw.set3DModelVisible(true);
                a(Track2DStateMessage.TRACK_MODEL_APPEAR);
            } else {
                a(Track2DStateMessage.MODEL_CAN_DISAPPEARING);
                this.Ax.b(102, null);
                this.Aw.pauseScene();
                this.Aw.set3DModelVisible(false);
                this.AC.AE = false;
            }
        }
        a(Track2DStateMessage.MODEL_LOADED);
    }

    public void setStateChangedListener(ITrack2DStateChangedListener iTrack2DStateChangedListener) {
        this.Ap = iTrack2DStateChangedListener;
    }

    private Matrixf4x4 a(Vector3f vector3f) {
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrixValues(this.sD.getMatrix());
        matrixf4x4.transpose();
        if (this.AD) {
            a(matrixf4x4, vector3f);
        }
        float[] fArr = new float[16];
        Matrix.multiplyMM(fArr, this.sG.getMatrix(), matrixf4x4.getMatrix());
        matrixf4x4.setMatrixValues(fArr);
        return matrixf4x4;
    }

    private Vector3f a(Matrixf4x4 matrixf4x4) {
        float[] matrix = matrixf4x4.getMatrix();
        Vector3f vector3f = new Vector3f(matrix[12], matrix[13], matrix[14]);
        Matrixf4x4 matrixf4x42 = new Matrixf4x4();
        matrix[14] = 0.0f;
        matrix[13] = 0.0f;
        matrix[12] = 0.0f;
        matrixf4x42.setMatrixValues(matrix);
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        Matrix.invertM(matrixf4x43.getMatrix(), 0, matrixf4x42.getMatrix(), 0);
        Vector4f vector4f = new Vector4f();
        Matrix.multiplyMV3(vector4f.toArray(), matrixf4x43.getMatrix(), vector3f.toArray(), 1.0f);
        vector3f.setXYZ(vector4f.x(), vector4f.y(), vector4f.z());
        return vector3f;
    }

    private void a(Matrixf4x4 matrixf4x4, Vector3f vector3f) {
        this.AD = false;
        if (this.sK == 1) {
            this.sE.setMatrixValues(matrixf4x4.getMatrix());
            Matrixf4x4 matrixf4x42 = new Matrixf4x4();
            matrixf4x42.setW0(vector3f.x());
            matrixf4x42.setW1(vector3f.y());
            matrixf4x42.setW2(vector3f.z());
            float[] fArr = new float[16];
            Matrix.multiplyMM(fArr, matrixf4x4.getMatrix(), matrixf4x42.getMatrix());
            float[] fArr2 = new float[16];
            Matrix.invertM(fArr2, 0, fArr, 0);
            this.sF.setMatrixValues(fArr2);
            return;
        }
        float[] fArr3 = new float[16];
        Matrix.transposeM(fArr3, 0, matrixf4x4.getMatrix(), 0);
        this.sG.setMatrixValues(fArr3);
    }

    public void a(fh fhVar) {
        if (this.AC.isTrackFound() || fhVar == null) {
            return;
        }
        a(fhVar.getMatrix(), fhVar.dU());
    }

    public void a(fk fkVar) {
        this.sC = fkVar;
    }

    private void a(js jsVar) {
        jp jpVar;
        Track2DStateMessage track2DStateMessage;
        if (jsVar == null || !jsVar.isTracked() || (jpVar = this.Ay) == null || jpVar.gu() == null) {
            this.AC.AG = ITrack2DState.DistanceState.UNKNOWN;
            return;
        }
        ITrack2DState.DistanceState distanceState = this.AC.AG;
        float distance = jsVar.getDistance();
        jo gu = this.Ay.gu();
        if (Float.isNaN(gu.gq()) || Float.isNaN(gu.gr())) {
            kf.cj("Far or Near Threshold is NaN");
            track2DStateMessage = null;
        } else if (distance > gu.gq()) {
            this.AC.AG = ITrack2DState.DistanceState.TOO_FAR;
            track2DStateMessage = Track2DStateMessage.TRACK_DISTANCE_TOO_FAR;
            a(track2DStateMessage);
        } else if (distance < gu.gr()) {
            this.AC.AG = ITrack2DState.DistanceState.TOO_NEAR;
            track2DStateMessage = Track2DStateMessage.TRACK_DISTANCE_TOO_NEAR;
        } else {
            this.AC.AG = ITrack2DState.DistanceState.NORMAL;
            track2DStateMessage = Track2DStateMessage.TRACK_DISTANCE_NORMAL;
        }
        if (distanceState != this.AC.AG) {
            a(track2DStateMessage);
        }
    }

    public void a(ju juVar) {
        js gB = juVar.gB();
        if (this.Aw == null || gB == null) {
            return;
        }
        this.AC.AF = gB.isTracked();
        StatisticApi.onEventStatus(StatisticConstants.TRACKED, StatisticConstants.UNTRACKED, this.AC.isTrackFound());
        if (gB.isTracked()) {
            this.Az = true;
            if (gB.gx()) {
                a(Track2DStateMessage.TRACK_FOUND);
                this.Ax.b(101, null);
                this.Aw.resumeScene();
                this.AC.AE = this.Aw.set3DModelVisible(true);
                a(Track2DStateMessage.TRACK_MODEL_APPEAR);
            }
            jl jlVar = this.AC;
            if (!jlVar.AE) {
                jlVar.AE = this.Aw.set3DModelVisible(true);
                a(Track2DStateMessage.TRACK_MODEL_APPEAR);
            }
            if (gB.getMatrix() != null) {
                g(gB.getMatrix());
            }
        } else {
            if (gB.gy()) {
                a(Track2DStateMessage.TRACK_LOST);
                this.Ax.b(102, null);
                if (!this.AA && !this.AB && !go()) {
                    this.AC.AE = false;
                    this.Aw.pauseScene();
                    this.Aw.set3DModelVisible(false);
                }
            }
            if (this.AA) {
                if (!this.AC.AE) {
                    this.Aw.set3DModelVisible(true);
                    this.AC.AE = true;
                    a(Track2DStateMessage.TRACK_MODEL_APPEAR);
                }
            } else if (!this.Az && this.AC.AE) {
                this.Aw.set3DModelVisible(false);
                this.AC.AE = false;
            }
        }
        a(gB);
    }

    public void a(Track2DStateMessage track2DStateMessage) {
        ITrack2DStateChangedListener iTrack2DStateChangedListener = this.Ap;
        if (iTrack2DStateChangedListener != null) {
            iTrack2DStateChangedListener.onStateChanged(track2DStateMessage, this.AC);
        }
    }

    private void a(float[] fArr, int i) {
        if (fArr == null || fArr.length != 16) {
            return;
        }
        System.arraycopy(fArr, 0, this.sI, 0, 16);
        this.sD.setMatrixValues(this.sI);
        this.sJ = true;
        this.sK = i;
        System.arraycopy(fArr, 0, this.sI, 0, 16);
        this.sD.setMatrixValues(this.sI);
        IARRenderer iARRenderer = this.Aw;
        if (iARRenderer != null) {
            iARRenderer.setEnvironmentDataPipKV(ARPScriptEnvironment.KEY_DATA_PIP_IMU, this.sD);
        }
        this.sJ = true;
        this.sK = i;
        dT();
    }
}
