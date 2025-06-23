package com.huawei.hms.ads.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.ads.jsb.IWebView;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private volatile String f17317a;

    /* renamed from: com.huawei.hms.ads.jsbridge.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class CallableC0651a implements Callable<String> {

        /* renamed from: a, reason: collision with root package name */
        private IWebView f17318a;
        private WebView b;
        private boolean c;

        public CallableC0651a(WebView webView) {
            this.b = webView;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            if (this.c) {
                IWebView iWebView = this.f17318a;
                if (iWebView != null) {
                    return iWebView.getUrl();
                }
                return null;
            }
            WebView webView = this.b;
            if (webView != null) {
                return webView.getUrl();
            }
            return null;
        }

        public CallableC0651a(IWebView iWebView) {
            this.c = true;
            this.f17318a = iWebView;
        }
    }

    @Nullable
    private static String b(@NonNull WebView webView) {
        try {
            return a(new FutureTask(new CallableC0651a(webView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            b.b("Exception will waiting: " + e.getMessage());
            b.b("exception or timeout while waiting for url");
            return null;
        }
    }

    @Nullable
    public String a(@Nullable WebView webView) {
        if (webView == null) {
            return null;
        }
        String str = this.f17317a;
        if (str != null) {
            return str;
        }
        b.a("securityExtSetFrameUrl is null ,get url from native");
        return b(webView);
    }

    @Nullable
    private static String b(@NonNull IWebView iWebView) {
        try {
            return a(new FutureTask(new CallableC0651a(iWebView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            b.b("Exception will waiting: " + e.getMessage());
            b.b("exception or timeout while waiting for url");
            return null;
        }
    }

    @Nullable
    public String a(@Nullable IWebView iWebView) {
        if (iWebView == null) {
            return null;
        }
        String str = this.f17317a;
        return str != null ? str : b(iWebView);
    }

    private static Future<String> a(FutureTask futureTask) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            futureTask.run();
        } else {
            new Handler(Looper.getMainLooper()).post(futureTask);
        }
        return futureTask;
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
