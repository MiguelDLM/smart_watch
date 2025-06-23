package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class MediationUserInfoForSegmentImpl implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private MediationConfigUserInfoForSegment f10814a;

    public MediationUserInfoForSegmentImpl(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        this.f10814a = mediationConfigUserInfoForSegment;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        Map<String, String> hashMap;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment = this.f10814a;
        if (mediationConfigUserInfoForSegment != null) {
            hashMap = mediationConfigUserInfoForSegment.getCustomInfos();
        } else {
            hashMap = new HashMap<>();
        }
        create.add(8468, hashMap);
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment2 = this.f10814a;
        if (mediationConfigUserInfoForSegment2 != null) {
            i = mediationConfigUserInfoForSegment2.getAge();
        } else {
            i = 0;
        }
        create.add(8469, i);
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment3 = this.f10814a;
        String str5 = "";
        if (mediationConfigUserInfoForSegment3 == null) {
            str = "";
        } else {
            str = mediationConfigUserInfoForSegment3.getChannel();
        }
        create.add(8470, str);
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment4 = this.f10814a;
        if (mediationConfigUserInfoForSegment4 == null) {
            str2 = "";
        } else {
            str2 = mediationConfigUserInfoForSegment4.getSubChannel();
        }
        create.add(8471, str2);
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment5 = this.f10814a;
        if (mediationConfigUserInfoForSegment5 == null) {
            str3 = "";
        } else {
            str3 = mediationConfigUserInfoForSegment5.getUserId();
        }
        create.add(8472, str3);
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment6 = this.f10814a;
        if (mediationConfigUserInfoForSegment6 == null) {
            str4 = "";
        } else {
            str4 = mediationConfigUserInfoForSegment6.getGender();
        }
        create.add(8473, str4);
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment7 = this.f10814a;
        if (mediationConfigUserInfoForSegment7 != null) {
            str5 = mediationConfigUserInfoForSegment7.getUserValueGroup();
        }
        create.add(8474, str5);
        return create.build();
    }
}
