package com.baidu.navisdk.util.http.center;

import android.os.Looper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* loaded from: classes8.dex */
public class g {
    public static void a() {
        if (b()) {
            throw new RuntimeException("Expected to run on UI thread!");
        }
    }

    public static boolean b() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public static String a(List<? extends l> list) {
        StringBuilder sb = new StringBuilder();
        for (l lVar : list) {
            String a2 = a(lVar.a());
            String b = lVar.b();
            String a3 = b != null ? a(b) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(a2);
            sb.append("=");
            sb.append(a3);
        }
        return sb.toString();
    }

    private static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
