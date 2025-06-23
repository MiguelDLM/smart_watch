package com.baidu.platform.base;

import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f9527a;
    final /* synthetic */ Object b;
    final /* synthetic */ a c;

    public b(a aVar, d dVar, Object obj) {
        this.c = aVar;
        this.f9527a = dVar;
        this.b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.c.a(httpStateError, this.f9527a, this.b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        boolean c;
        String str2;
        AsyncHttpClient asyncHttpClient;
        String str3;
        c = this.c.c(str);
        if (!c) {
            if (this.f9527a instanceof com.baidu.platform.core.c.e) {
                str3 = this.c.a(str);
            } else {
                str3 = "";
            }
            if (!TextUtils.isEmpty(str3)) {
                str2 = str3;
                a aVar = this.c;
                d dVar = this.f9527a;
                Object obj = this.b;
                asyncHttpClient = aVar.b;
                aVar.a(str2, dVar, obj, asyncHttpClient, this);
            }
        }
        str2 = str;
        a aVar2 = this.c;
        d dVar2 = this.f9527a;
        Object obj2 = this.b;
        asyncHttpClient = aVar2.b;
        aVar2.a(str2, dVar2, obj2, asyncHttpClient, this);
    }
}
