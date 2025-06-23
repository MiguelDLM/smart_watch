package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class o extends b<String> {
    private static volatile String[] auD;

    public o(String str, String str2) {
        super(str, str2);
        auD = null;
    }

    public static boolean aa(long j) {
        if (auD == null) {
            return false;
        }
        for (String str : auD) {
            if (str != null && String.valueOf(j).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    private static void dw(String str) {
        if (!TextUtils.isEmpty(str)) {
            auD = str.split(",");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), Dr());
        setValue(string);
        dw(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(getKey(), Dr());
            setValue(optString);
            dw(optString);
            return;
        }
        setValue(Dr());
    }
}
