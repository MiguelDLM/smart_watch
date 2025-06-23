package com.kwad.sdk.h;

import androidx.annotation.WorkerThread;
import com.kwad.sdk.h.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class m {
    private static final Map<String, k> aKK = new ConcurrentHashMap();
    private static long aKL;

    public static void Ka() {
        long currentTimeMillis = System.currentTimeMillis() - aKL;
        if (aKK.size() > 0 && currentTimeMillis > h.JN().JT()) {
            aKL = System.currentTimeMillis();
            final List<k> actionList = getActionList();
            actionList.size();
            j.JY();
            l.a(actionList, new l.a() { // from class: com.kwad.sdk.h.m.1
                @Override // com.kwad.sdk.h.l.a
                public final void onSuccess() {
                    j.JY();
                    m.x(actionList);
                }
            });
        }
    }

    @WorkerThread
    public static synchronized void a(i iVar, boolean z) {
        synchronized (m.class) {
            try {
                Map<String, k> map = aKK;
                if (map.size() > 200) {
                    j.ak("LogRequestManger", "enqueueAction fail size limit");
                } else {
                    k b = b(iVar, z);
                    map.put(b.actionId, b);
                }
                Ka();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static k b(i iVar, boolean z) {
        c.a Pa;
        if (z) {
            Pa = c.a.OZ();
        } else {
            Pa = c.a.Pa();
        }
        com.kwai.adclient.kscommerciallogger.model.c Pb = Pa.b(BusinessType.OTHER).b(SubBusinessType.OTHER).hv("ad_sdk_local_log").hu(iVar.aKD).A(iVar.toJson()).Pb();
        return new k(Pb.OT(), Pb.toString(), iVar);
    }

    private static synchronized List<k> getActionList() {
        ArrayList arrayList;
        synchronized (m.class) {
            Map<String, k> map = aKK;
            arrayList = new ArrayList(map.size());
            Iterator<Map.Entry<String, k>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void x(List<k> list) {
        synchronized (m.class) {
            if (list != null) {
                Iterator<k> it = list.iterator();
                while (it.hasNext()) {
                    aKK.remove(it.next().actionId);
                }
            }
        }
    }
}
