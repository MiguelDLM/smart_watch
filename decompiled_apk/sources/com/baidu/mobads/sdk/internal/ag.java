package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ag implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f6221a;

    public ag(ae aeVar) {
        this.f6221a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6221a.x();
        }
    }
}
