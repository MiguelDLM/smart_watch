package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class b<T> {
    private T auv;
    private T auw;
    private String mKey;

    public b(String str, T t) {
        this(str, t, t);
    }

    public static String dt(String str) {
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.core.a.c.dR(str);
        }
        return str;
    }

    public static String du(String str) {
        if (!TextUtils.isEmpty(str) && com.kwad.sdk.core.a.c.dT(str)) {
            return com.kwad.sdk.core.a.c.dS(str);
        }
        return str;
    }

    public final T Dr() {
        return this.auv;
    }

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public final String getKey() {
        return this.mKey;
    }

    @Nullable
    public T getValue() {
        return this.auw;
    }

    public abstract void k(JSONObject jSONObject);

    public void setValue(T t) {
        this.auw = t;
    }

    private b(String str, T t, T t2) {
        this.mKey = str;
        this.auw = t;
        this.auv = t2;
        com.kwad.sdk.core.config.b.a(this);
    }
}
