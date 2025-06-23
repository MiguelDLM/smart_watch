package com.baidu.mapapi.http;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes7.dex */
public class AsyncHttpClient {

    /* renamed from: a, reason: collision with root package name */
    private int f5781a = 10000;
    private int b = 10000;
    private ExecutorService c = Executors.newCachedThreadPool();

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {
        private a() {
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        public /* synthetic */ a(com.baidu.mapapi.http.a aVar) {
            this();
        }
    }

    public void get(String str, HttpClient.ProtoResultCallback protoResultCallback) {
        if (str != null) {
            this.c.submit(new com.baidu.mapapi.http.a(this, protoResultCallback, str));
            return;
        }
        throw new IllegalArgumentException("URI cannot be null");
    }

    public boolean isAuthorized() {
        int permissionCheck = PermissionCheck.permissionCheck();
        if (permissionCheck != 0 && permissionCheck != 602 && permissionCheck != 601) {
            return false;
        }
        return true;
    }
}
