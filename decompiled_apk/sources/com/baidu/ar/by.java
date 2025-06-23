package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.baidumap.CaseDownloadListener;
import com.baidu.ar.baidumap.CaseStateListener;
import com.baidu.ar.callback.ICancellable;
import com.baidu.ar.content.ContentCloud;
import com.baidu.ar.content.IARCaseInfo;
import com.baidu.ar.content.IRequestCallback;
import com.baidu.ar.ihttp.IProgressCallback;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class by {
    private ContentCloud lw;
    private CaseStateListener lx;
    private a ly;
    private ConcurrentHashMap<String, ICancellable> lz = new ConcurrentHashMap<>();

    /* loaded from: classes7.dex */
    public interface a {
        void b(IARCaseInfo iARCaseInfo);
    }

    public by(Context context) {
        this.lw = new ContentCloud(context);
    }

    public void N(final String str) {
        this.lz.put(str, this.lw.downloadCase(str, new IRequestCallback<IARCaseInfo>() { // from class: com.baidu.ar.by.1
            @Override // com.baidu.ar.content.IRequestCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(IARCaseInfo iARCaseInfo) {
                by.this.lz.remove(iARCaseInfo.getARKey());
                if (by.this.ly != null) {
                    by.this.ly.b(iARCaseInfo);
                }
                if (by.this.lx != null) {
                    if (iARCaseInfo.isRefused() || !iARCaseInfo.isHardwareSatisfied()) {
                        by.this.lx.onRefused();
                    } else {
                        by.this.lx.onDownloadFinish(true, iARCaseInfo.getARKey(), iARCaseInfo.getArCasePath(), 0, "ar case download success!!!");
                    }
                }
            }

            @Override // com.baidu.ar.content.IRequestCallback
            public void onFail(int i, String str2) {
                if (by.this.lx != null) {
                    by.this.lx.onDownloadFinish(false, str, null, i, str2);
                }
                by.this.lz.remove(str);
            }
        }, new IProgressCallback() { // from class: com.baidu.ar.by.2
            @Override // com.baidu.ar.ihttp.IProgressCallback
            public void onProgress(int i, int i2) {
                if (by.this.lx != null) {
                    by.this.lx.onDownloadProgress(i2 != 0 ? (i * 100) / i2 : 100, str);
                }
            }
        }));
    }

    public void O(String str) {
        ICancellable iCancellable = this.lz.get(str);
        if (iCancellable != null) {
            iCancellable.cancel();
            this.lz.remove(str);
        }
    }

    public void cancel() {
        Iterator<Map.Entry<String, ICancellable>> it = this.lz.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().cancel();
        }
        this.lz.clear();
    }

    public void checkCaseUpdate(String str, cv cvVar) {
        this.lw.checkCaseUpdate(str, cvVar);
    }

    public void downloadCase(final String str, final CaseDownloadListener caseDownloadListener) {
        this.lz.put(str, this.lw.downloadCase(str, new IRequestCallback<IARCaseInfo>() { // from class: com.baidu.ar.by.3
            @Override // com.baidu.ar.content.IRequestCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(IARCaseInfo iARCaseInfo) {
                if (caseDownloadListener != null) {
                    if (iARCaseInfo.isRefused() || !iARCaseInfo.isHardwareSatisfied()) {
                        by.this.lx.onRefused();
                        return;
                    }
                    caseDownloadListener.onDownloadFinish(true, iARCaseInfo.getARKey(), iARCaseInfo.getArCasePath(), 0, "ar case download success!!!");
                }
                by.this.lz.remove(iARCaseInfo.getARKey());
            }

            @Override // com.baidu.ar.content.IRequestCallback
            public void onFail(int i, String str2) {
                CaseDownloadListener caseDownloadListener2 = caseDownloadListener;
                if (caseDownloadListener2 != null) {
                    caseDownloadListener2.onDownloadFinish(false, str, null, i, str2);
                }
                by.this.lz.remove(str);
            }
        }, new IProgressCallback() { // from class: com.baidu.ar.by.4
            @Override // com.baidu.ar.ihttp.IProgressCallback
            public void onProgress(int i, int i2) {
                CaseDownloadListener caseDownloadListener2 = caseDownloadListener;
                if (caseDownloadListener2 != null) {
                    caseDownloadListener2.onDownloadProgress(i2 != 0 ? (i * 100) / i2 : 100, str);
                }
            }
        }));
    }

    public void release() {
        this.lx = null;
        cancel();
        this.lw.release();
        this.lw = null;
    }

    public void setCaseStateListener(CaseStateListener caseStateListener) {
        this.lx = caseStateListener;
    }

    public void a(a aVar) {
        this.ly = aVar;
    }
}
