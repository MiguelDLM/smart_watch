package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class af implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f6220a;

    public af(ae aeVar) {
        this.f6220a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6220a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
