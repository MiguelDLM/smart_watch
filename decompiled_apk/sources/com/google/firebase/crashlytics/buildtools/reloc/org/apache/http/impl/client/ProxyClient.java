package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ConnectionReuseStrategy;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthSchemeRegistry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthScope;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthState;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.Credentials;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.config.RequestConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.params.HttpClientParamConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.RequestClientConnControl;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.config.ConnectionConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.HttpConnectionFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ManagedHttpClientConnection;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.routing.HttpRoute;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.routing.RouteInfo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.BufferedHttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.DefaultConnectionReuseStrategy;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.BasicSchemeFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.DigestSchemeFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.KerberosSchemeFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.NTLMSchemeFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.SPNegoSchemeFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicHttpRequest;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.BasicHttpParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParamConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.BasicHttpContext;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpProcessor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpRequestExecutor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.ImmutableHttpProcessor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.RequestTargetHost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.RequestUserAgent;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.Socket;

/* loaded from: classes10.dex */
public class ProxyClient {
    private final AuthSchemeRegistry authSchemeRegistry;
    private final com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.HttpAuthenticator authenticator;
    private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
    private final ConnectionConfig connectionConfig;
    private final HttpProcessor httpProcessor;
    private final AuthState proxyAuthState;
    private final ProxyAuthenticationStrategy proxyAuthStrategy;
    private final RequestConfig requestConfig;
    private final HttpRequestExecutor requestExec;
    private final ConnectionReuseStrategy reuseStrategy;

    public ProxyClient(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, ConnectionConfig connectionConfig, RequestConfig requestConfig) {
        this.connFactory = httpConnectionFactory == null ? ManagedHttpClientConnectionFactory.INSTANCE : httpConnectionFactory;
        this.connectionConfig = connectionConfig == null ? ConnectionConfig.DEFAULT : connectionConfig;
        this.requestConfig = requestConfig == null ? RequestConfig.DEFAULT : requestConfig;
        this.httpProcessor = new ImmutableHttpProcessor(new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent());
        this.requestExec = new HttpRequestExecutor();
        this.proxyAuthStrategy = new ProxyAuthenticationStrategy();
        this.authenticator = new com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.HttpAuthenticator();
        this.proxyAuthState = new AuthState();
        AuthSchemeRegistry authSchemeRegistry = new AuthSchemeRegistry();
        this.authSchemeRegistry = authSchemeRegistry;
        authSchemeRegistry.register("Basic", new BasicSchemeFactory());
        authSchemeRegistry.register("Digest", new DigestSchemeFactory());
        authSchemeRegistry.register("NTLM", new NTLMSchemeFactory());
        authSchemeRegistry.register("Negotiate", new SPNegoSchemeFactory());
        authSchemeRegistry.register("Kerberos", new KerberosSchemeFactory());
        this.reuseStrategy = new DefaultConnectionReuseStrategy();
    }

    @Deprecated
    public AuthSchemeRegistry getAuthSchemeRegistry() {
        return this.authSchemeRegistry;
    }

    @Deprecated
    public HttpParams getParams() {
        return new BasicHttpParams();
    }

    public Socket tunnel(HttpHost httpHost, HttpHost httpHost2, Credentials credentials) throws IOException, HttpException {
        HttpHost httpHost3;
        HttpResponse execute;
        Args.notNull(httpHost, "Proxy host");
        Args.notNull(httpHost2, "Target host");
        Args.notNull(credentials, "Credentials");
        if (httpHost2.getPort() <= 0) {
            httpHost3 = new HttpHost(httpHost2.getHostName(), 80, httpHost2.getSchemeName());
        } else {
            httpHost3 = httpHost2;
        }
        HttpRoute httpRoute = new HttpRoute(httpHost3, this.requestConfig.getLocalAddress(), httpHost, false, RouteInfo.TunnelType.TUNNELLED, RouteInfo.LayerType.PLAIN);
        ManagedHttpClientConnection create = this.connFactory.create(httpRoute, this.connectionConfig);
        HttpContext basicHttpContext = new BasicHttpContext();
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", httpHost3.toHostString(), HttpVersion.HTTP_1_1);
        BasicCredentialsProvider basicCredentialsProvider = new BasicCredentialsProvider();
        basicCredentialsProvider.setCredentials(new AuthScope(httpHost), credentials);
        basicHttpContext.setAttribute("http.target_host", httpHost2);
        basicHttpContext.setAttribute("http.connection", create);
        basicHttpContext.setAttribute("http.request", basicHttpRequest);
        basicHttpContext.setAttribute("http.route", httpRoute);
        basicHttpContext.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
        basicHttpContext.setAttribute("http.auth.credentials-provider", basicCredentialsProvider);
        basicHttpContext.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
        basicHttpContext.setAttribute("http.request-config", this.requestConfig);
        this.requestExec.preProcess(basicHttpRequest, this.httpProcessor, basicHttpContext);
        while (true) {
            if (!create.isOpen()) {
                create.bind(new Socket(httpHost.getHostName(), httpHost.getPort()));
            }
            this.authenticator.generateAuthResponse(basicHttpRequest, this.proxyAuthState, basicHttpContext);
            execute = this.requestExec.execute(basicHttpRequest, create, basicHttpContext);
            if (execute.getStatusLine().getStatusCode() >= 200) {
                if (!this.authenticator.isAuthenticationRequested(httpHost, execute, this.proxyAuthStrategy, this.proxyAuthState, basicHttpContext) || !this.authenticator.handleAuthChallenge(httpHost, execute, this.proxyAuthStrategy, this.proxyAuthState, basicHttpContext)) {
                    break;
                }
                if (this.reuseStrategy.keepAlive(execute, basicHttpContext)) {
                    EntityUtils.consume(execute.getEntity());
                } else {
                    create.close();
                }
                basicHttpRequest.removeHeaders("Proxy-Authorization");
            } else {
                throw new HttpException("Unexpected response to CONNECT request: " + execute.getStatusLine());
            }
        }
        if (execute.getStatusLine().getStatusCode() > 299) {
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                execute.setEntity(new BufferedHttpEntity(entity));
            }
            create.close();
            throw new com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.execchain.TunnelRefusedException("CONNECT refused by proxy: " + execute.getStatusLine(), execute);
        }
        return create.getSocket();
    }

    @Deprecated
    public ProxyClient(HttpParams httpParams) {
        this(null, HttpParamConfig.getConnectionConfig(httpParams), HttpClientParamConfig.getRequestConfig(httpParams));
    }

    public ProxyClient(RequestConfig requestConfig) {
        this(null, null, requestConfig);
    }

    public ProxyClient() {
        this(null, null, null);
    }
}
