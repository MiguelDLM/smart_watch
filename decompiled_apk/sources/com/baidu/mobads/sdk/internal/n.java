package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class n implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f6332a;

    public n(m mVar) {
        this.f6332a = mVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bj.a(new o(this, iOAdEvent));
    }
}
