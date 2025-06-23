package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.execchain;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.LogFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ConnectionReuseStrategy;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ProtocolException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpRequestWrapper;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.RequestClientConnControl;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils.URIUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ConnectionKeepAliveStrategy;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.HttpClientConnectionManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.routing.HttpRoute;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpProcessor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpRequestExecutor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.ImmutableHttpProcessor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.RequestContent;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.RequestTargetHost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.RequestUserAgent;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.VersionInfo;
import java.net.URI;
import java.net.URISyntaxException;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes10.dex */
public class MinimalClientExec implements ClientExecChain {
    private final HttpClientConnectionManager connManager;
    private final HttpProcessor httpProcessor;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final Log log = LogFactory.getLog(getClass());
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;

    public MinimalClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        this.httpProcessor = new ImmutableHttpProcessor(new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(VersionInfo.getUserAgent("Apache-HttpClient", "com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client", getClass())));
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
    }

    public static void rewriteRequestURI(HttpRequestWrapper httpRequestWrapper, HttpRoute httpRoute) throws ProtocolException {
        URI rewriteURI;
        try {
            URI uri = httpRequestWrapper.getURI();
            if (uri != null) {
                if (uri.isAbsolute()) {
                    rewriteURI = URIUtils.rewriteURI(uri, null, true);
                } else {
                    rewriteURI = URIUtils.rewriteURI(uri);
                }
                httpRequestWrapper.setURI(rewriteURI);
            }
        } catch (URISyntaxException e) {
            throw new ProtocolException("Invalid URI: " + httpRequestWrapper.getRequestLine().getUri(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb A[Catch: Error -> 0x0059, RuntimeException -> 0x005c, IOException -> 0x005f, HttpException -> 0x0062, ConnectionShutdownException -> 0x0065, TryCatch #3 {HttpException -> 0x0062, ConnectionShutdownException -> 0x0065, IOException -> 0x005f, Error -> 0x0059, RuntimeException -> 0x005c, blocks: (B:49:0x004f, B:51:0x0055, B:52:0x0068, B:53:0x0070, B:17:0x0071, B:19:0x0077, B:22:0x0081, B:24:0x0089, B:26:0x008f, B:27:0x0092, B:29:0x009a, B:31:0x00a6, B:33:0x00bb, B:34:0x00bf, B:36:0x00eb, B:37:0x00fb, B:39:0x0101, B:42:0x0108, B:44:0x010e, B:46:0x00f8), top: B:48:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00eb A[Catch: Error -> 0x0059, RuntimeException -> 0x005c, IOException -> 0x005f, HttpException -> 0x0062, ConnectionShutdownException -> 0x0065, TryCatch #3 {HttpException -> 0x0062, ConnectionShutdownException -> 0x0065, IOException -> 0x005f, Error -> 0x0059, RuntimeException -> 0x005c, blocks: (B:49:0x004f, B:51:0x0055, B:52:0x0068, B:53:0x0070, B:17:0x0071, B:19:0x0077, B:22:0x0081, B:24:0x0089, B:26:0x008f, B:27:0x0092, B:29:0x009a, B:31:0x00a6, B:33:0x00bb, B:34:0x00bf, B:36:0x00eb, B:37:0x00fb, B:39:0x0101, B:42:0x0108, B:44:0x010e, B:46:0x00f8), top: B:48:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f8 A[Catch: Error -> 0x0059, RuntimeException -> 0x005c, IOException -> 0x005f, HttpException -> 0x0062, ConnectionShutdownException -> 0x0065, TryCatch #3 {HttpException -> 0x0062, ConnectionShutdownException -> 0x0065, IOException -> 0x005f, Error -> 0x0059, RuntimeException -> 0x005c, blocks: (B:49:0x004f, B:51:0x0055, B:52:0x0068, B:53:0x0070, B:17:0x0071, B:19:0x0077, B:22:0x0081, B:24:0x0089, B:26:0x008f, B:27:0x0092, B:29:0x009a, B:31:0x00a6, B:33:0x00bb, B:34:0x00bf, B:36:0x00eb, B:37:0x00fb, B:39:0x0101, B:42:0x0108, B:44:0x010e, B:46:0x00f8), top: B:48:0x004f }] */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.execchain.ClientExecChain
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.CloseableHttpResponse execute(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.routing.HttpRoute r9, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpRequestWrapper r10, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.HttpClientContext r11, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpExecutionAware r12) throws java.io.IOException, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.execchain.MinimalClientExec.execute(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.routing.HttpRoute, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpRequestWrapper, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.HttpClientContext, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpExecutionAware):com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.CloseableHttpResponse");
    }
}
