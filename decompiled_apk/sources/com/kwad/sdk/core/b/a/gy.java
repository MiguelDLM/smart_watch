package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class gy implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.axd = jSONObject.optLong("request_prepare_cost");
        jVar.axe = jSONObject.optLong("request_add_params_cost");
        jVar.axf = jSONObject.optLong("request_create_cost");
        jVar.axg = jSONObject.optInt("keep_alive");
        jVar.axh = jSONObject.optLong("dns_start");
        jVar.axi = jSONObject.optLong("dns_cost");
        jVar.axj = jSONObject.optLong("connect_establish_start");
        jVar.axk = jSONObject.optLong("connect_establish_cost");
        jVar.axl = jSONObject.optLong("request_start");
        jVar.axm = jSONObject.optLong("request_cost");
        jVar.axn = jSONObject.optLong("request_size");
        jVar.axo = jSONObject.optLong("response_start");
        jVar.axp = jSONObject.optLong("response_cost");
        jVar.axq = jSONObject.optLong("response_parse_cost");
        jVar.axr = jSONObject.optLong("response_size");
        jVar.axs = jSONObject.optLong("waiting_response_cost");
        jVar.axt = jSONObject.optLong("total_cost");
        jVar.axu = jSONObject.optInt("proxy_used");
        jVar.axv = jSONObject.optString("request_id");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(jVar.axv)) {
            jVar.axv = "";
        }
        jVar.axw = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt("result");
        jVar.axx = jSONObject.optLong("response_done_cost");
        jVar.axy = jSONObject.optString("host_ip");
        if (obj.toString().equals(jVar.axy)) {
            jVar.axy = "";
        }
        jVar.axz = jSONObject.optInt("ip_type");
        jVar.axA = jSONObject.optInt("recommend_ping_time");
        jVar.axB = jSONObject.optInt("backup_ping_time");
        jVar.axC = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = jVar.axd;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_prepare_cost", j);
        }
        long j2 = jVar.axe;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_add_params_cost", j2);
        }
        long j3 = jVar.axf;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_create_cost", j3);
        }
        int i = jVar.axg;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "keep_alive", i);
        }
        long j4 = jVar.axh;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dns_start", j4);
        }
        long j5 = jVar.axi;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dns_cost", j5);
        }
        long j6 = jVar.axj;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connect_establish_start", j6);
        }
        long j7 = jVar.axk;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connect_establish_cost", j7);
        }
        long j8 = jVar.axl;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_start", j8);
        }
        long j9 = jVar.axm;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_cost", j9);
        }
        long j10 = jVar.axn;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_size", j10);
        }
        long j11 = jVar.axo;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_start", j11);
        }
        long j12 = jVar.axp;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_cost", j12);
        }
        long j13 = jVar.axq;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_parse_cost", j13);
        }
        long j14 = jVar.axr;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_size", j14);
        }
        long j15 = jVar.axs;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "waiting_response_cost", j15);
        }
        long j16 = jVar.axt;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_cost", j16);
        }
        int i2 = jVar.axu;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "proxy_used", i2);
        }
        String str = jVar.axv;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_id", jVar.axv);
        }
        int i3 = jVar.axw;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "has_data_v2", i3);
        }
        int i4 = jVar.result;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "result", i4);
        }
        long j17 = jVar.axx;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_done_cost", j17);
        }
        String str2 = jVar.axy;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "host_ip", jVar.axy);
        }
        int i5 = jVar.axz;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ip_type", i5);
        }
        int i6 = jVar.axA;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "recommend_ping_time", i6);
        }
        int i7 = jVar.axB;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "backup_ping_time", i7);
        }
        int i8 = jVar.axC;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "other_ping_time", i8);
        }
        return jSONObject;
    }
}
