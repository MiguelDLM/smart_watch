package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import XIXIX.OOXIXo;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* loaded from: classes8.dex */
public class MediationLocationImpl implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private IMediationLocation f10868a;

    public MediationLocationImpl(IMediationLocation iMediationLocation) {
        this.f10868a = iMediationLocation;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        double d;
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        IMediationLocation iMediationLocation = this.f10868a;
        double d2 = OOXIXo.f3760XO;
        if (iMediationLocation != null) {
            d = iMediationLocation.getLatitude();
        } else {
            d = 0.0d;
        }
        create.add(8481, d);
        IMediationLocation iMediationLocation2 = this.f10868a;
        if (iMediationLocation2 != null) {
            d2 = iMediationLocation2.getLongitude();
        }
        create.add(8482, d2);
        return create.build();
    }
}
