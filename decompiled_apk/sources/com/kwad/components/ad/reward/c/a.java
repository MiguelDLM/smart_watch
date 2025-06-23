package com.kwad.components.ad.reward.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.v;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public class a {
    private static volatile a ri;
    private g qp;

    @Nullable
    private b rj;
    private volatile boolean rk = false;
    private volatile boolean rl = false;
    private List<WeakReference<h>> rm = new CopyOnWriteArrayList();

    private a() {
    }

    public static a gM() {
        if (ri == null) {
            synchronized (a.class) {
                try {
                    if (ri == null) {
                        ri = new a();
                    }
                } finally {
                }
            }
        }
        return ri;
    }

    private synchronized boolean gO() {
        b bVar = this.rj;
        if (bVar != null) {
            if (bVar.rq == b.rn) {
                return true;
            }
        }
        return false;
    }

    private boolean isNeoScan() {
        AdGlobalConfigInfo adGlobalConfigInfo = this.qp.mAdResultData.adGlobalConfigInfo;
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            return true;
        }
        return false;
    }

    public final void M(Context context) {
        boolean gO = gO();
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + gO + ", hadToast: " + this.rl);
        if (!this.rl && gO) {
            this.rl = true;
            v.P(context, "恭喜获得第2份奖励");
        }
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        if (adTemplate == null) {
            return;
        }
        try {
            com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
            this.rj = bVar;
            if (bVar.rq == b.rn && !this.rk) {
                this.rk = true;
                c.a(this.rj, com.kwad.components.ad.reward.e.f.H(adTemplate.getUniqueId()));
                com.kwad.sdk.core.adlog.c.j(adTemplate, isNeoScan());
            }
            for (WeakReference<h> weakReference : this.rm) {
                if (weakReference.get() == null) {
                    this.rm.remove(weakReference);
                } else {
                    b gN = gN();
                    com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + gN.toJson().toString());
                    weakReference.get().a(gN);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + i);
        g gVar = this.qp;
        if (gVar != null && gVar.fO() && i == b.STATUS_NONE) {
            com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        b gN = gM().gN();
        gN.M(i);
        gM().a(adTemplate, gN);
    }

    @NonNull
    public final synchronized b gN() {
        try {
            if (this.rj == null) {
                b gQ = c.gQ();
                this.rj = gQ;
                gQ.rq = 0;
            }
            com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.rj.rq);
        } catch (Throwable th) {
            throw th;
        }
        return this.rj;
    }

    public final synchronized void reset() {
        this.rj = null;
        this.rl = false;
        this.rk = false;
        this.qp = null;
    }

    public final void setCallerContext(g gVar) {
        this.qp = gVar;
    }

    public final void a(h hVar) {
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + hVar);
        if (hVar != null) {
            this.rm.add(new WeakReference<>(hVar));
        }
    }
}
