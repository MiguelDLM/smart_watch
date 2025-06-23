package com.bytedance.sdk.openadsdk.c.a.c;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class c {
    public static final ValueSet a(LocationProvider locationProvider) {
        xXxxox0I oIX0oI2 = xXxxox0I.oIX0oI();
        if (locationProvider == null) {
            return null;
        }
        oIX0oI2.I0Io(262001, locationProvider.getLatitude());
        oIX0oI2.I0Io(262002, locationProvider.getLongitude());
        return oIX0oI2.OOXIXo();
    }
}
