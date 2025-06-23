package com.baidu.ar;

import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.auth.IOfflineAuthenticator;

/* loaded from: classes7.dex */
public class bt {
    public static IAuthenticator getAsyncAuthenticator(String str, String str2, String str3) {
        return bv.b(str, str2, str3);
    }

    public static IAuthenticator getAuthenticator() {
        return bw.cl();
    }

    public static IOfflineAuthenticator getOfflineAuthenticator() {
        return bx.cm();
    }
}
