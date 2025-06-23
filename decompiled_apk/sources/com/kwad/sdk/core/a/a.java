package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.p;
import java.util.Map;

/* loaded from: classes11.dex */
public final class a implements g {
    private static String avX;

    private static String Eb() {
        if (!TextUtils.isEmpty(avX)) {
            return avX;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        String str = context.getPackageName() + bd.dh(context);
        avX = str;
        return str;
    }

    @Override // com.kwad.sdk.core.a.g
    public final void a(String str, Map<String, String> map, String str2) {
        f.a(str, map, str2);
    }

    @Override // com.kwad.sdk.core.a.g
    public final String am(String str) {
        try {
            String dY = p.dY(0);
            return new String(c.Ec().encode(b.d(dY.getBytes("UTF-8"), b.f(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.g
    public final void g(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", Eb());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.a.g
    public final String getResponseData(String str) {
        try {
            return new String(b.g(b.a(p.dY(0), c.Ee().decode(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
