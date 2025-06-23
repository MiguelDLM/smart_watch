package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class n implements e.a<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f5595a;
    final /* synthetic */ LBSAuthManager b;

    public n(LBSAuthManager lBSAuthManager, String str) {
        this.b = lBSAuthManager;
        this.f5595a = str;
    }

    @Override // com.baidu.lbsapi.auth.e.a
    public void a(String str) {
        this.b.a(str, this.f5595a);
    }
}
