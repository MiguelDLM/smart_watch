package com.baidu.ar;

import com.baidu.ar.remoteres.IDuMixResProcessor;
import java.io.File;

/* loaded from: classes7.dex */
public class id implements IDuMixResProcessor {
    private static final String[] xV = {"dlModels/gesture", "dlModels/hairSeg"};
    private boolean xJ = false;
    private boolean xK = false;
    private boolean xL = false;

    public void P(boolean z) {
        this.xJ = z;
    }

    public void b(DuMixController duMixController, File file) {
        if (duMixController == null || this.xJ) {
            return;
        }
        for (String str : xV) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                duMixController.setMdlModelPath(file2.getAbsolutePath());
            }
        }
        this.xK = false;
        this.xJ = true;
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public String getBusinessTag() {
        return "egl_core";
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
        if (!this.xL && !new File(file, "libdumixar.so").exists()) {
            return false;
        }
        for (String str : xV) {
            if (!new File(file2, str + "/dl_config.json").exists()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public boolean load(DuMixController duMixController, File file, File file2) {
        try {
            fn.require("dumixar");
            this.xK = false;
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
