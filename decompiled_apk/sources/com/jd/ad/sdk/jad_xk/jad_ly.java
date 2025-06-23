package com.jd.ad.sdk.jad_xk;

import com.jd.ad.sdk.logger.Logger;
import java.io.BufferedInputStream;
import java.io.Closeable;

/* loaded from: classes10.dex */
public final class jad_ly implements Closeable {
    public static final /* synthetic */ int jad_er = 0;
    public int jad_an;
    public jad_fs jad_bo;
    public jad_na jad_cp;
    public com.jd.ad.sdk.jad_xk.jad_an jad_dq;

    /* loaded from: classes10.dex */
    public static final class jad_an {
        public int jad_an;
        public jad_fs jad_bo;
        public jad_na jad_cp;
        public com.jd.ad.sdk.jad_xk.jad_an jad_dq;
    }

    static {
        new jad_ly(new jad_an());
    }

    public jad_ly(jad_an jad_anVar) {
        this.jad_an = jad_anVar.jad_an;
        this.jad_bo = jad_anVar.jad_bo;
        this.jad_cp = jad_anVar.jad_cp;
        this.jad_dq = jad_anVar.jad_dq;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            com.jd.ad.sdk.jad_xk.jad_an jad_anVar = this.jad_dq;
            if (jad_anVar != null) {
                jad_anVar.jad_an();
                this.jad_dq = null;
            }
            jad_fs jad_fsVar = this.jad_bo;
            if (jad_fsVar != null) {
                jad_fsVar.jad_an.clear();
                this.jad_bo = null;
            }
            BufferedInputStream bufferedInputStream = this.jad_cp.jad_bo;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        } catch (Exception e) {
            Logger.w("Exception while response close", e.getMessage());
        }
    }

    public jad_na jad_bo() {
        return this.jad_cp;
    }

    public int jad_cp() {
        return this.jad_an;
    }

    public String toString() {
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Response{mCode=");
        jad_an2.append(this.jad_an);
        jad_an2.append(", mHeaders=");
        jad_an2.append(this.jad_bo);
        jad_an2.append(", mBody=");
        jad_an2.append(this.jad_cp);
        jad_an2.append('}');
        return jad_an2.toString();
    }
}
