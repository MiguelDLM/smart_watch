package com.bytedance.sdk.openadsdk.h.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10777a = xXxxox0I.f31020I0Io;
    private final TTDrawFeedAd.DrawVideoListener b;

    public a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.b = drawVideoListener;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTDrawFeedAd.DrawVideoListener drawVideoListener = this.b;
        if (drawVideoListener == null) {
            return null;
        }
        switch (i) {
            case 171101:
                drawVideoListener.onClick();
                break;
            case 171102:
                drawVideoListener.onClickRetry();
                break;
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10777a;
    }
}
