package x0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.octopus.ad.internal.utilities.oIX0oI;
import com.octopus.ad.internal.xoIox;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public class oxXx0IX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33766oIX0oI = "Set-cookie";

    public static String I0Io() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            String cookie = cookieManager.getCookie(xoIox.oIX0oI().Oxx0xo());
            if (!TextUtils.isEmpty(cookie)) {
                for (String str : cookie.split("; ")) {
                    if (str != null && str.contains("sdkuid")) {
                        return str;
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static String II0xO0() {
        return null;
    }

    public static void X0o0xo(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebView.class.getDeclaredMethod("onResume", null).invoke(webView, null);
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static void XO(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.getSettings().setBuiltInZoomControls(false);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setMixedContentMode(0);
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            webView.getSettings().setAllowFileAccess(false);
            webView.getSettings().setAllowContentAccess(false);
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setAllowFileAccessFromFileURLs(false);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                cookieManager.setAcceptThirdPartyCookies(webView, true);
            } else {
                oIX0oI.II0xO0(oIX0oI.f18685II0xO0, "Failed to set Webview to accept 3rd party cookie");
            }
            webView.getSettings().setAppCachePath(webView.getContext().getCacheDir().getAbsolutePath());
            webView.getSettings().setAppCacheEnabled(true);
            webView.getSettings().setCacheMode(-1);
            WebView.setWebContentsDebuggingEnabled(false);
        } catch (Exception e) {
            oIX0oI.oxoX(oIX0oI.f18697XO, "Unable update webview settings - Exception: " + e.getMessage());
        }
    }

    public static void oIX0oI(Map<String, List<String>> map) {
        if (map != null && !map.isEmpty()) {
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager == null) {
                oIX0oI.IIXOooo(oIX0oI.f18697XO, "Unable to find a CookieManager");
                return;
            }
            try {
                String I0Io2 = I0Io();
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null && key.equalsIgnoreCase(f33766oIX0oI)) {
                        for (String str : entry.getValue()) {
                            if (!TextUtils.isEmpty(str) && str.contains("sdkuid") && (I0Io2 == null || !str.contains(I0Io2))) {
                                cookieManager.setCookie(xoIox.oIX0oI().Oxx0xo(), str);
                                cookieManager.flush();
                            }
                        }
                    }
                }
            } catch (IllegalStateException | Exception unused) {
            }
        }
    }

    public static void oxoX(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebView.class.getDeclaredMethod("onPause", null).invoke(webView, null);
        } catch (Exception unused) {
        }
    }
}
