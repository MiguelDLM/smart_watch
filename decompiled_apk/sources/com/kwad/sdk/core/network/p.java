package com.kwad.sdk.core.network;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/* loaded from: classes11.dex */
public final class p {
    private static String axD = "";
    private static String axE = "";

    public static String Ey() {
        try {
            if (!TextUtils.isEmpty(axD)) {
                return axD;
            }
            String property = System.getProperty("http.agent");
            axD = property;
            if (TextUtils.isEmpty(property)) {
                return axD;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = axD.length();
            for (int i = 0; i < length; i++) {
                char charAt = axD.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            String stringBuffer2 = stringBuffer.toString();
            axD = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String Ez() {
        String cs;
        if (!TextUtils.isEmpty(axE)) {
            return axE;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            cs = y.cs(context);
            axE = cs;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(cs)) {
            return axE;
        }
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        axE = defaultUserAgent;
        String encode = URLEncoder.encode(defaultUserAgent, "UTF-8");
        axE = encode;
        y.aj(context, encode);
        return axE;
    }

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", Ez());
        httpURLConnection.setRequestProperty("SystemUa", Ey());
    }

    public static String getDefaultUserAgent() {
        return Ey() + "-ksad-android-3.3.63";
    }

    public static String getUserAgent() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getUserAgent();
    }
}
