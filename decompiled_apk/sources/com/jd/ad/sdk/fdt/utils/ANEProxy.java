package com.jd.ad.sdk.fdt.utils;

import android.text.TextUtils;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes10.dex */
public class ANEProxy {
    public static synchronized String ja(String str) {
        String jad_cp;
        synchronized (ANEProxy.class) {
            jad_cp = ANE.jad_cp(str);
        }
        return jad_cp;
    }

    public static synchronized String jb(String str) {
        String jad_an;
        synchronized (ANEProxy.class) {
            jad_an = ANE.jad_an(str);
        }
        return jad_an;
    }

    public static synchronized String jc(String str) {
        String trim;
        synchronized (ANEProxy.class) {
            synchronized (ANE.class) {
                try {
                    int i = ANE.jad_an;
                    if (!TextUtils.isEmpty(str)) {
                        trim = str.trim();
                        if (!trim.startsWith("{") || !trim.endsWith(ooOOo0oXI.f33074oOoXoXO)) {
                            try {
                                trim = ANE.jad_an(trim);
                            } catch (Throwable th) {
                                Logger.d(Log.getStackTraceString(th));
                                trim = "";
                            }
                            if (trim.startsWith("{")) {
                                if (trim.endsWith(ooOOo0oXI.f33074oOoXoXO)) {
                                }
                            }
                        }
                    }
                    trim = "";
                } finally {
                }
            }
        }
        return trim;
    }

    public static synchronized String jd(String str) {
        String jad_dq;
        synchronized (ANEProxy.class) {
            jad_dq = ANE.jad_dq(str);
        }
        return jad_dq;
    }

    public static synchronized String je(String str) {
        String jad_bo;
        synchronized (ANEProxy.class) {
            jad_bo = ANE.jad_bo(str);
        }
        return jad_bo;
    }
}
