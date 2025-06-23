package com.baidu.ar;

import android.text.TextUtils;
import com.baidu.ar.remoteres.IDuMixResProcessor;
import java.io.File;

/* loaded from: classes7.dex */
public class ia implements IDuMixResProcessor {
    private boolean xJ = false;
    private boolean xK = false;
    private String xU;

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public String getBusinessTag() {
        return TextUtils.isEmpty(this.xU) ? "egl_core" : this.xU;
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public boolean isLoaded() {
        return this.xJ;
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public boolean isReady(File file, File file2) {
        return !this.xK;
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public boolean load(DuMixController duMixController, File file, File file2) {
        try {
            this.xK = false;
            this.xJ = true;
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            this.xK = true;
            return false;
        }
    }

    public void setBusinessTag(String str) {
        this.xU = str;
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public void setUseLocalLib() {
    }
}
