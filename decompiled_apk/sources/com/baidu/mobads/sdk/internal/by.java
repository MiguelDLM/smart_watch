package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ck;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class by implements ck.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bx f6263a;

    public by(bx bxVar) {
        this.f6263a = bxVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void a(bz bzVar) {
        this.f6263a.a("OK", bzVar, "download apk successfully, downloader exit");
        bx unused = bx.h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void b(bz bzVar) {
        this.f6263a.a(cb.l, bzVar, "downloadApk failed");
    }
}
