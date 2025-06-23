package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.map.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f extends HttpClient.ProtoResultCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6183a;
    final /* synthetic */ String b;
    final /* synthetic */ e.a c;
    final /* synthetic */ e d;

    public f(e eVar, Context context, String str, e.a aVar) {
        this.d = eVar;
        this.f6183a = context;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        String a2;
        boolean a3;
        a2 = this.d.a(this.f6183a, this.b);
        a3 = this.d.a(a2);
        if (!a3) {
            a2 = null;
        }
        e.a aVar = this.c;
        if (aVar != null) {
            aVar.a(httpStateError.ordinal(), httpStateError.name(), a2);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("CustomMap failed error = " + httpStateError.ordinal());
        }
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        this.d.b(this.f6183a, str, this.b, this.c);
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("CustomMap result = " + str);
        }
    }
}
