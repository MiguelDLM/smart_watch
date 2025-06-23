package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.commonutils.a.c;
import com.baidu.mapsdkplatform.comapi.map.e;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements c.InterfaceC0139c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6184a;
    final /* synthetic */ String b;
    final /* synthetic */ e.a c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ e f;

    public g(e eVar, Context context, String str, e.a aVar, String str2, String str3) {
        this.f = eVar;
        this.f6184a = context;
        this.b = str;
        this.c = aVar;
        this.d = str2;
        this.e = str3;
    }

    @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.c.InterfaceC0139c
    public void a(File file) {
        boolean a2;
        boolean a3;
        a2 = this.f.a(this.f6184a, file, this.b);
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("CustomMap loadStyleFile success ret = " + a2);
        }
        if (a2) {
            this.f.a(this.f6184a, this.b, this.d);
            if (this.c != null) {
                a3 = this.f.a(this.e);
                this.c.a(true, a3 ? this.e : null);
                return;
            }
            return;
        }
        e.a aVar = this.c;
        if (aVar != null) {
            aVar.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "UnZipStyleFile onFailed", null);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.c.InterfaceC0139c
    public void a() {
        e.a aVar = this.c;
        if (aVar != null) {
            aVar.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "loadStyleFile onFailed", null);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("CustomMap loadStyleFile failed");
        }
    }
}
