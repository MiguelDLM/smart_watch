package com.jd.ad.sdk.jad_zi;

import java.io.InputStream;
import java.util.logging.Logger;

/* loaded from: classes10.dex */
public final class jad_er {
    static {
        Logger.getLogger(jad_er.class.getName());
    }

    public static jad_mz jad_an(InputStream inputStream) {
        jad_na jad_naVar = new jad_na();
        if (inputStream != null) {
            return new jad_dq(jad_naVar, inputStream);
        }
        throw new IllegalArgumentException("in == null");
    }
}
