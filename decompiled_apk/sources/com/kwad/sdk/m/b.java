package com.kwad.sdk.m;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.m.a.a;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class b {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    private String value;

    /* loaded from: classes11.dex */
    public static class a {
        private static final b aOq = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b Li() {
        return a.aOq;
    }

    public static /* synthetic */ com.kwad.sdk.m.b.a.c a(b bVar, String str, String str2) {
        return am(str, str2);
    }

    @Nullable
    private static com.kwad.sdk.m.b.a.c am(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.kwad.sdk.m.b.a.c cVar = new com.kwad.sdk.m.b.a.c();
            cVar.name = str;
            cVar.aOR = str2;
            return cVar;
        }
        return null;
    }

    private static Object c(com.kwad.sdk.m.a.a aVar) {
        if (aVar.aOC) {
            try {
                return s.c(Class.forName(aVar.aOA), aVar.aOB);
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.w(TAG, Log.getStackTraceString(e));
            }
        } else {
            Object obj = aVar.aOz;
            if (obj != null) {
                return s.getField(obj, aVar.aOB);
            }
        }
        return null;
    }

    private void l(Object obj) {
        if (obj != null) {
            this.value = String.valueOf(obj);
        } else {
            com.kwad.sdk.core.e.c.w(TAG, "value is null by ob null");
            this.value = "";
        }
    }

    public final void b(c cVar) {
        List<com.kwad.sdk.m.a.a> list;
        if (cVar == null || (list = cVar.aOt) == null || list.isEmpty()) {
            return;
        }
        final List<com.kwad.sdk.m.a.a> list2 = cVar.aOt;
        g.schedule(new az() { // from class: com.kwad.sdk.m.b.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.m.a.a aVar : list2) {
                    if (aVar != null && !TextUtils.isEmpty(aVar.aOD)) {
                        String str = aVar.aOD;
                        b.this.a(aVar);
                        b bVar = b.this;
                        com.kwad.sdk.m.b.a.c a2 = b.a(bVar, str, bVar.value);
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    com.kwad.sdk.m.b.a.d dVar = new com.kwad.sdk.m.b.a.d();
                    dVar.aOS = arrayList;
                    com.kwad.sdk.m.b.a.a(dVar);
                }
            }
        }, 20L, TimeUnit.SECONDS);
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.m.a.a aVar) {
        com.kwad.sdk.m.a.a aVar2 = aVar.aOF;
        if (aVar2 != null && !aVar2.Ln()) {
            if (!TextUtils.isEmpty(aVar.aOB)) {
                aVar.aOF.aOz = c(aVar);
            } else {
                a.b bVar = aVar.aOE;
                if (bVar != null && !bVar.Ln()) {
                    aVar.aOF.aOz = b(aVar);
                }
            }
            a(aVar.aOF);
            return;
        }
        if (!TextUtils.isEmpty(aVar.aOB)) {
            l(c(aVar));
            return;
        }
        a.b bVar2 = aVar.aOE;
        if (bVar2 != null && !bVar2.Ln()) {
            l(b(aVar));
            return;
        }
        com.kwad.sdk.core.e.c.d(TAG, "node.nodeClassName:" + aVar.aOA);
        this.value = s.classExists(aVar.aOA) ? "true" : "false";
    }

    private Object b(com.kwad.sdk.m.a.a aVar) {
        Class<?> cls;
        if (aVar.aOE.aON) {
            try {
                if (!TextUtils.isEmpty(aVar.aOA)) {
                    cls = Class.forName(aVar.aOA);
                } else {
                    Object obj = aVar.aOz;
                    cls = obj != null ? obj.getClass() : null;
                }
                if (cls != null) {
                    return a(aVar, true, cls);
                }
                return null;
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.w(TAG, Log.getStackTraceString(e));
                return null;
            }
        }
        if (aVar.aOz != null) {
            return a(aVar, false, (Class<?>) null);
        }
        return null;
    }

    private static Object a(com.kwad.sdk.m.a.a aVar, boolean z, Class<?> cls) {
        Object[] Lq = aVar.aOE.Lq();
        if (Lq == null || Lq.length == 0) {
            if (z) {
                return s.callStaticMethod(cls, aVar.aOE.name, new Object[0]);
            }
            return s.callMethod(aVar.aOz, aVar.aOE.name, new Object[0]);
        }
        if (z) {
            return s.callStaticMethod(cls, aVar.aOE.name, Lq);
        }
        return s.callMethod(aVar.aOz, aVar.aOE.name, Lq);
    }
}
