package com.kwad.sdk.core.adlog.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.t;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    private final c aqB;
    private final List<com.kwad.sdk.core.adlog.a.a> aqC;

    /* loaded from: classes11.dex */
    public static final class a {
        private static final b aqE = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b BQ() {
        return a.aqE;
    }

    @Nullable
    private synchronized com.kwad.sdk.core.adlog.a.a BS() {
        if (ai.I(this.aqC)) {
            return null;
        }
        return this.aqC.remove(0);
    }

    private boolean BU() {
        c cVar = this.aqB;
        if (cVar != null && cVar.aqF) {
            return false;
        }
        return true;
    }

    public final void BR() {
        try {
            if (BU() || ai.I(this.aqC)) {
                return;
            }
            bo.runOnUiThread(new az() { // from class: com.kwad.sdk.core.adlog.a.b.2
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    com.kwad.sdk.core.adlog.b.BN();
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Nullable
    public final com.kwad.sdk.core.adlog.a.a BT() {
        com.kwad.sdk.core.adlog.a.a BS = BS();
        if (BS == null) {
            return null;
        }
        com.kwad.sdk.core.adlog.b.a.d(BS, this.aqB, this.aqC.size());
        long currentTimeMillis = System.currentTimeMillis() - BS.aqy;
        c cVar = this.aqB;
        if (currentTimeMillis > cVar.aqH * 1000) {
            com.kwad.sdk.core.adlog.b.a.b(BS, cVar, this.aqC.size(), currentTimeMillis);
            com.kwad.sdk.core.e.c.i("AdLogCacheManager", "getCache fail expired cacheTime: " + currentTimeMillis + ", adLogCache：" + BS);
            return null;
        }
        BS.retryCount++;
        com.kwad.sdk.core.adlog.b.a.a(BS, cVar, this.aqC.size(), currentTimeMillis);
        com.kwad.sdk.core.e.c.i("AdLogCacheManager", "getCache success：" + BS);
        return BS;
    }

    public final void a(@Nullable com.kwad.sdk.core.adlog.a.a aVar, String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar2, int i, String str2) {
        try {
            if (BU()) {
                return;
            }
            if (aVar == null) {
                aVar = com.kwad.sdk.core.adlog.a.a.BP().dg(str).i(jSONObject).c(aVar2).ak(System.currentTimeMillis());
            }
            aVar.cr(i).dh(str2);
            com.kwad.sdk.core.adlog.b.a.a(aVar, this.aqB, this.aqC.size());
            int i2 = aVar.retryCount;
            c cVar = this.aqB;
            if (i2 >= cVar.aqG) {
                com.kwad.sdk.core.adlog.b.a.c(aVar, cVar, this.aqC.size());
                com.kwad.sdk.core.e.c.i("AdLogCacheManager", "addCache fail limit retryCount: " + aVar.retryCount + ", log: " + aVar);
                return;
            }
            if (this.aqC.size() >= this.aqB.aqI) {
                com.kwad.sdk.core.adlog.a.a BS = BS();
                com.kwad.sdk.core.e.c.i("AdLogCacheManager", "addCache limit size: " + this.aqC.size() + ", remove log：" + BS);
                com.kwad.sdk.core.adlog.b.a.e(BS, this.aqB, this.aqC.size());
            }
            a(aVar);
            com.kwad.sdk.core.e.c.i("AdLogCacheManager", "addCache success size: " + this.aqC.size() + ", log: " + aVar);
            com.kwad.sdk.core.adlog.b.a.b(aVar, this.aqB, this.aqC.size());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private b() {
        this.aqC = new CopyOnWriteArrayList();
        this.aqB = (c) t.b(((h) ServiceProvider.get(h.class)).zE(), new com.kwad.sdk.core.c<c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            private static c BV() {
                return new c();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ c BE() {
                return BV();
            }
        });
    }

    private synchronized void a(com.kwad.sdk.core.adlog.a.a aVar) {
        this.aqC.add(aVar);
    }
}
