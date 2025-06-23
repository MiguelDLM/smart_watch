package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IOfflineAuthenticator;

/* loaded from: classes7.dex */
public class bx implements IOfflineAuthenticator {
    private static volatile bx ln;

    private bx() {
    }

    public static bx cm() {
        if (ln == null) {
            ln = new bx();
        }
        return ln;
    }

    @Override // com.baidu.ar.auth.IOfflineAuthenticator
    public boolean checkLicense(Context context, byte[] bArr) {
        fn.load(context, null);
        return ARAuth.checkOfflineLicenseAuth(context, bArr);
    }
}
