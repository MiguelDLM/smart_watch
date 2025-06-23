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

public class tanxc_do {
    private boolean tanxc_byte;
    private final OkHttpClient tanxc_case = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(false);
    /* access modifiers changed from: private */
    public final Handler tanxc_char = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for();
    /* access modifiers changed from: private */
    public long tanxc_do;
    private Request.Builder tanxc_else;
    private String tanxc_for;
    private String tanxc_if;
    /* access modifiers changed from: private */
    public String tanxc_int;
    /* access modifiers changed from: private */
    public String tanxc_new;
    /* access modifiers changed from: private */
    public boolean tanxc_try;

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
        if (!this.tanxc_byte) {
            return;
        }
        if (!TextUtils.isEmpty(this.tanxc_for)) {
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_for);
        } else {
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_if);
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
                if (!com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_for)) {
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_for);
                } else {
                    return;
                }
            } else if (!com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_if)) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_if);
            } else {
                return;
            }
        }
        if (this.tanxc_try) {
            File file = new File(this.tanxc_int, this.tanxc_new);
            if (file.exists()) {
                this.tanxc_do = file.length();
                Request.Builder builder = this.tanxc_else;
                builder.header("RANGE", "bytes=" + this.tanxc_do + HelpFormatter.DEFAULT_OPT_PREFIX);
            }
        }
        this.tanxc_case.newCall(this.tanxc_else.build()).enqueue(new Callback() {
            public void onFailure(Call call, final IOException iOException) {
                tanxc_do.this.tanxc_if();
                tanxc_do.this.tanxc_char.post(new Runnable() {
                    public void run() {
                        OnDownloadListener onDownloadListener = onDownloadListener;
                        UtErrorCode utErrorCode = UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                        int intCode = utErrorCode.getIntCode();
                        onDownloadListener.onDownloadFailed(intCode, utErrorCode.getMsg() + ": 下载失败监听回调 :" + LogUtils.getStackTraceMessage(iOException));
                    }
                });
            }

            public void onResponse(Call call, Response response) throws IOException {
                long longValue;
                try {
                    tanxc_do.this.tanxc_if();
                    File andCreateFile = FileUtil.getAndCreateFile(tanxc_do.this.tanxc_int, tanxc_do.this.tanxc_new);
                    Long valueOf = Long.valueOf(response.body().contentLength());
                    if (tanxc_do.this.tanxc_do == valueOf.longValue()) {
                        tanxc_do.this.tanxc_do(andCreateFile, -1, -1, (Exception) null, onDownloadListener);
                        return;
                    }
                    if (tanxc_do.this.tanxc_try) {
                        longValue = valueOf.longValue() + tanxc_do.this.tanxc_do;
                    } else {
                        longValue = valueOf.longValue();
                    }
                    tanxc_do.this.tanxc_do((File) null, longValue, -1, (Exception) null, onDownloadListener);
                    if (response.body() != null) {
                        FileUtil.writeFile(response.body(), andCreateFile, tanxc_do.this.tanxc_do, tanxc_do.this.tanxc_try, new FileUtil.WriteProgress() {
                            public void error(Exception exc) {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                tanxc_do.this.tanxc_do((File) null, -1, -1, exc, onDownloadListener);
                            }

                            public void writeProgress(int i) {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                tanxc_do.this.tanxc_do((File) null, -1, i, (Exception) null, onDownloadListener);
                            }
                        });
                    }
                    tanxc_do.this.tanxc_do(andCreateFile, -1, -1, (Exception) null, onDownloadListener);
                } catch (Exception e) {
                    Exception exc = e;
                    LogUtils.e("OkDownloadBuilder", exc);
                    tanxc_do.this.tanxc_do((File) null, -1, -1, exc, onDownloadListener);
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

    public void tanxc_do(File file, long j, int i, Exception exc, OnDownloadListener onDownloadListener) {
        if (onDownloadListener != null) {
            final int i2 = i;
            final OnDownloadListener onDownloadListener2 = onDownloadListener;
            final File file2 = file;
            final long j2 = j;
            final Exception exc2 = exc;
            this.tanxc_char.post(new Runnable() {
                public void run() {
                    int i = i2;
                    if (i > -1) {
                        onDownloadListener2.onDownloading(i);
                    }
                    File file = file2;
                    if (file != null) {
                        onDownloadListener2.onDownloadSuccess(file);
                    }
                    long j = j2;
                    if (j > -1) {
                        onDownloadListener2.onDownLoadTotal(j);
                    }
                    if (exc2 != null) {
                        OnDownloadListener onDownloadListener = onDownloadListener2;
                        UtErrorCode utErrorCode = UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                        int intCode = utErrorCode.getIntCode();
                        onDownloadListener.onDownloadFailed(intCode, utErrorCode.getMsg() + ": callBack e不为空:" + LogUtils.getStackTraceMessage(exc2));
                    }
                }
            });
        }
    }
}
