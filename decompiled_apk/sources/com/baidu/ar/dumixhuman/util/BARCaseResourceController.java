package com.baidu.ar.dumixhuman.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.ar.dumixhuman.util.casedownload.OnCaseDownloadListener;
import com.baidu.ar.eg;
import com.baidu.ar.eh;
import com.baidu.ar.kf;
import com.baidu.ar.km;
import java.io.File;

/* loaded from: classes7.dex */
public class BARCaseResourceController {
    private static BARCaseResourceController rc;
    public OnCaseDownloadListener onCaseDownloadListener;
    private eh rb;

    /* loaded from: classes7.dex */
    public class a implements eg {
        private BARCaseResourceController rd;

        public a(BARCaseResourceController bARCaseResourceController) {
            this.rd = bARCaseResourceController;
        }

        @Override // com.baidu.ar.eg
        public void onDownloadFinish(boolean z, String str, String str2, int i, String str3) {
            kf.cl("onDownloadFinish:" + z);
            BARCaseResourceController bARCaseResourceController = this.rd;
            if (bARCaseResourceController != null) {
                bARCaseResourceController.a(z);
            }
        }

        @Override // com.baidu.ar.eg
        public void onDownloadProgress(int i, String str) {
            BARCaseResourceController bARCaseResourceController = this.rd;
            if (bARCaseResourceController != null) {
                bARCaseResourceController.y(i);
            }
        }

        @Override // com.baidu.ar.eg
        public void onRefused() {
        }
    }

    private BARCaseResourceController(Context context) {
        if (this.rb == null) {
            this.rb = new eh(context);
        }
        this.rb.a(new a(this));
    }

    public static synchronized BARCaseResourceController getInstance(Context context) {
        BARCaseResourceController bARCaseResourceController;
        synchronized (BARCaseResourceController.class) {
            try {
                if (rc == null) {
                    rc = new BARCaseResourceController(context);
                }
                bARCaseResourceController = rc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bARCaseResourceController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i) {
        OnCaseDownloadListener onCaseDownloadListener = this.onCaseDownloadListener;
        if (onCaseDownloadListener != null) {
            onCaseDownloadListener.onDownloadProgress(i);
        }
    }

    public void cancelAllDownLoadArCase() {
        eh ehVar = this.rb;
        if (ehVar != null) {
            ehVar.dB();
        }
    }

    public void cancelDownLoadArCase(String str) {
        if (this.rb == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.rb.au(str);
    }

    public void clearAllCache(Context context) {
        a(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            a(context.getExternalFilesDir(""));
            a(context.getFilesDir());
        }
    }

    public void clearArKeyCache(String str) {
        if (this.rb == null || TextUtils.isEmpty(str)) {
            return;
        }
        a(new File(this.rb.getCasePath(str)));
    }

    public void downloadARCase(String str) {
        if (this.rb == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.rb.au(str);
        this.rb.N(str);
    }

    public String getCasePath(String str) {
        if (this.rb != null && !TextUtils.isEmpty(str)) {
            String casePath = this.rb.getCasePath(str);
            if (!TextUtils.isEmpty(casePath) && km.m(new File(casePath))) {
                kf.u("BARCaseResourceController", "getCasePath : " + casePath);
                return casePath;
            }
        }
        kf.u("BARCaseResourceController", "getCasePath empty");
        return "";
    }

    public void release() {
        eh ehVar = this.rb;
        if (ehVar != null) {
            ehVar.release();
        }
        rc = null;
    }

    public void setOnCaseDownloadListener(OnCaseDownloadListener onCaseDownloadListener) {
        this.onCaseDownloadListener = onCaseDownloadListener;
    }

    private void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                a(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        OnCaseDownloadListener onCaseDownloadListener = this.onCaseDownloadListener;
        if (onCaseDownloadListener != null) {
            onCaseDownloadListener.onDownloadResult(z);
        }
    }
}
