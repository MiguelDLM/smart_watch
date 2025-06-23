package com.baidu.tts.client.model;

import com.baidu.tts.a2;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d2;
import com.baidu.tts.e2;
import com.baidu.tts.m1;
import com.baidu.tts.m3;
import com.baidu.tts.n1;
import com.baidu.tts.tools.StringTool;
import java.util.UUID;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public class DownloadHandler {
    public static final int DOWNLOAD_SUCCESS = 0;

    /* renamed from: a, reason: collision with root package name */
    public n1 f10057a;
    public Future<m1> b;
    public TtsError c;
    public m3 f;
    public a2 d = a2.a();
    public volatile boolean e = false;
    public RecordData g = null;
    public String h = UUID.randomUUID().toString();

    public DownloadHandler(m3 m3Var) {
        this.f = m3Var;
    }

    public n1 getDownloadParams() {
        return this.f10057a;
    }

    public int getErrorCode() {
        return getErrorCode(this.c);
    }

    public String getErrorMessage() {
        return getErrorMessage(this.c);
    }

    public String getModelId() {
        return this.f10057a.f10137a;
    }

    public TtsError getTtsError() {
        return this.c;
    }

    public void reset(n1 n1Var) {
        setDownloadParams(n1Var);
        reset();
    }

    public void setCheckFuture(Future<m1> future) {
        this.b = future;
    }

    public void setDownloadParams(n1 n1Var) {
        this.f10057a = n1Var;
    }

    public void setTtsError(TtsError ttsError) {
        this.c = ttsError;
    }

    public synchronized void stop() {
        d2 d2Var;
        try {
            LoggerProxy.d("DownloadHandler", "stop");
            this.e = true;
            Future<m1> future = this.b;
            if (future != null) {
                future.cancel(true);
                this.b = null;
            }
            e2 e2Var = this.d.f10031a;
            e2Var.getClass();
            String modelId = getModelId();
            try {
                d2Var = new d2(modelId);
                d2 putIfAbsent = e2Var.f10079a.putIfAbsent(modelId, d2Var);
                if (putIfAbsent != null) {
                    d2Var = putIfAbsent;
                }
            } catch (Exception unused) {
                d2Var = null;
            }
            d2Var.a(this);
            this.f10057a.b = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void updateFinish(String str, TtsError ttsError) {
        setTtsError(ttsError);
        int errorCode = getErrorCode();
        if (Statistics.isStatistics) {
            this.g.setEndInfo(this.h, str, errorCode, System.currentTimeMillis() + "");
        }
        OnDownloadListener onDownloadListener = this.f10057a.b;
        if (onDownloadListener != null) {
            synchronized (this) {
                try {
                    if (!this.e) {
                        onDownloadListener.onFinish(str, errorCode);
                        this.f10057a.b = null;
                    }
                } finally {
                }
            }
        }
        synchronized (this) {
            try {
                if (Statistics.isStatistics) {
                    this.g.setEndInfo(this.h, str, errorCode, System.currentTimeMillis() + "");
                }
                if (Statistics.isStatistics) {
                    LoggerProxy.d("DownloadHandler", " statistics ret=" + new Statistics(this.f.f10136a).start());
                }
            } finally {
            }
        }
    }

    public void updateProgress(d2 d2Var) {
        long j;
        long a2 = d2Var.f.a(d2Var.b);
        long a3 = d2Var.f.a(d2Var.c);
        if (!StringTool.isEmpty(d2Var.d)) {
            j = d2Var.f.a(d2Var.d);
        } else {
            j = 0;
        }
        long j2 = a2 + a3 + j;
        d2Var.b();
        long j3 = d2Var.e;
        String str = d2Var.f10070a;
        OnDownloadListener onDownloadListener = this.f10057a.b;
        if (onDownloadListener != null) {
            synchronized (this) {
                try {
                    if (!this.e) {
                        onDownloadListener.onProgress(str, j2, j3);
                    }
                } finally {
                }
            }
        }
    }

    public void updateStart(d2 d2Var) {
        String str = d2Var.f10070a;
        this.g = new RecordData(this.f);
        synchronized (this) {
            try {
                if (Statistics.isStatistics) {
                    this.g.setStartInfo(this.h, str, System.currentTimeMillis() + "");
                }
            } finally {
            }
        }
        OnDownloadListener onDownloadListener = this.f10057a.b;
        if (onDownloadListener != null) {
            synchronized (this) {
                try {
                    if (!this.e) {
                        onDownloadListener.onStart(str);
                    }
                } finally {
                }
            }
        }
    }

    public int getErrorCode(TtsError ttsError) {
        if (ttsError != null) {
            return ttsError.getDetailCode();
        }
        return 0;
    }

    public String getErrorMessage(TtsError ttsError) {
        if (ttsError != null) {
            return ttsError.getDetailMessage();
        }
        return null;
    }

    public synchronized void reset() {
        LoggerProxy.d("DownloadHandler", "reset");
        this.e = false;
    }

    public void updateFinish(d2 d2Var, TtsError ttsError) {
        updateFinish(d2Var.f10070a, ttsError);
    }
}
