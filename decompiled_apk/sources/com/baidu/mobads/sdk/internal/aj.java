package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.kwad.sdk.core.scene.URLPackage;
import com.sma.smartv3.ui.me.O0OOX0IIx;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class aj implements u {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f6224a;

    public aj(ae aeVar) {
        this.f6224a = aeVar;
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
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6224a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6224a.h()));
        hashMap.put("entry", 2);
        iArr = this.f6224a.t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f6224a.a(de.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6224a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f6224a.t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        this.f6224a.a(de.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6224a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6224a.h()));
        hashMap.put("entry", 2);
        iArr = this.f6224a.t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f6224a.a(de.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f6224a.t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        this.f6224a.a(de.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6224a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6224a.h()));
        hashMap.put("entry", 2);
        iArr = this.f6224a.t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, Integer.valueOf(i));
        this.f6224a.a(de.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i = this.f6224a.i("get_cuid");
        String i2 = this.f6224a.i("get_imei");
        String i3 = this.f6224a.i("get_oaid");
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
        this.f6224a.i.a("单次阅读器打开时长 = " + j);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, int i) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6224a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6224a.h()));
        hashMap.put("entry", 2);
        iArr = this.f6224a.t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("count_down", Integer.valueOf(i));
        this.f6224a.a(de.x, hashMap);
    }
}
