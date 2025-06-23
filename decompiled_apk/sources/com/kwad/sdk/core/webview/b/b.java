package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.q;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.b.a.b> aFC = new ConcurrentHashMap();
    private static final Map<String, String> aFD = new ConcurrentHashMap();

    @Nullable
    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.g.a.b bVar, b.a aVar, boolean z) {
        com.kwad.sdk.core.webview.b.a.b bVar2;
        try {
            bVar2 = a(context, bVar, str, aVar);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e);
            bVar2 = null;
        }
        if (bVar2 == null) {
            b(z, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        }
        if (TextUtils.isEmpty(bVar2.aFK)) {
            b(z, "getResource [" + str + "] getFilePath from url fail");
            aVar.msg = "getFilePath from url fail";
            return null;
        }
        if (!com.kwad.sdk.core.webview.b.c.c.fh(bVar2.aFG)) {
            b(z, "mimetype为: " + bVar2.aFG + "不在拦截范围的文件");
            aVar.msg = "mimetype为: " + bVar2.aFG + "不在拦截范围的文件";
            return null;
        }
        BufferedInputStream gA = q.gA(bVar2.aFK);
        if (gA == null) {
            b(z, "getResource [" + str + "] inputStream is null");
            StringBuilder sb = new StringBuilder("inputStream is null,本地加载路径：");
            sb.append(bVar2.aFK);
            aVar.msg = sb.toString();
            return null;
        }
        return a(gA, bVar2);
    }

    private static String ac(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    private static void ad(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            aFD.put(str, str2);
        }
    }

    private static void b(boolean z, String str) {
        if (z) {
            return;
        }
        c.d("HybridResourceManager", str);
    }

    private static com.kwad.sdk.core.webview.b.a.b eZ(String str) {
        return aFC.get(String.valueOf(str.hashCode()));
    }

    private static String fa(String str) {
        return aFD.get(str);
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.b.a.b bVar) {
        String str = bVar.aFG;
        HashMap hashMap = new HashMap();
        hashMap.put("Access-Control-Allow-Origin", bVar.aFJ.aFE);
        hashMap.put("Access-Control-Allow-Credentials", "true");
        hashMap.put("Timing-Allow-Origin", bVar.aFJ.aFF);
        hashMap.put("content-type", str);
        hashMap.put("Date", bVar.aFJ.aFH);
        hashMap.put("union-cache ", "1");
        return new WebResourceResponse(bVar.aFG, "", bVar.status, "OK", hashMap, inputStream);
    }

    private static com.kwad.sdk.core.webview.b.a.b a(Context context, com.kwad.sdk.g.a.b bVar, String str, b.a aVar) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String fa = fa(bVar.aJm);
            com.kwad.sdk.core.webview.b.a.b eZ = !TextUtils.isEmpty(fa) ? eZ(ac(fa, str)) : null;
            if (eZ != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return eZ;
            }
            String J = com.kwad.sdk.core.webview.b.c.a.J(context, bVar.aJn);
            if (J == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(J);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 " + J;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
                try {
                    String b = h.b(inputStreamReader);
                    if (TextUtils.isEmpty(b)) {
                        aVar.msg = "获取配置文件失败 mainfest文件不存在";
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(b);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        com.kwad.sdk.core.webview.b.a.b bVar2 = new com.kwad.sdk.core.webview.b.a.b();
                        bVar2.parseJson(jSONObject2);
                        String host = Uri.parse(BNWebViewClient.URL_HTTPS_PREFIX + next).getHost();
                        bVar2.aFL = host;
                        bVar2.aFK = com.kwad.sdk.core.webview.b.c.a.I(context, bVar.aJn) + "/" + next;
                        if (TextUtils.isEmpty(bVar2.aFG)) {
                            bVar2.aFG = URLConnection.getFileNameMap().getContentTypeFor(bVar2.aFK);
                        }
                        a(next, bVar2);
                        fa = host;
                    }
                    ad(bVar.aJm, fa);
                    com.kwad.sdk.core.webview.b.a.b eZ2 = eZ(ac(fa, str));
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return eZ2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.b.a.b bVar) {
        aFC.put(String.valueOf(str.hashCode()), bVar);
    }
}
