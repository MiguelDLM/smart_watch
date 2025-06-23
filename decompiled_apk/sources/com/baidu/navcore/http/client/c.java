package com.baidu.navcore.http.client;

import com.baidu.navcore.http.d;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes7.dex */
public class c {
    public void a(String str, d dVar, com.baidu.navcore.http.handler.a aVar) {
        a(str, "GET", dVar, aVar);
    }

    public void b(String str, d dVar, com.baidu.navcore.http.handler.a aVar) {
        a(str, "POST", dVar, aVar);
    }

    public void a(String str, String str2, d dVar, com.baidu.navcore.http.handler.a aVar) {
        URL url;
        try {
            if ("GET".equals(str2)) {
                url = new URL(a(str, dVar));
            } else {
                if (dVar.a() != null) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, d.a> entry : dVar.a().entrySet()) {
                        if (entry.getValue().f6460a != null) {
                            hashMap.put(entry.getKey(), entry.getValue().f6460a.getPath());
                        }
                    }
                    String a2 = a.a(str, dVar.d(), hashMap);
                    aVar.a(true);
                    aVar.b(200, a2.getBytes());
                    return;
                }
                url = new URL(str);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            if ("POST".equals(str2)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.connect();
            if ("POST".equals(str2)) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(dVar.b().trim().getBytes());
                outputStream.flush();
                outputStream.close();
            }
            aVar.a(true);
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
        } catch (Throwable th) {
            aVar.b(-1, null, th);
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
