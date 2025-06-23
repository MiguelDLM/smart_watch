package com.kwad.sdk.kgeo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.b;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.kgeo.c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    private static String aKd;
    private static KGeoInfo aKe;
    private static final AtomicBoolean aKf = new AtomicBoolean();

    @Nullable
    public static KGeoInfo JD() {
        return aKe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void JE() {
        try {
            if (aKf.getAndSet(true)) {
                return;
            }
            c.a(ServiceProvider.Lw(), new c.a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.c.a
                public final void HZ() {
                    a.JF();
                }

                @Override // com.kwad.sdk.kgeo.c.a
                public final void onSuccess(String str) {
                    String unused = a.aKd = str;
                    a.JF();
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void JF() {
        try {
            new l<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                @NonNull
                private static KGeoResultData fZ(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public final f createRequest() {
                    return new b();
                }

                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ KGeoResultData parseData(String str) {
                    return fZ(str);
                }
            }.request(new o<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                private static void a(@NonNull KGeoResultData kGeoResultData) {
                    KGeoInfo unused = a.aKe = kGeoResultData.kGeoInfo;
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                    a((KGeoResultData) baseResultData);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void dC(int i) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            JE();
        } else if (i == 2) {
            com.kwad.components.core.request.b.qN().a(new b.a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.b.a
                public final void qP() {
                    com.kwad.components.core.request.b.qN().b(this);
                    a.JE();
                }
            });
        }
    }

    @Nullable
    public static String yZ() {
        return aKd;
    }
}
