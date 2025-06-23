package com.kwad.sdk.h;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class g {
    private String aAB;
    private String aAC;
    private JSONObject aKs;
    private boolean aKt;
    private Map<String, String> agA;
    private String appId;
    private JSONObject aqw;
    private String aux;
    private String auy;
    private String azF;
    private String sdkVersion;

    private g() {
    }

    public static g JI() {
        return new g();
    }

    public final JSONObject JJ() {
        return this.aKs;
    }

    public final boolean JK() {
        return this.aKt;
    }

    public final String JL() {
        return this.azF;
    }

    public final JSONObject JM() {
        return this.aqw;
    }

    public final g bE(boolean z) {
        this.aKt = z;
        return this;
    }

    public final g ga(String str) {
        this.appId = str;
        return this;
    }

    public final g gb(String str) {
        this.sdkVersion = str;
        return this;
    }

    public final g gc(String str) {
        this.auy = str;
        return this;
    }

    public final g gd(String str) {
        this.aAC = str;
        return this;
    }

    public final g ge(String str) {
        this.aAB = str;
        return this;
    }

    public final String getAndroidId() {
        return this.aAB;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.aAC;
    }

    public final String getImei() {
        return this.aux;
    }

    public final String getOaid() {
        return this.auy;
    }

    public final Map<String, String> getRequestHeader() {
        return this.agA;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final g gf(String str) {
        this.aux = str;
        return this;
    }

    public final g gg(String str) {
        this.azF = str;
        return this;
    }

    public final g h(Map<String, String> map) {
        this.agA = map;
        return this;
    }

    public final g m(JSONObject jSONObject) {
        this.aKs = jSONObject;
        return this;
    }

    public final g n(JSONObject jSONObject) {
        this.aqw = jSONObject;
        return this;
    }
}
