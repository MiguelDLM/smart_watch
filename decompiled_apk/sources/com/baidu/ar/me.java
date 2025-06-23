package com.baidu.ar;

import android.app.Activity;
import android.util.Log;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.mc;
import com.huawei.hiar.ARCameraIntrinsics;
import com.huawei.hiar.ARConfigBase;
import com.huawei.hiar.ARFrame;
import com.huawei.hiar.ARPose;
import com.huawei.hiar.ARSession;
import com.huawei.hiar.ARTrackable;
import com.huawei.hiar.ARWorldTrackingConfig;
import java.util.LinkedList;

/* loaded from: classes7.dex */
public class me extends mc {
    private Activity Fm;
    private ARSession Fo;
    private boolean du;
    private float[] Fp = {1095.9f, 0.0f, 719.122f, 0.0f, 1095.8f, 548.474f, 0.0f, 0.0f, 1.0f};
    private boolean dm = true;
    LinkedList<ARFrame> Fq = new LinkedList<>();

    public me(Activity activity) {
        this.Fm = activity;
    }

    private boolean o(float[] fArr) {
        for (float f : fArr) {
            if (f == 0.0f) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.ar.mc
    public boolean ah(boolean z) {
        try {
            this.du = z;
            this.Fo = new ARSession(this.Fm);
            ARWorldTrackingConfig aRWorldTrackingConfig = new ARWorldTrackingConfig(this.Fo);
            aRWorldTrackingConfig.setFocusMode(z ? ARConfigBase.FocusMode.FIXED_FOCUS : ARConfigBase.FocusMode.AUTO_FOCUS);
            aRWorldTrackingConfig.setSemanticMode(1);
            this.Fo.configure(aRWorldTrackingConfig);
            return true;
        } catch (Exception e) {
            Log.e("AREngineAbility", "create ARSession error!!!");
            e.printStackTrace();
            ARSession aRSession = this.Fo;
            if (aRSession == null) {
                return false;
            }
            aRSession.stop();
            this.Fo = null;
            return false;
        }
    }

    @Override // com.baidu.ar.mt
    public void b(Texture texture) {
        ARSession aRSession = this.Fo;
        if (aRSession != null) {
            aRSession.setCameraTextureName(texture.getId());
        }
    }

    @Override // com.baidu.ar.mc
    public boolean ij() {
        if (!this.dm) {
            ah(this.du);
            this.dm = true;
        }
        ARSession aRSession = this.Fo;
        if (aRSession == null) {
            return super.ij();
        }
        aRSession.resume();
        return true;
    }

    @Override // com.baidu.ar.mc
    public void ik() {
        double d;
        super.ik();
        ARSession aRSession = this.Fo;
        if (aRSession == null) {
            return;
        }
        ARFrame update = aRSession.update();
        ARPose pose = update.getCamera().getPose();
        ARCameraIntrinsics cameraImageIntrinsics = update.getCamera().getCameraImageIntrinsics();
        float[] principalPoint = cameraImageIntrinsics.getPrincipalPoint();
        float[] focalLength = cameraImageIntrinsics.getFocalLength();
        float[] fArr = o(focalLength) ? new float[]{focalLength[1], 0.0f, principalPoint[1], 0.0f, focalLength[0], principalPoint[0], 0.0f, 0.0f, 1.0f} : this.du ? this.Fp : null;
        if (fArr != null) {
            d = fArr[2] / fArr[0];
        } else {
            float[] fArr2 = this.Fp;
            d = fArr2[2] / fArr2[0];
        }
        double atan = ((Math.atan(d) * 2.0d) / 3.141592653589793d) * 180.0d;
        Log.e("AREngineAbility", "fov:" + atan);
        int i = update.getTrackingState() == ARTrackable.TrackingState.TRACKING ? 0 : 1;
        float[] fArr3 = new float[16];
        pose.toMatrix(fArr3, 0);
        float[] fArr4 = {fArr3[0], fArr3[4], fArr3[8], fArr3[1], fArr3[5], fArr3[9], fArr3[2], fArr3[6], fArr3[10], fArr3[12], fArr3[13], fArr3[14]};
        mc.a aVar = this.Fl;
        if (aVar != null) {
            aVar.a(i, fArr, (float) atan, fArr4, fArr3);
        }
    }

    @Override // com.baidu.ar.mc
    public boolean pause() {
        try {
            this.dm = false;
            this.Fo.pause();
            this.Fo.stop();
            this.Fo = null;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return super.pause();
        }
    }

    @Override // com.baidu.ar.mc
    public void release() {
        ARSession aRSession = this.Fo;
        if (aRSession != null) {
            aRSession.stop();
            this.Fo = null;
        }
    }
}
