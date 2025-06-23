package com.baidu.navcore.http.client;

import com.baidu.navcore.http.d;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes7.dex */
public class b {

    /* loaded from: classes7.dex */
    public class a extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6457a;
        final /* synthetic */ d b;
        final /* synthetic */ com.baidu.navcore.http.handler.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, String str3, d dVar, com.baidu.navcore.http.handler.a aVar) {
            super(str, str2);
            this.f6457a = str3;
            this.b = dVar;
            this.c = aVar;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.a(this.f6457a, "GET", this.b, this.c);
            return null;
        }
    }

    /* renamed from: com.baidu.navcore.http.client.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0150b extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6458a;
        final /* synthetic */ d b;
        final /* synthetic */ com.baidu.navcore.http.handler.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0150b(String str, String str2, String str3, d dVar, com.baidu.navcore.http.handler.a aVar) {
            super(str, str2);
            this.f6458a = str3;
            this.b = dVar;
            this.c = aVar;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.a(this.f6458a, "POST", this.b, this.c);
            return null;
        }
    }

    public void a(String str, d dVar, com.baidu.navcore.http.handler.a aVar) {
        com.baidu.navisdk.util.worker.c.a().c(new a("NavAsyncHttpClient", null, str, dVar, aVar), new e(203, 0));
    }

    public void b(String str, d dVar, com.baidu.navcore.http.handler.a aVar) {
        com.baidu.navisdk.util.worker.c.a().c(new C0150b("NavAsyncHttpClient", null, str, dVar, aVar), new e(203, 0));
    }

    public void a(String str, String str2, d dVar, com.baidu.navcore.http.handler.a aVar) {
        URL url;
        try {
            if ("GET".equals(str2)) {
                url = new URL(a(str, dVar));
            } else {
                url = new URL(str);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.connect();
            if ("POST".equals(str2)) {
                httpURLConnection.getOutputStream().write(dVar.b().trim().getBytes());
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 300) {
                InputStream inputStream = httpURLConnection.getInputStream();
                com.baidu.navcore.http.a aVar2 = new com.baidu.navcore.http.a(httpURLConnection.getContent().toString().length());
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        aVar2.a(bArr, 0, read);
                    }
                }
                aVar.b(responseCode, aVar2.a());
                inputStream.close();
            } else {
                aVar.b(responseCode, null, null);
            }
            httpURLConnection.disconnect();
        } catch (IOException e) {
            aVar.b(-1, null, e);
        }
    }

    private String a(String str, d dVar) {
        if (str == null) {
            return null;
        }
        if (dVar == null) {
            return str;
        }
        String trim = dVar.b().trim();
        if ("".equals(trim)) {
            return str;
        }
        String str2 = LocationInfo.NA;
        if (LocationInfo.NA.equals(trim)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.contains(LocationInfo.NA)) {
            str2 = "&";
        }
        sb.append(str2);
        return sb.toString() + trim;
    }
}
