package com.kwad.library.solder.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.b.c;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;

/* loaded from: classes11.dex */
public final class a {
    public static void a(Context context, @NonNull b bVar, b.c cVar) {
        i.xI().a(context, new c(bVar), cVar);
    }

    public static com.kwad.library.b.a j(Context context, String str) {
        com.kwad.library.solder.lib.a.a l = i.xI().l(context, str);
        if (l != null && l.isLoaded() && (l instanceof com.kwad.library.b.a)) {
            return (com.kwad.library.b.a) l;
        }
        return null;
    }

    public static void k(Context context, String str) {
        i.xI().k(context, str);
    }

    public static void a(Context context, @NonNull com.kwad.library.solder.lib.c.b bVar, b.a aVar) {
        i.xI().a(context, new com.kwad.library.solder.lib.b.a(bVar), aVar);
    }
}
