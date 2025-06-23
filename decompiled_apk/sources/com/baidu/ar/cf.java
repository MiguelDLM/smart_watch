package com.baidu.ar;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
final class cf {
    private static final List<cf> mi = new ArrayList();
    Object mj;
    cj mk;
    cf ml;

    public static void b(cf cfVar) {
        cfVar.mj = null;
        cfVar.mk = null;
        cfVar.ml = null;
        List<cf> list = mi;
        synchronized (list) {
            try {
                if (list.size() < 20) {
                    list.add(cfVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
