package com.bytedance.sdk.openadsdk.g.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.c.a.a.p;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class f implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10776a = xXxxox0I.f31020I0Io;
    private final TTAdNative.RewardVideoAdListener b;

    public f(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.b = rewardVideoAdListener;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.b;
        if (rewardVideoAdListener == null) {
            return null;
        }
        switch (i) {
            case 124101:
                this.b.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 124102:
                this.b.onRewardVideoAdLoad(new p((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124103:
                this.b.onRewardVideoCached(new p((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124104:
                rewardVideoAdListener.onRewardVideoCached();
                break;
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10776a;
    }
}
