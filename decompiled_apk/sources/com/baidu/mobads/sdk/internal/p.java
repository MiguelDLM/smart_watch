package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class p implements NativeResponse.CustomizeMediaPlayer {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6334a = "vstart";
    private static final String b = "vrepeatedplay";
    private static final String c = "vclose";
    private static final String d = "vreadyplay";
    private static final String e = "vplayfail";
    private static final String f = "vmute";
    private static final String g = "vfrozen";
    private static final String h = "vshow";
    private static final String i = "curTimeSec";
    private static final String j = "startTimeSec";
    private static final String k = "autoPlay";
    private static final String l = "reasonValue";
    private final dm m;
    private final a n;
    private boolean o = false;
    private int p = 0;

    public p(dm dmVar, a aVar) {
        this.m = dmVar;
        this.n = aVar;
    }

    private void a(String str, JSONObject jSONObject) {
        a aVar;
        JSONObject T;
        if (this.m == null || (aVar = this.n) == null || (T = aVar.T()) == null) {
            return;
        }
        try {
            T.put("msg", "sendVideoThirdLog");
            T.put("trackType", str);
            T.put("trackInfo", jSONObject);
            this.m.a(T);
        } catch (Throwable th) {
            bv.a().d(th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public String getVideoUrl() {
        a aVar = this.n;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i2) {
        a(e, a(this.p, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i2) {
        a(g, a(this.p, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        a(d, a(0, 0, false, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i2, boolean z) {
        int i3;
        int i4 = this.p;
        boolean z2 = this.o;
        if (z) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        a(f, a(i4, i2, z2, i3));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i2, NativeResponse.VideoReason videoReason) {
        a(c, a(this.p, i2, this.o, videoReason.getCode()));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        this.p = 0;
        a(b, a(0, 0, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i2) {
        this.p = i2;
        a(f6334a, a(i2, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        a(h, a(0, 0, false, 7));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z) {
        this.p = 0;
        this.o = z;
        a(f6334a, a(0, 0, z, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i2, NativeResponse.VideoReason videoReason) {
        a(c, a(this.p, i2, this.o, videoReason.getCode()));
    }

    private JSONObject a(int i2, int i3, boolean z, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(j, i2 / 1000);
            jSONObject.put(i, i3 / 1000);
            jSONObject.put(k, z);
            jSONObject.put(l, i4);
        } catch (Throwable th) {
            bv.a().d(th.getMessage());
        }
        return jSONObject;
    }
}
