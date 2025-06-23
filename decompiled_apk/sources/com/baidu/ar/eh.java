package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.callback.ICancellable;
import com.baidu.ar.content.ContentCloud;
import com.baidu.ar.content.IARCaseInfo;
import com.baidu.ar.content.IRequestCallback;
import com.baidu.ar.ihttp.IProgressCallback;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class eh {
    private ContentCloud lw;
    private ConcurrentHashMap<String, ICancellable> lz = new ConcurrentHashMap<>();
    private eg rh;
    private a ri;

    /* loaded from: classes7.dex */
    public interface a {
        void b(IARCaseInfo iARCaseInfo);
    }

    public eh(Context context) {
        this.lw = new ContentCloud(context);
    }

    public void N(final String str) {
        if (this.lw == null) {
            return;
        }
        kf.u("CaseDownloader", "start downloading case,arkey:" + str);
        this.lz.put(str, this.lw.downloadCase(str, new IRequestCallback<IARCaseInfo>() { // from class: com.baidu.ar.eh.1
            @Override // com.baidu.ar.content.IRequestCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(IARCaseInfo iARCaseInfo) {
                eh.this.lz.remove(iARCaseInfo.getARKey());
                if (eh.this.ri != null) {
                    eh.this.ri.b(iARCaseInfo);
                }
                if (eh.this.rh != null) {
                    if (iARCaseInfo.isRefused() || !iARCaseInfo.isHardwareSatisfied()) {
                        eh.this.rh.onRefused();
                    } else {
                        eh.this.rh.onDownloadFinish(true, iARCaseInfo.getARKey(), iARCaseInfo.getArCasePath(), 0, "ar case download success!!!");
                    }
                }
            }

            @Override // com.baidu.ar.content.IRequestCallback
            public void onFail(int i, String str2) {
                if (eh.this.rh != null) {
                    eh.this.rh.onDownloadFinish(false, str, null, i, str2);
                }
                eh.this.lz.remove(str);
            }
        }, new IProgressCallback() { // from class: com.baidu.ar.eh.2
            @Override // com.baidu.ar.ihttp.IProgressCallback
            public void onProgress(int i, int i2) {
                if (eh.this.rh != null) {
                    eh.this.rh.onDownloadProgress(i2 != 0 ? (i * 100) / i2 : 100, str);
                }
            }
        }));
    }

    public void au(String str) {
        ICancellable iCancellable = this.lz.get(str);
        if (iCancellable != null) {
            iCancellable.cancel();
            this.lz.remove(str);
        }
    }

    public void dB() {
        Iterator<Map.Entry<String, ICancellable>> it = this.lz.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().cancel();
        }
        this.lz.clear();
    }

    public String getCasePath(String str) {
        ContentCloud contentCloud = this.lw;
        if (contentCloud != null) {
            return contentCloud.getCasePath(str);
        }
        return null;
    }

    public void release() {
        this.rh = null;
        dB();
        this.lw.release();
        this.lw = null;
    }

    public void a(eg egVar) {
        this.rh = egVar;
    }
}
