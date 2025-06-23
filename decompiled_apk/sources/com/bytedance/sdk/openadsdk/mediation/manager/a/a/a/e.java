package com.bytedance.sdk.openadsdk.mediation.manager.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class e implements MediationRewardManager {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10894a;

    public e(Bridge bridge) {
        this.f10894a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager
    public void destroy() {
        this.f10894a.call(270007, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        List list = (List) this.f10894a.call(270002, xXxxox0I.II0xO0(0).OOXIXo(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new b((Bridge) it.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getBestEcpm() {
        return new a((Bridge) this.f10894a.call(270004, xXxxox0I.II0xO0(0).OOXIXo(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        List list = (List) this.f10894a.call(270005, xXxxox0I.II0xO0(0).OOXIXo(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new a((Bridge) it.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getMultiBiddingEcpm() {
        List list = (List) this.f10894a.call(270003, xXxxox0I.II0xO0(0).OOXIXo(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new a((Bridge) it.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getShowEcpm() {
        return new a((Bridge) this.f10894a.call(270006, xXxxox0I.II0xO0(0).OOXIXo(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        return ((Boolean) this.f10894a.call(270001, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }
}
