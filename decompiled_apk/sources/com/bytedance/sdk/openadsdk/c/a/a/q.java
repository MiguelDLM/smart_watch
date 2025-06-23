package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTWidgetManager;
import o0.xXxxox0I;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class q extends TTWidgetManager {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10730a;

    public q(Bridge bridge) {
        this.f10730a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTWidgetManager
    public boolean updateWidgetWithType(int i, JSONObject jSONObject) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(2);
        II0xO02.X0o0xo(0, i);
        II0xO02.Oxx0IOOO(1, jSONObject);
        return ((Boolean) this.f10730a.call(264001, II0xO02.OOXIXo(), Boolean.TYPE)).booleanValue();
    }
}
