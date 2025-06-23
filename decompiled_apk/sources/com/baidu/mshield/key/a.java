package com.baidu.mshield.key;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mshield.b.f.b;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.utility.d;
import com.sma.smartv3.network.BaiDu;
import java.security.PublicKey;
import org.apache.commons.lang3.xXOx;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    public static boolean a(Context context) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put("pkg", packageName);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                packageInfo = null;
            }
            if (packageInfo != null) {
                PublicKey a2 = b.a(packageInfo.applicationInfo.sourceDir);
                if (a2 == null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
                    try {
                        a2 = b.a(signature);
                    } catch (Throwable th2) {
                        com.baidu.mshield.utility.a.a(th2);
                    }
                }
                if (a2 != null) {
                    byte[] encoded = a2.getEncoded();
                    if (encoded != null) {
                        com.baidu.mshield.utility.a.a(context, encoded);
                        jSONObject.put(HttpConstants.SIGN, e.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace(xXOx.f32950X0o0xo, "")));
                    }
                } else {
                    jSONObject.put(HttpConstants.SIGN, "");
                }
                jSONObject.put("app", packageName);
            } else {
                jSONObject.put(HttpConstants.SIGN, "");
                jSONObject.put("app", "");
            }
            String a3 = d.a(context, com.baidu.mshield.utility.a.a(context) + "p/1/auh", jSONObject.toString(), false, true);
            com.baidu.mshield.b.c.a.b("auh res:" + a3);
            JSONObject jSONObject2 = new JSONObject(a3);
            if (jSONObject2.length() <= 0 || jSONObject2.optInt("code") != 200) {
                return false;
            }
            String optString = jSONObject2.optString(BaiDu.AK_SERVICE_KEY);
            String optString2 = jSONObject2.optString("sk");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return false;
            }
            com.baidu.mshield.utility.a.a(optString, optString2);
            com.baidu.mshield.sharedpreferences.a.a(context).a(optString, optString2);
            return true;
        } catch (Throwable th3) {
            com.baidu.mshield.utility.a.a(th3);
            return false;
        }
    }
}
