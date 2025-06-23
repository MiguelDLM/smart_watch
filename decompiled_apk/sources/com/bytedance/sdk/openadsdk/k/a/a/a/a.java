package com.bytedance.sdk.openadsdk.k.a.a.a;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.c.a.a.n;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10782a = xXxxox0I.f31020I0Io;
    private final TTNativeAd.AdInteractionListener b;

    public a(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.b = adInteractionListener;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.b == null) {
            return null;
        }
        switch (i) {
            case 141101:
                this.b.onAdClicked((View) valueSet.objectValue(0, View.class), new n((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 141102:
                this.b.onAdCreativeClick((View) valueSet.objectValue(0, View.class), new n((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 141103:
                this.b.onAdShow(new n((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10782a;
    }
}
