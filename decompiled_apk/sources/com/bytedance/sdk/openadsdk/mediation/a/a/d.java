package com.bytedance.sdk.openadsdk.mediation.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* loaded from: classes8.dex */
public class d extends com.bytedance.sdk.openadsdk.g.a.a.a.c {

    /* renamed from: a, reason: collision with root package name */
    private TTAdNative.FullScreenVideoAdListener f10825a;

    public d(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        super(fullScreenVideoAdListener);
        this.f10825a = fullScreenVideoAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.g.a.a.a.c, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 132102) {
            if (this.f10825a != null) {
                this.f10825a.onFullScreenVideoAdLoad(new m((Bridge) valueSet.objectValue(0, Bridge.class)));
                return null;
            }
        } else if (i == 132103 && this.f10825a != null) {
            this.f10825a.onFullScreenVideoCached(new m((Bridge) valueSet.objectValue(0, Bridge.class)));
            return null;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
