package com.baidu.navisdk.module.ar.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;
import o0oIxXOx.oO;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private String f6991a;

    @oOoXoXO
    private String b;

    @oOoXoXO
    private String c;

    @oOoXoXO
    private String d;

    @oOoXoXO
    private String e;

    @oOoXoXO
    private String f;

    @oOoXoXO
    private String g;
    private int h = 65793;

    @oOoXoXO
    private String i = "";

    @OOXIXo
    private String j = "android";

    @OOXIXo
    private String k = "";

    private final String j(String str) {
        if (str != null) {
            return (String) StringsKt__StringsKt.XXoO0oX(str, new String[]{"/"}, false, 0, 6, null).get(r8.size() - 2);
        }
        return "";
    }

    public final void a(int i) {
        this.h = i;
    }

    public final void b(@oOoXoXO String str) {
        this.i = str;
    }

    public final void c(@oOoXoXO String str) {
        this.c = str;
    }

    public final void d(@oOoXoXO String str) {
        this.d = str;
    }

    public final void e(@oOoXoXO String str) {
        this.f6991a = str;
    }

    public final void f(@oOoXoXO String str) {
        this.b = str;
    }

    public final void g(@oOoXoXO String str) {
        this.g = str;
    }

    public final void h(@oOoXoXO String str) {
        this.e = str;
    }

    public final void i(@oOoXoXO String str) {
        this.f = str;
    }

    public final void a(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.k = str;
    }

    @OOXIXo
    public final String b() {
        JSONObject put;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("day", 0);
        jSONObject.put("cuid", this.i);
        jSONObject.put(oO.f31192XO, this.j);
        jSONObject.put(HttpConstants.APP_VERSION, this.k);
        jSONObject.put("model_version", this.h);
        jSONObject.put("output_dir", this.g);
        jSONObject.put("engine_resource_path", this.g);
        if (TextUtils.isEmpty(this.b)) {
            jSONObject.put("detector_model_path", this.f6991a);
            jSONObject.put("detector_model_md5", j(this.f6991a));
        } else {
            jSONObject.put("detector_model_path", this.b);
            jSONObject.put("detector_model_md5", j(this.b));
        }
        if (TextUtils.isEmpty(this.d)) {
            jSONObject.put("lanesegment_model_path", this.c);
            jSONObject.put("lanesegment_model_md5", j(this.c));
        } else {
            jSONObject.put("lanesegment_model_path", this.d);
            jSONObject.put("lanesegment_model_md5", j(this.d));
        }
        if (TextUtils.isEmpty(this.f)) {
            jSONObject.put("traffic_model_path", this.e);
            put = jSONObject.put("traffic_model_md5", j(this.e));
        } else {
            jSONObject.put("traffic_model_path", this.f);
            put = jSONObject.put("traffic_model_md5", j(this.f));
        }
        String jSONObject2 = put.toString();
        IIX0o.oO(jSONObject2, "root.toString()");
        return jSONObject2;
    }

    @OOXIXo
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("day", 1);
        jSONObject.put("cuid", this.i);
        jSONObject.put(oO.f31192XO, this.j);
        jSONObject.put(HttpConstants.APP_VERSION, this.k);
        jSONObject.put("model_version", this.h);
        jSONObject.put("output_dir", this.g);
        jSONObject.put("engine_resource_path", this.g);
        jSONObject.put("detector_model_path", this.f6991a);
        jSONObject.put("detector_model_md5", j(this.f6991a));
        jSONObject.put("lanesegment_model_path", this.c);
        jSONObject.put("lanesegment_model_md5", j(this.c));
        jSONObject.put("traffic_model_path", this.e);
        String jSONObject2 = jSONObject.put("traffic_model_md5", j(this.e)).toString();
        IIX0o.oO(jSONObject2, "root.toString()");
        return jSONObject2;
    }
}
