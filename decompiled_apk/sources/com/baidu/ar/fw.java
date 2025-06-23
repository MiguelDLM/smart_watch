package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class fw {
    private Context mContext;

    public fw(Context context) {
        this.mContext = (Context) new WeakReference(context).get();
    }

    public static void b(String str, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 9002);
        hashMap.put("request_id", str);
        hashMap.put("status", Integer.valueOf(i));
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    public static void n(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 9003);
        hashMap.put("request_id", str);
        hashMap.put("data", str2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    public boolean ek() {
        Context context = this.mContext;
        if (context != null) {
            return kq.p(context);
        }
        return false;
    }

    public void l(HashMap<String, Object> hashMap) {
        String cn;
        String str = (String) hashMap.get("request_id");
        if (TextUtils.isEmpty(str)) {
            kf.cl("requestId can not be null!");
            return;
        }
        String str2 = (String) hashMap.get("request_method");
        String str3 = (String) hashMap.get("url");
        String str4 = (String) hashMap.get("content");
        if (!ek()) {
            b(str, 1);
            return;
        }
        if (str3 == null || !str3.contains(BNWebViewClient.URL_HTTPS_PREFIX)) {
            b(str, 2);
            return;
        }
        if (str2 == null) {
            b(str, 2);
            return;
        }
        if ("get".equals(str2) || "GET".equals(str2)) {
            cn = kn.cn(str3);
        } else {
            if (!"post".equals(str2) && !"POST".equals(str2)) {
                b(str, 2);
                return;
            }
            cn = kn.w(str3, str4);
        }
        n(str, cn);
    }
}
