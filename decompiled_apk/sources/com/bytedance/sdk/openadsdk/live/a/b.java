package com.bytedance.sdk.openadsdk.live.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class b implements ILiveHostActionParam {

    /* renamed from: a, reason: collision with root package name */
    private Bridge f10790a;

    public b(Bridge bridge) {
        this.f10790a = bridge;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        Bridge bridge = this.f10790a;
        if (bridge != null) {
            bridge.call(1, xXxxox0I.oIX0oI().xxIXOIIO(0, z).II0XooXoX(1, str).II0XooXoX(2, str2).Oxx0IOOO(3, map).OOXIXo(), null);
        }
    }
}
