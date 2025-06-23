package com.bytedance.sdk.openadsdk.f.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10770a = xXxxox0I.f31020I0Io;
    private final TTAdDislike.DislikeInteractionCallback b;

    public a(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.b = dislikeInteractionCallback;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.b;
        if (dislikeInteractionCallback == null) {
            return null;
        }
        switch (i) {
            case 244101:
                dislikeInteractionCallback.onShow();
                break;
            case 244102:
                this.b.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class), valueSet.booleanValue(2));
                break;
            case 244103:
                dislikeInteractionCallback.onCancel();
                break;
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10770a;
    }
}
