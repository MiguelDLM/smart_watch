package com.kwad.components.ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.q;
import java.io.File;

/* loaded from: classes11.dex */
public final class a {
    public static Pair<Integer, String> d(@NonNull AdTemplate adTemplate) {
        String K = com.kwad.sdk.core.response.b.a.K(e.dS(adTemplate));
        int i = 2;
        if (TextUtils.isEmpty(K)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int zA = d.zA();
        long j = 0;
        int i2 = 1;
        String str = "";
        if (zA < 0) {
            File bZ = com.kwad.sdk.core.diskcache.b.a.DM().bZ(K);
            if (!q.L(bZ)) {
                a.C0856a c0856a = new a.C0856a();
                if (com.kwad.sdk.core.diskcache.b.a.DM().a(K, c0856a)) {
                    i = 1;
                }
                str = c0856a.msg;
                i2 = i;
            }
            if (bZ != null) {
                j = bZ.length();
            }
            adTemplate.setDownloadSize(j);
        } else if (zA > 0) {
            a.C0856a c0856a2 = new a.C0856a();
            f by = com.kwad.sdk.core.videocache.c.a.by(ServiceProvider.getContext());
            if (!by.eM(K)) {
                if (by.a(K, zA * 1024, c0856a2, null)) {
                    i = 1;
                }
                i2 = i;
            }
            str = c0856a2.msg;
            adTemplate.setDownloadSize(zA * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i2), str);
    }
}
