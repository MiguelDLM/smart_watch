package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* loaded from: classes11.dex */
public class p {
    private static String aPO = "";
    private static String aPP = "";
    private static String aPQ = "";

    private static String a(String str, InputStream inputStream) {
        String gw;
        synchronized (p.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.KP();
            gw = oVar.KO().gw(str);
            oVar.end();
        }
        return gw;
    }

    public static String dY(int i) {
        InputStream inputStream;
        Context Lw = ServiceProvider.Lw();
        String str = aPO;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty("aes_key")) {
            Log.e("EncryptUtils", "EncryptUtils getKey get id is error ");
        }
        try {
            try {
                inputStream = Lw.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th) {
                Log.e("EncryptUtils", "EncryptUtils getKey get InputStream from loader is null,  e: " + th);
                inputStream = null;
            }
            if (inputStream == null) {
                inputStream = Lw.getAssets().open("ksad_common_encrypt_image.png");
            }
            String a2 = a("aes_key", inputStream);
            if (TextUtils.isEmpty(a2)) {
                Log.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
            }
            aPO = a2;
            return a2;
        } catch (Throwable unused) {
            return "";
        }
    }
}
