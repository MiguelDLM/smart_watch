package com.kwad.components.core.n.b;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.n.b.a.j;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.c.c;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class b {
    private static final AtomicBoolean Kc = new AtomicBoolean();

    @ForInvoker(methodId = "initOC")
    public static void an(Context context) {
        com.kwad.components.offline.a.b.au(context);
        com.kwad.components.offline.b.b.au(context);
        c.au(context);
    }

    public static void init(final Context context) {
        AtomicBoolean atomicBoolean = Kc;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        OfflineHostProvider.get().init(context, new j());
        g.execute(new az() { // from class: com.kwad.components.core.n.b.b.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                b.an(context);
            }
        });
    }
}
