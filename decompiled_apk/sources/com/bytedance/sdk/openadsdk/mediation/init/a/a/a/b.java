package com.bytedance.sdk.openadsdk.mediation.init.a.a.a;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class b {
    public static final ValueSet a(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        xXxxox0I oIX0oI2 = xXxxox0I.oIX0oI();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        oIX0oI2.Oxx0IOOO(262114, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.a.a.a.b.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public List get() {
                return IMediationPrivacyConfig.this.getCustomAppList();
            }
        });
        oIX0oI2.Oxx0IOOO(262115, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.a.a.a.b.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public List get() {
                return IMediationPrivacyConfig.this.getCustomDevImeis();
            }
        });
        oIX0oI2.Oxx0IOOO(262116, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.a.a.a.b.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isCanUseOaid());
            }
        });
        oIX0oI2.Oxx0IOOO(262117, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.a.a.a.b.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isLimitPersonalAds());
            }
        });
        oIX0oI2.Oxx0IOOO(262118, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.a.a.a.b.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isProgrammaticRecommend());
            }
        });
        return oIX0oI2.OOXIXo();
    }
}
