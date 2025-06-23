package com.kwad.sdk.e;

import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class b implements a {
    private static volatile b aJi;
    private static c aJj;

    private b() {
    }

    public static synchronized b Jd() {
        b bVar;
        synchronized (b.class) {
            try {
                if (aJi == null) {
                    synchronized (b.class) {
                        try {
                            if (aJi == null) {
                                aJi = new b();
                            }
                        } finally {
                        }
                    }
                }
                bVar = aJi;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private static String Je() {
        return a(false, "", 2);
    }

    public static void a(c cVar) {
        aJj = cVar;
    }

    @Override // com.kwad.sdk.e.a
    public final String IR() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IR();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String IS() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IS();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String IT() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IT();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String IU() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IU();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String IV() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IV();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String IW() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IW();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String IX() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IX();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String IY() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IY();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String IZ() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IZ();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String Ja() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.Ja();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String Jb() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.Jb();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String Jc() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.Jc();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String getAppId() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getAppId();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String getDeviceId() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getDeviceId();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIccId() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getIccId();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIp() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getIp();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String getLocation() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getLocation();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String getOaid() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getOaid();
        }
        return Je();
    }

    @Override // com.kwad.sdk.e.a
    public final String getSdkVersion() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getSdkVersion();
        }
        return Je();
    }

    public static String a(boolean z, Object obj, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z));
        hashMap.put("value", obj);
        hashMap.put("errorCode", String.valueOf(i));
        return new JSONObject(hashMap).toString();
    }
}
