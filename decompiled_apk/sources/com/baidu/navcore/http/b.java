package com.baidu.navcore.http;

import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.http.center.j;
import com.baidu.navisdk.util.http.center.k;
import com.huawei.openalliance.ad.constant.bf;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class b implements j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6454a = "b";

    @Override // com.baidu.navisdk.util.http.center.j
    public void b(String str, HashMap<String, String> hashMap, k kVar, com.baidu.navisdk.util.http.center.e eVar) {
        g gVar = g.OPEN_SDK;
        if (gVar.d()) {
            gVar.e(f6454a, "post() url=" + str);
        }
        if (eVar == null) {
            eVar = new com.baidu.navisdk.util.http.center.e();
        }
        HashMap<String, File> hashMap2 = eVar.d;
        if (hashMap2 == null) {
            if (eVar.b != null && eVar.c != null) {
                hashMap2 = new HashMap<>();
                hashMap2.put(eVar.b, eVar.c);
            } else {
                hashMap2 = null;
            }
        }
        HashMap<String, File> hashMap3 = hashMap2;
        if (kVar instanceof com.baidu.navisdk.util.http.center.f) {
            com.baidu.navcore.http.c.a().a(!eVar.f9300a, str, hashMap, hashMap3, new d(this, str, kVar));
        }
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navcore.http.handler.d {
        final /* synthetic */ k e;
        final /* synthetic */ String f;

        public a(b bVar, k kVar, String str) {
            this.e = kVar;
            this.f = str;
        }

        @Override // com.baidu.navcore.http.handler.d
        public void a(int i, String str) {
            k kVar = this.e;
            if (kVar != null) {
                ((com.baidu.navisdk.util.http.center.f) kVar).a(i, str);
            }
        }

        @Override // com.baidu.navcore.http.handler.d
        public void a(int i, String str, Throwable th) {
            g gVar = g.OPEN_SDK;
            if (gVar.d()) {
                gVar.e("onFailure() url=" + this.f + ", statusCode=" + i + ", responseString=" + str + "， throwable=" + th.getMessage());
            }
            k kVar = this.e;
            if (kVar != null) {
                ((com.baidu.navisdk.util.http.center.f) kVar).a(i, str, th);
            }
        }
    }

    /* renamed from: com.baidu.navcore.http.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0149b extends com.baidu.navcore.http.handler.c {
        final /* synthetic */ k f;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0149b(b bVar, File file, k kVar, String str) {
            super(file);
            this.f = kVar;
            this.g = str;
        }

        @Override // com.baidu.navcore.http.handler.c
        public void a(int i, File file) {
            k kVar = this.f;
            if (kVar != null) {
                ((com.baidu.navisdk.util.http.center.d) kVar).a(i, file);
            }
        }

        @Override // com.baidu.navcore.http.handler.c
        public void a(int i, Throwable th, File file) {
            g gVar = g.OPEN_SDK;
            if (gVar.d()) {
                gVar.e("onFailure() url=" + this.g + ", statusCode=" + i + "， throwable=" + th.getMessage());
            }
            k kVar = this.f;
            if (kVar != null) {
                ((com.baidu.navisdk.util.http.center.d) kVar).a(i, th, file);
            }
        }
    }

    @Override // com.baidu.navisdk.util.http.center.j
    public void a(String str, HashMap<String, String> hashMap, k kVar, com.baidu.navisdk.util.http.center.e eVar) {
        g gVar = g.OPEN_SDK;
        if (gVar.d()) {
            gVar.e(f6454a, "get() url=" + str);
        }
        com.baidu.navisdk.util.http.center.e eVar2 = eVar == null ? new com.baidu.navisdk.util.http.center.e() : eVar;
        if (kVar instanceof com.baidu.navisdk.util.http.center.f) {
            com.baidu.navcore.http.c.a().a(!eVar2.f9300a, str, hashMap, new a(this, kVar, str));
        } else if (kVar instanceof com.baidu.navisdk.util.http.center.d) {
            com.baidu.navcore.http.c.a().a(!eVar2.f9300a, str, hashMap, new C0149b(this, eVar2.c, kVar, str));
        } else if (kVar instanceof com.baidu.navisdk.util.http.center.a) {
            com.baidu.navcore.http.c.a().a(!eVar2.f9300a, str, hashMap, new c(this, new String[]{"text/plain", "application/octet-stream", "image/jpeg", bf.Z, bf.B, "application/octet-stream".concat(";charset=utf-8"), "image/jpeg;charset=utf-8", "image/png;charset=utf-8", "image/gif;charset=utf-8", "application/javascript;charset=utf-8"}, str, kVar));
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navcore.http.handler.b {
        final /* synthetic */ String e;
        final /* synthetic */ k f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, String[] strArr, String str, k kVar) {
            super(strArr);
            this.e = str;
            this.f = kVar;
        }

        @Override // com.baidu.navcore.http.handler.a
        public void a(int i, byte[] bArr) {
            g gVar = g.OPEN_SDK;
            if (gVar.d()) {
                gVar.e(b.f6454a, "onSuccess() url=" + this.e + ", statusCode=" + i);
            }
            k kVar = this.f;
            if (kVar != null) {
                ((com.baidu.navisdk.util.http.center.a) kVar).a(i, bArr);
            }
        }

        @Override // com.baidu.navcore.http.handler.a
        public void a(int i, byte[] bArr, Throwable th) {
            g gVar = g.OPEN_SDK;
            if (gVar.d()) {
                gVar.e("onFailure() url=" + this.e + ", statusCode=" + i + "， throwable=" + th.getMessage());
            }
            k kVar = this.f;
            if (kVar != null) {
                ((com.baidu.navisdk.util.http.center.a) kVar).a(i, bArr, th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navcore.http.handler.d {
        final /* synthetic */ String e;
        final /* synthetic */ k f;

        public d(b bVar, String str, k kVar) {
            this.e = str;
            this.f = kVar;
        }

        @Override // com.baidu.navcore.http.handler.d
        public void a(int i, String str) {
            g gVar = g.OPEN_SDK;
            if (gVar.d()) {
                gVar.e(b.f6454a, "onSuccess() url=" + this.e + ", statusCode =" + i + ", responseString=" + str);
            }
            k kVar = this.f;
            if (kVar != null) {
                ((com.baidu.navisdk.util.http.center.f) kVar).a(i, str);
            }
        }

        @Override // com.baidu.navcore.http.handler.d
        public void a(int i, String str, Throwable th) {
            g gVar = g.OPEN_SDK;
            if (gVar.d()) {
                gVar.e(b.f6454a, "onFailure() url=" + this.e + ", statusCode =" + i + ", responseString=" + str);
            }
            k kVar = this.f;
            if (kVar != null) {
                ((com.baidu.navisdk.util.http.center.f) kVar).a(i, str, th);
            }
        }
    }
}
