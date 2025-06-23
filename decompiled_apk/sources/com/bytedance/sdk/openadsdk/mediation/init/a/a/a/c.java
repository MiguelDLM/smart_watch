package com.bytedance.sdk.openadsdk.mediation.init.a.a.a;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class c {
    public static final ValueSet a(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        xXxxox0I oIX0oI2 = xXxxox0I.oIX0oI();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        oIX0oI2.Oxx0IOOO(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        oIX0oI2.II0XooXoX(265001, mediationConfigUserInfoForSegment.getUserId());
        oIX0oI2.II0XooXoX(265002, mediationConfigUserInfoForSegment.getChannel());
        oIX0oI2.II0XooXoX(265003, mediationConfigUserInfoForSegment.getSubChannel());
        oIX0oI2.X0o0xo(265004, mediationConfigUserInfoForSegment.getAge());
        oIX0oI2.II0XooXoX(265005, mediationConfigUserInfoForSegment.getGender());
        oIX0oI2.II0XooXoX(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return oIX0oI2.OOXIXo();
    }
}
