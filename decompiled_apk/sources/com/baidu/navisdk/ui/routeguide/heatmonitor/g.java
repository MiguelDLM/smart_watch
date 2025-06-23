package com.baidu.navisdk.ui.routeguide.heatmonitor;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    private int f8626a;
    private int b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;

    @Deprecated
    private int h;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private long p;
    private int i = -1;
    private int j = -1;
    private int q = -1;

    public static g a(String str, f fVar) {
        try {
            g gVar = new g();
            JSONObject jSONObject = new JSONObject(str);
            gVar.b = jSONObject.optInt("disable_detector", -1);
            gVar.c = jSONObject.optBoolean("disable_vdr", false);
            gVar.d = jSONObject.optInt("disable_asr", -1);
            gVar.e = jSONObject.optInt("disable_poi", -1);
            gVar.f = jSONObject.optInt("link_road", -1);
            gVar.g = jSONObject.optInt("fps", -1);
            gVar.i = jSONObject.optInt("hd_fps", -1);
            gVar.j = jSONObject.optInt("hd_native_fps", -1);
            gVar.k = jSONObject.optInt("disable_animation", -1);
            gVar.l = jSONObject.optBoolean("switch_voice", false);
            gVar.o = jSONObject.optInt("expand_hide_type", -1);
            gVar.p = jSONObject.optLong("diy_model", -1L);
            gVar.m = fVar.a().d();
            gVar.n = jSONObject.optInt("avoid_expand", -1);
            gVar.q = jSONObject.optInt("nhd_fps", -1);
            return gVar;
        } catch (JSONException e) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.HEAT_MONITOR;
            if (!gVar2.d()) {
                return null;
            }
            gVar2.e("RGHMSateModel", "parseFormJson() error, json = " + str + " e = " + e);
            return null;
        }
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.k;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.e;
    }

    public long f() {
        return this.p;
    }

    public int g() {
        return this.o;
    }

    public int h() {
        return this.i;
    }

    public int i() {
        return this.j;
    }

    public int j() {
        return this.f;
    }

    public int k() {
        return this.g;
    }

    public int l() {
        return this.q;
    }

    public boolean m() {
        return this.c;
    }

    public String toString() {
        return "RGHMSateConfigModel{disableScale=" + this.f8626a + ", disableDetector=" + this.b + ", disableVDR=" + this.c + ", disableASR=" + this.d + ", disablePoi=" + this.e + ", linkRoad=" + this.f + ", mapFPS=" + this.g + ", nativeFPS=" + this.h + ", disableAni=" + this.k + ", switchVoice=" + this.l + ", recordTime=" + this.m + ", avoidExpand=" + this.n + ", nhdMapFps=" + this.q + '}';
    }

    public int a() {
        return this.n;
    }
}
