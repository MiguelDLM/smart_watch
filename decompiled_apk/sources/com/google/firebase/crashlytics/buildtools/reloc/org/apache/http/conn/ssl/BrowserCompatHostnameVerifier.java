package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ssl;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import javax.net.ssl.SSLException;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes10.dex */
public class BrowserCompatHostnameVerifier extends AbstractVerifier {
    public static final BrowserCompatHostnameVerifier INSTANCE = new BrowserCompatHostnameVerifier();

    public final String toString() {
        return "BROWSER_COMPATIBLE";
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
        verify(str, strArr, strArr2, false);
    }
}
