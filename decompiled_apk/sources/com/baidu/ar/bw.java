package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IAuthenticateCallback;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.auth.IDuMixAuthCallback;
import java.util.List;

/* loaded from: classes7.dex */
public class bw implements IAuthenticator {
    private static volatile bw lk;

    private bw() {
    }

    public static bw cl() {
        if (lk == null) {
            lk = new bw();
        }
        return lk;
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void init(Context context, byte[] bArr) {
        init(context, bArr, null);
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void release() {
        ARAuth.release();
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void init(final Context context, byte[] bArr, final IAuthenticateCallback iAuthenticateCallback) {
        fn.load(context, null);
        final List[] listArr = {ARAuth.checkAuth(context, bArr, new IDuMixAuthCallback() { // from class: com.baidu.ar.bw.1
            @Override // com.baidu.ar.auth.IDuMixAuthCallback
            public void onAvailFeaturesUpdate(List<Integer> list) {
                listArr[0] = list;
                IAuthenticateCallback iAuthenticateCallback2 = iAuthenticateCallback;
                if (iAuthenticateCallback2 != null) {
                    iAuthenticateCallback2.onAvailFeaturesChanged(list);
                }
            }

            @Override // com.baidu.ar.auth.IDuMixAuthCallback
            public void onFeatureRejected(int i) {
                IAuthenticateCallback iAuthenticateCallback2 = iAuthenticateCallback;
                if (iAuthenticateCallback2 != null) {
                    iAuthenticateCallback2.onFeatureRejected(i);
                }
            }

            @Override // com.baidu.ar.auth.IDuMixAuthCallback
            public void onResult(boolean z) {
                if (z) {
                    ARAuth.doAuth(context, null);
                } else {
                    listArr[0].clear();
                }
                IAuthenticateCallback iAuthenticateCallback2 = iAuthenticateCallback;
                if (iAuthenticateCallback2 != null) {
                    iAuthenticateCallback2.onResult(z, listArr[0]);
                }
            }
        })};
    }
}
