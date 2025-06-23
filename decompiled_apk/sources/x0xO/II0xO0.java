package x0xO;

import android.webkit.WebView;

/* loaded from: classes9.dex */
public class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f34051I0Io = "yy://return/_fetchQueue/";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f34052II0XooXoX = "javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f34053II0xO0 = "yy://return/";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f34054Oxx0IOOO = "JAVA_CB_%s";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f34055X0o0xo = "_";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f34056XO = "/";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f34057oIX0oI = "yy://";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f34058oxoX = "";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f34059xoIox = "javascript:";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f34060xxIXOIIO = "javascript:WebViewJavascriptBridge._fetchQueue();";

    public static String I0Io(String str) {
        String[] split = str.replace(f34053II0xO0, "").split("/");
        if (split.length >= 1) {
            return split[0];
        }
        return null;
    }

    public static String II0xO0(String str) {
        if (str.startsWith(f34051I0Io)) {
            return str.replace(f34051I0Io, "");
        }
        String[] split = str.replace(f34053II0xO0, "").split("/");
        if (split.length >= 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < split.length; i++) {
                sb.append(split[i]);
            }
            return sb.toString();
        }
        return null;
    }

    public static void X0o0xo(WebView webView, String str) {
        webView.loadUrl(f34059xoIox + (("var newscript = document.createElement(\"script\");newscript.src=\"" + str + "\";") + "document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);"));
    }

    public static void XO(WebView webView, String str) {
        webView.loadUrl(f34059xoIox + oIX0oI(webView.getContext(), str));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String oIX0oI(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            java.io.InputStream r4 = r4.open(r5)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
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
            goto L4c
        L2d:
            r5 = move-exception
            goto L43
        L2f:
            if (r2 != 0) goto L18
            r5.close()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            r4.close()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            r4.close()     // Catch: java.io.IOException -> L3e
        L3e:
            return r5
        L3f:
            r5 = move-exception
            goto L4c
        L41:
            r5 = move-exception
            r4 = r0
        L43:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L4b
            r4.close()     // Catch: java.io.IOException -> L4b
        L4b:
            return r0
        L4c:
            if (r0 == 0) goto L51
            r0.close()     // Catch: java.io.IOException -> L51
        L51:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: x0xO.II0xO0.oIX0oI(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String oxoX(String str) {
        return str.replace("javascript:WebViewJavascriptBridge.", "").replaceAll("\\(.*\\);", "");
    }
}
