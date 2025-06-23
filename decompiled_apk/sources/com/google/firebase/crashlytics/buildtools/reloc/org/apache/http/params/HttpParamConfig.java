package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.config.ConnectionConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.config.MessageConstraints;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.config.SocketConfig;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

@Deprecated
/* loaded from: classes10.dex */
public final class HttpParamConfig {
    private HttpParamConfig() {
    }

    public static ConnectionConfig getConnectionConfig(HttpParams httpParams) {
        Charset charset;
        MessageConstraints messageConstraints = getMessageConstraints(httpParams);
        String str = (String) httpParams.getParameter(CoreProtocolPNames.HTTP_ELEMENT_CHARSET);
        ConnectionConfig.Builder custom = ConnectionConfig.custom();
        if (str != null) {
            charset = Charset.forName(str);
        } else {
            charset = null;
        }
        return custom.setCharset(charset).setMalformedInputAction((CodingErrorAction) httpParams.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION)).setMalformedInputAction((CodingErrorAction) httpParams.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION)).setMessageConstraints(messageConstraints).build();
    }

    public static MessageConstraints getMessageConstraints(HttpParams httpParams) {
        return MessageConstraints.custom().setMaxHeaderCount(httpParams.getIntParameter(CoreConnectionPNames.MAX_HEADER_COUNT, -1)).setMaxLineLength(httpParams.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1)).build();
    }

    public static SocketConfig getSocketConfig(HttpParams httpParams) {
        return SocketConfig.custom().setSoTimeout(httpParams.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0)).setSoReuseAddress(httpParams.getBooleanParameter(CoreConnectionPNames.SO_REUSEADDR, false)).setSoKeepAlive(httpParams.getBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, false)).setSoLinger(httpParams.getIntParameter(CoreConnectionPNames.SO_LINGER, -1)).setTcpNoDelay(httpParams.getBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true)).build();
    }
}
