package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.params;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.params.AuthPNames;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.config.RequestConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.params.ConnRoutePNames;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.CoreConnectionPNames;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.CoreProtocolPNames;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;
import java.net.InetAddress;
import java.util.Collection;

@Deprecated
/* loaded from: classes10.dex */
public final class HttpClientParamConfig {
    private HttpClientParamConfig() {
    }

    public static RequestConfig getRequestConfig(HttpParams httpParams) {
        return getRequestConfig(httpParams, RequestConfig.DEFAULT);
    }

    public static RequestConfig getRequestConfig(HttpParams httpParams, RequestConfig requestConfig) {
        RequestConfig.Builder relativeRedirectsAllowed = RequestConfig.copy(requestConfig).setSocketTimeout(httpParams.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, requestConfig.getSocketTimeout())).setStaleConnectionCheckEnabled(httpParams.getBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, requestConfig.isStaleConnectionCheckEnabled())).setConnectTimeout(httpParams.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, requestConfig.getConnectTimeout())).setExpectContinueEnabled(httpParams.getBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, requestConfig.isExpectContinueEnabled())).setAuthenticationEnabled(httpParams.getBooleanParameter(ClientPNames.HANDLE_AUTHENTICATION, requestConfig.isAuthenticationEnabled())).setCircularRedirectsAllowed(httpParams.getBooleanParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, requestConfig.isCircularRedirectsAllowed())).setConnectionRequestTimeout((int) httpParams.getLongParameter("http.conn-manager.timeout", requestConfig.getConnectionRequestTimeout())).setMaxRedirects(httpParams.getIntParameter(ClientPNames.MAX_REDIRECTS, requestConfig.getMaxRedirects())).setRedirectsEnabled(httpParams.getBooleanParameter(ClientPNames.HANDLE_REDIRECTS, requestConfig.isRedirectsEnabled())).setRelativeRedirectsAllowed(!httpParams.getBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, !requestConfig.isRelativeRedirectsAllowed()));
        HttpHost httpHost = (HttpHost) httpParams.getParameter(ConnRoutePNames.DEFAULT_PROXY);
        if (httpHost != null) {
            relativeRedirectsAllowed.setProxy(httpHost);
        }
        InetAddress inetAddress = (InetAddress) httpParams.getParameter(ConnRoutePNames.LOCAL_ADDRESS);
        if (inetAddress != null) {
            relativeRedirectsAllowed.setLocalAddress(inetAddress);
        }
        Collection<String> collection = (Collection) httpParams.getParameter(AuthPNames.TARGET_AUTH_PREF);
        if (collection != null) {
            relativeRedirectsAllowed.setTargetPreferredAuthSchemes(collection);
        }
        Collection<String> collection2 = (Collection) httpParams.getParameter(AuthPNames.PROXY_AUTH_PREF);
        if (collection2 != null) {
            relativeRedirectsAllowed.setProxyPreferredAuthSchemes(collection2);
        }
        String str = (String) httpParams.getParameter(ClientPNames.COOKIE_POLICY);
        if (str != null) {
            relativeRedirectsAllowed.setCookieSpec(str);
        }
        return relativeRedirectsAllowed.build();
    }
}
