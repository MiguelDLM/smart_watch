package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes13.dex */
public class g implements IDownloadHttpService {

    /* renamed from: a, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.i.h<String, OkHttpClient> f26376a = new com.ss.android.socialbase.downloader.i.h<>(4, 8);

    private OkHttpClient a(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.f26376a) {
                    try {
                        OkHttpClient okHttpClient = this.f26376a.get(str3);
                        if (okHttpClient != null) {
                            return okHttpClient;
                        }
                        OkHttpClient.Builder u = com.ss.android.socialbase.downloader.downloader.c.u();
                        u.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.g.2
                        });
                        OkHttpClient build = u.build();
                        synchronized (this.f26376a) {
                            this.f26376a.put(str3, build);
                        }
                        return build;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return com.ss.android.socialbase.downloader.downloader.c.s();
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public com.ss.android.socialbase.downloader.network.i downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        String str2;
        OkHttpClient s;
        final InputStream inputStream;
        Request.Builder url = new Request.Builder().url(str);
        if (list != null && list.size() > 0) {
            str2 = null;
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                String a2 = cVar.a();
                if (str2 == null && "ss_d_request_host_ip_114".equals(a2)) {
                    str2 = cVar.b();
                } else {
                    url.addHeader(a2, com.ss.android.socialbase.downloader.i.f.g(cVar.b()));
                }
            }
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            s = a(str, str2);
        } else {
            s = com.ss.android.socialbase.downloader.downloader.c.s();
        }
        if (s != null) {
            final Call newCall = s.newCall(url.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                final ResponseBody body = execute.body();
                if (body == null) {
                    return null;
                }
                InputStream byteStream = body.byteStream();
                String header = execute.header("Content-Encoding");
                if (header != null && "gzip".equalsIgnoreCase(header) && !(byteStream instanceof GZIPInputStream)) {
                    inputStream = new GZIPInputStream(byteStream);
                } else {
                    inputStream = byteStream;
                }
                return new com.ss.android.socialbase.downloader.network.e() { // from class: com.ss.android.socialbase.downloader.impls.g.1
                    @Override // com.ss.android.socialbase.downloader.network.i
                    public InputStream a() throws IOException {
                        return inputStream;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public int b() throws IOException {
                        return execute.code();
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public void c() {
                        Call call = newCall;
                        if (call != null && !call.isCanceled()) {
                            newCall.cancel();
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.i
                    public void d() {
                        try {
                            ResponseBody responseBody = body;
                            if (responseBody != null) {
                                responseBody.close();
                            }
                            Call call = newCall;
                            if (call != null && !call.isCanceled()) {
                                newCall.cancel();
                            }
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.a
                    public String e() {
                        return "";
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public String a(String str3) {
                        return execute.header(str3);
                    }
                };
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
