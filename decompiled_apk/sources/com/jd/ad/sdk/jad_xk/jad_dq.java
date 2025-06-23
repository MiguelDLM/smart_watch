package com.jd.ad.sdk.jad_xk;

import com.jd.ad.sdk.logger.Logger;
import java.net.URL;

/* loaded from: classes10.dex */
public abstract class jad_dq {
    public jad_kx jad_an;
    public jad_an jad_bo;

    public jad_dq(jad_kx jad_kxVar) {
        try {
            this.jad_an = jad_kxVar;
            String protocol = new URL(jad_kxVar.jad_an()).getProtocol();
            if ("http".equalsIgnoreCase(protocol)) {
                throw new IllegalArgumentException("http protocol error");
            }
            if ("https".equalsIgnoreCase(protocol)) {
                this.jad_bo = new jad_hu();
            }
        } catch (Throwable th) {
            Logger.w("Exception while base task", th.getMessage());
            throw new com.jd.ad.sdk.jad_zm.jad_an(th);
        }
    }
}
