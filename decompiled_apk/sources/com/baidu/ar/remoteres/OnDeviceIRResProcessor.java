package com.baidu.ar.remoteres;

import com.baidu.ar.DuMixController;
import com.baidu.ar.fn;
import java.io.File;

/* loaded from: classes7.dex */
class OnDeviceIRResProcessor implements IDuMixResProcessor {
    private boolean xJ = false;
    private boolean xK = false;
    private boolean xL = false;

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public String getBusinessTag() {
        return "local_recognize";
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
        return new File(file, "libImgRecognition.so").exists();
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public boolean load(DuMixController duMixController, File file, File file2) {
        try {
            if (!this.xL) {
                fn.require("ImgRecognition");
            }
            this.xK = false;
            this.xJ = true;
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            this.xK = true;
            return false;
        }
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public void setUseLocalLib() {
        this.xL = true;
    }
}
