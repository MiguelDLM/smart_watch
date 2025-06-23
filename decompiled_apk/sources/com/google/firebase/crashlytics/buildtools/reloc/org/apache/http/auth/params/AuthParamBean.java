package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.params;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpAbstractParamBean;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: classes10.dex */
public class AuthParamBean extends HttpAbstractParamBean {
    public AuthParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setCredentialCharset(String str) {
        AuthParams.setCredentialCharset(this.params, str);
    }
}
