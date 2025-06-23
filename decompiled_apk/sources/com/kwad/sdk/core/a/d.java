package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import java.util.Map;

/* loaded from: classes11.dex */
public final class d {
    private static g awl;

    public static void a(String str, Map<String, String> map, String str2) {
        oW().a(str, map, str2);
    }

    public static String am(String str) {
        return oW().am(str);
    }

    public static void g(@NonNull Map<String, String> map) {
        oW().g(map);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return oW().getResponseData(str);
    }

    private static g oW() {
        g gVar = awl;
        if (gVar != null) {
            return gVar;
        }
        com.kwad.sdk.components.g gVar2 = (com.kwad.sdk.components.g) com.kwad.sdk.components.c.f(com.kwad.sdk.components.g.class);
        if (gVar2 != null) {
            gVar2.oW();
            awl = gVar2.oW();
        } else {
            awl = new a();
        }
        return awl;
    }
}
