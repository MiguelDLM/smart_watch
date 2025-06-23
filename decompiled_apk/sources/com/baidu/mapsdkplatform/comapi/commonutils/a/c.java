package com.baidu.mapsdkplatform.comapi.commonutils.a;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes7.dex */
public class c {
    private InterfaceC0139c d;
    private int b = 1;
    private List<com.baidu.mapsdkplatform.comapi.commonutils.a.b> c = new LinkedList();

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f6153a = Executors.newCachedThreadPool();

    /* loaded from: classes7.dex */
    public class a implements b {
        private File b;

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.c.b
        public void a(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar) {
            if (c.this.c != null && c.this.c.size() != 0 && bVar != null && bVar.a() && c.this.c != null) {
                c.this.c.remove(bVar);
                if (c.this.c.size() == 0) {
                    c.this.d.a(this.b);
                }
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.c.b
        public void b(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar) {
            if (c.this.c != null && c.this.c.size() != 0 && bVar != null) {
                c.this.c.clear();
                if (c.this.d != null) {
                    c.this.d.a();
                }
            }
        }

        private a(File file) {
            this.b = file;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar);

        void b(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar);
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.commonutils.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0139c {
        void a();

        void a(File file);
    }

    /* loaded from: classes7.dex */
    public static class d implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    public void a(String str, String str2, String str3, int i, InterfaceC0139c interfaceC0139c) {
        if (i <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        this.b = i;
        this.d = interfaceC0139c;
        a(str, str2, str3);
    }

    private void a(String str, String str2, String str3) {
        String headerField;
        File file = new File(str2);
        if (file.exists() || file.mkdirs()) {
            HttpURLConnection a2 = a(str);
            if (a2 != null) {
                try {
                    if (a2.getResponseCode() == 200) {
                        int contentLength = a2.getContentLength();
                        if (contentLength > 0) {
                            if (str3 == null && ((headerField = a2.getHeaderField("Content-Disposition")) == null || headerField.length() == 0 || (str3 = URLDecoder.decode(headerField.substring(headerField.indexOf("filename=") + 9), "UTF-8")) == null || str3.length() == 0)) {
                                return;
                            }
                            File file2 = new File(file, str3);
                            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                            randomAccessFile.setLength(contentLength);
                            randomAccessFile.close();
                            a2.disconnect();
                            int i = this.b;
                            int i2 = contentLength % i;
                            int i3 = contentLength / i;
                            if (i2 != 0) {
                                i3++;
                            }
                            a(str, file2, i3, contentLength);
                            return;
                        }
                        throw new RuntimeException("unKnow file length");
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            throw new RuntimeException("server no response.");
        }
    }

    private void a(String str, File file, int i, int i2) {
        if (TextUtils.isEmpty(str) || file == null || i <= 0 || i2 <= 0) {
            return;
        }
        int i3 = 0;
        while (i3 < this.b) {
            int i4 = i3 + 1;
            com.baidu.mapsdkplatform.comapi.commonutils.a.a aVar = new com.baidu.mapsdkplatform.comapi.commonutils.a.a(i3, i3 * i, (i4 * i) - 1);
            if (i3 == this.b - 1) {
                aVar.a(i2);
            }
            com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar = new com.baidu.mapsdkplatform.comapi.commonutils.a.b(str, file, aVar, new a(file));
            List<com.baidu.mapsdkplatform.comapi.commonutils.a.b> list = this.c;
            if (list != null) {
                list.add(bVar);
            }
            ExecutorService executorService = this.f6153a;
            if (executorService != null && !executorService.isShutdown()) {
                this.f6153a.submit(bVar);
            }
            i3 = i4;
        }
    }

    private HttpURLConnection a(String str) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str);
            if (HttpClient.isHttpsEnable) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setHostnameVerifier(new d());
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            return httpURLConnection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
