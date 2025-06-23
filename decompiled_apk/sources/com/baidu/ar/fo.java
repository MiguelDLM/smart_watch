package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.libloader.ILibLoaderPlugin;

/* loaded from: classes7.dex */
class fo implements ILibLoader {
    private boolean tA = false;
    private fq tB = new fq();

    @Override // com.baidu.ar.libloader.ILibLoader
    public void load(Context context, ILibLoader.b bVar) {
        this.tA = true;
        this.tB.eh();
        this.tB.clearAll();
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void prepareCaseRes(ARType aRType, String str, String str2, ILibLoader.a aVar) {
        if (aVar != null) {
            aVar.a(aRType, str, str2);
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void release() {
        fq fqVar = this.tB;
        if (fqVar != null) {
            fqVar.clearAll();
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void require(String str) {
        System.loadLibrary(str);
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void setLibReadyListener(String str, ILibLoader.c cVar) {
        if (cVar != null) {
            if (this.tA) {
                cVar.onReady();
            } else {
                this.tB.a(str, cVar);
            }
        }
    }
}
