package com.bytedance.sdk.openadsdk.mediation.a.a;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class g extends com.bytedance.sdk.openadsdk.mediation.a.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    private Bridge f10828a;

    public g(Bridge bridge) {
        super(bridge);
        this.f10828a = bridge;
    }

    private ValueSet a(AdSlot adSlot) {
        xXxxox0I xoIox2 = xXxxox0I.xoIox(com.bytedance.sdk.openadsdk.c.a.c.b.b(adSlot));
        xoIox2.Oxx0IOOO(8302, MediationAdClassLoader.getInstance());
        if (adSlot != null && adSlot.getMediationAdSlot() != null) {
            xoIox2.Oxx0IOOO(8260028, new e(adSlot.getMediationAdSlot()));
        }
        return xoIox2.OOXIXo();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.a.a.a.b, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        if (this.f10828a != null) {
            xXxxox0I II0xO02 = xXxxox0I.II0xO0(3);
            II0xO02.Oxx0IOOO(0, context);
            II0xO02.Oxx0IOOO(1, a(adSlot));
            II0xO02.Oxx0IOOO(2, new com.bytedance.sdk.openadsdk.mediation.a.a.b.a(iMediationDrawAdTokenCallback));
            II0xO02.Oxx0IOOO(3, MediationAdClassLoader.getInstance());
            this.f10828a.call(270022, II0xO02.OOXIXo(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.a.a.a.b, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        if (this.f10828a != null) {
            xXxxox0I II0xO02 = xXxxox0I.II0xO0(3);
            II0xO02.Oxx0IOOO(0, context);
            II0xO02.Oxx0IOOO(1, a(adSlot));
            II0xO02.Oxx0IOOO(2, new com.bytedance.sdk.openadsdk.mediation.a.a.b.c(iMediationNativeAdTokenCallback));
            II0xO02.Oxx0IOOO(3, MediationAdClassLoader.getInstance());
            this.f10828a.call(270021, II0xO02.OOXIXo(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.a.a.a.b, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i, int i2) {
        if (this.f10828a != null) {
            xXxxox0I II0xO02 = xXxxox0I.II0xO0(4);
            II0xO02.Oxx0IOOO(0, activity);
            if (list != null) {
                LinkedList linkedList = new LinkedList();
                Iterator<IMediationPreloadRequestInfo> it = list.iterator();
                while (it.hasNext()) {
                    linkedList.add(new h(it.next()));
                }
                II0xO02.Oxx0IOOO(1, linkedList);
            }
            II0xO02.X0o0xo(2, i);
            II0xO02.X0o0xo(3, i2);
            II0xO02.Oxx0IOOO(4, MediationAdClassLoader.getInstance());
            this.f10828a.call(270013, II0xO02.OOXIXo(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.a.a.a.b, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        if (this.f10828a != null) {
            xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
            II0xO02.Oxx0IOOO(0, com.bytedance.sdk.openadsdk.mediation.init.a.a.a.c.a(mediationConfigUserInfoForSegment));
            this.f10828a.call(270014, II0xO02.OOXIXo(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.a.a.a.b, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        if (this.f10828a != null) {
            xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
            II0xO02.Oxx0IOOO(0, com.bytedance.sdk.openadsdk.c.a.c.d.a(tTCustomController));
            this.f10828a.call(270016, II0xO02.OOXIXo(), Void.class);
        }
    }
}
