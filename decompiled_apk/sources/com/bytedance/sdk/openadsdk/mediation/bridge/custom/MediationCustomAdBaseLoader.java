package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.a.a.a;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationAdLoader;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class MediationCustomAdBaseLoader implements IMediationAdLoader {
    public Bridge mGmAdLoader;

    private void a() {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8405, this);
            this.mGmAdLoader.call(8221, create.build(), String.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8241) {
            load((Context) valueSet.objectValue(8009, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        } else if (i == 8225) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
        } else if (i == 8149) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i == 8148) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i == 8109) {
            MediationApiLog.i("TTMediationSDK", "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i, valueSet, cls);
    }

    public final void callLoadFail(int i, String str) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYS, i);
            create.add(8015, str);
            this.mGmAdLoader.call(8123, create.build(), String.class);
        }
    }

    public abstract <T> T callMethod(int i, ValueSet valueSet, Class<T> cls);

    public final String getAdm() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return (String) bridge.call(8137, null, String.class);
        }
        return "";
    }

    public final int getBiddingType() {
        Integer num;
        Bridge bridge = this.mGmAdLoader;
        if (bridge == null || (num = (Integer) bridge.call(8226, null, Integer.class)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final Object getExtraDataNoParse() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge == null) {
            return null;
        }
        return bridge.call(8224, null, Object.class);
    }

    public final Bridge getGMBridge() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge == null) {
            return null;
        }
        return (Bridge) bridge.call(8127, null, Bridge.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationAdLoader
    public final void load(Context context, ValueSet valueSet) {
        MediationLoaderConfig create = MediationLoaderConfig.create(valueSet);
        loadInner(context, a.a(create.getAdSlotValueSet()), new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig(create.getMediationCustomServiceConfigValue()), create.getGMCustomAdLoader());
    }

    public abstract void load(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig);

    public final void loadInner(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig, Bridge bridge) {
        this.mGmAdLoader = bridge;
        a();
        if (adSlot == null) {
            try {
                adSlot = new AdSlot.Builder().build();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        load(context, adSlot, mediationCustomServiceConfig);
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void receiveBidResult(boolean z, double d, int i, @Nullable Map<String, Object> map) {
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (this.mGmAdLoader != null && map != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8075, map);
            this.mGmAdLoader.call(8227, create.build(), Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
