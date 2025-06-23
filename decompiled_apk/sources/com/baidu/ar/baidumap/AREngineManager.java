package com.baidu.ar.baidumap;

import android.content.Context;
import com.baidu.ar.DuMixController;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.fn;
import com.baidu.ar.fp;
import com.baidu.ar.ge;
import com.baidu.ar.ic;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.ar.kf;
import com.baidu.ar.kr;
import com.baidu.ar.marker.MarkerErrorCode;
import com.baidu.ar.remoteres.IDuMixResLoadTask;
import java.io.File;

/* loaded from: classes7.dex */
public class AREngineManager {
    private static volatile AREngineManager lo;
    private OnEngineSoLoadedListener lp;
    private ic lq;
    private String lr;
    private Context mContext;

    /* loaded from: classes7.dex */
    public interface OnEngineSoLoadedListener {
        void onLoadedError(Throwable th);

        void onLoadedSuccess();
    }

    private AREngineManager() {
    }

    public static AREngineManager getInstance() {
        if (lo == null) {
            synchronized (AREngineManager.class) {
                try {
                    if (lo == null) {
                        synchronized (AREngineManager.class) {
                            lo = new AREngineManager();
                        }
                    }
                } finally {
                }
            }
        }
        return lo;
    }

    private boolean isCoreFileExists(Context context) {
        if (!kr.a("com.baidu.ar.remoteres.RemoteResLoader", context.getClassLoader())) {
            return true;
        }
        File file = new File(this.lr, "libdumixar-engine.so");
        return file.exists() && file.length() > 0;
    }

    public void download(final DownloadListener downloadListener) {
        ic icVar = this.lq;
        if (icVar != null) {
            icVar.prepareEglCore(new ICallback() { // from class: com.baidu.ar.baidumap.AREngineManager.1
                @Override // com.baidu.ar.callback.ICallback
                public void run() {
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 != null) {
                        downloadListener2.onDownloadComplete(true);
                    }
                }
            }, new IProgressCallback() { // from class: com.baidu.ar.baidumap.AREngineManager.2
                @Override // com.baidu.ar.ihttp.IProgressCallback
                public void onProgress(int i, int i2) {
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 != null) {
                        if (i == 0) {
                            downloadListener2.onDownloadStart(true);
                        } else {
                            downloadListener2.onDownloadProcess((int) ((i / i2) * 100.0f));
                        }
                    }
                }
            }, new ICallbackWith<IDuMixResLoadTask>() { // from class: com.baidu.ar.baidumap.AREngineManager.3
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void run(IDuMixResLoadTask iDuMixResLoadTask) {
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 != null) {
                        downloadListener2.onDownloadError(MarkerErrorCode.ERROR_DOWNLOAD_SO, iDuMixResLoadTask.getError());
                    }
                }
            });
        } else if (downloadListener != null) {
            downloadListener.onDownloadComplete(true);
        }
    }

    public boolean engineFileExists(Context context) {
        if (context == null) {
            return false;
        }
        return isCoreFileExists(context);
    }

    public void loadEngineSo() {
        if (this.mContext == null) {
            OnEngineSoLoadedListener onEngineSoLoadedListener = this.lp;
            if (onEngineSoLoadedListener != null) {
                onEngineSoLoadedListener.onLoadedError(new Throwable("context is null !!!"));
                return;
            }
            return;
        }
        fn.a(new fp(this.lr));
        try {
            fn.require("dumixar-engine");
            OnEngineSoLoadedListener onEngineSoLoadedListener2 = this.lp;
            if (onEngineSoLoadedListener2 != null) {
                onEngineSoLoadedListener2.onLoadedSuccess();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            OnEngineSoLoadedListener onEngineSoLoadedListener3 = this.lp;
            if (onEngineSoLoadedListener3 != null) {
                onEngineSoLoadedListener3.onLoadedError(th);
            }
        }
    }

    public void release() {
        ic icVar = this.lq;
        if (icVar != null) {
            icVar.release();
            this.lq = null;
        }
        lo = null;
    }

    public void setOnEngineSoLoadedListener(OnEngineSoLoadedListener onEngineSoLoadedListener) {
        this.lp = onEngineSoLoadedListener;
    }

    public void setup(Context context, BusinessSoType businessSoType) {
        this.mContext = context.getApplicationContext();
        this.lq = (ic) kr.cq("com.baidu.ar.remoteres.EglCoreManager");
        this.lr = DuMixController.getSoDownLoadDir(this.mContext);
        ic icVar = this.lq;
        if (icVar != null) {
            icVar.setBusinessTag(businessSoType.getBusiness());
            this.lq.setSoName("libdumixar-engine.so");
            this.lq.setup(context);
        }
    }

    public boolean soIsReady() {
        ic icVar;
        boolean isEngineCreated = ARPEngine.isEngineCreated();
        boolean ey = ge.ew().ey();
        kf.c("PanoDownloader", "isEngineCreated:" + isEngineCreated + " isDumixSDKCreated:" + ey);
        if (isEngineCreated || ey || (icVar = this.lq) == null) {
            return false;
        }
        return icVar.isSoDownloadSuccess();
    }
}
