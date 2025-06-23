package com.baidu.mshield.x0.g;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.b.d;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c extends com.baidu.mshield.b.d.a {
    public b c;

    public c(Context context, Handler handler) {
        super(context, handler);
        this.b = context;
        this.c = b.a(context);
    }

    public boolean a(String str) {
        com.baidu.mshield.b.c.a.b("j=" + str);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            byte[] a2 = d.a();
            String b = this.c.b(URLEncoder.encode(Base64.encodeToString(com.baidu.mshield.b.f.d.c(a2, e.a(com.baidu.mshield.utility.c.a(this.b)).getBytes()), 0)));
            byte[] a3 = this.c.a(a2, str);
            if (a3 == null) {
                return true;
            }
            try {
                String a4 = a(b, a3);
                if (TextUtils.isEmpty(a4)) {
                    return false;
                }
                try {
                    new JSONObject(a4).getInt("response");
                    return true;
                } catch (Throwable th) {
                    d.a(th);
                    return true;
                }
            } catch (Throwable th2) {
                d.a(th2);
                return false;
            }
        } catch (Throwable th3) {
            d.a(th3);
            return true;
        }
    }
}
