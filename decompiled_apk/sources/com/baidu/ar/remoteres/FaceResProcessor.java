package com.baidu.ar.remoteres;

import com.baidu.ar.DuMixController;
import com.baidu.ar.filter.FilterParam;
import java.io.File;

/* loaded from: classes7.dex */
class FaceResProcessor implements IDuMixResProcessor {
    private boolean xJ = false;
    private boolean xK = false;

    private void a(DuMixController duMixController, File file) {
        File file2 = new File(file, "filter/beauty_skin_small_video.png");
        if (file2.exists()) {
            duMixController.updateFilter(FilterParam.SkinFilter.whitenFile, file2.getAbsolutePath());
        }
        File file3 = new File(file, "faceModels");
        if (file3.exists()) {
            duMixController.getARProxyManager().getFaceAR().setFaceModelPath(file3.getAbsolutePath() + "/");
        }
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public String getBusinessTag() {
        return "face_alg_model";
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public boolean isLoaded() {
        return this.xJ;
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public boolean isReady(File file, File file2) {
        if (this.xK) {
            return false;
        }
        if (this.xJ) {
            return true;
        }
        return new File(file2, "faceModels").exists();
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public boolean load(DuMixController duMixController, File file, File file2) {
        if (duMixController != null) {
            try {
                a(duMixController, file2);
            } catch (Throwable th) {
                th.printStackTrace();
                this.xK = true;
                return false;
            }
        }
        this.xK = false;
        this.xJ = true;
        return true;
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public void setUseLocalLib() {
    }
}
