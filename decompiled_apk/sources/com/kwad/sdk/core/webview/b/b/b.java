package com.kwad.sdk.core.webview.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.q;
import java.io.File;

/* loaded from: classes11.dex */
public final class b {
    public static synchronized boolean a(Context context, com.kwad.sdk.g.a.b bVar) {
        synchronized (b.class) {
            try {
                String str = bVar.aJo;
                File file = new File(str);
                if (!q.L(file)) {
                    return false;
                }
                if (!TextUtils.isEmpty(bVar.akB)) {
                    String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
                    if (fileMD5 != null && fileMD5.length() > 10) {
                        fileMD5 = fileMD5.substring(0, 10);
                    }
                    if (!bh.isEquals(fileMD5, bVar.akB)) {
                        q.aa(file);
                        return false;
                    }
                }
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 2);
                try {
                    com.kwad.sdk.core.webview.b.c.a.f(context, str, com.kwad.sdk.core.webview.b.c.a.G(context, bVar.aJn));
                    q.aa(file);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 2, e.getMessage());
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
