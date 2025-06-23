package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.libloader.ILibLoaderPlugin;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class fp extends fo {
    private String tC;
    private List<String> tD = new ArrayList();
    private a tE;

    /* loaded from: classes7.dex */
    public interface a {
        void a(String str, String str2);
    }

    public fp(String str) {
        this.tC = str;
    }

    private void aH(String str) {
        try {
            System.load(str);
        } catch (Throwable th) {
            if (this.tE != null) {
                this.tE.a(str, th.getMessage());
            }
            throw th;
        }
    }

    public void a(a aVar) {
        this.tE = aVar;
    }

    @Override // com.baidu.ar.fo, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void load(Context context, ILibLoader.b bVar) {
        super.load(context, bVar);
    }

    @Override // com.baidu.ar.fo, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void prepareCaseRes(ARType aRType, String str, String str2, ILibLoader.a aVar) {
        super.prepareCaseRes(aRType, str, str2, aVar);
    }

    @Override // com.baidu.ar.fo, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // com.baidu.ar.fo, com.baidu.ar.libloader.ILibLoader
    public void require(String str) {
        kf.u("LocalWithPathLibLoader", "require libName = " + str);
        try {
            super.require(str);
            if (this.tD.contains(str)) {
                return;
            }
            this.tD.add(str);
        } catch (Throwable th) {
            if (!TextUtils.isEmpty(this.tC)) {
                File file = new File(this.tC, NativeSymbolGenerator.LIB_PREFIX + str + ".so");
                if (file.exists()) {
                    aH(file.getAbsolutePath());
                    if (this.tD.contains(str)) {
                        return;
                    }
                    this.tD.add(str);
                    return;
                }
            }
            throw th;
        }
    }

    @Override // com.baidu.ar.fo, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        super.setLibLoadPlugin(iLibLoaderPlugin);
    }

    @Override // com.baidu.ar.fo, com.baidu.ar.libloader.ILibLoader
    public void setLibReadyListener(String str, ILibLoader.c cVar) {
        if (cVar == null || !this.tD.contains(str)) {
            super.setLibReadyListener(str, cVar);
        } else {
            cVar.onReady();
        }
    }
}
