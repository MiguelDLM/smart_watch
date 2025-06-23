package com.baidu.mshield.x0.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mshield.x0.EngineImpl;

/* loaded from: classes7.dex */
public final class g {
    public static String a(Context context) {
        try {
            com.baidu.mshield.x0.j.c cVar = new com.baidu.mshield.x0.j.c(context);
            String d = cVar.d();
            if (!TextUtils.isEmpty(d)) {
                return d;
            }
            if (Build.VERSION.SDK_INT > 25) {
                return "";
            }
            String b = b(context);
            if (TextUtils.isEmpty("") && TextUtils.isEmpty(b)) {
                return "";
            }
            byte[] bytes = (":" + b).getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] ^ 246);
            }
            String b2 = com.baidu.mshield.b.f.e.b(bytes);
            if (TextUtils.isEmpty(b2)) {
                return "";
            }
            cVar.c(b2);
            return b2;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String b(Context context) {
        return EngineImpl.getInstance(context).getPropertyByType("arid");
    }
}
