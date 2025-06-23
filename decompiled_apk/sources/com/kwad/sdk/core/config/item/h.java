package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class h extends b<a> {

    @KsJson
    /* loaded from: classes11.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String aux = "";
        public String auy = "";
    }

    public h() {
        super("idMapping", new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        a value = getValue();
        if (value == null) {
            value = new a();
        }
        String string = sharedPreferences.getString(getKey(), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                value.parseJson(new JSONObject(b.du(string)));
            } catch (JSONException e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() != null && getValue().toJson() != null) {
            editor.putString(getKey(), b.dt(getValue().toJson().toString()));
        } else {
            editor.putString(getKey(), "");
        }
    }

    public final String getImei() {
        a value = getValue();
        if (value != null && !TextUtils.isEmpty(value.aux)) {
            return value.aux;
        }
        return "";
    }

    public final String getOaid() {
        a value = getValue();
        if (value != null && !TextUtils.isEmpty(value.auy)) {
            return value.auy;
        }
        return "";
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(getKey());
        if (optJSONObject == null) {
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }
}
