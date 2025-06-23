package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class o implements g.a<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f5596a;
    final /* synthetic */ LBSAuthManager b;

    public o(LBSAuthManager lBSAuthManager, String str) {
        this.b = lBSAuthManager;
        this.f5596a = str;
    }

    @Override // com.baidu.lbsapi.auth.g.a
    public void a(String str) {
        this.b.a(str, this.f5596a);
    }
}
