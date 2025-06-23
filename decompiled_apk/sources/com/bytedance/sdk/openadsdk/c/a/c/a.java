package com.bytedance.sdk.openadsdk.c.a.c;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.Map;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a {
    public static final ValueSet a(final AdConfig adConfig) {
        ValueSet valueSet;
        xXxxox0I oIX0oI2 = xXxxox0I.oIX0oI();
        ValueSet valueSet2 = null;
        if (adConfig == null) {
            return null;
        }
        oIX0oI2.II0XooXoX(261001, adConfig.getAppId());
        oIX0oI2.II0XooXoX(261002, adConfig.getAppName());
        oIX0oI2.xxIXOIIO(261003, adConfig.isPaid());
        oIX0oI2.II0XooXoX(261004, adConfig.getKeywords());
        oIX0oI2.II0XooXoX(261005, adConfig.getData());
        oIX0oI2.X0o0xo(261006, adConfig.getTitleBarTheme());
        oIX0oI2.xxIXOIIO(261007, adConfig.isAllowShowNotify());
        oIX0oI2.xxIXOIIO(261008, adConfig.isDebug());
        oIX0oI2.Oxx0IOOO(261009, adConfig.getDirectDownloadNetworkType());
        oIX0oI2.xxIXOIIO(261011, adConfig.isSupportMultiProcess());
        if (adConfig.getCustomController() != null) {
            valueSet = d.a(adConfig.getCustomController());
        } else {
            valueSet = null;
        }
        oIX0oI2.Oxx0IOOO(261012, valueSet);
        oIX0oI2.Oxx0IOOO(261013, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.a.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getPluginUpdateConfig());
            }
        });
        oIX0oI2.Oxx0IOOO(261014, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.a.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getAgeGroup());
            }
        });
        oIX0oI2.Oxx0IOOO(261015, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.a.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getThemeStatus());
            }
        });
        if (adConfig.getMediationConfig() != null) {
            valueSet2 = com.bytedance.sdk.openadsdk.mediation.init.a.a.a.a.a(adConfig.getMediationConfig());
        }
        oIX0oI2.Oxx0IOOO(261016, valueSet2);
        oIX0oI2.xxIXOIIO(261017, adConfig.isUseMediation());
        oIX0oI2.Oxx0IOOO(261018, new ValueSet.ValueGetter<Map>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.a.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map get() {
                return AdConfig.this.getInitExtra();
            }
        });
        return oIX0oI2.OOXIXo();
    }
}
