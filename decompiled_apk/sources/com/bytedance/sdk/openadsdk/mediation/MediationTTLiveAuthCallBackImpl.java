package com.bytedance.sdk.openadsdk.mediation;

import com.baidu.mapapi.UIMsg;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* loaded from: classes8.dex */
public class MediationTTLiveAuthCallBackImpl implements TTLiveAuthCallback {

    /* renamed from: a, reason: collision with root package name */
    private Bridge f10812a;

    public MediationTTLiveAuthCallBackImpl(Bridge bridge) {
        this.f10812a = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
    public void onAuth(TTLiveToken tTLiveToken) {
        if (this.f10812a != null && tTLiveToken != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8520, tTLiveToken.name);
            create.add(8521, tTLiveToken.accessToken);
            create.add(8522, tTLiveToken.openId);
            create.add(8523, tTLiveToken.expireAt);
            create.add(8524, tTLiveToken.refreshToken);
            this.f10812a.call(8527, create.build(), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
    public void onFailed(Throwable th) {
        if (this.f10812a != null && th != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYS, th);
            this.f10812a.call(8528, create.build(), null);
        }
    }
}
