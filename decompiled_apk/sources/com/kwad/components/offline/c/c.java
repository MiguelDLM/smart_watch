package com.kwad.components.offline.c;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.g;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.core.n.b.a<ITkOfflineCompo> {
    private static long adG;
    private final List<com.kwad.components.core.n.a.d.a> adF;
    private final AtomicBoolean adH;

    /* renamed from: com.kwad.components.offline.c.c$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ ITkOfflineCompo adI;
        final /* synthetic */ boolean adJ;
        final /* synthetic */ long adK;
        final /* synthetic */ long adL;
        final /* synthetic */ Context gq;

        public AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, boolean z, long j, long j2, Context context) {
            this.adI = iTkOfflineCompo;
            this.adJ = z;
            this.adK = j;
            this.adL = j2;
            this.gq = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i) {
            c.this.au(i);
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z) {
            int i;
            try {
                final b bVar = new b(this.adI);
                com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.d.c.class, bVar);
                int i2 = 1;
                c.this.adH.set(true);
                if (z) {
                    i = 2;
                } else {
                    i = 1;
                }
                if (this.adJ) {
                    i2 = 2;
                }
                c.this.b(i, i2, SystemClock.elapsedRealtime() - this.adK, this.adL);
                TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.adL).setSoLoadTime(SystemClock.elapsedRealtime() - this.adK).setInitSdkTimeConsuming(SystemClock.elapsedRealtime() - l.zJ().Ah()).setThreadPoolCoreSize(i.xI().xC().yd()).setOfflineSource(i2).setSoSource(i).toJson());
                c.this.pm();
                g.b(new h() { // from class: com.kwad.components.offline.c.c.1.1
                    @Override // com.kwad.components.core.request.h, com.kwad.components.core.request.g.a
                    public final void d(@NonNull final SdkConfigData sdkConfigData) {
                        super.d(sdkConfigData);
                        com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.components.offline.c.c.1.1.1
                            @Override // com.kwad.sdk.utils.az
                            public final void doTask() {
                                C08211 c08211 = C08211.this;
                                bVar.onConfigRefresh(AnonymousClass1.this.gq, sdkConfigData.toJson());
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class a {
        private static final c adR = new c(0);
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void au(Context context) {
        adG = SystemClock.elapsedRealtime();
        un().init(context);
    }

    public static c un() {
        return a.adR;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.asN)).booleanValue();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pn() {
        return "TK";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String po() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pp() {
        return "3.3.64.1";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pq() {
        return " https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.64.1-30279a11a9-537.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pr() {
        return "83a61ff3bc9f6b8f92b6336d6430be8d";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String ps() {
        return "ks_tk_33641";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pt() {
        return ITkOfflineCompo.IMPL;
    }

    private c() {
        this.adF = new CopyOnWriteArrayList();
        this.adH = new AtomicBoolean(false);
    }

    public final void b(com.kwad.components.core.n.a.d.a aVar) {
        if (aVar == null) {
            return;
        }
        this.adF.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, long j, long j2) {
        Iterator<com.kwad.components.core.n.a.d.a> it = this.adF.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(i, i2, j, j2);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.b.a
    public void a(Context context, boolean z, ITkOfflineCompo iTkOfflineCompo) {
        iTkOfflineCompo.init(context, new d(), new AnonymousClass1(iTkOfflineCompo, z, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - adG, context));
    }

    public final void a(com.kwad.components.core.n.a.d.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (this.adH.get()) {
                aVar.a(1, 1, 0L, 0L);
            }
            this.adF.add(aVar);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
