package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.baidumap.CaseStateListener;

/* loaded from: classes7.dex */
public class ARResourceDownloader {
    public OnARResourceDownloadListener onARResourceDownloadListener;
    private by v;

    /* loaded from: classes7.dex */
    public class a implements CaseStateListener {
        private ARResourceDownloader w;

        public a(ARResourceDownloader aRResourceDownloader) {
            this.w = aRResourceDownloader;
        }

        @Override // com.baidu.ar.baidumap.CaseStateListener
        public void onCaseCreated(boolean z, String str, String str2) {
        }

        @Override // com.baidu.ar.baidumap.CaseStateListener
        public void onCaseDestroy() {
        }

        @Override // com.baidu.ar.baidumap.CaseDownloadListener
        public void onDownloadFinish(boolean z, String str, String str2, int i, String str3) {
            kf.cl("onDownloadFinish:" + z);
            ARResourceDownloader aRResourceDownloader = this.w;
            if (aRResourceDownloader != null) {
                aRResourceDownloader.a(z);
            }
        }

        @Override // com.baidu.ar.baidumap.CaseDownloadListener
        public void onDownloadProgress(int i, String str) {
            kf.cl("onDownloadProgress:" + i);
        }

        @Override // com.baidu.ar.baidumap.CaseDownloadListener
        public void onRefused() {
        }
    }

    public ARResourceDownloader(Context context) {
        if (this.v == null) {
            this.v = new by(context);
        }
        this.v.setCaseStateListener(new a(this));
    }

    public void downloadARResource(String str) {
        if (this.v == null || TextUtils.isEmpty(str)) {
            return;
        }
        kf.cj("ARResourceDownloader::downloadARResource");
    }

    public void release() {
        if (this.v != null) {
            kf.cj("ARResourceDownloader::release");
        }
    }

    public void setOnARResourceDownloadListener(OnARResourceDownloadListener onARResourceDownloadListener) {
        this.onARResourceDownloadListener = onARResourceDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        OnARResourceDownloadListener onARResourceDownloadListener = this.onARResourceDownloadListener;
        if (onARResourceDownloadListener != null) {
            onARResourceDownloadListener.onDownloadResult(z);
        }
    }
}
