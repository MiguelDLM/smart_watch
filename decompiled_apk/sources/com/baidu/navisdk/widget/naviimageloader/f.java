package com.baidu.navisdk.widget.naviimageloader;

import android.graphics.BitmapFactory;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class f {
    public void a(String str, h hVar) {
        com.baidu.navisdk.util.http.center.e eVar = new com.baidu.navisdk.util.http.center.e();
        eVar.f9300a = false;
        com.baidu.navisdk.util.http.center.b.a().a(str, null, new a(this, hVar), eVar);
    }

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.http.center.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f9420a;

        public a(f fVar, h hVar) {
            this.f9420a = hVar;
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr) {
            LogUtil.e("BaseHttpClient", "onSuccess().statusCode=" + i);
            if (this.f9420a == null || bArr == null) {
                return;
            }
            this.f9420a.a((Object) BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr, Throwable th) {
            LogUtil.e("BaseHttpClient", "onFailure().statusCode=" + i);
            h hVar = this.f9420a;
            if (hVar != null) {
                hVar.a(th);
            }
        }
    }
}
