package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: classes7.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6227a = "OAdURLConnection";
    public static final String b = "POST";
    public static final String c = "GET";
    public static final String d = "application/json";
    public static final String e = "text/plain";
    private HttpURLConnection f;
    private bv g;
    private b h;
    private c i;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private boolean p;
    private Uri.Builder q;

    /* loaded from: classes7.dex */
    public class a extends i {
        public a() {
        }

        @Override // com.baidu.mobads.sdk.internal.i
        public Object i() {
            an.this.e();
            an.this.f();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(String str, int i);

        void a(String str, String str2);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(InputStream inputStream, String str);

        void a(String str, int i);
    }

    public an(String str) {
        this(str, "GET");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!TextUtils.isEmpty(this.j) && cs.a().f(this.j)) {
            try {
                HttpURLConnection a2 = cs.a().a(new URL(this.j));
                this.f = a2;
                a2.setConnectTimeout(this.n);
                if (Integer.parseInt(bn.a((Context) null).b()) < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                this.f.setRequestMethod(this.k);
                this.f.setUseCaches(this.p);
                if (!TextUtils.isEmpty(this.l)) {
                    this.f.setRequestProperty("User-Agent", this.l);
                }
                this.f.setRequestProperty("Content-type", this.m);
                this.f.setRequestProperty("Connection", "keep-alive");
                this.f.setRequestProperty("Cache-Control", "no-cache");
                if (this.k.equals("POST")) {
                    this.f.setDoInput(true);
                    this.f.setDoOutput(true);
                    Uri.Builder builder = this.q;
                    if (builder != null) {
                        a(builder.build().getEncodedQuery(), this.f);
                    }
                }
            } catch (Exception e2) {
                b bVar = this.h;
                if (bVar != null) {
                    bVar.a("Net Create RuntimeError: " + e2.toString(), 0);
                }
                c cVar = this.i;
                if (cVar != null) {
                    cVar.a("Net Create RuntimeError: " + e2.toString(), 0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f.connect();
                this.g.a(f6227a, this.f.getRequestMethod() + " connect code :" + this.f.getResponseCode());
                int responseCode = this.f.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f.setInstanceFollowRedirects(false);
                    HttpURLConnection a2 = a(this.f);
                    this.f = a2;
                    responseCode = a2.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    b bVar = this.h;
                    if (bVar != null) {
                        bVar.a(this.f.getResponseMessage(), responseCode);
                    }
                    c cVar = this.i;
                    if (cVar != null) {
                        cVar.a(this.f.getResponseMessage(), responseCode);
                    }
                } else {
                    String g = cs.a().g(this.j);
                    b bVar2 = this.h;
                    if (bVar2 != null) {
                        bVar2.a(c(), g);
                    }
                    c cVar2 = this.i;
                    if (cVar2 != null) {
                        cVar2.a(this.f.getInputStream(), g);
                    }
                }
                httpURLConnection = this.f;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                b bVar3 = this.h;
                if (bVar3 != null) {
                    bVar3.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                c cVar3 = this.i;
                if (cVar3 != null) {
                    cVar3.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                httpURLConnection = this.f;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public String c() {
        InputStream inputStream = null;
        try {
            inputStream = this.f.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    inputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public void d() {
        HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e2) {
                az.h(f6227a).f(e2.toString());
            }
        }
    }

    public an(String str, String str2) {
        this.g = bv.a();
        this.h = null;
        this.i = null;
        this.m = "text/plain";
        this.n = 10000;
        this.o = 10000;
        this.p = false;
        this.q = null;
        this.j = str;
        this.k = str2;
    }

    public String a() {
        e();
        HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                String c2 = c();
                HttpURLConnection httpURLConnection3 = this.f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return c2;
            } catch (Throwable unused) {
                HttpURLConnection httpURLConnection4 = this.f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    public void b() {
        try {
            be.a().a((i) new a());
        } catch (Exception unused) {
        }
    }

    public void b(int i) {
        this.o = i;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public void a(Map<String, String> map) {
        if (this.f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public void a(c cVar) {
        this.i = cVar;
    }

    public void a(int i) {
        this.n = i;
    }

    public void a(Uri.Builder builder) {
        this.q = builder;
    }

    public void a(String str) {
        this.m = str;
    }
}
