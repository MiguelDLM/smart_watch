package com.alimm.tanx.core.net.okhttp;

import android.os.Handler;
import android.os.Looper;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for;
import com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

public class tanxc_do {
    private static tanxc_do tanxc_do;
    private static tanxc_do tanxc_if;
    private OkHttpClient tanxc_for;
    private OkHttpClient tanxc_int;
    private final Handler tanxc_new = new Handler(Looper.getMainLooper());
    private final ArrayList<String> tanxc_try = new ArrayList<>();

    private tanxc_do(boolean z) {
        Cache cache = new Cache(new File(FileUtils.getExternalDir(TanxCoreSdk.getApplication(), 0).getPath() + "/okhttp_cache/"), 52428800);
        if (z) {
            OkHttpClient.Builder hostnameVerifier = new OkHttpClient.Builder().cache(cache).hostnameVerifier(new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.tanxc_int = hostnameVerifier.connectTimeout(10, timeUnit).readTimeout(10, timeUnit).writeTimeout(10, timeUnit).addInterceptor(tanxc_for.tanxc_do()).addNetworkInterceptor(tanxc_if.tanxc_do()).addInterceptor(new com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_do()).build();
            return;
        }
        OkHttpClient.Builder hostnameVerifier2 = new OkHttpClient.Builder().cache(cache).hostnameVerifier(new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        });
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        this.tanxc_for = hostnameVerifier2.connectTimeout(10, timeUnit2).readTimeout(10, timeUnit2).writeTimeout(10, timeUnit2).addInterceptor(tanxc_for.tanxc_do()).addNetworkInterceptor(tanxc_if.tanxc_do()).build();
    }

    public static tanxc_do tanxc_do() {
        long currentTimeMillis = System.currentTimeMillis();
        if (tanxc_do == null) {
            synchronized (tanxc_do.class) {
                try {
                    if (tanxc_do == null) {
                        tanxc_do = new tanxc_do(false);
                        LogUtils.d("splashTimeConsuming", "new OkHttpUtil ->" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return tanxc_do;
    }

    public static tanxc_do tanxc_if() {
        if (tanxc_if == null) {
            synchronized (tanxc_do.class) {
                try {
                    if (tanxc_if == null) {
                        tanxc_if = new tanxc_do(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return tanxc_if;
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_new() {
        return new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if();
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do tanxc_try() {
        return new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do();
    }

    public Handler tanxc_for() {
        return this.tanxc_new;
    }

    public ArrayList<String> tanxc_int() {
        return this.tanxc_try;
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_if(boolean z) {
        return new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for(z);
    }

    public OkHttpClient tanxc_do(boolean z) {
        if (z) {
            return this.tanxc_int;
        }
        return this.tanxc_for;
    }

    public void tanxc_do(String str) {
        Dispatcher dispatcher = this.tanxc_for.dispatcher();
        synchronized (dispatcher) {
            try {
                for (Call next : dispatcher.queuedCalls()) {
                    if (str.equals(next.request().tag())) {
                        next.cancel();
                    }
                }
                for (Call next2 : dispatcher.runningCalls()) {
                    if (str.equals(next2.request().tag())) {
                        next2.cancel();
                    }
                }
            } finally {
            }
        }
    }
}
