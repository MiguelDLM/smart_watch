package com.baidu.mshield.b.d;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes7.dex */
public class c implements HostnameVerifier {
    public c(b bVar) {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if ("mshield.baidu.com".equals(str)) {
            return true;
        }
        return false;
    }
}
