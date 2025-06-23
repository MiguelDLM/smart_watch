package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class dc implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ db f6303a;

    public dc(db dbVar) {
        this.f6303a = dbVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bj.a(new dd(this, iOAdEvent));
    }
}
