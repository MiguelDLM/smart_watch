package com.adp.sdk.jsbridge;

import android.webkit.WebView;
import x0xO.II0xO0;

class BridgeUtil {
    public static final String CALLBACK_ID_FORMAT = "JAVA_CB_%s";
    public static final String JAVASCRIPT_STR = "javascript:%s";
    public static final String JAVA_SCRIPT = "WebViewJavascriptBridge.js";
    public static final String JS_HANDLE_MESSAGE_FROM_JAVA = "javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');";
    public static final String UNDERLINE_STR = "_";

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d A[SYNTHETIC, Splitter:B:27:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0058 A[SYNTHETIC, Splitter:B:33:0x0058] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String assetFile2Str(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            java.io.InputStream r4 = r4.open(r5)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x002d }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x002d }
            r1.<init>(r4)     // Catch:{ Exception -> 0x002d }
            r5.<init>(r1)     // Catch:{ Exception -> 0x002d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002d }
            r1.<init>()     // Catch:{ Exception -> 0x002d }
        L_0x0018:
            java.lang.String r2 = r5.readLine()     // Catch:{ Exception -> 0x002d }
            if (r2 == 0) goto L_0x002f
            java.lang.String r3 = "^\\s*\\/\\/.*"
            boolean r3 = r2.matches(r3)     // Catch:{ Exception -> 0x002d }
            if (r3 != 0) goto L_0x002f
            r1.append(r2)     // Catch:{ Exception -> 0x002d }
            goto L_0x002f
        L_0x002a:
            r5 = move-exception
            r0 = r4
            goto L_0x0056
        L_0x002d:
            r5 = move-exception
            goto L_0x0048
        L_0x002f:
            if (r2 != 0) goto L_0x0018
            r5.close()     // Catch:{ Exception -> 0x002d }
            r4.close()     // Catch:{ Exception -> 0x002d }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x002d }
            r4.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0043:
            return r5
        L_0x0044:
            r5 = move-exception
            goto L_0x0056
        L_0x0046:
            r5 = move-exception
            r4 = r0
        L_0x0048:
            r5.printStackTrace()     // Catch:{ all -> 0x002a }
            if (r4 == 0) goto L_0x0055
            r4.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0055:
            return r0
        L_0x0056:
            if (r0 == 0) goto L_0x0060
            r0.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0060:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.jsbridge.BridgeUtil.assetFile2Str(android.content.Context, java.lang.String):java.lang.String");
    }

    public static void webViewLoadJs(WebView webView, String str) {
        webView.loadUrl(II0xO0.f35433xoIox + (("var newscript = document.createElement(\"script\");" + "newscript.src=\"" + str + "\";") + "document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);"));
    }

    public static void webViewLoadLocalJs(WebView webView, String str) {
        String assetFile2Str = assetFile2Str(webView.getContext(), str);
        webView.loadUrl(II0xO0.f35433xoIox + assetFile2Str);
    }
}
