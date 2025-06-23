package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes8.dex */
public class a4 {
    public static final HostnameVerifier g = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f10033a = true;
    public int b = 5000;
    public String c = null;
    public int d = -1;
    public HttpURLConnection e = null;
    public Map<String, String> f = null;

    /* loaded from: classes8.dex */
    public static class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            try {
                String peerHost = sSLSession.getPeerHost();
                for (X509Certificate x509Certificate : (X509Certificate[]) sSLSession.getPeerCertificates()) {
                    X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                    try {
                        x509Certificate.getSubjectAlternativeNames();
                    } catch (CertificateParsingException e) {
                        e.printStackTrace();
                    }
                    for (String str2 : subjectX500Principal.getName().split(",")) {
                        if (str2.startsWith("CN") && peerHost.equals(str)) {
                            return true;
                        }
                    }
                }
            } catch (SSLPeerUnverifiedException e2) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public final void a(String str, String str2, String str3, i4 i4Var) {
        HttpURLConnection httpURLConnection;
        URL url;
        Map<String, List<String>> map = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                if (!this.f10033a) {
                                    url = new URL(URLDecoder.decode(str, "UTF-8"));
                                } else {
                                    url = new URL(str);
                                }
                                if (url.getProtocol().toLowerCase().equals("https")) {
                                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                                    this.e = httpsURLConnection;
                                    httpsURLConnection.setHostnameVerifier(g);
                                } else {
                                    this.e = (HttpURLConnection) url.openConnection();
                                }
                                Map<String, String> map2 = this.f;
                                if (map2 != null) {
                                    for (String str4 : map2.keySet()) {
                                        this.e.setRequestProperty(str4, this.f.get(str4));
                                    }
                                }
                                if (i4Var instanceof h4) {
                                    ((h4) i4Var).a(this.e);
                                }
                                i4Var.f10110a = URI.create(str);
                                this.e.setRequestMethod(str3);
                                this.e.setConnectTimeout(this.b);
                                this.e.setReadTimeout(this.b);
                                if (str3 == "POST") {
                                    this.e.setDoInput(true);
                                    this.e.setDoOutput(true);
                                    OutputStream outputStream = this.e.getOutputStream();
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                                    bufferedOutputStream.write(str2.getBytes());
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                    outputStream.close();
                                } else {
                                    this.e.setDoInput(true);
                                }
                                this.d = this.e.getResponseCode();
                                LoggerProxy.d("HttpClientUtil", "ResponseCode: " + this.d);
                                this.c = this.e.getContentType();
                                map = this.e.getHeaderFields();
                                d4 d4Var = new d4();
                                d4Var.f10072a = this.e.getContentLength();
                                d4Var.b = this.e.getInputStream();
                                d4Var.c = map;
                                this.e.getContentEncoding();
                                d4Var.e = this.c;
                                d4Var.d = this.d;
                                i4Var.a(d4Var);
                                httpURLConnection = this.e;
                                if (httpURLConnection == null) {
                                    return;
                                }
                            } catch (SocketTimeoutException e) {
                                Map<String, List<String>> map3 = map;
                                if (i4Var != null) {
                                    i4Var.a(this.d, map3, this.c, null, e);
                                }
                                e.printStackTrace();
                                httpURLConnection = this.e;
                                if (httpURLConnection == null) {
                                    return;
                                }
                            }
                        } catch (MalformedURLException e2) {
                            Map<String, List<String>> map4 = map;
                            if (i4Var != null) {
                                i4Var.a(this.d, map4, this.c, null, e2);
                            }
                            e2.printStackTrace();
                            httpURLConnection = this.e;
                            if (httpURLConnection == null) {
                                return;
                            }
                        }
                    } catch (InterruptedIOException e3) {
                        LoggerProxy.d("HttpClientUtil", e3.toString());
                        httpURLConnection = this.e;
                        if (httpURLConnection == null) {
                            return;
                        }
                    }
                } catch (Exception e4) {
                    Map<String, List<String>> map5 = map;
                    if (i4Var != null) {
                        i4Var.a(this.d, map5, this.c, null, e4);
                    }
                    httpURLConnection = this.e;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
            } catch (IOException e5) {
                Map<String, List<String>> map6 = map;
                if (i4Var != null) {
                    i4Var.a(this.d, map6, this.c, null, e5);
                }
                e5.printStackTrace();
                httpURLConnection = this.e;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.e;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }
}
