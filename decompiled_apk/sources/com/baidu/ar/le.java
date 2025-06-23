package com.baidu.ar;

import android.opengl.Matrix;
import com.baidu.ar.algovo.ARVOJniClient;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.slam.TrackModel;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class le implements lc, ld {
    private static final float[] DR = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final String TAG = "le";
    private lf DS;
    private float[] DU;
    private float DX;
    private x mPreviewInfo;
    private boolean DT = false;
    private float DV = 0.0f;
    private boolean DW = false;

    public le(lf lfVar) {
        this.DS = lfVar;
    }

    private void c(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        float[] fArr4 = new float[16];
        Matrix.invertM(fArr3, 0, fArr2, 0);
        Matrix.multiplyMM(fArr4, 0, DR, 0, fArr3, 0);
        Matrix.invertM(fArr3, 0, fArr4, 0);
        fArr[0] = fArr3[0];
        fArr[1] = fArr3[1];
        fArr[2] = fArr3[2];
        fArr[4] = fArr3[4];
        fArr[5] = fArr3[5];
        fArr[6] = fArr3[6];
        fArr[8] = fArr3[8];
        fArr[9] = fArr3[9];
        fArr[10] = fArr3[10];
        float scale = this.mPreviewInfo.getScale();
        float f = fArr[12];
        float f2 = this.DX;
        float f3 = fArr[13] * f2 * scale;
        float f4 = fArr[14] * f2 * scale;
        fArr[12] = f * f2 * scale;
        fArr[13] = f3;
        fArr[14] = f4;
        Matrix.rotateM(fArr, 0, this.DV - 90.0f, 0.0f, 0.0f, 1.0f);
    }

    private float[] h(float[] fArr) {
        if (this.DV == 0.0f) {
            this.DV = this.DS.Ea.getAngle();
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        Matrix.multiplyMM(fArr3, 0, DR, 0, fArr2, 0);
        return new float[]{-fArr3[4], -fArr3[5], -fArr3[6], -fArr3[0], -fArr3[1], -fArr3[2], -fArr3[8], -fArr3[9], -fArr3[10], 0.0f, 0.0f, 0.0f};
    }

    @Override // com.baidu.ar.ld
    public void a(FramePixels framePixels, ICallbackWith<lh> iCallbackWith) {
        lf lfVar;
        float[] hF;
        if (framePixels == null || !this.DT || (lfVar = this.DS) == null || (hF = lfVar.Ea.hF()) == null || hF.length == 0) {
            return;
        }
        if (!this.DW) {
            iCallbackWith.run(new lh(framePixels.getTimestamp()));
            return;
        }
        this.DU = hF;
        ARVOJniClient.track(framePixels.getPixelsAddress(), h(hF));
        ArrayList<TrackModel> fetchModelPose = ARVOJniClient.fetchModelPose();
        Iterator<TrackModel> it = fetchModelPose.iterator();
        while (it.hasNext()) {
            c(it.next().pose, this.DU);
        }
        li liVar = new li(framePixels.getTimestamp());
        liVar.C(true);
        liVar.D(true);
        liVar.b(fetchModelPose);
        iCallbackWith.run(new lh(liVar));
    }

    @Override // com.baidu.ar.lc
    public void hM() {
        if (this.DT && this.DW) {
            ARVOJniClient.removeAllModel();
            this.DW = false;
        }
    }

    @Override // com.baidu.ar.ld
    public void init() {
        lf lfVar = this.DS;
        this.mPreviewInfo = x.a(lfVar.DY, lfVar.DZ, false);
        try {
            fn.require("dumixar");
            x xVar = this.mPreviewInfo;
            this.DT = ARVOJniClient.start(xVar.width, xVar.height, xVar.aw(), this.mPreviewInfo.ax());
        } catch (UnsatisfiedLinkError e) {
            kf.b(TAG, "slam algo UnsatisfiedLinkError " + e.getMessage());
        }
    }

    @Override // com.baidu.ar.lc
    public int insertModel(String str, int i, int i2, float[] fArr, float f) {
        if (!this.DT) {
            return -1;
        }
        this.DX = f;
        if (fArr == null) {
            fArr = DR;
        }
        int insertModel = ARVOJniClient.insertModel(str, i, i2, fArr, 1.0f);
        this.DW = true;
        return insertModel;
    }

    public void release() {
        if (this.DT) {
            ARVOJniClient.stop();
            this.DT = false;
        }
        this.DS = null;
    }

    @Override // com.baidu.ar.lc
    public float[] a(float f, float[] fArr) {
        if (!this.DT) {
            return null;
        }
        float[] fArr2 = new float[2];
        return new float[]{ARVOJniClient.calModelPosition(this.mPreviewInfo.aw(), f, h(fArr), fArr2), fArr2[0], fArr2[1]};
    }
}
