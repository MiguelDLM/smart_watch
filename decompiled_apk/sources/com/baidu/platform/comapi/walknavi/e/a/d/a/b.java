package com.baidu.platform.comapi.walknavi.e.a.d.a;

import com.baidu.platform.comapi.walknavi.e.a.d.a.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes8.dex */
public class b {
    public static boolean a(String str, File file, c.b bVar) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                inputStream = httpURLConnection.getInputStream();
                c.a(inputStream, file, httpURLConnection.getContentLength(), bVar);
                c.a(inputStream);
                a(httpURLConnection);
                return true;
            } catch (IOException unused) {
                c.a(inputStream);
                a(httpURLConnection);
                return false;
            } catch (Throwable th) {
                th = th;
                c.a(inputStream);
                a(httpURLConnection);
                throw th;
            }
        } catch (IOException unused2) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    private static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
