package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* loaded from: classes8.dex */
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f10809a;
    private AdSlot b;
    private List<String> c;

    public MediationPreloadRequestInfo(int i, AdSlot adSlot, List<String> list) {
        this.f10809a = i;
        this.b = adSlot;
        this.c = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.f10809a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.c;
    }
}
