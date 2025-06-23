package com.kwad.sdk.core.response.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.b.a.fr;
import com.kwad.sdk.core.d;
import com.kwad.sdk.core.e.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class a implements b {
    private static final List<String> WHITE_LIST;
    private List<d<a>> mHolders;

    static {
        ArrayList arrayList = new ArrayList();
        WHITE_LIST = arrayList;
        arrayList.add("com.kwad.sdk.core.report.BaseReportAction");
    }

    private d<a> getHolder(Class<? extends a> cls) {
        if (!a.class.equals(cls) && !WHITE_LIST.contains(cls.getName())) {
            return fr.getHolder(cls);
        }
        return null;
    }

    private synchronized List<d<a>> getHolders() {
        try {
            if (this.mHolders == null) {
                this.mHolders = new ArrayList();
                for (Class<?> cls = getClass(); cls != null && a.class.isAssignableFrom(cls); cls = cls.getSuperclass()) {
                    d<a> holder = getHolder(cls);
                    if (holder != null) {
                        this.mHolders.add(0, holder);
                    }
                }
            }
            List<d<a>> list = this.mHolders;
            if (list == null || list.isEmpty()) {
                c.printStackTrace(new IllegalStateException("no holders for class: " + getClass()));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mHolders;
    }

    public void afterParseJson(@Nullable JSONObject jSONObject) {
    }

    public void afterToJson(JSONObject jSONObject) {
    }

    public void beforeToJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        List<d<a>> holders = getHolders();
        for (int size = holders.size() - 1; size >= 0; size--) {
            holders.get(size).a(this, jSONObject);
        }
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        List<d<a>> holders = getHolders();
        JSONObject jSONObject = new JSONObject();
        beforeToJson(jSONObject);
        if (holders == null) {
            return jSONObject;
        }
        for (int size = holders.size() - 1; size >= 0; size--) {
            d<a> dVar = holders.get(size);
            if (dVar != null) {
                dVar.b(this, jSONObject);
            }
        }
        afterToJson(jSONObject);
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }
}
