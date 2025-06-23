package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class cw implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cv f6297a;

    public cw(cv cvVar) {
        this.f6297a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6297a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
