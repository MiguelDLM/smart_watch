package com.kwad.components.core.request;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.x;
import com.kwad.sdk.utils.y;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class g {
    private static final AtomicBoolean sHasInit = new AtomicBoolean();
    private static volatile boolean RZ = false;
    private static final List<a> Sa = new CopyOnWriteArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void d(@NonNull SdkConfigData sdkConfigData);

        void qW();
    }

    /* loaded from: classes11.dex */
    public interface b extends a {
        void qX();
    }

    public static synchronized void a(a aVar) {
        synchronized (g.class) {
            com.kwad.sdk.core.e.c.d("ConfigRequestManager", "init config");
            if (sHasInit.get()) {
                com.kwad.sdk.core.e.c.d("ConfigRequestManager", "config request manager has init");
            } else {
                Sa.add(aVar);
                com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.components.core.request.g.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        Context Lw = ServiceProvider.Lw();
                        y.l(Lw, y.cn(Lw) + 1);
                        com.kwad.sdk.core.config.d.bf(Lw);
                        g.qS();
                        g.qR();
                    }
                });
            }
        }
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        RZ = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(int i, String str) {
        for (a aVar : Sa) {
            try {
                if (aVar instanceof b) {
                    ((b) aVar).qX();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static void qR() {
        com.kwad.sdk.core.e.c.d("ConfigRequestManager", "requestConfig");
        new l<f, SdkConfigData>() { // from class: com.kwad.components.core.request.g.2
            @NonNull
            private static SdkConfigData ax(String str) {
                SdkConfigData sdkConfigData = new SdkConfigData();
                try {
                    y.ak(ServiceProvider.Lw(), str);
                    sdkConfigData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
                return sdkConfigData;
            }

            @NonNull
            private static f qV() {
                return new f();
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ com.kwad.sdk.core.network.f createRequest() {
                return qV();
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ SdkConfigData parseData(String str) {
                return ax(str);
            }
        }.request(new o<f, SdkConfigData>() { // from class: com.kwad.components.core.request.g.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull f fVar, int i, String str) {
                super.onError(fVar, i, str);
                com.kwad.sdk.core.e.c.d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                g.m(i, str);
            }

            private static void c(@NonNull SdkConfigData sdkConfigData) {
                try {
                    com.kwad.sdk.core.e.c.T("ConfigRequestManager", "load config success");
                    com.kwad.sdk.core.config.b.bd(ServiceProvider.Lw());
                    com.kwad.sdk.core.config.d.f(sdkConfigData);
                    g.access$102(true);
                    g.a(sdkConfigData);
                    x.Mi();
                    x.Mc();
                    y.l(ServiceProvider.Lw(), 0);
                    g.sHasInit.set(true);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                c((SdkConfigData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qS() {
        Iterator<a> it = Sa.iterator();
        while (it.hasNext()) {
            try {
                it.next().qW();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static void b(a aVar) {
        try {
            Sa.add(aVar);
            if (com.kwad.sdk.core.config.d.isLoaded()) {
                aVar.qW();
            }
            if (RZ) {
                aVar.d(com.kwad.sdk.core.config.d.CK());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull SdkConfigData sdkConfigData) {
        Iterator<a> it = Sa.iterator();
        while (it.hasNext()) {
            try {
                it.next().d(sdkConfigData);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
