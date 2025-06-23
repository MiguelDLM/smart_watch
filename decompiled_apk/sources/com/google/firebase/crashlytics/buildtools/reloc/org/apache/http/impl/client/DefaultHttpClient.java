package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.RequestAddCookies;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.RequestAuthCache;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.RequestClientConnControl;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.RequestDefaultHeaders;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.RequestProxyAuthentication;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.RequestTargetAuthentication;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol.ResponseProcessCookies;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpConnectionParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpProtocolParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.SyncBasicHttpParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.BasicHttpProcessor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.RequestContent;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.RequestExpectContinue;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.RequestTargetHost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.RequestUserAgent;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.VersionInfo;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: classes10.dex */
public class DefaultHttpClient extends AbstractHttpClient {
    public DefaultHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
    }

    public static void setDefaultHttpParams(HttpParams httpParams) {
        HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(httpParams, HTTP.DEF_CONTENT_CHARSET.name());
        HttpConnectionParams.setTcpNoDelay(httpParams, true);
        HttpConnectionParams.setSocketBufferSize(httpParams, 8192);
        HttpProtocolParams.setUserAgent(httpParams, VersionInfo.getUserAgent("Apache-HttpClient", "com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client", DefaultHttpClient.class));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.AbstractHttpClient
    public HttpParams createHttpParams() {
        SyncBasicHttpParams syncBasicHttpParams = new SyncBasicHttpParams();
        setDefaultHttpParams(syncBasicHttpParams);
        return syncBasicHttpParams;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.AbstractHttpClient
    public BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor basicHttpProcessor = new BasicHttpProcessor();
        basicHttpProcessor.addInterceptor(new RequestDefaultHeaders());
        basicHttpProcessor.addInterceptor(new RequestContent());
        basicHttpProcessor.addInterceptor(new RequestTargetHost());
        basicHttpProcessor.addInterceptor(new RequestClientConnControl());
        basicHttpProcessor.addInterceptor(new RequestUserAgent());
        basicHttpProcessor.addInterceptor(new RequestExpectContinue());
        basicHttpProcessor.addInterceptor(new RequestAddCookies());
        basicHttpProcessor.addInterceptor(new ResponseProcessCookies());
        basicHttpProcessor.addInterceptor(new RequestAuthCache());
        basicHttpProcessor.addInterceptor(new RequestTargetAuthentication());
        basicHttpProcessor.addInterceptor(new RequestProxyAuthentication());
        return basicHttpProcessor;
    }

    public DefaultHttpClient(ClientConnectionManager clientConnectionManager) {
        super(clientConnectionManager, null);
    }

    public DefaultHttpClient(HttpParams httpParams) {
        super(null, httpParams);
    }

    public DefaultHttpClient() {
        super(null, null);
    }
}
