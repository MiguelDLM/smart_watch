package com.jd.ad.sdk.jad_xk;

import android.text.TextUtils;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes10.dex */
public class jad_jt implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !Arrays.asList(jad_hu.jad_cp).contains(str);
    }
}
