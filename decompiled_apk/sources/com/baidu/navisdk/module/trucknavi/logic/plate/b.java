package com.baidu.navisdk.module.trucknavi.logic.plate;

import com.baidu.navisdk.adapter.struct.VehicleConstant;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f7579a = "";
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public void a(String str) {
        this.f7579a = str;
    }

    public void b(int i) {
        this.i = i;
    }

    public void c(int i) {
        this.d = i;
    }

    public void d(int i) {
        this.b = i;
    }

    public void e(int i) {
        this.f = i;
    }

    public void f(int i) {
        this.h = i;
    }

    public void g(int i) {
        this.e = i;
    }

    public void h(int i) {
        this.c = i;
    }

    public String toString() {
        return "TruckPlateInfo{plate='" + this.f7579a + "', length=" + this.b + ", width=" + this.c + ", height=" + this.d + ", weight=" + this.e + ", load=" + this.f + ", axleNumber=" + this.g + ", truckType=" + this.h + ", emission=" + this.i + '}';
    }

    public void a(int i) {
        this.g = i;
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plate", this.f7579a);
            jSONObject.put("length", this.b);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.c);
            jSONObject.put("height", this.d);
            jSONObject.put("weight", this.e);
            jSONObject.put("load", this.f);
            jSONObject.put(VehicleConstant.PlateBundleKey.AXLE_NUMBER, this.g);
            jSONObject.put(VehicleConstant.PlateBundleKey.TRUCK_TYPE, this.h);
            jSONObject.put("emission", this.i);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
