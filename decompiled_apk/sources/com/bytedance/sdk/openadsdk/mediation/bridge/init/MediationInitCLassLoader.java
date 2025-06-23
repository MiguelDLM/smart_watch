package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;

/* loaded from: classes8.dex */
public class MediationInitCLassLoader implements Bridge {
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Class<?> cls2;
        if (i == 8100) {
            MediationInitConfig create = MediationInitConfig.create(valueSet);
            try {
                if (create.isCustom() && create.getCustomInitConfigValueSet() != null) {
                    cls2 = Class.forName(create.getCustomInitConfigValueSet().stringValue(8536));
                } else {
                    cls2 = Class.forName(create.getClassName());
                }
                Object newInstance = cls2.newInstance();
                if (newInstance instanceof Bridge) {
                    MediationValueSetBuilder create2 = MediationValueSetBuilder.create();
                    create2.add(8009, TTAppContextHolder.getContext());
                    create2.add(8424, valueSet);
                    ((Bridge) newInstance).call(8240, create2.build(), null);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
