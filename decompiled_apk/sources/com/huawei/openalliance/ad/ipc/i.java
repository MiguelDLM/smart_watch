package com.huawei.openalliance.ad.ipc;

import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.utils.aa;

/* loaded from: classes10.dex */
public abstract class i {
    private static final String Code = "RemoteCallUtil";

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T Code(String str, Class<T> cls) {
        if (cls == null || cls == String.class) {
            return str;
        }
        if (!cls.isPrimitive()) {
            return (T) aa.V(str, cls, new Class[0]);
        }
        String str2 = "Response type: " + cls + " not supported!";
        fb.I(Code, str2);
        throw new IllegalArgumentException(str2);
    }
}
