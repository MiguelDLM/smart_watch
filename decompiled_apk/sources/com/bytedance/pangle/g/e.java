package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;

/* loaded from: classes8.dex */
public final class e {
    public static boolean a(String str, String str2) {
        o a2;
        Signature[] signatureArr;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (com.bytedance.pangle.util.i.a()) {
                a2 = d.a(str);
            } else {
                a2 = a.a(str);
            }
            if (a2 != null) {
                signatureArr = a2.b;
            } else {
                signatureArr = null;
            }
            byte[] decode = Base64.decode(Zeus.getPlugin(str2).mSignature, 0);
            if (decode != null && decode.length != 0) {
                int i = 0;
                for (Signature signature : signatureArr) {
                    i += signature.toByteArray().length;
                }
                byte[] bArr = new byte[i];
                int i2 = 0;
                for (Signature signature2 : signatureArr) {
                    System.arraycopy(signature2.toByteArray(), 0, bArr, i2, signature2.toByteArray().length);
                    i2 += signature2.toByteArray().length;
                }
                boolean a3 = o.a(bArr, decode);
                if (!a3) {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
                }
                return a3;
            }
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
            return false;
        } catch (q e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e);
            return false;
        }
    }
}
