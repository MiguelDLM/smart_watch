package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class cx implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cv f6298a;

    public cx(cv cvVar) {
        this.f6298a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6298a.h();
        }
    }
}
