package com.alimm.tanx.core.net.okhttp.tanxc_do;

import android.os.Handler;
import android.text.TextUtils;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.FileUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes.dex */
public class tanxc_do {
    private boolean tanxc_byte;
    private final OkHttpClient tanxc_case = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(false);
    private final Handler tanxc_char = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for();
    private long tanxc_do;
    private Request.Builder tanxc_else;
    private String tanxc_for;
    private String tanxc_if;
    private String tanxc_int;
    private String tanxc_new;
    private boolean tanxc_try;

    public tanxc_do tanxc_do() {
        Request.Builder builder = new Request.Builder();
        this.tanxc_else = builder;
        builder.url(this.tanxc_if);
        if (!TextUtils.isEmpty(this.tanxc_for)) {
            this.tanxc_else.tag(this.tanxc_for);
        }
        this.tanxc_else.cacheControl(CacheControl.FORCE_NETWORK);
        return this;
    }

    public tanxc_do tanxc_for(String str) {
        this.tanxc_if = str;
        return this;
    }

    public void tanxc_if() {
        if (this.tanxc_byte) {
            if (!TextUtils.isEmpty(this.tanxc_for)) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_for);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_if);
            }
        }
    }

    public tanxc_do tanxc_int(String str) {
        this.tanxc_for = str;
        return this;
    }

    public tanxc_do tanxc_if(String str) {
        this.tanxc_new = str;
        return this;
    }

    public void tanxc_do(final OnDownloadListener onDownloadListener) {
        if (this.tanxc_byte) {
            if (!TextUtils.isEmpty(this.tanxc_for)) {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_for)) {
                    return;
                } else {
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_for);
                }
            } else if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_if)) {
                return;
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_if);
            }
        }
        if (this.tanxc_try) {
            File file = new File(this.tanxc_int, this.tanxc_new);
            if (file.exists()) {
                this.tanxc_do = file.length();
                this.tanxc_else.header("RANGE", "bytes=" + this.tanxc_do + HelpFormatter.DEFAULT_OPT_PREFIX);
            }
        }
        this.tanxc_case.newCall(this.tanxc_else.build()).enqueue(new Callback() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, final IOException iOException) {
                tanxc_do.this.tanxc_if();
                tanxc_do.this.tanxc_char.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OnDownloadListener onDownloadListener2 = onDownloadListener;
                        UtErrorCode utErrorCode = UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                        onDownloadListener2.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + ": 下载失败监听回调 :" + LogUtils.getStackTraceMessage(iOException));
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                long longValue;
                try {
                    tanxc_do.this.tanxc_if();
                    File andCreateFile = FileUtil.getAndCreateFile(tanxc_do.this.tanxc_int, tanxc_do.this.tanxc_new);
                    Long valueOf = Long.valueOf(response.body().contentLength());
                    if (tanxc_do.this.tanxc_do == valueOf.longValue()) {
                        tanxc_do.this.tanxc_do(andCreateFile, -1L, -1, null, onDownloadListener);
                        return;
                    }
                    if (tanxc_do.this.tanxc_try) {
                        longValue = valueOf.longValue() + tanxc_do.this.tanxc_do;
                    } else {
                        longValue = valueOf.longValue();
                    }
                    tanxc_do.this.tanxc_do(null, longValue, -1, null, onDownloadListener);
                    if (response.body() != null) {
                        FileUtil.writeFile(response.body(), andCreateFile, tanxc_do.this.tanxc_do, tanxc_do.this.tanxc_try, new FileUtil.WriteProgress() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.1.2
                            @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
                            public void error(Exception exc) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                tanxc_do.this.tanxc_do(null, -1L, -1, exc, onDownloadListener);
                            }

                            @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
                            public void writeProgress(int i) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                tanxc_do.this.tanxc_do(null, -1L, i, null, onDownloadListener);
                            }
                        });
                    }
                    tanxc_do.this.tanxc_do(andCreateFile, -1L, -1, null, onDownloadListener);
                } catch (Exception e) {
                    LogUtils.e("OkDownloadBuilder", e);
                    tanxc_do.this.tanxc_do(null, -1L, -1, e, onDownloadListener);
                }
            }
        });
    }

    public tanxc_do tanxc_do(String str) {
        this.tanxc_int = str;
        return this;
    }

    public tanxc_do tanxc_do(boolean z) {
        this.tanxc_try = z;
        return this;
    }

    public void tanxc_do(final File file, final long j, final int i, final Exception exc, final OnDownloadListener onDownloadListener) {
        if (onDownloadListener != null) {
            this.tanxc_char.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.2
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = i;
                    if (i2 > -1) {
                        onDownloadListener.onDownloading(i2);
                    }
                    File file2 = file;
                    if (file2 != null) {
                        onDownloadListener.onDownloadSuccess(file2);
                    }
                    long j2 = j;
                    if (j2 > -1) {
                        onDownloadListener.onDownLoadTotal(j2);
                    }
                    if (exc != null) {
                        OnDownloadListener onDownloadListener2 = onDownloadListener;
                        UtErrorCode utErrorCode = UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                        onDownloadListener2.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + ": callBack e不为空:" + LogUtils.getStackTraceMessage(exc));
                    }
                }
            });
        }
    }
}
