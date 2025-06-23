package com.baidu.ar;

import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.net.HttpURLConnection;

/* loaded from: classes7.dex */
class en implements ew {
    private Object mLock;
    private IProgressCallback oe;
    private er rC;
    private HttpURLConnection rD;
    private et rE;
    private fa rx;
    private volatile boolean rz;

    public en(er erVar) {
        this(erVar, null);
    }

    @Override // com.baidu.ar.ew
    public void cancel() {
        if (this.rz) {
            return;
        }
        this.rx = null;
        this.oe = null;
        synchronized (this.mLock) {
            this.rz = true;
        }
    }

    @Override // com.baidu.ar.ew
    public et dH() {
        return this.rE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0104  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.baidu.ar.et dJ() {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.en.dJ():com.baidu.ar.et");
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpException e;
        boolean z;
        boolean z2;
        fa faVar;
        et dJ;
        fa faVar2;
        try {
            try {
                dJ = dJ();
                try {
                    try {
                    } catch (HttpException e2) {
                        e = e2;
                        z = false;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } finally {
                HttpURLConnection httpURLConnection = this.rD;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        } catch (HttpException e3) {
            e = e3;
            z = false;
            z2 = false;
        }
        synchronized (this.mLock) {
            try {
                z2 = this.rz;
                if (!z2 && (faVar2 = this.rx) != null) {
                    try {
                        faVar2.a(dJ);
                    } catch (HttpException e4) {
                        e = e4;
                        z = true;
                        if (!z2 && !z && (faVar = this.rx) != null) {
                            faVar.a(e);
                        }
                        HttpURLConnection httpURLConnection2 = this.rD;
                        if (httpURLConnection2 == null) {
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.oe = iProgressCallback;
    }

    public en(er erVar, fa faVar) {
        this.mLock = new Object();
        this.rz = false;
        this.rC = erVar;
        this.rx = faVar;
        this.rD = null;
        this.rE = null;
    }
}
