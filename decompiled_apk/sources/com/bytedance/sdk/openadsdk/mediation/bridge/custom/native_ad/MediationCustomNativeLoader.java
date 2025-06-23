package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class MediationCustomNativeLoader extends MediationCustomAdBaseLoader {
    public final void callLoadSuccess(List<? extends MediationCustomNativeAd> list) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8303, list);
            this.mGmAdLoader.call(8107, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public final boolean isExpressRender() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return ((Boolean) bridge.call(8222, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public final boolean isNativeAd() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return ((Boolean) bridge.call(8223, null, Boolean.class)).booleanValue();
        }
        return false;
    }
}
