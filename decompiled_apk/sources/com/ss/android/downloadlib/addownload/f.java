package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadModel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes11.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f26047a;
    private final ConcurrentHashMap<String, String> b;

    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static f f26048a = new f();
    }

    public static f a() {
        return a.f26048a;
    }

    private String c(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.equals("https", scheme) || !lastPathSegment.endsWith(com.huawei.hms.ads.dynamicloader.b.b)) {
                return null;
            }
            this.f26047a.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b(String str) {
        Iterator<Map.Entry<String, String>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.f26047a.remove(next.getKey());
            }
        }
    }

    private f() {
        this.f26047a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.b.containsKey(str2)) {
            return;
        }
        this.b.put(str2, str);
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str) || this.b.isEmpty() || !this.b.containsKey(str)) {
            return null;
        }
        String c = c(str);
        if (this.f26047a.containsValue(c)) {
            for (Map.Entry<String, String> entry : this.f26047a.entrySet()) {
                if (TextUtils.equals(entry.getValue(), c)) {
                    String str2 = this.b.get(entry.getKey());
                    this.b.put(str, str2);
                    if (!this.f26047a.containsKey(str)) {
                        this.f26047a.put(str, c);
                    }
                    return str2;
                }
            }
        }
        return this.b.get(str);
    }

    public String a(DownloadModel downloadModel) {
        String c = c(downloadModel.getDownloadUrl());
        if (c == null || TextUtils.isEmpty(c)) {
            return null;
        }
        String e = com.ss.android.socialbase.downloader.i.f.e(c + downloadModel.getPackageName());
        this.b.put(downloadModel.getDownloadUrl(), e);
        return e;
    }
}
