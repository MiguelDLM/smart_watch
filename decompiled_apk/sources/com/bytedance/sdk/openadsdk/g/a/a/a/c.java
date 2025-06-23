package com.bytedance.sdk.openadsdk.g.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.c.a.a.l;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class c implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10773a = xXxxox0I.f31020I0Io;
    private final TTAdNative.FullScreenVideoAdListener b;

    public c(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.b = fullScreenVideoAdListener;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = this.b;
        if (fullScreenVideoAdListener == null) {
            return null;
        }
        switch (i) {
            case 132101:
                this.b.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 132102:
                this.b.onFullScreenVideoAdLoad(new l((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132103:
                this.b.onFullScreenVideoCached(new l((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132104:
                fullScreenVideoAdListener.onFullScreenVideoCached();
                break;
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10773a;
    }
}
