package com.baidu.ar.remoteres;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.Cif;
import com.baidu.ar.DuMixController;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.fn;
import com.baidu.ar.fp;
import com.baidu.ar.hz;
import com.baidu.ar.ia;
import com.baidu.ar.ic;
import com.baidu.ar.ie;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.ar.kf;
import com.baidu.ar.kg;
import com.baidu.ar.km;
import java.io.File;
import java.util.Map;

/* loaded from: classes7.dex */
public class EglCoreManager extends hz implements ic {
    private File mLibDir;
    private ia xQ;
    private String xR;

    static {
        kf.ae(true);
    }

    private void checkNewVersion() {
        String[] strArr = {fM().getBusinessTag()};
        this.mDownloader.setErrorCallback(new ICallbackWith<String>() { // from class: com.baidu.ar.remoteres.EglCoreManager.1
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public void run(String str) {
                EglCoreManager eglCoreManager = EglCoreManager.this;
                ICallbackWith<IDuMixResLoadTask> iCallbackWith = eglCoreManager.mErrorCallback;
                if (iCallbackWith != null) {
                    iCallbackWith.run(eglCoreManager.makeErrorObj(str));
                }
            }
        });
        this.mDownloader.a(strArr, new ICallbackWith<Map<String, String>>() { // from class: com.baidu.ar.remoteres.EglCoreManager.2
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void run(Map<String, String> map) {
                if (map != null) {
                    EglCoreManager.this.mBusinessResUrls.putAll(map);
                }
                EglCoreManager eglCoreManager = EglCoreManager.this;
                eglCoreManager.mIsChecked = true;
                eglCoreManager.executeReadyTask();
            }
        });
    }

    private void checkResSdkVersion(Context context) {
        Cif i = Cif.i(context);
        if (i.fQ() != kg.getVersionCode()) {
            km.a(this.mLibDir, true);
            i = Cif.fP();
        }
        this.mResVersion = i;
    }

    private ia fM() {
        if (this.xQ == null) {
            this.xQ = new ia();
        }
        return this.xQ;
    }

    @Override // com.baidu.ar.ic
    public boolean isSoDownloadSuccess() {
        ia fM = fM();
        boolean z = false;
        if (fM != null) {
            if (fM.isReady(this.mLibDir, null) && km.m(this.mLibDir)) {
                z = true;
            }
            kf.c("EglCoreManager", "check so download success: isSoDownloadSuccess:" + z);
        }
        return z;
    }

    @Override // com.baidu.ar.ic
    public void prepareEglCore(ICallback iCallback, IProgressCallback iProgressCallback, ICallbackWith<IDuMixResLoadTask> iCallbackWith) {
        this.mErrorCallback = iCallbackWith;
        a(iCallback, iProgressCallback);
    }

    @Override // com.baidu.ar.ic
    public void release() {
        onRelease();
    }

    @Override // com.baidu.ar.ic
    public void setBusinessTag(String str) {
        fM().setBusinessTag(str);
    }

    @Override // com.baidu.ar.ic
    public void setSoName(String str) {
        this.xR = str;
    }

    @Override // com.baidu.ar.ic
    public void setup(Context context) {
        this.mContext = context.getApplicationContext();
        this.mLibDir = new File(DuMixController.getSoDownLoadDir(context));
        if (!fn.isRegistered()) {
            fn.a(new fp(this.mLibDir.getAbsolutePath()));
        }
        checkResSdkVersion(context);
        km.d(this.mLibDir);
        this.mDownloader = new ie(context.getApplicationContext(), this.mLibDir);
        checkNewVersion();
    }

    private void a(final ICallback iCallback, final IProgressCallback iProgressCallback) {
        final ia fM = fM();
        if (fM != null) {
            onReady(new Runnable() { // from class: com.baidu.ar.remoteres.EglCoreManager.3
                private void fN() {
                    iProgressCallback.onProgress(0, 0);
                    kf.c("EglCoreManager", "start downloading so:" + fM.getBusinessTag());
                    EglCoreManager.this.doDownloadRes(fM.getBusinessTag(), new ICallback() { // from class: com.baidu.ar.remoteres.EglCoreManager.3.1
                        @Override // com.baidu.ar.callback.ICallback
                        public void run() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            EglCoreManager.this.updateModResVersion(fM);
                            fM.load(null, null, null);
                            DuMixResManager.setAREngienDownload(true);
                            ICallback iCallback2 = iCallback;
                            if (iCallback2 != null) {
                                iCallback2.run();
                            }
                        }
                    }, iProgressCallback);
                }

                @Override // java.lang.Runnable
                public void run() {
                    ICallback iCallback2;
                    if (TextUtils.isEmpty(EglCoreManager.this.xR)) {
                        if (EglCoreManager.this.isSoDownloadSuccess() && !EglCoreManager.this.isModHasNewVersion(fM.getBusinessTag())) {
                            iCallback2 = iCallback;
                            if (iCallback2 == null) {
                                return;
                            }
                            iCallback2.run();
                            return;
                        }
                        fN();
                    }
                    if (EglCoreManager.this.isSoDownloadSuccess() && km.a(EglCoreManager.this.mLibDir, EglCoreManager.this.xR) && !EglCoreManager.this.isModHasNewVersion(fM.getBusinessTag())) {
                        iCallback2 = iCallback;
                        if (iCallback2 == null) {
                            return;
                        }
                        iCallback2.run();
                        return;
                    }
                    fN();
                }
            });
        } else if (iCallback != null) {
            iCallback.run();
        }
    }
}
