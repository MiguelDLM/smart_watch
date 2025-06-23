package com.bytedance.sdk.openadsdk.mediation.a.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10819a = xXxxox0I.f31020I0Io;
    private final IMediationDrawAdTokenCallback b;

    public a(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.b = iMediationDrawAdTokenCallback;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.b == null) {
            return null;
        }
        switch (i) {
            case 270029:
                this.b.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), new com.bytedance.sdk.openadsdk.mediation.a.a.a.a((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 270030:
                this.b.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10819a;
    }
}
