package com.kwad.components.core.proxy.a;

import android.os.SystemClock;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class a {
    private String RH;
    private long RI;
    private long RJ;
    private long RK;
    private boolean RL;
    private c RM;

    public a(c cVar) {
        this.RM = cVar;
    }

    public final void F(long j) {
        this.RI = j;
        this.RJ = SystemClock.uptimeMillis();
    }

    public final void aw(String str) {
        this.RH = str;
    }

    public final void qH() {
        if (this.RL) {
            return;
        }
        this.RL = true;
        bo.runOnUiThread(new az() { // from class: com.kwad.components.core.proxy.a.a.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                a.this.RK = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public final void report() {
        long j;
        long j2;
        b bVar = new b();
        bVar.RH = this.RH;
        long j3 = this.RI;
        long j4 = 0;
        if (j3 != 0) {
            j = this.RJ - j3;
        } else {
            j = 0;
        }
        bVar.RP = j;
        long j5 = this.RJ;
        if (j5 != 0) {
            j2 = this.RK - j5;
        } else {
            j2 = 0;
        }
        bVar.RQ = j2;
        if (j3 != 0) {
            j4 = this.RK - j3;
        }
        bVar.RO = j4;
        com.kwad.components.core.o.a.qI().a(bVar);
        com.kwad.sdk.core.e.c.d("PageMonitor", bVar.toString());
    }

    public final void a(PageCreateStage pageCreateStage) {
        c cVar = this.RM;
        if (cVar != null) {
            cVar.onCreateStageChange(pageCreateStage);
        }
    }
}
