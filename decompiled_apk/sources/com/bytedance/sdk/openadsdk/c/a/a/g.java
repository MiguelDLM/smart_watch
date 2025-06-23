package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class g implements PersonalizationPrompt {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10720a;

    public g(Bridge bridge) {
        this.f10720a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getName() {
        return (String) this.f10720a.values().objectValue(242002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getUrl() {
        return (String) this.f10720a.values().objectValue(242001, String.class);
    }
}
