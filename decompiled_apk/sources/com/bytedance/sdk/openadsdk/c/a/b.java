package com.bytedance.sdk.openadsdk.c.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.lang.reflect.Method;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class b implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10731a = xXxxox0I.f31020I0Io;
    private final TTAdNative.CSJSplashAdListener b;

    public b(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.b = cSJSplashAdListener;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.b == null) {
            return null;
        }
        switch (i) {
            case 114102:
                Bridge bridge = (Bridge) valueSet.objectValue(0, Bridge.class);
                com.bytedance.sdk.openadsdk.c.a.a.b bVar = new com.bytedance.sdk.openadsdk.c.a.a.b(bridge);
                if (bridge != null) {
                    try {
                        if (bridge.values().intValue(1) >= 5700) {
                            this.b.onSplashLoadSuccess(bVar);
                        } else {
                            Method declaredMethod = this.b.getClass().getDeclaredMethod("onSplashLoadSuccess", null);
                            if (declaredMethod != null) {
                                declaredMethod.invoke(this.b, null);
                            }
                        }
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
                break;
            case 114103:
                this.b.onSplashLoadFail(new com.bytedance.sdk.openadsdk.c.a.a.a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114104:
                this.b.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.c.a.a.b((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114105:
                this.b.onSplashRenderFail(new com.bytedance.sdk.openadsdk.c.a.a.b((Bridge) valueSet.objectValue(0, Bridge.class)), new com.bytedance.sdk.openadsdk.c.a.a.a((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10731a;
    }
}
