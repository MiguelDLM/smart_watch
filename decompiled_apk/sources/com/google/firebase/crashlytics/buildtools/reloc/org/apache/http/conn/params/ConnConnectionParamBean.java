package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.params;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpAbstractParamBean;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: classes10.dex */
public class ConnConnectionParamBean extends HttpAbstractParamBean {
    public ConnConnectionParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    @Deprecated
    public void setMaxStatusLineGarbage(int i) {
        this.params.setIntParameter(ConnConnectionPNames.MAX_STATUS_LINE_GARBAGE, i);
    }
}
