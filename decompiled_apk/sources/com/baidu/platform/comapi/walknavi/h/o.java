package com.baidu.platform.comapi.walknavi.h;

import android.text.TextUtils;
import com.baidu.platform.comapi.walknavi.widget.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class o implements a.InterfaceC0539a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9813a;

    public o(b bVar) {
        this.f9813a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0539a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals("stop")) {
            com.baidu.platform.comapi.wnplatform.d.a.a("view listener", "stop");
        } else {
            com.baidu.platform.comapi.wnplatform.d.a.a("view listener", "finish");
            this.f9813a.b(str);
        }
    }
}
