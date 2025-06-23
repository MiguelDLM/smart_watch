package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.net.ConnectException;

/* loaded from: classes10.dex */
public class HttpHostConnectException extends ConnectException {
    private static final long serialVersionUID = -3194482710275220224L;
    private final HttpHost host;

    @Deprecated
    public HttpHostConnectException(HttpHost httpHost, ConnectException connectException) {
        this(connectException, httpHost, null);
    }

    public HttpHost getHost() {
        return this.host;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HttpHostConnectException(java.io.IOException r4, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost r5, java.net.InetAddress... r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Connect to "
            r0.append(r1)
            if (r5 == 0) goto L11
            java.lang.String r1 = r5.toHostString()
            goto L13
        L11:
            java.lang.String r1 = "remote host"
        L13:
            r0.append(r1)
            if (r6 == 0) goto L31
            int r1 = r6.length
            if (r1 <= 0) goto L31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " "
            r1.append(r2)
            java.util.List r6 = java.util.Arrays.asList(r6)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            goto L33
        L31:
            java.lang.String r6 = ""
        L33:
            r0.append(r6)
            if (r4 == 0) goto L54
            java.lang.String r6 = r4.getMessage()
            if (r6 == 0) goto L54
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = " failed: "
            r6.append(r1)
            java.lang.String r1 = r4.getMessage()
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            goto L56
        L54:
            java.lang.String r6 = " refused"
        L56:
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r3.<init>(r6)
            r3.host = r5
            r3.initCause(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.HttpHostConnectException.<init>(java.io.IOException, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost, java.net.InetAddress[]):void");
    }
}
