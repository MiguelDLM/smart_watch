package com.bytedance.sdk.openadsdk.i.a.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.c.a.a.k;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10779a = xXxxox0I.f31020I0Io;
    private final TTFeedAd.VideoAdListener b;

    public a(TTFeedAd.VideoAdListener videoAdListener) {
        this.b = videoAdListener;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.b == null) {
            return null;
        }
        switch (i) {
            case 161101:
                this.b.onVideoLoad(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161102:
                this.b.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 161103:
                this.b.onVideoAdPaused(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161104:
                this.b.onVideoAdStartPlay(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161105:
                this.b.onVideoAdContinuePlay(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161106:
                this.b.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 161107:
                this.b.onVideoAdComplete(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10779a;
    }
}
