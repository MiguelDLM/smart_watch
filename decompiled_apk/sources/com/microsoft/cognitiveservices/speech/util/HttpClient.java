package com.microsoft.cognitiveservices.speech.util;

import android.net.ConnectivityManager;
import android.os.Build;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import org.apache.commons.lang3.XX0;

/* loaded from: classes11.dex */
public class HttpClient {
    private static final int MAX_HTTP_THREADS = 2;
    private ConnectivityCallback m_callback;
    private ConnectivityManager m_connectivityManager;
    private final ExecutorService m_executor;

    /* loaded from: classes11.dex */
    public static class FutureShim extends FutureTask<Boolean> {
        public FutureShim(Request request) {
            super(request, Boolean.TRUE);
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return super.cancel(z);
        }
    }

    public HttpClient() {
        setCacheFilePath(System.getProperty(XX0.f32564X0o0xo));
        this.m_executor = createExecutor();
        createClientInstance();
    }

    public native void createClientInstance();

    public ExecutorService createExecutor() {
        return Executors.newFixedThreadPool(2);
    }

    public FutureTask<Boolean> createTask(String str, String str2, byte[] bArr, String str3, int[] iArr, byte[] bArr2) {
        try {
            return new FutureShim(new Request(this, str, str2, bArr, str3, iArr, bArr2));
        } catch (Exception unused) {
            return null;
        }
    }

    public native void deleteClientInstance();

    public native void dispatchCallback(String str, int i, Object[] objArr, byte[] bArr);

    public void executeTask(FutureTask<Boolean> futureTask) {
        this.m_executor.execute(futureTask);
    }

    public void finalize() {
        ConnectivityCallback connectivityCallback = this.m_callback;
        if (connectivityCallback != null) {
            this.m_connectivityManager.unregisterNetworkCallback(connectivityCallback);
            this.m_callback = null;
        }
        deleteClientInstance();
        this.m_executor.shutdown();
    }

    public boolean hasConnectivityManager() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public URL newUrl(String str) throws MalformedURLException {
        return new URL(str);
    }

    public native void onCostChange(boolean z);

    public native void onPowerChange(boolean z, boolean z2);

    public native void setCacheFilePath(String str);

    public native void setDeviceInfo(String str, String str2, String str3);

    public native void setSystemInfo(String str, String str2, String str3, String str4, String str5, String str6);
}
