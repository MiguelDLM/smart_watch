package com.bytedance.sdk.openadsdk.a;

import android.app.Application;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.a.a;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public final class c implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f10658a;
    private b b;
    private a c = new a();

    private c() {
    }

    public static c a() {
        if (f10658a == null) {
            synchronized (c.class) {
                try {
                    if (f10658a == null) {
                        f10658a = new c();
                    }
                } finally {
                }
            }
        }
        return f10658a;
    }

    public Application.ActivityLifecycleCallbacks b() {
        return this.c;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Bridge a2;
        switch (i) {
            case 2:
                return (T) this.c.a();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                b bVar = this.b;
                if (bVar == null || (a2 = bVar.a(4)) == null) {
                    return null;
                }
                return (T) a2.call(i, valueSet, cls);
            case 9:
                Object objectValue = valueSet.objectValue(0, Object.class);
                if (!(objectValue instanceof EventListener)) {
                    return null;
                }
                a((EventListener) objectValue);
                return null;
            case 10:
                b bVar2 = this.b;
                if (bVar2 == null) {
                    return null;
                }
                return (T) bVar2.a(valueSet.intValue(0));
            default:
                return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return xXxxox0I.oIX0oI().X0o0xo(10000, 5).OOXIXo();
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    private void a(final EventListener eventListener) {
        this.c.a(new a.InterfaceC0565a() { // from class: com.bytedance.sdk.openadsdk.a.c.1
            @Override // com.bytedance.sdk.openadsdk.a.a.InterfaceC0565a
            public void a() {
                eventListener.onEvent(0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.a.a.InterfaceC0565a
            public void b() {
                eventListener.onEvent(1, null);
            }
        });
    }
}
