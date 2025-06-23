package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.kwad.sdk.core.scene.URLPackage;
import com.sma.smartv3.ui.me.O0OOX0IIx;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class cz implements u {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f6300a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ cv d;

    public cz(cv cvVar, int i, int i2, String str) {
        this.d = cvVar;
        this.f6300a = i;
        this.b = i2;
        this.c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.d.f());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.d.g()));
        hashMap.put("entry", Integer.valueOf(this.f6300a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        hashMap.put("novel_info", jSONObject);
        this.d.a(de.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f6300a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        this.d.a(de.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.d.g()));
        hashMap.put("entry", Integer.valueOf(this.f6300a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        hashMap.put("novel_info", jSONObject);
        this.d.a(de.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f6300a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        this.d.a(de.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.d.f());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.d.g()));
        hashMap.put("entry", Integer.valueOf(this.f6300a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        hashMap.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, Integer.valueOf(i));
        this.d.a(de.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i = this.d.i("get_cuid");
        String i2 = this.d.i("get_imei");
        String i3 = this.d.i("get_oaid");
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
        this.d.i.a("单次阅读器打开时长 = " + j);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.d.g()));
        hashMap.put("entry", Integer.valueOf(this.f6300a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        hashMap.put("count_down", Integer.valueOf(i));
        this.d.a(de.x, hashMap);
    }
}
