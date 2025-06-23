package com.baidu.location.e;

import android.os.Looper;
import com.baidu.location.b.ab;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes7.dex */
public abstract class g {
    public static int dx = com.baidu.location.e.a.f;

    /* renamed from: a, reason: collision with root package name */
    private static String f5737a = "10.0.0.172";
    private static int b = 80;
    protected static int dJ = 0;
    public String dy = null;
    public int dz = 1;
    public String dA = null;
    public Map<String, Object> dB = null;
    public String dC = null;
    public byte[] dD = null;
    public byte[] dE = null;
    public String dF = null;
    public boolean dG = false;
    public String dH = null;
    public long dI = 0;

    /* loaded from: classes7.dex */
    public static class a implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        private URL f5738a;

        public a(URL url) {
            this.f5738a = url;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.f5738a.getHost().equals(str);
        }
    }

    public abstract void a();

    public abstract void a(boolean z);

    public void b(String str) {
        if (com.baidu.location.b.e.b().dm != 1) {
            try {
                new k(this, str).start();
            } catch (Throwable unused) {
                a(false);
            }
        } else if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            new Thread(new j(this, str)).start();
        } else {
            a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        ab a2;
        String str2;
        a();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dH != null) {
            a2 = ab.a();
            str2 = this.dH;
        } else {
            a2 = ab.a();
            str2 = null;
        }
        a2.a(str2);
        ab.a().a(this.dB, str, new h(this, currentTimeMillis));
    }

    public void a(ExecutorService executorService, String str) {
        try {
            executorService.execute(new m(this, str));
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void a(ExecutorService executorService, boolean z, String str) {
        try {
            executorService.execute(new i(this, str, z));
        } catch (Throwable unused) {
            a(false);
        }
    }
}
