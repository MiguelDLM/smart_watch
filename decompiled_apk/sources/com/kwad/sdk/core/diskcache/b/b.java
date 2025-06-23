package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes11.dex */
public final class b {
    public static void a(@NonNull final com.kwad.sdk.core.diskcache.a.a aVar, @NonNull final String str, @NonNull final String str2) {
        g.execute(new az() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                OutputStream outputStream = null;
                try {
                    a.C0848a dz = com.kwad.sdk.core.diskcache.a.a.this.dz(str2);
                    if (dz != null) {
                        outputStream = dz.cZ(0);
                        if (b.a(str, outputStream, new a.C0856a())) {
                            dz.commit();
                        } else {
                            dz.abort();
                        }
                        com.kwad.sdk.core.diskcache.a.a.this.flush();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (IOException unused) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (Throwable th) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    throw th;
                }
            }
        });
    }

    public static File a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str) {
        a.c cVar;
        a.c cVar2 = null;
        try {
            cVar = aVar.dy(str);
            if (cVar != null) {
                try {
                    File dc = cVar.dc(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    return dc;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    cVar2 = cVar;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar2);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVar = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
        return null;
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, a.C0856a c0856a) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0848a dz = aVar.dz(str2);
                if (dz != null) {
                    outputStream = dz.cZ(0);
                    if (a(str, outputStream, c0856a)) {
                        dz.commit();
                        z = true;
                    } else {
                        dz.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e) {
                c0856a.msg = e.getMessage();
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            return z;
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0856a c0856a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0856a, -1L, null);
    }
}
