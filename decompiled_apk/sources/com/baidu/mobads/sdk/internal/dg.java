package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class dg implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ de f6307a;

    public dg(de deVar) {
        this.f6307a = deVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6307a.z();
        }
    }
}
