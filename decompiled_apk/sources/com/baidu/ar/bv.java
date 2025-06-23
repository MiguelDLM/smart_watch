package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.AuthJni;
import com.baidu.ar.auth.IAuthenticateCallback;
import com.baidu.ar.auth.IAuthenticator;

/* loaded from: classes7.dex */
public class bv implements IAuthenticator {
    private static volatile bv lg;
    private String ld;
    private String le;
    private kh lf;
    private String mSecretKey;

    private bv(String str, String str2, String str3) {
        this.ld = str;
        this.le = str2;
        this.mSecretKey = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, byte[] bArr, IAuthenticateCallback iAuthenticateCallback) {
        bw.cl().init(context, bArr, iAuthenticateCallback);
    }

    public static bv b(String str, String str2, String str3) {
        if (lg == null) {
            lg = new bv(str, str2, str3);
        } else {
            lg.ld = str;
            lg.le = str2;
            lg.mSecretKey = str3;
        }
        return lg;
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
    public void init(final Context context, final byte[] bArr, final IAuthenticateCallback iAuthenticateCallback) {
        fn.load(context, null);
        ARAuth.setAuthLicense(bArr, this.ld, this.le, this.mSecretKey);
        if (this.lf == null) {
            kh khVar = new kh("AsyncAuthenticator");
            this.lf = khVar;
            khVar.start();
        }
        AuthJni.init();
        this.lf.execute(new Runnable() { // from class: com.baidu.ar.bv.1
            @Override // java.lang.Runnable
            public void run() {
                bv.this.a(context, bArr, iAuthenticateCallback);
            }
        });
    }
}
