package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ce implements cp.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cb f6271a;

    public ce(cb cbVar) {
        this.f6271a = cbVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cp.a
    public void a(String str) {
        try {
            this.f6271a.b();
            this.f6271a.a(str);
        } catch (Throwable th) {
            bv.a().a(th);
        }
    }
}
