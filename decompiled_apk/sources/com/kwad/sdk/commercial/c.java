package com.kwad.sdk.commercial;

import androidx.annotation.NonNull;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c {
    public double apd = 0.01d;
    public double ape = 1.0d;
    public double apf = 0.001d;
    public BusinessType apg = BusinessType.OTHER;
    public SubBusinessType aph = SubBusinessType.OTHER;
    public com.kwai.adclient.kscommerciallogger.model.d api;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String primaryKey;
    public String tag;

    private c() {
    }

    public static c Br() {
        return new c();
    }

    public final c N(String str, String str2) {
        this.eventId = str;
        this.primaryKey = str2;
        return this;
    }

    public final c a(BusinessType businessType) {
        this.apg = businessType;
        return this;
    }

    public final c cA(String str) {
        this.tag = str;
        return this;
    }

    public final c cz(String str) {
        this.category = str;
        return this;
    }

    @Deprecated
    public final c h(JSONObject jSONObject) {
        this.msg = jSONObject;
        return this;
    }

    public final c i(double d) {
        this.apd = d;
        return this;
    }

    public final c j(double d) {
        this.ape = d;
        return this;
    }

    public final c k(double d) {
        this.apf = 0.001d;
        return this;
    }

    public final c t(com.kwad.sdk.commercial.c.a aVar) {
        this.msg = aVar.toJson();
        return this;
    }

    @NonNull
    public final String toString() {
        return "ReportItem{category='" + this.category + "', eventId='" + this.eventId + "', bizType='" + this.apg + "', primaryKey='" + this.primaryKey + "', msg=" + this.msg + '}';
    }

    public final c a(SubBusinessType subBusinessType) {
        this.aph = subBusinessType;
        return this;
    }

    public final c a(com.kwai.adclient.kscommerciallogger.model.d dVar) {
        this.api = dVar;
        return this;
    }
}
