package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes7.dex */
public class cs {

    /* renamed from: a, reason: collision with root package name */
    private static volatile cs f6293a;
    private boolean b;
    private boolean c;

    private cs() {
    }

    public static cs a() {
        if (f6293a == null) {
            synchronized (cs.class) {
                try {
                    if (f6293a == null) {
                        f6293a = new cs();
                    }
                } finally {
                }
            }
        }
        return f6293a;
    }

    public boolean b() {
        return this.c;
    }

    public String c(String str) {
        if (this.b && a(str).booleanValue()) {
            return str.replaceFirst("(?i)http", "https");
        }
        return str;
    }

    public Boolean d(String str) {
        boolean z;
        if (!a(str, "sms:").booleanValue() && !a(str, "smsto:").booleanValue() && !a(str, "mms:").booleanValue()) {
            z = false;
        } else {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public String e(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    public boolean f(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("/thefatherofsalmon.com")) {
            return false;
        }
        return true;
    }

    public String g(String str) {
        if (str == null) {
            return null;
        }
        if (a(str).booleanValue() || b(str).booleanValue()) {
            return str.split("\\?")[0];
        }
        return str;
    }

    public String h(String str) {
        String[] split;
        if (str == null) {
            return null;
        }
        if (!a(str).booleanValue() && !b(str).booleanValue()) {
            split = null;
        } else {
            split = str.split("\\?");
        }
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public void i(String str) {
        new an(str).b();
    }

    public void b(boolean z) {
        this.b = z;
    }

    public Boolean b(String str) {
        return a(str, "https:");
    }

    public void a(boolean z) {
        this.c = z;
    }

    public Boolean a(String str) {
        return a(str, "http:");
    }

    private Boolean a(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public HttpURLConnection a(URL url) {
        if (url.getProtocol().toLowerCase().equals("https")) {
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public String a(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            sb.append(LocationInfo.NA);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append("&");
                } catch (Exception e) {
                    bv.a().c(e);
                }
            }
            return sb.toString().substring(0, r3.length() - 1);
        }
        return sb.toString();
    }

    public void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Throwable unused) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (Throwable unused2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
        }
    }
}
