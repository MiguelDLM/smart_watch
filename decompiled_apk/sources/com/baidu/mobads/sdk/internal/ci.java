package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ci implements ao.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cb f6273a;

    public ci(cb cbVar) {
        this.f6273a = cbVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ao.a
    public void a() {
        boolean z;
        z = this.f6273a.A;
        if (z) {
            this.f6273a.A = false;
            this.f6273a.a(false, "remote update Network access failed");
        }
    }
}
