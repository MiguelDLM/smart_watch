package com.bytedance.sdk.openadsdk.i.a.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class b implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10780a = xXxxox0I.f31020I0Io;
    private final TTFeedAd.VideoRewardListener b;

    public b(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.b = videoRewardListener;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.b == null) {
            return null;
        }
        if (i == 163101) {
            this.b.onFeedRewardCountDown(valueSet.intValue(0));
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10780a;
    }
}
