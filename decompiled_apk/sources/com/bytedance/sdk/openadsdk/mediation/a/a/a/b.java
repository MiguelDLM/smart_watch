package com.bytedance.sdk.openadsdk.mediation.a.a.a;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.c.a.a.i;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import com.bytedance.sdk.openadsdk.mediation.a.a.b.e;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.List;
import java.util.Map;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class b implements IMediationManager {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10816a;

    public b(Bridge bridge) {
        this.f10816a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Map<String, Object> getMediationExtraInfo() {
        return (Map) this.f10816a.call(270024, xXxxox0I.II0xO0(0).OOXIXo(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(3);
        II0xO02.Oxx0IOOO(0, context);
        II0xO02.Oxx0IOOO(1, adSlot);
        II0xO02.Oxx0IOOO(2, new com.bytedance.sdk.openadsdk.mediation.a.a.b.a(iMediationDrawAdTokenCallback));
        this.f10816a.call(270022, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(3);
        II0xO02.Oxx0IOOO(0, context);
        II0xO02.Oxx0IOOO(1, adSlot);
        II0xO02.Oxx0IOOO(2, new com.bytedance.sdk.openadsdk.mediation.a.a.b.c(iMediationNativeAdTokenCallback));
        this.f10816a.call(270021, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Object mtool(int i, ValueSet valueSet) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(2);
        II0xO02.X0o0xo(0, i);
        II0xO02.Oxx0IOOO(1, valueSet);
        return this.f10816a.call(271043, II0xO02.OOXIXo(), Object.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i, int i2) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(4);
        II0xO02.Oxx0IOOO(0, activity);
        II0xO02.Oxx0IOOO(1, list);
        II0xO02.X0o0xo(2, i);
        II0xO02.X0o0xo(3, i2);
        this.f10816a.call(270013, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, context);
        this.f10816a.call(270017, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setPulisherDid(String str) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.II0XooXoX(0, str);
        this.f10816a.call(270015, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setThemeStatus(int i) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.X0o0xo(0, i);
        this.f10816a.call(270019, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, mediationConfigUserInfoForSegment);
        this.f10816a.call(270014, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new e(mediationAppDialogClickListener));
        return ((Integer) this.f10816a.call(270020, II0xO02.OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updateLocalExtra(Map<String, Object> map) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, map);
        this.f10816a.call(271050, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new i(tTCustomController));
        this.f10816a.call(270016, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context, int[] iArr) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(2);
        II0xO02.Oxx0IOOO(0, context);
        II0xO02.Oxx0IOOO(1, iArr);
        this.f10816a.call(270018, II0xO02.OOXIXo(), Void.class);
    }
}
