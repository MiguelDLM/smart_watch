package com.kwad.sdk.core.video.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class e {
    private static boolean Uw = false;
    private static AtomicBoolean aCD = null;
    private static int aCE = -1;
    private static final AtomicBoolean aCF = new AtomicBoolean(false);
    private static final AtomicBoolean aCG = new AtomicBoolean(false);
    private static int aCH;

    private static boolean Bf() {
        if (!aCG.get() && !com.kwad.framework.a.a.IX.booleanValue()) {
            return false;
        }
        return true;
    }

    public static int GP() {
        return aCH;
    }

    private static boolean GQ() {
        AtomicBoolean atomicBoolean = aCD;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aCD = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c a(@NonNull Context context, boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        b bVar;
        boolean z5;
        b bVar2;
        try {
            if (Bf() && z2 && GQ()) {
                com.kwad.sdk.core.e.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i);
                aCH = 2;
                dVar.bn(z);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.e.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar3 = new b();
                aCH = 1;
                bVar2 = bVar3;
            }
            z4 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!Uw) {
                Uw = true;
                com.kwad.sdk.service.c.gatherException(th);
            }
            b bVar4 = new b();
            aCH = 1;
            z4 = true;
            bVar = bVar4;
        }
        if (ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yV()) {
            z5 = true;
        } else {
            z5 = false;
        }
        int a2 = ao.a(Bf(), z5, z2, GQ(), z4, z3, bVar.getMediaPlayerType());
        com.kwad.sdk.core.e.c.T("KwaiPlayHelper", "player v=" + Integer.toBinaryString(a2));
        if (aCE != a2) {
            aCE = a2;
            dq(a2);
        }
        return bVar;
    }

    private static void dq(int i) {
        n nVar = new n(10212L);
        nVar.azC = i;
        g.a2(nVar);
    }
}
