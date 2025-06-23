package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a.InterfaceC0530a f9680a;
    final /* synthetic */ a b;

    public b(a aVar, a.InterfaceC0530a interfaceC0530a) {
        this.b = aVar;
        this.f9680a = interfaceC0530a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9680a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0530a interfaceC0530a = this.f9680a;
        a2 = this.b.a(str);
        interfaceC0530a.a((a.InterfaceC0530a) a2);
    }
}
