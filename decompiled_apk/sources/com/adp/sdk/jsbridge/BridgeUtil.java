package com.adp.sdk.jsbridge;

import android.webkit.WebView;

/* loaded from: classes.dex */
class BridgeUtil {
    public static final String CALLBACK_ID_FORMAT = "JAVA_CB_%s";
    public static final String JAVASCRIPT_STR = "javascript:%s";
    public static final String JAVA_SCRIPT = "WebViewJavascriptBridge.js";
    public static final String JS_HANDLE_MESSAGE_FROM_JAVA = "javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');";
    public static final String UNDERLINE_STR = "_";

    /* JADX WARN: Removed duplicated region for block: B:41:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String assetFile2Str(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            java.io.InputStream r4 = r4.open(r5)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            r1.<init>()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
        L18:
            java.lang.String r2 = r5.readLine()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            if (r2 == 0) goto L2f
            java.lang.String r3 = "^\\s*\\/\\/.*"
            boolean r3 = r2.matches(r3)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            if (r3 != 0) goto L2f
            r1.append(r2)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            goto L2f
        L2a:
            r5 = move-exception
            r0 = r4
            goto L56
        L2d:
            r5 = move-exception
            goto L48
        L2f:
            if (r2 != 0) goto L18
            r5.close()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            r4.close()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            r4.close()     // Catch: java.io.IOException -> L3f
            goto L43
        L3f:
            r4 = move-exception
            r4.printStackTrace()
        L43:
            return r5
        L44:
            r5 = move-exception
            goto L56
        L46:
            r5 = move-exception
            r4 = r0
        L48:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L55
            r4.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r4 = move-exception
            r4.printStackTrace()
        L55:
            return r0
        L56:
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r4 = move-exception
            r4.printStackTrace()
        L60:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.jsbridge.BridgeUtil.assetFile2Str(android.content.Context, java.lang.String):java.lang.String");
    }

    public static void webViewLoadJs(WebView webView, String str) {
        webView.loadUrl(x0xO.II0xO0.f34059xoIox + (("var newscript = document.createElement(\"script\");newscript.src=\"" + str + "\";") + "document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);"));
    }

    public static void webViewLoadLocalJs(WebView webView, String str) {
        webView.loadUrl(x0xO.II0xO0.f34059xoIox + assetFile2Str(webView.getContext(), str));
    }
}
