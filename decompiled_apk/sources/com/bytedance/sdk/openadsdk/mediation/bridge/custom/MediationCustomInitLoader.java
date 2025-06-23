package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.IMediationInit;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class MediationCustomInitLoader implements IMediationInit {

    /* renamed from: a, reason: collision with root package name */
    private Bridge f10858a;

    private void a() {
        if (this.f10858a != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8402, this);
            this.f10858a.call(8216, create.build(), String.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8240) {
            initAdn((Context) valueSet.objectValue(8009, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        } else {
            if (i == 8139) {
                return (T) getBiddingToken((Context) valueSet.objectValue(8009, Context.class), (Map) valueSet.objectValue(8075, Map.class));
            }
            if (i == 8217) {
                return (T) getSdkInfo((Context) valueSet.objectValue(8009, Context.class), (Map) valueSet.objectValue(8075, Map.class));
            }
            if (i == 8218) {
                return (T) getNetworkSdkVersion();
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public final void callInitSuccess() {
        Bridge bridge = this.f10858a;
        if (bridge != null) {
            bridge.call(8219, null, String.class);
        }
    }

    public String getBiddingToken(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract String getNetworkSdkVersion();

    public String getSdkInfo(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.IMediationInit
    public final void initAdn(Context context, ValueSet valueSet) {
        MediationInitConfig create = MediationInitConfig.create(valueSet);
        initInnerADN(context, new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig(create.getCustomInitConfigValueSet()), create.getCustomInitMap(), create.getCustomGMConfiguration());
    }

    public final void initInnerADN(Context context, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map, Bridge bridge) {
        this.f10858a = bridge;
        a();
        try {
            initializeADN(context, mediationCustomInitConfig, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void initializeADN(Context context, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map);

    public final boolean isInit() {
        Bridge bridge = this.f10858a;
        if (bridge != null) {
            return ((Boolean) bridge.call(8220, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
