package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ssl;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import java.security.cert.X509Certificate;
import java.util.Arrays;

@Deprecated
/* loaded from: classes10.dex */
public final class PrivateKeyDetails {
    private final X509Certificate[] certChain;
    private final String type;

    public PrivateKeyDetails(String str, X509Certificate[] x509CertificateArr) {
        this.type = (String) Args.notNull(str, "Private key type");
        this.certChain = x509CertificateArr;
    }

    public X509Certificate[] getCertChain() {
        return this.certChain;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return this.type + ':' + Arrays.toString(this.certChain);
    }
}
