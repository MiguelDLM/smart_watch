package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.content.Context;
import com.baidu.platform.comapi.UIMsg;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationResultBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;

/* loaded from: classes8.dex */
public abstract class MediationInitImpl implements IMediationInit {
    public MediationInitConfig mInitConfig;

    private void a() {
        Bridge initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(UIMsg.MsgDefine.MSG_BASE_VOICESEARCH_STATE, this);
            initCallback.call(8266, create.build(), Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8240) {
            initAdn((Context) valueSet.objectValue(8009, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        }
        return (T) callFunction(i, valueSet, cls);
    }

    public <T> T callFunction(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.IMediationInit
    public final void initAdn(Context context, ValueSet valueSet) {
        this.mInitConfig = MediationInitConfig.create(valueSet);
        a();
        realInitAdn(context, this.mInitConfig);
    }

    public void notifyFail(int i, String str) {
        Bridge initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            MediationResultBuilder create = MediationResultBuilder.create();
            create.setSuccess(false);
            create.setCode(i);
            create.setMessage(str);
            MediationValueSetBuilder create2 = MediationValueSetBuilder.create();
            create2.add(8022, create);
            initCallback.call(8123, create2.build(), Void.class);
        }
    }

    public void notifySuccess() {
        Bridge initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(UIMsg.MsgDefine.MSG_BASE_VOICESEARCH_STATE, this);
            initCallback.call(8122, create.build(), Void.class);
        }
    }

    public abstract void realInitAdn(Context context, MediationInitConfig mediationInitConfig);

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public void notifyFail(String str) {
        notifyFail(80000, str);
    }
}
