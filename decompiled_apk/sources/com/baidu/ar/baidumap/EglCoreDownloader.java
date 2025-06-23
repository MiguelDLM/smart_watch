package com.baidu.ar.baidumap;

import android.content.Context;
import com.baidu.ar.DuMixController;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.ge;
import com.baidu.ar.ic;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.ar.kf;
import com.baidu.ar.kr;
import com.baidu.ar.marker.MarkerErrorCode;
import com.baidu.ar.remoteres.IDuMixResLoadTask;
import java.io.File;

/* loaded from: classes7.dex */
public class EglCoreDownloader {
    private static volatile EglCoreDownloader lD;
    private ic lq;

    private EglCoreDownloader(Context context) {
        ic icVar = (ic) kr.cq("com.baidu.ar.remoteres.EglCoreManager");
        this.lq = icVar;
        if (icVar != null) {
            icVar.setup(context);
        }
    }

    public static EglCoreDownloader getInstance(Context context) {
        if (lD == null) {
            synchronized (EglCoreDownloader.class) {
                try {
                    if (lD == null) {
                        lD = new EglCoreDownloader(context);
                    }
                } finally {
                }
            }
        }
        return lD;
    }

    private boolean isCoreFileExists(Context context) {
        if (!kr.a("com.baidu.ar.remoteres.RemoteResLoader", context.getClassLoader())) {
            return true;
        }
        File file = new File(DuMixController.getSoDownLoadDir(context), "libdumixar.so");
        return file.exists() && file.length() > 0;
    }

    public void download(final DownloadListener downloadListener) {
        ic icVar = this.lq;
        if (icVar != null) {
            icVar.prepareEglCore(new ICallback() { // from class: com.baidu.ar.baidumap.EglCoreDownloader.1
                @Override // com.baidu.ar.callback.ICallback
                public void run() {
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 != null) {
                        downloadListener2.onDownloadComplete(true);
                    }
                }
            }, new IProgressCallback() { // from class: com.baidu.ar.baidumap.EglCoreDownloader.2
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
            }, new ICallbackWith<IDuMixResLoadTask>() { // from class: com.baidu.ar.baidumap.EglCoreDownloader.3
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

    public void release() {
        ic icVar = this.lq;
        if (icVar != null) {
            icVar.release();
            this.lq = null;
        }
        lD = null;
    }

    public void setDownloadSoBusinessTag(BusinessSoType businessSoType) {
        ic icVar = this.lq;
        if (icVar != null) {
            icVar.setBusinessTag(businessSoType.getBusiness());
        }
    }

    public boolean soIsReady() {
        ic icVar;
        boolean isEngineCreated = ARPEngine.isEngineCreated();
        boolean ey = ge.ew().ey();
        kf.c("EglCoreDownloader", "isEngineCreated:" + isEngineCreated + " isDumixSDKCreated:" + ey);
        if (isEngineCreated || ey || (icVar = this.lq) == null) {
            return false;
        }
        return icVar.isSoDownloadSuccess();
    }
}
