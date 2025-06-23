package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;

@Deprecated
/* loaded from: classes10.dex */
public final class HttpConnectionParams implements CoreConnectionPNames {
    private HttpConnectionParams() {
    }

    public static int getConnectionTimeout(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        return httpParams.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0);
    }

    public static int getLinger(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        return httpParams.getIntParameter(CoreConnectionPNames.SO_LINGER, -1);
    }

    public static boolean getSoKeepalive(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        return httpParams.getBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, false);
    }

    public static boolean getSoReuseaddr(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        return httpParams.getBooleanParameter(CoreConnectionPNames.SO_REUSEADDR, false);
    }

    public static int getSoTimeout(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        return httpParams.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0);
    }

    public static int getSocketBufferSize(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        return httpParams.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, -1);
    }

    public static boolean getTcpNoDelay(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        return httpParams.getBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true);
    }

    public static boolean isStaleCheckingEnabled(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        return httpParams.getBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true);
    }

    public static void setConnectionTimeout(HttpParams httpParams, int i) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, i);
    }

    public static void setLinger(HttpParams httpParams, int i) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setIntParameter(CoreConnectionPNames.SO_LINGER, i);
    }

    public static void setSoKeepalive(HttpParams httpParams, boolean z) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, z);
    }

    public static void setSoReuseaddr(HttpParams httpParams, boolean z) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setBooleanParameter(CoreConnectionPNames.SO_REUSEADDR, z);
    }

    public static void setSoTimeout(HttpParams httpParams, int i) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, i);
    }

    public static void setSocketBufferSize(HttpParams httpParams, int i) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, i);
    }

    public static void setStaleCheckingEnabled(HttpParams httpParams, boolean z) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, z);
    }

    public static void setTcpNoDelay(HttpParams httpParams, boolean z) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setBooleanParameter(CoreConnectionPNames.TCP_NODELAY, z);
    }
}
