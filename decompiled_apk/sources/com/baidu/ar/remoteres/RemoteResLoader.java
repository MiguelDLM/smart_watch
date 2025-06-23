package com.baidu.ar.remoteres;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.ARType;
import com.baidu.ar.DuMixController;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.ICancellable;
import com.baidu.ar.content.IARCaseInfo;
import com.baidu.ar.content.IRequestCallback;
import com.baidu.ar.fq;
import com.baidu.ar.kf;
import com.baidu.ar.kv;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.libloader.ILibLoaderPlugin;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class RemoteResLoader implements ILibLoader {
    private fq tB;
    private String tC;
    private DuMixResManager xW;

    /* renamed from: xX, reason: collision with root package name */
    private DuMixController f5576xX;
    private boolean xY = false;
    private final Map<String, Integer> xZ;
    private ILibLoaderPlugin ya;
    private ICancellable yb;

    public RemoteResLoader(DuMixController duMixController, String str) {
        HashMap hashMap = new HashMap();
        this.xZ = hashMap;
        this.tC = str;
        hashMap.clear();
        this.tB = new fq();
        this.f5576xX = duMixController;
    }

    private void bw(final String str) {
        kv.runOnUiThread(new Runnable() { // from class: com.baidu.ar.remoteres.RemoteResLoader.4
            @Override // java.lang.Runnable
            public void run() {
                RemoteResLoader.this.tB.aJ(str);
                RemoteResLoader.this.tB.aI(str);
            }
        });
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void load(final Context context, final ILibLoader.b bVar) {
        ILibLoaderPlugin iLibLoaderPlugin = this.ya;
        if (iLibLoaderPlugin != null) {
            iLibLoaderPlugin.onBeforeLoad(new ICallback() { // from class: com.baidu.ar.remoteres.RemoteResLoader.1
                @Override // com.baidu.ar.callback.ICallback
                public void run() {
                    RemoteResLoader.this.a(context, bVar);
                }
            });
        } else {
            a(context, bVar);
        }
    }

    public void loadCaseAndRes(final ARType aRType, final String str, final ILibLoader.a aVar) {
        DuMixController duMixController = this.f5576xX;
        if (duMixController == null || duMixController.getContentPlatform() == null) {
            aVar.a(aRType, null, str);
            return;
        }
        ICancellable iCancellable = this.yb;
        if (iCancellable != null) {
            iCancellable.cancel();
        }
        final int[] iArr = {2, 0};
        final String[] strArr = new String[1];
        this.yb = this.f5576xX.getContentPlatform().downloadCase(str, new IRequestCallback<IARCaseInfo>() { // from class: com.baidu.ar.remoteres.RemoteResLoader.6
            @Override // com.baidu.ar.content.IRequestCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(IARCaseInfo iARCaseInfo) {
                ILibLoader.a aVar2;
                RemoteResLoader.this.yb = null;
                if (iARCaseInfo == null || iARCaseInfo.getCaseBundleInfo() == null) {
                    return;
                }
                int[] iArr2 = iArr;
                iArr2[1] = iArr2[1] + 1;
                strArr[0] = new File(iARCaseInfo.getCaseBundleInfo().caseDir).getParent();
                int[] iArr3 = iArr;
                if (iArr3[1] < iArr3[0] || (aVar2 = aVar) == null) {
                    return;
                }
                aVar2.a(aRType, strArr[0], str);
            }

            @Override // com.baidu.ar.content.IRequestCallback
            public void onFail(int i, String str2) {
                RemoteResLoader.this.yb = null;
                ILibLoader.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(DuMixErrorType.LoadCaseError, str2);
                }
            }
        }, null);
        this.xW.loadARRes(aRType, this.f5576xX, new ICallback() { // from class: com.baidu.ar.remoteres.RemoteResLoader.7
            @Override // com.baidu.ar.callback.ICallback
            public void run() {
                ILibLoader.a aVar2;
                int[] iArr2 = iArr;
                int i = iArr2[1] + 1;
                iArr2[1] = i;
                if (i < iArr2[0] || (aVar2 = aVar) == null) {
                    return;
                }
                aVar2.a(aRType, strArr[0], str);
            }
        });
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void prepareCaseRes(final ARType aRType, final String str, final String str2, final ILibLoader.a aVar) {
        if (this.f5576xX == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || aRType == ARType.CLOUD_IR || aRType == ARType.ON_DEVICE_IR) {
            this.xW.loadARRes(aRType, this.f5576xX, new ICallback() { // from class: com.baidu.ar.remoteres.RemoteResLoader.5
                @Override // com.baidu.ar.callback.ICallback
                public void run() {
                    ILibLoader.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(aRType, str, str2);
                    }
                }
            });
        } else {
            loadCaseAndRes(aRType, str2, aVar);
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void release() {
        this.ya = null;
        this.yb = null;
        this.f5576xX = null;
        DuMixResManager duMixResManager = this.xW;
        if (duMixResManager != null) {
            duMixResManager.release();
            this.xW = null;
        }
        this.xZ.clear();
        fq fqVar = this.tB;
        if (fqVar != null) {
            fqVar.clearAll();
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void require(String str) {
        kf.u("RemoteResLoader", "require libName = " + str);
        if (this.xZ.containsKey(str) && this.xZ.get(str).intValue() == 1) {
            return;
        }
        this.xZ.put(str, 0);
        if (TextUtils.isEmpty(this.tC)) {
            return;
        }
        File file = new File(this.tC, NativeSymbolGenerator.LIB_PREFIX + str + ".so");
        if (file.exists()) {
            try {
                System.load(file.getAbsolutePath());
                this.xZ.put(str, 1);
                bw(str);
            } catch (Throwable th) {
                kf.cj(th.getMessage());
            }
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        this.ya = iLibLoaderPlugin;
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void setLibReadyListener(String str, ILibLoader.c cVar) {
        if (cVar != null) {
            this.tB.a(str, cVar);
            if (this.xZ.containsKey(str) && this.xZ.get(str).intValue() == 1) {
                bw(str);
            } else {
                cVar.onError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final ILibLoader.b bVar) {
        if (this.xW == null) {
            this.xW = new DuMixResManager(context);
        }
        this.xW.setErrorCallback(new ICallbackWith<IDuMixResLoadTask>() { // from class: com.baidu.ar.remoteres.RemoteResLoader.2
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void run(IDuMixResLoadTask iDuMixResLoadTask) {
                ILibLoader.b bVar2;
                if ((RemoteResLoader.this.ya != null ? RemoteResLoader.this.ya.processLoadError(new ICallback() { // from class: com.baidu.ar.remoteres.RemoteResLoader.2.1
                    @Override // com.baidu.ar.callback.ICallback
                    public void run() {
                        if (RemoteResLoader.this.xW != null) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            RemoteResLoader.this.a(context, bVar);
                        }
                    }
                }) : false) || (bVar2 = bVar) == null) {
                    return;
                }
                bVar2.a(DuMixErrorType.LibraryError, new Exception(iDuMixResLoadTask.getError()));
            }
        });
        this.xW.loadMainLib(new ICallback() { // from class: com.baidu.ar.remoteres.RemoteResLoader.3
            @Override // com.baidu.ar.callback.ICallback
            public void run() {
                RemoteResLoader.this.a(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ILibLoader.b bVar) {
        DuMixResManager duMixResManager = this.xW;
        if (duMixResManager == null) {
            return;
        }
        this.xY = true;
        duMixResManager.setErrorCallback(null);
        try {
            require("dumixar");
            DuMixController duMixController = this.f5576xX;
            if (duMixController != null) {
                this.xW.prepareMainRes(duMixController);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (bVar != null) {
                bVar.a(DuMixErrorType.LibraryError, new Exception(th.getMessage()));
            }
        }
    }
}
