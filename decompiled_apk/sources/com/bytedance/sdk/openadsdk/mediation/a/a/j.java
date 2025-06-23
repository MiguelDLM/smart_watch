package com.bytedance.sdk.openadsdk.mediation.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class j implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10831a = xXxxox0I.f31020I0Io;
    private final MediationAdDislike b;

    public j(MediationAdDislike mediationAdDislike) {
        this.b = mediationAdDislike;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike mediationAdDislike = this.b;
        if (mediationAdDislike == null) {
            return null;
        }
        switch (i) {
            case 270032:
                mediationAdDislike.showDislikeDialog();
                break;
            case 270033:
                this.b.setDislikeCallback(new f((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10831a;
    }
}
