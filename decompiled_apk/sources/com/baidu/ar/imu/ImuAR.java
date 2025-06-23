package com.baidu.ar.imu;

import com.baidu.ar.ARType;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bk;
import com.baidu.ar.d;
import com.baidu.ar.fd;
import com.baidu.ar.fh;
import com.baidu.ar.fi;
import com.baidu.ar.fk;
import com.baidu.ar.ft;
import com.baidu.ar.kf;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.facebook.internal.AnalyticsEvents;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class ImuAR extends d implements fi {
    private static final String TAG = "ImuAR";
    private ft sB;
    private fk sC;
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
    private boolean sN = false;
    private boolean sO = false;

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

    private void dS() {
        if (this.sB == null) {
            this.sB = new ft() { // from class: com.baidu.ar.imu.ImuAR.1
                @Override // com.baidu.ar.ft
                public void a(int i, int i2, HashMap<String, Object> hashMap) {
                    if (i != 305) {
                        if (i == 306 && (hashMap.get("is_mirrored") instanceof Integer)) {
                            int intValue = ((Integer) hashMap.get("is_mirrored")).intValue();
                            ImuAR.this.sO = intValue == 1;
                            return;
                        }
                        return;
                    }
                    if (hashMap != null && hashMap.containsKey("with_interaction") && ((Integer) hashMap.get("with_interaction")).intValue() != 0) {
                        r0 = true;
                    }
                    ImuAR.this.sN = true;
                    if (r0 || ImuAR.this.t() == null) {
                        return;
                    }
                    ImuAR.this.t().sceneRelocate();
                }

                @Override // com.baidu.ar.ft
                public List<Integer> q() {
                    return Arrays.asList(306, 305);
                }
            };
        }
        a(this.sB);
    }

    private void dT() {
        IARRenderer t = t();
        if (this.sJ && !this.sL) {
            this.sL = true;
            b(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, (HashMap<String, Object>) null);
            if (t != null) {
                this.sM = t.isDriverdByARPVersion();
            }
        }
        if (t != null) {
            Matrixf4x4 initialTransform = t.getInitialTransform();
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
            bkVar.u("ability_imu");
            bkVar.setMatrix(a3.getMatrix());
            t.setOffScreenGuideWork(true);
            t.updateRenderCameraData(bkVar);
        }
    }

    @Override // com.baidu.ar.fi
    public void onImuUpdate(fh fhVar) {
        if (fhVar != null) {
            a(fhVar.getMatrix(), fhVar.dU());
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        kf.c(TAG, "release()");
        a((fi) this);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, 1);
        b(304, hashMap);
        b(this.sB);
        this.sC = null;
        super.release();
    }

    @Override // com.baidu.ar.d
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (hashMap != null && hashMap.containsKey("type")) {
            kf.c(TAG, "setup() luaParams = " + hashMap.toString());
            Object obj = hashMap.get("type");
            int i = 0;
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof Float ? (int) ((Float) obj).floatValue() : 0;
            if (hashMap.containsKey("init_pos")) {
                Object obj2 = hashMap.get("init_pos");
                if (obj2 instanceof Integer) {
                    i = ((Integer) obj2).intValue();
                } else if (obj2 instanceof Float) {
                    i = (int) ((Float) obj2).floatValue();
                }
            }
            fk fkVar = new fk();
            this.sC = fkVar;
            fkVar.a(fd.A(intValue));
            this.sC.C(i);
            a(this.sC, this);
            dS();
            IARRenderer t = t();
            if (t != null) {
                t.updateDeviceOrientation();
                if (this.sC.dX() == fd.RELATIVE) {
                    t.calibrationTouchAngle();
                }
                t.setImuType(this.sC.dX());
            }
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, 1);
            b(302, hashMap2);
        }
        if (ARConfig.getARType() == ARType.IMU.getTypeValue()) {
            StatisticApi.onEvent(StatisticConstants.IMU_SET_SUCCESS);
        }
    }

    private Matrixf4x4 a(Vector3f vector3f) {
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrixValues(this.sD.getMatrix());
        matrixf4x4.transpose();
        if (this.sN) {
            a(matrixf4x4, vector3f);
        }
        float[] fArr = new float[16];
        Matrix.multiplyMM(fArr, this.sG.getMatrix(), matrixf4x4.getMatrix());
        matrixf4x4.setMatrixValues(fArr);
        return matrixf4x4;
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
        this.sN = false;
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
        IARRenderer t = t();
        if (t != null) {
            t.setEnvironmentDataPipKV(ARPScriptEnvironment.KEY_DATA_PIP_IMU, this.sD);
        }
        this.sJ = true;
        this.sK = i;
        dT();
    }
}
