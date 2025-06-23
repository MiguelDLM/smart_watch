package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.kwad.sdk.core.scene.URLPackage;
import com.sma.smartv3.ui.me.O0OOX0IIx;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class dh implements u {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ de f6308a;

    public dh(de deVar) {
        this.f6308a = deVar;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6308a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f6308a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f6308a.E));
        hashMap.put("novel_id", this.f6308a.F);
        this.f6308a.a(de.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6308a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6308a.h()));
        hashMap.put("entry", Integer.valueOf(this.f6308a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f6308a.E));
        hashMap.put("novel_id", this.f6308a.F);
        hashMap.put("novel_info", jSONObject);
        this.f6308a.a(de.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6308a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6308a.h()));
        hashMap.put("entry", Integer.valueOf(this.f6308a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f6308a.E));
        hashMap.put("novel_id", this.f6308a.F);
        hashMap.put("novel_info", jSONObject);
        this.f6308a.a(de.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f6308a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f6308a.E));
        hashMap.put("novel_id", this.f6308a.F);
        hashMap.put("isnight", Boolean.valueOf(this.f6308a.x()));
        this.f6308a.a(de.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6308a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6308a.h()));
        hashMap.put("entry", Integer.valueOf(this.f6308a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f6308a.E));
        hashMap.put("novel_id", this.f6308a.F);
        hashMap.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, Integer.valueOf(i));
        this.f6308a.a(de.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i = this.f6308a.i("get_cuid");
        String i2 = this.f6308a.i("get_imei");
        String i3 = this.f6308a.i("get_oaid");
        try {
            jSONObject.put("cuid", i);
            jSONObject.put(O0OOX0IIx.f23381X0o0xo, i2);
            jSONObject.put("oaid", i3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(long j) {
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        CPUNovelAd.CpuNovelListener cpuNovelListener2;
        cpuNovelListener = this.f6308a.H;
        if (cpuNovelListener != null) {
            cpuNovelListener2 = this.f6308a.H;
            cpuNovelListener2.onReadTime(j);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6308a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6308a.h()));
        hashMap.put("entry", Integer.valueOf(this.f6308a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f6308a.E));
        hashMap.put("novel_id", this.f6308a.F);
        hashMap.put("count_down", Integer.valueOf(i));
        this.f6308a.a(de.x, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z) {
        SoftReference softReference;
        SoftReference softReference2;
        softReference = this.f6308a.I;
        if (softReference != null) {
            softReference2 = this.f6308a.I;
            RelativeLayout relativeLayout = (RelativeLayout) softReference2.get();
            if (relativeLayout != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("novel_activity", (Activity) this.f6308a.h);
                hashMap.put("interstitial_container", null);
                hashMap.put("banner_container", relativeLayout);
                hashMap.put("entry", Integer.valueOf(this.f6308a.D));
                hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f6308a.E));
                hashMap.put("novel_id", this.f6308a.F);
                hashMap.put("isnight", Boolean.valueOf(this.f6308a.x()));
                this.f6308a.a(de.w, hashMap);
            }
        }
    }
}
