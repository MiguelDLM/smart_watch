package com.kwad.components.ad.reward.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.l;
import com.kwad.sdk.utils.h;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class e {
    private g qp;

    @Nullable
    private com.kwad.components.ad.reward.f.a xU;

    @Nullable
    private d xV;

    @Nullable
    private b xW;

    /* renamed from: xX, reason: collision with root package name */
    @NonNull
    private com.kwad.components.ad.k.a f18448xX;
    private int xT = 0;
    private int xY = 0;
    private List<l> xZ = new CopyOnWriteArrayList();

    public e(g gVar) {
        this.qp = gVar;
        this.f18448xX = new a(gVar.mAdTemplate);
    }

    private com.kwad.components.ad.k.a jM() {
        return this.f18448xX;
    }

    public final void a(int i, com.kwad.components.ad.k.a aVar) {
        this.xT = i;
        if (i == 1) {
            this.xV = (d) aVar;
        } else if (i == 2) {
            this.xU = (com.kwad.components.ad.reward.f.a) aVar;
        } else if (i == 3) {
            this.xW = (b) aVar;
        }
        this.f18448xX = aVar;
        Iterator<l> it = this.xZ.iterator();
        while (it.hasNext()) {
            this.f18448xX.b(it.next());
        }
        this.xZ.clear();
    }

    public final void b(@Nullable l lVar) {
        jM().a(lVar);
        if (lVar != null) {
            this.xZ.remove(lVar);
        }
    }

    public final long getPlayDuration() {
        return jM().getPlayDuration();
    }

    public final void jJ() {
        d dVar = this.xV;
        if (dVar != null) {
            dVar.jJ();
        } else {
            b bVar = this.xW;
            if (bVar != null) {
                bVar.jJ();
            }
        }
        this.qp.fz();
    }

    public final void jK() {
        d dVar = this.xV;
        if (dVar != null) {
            dVar.jK();
        }
    }

    public final boolean jN() {
        if (this.xU != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final com.kwad.components.ad.reward.f.a jO() {
        return this.xU;
    }

    @Nullable
    public final b jP() {
        return this.xW;
    }

    public final void pause() {
        jM().pause();
    }

    public final void release() {
        jM().release();
    }

    public final void resume() {
        int i;
        boolean z;
        jM().resume();
        com.kwad.components.ad.reward.f.a aVar = this.xU;
        if (aVar != null && (i = this.xY) > 0) {
            if (i == 2) {
                z = true;
            } else {
                z = false;
            }
            aVar.setAudioEnabled(z, false);
        }
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        int i;
        if (z) {
            i = 2;
        } else {
            i = 1;
        }
        this.xY = i;
        jM().setAudioEnabled(z, z2);
    }

    public final void skipToEnd() {
        jM().skipToEnd();
    }

    public final void b(h.a aVar) {
        d dVar = this.xV;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final void a(@Nullable l lVar) {
        if (jM().jI()) {
            this.xZ.add(lVar);
        } else {
            jM().b(lVar);
        }
    }

    public final void a(h.a aVar) {
        d dVar = this.xV;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }
}
