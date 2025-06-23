package com.bytedance.sdk.openadsdk.mediation.ad.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class b implements MediationAdDislike {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10842a;

    public b(Bridge bridge) {
        this.f10842a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.mediation.ad.a.a.b.b(iMediationDislikeCallback));
        this.f10842a.call(270033, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        this.f10842a.call(270032, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }
}
