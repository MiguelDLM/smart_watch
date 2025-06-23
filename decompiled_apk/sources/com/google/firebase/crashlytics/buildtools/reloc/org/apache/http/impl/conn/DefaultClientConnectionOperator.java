package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.LogFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.ClientContext;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionOperator;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.DnsResolver;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.OperatedClientConnection;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.scheme.Scheme;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.scheme.SchemeRegistry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpConnectionParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Asserts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: classes10.dex */
public class DefaultClientConnectionOperator implements ClientConnectionOperator {
    protected final DnsResolver dnsResolver;
    private final Log log = LogFactory.getLog(getClass());
    protected final SchemeRegistry schemeRegistry;

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = new SystemDefaultDnsResolver();
    }

    private SchemeRegistry getSchemeRegistry(HttpContext httpContext) {
        SchemeRegistry schemeRegistry = (SchemeRegistry) httpContext.getAttribute(ClientContext.SCHEME_REGISTRY);
        if (schemeRegistry == null) {
            return this.schemeRegistry;
        }
        return schemeRegistry;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionOperator
    public OperatedClientConnection createConnection() {
        return new DefaultClientConnection();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf A[SYNTHETIC] */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionOperator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void openConnection(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.OperatedClientConnection r17, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost r18, java.net.InetAddress r19, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext r20, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams r21) throws java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            java.lang.String r0 = "Connection"
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args.notNull(r2, r0)
            java.lang.String r0 = "Target host"
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args.notNull(r3, r0)
            java.lang.String r0 = "HTTP parameters"
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args.notNull(r6, r0)
            boolean r0 = r17.isOpen()
            r7 = 1
            r0 = r0 ^ r7
            java.lang.String r8 = "Connection must not be open"
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Asserts.check(r0, r8)
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.scheme.SchemeRegistry r0 = r1.getSchemeRegistry(r5)
            java.lang.String r8 = r18.getSchemeName()
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.scheme.Scheme r0 = r0.getScheme(r8)
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.scheme.SchemeSocketFactory r8 = r0.getSchemeSocketFactory()
            java.lang.String r9 = r18.getHostName()
            java.net.InetAddress[] r9 = r1.resolveHostname(r9)
            int r10 = r18.getPort()
            int r10 = r0.resolvePort(r10)
            r11 = 0
            r12 = 0
        L48:
            int r0 = r9.length
            if (r12 >= r0) goto Ld8
            r0 = r9[r12]
            int r13 = r9.length
            int r13 = r13 - r7
            if (r12 != r13) goto L53
            r13 = 1
            goto L54
        L53:
            r13 = 0
        L54:
            java.net.Socket r14 = r8.createSocket(r6)
            r2.opening(r14, r3)
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.HttpInetSocketAddress r15 = new com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.HttpInetSocketAddress
            r15.<init>(r3, r0, r10)
            if (r4 == 0) goto L68
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
            r0.<init>(r4, r11)
            goto L69
        L68:
            r0 = 0
        L69:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log r7 = r1.log
            boolean r7 = r7.isDebugEnabled()
            if (r7 == 0) goto L87
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log r7 = r1.log
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r4 = "Connecting to "
            r11.append(r4)
            r11.append(r15)
            java.lang.String r4 = r11.toString()
            r7.debug(r4)
        L87:
            java.net.Socket r0 = r8.connectSocket(r14, r15, r0, r6)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ConnectTimeoutException -> L92 java.net.ConnectException -> L94
            if (r14 == r0) goto L96
            r2.opening(r0, r3)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ConnectTimeoutException -> L92 java.net.ConnectException -> L94
            r14 = r0
            goto L96
        L92:
            r0 = move-exception
            goto La1
        L94:
            r0 = move-exception
            goto La5
        L96:
            r1.prepareSocket(r14, r5, r6)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ConnectTimeoutException -> L92 java.net.ConnectException -> L94
            boolean r0 = r8.isSecure(r14)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ConnectTimeoutException -> L92 java.net.ConnectException -> L94
            r2.openCompleted(r0, r6)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ConnectTimeoutException -> L92 java.net.ConnectException -> L94
            return
        La1:
            if (r13 != 0) goto La4
            goto La7
        La4:
            throw r0
        La5:
            if (r13 != 0) goto Ld7
        La7:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log r0 = r1.log
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto Lcf
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log r0 = r1.log
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "Connect to "
            r4.append(r7)
            r4.append(r15)
            java.lang.String r7 = " timed out. "
            r4.append(r7)
            java.lang.String r7 = "Connection will be retried using another IP address"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r0.debug(r4)
        Lcf:
            int r12 = r12 + 1
            r4 = r19
            r7 = 1
            r11 = 0
            goto L48
        Ld7:
            throw r0
        Ld8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn.DefaultClientConnectionOperator.openConnection(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.OperatedClientConnection, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost, java.net.InetAddress, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams):void");
    }

    public void prepareSocket(Socket socket, HttpContext httpContext, HttpParams httpParams) throws IOException {
        boolean z;
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(httpParams));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(httpParams));
        int linger = HttpConnectionParams.getLinger(httpParams);
        if (linger >= 0) {
            if (linger > 0) {
                z = true;
            } else {
                z = false;
            }
            socket.setSoLinger(z, linger);
        }
    }

    public InetAddress[] resolveHostname(String str) throws UnknownHostException {
        return this.dnsResolver.resolve(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionOperator
    public void updateSecureConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, HttpContext httpContext, HttpParams httpParams) throws IOException {
        Args.notNull(operatedClientConnection, "Connection");
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpParams, "Parameters");
        Asserts.check(operatedClientConnection.isOpen(), "Connection must be open");
        Scheme scheme = getSchemeRegistry(httpContext).getScheme(httpHost.getSchemeName());
        Asserts.check(scheme.getSchemeSocketFactory() instanceof SchemeLayeredSocketFactory, "Socket factory must implement SchemeLayeredSocketFactory");
        SchemeLayeredSocketFactory schemeLayeredSocketFactory = (SchemeLayeredSocketFactory) scheme.getSchemeSocketFactory();
        Socket createLayeredSocket = schemeLayeredSocketFactory.createLayeredSocket(operatedClientConnection.getSocket(), httpHost.getHostName(), scheme.resolvePort(httpHost.getPort()), httpParams);
        prepareSocket(createLayeredSocket, httpContext, httpParams);
        operatedClientConnection.update(createLayeredSocket, httpHost, schemeLayeredSocketFactory.isSecure(createLayeredSocket), httpParams);
    }

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry, DnsResolver dnsResolver) {
        Args.notNull(schemeRegistry, "Scheme registry");
        Args.notNull(dnsResolver, "DNS resolver");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = dnsResolver;
    }
}
