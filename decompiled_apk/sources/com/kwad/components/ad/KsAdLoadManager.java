package com.kwad.components.ad;

import androidx.annotation.NonNull;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.c.d;
import com.kwad.components.core.c.g;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.l;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class KsAdLoadManager {

    /* loaded from: classes11.dex */
    public enum Holder {
        INSTANCE;

        private final KsAdLoadManager mInstance = new KsAdLoadManager(0);

        Holder() {
        }
    }

    public /* synthetic */ KsAdLoadManager(byte b) {
        this();
    }

    public static KsAdLoadManager M() {
        return Holder.INSTANCE.mInstance;
    }

    public static void a(@NonNull com.kwad.components.core.request.model.a aVar) {
        if (!l.zJ().Ag()) {
            e eVar = e.awH;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, true);
        } else {
            if (c.b(aVar)) {
                return;
            }
            d.mX().c(aVar);
        }
    }

    public final synchronized <T> void b(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            g.nf().add(it.next());
        }
    }

    private KsAdLoadManager() {
    }

    public final synchronized <T> void a(T t) {
        g.nf().add(t);
    }
}
