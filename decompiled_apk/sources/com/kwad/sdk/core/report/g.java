package com.kwad.sdk.core.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public class g extends b<n, f> {
    private static volatile boolean ayN = false;
    private static volatile g ayO;
    private static r<n, f> ayP;

    private g() {
    }

    private static g Ft() {
        if (ayO == null) {
            synchronized (g.class) {
                try {
                    if (ayO == null) {
                        ayO = new g();
                    }
                } finally {
                }
            }
        }
        ayO.checkInit();
        return ayO;
    }

    private static boolean aa(long j) {
        s sVar = (s) ServiceProvider.get(s.class);
        if (sVar != null && sVar.aa(j)) {
            return true;
        }
        return false;
    }

    private void b(final n nVar, boolean z) {
        if (nVar == null || !ayN) {
            return;
        }
        if (!z && !aa(nVar.actionType)) {
            ayO.a(new k<n>() { // from class: com.kwad.sdk.core.report.g.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* renamed from: Fu, reason: merged with bridge method [inline-methods] */
                public n Fp() {
                    return nVar.Fw();
                }
            });
        } else {
            ayO.b(new k<n>() { // from class: com.kwad.sdk.core.report.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* renamed from: Fu, reason: merged with bridge method [inline-methods] */
                public n Fp() {
                    return nVar.Fw();
                }
            });
        }
    }

    private synchronized void checkInit() {
        try {
            if (ayN) {
                return;
            }
            com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
            if (fVar == null) {
                return;
            }
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar == null) {
                return;
            }
            Context context = fVar.getContext();
            if (context == null) {
                return;
            }
            int aD = hVar.aD(context);
            j(context, aD);
            t.init(context);
            t.FC();
            com.kwad.sdk.core.e.c.d("BatchReporter", "cache type = " + aD);
            if (aD == 2) {
                a(q.bs(context));
            }
            ayN = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public f w(List<n> list) {
        r<n, f> rVar = ayP;
        if (rVar != null) {
            return rVar.FB();
        }
        String z = z(list);
        if (!TextUtils.isEmpty(z)) {
            return new f(z);
        }
        return new f(list);
    }

    private static String z(List<n> list) {
        if (list.get(0) != null && !TextUtils.isEmpty(list.get(0).aAd)) {
            StringBuilder sb = new StringBuilder(",\"actionList\":[");
            Iterator<n> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next().aAd);
                sb.append(',');
            }
            int length = sb.length();
            sb.replace(length - 1, length, "]");
            return sb.toString();
        }
        return "";
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public static void a2(@NonNull n nVar) {
        a(nVar, false);
    }

    public static void a(@NonNull n nVar, boolean z) {
        Ft().b(nVar, z);
    }

    @Override // com.kwad.sdk.core.report.b
    public final Runnable a(Context context, l<n> lVar, AtomicInteger atomicInteger) {
        u<n, f> Fz;
        r<n, f> rVar = ayP;
        return (rVar == null || (Fz = rVar.Fz()) == null) ? super.a(context, lVar, atomicInteger) : Fz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(n nVar) {
        r<n, f> rVar = ayP;
        if (rVar != null) {
            return rVar.FA();
        }
        return (f) super.a((g) nVar);
    }
}
