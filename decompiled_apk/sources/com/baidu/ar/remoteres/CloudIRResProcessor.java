package com.baidu.ar.remoteres;

import com.baidu.ar.DuMixController;
import com.baidu.ar.fn;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import java.io.File;

/* loaded from: classes7.dex */
class CloudIRResProcessor implements IDuMixResProcessor {

    /* renamed from: xI, reason: collision with root package name */
    private static final String[] f5575xI = {"dumixar"};
    private boolean xJ = false;
    private boolean xK = false;
    private boolean xL = false;

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
        if (!this.xJ && !this.xL) {
            for (String str : f5575xI) {
                if (!new File(file, NativeSymbolGenerator.LIB_PREFIX + str + ".so").exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.ar.remoteres.IDuMixResProcessor
    public boolean load(DuMixController duMixController, File file, File file2) {
        try {
            if (!this.xL) {
                for (String str : f5575xI) {
                    fn.require(str);
                }
            }
            this.xJ = true;
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
