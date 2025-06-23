package com.bytedance.sdk.openadsdk.c.a.c;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class b {
    public static final ValueSet b(final AdSlot adSlot) {
        xXxxox0I oIX0oI2 = xXxxox0I.oIX0oI();
        if (adSlot == null) {
            return null;
        }
        oIX0oI2.II0XooXoX(260001, adSlot.getAdId());
        oIX0oI2.II0XooXoX(260002, adSlot.getCreativeId());
        oIX0oI2.II0XooXoX(260003, adSlot.getExt());
        oIX0oI2.II0XooXoX(260004, adSlot.getCodeId());
        oIX0oI2.xxIXOIIO(260005, adSlot.isAutoPlay());
        oIX0oI2.X0o0xo(260006, adSlot.getImgAcceptedWidth());
        oIX0oI2.X0o0xo(260007, adSlot.getImgAcceptedHeight());
        oIX0oI2.oxoX(260008, adSlot.getExpressViewAcceptedWidth());
        oIX0oI2.oxoX(260009, adSlot.getExpressViewAcceptedHeight());
        oIX0oI2.xxIXOIIO(260010, adSlot.isSupportDeepLink());
        oIX0oI2.xxIXOIIO(260011, adSlot.isSupportRenderConrol());
        oIX0oI2.X0o0xo(2600012, adSlot.getAdCount());
        oIX0oI2.II0XooXoX(260013, adSlot.getMediaExtra());
        oIX0oI2.II0XooXoX(260014, adSlot.getUserID());
        oIX0oI2.X0o0xo(260015, adSlot.getOrientation());
        oIX0oI2.X0o0xo(260016, adSlot.getNativeAdType());
        oIX0oI2.Oxx0IOOO(260017, adSlot.getExternalABVid());
        oIX0oI2.X0o0xo(260018, adSlot.getAdloadSeq());
        oIX0oI2.II0XooXoX(260019, adSlot.getPrimeRit());
        oIX0oI2.X0o0xo(260020, adSlot.getAdType());
        oIX0oI2.II0XooXoX(260021, adSlot.getBidAdm());
        oIX0oI2.II0XooXoX(260022, adSlot.getUserData());
        oIX0oI2.Oxx0IOOO(260023, adSlot.getAdLoadType());
        oIX0oI2.Oxx0IOOO(260024, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.b.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get() {
                return AdSlot.this.getRewardName();
            }
        });
        oIX0oI2.Oxx0IOOO(260025, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.b.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdSlot.this.getRewardAmount());
            }
        });
        oIX0oI2.Oxx0IOOO(260026, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.c.a.c.b.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(AdSlot.this.isSupportIconStyle());
            }
        });
        oIX0oI2.Oxx0IOOO(8260028, adSlot.getMediationAdSlot());
        return oIX0oI2.OOXIXo();
    }
}
