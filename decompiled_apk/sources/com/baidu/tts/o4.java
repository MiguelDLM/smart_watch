package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes8.dex */
public final class o4 implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        boolean z;
        HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        if (!defaultHostnameVerifier.verify("tts.baidu.com", sSLSession) && !defaultHostnameVerifier.verify("audiotest.baidu.com", sSLSession)) {
            z = false;
        } else {
            z = true;
        }
        LoggerProxy.d("SslSocketClient", "verify: " + str + " " + z);
        return z;
    }
}
