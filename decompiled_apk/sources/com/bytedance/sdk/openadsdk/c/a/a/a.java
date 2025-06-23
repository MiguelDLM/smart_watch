package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJAdError;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a extends CSJAdError {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10712a;

    public a(Bridge bridge) {
        this.f10712a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.f10712a.values().intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return (String) this.f10712a.values().objectValue(263002, String.class);
    }
}
