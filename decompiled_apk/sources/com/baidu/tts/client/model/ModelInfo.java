package com.baidu.tts.client.model;

import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.baidu.tts.q2;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ModelInfo {

    /* renamed from: a, reason: collision with root package name */
    public String f10062a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;

    public String getDomain() {
        return this.h;
    }

    public String getGender() {
        return this.f;
    }

    public String getLanguage() {
        return this.e;
    }

    public String getName() {
        return this.b;
    }

    public String getQuality() {
        return this.i;
    }

    public String getServerId() {
        return this.f10062a;
    }

    public String getSpeaker() {
        return this.g;
    }

    public String getSpeechDataId() {
        return this.k;
    }

    public String getSpeechExtDataId() {
        return this.l;
    }

    public String getTacSubganSpeakerAttr() {
        return this.m;
    }

    public String getTextDataId() {
        return this.j;
    }

    public String getVersionMax() {
        return this.d;
    }

    public String getVersionMin() {
        return this.c;
    }

    public void parseJson(JSONObject jSONObject) {
        q2 q2Var = q2.ID;
        this.f10062a = jSONObject.optString("id");
        q2 q2Var2 = q2.NAME;
        this.b = jSONObject.optString("name");
        q2 q2Var3 = q2.VERSION_MIN;
        this.c = jSONObject.optString("version_min");
        q2 q2Var4 = q2.VERSION_MAX;
        this.d = jSONObject.optString("version_max");
        q2 q2Var5 = q2.LANGUAGE;
        this.e = jSONObject.optString("language");
        q2 q2Var6 = q2.GENDER;
        this.f = jSONObject.optString("gender");
        q2 q2Var7 = q2.SPEAKER;
        this.g = jSONObject.optString(TtsStatsUploadBag.KEY_SPEAKER);
        q2 q2Var8 = q2.DOMAIN;
        this.h = jSONObject.optString(ClientCookie.DOMAIN_ATTR);
        q2 q2Var9 = q2.QUALITY;
        this.i = jSONObject.optString("quality");
        q2 q2Var10 = q2.TEXT_DATA_ID;
        this.j = jSONObject.optString("text_data_id");
        q2 q2Var11 = q2.SPEECH_DATA_ID;
        this.k = jSONObject.optString("speech_data_id");
        q2 q2Var12 = q2.SPEECH_EXT_DATA_ID;
        this.l = jSONObject.optString("speech_ext_data_id");
        q2 q2Var13 = q2.TAC_SUBGAN_SPEAKER_ATTR;
        this.m = jSONObject.optString("tac_subgan_speaker_attr");
    }

    public void setDomain(String str) {
        this.h = str;
    }

    public void setGender(String str) {
        this.f = str;
    }

    public void setLanguage(String str) {
        this.e = str;
    }

    public void setMap(Map<String, String> map) {
        if (map != null) {
            q2 q2Var = q2.ID;
            this.f10062a = map.get("id");
            q2 q2Var2 = q2.NAME;
            this.b = map.get("name");
            q2 q2Var3 = q2.VERSION_MIN;
            this.c = map.get("version_min");
            q2 q2Var4 = q2.VERSION_MAX;
            this.d = map.get("version_max");
            q2 q2Var5 = q2.LANGUAGE;
            this.e = map.get("language");
            q2 q2Var6 = q2.GENDER;
            this.f = map.get("gender");
            q2 q2Var7 = q2.SPEAKER;
            this.g = map.get(TtsStatsUploadBag.KEY_SPEAKER);
            q2 q2Var8 = q2.DOMAIN;
            this.h = map.get(ClientCookie.DOMAIN_ATTR);
            q2 q2Var9 = q2.QUALITY;
            this.i = map.get("quality");
            q2 q2Var10 = q2.TEXT_DATA_ID;
            this.j = map.get("text_data_id");
            q2 q2Var11 = q2.SPEECH_DATA_ID;
            this.k = map.get("speech_data_id");
            q2 q2Var12 = q2.SPEECH_EXT_DATA_ID;
            this.l = map.get("speech_ext_data_id");
            q2 q2Var13 = q2.TAC_SUBGAN_SPEAKER_ATTR;
            this.m = map.get("tac_subgan_speaker_attr");
        }
    }

    public void setName(String str) {
        this.b = str;
    }

    public void setQuality(String str) {
        this.i = str;
    }

    public void setServerId(String str) {
        this.f10062a = str;
    }

    public void setSpeaker(String str) {
        this.g = str;
    }

    public void setSpeechDataId(String str) {
        this.k = str;
    }

    public void setTextDataId(String str) {
        this.j = str;
    }

    public void setVersionMax(String str) {
        this.d = str;
    }

    public void setVersionMin(String str) {
        this.c = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            q2 q2Var = q2.ID;
            jSONObject.putOpt("id", this.f10062a);
            q2 q2Var2 = q2.NAME;
            jSONObject.putOpt("name", this.b);
            q2 q2Var3 = q2.VERSION_MIN;
            jSONObject.putOpt("version_min", this.c);
            q2 q2Var4 = q2.VERSION_MAX;
            jSONObject.putOpt("version_max", this.d);
            q2 q2Var5 = q2.LANGUAGE;
            jSONObject.putOpt("language", this.e);
            q2 q2Var6 = q2.GENDER;
            jSONObject.putOpt("gender", this.f);
            q2 q2Var7 = q2.SPEAKER;
            jSONObject.putOpt(TtsStatsUploadBag.KEY_SPEAKER, this.g);
            q2 q2Var8 = q2.DOMAIN;
            jSONObject.putOpt(ClientCookie.DOMAIN_ATTR, this.h);
            q2 q2Var9 = q2.QUALITY;
            jSONObject.putOpt("quality", this.i);
            q2 q2Var10 = q2.TEXT_DATA_ID;
            jSONObject.putOpt("text_data_id", this.j);
            q2 q2Var11 = q2.SPEECH_DATA_ID;
            jSONObject.putOpt("speech_data_id", this.k);
            q2 q2Var12 = q2.SPEECH_EXT_DATA_ID;
            jSONObject.putOpt("speech_ext_data_id", this.l);
            q2 q2Var13 = q2.TAC_SUBGAN_SPEAKER_ATTR;
            jSONObject.putOpt("tac_subgan_speaker_attr", this.m);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
