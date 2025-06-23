package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.internal.v;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* loaded from: classes7.dex */
public class am extends Observable implements v, Runnable {
    protected static final int i = 10240;
    protected static final int j = 10240;
    public static final String k = ".tmp";
    private static final String m = "FileDownloader";

    /* renamed from: a, reason: collision with root package name */
    protected Context f6226a;
    protected URL b;
    protected String c;
    protected String d;
    protected int e;
    protected v.a f;
    protected int g;
    protected int h;
    protected byte[] l;
    private boolean n;

    public am(Context context, URL url, String str, String str2, boolean z) {
        this.f6226a = context;
        this.b = url;
        this.c = str;
        this.n = z;
        if (str2 != null && str2.trim().length() > 0) {
            this.d = str2;
        } else {
            String file = url.getFile();
            this.d = file.substring(file.lastIndexOf(47) + 1);
        }
        this.e = -1;
        this.f = v.a.DOWNLOADING;
        this.g = 0;
        this.h = 0;
    }

    private void s() {
        a(v.a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public String e() {
        return this.b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public String g() {
        return this.c + this.d;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public int j() {
        return this.e;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public float k() {
        return Math.abs((this.g / this.e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public v.a l() {
        return this.f;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public void m() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public boolean n() {
        return false;
    }

    public byte[] o() {
        return this.l;
    }

    public void p() {
        be.a().a(this);
    }

    public void q() {
        setChanged();
        notifyObservers();
    }

    public void r() {
        bt.a(this.c + this.d + ".tmp", this.c + this.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.am.run():void");
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public void a() {
        a(v.a.DOWNLOADING);
        p();
    }

    public void a(v.a aVar) {
        this.f = aVar;
        q();
    }

    public void a(int i2, float f) {
        this.g += i2;
        q();
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField("Location"));
                this.b = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
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
}
