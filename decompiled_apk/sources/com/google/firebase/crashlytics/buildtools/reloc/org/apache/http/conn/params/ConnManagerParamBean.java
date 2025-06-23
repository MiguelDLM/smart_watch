package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.params;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpAbstractParamBean;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: classes10.dex */
public class ConnManagerParamBean extends HttpAbstractParamBean {
    public ConnManagerParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setConnectionsPerRoute(ConnPerRouteBean connPerRouteBean) {
        this.params.setParameter(ConnManagerPNames.MAX_CONNECTIONS_PER_ROUTE, connPerRouteBean);
    }

    public void setMaxTotalConnections(int i) {
        this.params.setIntParameter(ConnManagerPNames.MAX_TOTAL_CONNECTIONS, i);
    }

    public void setTimeout(long j) {
        this.params.setLongParameter("http.conn-manager.timeout", j);
    }
}
