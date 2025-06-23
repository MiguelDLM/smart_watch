package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected EventListener f10688a;

    public void a(int i, Result result) {
        if (a()) {
            return;
        }
        this.f10688a.onEvent(i, result);
    }

    public void a(int i) {
        a(i, null);
    }

    public boolean a() {
        return this.f10688a == null;
    }
}
