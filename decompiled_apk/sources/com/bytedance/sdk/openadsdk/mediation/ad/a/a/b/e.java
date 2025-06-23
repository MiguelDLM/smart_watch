package com.bytedance.sdk.openadsdk.mediation.ad.a.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class e implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10848a = xXxxox0I.f31020I0Io;
    private final IMediationViewBinder b;

    public e(IMediationViewBinder iMediationViewBinder) {
        this.b = iMediationViewBinder;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationViewBinder iMediationViewBinder = this.b;
        if (iMediationViewBinder == null) {
            return null;
        }
        switch (i) {
            case 271021:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getLayoutId()));
            case 271022:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getTitleId()));
            case 271023:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getDecriptionTextId()));
            case 271024:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getCallToActionId()));
            case 271025:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getIconImageId()));
            case 271026:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getMainImageId()));
            case 271027:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getMediaViewId()));
            case 271028:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getSourceId()));
            case 271029:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getGroupImage1Id()));
            case 271030:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getGroupImage2Id()));
            case 271031:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getGroupImage3Id()));
            case 271032:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getLogoLayoutId()));
            case 271033:
                return (T) Integer.class.cast(Integer.valueOf(iMediationViewBinder.getShakeViewContainerId()));
            case 271034:
                return (T) iMediationViewBinder.getExtras();
            default:
                a(i, valueSet, cls);
                return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10848a;
    }
}
