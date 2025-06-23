package com.bytedance.sdk.openadsdk.mediation;

import XIXIX.OOXIXo;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* loaded from: classes8.dex */
public class MediationLocationProviderImpl implements Bridge, LocationProvider {

    /* renamed from: a, reason: collision with root package name */
    private LocationProvider f10807a;

    public MediationLocationProviderImpl(LocationProvider locationProvider) {
        this.f10807a = locationProvider;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8481) {
            return (T) Double.valueOf(getLatitude());
        }
        if (i == 8482) {
            return (T) Double.valueOf(getLongitude());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        LocationProvider locationProvider = this.f10807a;
        if (locationProvider != null) {
            return locationProvider.getLatitude();
        }
        return OOXIXo.f3760XO;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        LocationProvider locationProvider = this.f10807a;
        if (locationProvider != null) {
            return locationProvider.getLongitude();
        }
        return OOXIXo.f3760XO;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
