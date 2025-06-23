package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.AbstractHttpParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;

@Deprecated
/* loaded from: classes10.dex */
public class ClientParamsStack extends AbstractHttpParams {
    protected final HttpParams applicationParams;
    protected final HttpParams clientParams;
    protected final HttpParams overrideParams;
    protected final HttpParams requestParams;

    public ClientParamsStack(HttpParams httpParams, HttpParams httpParams2, HttpParams httpParams3, HttpParams httpParams4) {
        this.applicationParams = httpParams;
        this.clientParams = httpParams2;
        this.requestParams = httpParams3;
        this.overrideParams = httpParams4;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams
    public HttpParams copy() {
        return this;
    }

    public final HttpParams getApplicationParams() {
        return this.applicationParams;
    }

    public final HttpParams getClientParams() {
        return this.clientParams;
    }

    public final HttpParams getOverrideParams() {
        return this.overrideParams;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams
    public Object getParameter(String str) {
        Object obj;
        HttpParams httpParams;
        HttpParams httpParams2;
        HttpParams httpParams3;
        Args.notNull(str, "Parameter name");
        HttpParams httpParams4 = this.overrideParams;
        if (httpParams4 != null) {
            obj = httpParams4.getParameter(str);
        } else {
            obj = null;
        }
        if (obj == null && (httpParams3 = this.requestParams) != null) {
            obj = httpParams3.getParameter(str);
        }
        if (obj == null && (httpParams2 = this.clientParams) != null) {
            obj = httpParams2.getParameter(str);
        }
        if (obj == null && (httpParams = this.applicationParams) != null) {
            return httpParams.getParameter(str);
        }
        return obj;
    }

    public final HttpParams getRequestParams() {
        return this.requestParams;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams
    public boolean removeParameter(String str) {
        throw new UnsupportedOperationException("Removing parameters in a stack is not supported.");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams
    public HttpParams setParameter(String str, Object obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
    }

    public ClientParamsStack(ClientParamsStack clientParamsStack) {
        this(clientParamsStack.getApplicationParams(), clientParamsStack.getClientParams(), clientParamsStack.getRequestParams(), clientParamsStack.getOverrideParams());
    }

    public ClientParamsStack(ClientParamsStack clientParamsStack, HttpParams httpParams, HttpParams httpParams2, HttpParams httpParams3, HttpParams httpParams4) {
        this(httpParams == null ? clientParamsStack.getApplicationParams() : httpParams, httpParams2 == null ? clientParamsStack.getClientParams() : httpParams2, httpParams3 == null ? clientParamsStack.getRequestParams() : httpParams3, httpParams4 == null ? clientParamsStack.getOverrideParams() : httpParams4);
    }
}
