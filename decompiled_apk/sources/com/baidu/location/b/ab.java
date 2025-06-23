package com.baidu.location.b;

import android.text.TextUtils;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes7.dex */
public class ab {

    /* renamed from: a, reason: collision with root package name */
    private OkHttpClient f5610a;
    private String b = null;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str);

        void b(int i, String str);
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final ab f5611a = new ab();
    }

    public ab() {
        b();
    }

    public static ab a() {
        return b.f5611a;
    }

    private synchronized void b() {
        try {
            if (this.f5610a == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                try {
                    String str = com.baidu.location.e.o.aY;
                    int i = com.baidu.location.e.o.aZ;
                    if (!TextUtils.isEmpty(str) && i != -1) {
                        builder.proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(str, i)));
                        String str2 = com.baidu.location.e.o.ba;
                        String str3 = com.baidu.location.e.o.bb;
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            builder.authenticator(new ac(this, str2, str3));
                        }
                    }
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    this.f5610a = builder.connectTimeout(12000L, timeUnit).readTimeout(12000L, timeUnit).writeTimeout(12000L, timeUnit).build();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private Request.Builder c() {
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        String str = com.baidu.location.e.o.aw;
        if (str != null) {
            builder.addHeader("bd-loc-android", str);
        }
        return builder;
    }

    private synchronized RequestBody a(Map<String, Object> map) {
        StringBuilder sb;
        try {
            sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable th) {
            throw th;
        }
        return RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), sb.toString());
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(Map<String, Object> map, String str, a aVar) {
        try {
            RequestBody a2 = a(map);
            Request.Builder c = c();
            String str2 = this.b;
            if (str2 != null) {
                c.addHeader("alwd", str2);
            }
            Response execute = this.f5610a.newCall(c.url(str).post(a2).build()).execute();
            if (!execute.isSuccessful()) {
                aVar.b(execute.code(), execute.message());
            } else if (execute.body() != null) {
                aVar.a(200, execute.body().string());
            } else {
                aVar.b(400, execute.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (aVar != null) {
                aVar.b(-100, "e=" + e.getMessage());
            }
        }
    }
}
