package com.bytedance.sdk.openadsdk.mediation.ad.a.a.b;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class f implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10849a = xXxxox0I.f31020I0Io;
    private final MediationExpressRenderListener b;

    public f(MediationExpressRenderListener mediationExpressRenderListener) {
        this.b = mediationExpressRenderListener;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        MediationExpressRenderListener mediationExpressRenderListener = this.b;
        if (mediationExpressRenderListener == null) {
            return null;
        }
        switch (i) {
            case 142101:
                this.b.onRenderSuccess((View) valueSet.objectValue(0, View.class), valueSet.floatValue(1), valueSet.floatValue(2), valueSet.booleanValue(3));
                break;
            case 142102:
                this.b.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), valueSet.intValue(2));
                break;
            case 142103:
                mediationExpressRenderListener.onAdClick();
                break;
            case 142104:
                mediationExpressRenderListener.onAdShow();
                break;
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10849a;
    }
}
