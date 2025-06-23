package com.baidu.ar.http;

import com.baidu.ar.eo;
import com.baidu.ar.ep;
import com.baidu.ar.eq;
import com.baidu.ar.fb;
import com.baidu.ar.ihttp.IHttpRequest;

/* loaded from: classes7.dex */
public class HttpRequestFactory implements fb {
    private volatile ep rR;

    public ep getExecutor() {
        if (this.rR == null) {
            synchronized (this) {
                try {
                    if (this.rR == null) {
                        this.rR = new ep(2, 5, 1000, 60L);
                    }
                } finally {
                }
            }
        }
        return this.rR;
    }

    @Override // com.baidu.ar.fb
    public IHttpRequest newRequest() {
        eq eqVar = new eq(this);
        eqVar.setCharset(eo.rF);
        eqVar.setConnectionTimeout(2000);
        eqVar.setReadTimeout(30000);
        eqVar.setUseCache(false);
        eqVar.addHeaders(eo.rG);
        return eqVar;
    }

    @Override // com.baidu.ar.fb
    public void release() {
        if (this.rR != null) {
            this.rR.shutdown();
            this.rR = null;
        }
    }
}
