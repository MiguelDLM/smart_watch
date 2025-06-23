package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.pool;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpClientConnection;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpConnectionFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.config.ConnectionConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.config.SocketConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.DefaultBHttpClientConnection;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.DefaultBHttpClientConnectionFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.CoreConnectionPNames;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParamConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.pool.ConnFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes10.dex */
public class BasicConnFactory implements ConnFactory<HttpHost, HttpClientConnection> {
    private final HttpConnectionFactory<? extends HttpClientConnection> connFactory;
    private final int connectTimeout;
    private final SocketFactory plainfactory;
    private final SocketConfig sconfig;
    private final SSLSocketFactory sslfactory;

    @Deprecated
    public BasicConnFactory(SSLSocketFactory sSLSocketFactory, HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP params");
        this.plainfactory = null;
        this.sslfactory = sSLSocketFactory;
        this.connectTimeout = httpParams.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0);
        this.sconfig = HttpParamConfig.getSocketConfig(httpParams);
        this.connFactory = new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(httpParams));
    }

    @Deprecated
    public HttpClientConnection create(Socket socket, HttpParams httpParams) throws IOException {
        DefaultBHttpClientConnection defaultBHttpClientConnection = new DefaultBHttpClientConnection(httpParams.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, 8192));
        defaultBHttpClientConnection.bind(socket);
        return defaultBHttpClientConnection;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.pool.ConnFactory
    public HttpClientConnection create(HttpHost httpHost) throws IOException {
        Socket socket;
        String schemeName = httpHost.getSchemeName();
        if ("http".equalsIgnoreCase(schemeName)) {
            SocketFactory socketFactory = this.plainfactory;
            socket = socketFactory != null ? socketFactory.createSocket() : new Socket();
        } else {
            socket = null;
        }
        if ("https".equalsIgnoreCase(schemeName)) {
            SocketFactory socketFactory2 = this.sslfactory;
            if (socketFactory2 == null) {
                socketFactory2 = SSLSocketFactory.getDefault();
            }
            socket = socketFactory2.createSocket();
        }
        if (socket != null) {
            String hostName = httpHost.getHostName();
            int port = httpHost.getPort();
            if (port == -1) {
                if (httpHost.getSchemeName().equalsIgnoreCase("http")) {
                    port = 80;
                } else if (httpHost.getSchemeName().equalsIgnoreCase("https")) {
                    port = 443;
                }
            }
            socket.setSoTimeout(this.sconfig.getSoTimeout());
            if (this.sconfig.getSndBufSize() > 0) {
                socket.setSendBufferSize(this.sconfig.getSndBufSize());
            }
            if (this.sconfig.getRcvBufSize() > 0) {
                socket.setReceiveBufferSize(this.sconfig.getRcvBufSize());
            }
            socket.setTcpNoDelay(this.sconfig.isTcpNoDelay());
            int soLinger = this.sconfig.getSoLinger();
            if (soLinger >= 0) {
                socket.setSoLinger(true, soLinger);
            }
            socket.setKeepAlive(this.sconfig.isSoKeepAlive());
            socket.connect(new InetSocketAddress(hostName, port), this.connectTimeout);
            return this.connFactory.createConnection(socket);
        }
        throw new IOException(schemeName + " scheme is not supported");
    }

    @Deprecated
    public BasicConnFactory(HttpParams httpParams) {
        this((SSLSocketFactory) null, httpParams);
    }

    public BasicConnFactory(SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, int i, SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this.plainfactory = socketFactory;
        this.sslfactory = sSLSocketFactory;
        this.connectTimeout = i;
        this.sconfig = socketConfig == null ? SocketConfig.DEFAULT : socketConfig;
        this.connFactory = new DefaultBHttpClientConnectionFactory(connectionConfig == null ? ConnectionConfig.DEFAULT : connectionConfig);
    }

    public BasicConnFactory(int i, SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this(null, null, i, socketConfig, connectionConfig);
    }

    public BasicConnFactory(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this(null, null, 0, socketConfig, connectionConfig);
    }

    public BasicConnFactory() {
        this(null, null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
    }
}
